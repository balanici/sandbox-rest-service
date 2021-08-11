package com.example.sandboxrestservice.service;

import com.example.sandboxrestservice.model.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    User findUser(Long userId);

    User findUser(String username);
}
