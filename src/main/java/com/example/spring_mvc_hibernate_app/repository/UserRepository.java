package com.example.spring_mvc_hibernate_app.repository;

import com.example.spring_mvc_hibernate_app.entity.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
    User findById(Long id);
    void save(User user);
    void update(User user);
    void delete(Long id);
}
