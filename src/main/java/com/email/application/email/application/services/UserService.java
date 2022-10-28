package com.email.application.email.application.services;

import com.email.application.email.application.entity.User;
import com.email.application.email.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUser(int UserId){
        return userRepository.findById(UserId).get();
    }
}

