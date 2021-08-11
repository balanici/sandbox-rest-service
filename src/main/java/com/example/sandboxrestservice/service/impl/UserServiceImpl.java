package com.example.sandboxrestservice.service.impl;

import com.example.sandboxrestservice.model.User;
import com.example.sandboxrestservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> findAllUsers() {
        return listOfUsers();
    }

    @Override
    public User findUser(Long userId) {
        return listOfUsers().stream()
            .filter(user -> userId.equals(user.getId()))
            .findFirst()
            .orElseThrow();
    }

    @Override
    public User findUser(String username) {
        return listOfUsers().stream()
            .filter(user -> username.equals(user.getUsername()))
            .findFirst()
            .orElseThrow();
    }

    private List<User> listOfUsers() {
        return List.of(
            User.builder().id(1L).username("sofiabowler").firstName("Sofia").lastName("Bowler").build(),
            User.builder().id(2L).username("biancahooper").firstName("Bianca").lastName("Hooper").build(),
            User.builder().id(3L).username("sakinadorsey").firstName("Sakina").lastName("Dorsey").build(),
            User.builder().id(4L).username("shereenmyers").firstName("Shereen").lastName("Myers").build(),
            User.builder().id(5L).username("juniperduffy").firstName("Juniper").lastName("Duffy").build()
        );
    }
}
