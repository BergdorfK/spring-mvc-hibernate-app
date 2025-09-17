package com.example.spring_mvc_hibernate_app.service;

import com.example.spring_mvc_hibernate_app.entity.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long id);

    void createUser(String name, String email);

    void updateUser(Long id, String name, String email);

    void deleteUser(Long id);
}