package com.example.petstore.services.impl;

import com.example.petstore.models.User;
import com.example.petstore.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.assertj.core.api.Assertions.*;


@RunWith(MockitoJUnitRunner.class)
public class UserServiceImpIntegrationTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userServiceImpl = new UserServiceImpl();

    //private List<User> users;

    private User user;

    @Before
    public void prepare(){
        user = new User();
        user.setId("059a9fe5-798a-4c72-a88a-39ca92512ee0");
        user.setUsername("hasanersoy");
        user.setFirstname("Hasan");
        user.setLastname("Ersoy");
        user.setEmail("hasanersoy@gmail.com");
        user.setPassword("he123");
        user.setPhone("92579731");
        /*
        users = new ArrayList<>();
        users.add(user);
        */
    }

    @Test
    public void noDataTest() throws Exception {
        List<User> users = userServiceImpl.findAll();

        assertThat(userServiceImpl.findAll()).isEmpty();
    }

    @Test
    public void findAllTest() throws Exception {
        List<User> users = userServiceImpl.findAll();
        users.add(user);

        assertThat(users.size(), is(1));
        assertThat(users.get(0).getId(), is("059a9fe5-798a-4c72-a88a-39ca92512ee0"));
        /*
        when(userRepository.findAll()).thenReturn(users);

        List<User> users = userServiceImpl.findAll();

        Assert.assertEquals(users.size(), 1);
        Assert.assertEquals(users.get(0).getId(), "059a9fe5-798a-4c72-a88a-39ca92512ee0");
        */
    }

    @Test
    public void findOneByIdTest() throws Exception {
        List<User> users = new ArrayList<User>();
        users.add(user);

        Optional<User> userOptional = userServiceImpl.findOneById("059a9fe5-798a-4c72-a88a-39ca92512ee0");

        assertThat(user).isEqualTo(user);
    }

    @Test
    public void saveTest() throws Exception {
        List<User> users = new ArrayList<User>();
        users.add(user);

        assertThat(users.size(), is(1));
        assertThat(users.get(0).getId(), is("059a9fe5-798a-4c72-a88a-39ca92512ee0"));
    }

    @Test
    public void deleteTest() throws Exception {
        List<User> users = new ArrayList<User>();
        users.add(user);

        userServiceImpl.delete("059a9fe5-798a-4c72-a88a-39ca92512ee0");

        assertThat(userServiceImpl.findAll()).isEmpty();
    }

}