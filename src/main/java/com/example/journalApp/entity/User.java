package com.example.journalApp.entity;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@Data
public class User {

    @Id
    public ObjectId id;

    @Indexed(unique = true)
    @NonNull
    public String username;

    @NonNull
    public String password;

    @DBRef
    public List<JournalEntry> journalEntries = new ArrayList<JournalEntry>();
}
