package com.giuseppe.expensetracker.service;

import com.giuseppe.expensetracker.entity.User;
import com.giuseppe.expensetracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Optional<User> findUserById(Long id){
        return userRepository.findById(id);
    }
}
