package com.MyJournal.MyJournalApi.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyJournal.MyJournalApi.dtos.AuthRequest;
import com.MyJournal.MyJournalApi.services.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public String register(@RequestBody AuthRequest request) {
        return authenticationService.register(request.getUsername(), request.getPassword());
    }

}
