package com.email.application.email.application.repository;

import com.email.application.email.application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByEmail(String fromUser);
}
