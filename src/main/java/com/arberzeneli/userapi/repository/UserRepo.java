package com.arberzeneli.userapi.repository;

import com.arberzeneli.userapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {

  User findUserByUserName(String name);
}
