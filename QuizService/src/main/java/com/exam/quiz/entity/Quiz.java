package com.exam.quiz.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Let the database auto-generate the primary key using its auto-increment feature.
    private Long id;
    private String title;

    transient private List<Question> questions; // questions is something we don’t want to store in the DB, and it’s populated from another service, So marking it as transient. JPA will not map it to any column or join table.
}
