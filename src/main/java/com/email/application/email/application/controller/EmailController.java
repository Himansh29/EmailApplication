package com.email.application.email.application.controller;

import com.email.application.email.application.entity.Email;
import com.email.application.email.application.services.EmailService;
import com.email.application.email.application.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    @Autowired
    UserService userService;

    @PostMapping("/email/")
    public Email CreateEmail(@RequestBody Email email){
        return emailService.createEmail(email);
    }

    @GetMapping("/emails/count/{userId}")
    public int emailCount(@PathVariable("userId") int userId){
        return userService.getUser(userId).getEmails().size();
    }
}
