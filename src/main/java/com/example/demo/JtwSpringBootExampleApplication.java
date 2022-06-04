package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SpringBootApplication
public class JtwSpringBootExampleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JtwSpringBootExampleApplication.class, args);
    }

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        User u = new User();
        u.setEmail("mohit@gmail.com");
        u.setName("mohit");
        u.setPassword(passwordEncoder.encode("121"));
        u.setRole("ROLE_NORMAL");
        this.userService.save(u);

        User u1 = new User();
        u1.setEmail("rohit@gmail.com");
        u1.setName("ROHIt");
        u1.setPassword(passwordEncoder.encode("121"));
        u1.setRole("ROLE_ADMIN");
        this.userService.save(u1);
    }
}