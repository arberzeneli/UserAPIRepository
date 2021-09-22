package com.arberzeneli.userapi.service;

import com.arberzeneli.userapi.model.User;
import com.arberzeneli.userapi.exeption.UserApiRequestException;
import com.arberzeneli.userapi.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;
    //@Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepo userRepo){
        this.userRepo=userRepo;
        this.passwordEncoder=new BCryptPasswordEncoder();

    }


    public List<User> getUsers() {
        return this.userRepo.findAll();
    }

    public User getUserByID(Long id){
        User userFound = userRepo.findById(id).orElse(new User(-1L,"","","",""));
        if (userFound.getUserId()!=-1){
            return userFound;
        }
        else {
            throw  new UserApiRequestException("User with id: " +id+ " is not found");
        }

    }

    public User getUserByUserName(String userName){
        User user =userRepo.findUserByUserName(userName);
        if (user.getUserId()==null){
            throw new UserApiRequestException("User not found");
        }
        return user;
    }

    public User addUser(User user)  {
        String encodedPassword=passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepo.save(user);
        return user;
    }

    public User updateUser(User user ) {
        Long userId=user.getUserId();
        User foundUser=userRepo.findById(
                userId).orElse(new User(-1L,"","","",""));
        if (foundUser.getUserId()!=-1){
            userRepo.save(user);
            return userRepo.getById(userId);
        }
        else {
            throw new UserApiRequestException("User not found.");
        }
    }

    public User deleteUser (User user ){
        userRepo.delete(user);
        return user;
    }

}
