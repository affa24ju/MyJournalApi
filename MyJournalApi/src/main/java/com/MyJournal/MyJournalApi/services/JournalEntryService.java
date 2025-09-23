package com.MyJournal.MyJournalApi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.MyJournal.MyJournalApi.models.JournalEntry;
import com.MyJournal.MyJournalApi.repositories.JournalEntryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JournalEntryService {

    private final JournalEntryRepository journalEntryRepository;

    // Metod för att skapa en journalpost
    public JournalEntry createJournalEntry() {

        return null; // Placeholder return

    }

    // Metod för att hämta alla journalposter för en användare
    public List<JournalEntry> getAllJournalEntriesForUser(String userId) {
        return journalEntryRepository.findAll(); // Placeholder return
    }

    // Metod för att visa statistik för en tidperiod
    public List<JournalEntry> getJournalEntriesByDateReange() {
        return journalEntryRepository.findAll(); // Placeholder return
    }

}
