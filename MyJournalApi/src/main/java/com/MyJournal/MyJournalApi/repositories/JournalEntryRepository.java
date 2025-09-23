package com.MyJournal.MyJournalApi.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.MyJournal.MyJournalApi.models.JournalEntry;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, String> {

    List<JournalEntry> findByUserId(String userId);
    // Custom query methods can be defined here if needed

}
