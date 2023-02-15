package com.example.catcher.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Comparator;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="dictionary")
public class Word {

    @Id
    private String id;

    private String word;

    private String translation;

    private Level level;

    private String imgName;

    public Word(String word, String translation) {
        this.word = word;
        this.translation = translation;
    }

    public enum Criterion{
        WORD, TRANSLATION, LEVEL
    }

    public static class TranslationComparator implements Comparator<Word> {
        @Override
        public int compare(Word o1, Word o2) {
            return o1.getTranslation().compareTo(o2.getTranslation());
        }
    }

    public static class WordComparator implements Comparator<Word> {
        @Override
        public int compare(Word o1, Word o2) {
            return o1.getWord().compareTo(o2.getWord());
        }
    }

    @Override
    public String toString() {
        return String.format("%20s, %20s, %3s", word, translation, level);
    }
}


