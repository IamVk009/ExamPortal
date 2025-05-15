package com.exam.question.service;

import com.exam.question.entity.Question;

import java.util.List;

public interface QuestionService {

    Question add(Question question);

    List<Question> getAllQuestions();

    Question getQuestionById(Long id);

    List<Question> getQuestionsOfQuiz(Long quizId);
}
