package com.demo.furnishhub.service;

import com.demo.furnishhub.entity.User;

public interface UserService {
    User getUser(Long id);
    User getUser(String username);
    User saveUser(User user);

}