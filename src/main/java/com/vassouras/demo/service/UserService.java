package com.vassouras.demo.service;

import com.vassouras.demo.model.User;
import com.vassouras.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<User> create(User original) {
        User user = userRepository.save(original);
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<List<User>> list() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    public ResponseEntity<User> findById(Long id) {
        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user);
    }

    public ResponseEntity<User> update(User original) {
        User user = userRepository.findById(original.getId()).orElse(null);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        user.setRegistration(original.getRegistration());
        user.setName(original.getName());
        user.setEmail(original.getEmail());
        user.setBirthDate(original.getBirthDate());
        user.setPhone(original.getPhone());

        user = userRepository.save(user);

        return ResponseEntity.ok(user);
    }

    public ResponseEntity<User> delete(Long id) {
        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        userRepository.delete(user);

        return ResponseEntity.ok(user);
    }
}
