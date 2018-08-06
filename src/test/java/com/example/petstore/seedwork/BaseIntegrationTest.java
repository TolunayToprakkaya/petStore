package com.example.petstore.seedwork;

import com.example.petstore.PetStoreApplication;
import com.example.petstore.config.TestApplicationContextInitializer;
import com.example.petstore.controllers.CategoryController;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@ActiveProfiles("integration")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = PetStoreApplication.class)
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
@ContextConfiguration(initializers = TestApplicationContextInitializer.class)
public class BaseIntegrationTest {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Getter @Setter private Gson gson = new Gson();

    @Autowired @Getter @Setter private Environment environment;

    @Autowired @Getter @Setter private TestRestTemplate testRestTemplate;

    @Getter @Setter private String port;

    @Before
    public void setup(){
        setPort(getEnvironment().getProperty("local.server.port"));
    }

}
