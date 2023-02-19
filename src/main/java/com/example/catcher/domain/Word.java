package com.example.catcher.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Comparator;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="dictionary")
public class Word {

    @Id
    private String id;

    private String translation;

    private String word;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;
        Word word1 = (Word) o;
        return Objects.equals(id, word1.id) &&
                Objects.equals(word, word1.word) &&
                Objects.equals(translation, word1.translation) &&
                level == word1.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, word, translation, level);
    }


    @Override
    public String toString() {
        return String.format("%20s, %20s, %3s", word, translation, level);
    }
}


