package com.example.catcher.repos;

import com.example.catcher.domain.CompletedTest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CompletedTestRepo extends MongoRepository<CompletedTest, String> {
    @Override
    List<CompletedTest> findAll();

    @Override
    Optional<CompletedTest> findById(String id);

    List<CompletedTest> findAllByUserId(String id);
}
