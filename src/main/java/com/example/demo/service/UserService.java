package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void save(User user) {
        this.userRepo.save(user);
    }

    public void delete(String email) {
        this.userRepo.deleteById(email);
    }

    public void update(User user) {
        this.userRepo.save(user);
    }

    public List<User> getAllUser() {
        return this.userRepo.findAll();
    }

    public User getUser(String email) {
       Optional<User> user = this.userRepo.findById(email);
        return user.get();
    }
}
