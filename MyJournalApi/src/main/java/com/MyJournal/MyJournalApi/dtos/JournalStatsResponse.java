package com.MyJournal.MyJournalApi.dtos;

import java.util.Map;

import com.MyJournal.MyJournalApi.models.Feeling;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JournalStatsResponse {

    private long totalEntries;
    private Map<Feeling, Long> feelingCounts;
    private Map<Feeling, Double> feelingPercentages;
}
