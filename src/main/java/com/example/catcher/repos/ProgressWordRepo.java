package com.example.catcher.repos;

import com.example.catcher.domain.ProgressWord;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProgressWordRepo extends MongoRepository<ProgressWord, String> {
    @Override
    List<ProgressWord> findAll();
    @Override
    Optional<ProgressWord> findById(String id);

    Optional<List<ProgressWord>> findByUserId(String id);

}
