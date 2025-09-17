package com.example.spring_mvc_hibernate_app.service.impl;

import com.example.spring_mvc_hibernate_app.entity.User;
import com.example.spring_mvc_hibernate_app.repository.UserRepository;
import com.example.spring_mvc_hibernate_app.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public void createUser(String name, String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        repository.save(user);
    }

    @Override
    @Transactional
    public void updateUser(Long id, String name, String email) {
        User user = repository.findById(id);
        if (user == null) {
            throw new RuntimeException("User with id=" + id + " not found");
        }
        user.setName(name);
        user.setEmail(email);
        repository.update(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        repository.delete(id);
    }
}