package com.MyJournal.MyJournalApi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.MyJournal.MyJournalApi.models.JournalEntry;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, String> {
    // Custom query methods can be defined here if needed

}
