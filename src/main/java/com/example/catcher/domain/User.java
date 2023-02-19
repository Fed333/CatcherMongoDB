package com.example.catcher.domain;

import com.example.catcher.algorithms.Pair;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.*;

import static com.example.catcher.domain.Level.A1;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Document(collection = "users")
public class User implements UserDetails {

    @Serial
    private static final long serialVersionUID = 7802389881351271921L;

    @Id
    private String id;

    private String login;

    private String password;

    @Field(name="avatar_name")
    private String avatarName;

    private Set<Role> roles;

    private String name;

    private String phone;

    private String email;

    private Level level;

    private Integer score;

    @Field(name="date_of_birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @DocumentReference
    @Field(name = "completed_tests")
    private List<CompletedTest> completedTests;

    @DocumentReference
    private List<ProgressWord> vocabulary;

    @Transient
    private Map<Pair<String, String>, Integer> cache = new HashMap<>();

    public User() {
        level = A1;
        score = 0;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public List<Word> getWords() {
        List<Word> words = new LinkedList<>();
        vocabulary.forEach(pw -> words.add(pw.getWord()));
        return words;
    }

    public boolean isAdmin(){
        return getRoles().contains(Role.ADMIN);
    }

    public boolean isTeacher(){ return getRoles().contains(Role.TEACHER); }

    public boolean isStudent(){return getRoles().contains(Role.STUDENT);}

}
