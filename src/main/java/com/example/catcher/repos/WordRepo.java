package com.example.catcher.repos;

import com.example.catcher.domain.Word;
import org.springframework.data.repository.CrudRepository;

public interface WordRepo extends CrudRepository<Word, String> {
    Word findByWord(String word);
    Word findByTranslation(String translation);
}
