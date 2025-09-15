package com.example.spring_mvc_hibernate_app.service.impl;

import com.example.spring_mvc_hibernate_app.entity.User;
import com.example.spring_mvc_hibernate_app.repository.UserRepository;
import com.example.spring_mvc_hibernate_app.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
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
    public void saveUser(User user) {
        repository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        repository.delete(id);
    }
}