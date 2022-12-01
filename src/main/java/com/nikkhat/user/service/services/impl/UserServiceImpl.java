package com.nikkhat.user.service.services.impl;

import com.nikkhat.user.service.entity.User;
import com.nikkhat.user.service.exceptions.ResourceNotFoundException;
import com.nikkhat.user.service.repository.UserRepository;
import com.nikkhat.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
   private UserRepository userRepository;


    @Override
    public User saveUser(User user) {

       String randomUserId= UUID.randomUUID().toString();   // generate unique Userid
       user.setUserId(randomUserId);
        return this.userRepository.save(user);
    }


    @Override
    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        return this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException(" user With Given Id is not found On Server !!  given User Id :"+userId));
    }

    @Override
    public void deleteUser(String userId) {

    }
}
