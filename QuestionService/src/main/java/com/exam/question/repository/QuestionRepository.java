package com.exam.question.repository;

import com.exam.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByQuizId(Long quizId); // Defining custom finder method to get Questions by using quizId.
}
