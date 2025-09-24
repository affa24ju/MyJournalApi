package com.MyJournal.MyJournalApi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

// DTO för att skicka användarinformation utan lösenord & andra känsliga data
@Data
@AllArgsConstructor
public class UserResponse {
    private String id;
    private String username;
}
