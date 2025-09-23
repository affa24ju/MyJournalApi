package com.MyJournal.MyJournalApi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.MyJournal.MyJournalApi.dtos.JournalEntryRequest;
import com.MyJournal.MyJournalApi.models.JournalEntry;
import com.MyJournal.MyJournalApi.repositories.JournalEntryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JournalEntryService {

    private final JournalEntryRepository journalEntryRepository;

    // Metod för att skapa en journalpost
    public JournalEntry createJournalEntry(JournalEntryRequest request) {
        JournalEntry newEntry = JournalEntry.builder()
                .note(request.getNote())
                .feeling(request.getFeeling())
                .createdAt(request.getCreatedAt())
                .build();

        return journalEntryRepository.save(newEntry); 

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
