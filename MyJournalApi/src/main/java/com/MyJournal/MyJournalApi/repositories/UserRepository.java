package com.MyJournal.MyJournalApi.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.MyJournal.MyJournalApi.models.User;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);

}
