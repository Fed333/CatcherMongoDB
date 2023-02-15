package com.example.catcher.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
public class TestQuestion {

    public static final Integer maxPoints = 5;
    public static final Double acceptableSimilarity = 0.75;

    @Field(name = "question")
    private String question;

    @Field(name = "answer")
    private String answer;

    @Field(name="right_answer")
    private String rightAnswer;

    @Field(name = "points")
    private Integer points;

    @Field(name = "similarity")
    private Integer similarity;

    public TestQuestion() {
        points = 0;
        similarity = 0;
    }

    public TestQuestion(String question, String answer, String rightAnswer) {
        this();
        this.question = question;
        this.answer = answer;
        this.rightAnswer = rightAnswer;
    }

}
