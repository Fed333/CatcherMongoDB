package com.example.catcher.service;

import com.example.catcher.domain.CompletedTest;
import com.example.catcher.domain.TestQuestion;
import com.example.catcher.repos.CompletedTestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompletedTestService {

    @Autowired
    private CompletedTestRepo completedTestRepo;

    @Transactional(readOnly = true)
    public List<TestQuestion> getTestQuestion(CompletedTest completedTest){
        if (completedTest == null){
            return null;
        }
        List<TestQuestion> questions = completedTest.getQuestions();
        return questions;

    }

    public int getTotalTestScore(CompletedTest completedTest) {
        List<TestQuestion> tests = getTestQuestion(completedTest);
        int totalScore = 0;
        for (TestQuestion tq: tests) {
            totalScore += tq.getPoints();
        }
        return totalScore;
    }

    //повертає точність, число від 0 до 1
    public double getTestAccuracy(CompletedTest completedTest) {
        List<TestQuestion> list = getTestQuestion(completedTest);
        double accuracy = 0;
        for (TestQuestion tq: list) {
            accuracy += tq.getSimilarity();
        }
        accuracy = accuracy/(100*list.size());
        return accuracy;
    }
}
