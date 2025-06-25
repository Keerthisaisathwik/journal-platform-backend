package com.sathwik.journalApp.controller;

import com.sathwik.journalApp.entity.JournalEntry;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

import java.util.HashMap;

@RestController
@RequestMapping("/journal")
public class JouranalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry) {
        journalEntries.put(myEntry.getId(), myEntry);
        return true;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myId){
        return journalEntries.get(myId);
    }

    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable Long myId){
        return journalEntries.remove(myId);
    }

    //Did this method on my own
    @PutMapping("id/{myId}")
    public JournalEntry updateJournalEntryById(@PathVariable Long myId, @RequestBody JournalEntry myEntry){
        if(journalEntries.containsKey(myId)){
            journalEntries.put(myId, myEntry);
            //Here when I do "return journalEntries.put(myId, myEntry);" I am getting previous value as output so
            return journalEntries.get(myId);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Journal entry not found");
        }
    }
}
