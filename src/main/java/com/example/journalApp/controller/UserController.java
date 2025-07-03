package com.example.journalApp.controller;

import com.example.journalApp.entity.JournalEntry;
import com.example.journalApp.entity.User;
import com.example.journalApp.repository.UserRepository;
import com.example.journalApp.service.JournalEntryService;
import com.example.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @PostMapping
    public boolean createUser(@RequestBody User user){
        userService.saveEntry(user);
        return true;
    }

    @PutMapping("/{username}")
    public User updateUser(@RequestBody User user, @PathVariable String username){
        User userDb = userRepository.findByusername(username);
        if(userDb != null){
            userDb.setUsername(user.getUsername());
            userDb.setPassword(user.getPassword());
            userService.saveEntry(userDb);
        }
        return userDb;
    }
}
