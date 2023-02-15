package com.example.catcher.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Document(collection = "progress_word")
public class ProgressWord {

    @Id
    private String id;

    @DocumentReference
    @Field(name = "word_id")
    private Word word;

    @Field(name = "user_id")
    private String userId;

    @Field(name = "learned_date")
    private Date learnedDate;

    @Field(name = "last_revision_date")
    private Date lastRevisionDate;

    @Field(name = "revision_count")
    private Integer revisionCount;

    @Field(name = "guessing_count")
    private Integer guessingCount;

    @Field(name = "studied")
    private Boolean studied;

    private ProgressWord() {
        revisionCount = 0;
        guessingCount = 0;
        learnedDate = new Date();
        studied = false;
    }

    public ProgressWord(Word word) {
        this(word, new Date());
    }

    public ProgressWord(Word word, Date learnedDate) {
        this();
        this.word = word;
        this.learnedDate = learnedDate;
    }


}
