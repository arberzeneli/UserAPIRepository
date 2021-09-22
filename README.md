# UserAPIRepository
user api using java spring boot

This is a simple API that has CRUD operations using Java Spring Boot and MS SQL Server for the database. IDE used for this project is IntelliJ 

To deploy the project, first you need to configure the file aplication.properties file.If you use MSSQL, just change the part for User logins in SQL. If you use another database you should set the configuration for that particular db and also add dependencies.After that, run the SQL Script (sql_script.sql) in the parent folder of the project, to create a database and insert a user in order to test the api, or create one using httprequests.
Also set proper path for the log file. For the demonstration purpose, entities have some basic fields (like username,pasw,fname,name etc).
For the authentication I have used basic authentication. Passwords are encrypted using Bcrypt.






 
