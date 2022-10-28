package com.email.application.email.application.services;

import com.email.application.email.application.entity.Email;
import com.email.application.email.application.entity.User;
import com.email.application.email.application.repository.EmailRepository;
import com.email.application.email.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private UserRepository userRepository;

    public Email createEmail(Email email){
        User user = userRepository.findByEmail(email.getFromUser());
        email.setUser(user);
        return emailRepository.save(email);
    }



}
