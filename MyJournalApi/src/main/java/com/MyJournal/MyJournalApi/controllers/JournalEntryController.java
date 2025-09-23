package com.MyJournal.MyJournalApi.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MyJournal.MyJournalApi.dtos.JournalEntryRequest;
import com.MyJournal.MyJournalApi.dtos.JournalStatsResponse;
import com.MyJournal.MyJournalApi.models.JournalEntry;
import com.MyJournal.MyJournalApi.models.User;
import com.MyJournal.MyJournalApi.services.JournalEntryService;
import com.MyJournal.MyJournalApi.services.JournalStatsService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/myJournal")
@RequiredArgsConstructor
public class JournalEntryController {

    private final JournalEntryService journalEntryService;
    private final JournalStatsService journalStatsService;

    @PostMapping("/createJournalEntry")
    public JournalEntry createJournalEntry(@RequestBody JournalEntryRequest request) {
        User dummyUser = new User();
        dummyUser.setId("dummyUser123"); // Replace with actual user ID retrieval logic
        return journalEntryService.createJournalEntry(dummyUser, request);
    }

    @GetMapping("/getEntries")
    public List<JournalEntry> getEntries() {
        User dummyUser = new User();
        dummyUser.setId("dummyUser123"); // Replace with actual user ID retrieval logic
        return journalEntryService.getEntries(dummyUser);
    }

    @GetMapping("/getStats")
    public JournalStatsResponse getStats(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        User dummyUser = new User();
        dummyUser.setId("dummyUser123"); // Replace with actual user ID retrieval logic
        List<JournalEntry> entries = journalEntryService.getJournalEntriesByDateRange(dummyUser, startDate, endDate);

        return journalStatsService.getStats(entries);

    }

}
