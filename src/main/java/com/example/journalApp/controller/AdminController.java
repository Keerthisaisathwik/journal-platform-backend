package com.example.journalApp.controller;

import com.example.journalApp.entity.JournalEntry;
import com.example.journalApp.entity.User;
import com.example.journalApp.service.JournalEntryService;
import com.example.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping("/all-users")
    public ResponseEntity<?> getAllUsers() {
        List<User> all = userService.getAll();
        if (all == null || all.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(all, HttpStatus.OK);
    }

    @GetMapping("/all-journals")
    public ResponseEntity<?> getAllJournals() {
        List<JournalEntry> all = journalEntryService.getAll();
        if(all == null || all.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @PostMapping("/create-admin-user")
    public ResponseEntity<Boolean> createAdminUser(@RequestBody User user){
        userService.createAdmin(user);
        return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
    }
}
