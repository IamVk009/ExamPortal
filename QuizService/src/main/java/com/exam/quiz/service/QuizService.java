package com.exam.quiz.service;

import com.exam.quiz.entity.Quiz;

import java.util.List;

public interface QuizService {
    Quiz add(Quiz quiz);

    List<Quiz> getAllQuizzes();

    Quiz getQuizById(Long id);
}
