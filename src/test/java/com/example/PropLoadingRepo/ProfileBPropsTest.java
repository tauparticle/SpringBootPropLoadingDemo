package com.example.PropLoadingRepo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles(profiles = "profileB")
@SpringBootTest
public class ProfileBPropsTest {

    @Autowired
    private Environment env;

    @Test
    public void Test() {
        assertEquals("test", env.getProperty("test.environment", String.class));
        assertEquals("test", env.getProperty("otherProp", String.class));
        assertEquals("testProp/test", env.getProperty("myTestProp", String.class));
    }

    @Configuration
    class TestConfig {}

}
