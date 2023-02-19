package com.example.catcher.migration;

import com.example.catcher.domain.Level;
import com.example.catcher.domain.User;
import com.example.catcher.repos.UserRepo;
import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import lombok.SneakyThrows;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import static com.example.catcher.domain.Role.*;

@ChangeLog(order = "0001")
public class AssignAdminsChangeLog {

    @SneakyThrows({ParseException.class})
    @ChangeSet(order = "01", author = "Kovalchuk_Roman", id = "2023-02-19 16:16")
    public void assignAdminsChangeSet(UserRepo userRepository) {
        userRepository.saveAll(new ArrayList<>(Arrays.asList(
                User.builder()
                        .login("admin_romanko03")
                        .password("gx901tirtx")
                        .name("Roman")
                        .birthday(new SimpleDateFormat("yyyy-MM-dd").parse("2003-01-09"))
                        .email("kovalchuk.roman03@gmail.com")
                        .phone("+380986378007")
                        .avatarName("4daf1e48-b2d3-4171-aa75-5db754b5b4e4.photo_2021-10-13_00-12-56.jpg")
                        .level(Level.A1)
                        .roles(Set.of(STUDENT, TEACHER, ADMIN)).build(),
                User.builder()
                        .login("admin_dudarko")
                        .password("meizum234")
                        .name("Serhii")
                        .birthday(new SimpleDateFormat("yyyy-MM-dd").parse("2003-03-21"))
                        .email("meizum234@gmail.com")
                        .phone("+380979765754")
                        .avatarName("0457f04f-7e4a-4b46-98ad-b32254666070.photo_2021-06-19_22-49-44.jpg")
                        .level(Level.A1)
                        .roles(Set.of(STUDENT, TEACHER, ADMIN)).build()
        )));
    }

}
