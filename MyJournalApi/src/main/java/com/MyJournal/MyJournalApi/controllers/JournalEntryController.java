package com.MyJournal.MyJournalApi.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyJournal.MyJournalApi.dtos.JournalEntryRequest;
import com.MyJournal.MyJournalApi.models.JournalEntry;
import com.MyJournal.MyJournalApi.models.User;
import com.MyJournal.MyJournalApi.services.JournalEntryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/myJournal")
@RequiredArgsConstructor
public class JournalEntryController {

    private final JournalEntryService journalEntryService;

    @PostMapping("/createJournalEntry")
    public JournalEntry createJournalEntry(@RequestBody JournalEntryRequest request) {
        User dummyUser = new User();
        dummyUser.setId("dummyUser123"); // Replace with actual user ID retrieval logic
        return journalEntryService.createJournalEntry(dummyUser, request);
    }

}
