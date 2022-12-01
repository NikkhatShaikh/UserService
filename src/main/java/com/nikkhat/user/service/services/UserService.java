package com.nikkhat.user.service.services;

import com.nikkhat.user.service.entity.User;

import java.util.List;

public interface UserService {

    // user operations


    User saveUser (User user);

    List<User> getAllUser();


    //getSingle User by Id
    User getUser(String userId);

    //update user

    void deleteUser (String userId);



}
