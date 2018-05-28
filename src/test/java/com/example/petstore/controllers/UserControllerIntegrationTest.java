package com.example.petstore.controllers;

import com.example.petstore.controllers.UserController;
import com.example.petstore.models.User;
import com.example.petstore.services.UserService;
import org.assertj.core.util.Lists;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
@WebMvcTest(UserController.class)
public class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Qualifier("userService")
    @MockBean
    private UserService userService;

    @Test
    public void UserControllerTest() throws Exception {
        User user = new User();
        user.setUsername("canavar");
        user.setFirstname("Can");
        user.setLastname("Avar");
        user.setEmail("canavar@gmail.com");
        user.setPassword("ca123");
        user.setPhone("05486241");
        user.setStatus(1);
        List<User> users = Lists.newArrayList();
        users.add(user);

        given(this.userService.findAll())
                .willReturn(users);
        this.mockMvc.perform(get("/users").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk());
    }

}