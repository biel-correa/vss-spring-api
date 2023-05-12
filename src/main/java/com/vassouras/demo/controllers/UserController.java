package com.vassouras.demo.controllers;

import com.vassouras.demo.model.User;
import com.vassouras.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    private ResponseEntity<User> create(User user) {
        return userService.create(user);
    }

    @GetMapping
    private ResponseEntity<List<User>> list() {
        return userService.list();
    }

    @GetMapping("{id}")
    private ResponseEntity<User> findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PutMapping
    private ResponseEntity<User> update(User user) {
        return userService.update(user);
    }

    @DeleteMapping("{id}")
    private ResponseEntity<User> delete(@PathVariable Long id) {
        return userService.delete(id);
    }
}
