package com.ChatGptClone.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ChatGptClone.Model.User;
import com.ChatGptClone.Repository.UserRepository;

@Service
public class UserService {
	@Autowired
    private UserRepository userRepository;

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
}
