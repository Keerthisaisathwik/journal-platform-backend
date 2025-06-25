//package com.example.journalApp.controller;
//
//import com.example.journalApp.entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.*;
//
//@RestController
//@RequestMapping("/journal")
//public class JournalEntryController {
//    private Map<Long, JournalEntry> journalEntry = new HashMap<>();
//
//    @GetMapping
//    public List<JournalEntry> getAll(){
//        return new ArrayList<>(journalEntry.values());
//    }
//
//    @PostMapping
//    public JournalEntry createEntry(@RequestBody JournalEntry myEntry){
//        return journalEntry.put(myEntry.getId(), myEntry);
//    }
//
//    @GetMapping("/id/{myId}")
//    public JournalEntry getJournalById(@PathVariable Long myId){
//        return journalEntry.get(myId);
//    }
//
//    @DeleteMapping("/id/{myId}")
//    public JournalEntry deleteJournalById(@PathVariable Long myId){
//        return journalEntry.remove(myId);
//    }
//
//    @PutMapping("/id/{myId}")
//    public JournalEntry updateJournalById(@PathVariable Long myId, @RequestBody JournalEntry myEntry){
//        return journalEntry.put(myId, myEntry);
//    }
//}
