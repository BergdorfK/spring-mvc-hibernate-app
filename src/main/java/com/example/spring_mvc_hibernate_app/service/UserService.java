package com.example.spring_mvc_hibernate_app.service;

import com.example.spring_mvc_hibernate_app.entity.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    void saveUser(User user);
    void deleteUser(Long id);
}