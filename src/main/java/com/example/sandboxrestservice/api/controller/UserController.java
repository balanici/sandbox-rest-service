package com.example.sandboxrestservice.api.controller;

import com.example.sandboxrestservice.model.User;
import com.example.sandboxrestservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(userService.findAllUsers());
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getByUsername(@PathVariable(name = "username") String username) {
        return ResponseEntity.ok().body(userService.findUser(username));
    }
}
