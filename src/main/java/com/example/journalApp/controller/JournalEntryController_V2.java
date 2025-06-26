package com.example.journalApp.controller;

import com.example.journalApp.entity.JournalEntry;
import com.example.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryController_V2 {

    @Autowired
    public JournalEntryService journalEntryService;

    @GetMapping()
    public List<JournalEntry> getAll() {
        return journalEntryService.getAll();
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry) {
        journalEntryService.saveEntry(myEntry);
        return true;
    }

    @GetMapping("/id/{myId}")
    public JournalEntry getJournalById(@PathVariable ObjectId myId) {
        return journalEntryService.findById(myId).orElse(null);
    }

    @DeleteMapping("/id/{myId}")
    public boolean deleteJournalById(@PathVariable ObjectId myId) {
        journalEntryService.deleteById(myId);
        return true;
    }

    @PutMapping("/id/{myId}")
    public JournalEntry updateJournalById(@PathVariable ObjectId myId, @RequestBody JournalEntry myEntry) {
        JournalEntry oldJournalEntry = journalEntryService.findById(myId).orElse(null);
        if (oldJournalEntry != null) {
            oldJournalEntry.setTitle(myEntry.getTitle() != null ? myEntry.getTitle() : oldJournalEntry.getTitle());
            oldJournalEntry.setContent(myEntry.getContent() != null ? myEntry.getContent() : oldJournalEntry.getContent());
        }
        journalEntryService.saveEntry(oldJournalEntry);
        return null;
    }
}
