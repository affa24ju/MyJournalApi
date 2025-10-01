package com.MyJournal.MyJournalApi.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.MyJournal.MyJournalApi.dtos.JournalStatsResponse;
import com.MyJournal.MyJournalApi.models.Feeling;
import com.MyJournal.MyJournalApi.models.JournalEntry;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JournalStatsService {

    // private final JournalEntryService journalEntryService;

    // Metod för att hämta statistik
    public JournalStatsResponse getStats(List<JournalEntry> entries) {
        long totalEntries = entries.size();
        Map<Feeling, Long> feelingCounts = entries.stream()
                .collect(Collectors.groupingBy(JournalEntry::getFeeling, Collectors.counting()));

        // Räkna ut procent för varje känsla
        Map<Feeling, Double> feelingPercentages = feelingCounts.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        e -> (totalEntries == 0) ? 0.0 : (e.getValue() * 100.0 / totalEntries)));

        return JournalStatsResponse.builder()
                .totalEntries(totalEntries)
                .feelingCounts(feelingCounts)
                .feelingPercentages(feelingPercentages)
                .build();

    }

}
