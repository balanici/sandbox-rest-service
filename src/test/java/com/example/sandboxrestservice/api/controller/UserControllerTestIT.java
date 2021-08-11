package com.example.sandboxrestservice.api.controller;

import com.example.sandboxrestservice.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTestIT {

    private final String USERS_URL = "/users";

    private final String USERNAME_DUFFY = "juniperduffy";

    private final User USER_JUNIPER_DUFFY = User.builder()
        .id(5L)
        .username("juniperduffy")
        .firstName("Juniper")
        .lastName("Duffy")
        .build();

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllUsers() throws Exception {
        this.mockMvc.perform(get(USERS_URL))
            .andDo(print())
            .andExpect(status().isOk())
        ;

    }

    @Test
    void getByUsername() throws Exception {
        this.mockMvc.perform(get(USERS_URL + "/" + USERNAME_DUFFY))
            .andDo(print())
            .andExpect(status().isOk())
        ;
    }

    //find here next:
    //https://www.infoworld.com/article/3543268/junit-5-tutorial-part-2-unit-testing-spring-mvc-with-junit-5.html?page=3
}