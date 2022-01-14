package com.example.PropLoadingRepo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles(profiles = {"profileA", "profileB"})
@SpringBootTest
public class ProfileABPropsTest {

    @Autowired
    private Environment env;

    @Test
    public void Test() {
        assertEquals("prod", env.getProperty("test.environment", String.class));
        assertEquals("prod", env.getProperty("otherProp", String.class));
        assertEquals("testProp/prod", env.getProperty("myTestProp", String.class));
    }

    @Configuration
    class TestConfig {}

}
