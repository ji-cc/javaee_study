package com.example.springboot1.config;

import com.example.springboot1.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {
    @Bean
    public Map<Integer,Integer> test1() {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,100);
        map.put(2,200);
        return map;
    }
    @Bean
    public Map<Integer,Integer> test2() {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(3,300);
        map.put(4,400);
        return map;
    }

    @Bean
    public User user1() {
        User user = new User();
        user.setUsername("cc");
        user.setPassword("123");
        return user;
    }

}
