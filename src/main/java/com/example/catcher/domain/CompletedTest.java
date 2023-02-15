package com.example.catcher.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Document(collection = "completed_tests")
public class CompletedTest {

    @Id
    private String id;

    @Field(name = "user_id")
    private String userId;

//    @ReadOnlyProperty
//    @DocumentReference(lazy = true)
//    private User user;

    @Field(name = "taking_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date takingTime;

    private Integer score;

    private List<TestQuestion> questions;

    public CompletedTest(){
        takingTime = new Date();
    }

}
