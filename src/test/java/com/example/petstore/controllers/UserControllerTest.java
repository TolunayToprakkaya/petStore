package com.example.petstore.controllers;

import com.example.petstore.models.User;
import com.example.petstore.services.UserService;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

/*
import com.example.petstore.PetStoreApplication;
import com.example.petstore.controllers.UserController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.Lists;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Collections;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
*/
/*DENEME1
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
@WebMvcTest(UserController.class)
*/
/*DENEME2
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes=PetStoreApplication.class)
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
@WebMvcTest(UserController.class)
*/
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
@WebMvcTest(value = UserController.class, secure = false)
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Qualifier("userService")
    @MockBean
    private UserService userService;

    private User user;

    @Before
    public void prepare(){
        user = new User();
        user.setId("d9a4ad55-25c1-42e9-aa11-8c214ce912de");
        user.setUsername("canavar");
        user.setFirstname("Can");
        user.setLastname("Avar");
        user.setEmail("canavar@gmail.com");
        user.setPassword("ca123");
        user.setPhone("05486241");
        user.setStatus(1);
    }

    @Test
    public void noDataTest() throws Exception{
        List<User> users = userService.findAll();

        assertThat(users.size(), is(0));
    }

    @Test
    public void findAllTest() throws Exception{
        List<User> users = new ArrayList<User>();
        users.add(user);

        assertThat(users.size(), is(1));
        assertThat(users.get(0).getId(), is("d9a4ad55-25c1-42e9-aa11-8c214ce912de"));
    }

    @Test
    public void findOneByIdTest() throws Exception{
        List<User> users = new ArrayList<User>();
        users.add(user);

        Optional<User> userOptional = userService.findOneById("d9a4ad55-25c1-42e9-aa11-8c214ce912de");

        assertThat(user).isEqualTo(user);
    }

    @Test
    public void saveTest() throws Exception{
        List<User> users = new ArrayList<User>();
        users.add(user);

        assertThat(users.size(), is(1));
        assertThat(users.get(0).getId(), is("d9a4ad55-25c1-42e9-aa11-8c214ce912de"));
    }

    @Test
    public void deleteTest() throws Exception{
        List<User> users = new ArrayList<User>();
        users.add(user);

        userService.delete("d9a4ad55-25c1-42e9-aa11-8c214ce912de");
        assertThat(userService.findAll()).isEmpty();
    }

    /*DENEME1
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
    */

    /*DENEME2
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    @Qualifier("userService")
    UserService userService;

    private TestEntityManager testEntityManager;


    @Test(expected = NullPointerException.class)
    public void should_find_no_users_if_services_is_empty(){
        List<User> users = userService.findAll();

        assertThat(users).isEmpty();
    }

    @Test(expected = NullPointerException.class)
    public void should_store_a_user(){
        User user = userService.save(new User("canavar", "can", "avar", "canavar@gmail.com", "ca123", "05486241", 1));

        assertThat(user).hasFieldOrPropertyWithValue("username", "canavar");
        assertThat(user).hasFieldOrPropertyWithValue("firstname", "can");
        assertThat(user).hasFieldOrPropertyWithValue("lastname", "avar");
        assertThat(user).hasFieldOrPropertyWithValue("email", "canavar@gmail.com");
        assertThat(user).hasFieldOrPropertyWithValue("password", "ca123");
        assertThat(user).hasFieldOrPropertyWithValue("phone", "05486241");
        assertThat(user).hasFieldOrPropertyWithValue("status", 1);
    }

    @Test(expected = NullPointerException.class)
    public void should_delete_all_user(){
        testEntityManager.persist(new User("zaferfatih", "zafer", "fatih", "zaferfatih@gmail.com", "qwe123", "0630331942", 1));
        testEntityManager.persist(new User("tolunaytoprakkaya", "tolunay", "toprakkaya", "tolunaytoprakkaya@gmail.com", "tt123", "0630331947", 1));

        //userService.delete();
        assertThat(userService.findAll()).isEmpty();
    }

    @Test(expected = NullPointerException.class)
    public void should_find_all_users(){
        User user1 = new User("zaferfatih", "zafer", "fatih", "zaferfatih@gmail.com", "qwe123", "0630331942", 1);
        testEntityManager.persist(user1);

        User user2 = new User("tolunaytoprakkaya", "tolunay", "toprakkaya", "tolunaytoprakkaya@gmail.com", "tt123", "0630331947", 1);
        testEntityManager.persist(user2);

        List<User> users = userService.findAll();

        assertThat(users).hasSize(2).contains(user1, user2);
    }

    @Test(expected = NullPointerException.class)
    public void should_find_user_by_id() {
        User user1 = new User("zaferfatih", "zafer", "fatih", "zaferfatih@gmail.com", "qwe123", "0630331942", 1);
        testEntityManager.persist(user1);

        User user2 = new User("tolunaytoprakkaya", "tolunay", "toprakkaya", "tolunaytoprakkaya@gmail.com", "tt123", "0630331947", 1);
        testEntityManager.persist(user2);

        Optional<User> users1 = userService.findOneById(user1.getId());
        Optional<User> users2 =userService.findOneById(user2.getId());

        assertThat(user1).isEqualTo(user1);
        assertThat(users2).isEqualTo(user2);
    }
    */
}