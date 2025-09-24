package com.MyJournal.MyJournalApi.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.MyJournal.MyJournalApi.models.User;
import com.MyJournal.MyJournalApi.repositories.UserRepository;
import com.MyJournal.MyJournalApi.security.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    // Registrerar en ny användare och returnerar en JWT-token
    public String register(String username, String password) {
        // Kontrollera om användarnamnet redan finns
        if (userRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }

        // Skapa och spara ny användare
        User user = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .build();

        userRepository.save(user);

        // Generera JWT-token för den nya användaren
        return jwtService.generateToken(username);
    }

    // Autentiserar en användare och returnerar en JWT-token
    public String authenticate(String username, String password) {
        // Autentisera användaren (validera användarnamn och lösenord)
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));

        // Kontrollera om användaren finns i databasen
        if (!userRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("Invalid username or password");
        }
        // Generera och returnera JWT-token om autentiseringen lyckas
        return jwtService.generateToken(username);
    }

}
