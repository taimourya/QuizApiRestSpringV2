package com.example.api.controller;

import com.example.api.dao.UserRepository;
import com.example.api.model.LoginForm;
import com.example.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:19006")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent())
            return user.get();
        return null;
    }

    @CrossOrigin(origins = "http://localhost:19006")
    @PostMapping("/users")
    public User saveUser(@RequestBody User user) throws Exception{
        if(userRepository.findUserByUsername(user.getUsername()) != null)
            throw new Exception("username existant");
        return userRepository.save(user);
    }

    @CrossOrigin(origins = "http://localhost:19006")
    @PostMapping(value = "/authentification")
    public User authentification(@RequestBody LoginForm loginForm) throws Exception{
        User user = userRepository.findUserByEmailAndPassword(loginForm.getUsername(), loginForm.getPassword());
        if(user == null)
            throw new Exception("username or password incorrect");
        return user;
    }

    @DeleteMapping("/users/{id}")
    public void delUser(@PathVariable Long id) throws Exception{
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
        }
        else {
            throw new Exception("utilisateur introuvable");
        }
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) throws Exception {
        Optional<User> userV = userRepository.findById(id);
        if (userV.isEmpty()) {
            throw new Exception("utilisateur introuvable");
        }
        user.setId(id);
        return userRepository.save(user);
    }
}
