package com.zoiworks.basketballfantasy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.zoiworks.basketballfantasy.util.EnvLoader;

@SpringBootTest(classes = BasketballFantasyApplication.class)
class BasketballFantasyApplicationTests {

    @SuppressWarnings("unused")
    @BeforeAll
    static void loadEnv() {
        EnvLoader.load();
    }

    @Test
    void contextLoads() {
        // απλό test για το Spring context
    }
}
