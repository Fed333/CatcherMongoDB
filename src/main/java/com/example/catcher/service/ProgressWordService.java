package com.example.catcher.service;

import com.example.catcher.domain.ProgressWord;
import com.example.catcher.domain.Word;
import com.example.catcher.repos.ProgressWordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgressWordService {
    @Autowired
    private ProgressWordRepo progressWordRepo;

    public LinkedList<String> extractWordsId(List<ProgressWord> vocabulary) {

        LinkedList<String> wordsId = new LinkedList<>();
        vocabulary.forEach(pw->{
            wordsId.add(pw.getWord().getId());
        });
        return wordsId;
    }

}
