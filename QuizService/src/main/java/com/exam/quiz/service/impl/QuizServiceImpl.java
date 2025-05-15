package com.exam.quiz.service.impl;

import com.exam.quiz.entity.Quiz;
import com.exam.quiz.repository.QuizRepository;
import com.exam.quiz.service.QuestionClient;
import com.exam.quiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    private final QuestionClient questionClient;

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getAllQuizzes() {
        List<Quiz> quizzes = quizRepository.findAll();
        List<Quiz> quizList = quizzes.stream()
                .map(quiz -> {
                    quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
                    return quiz;
                }).toList();
        return quizList;
    }

    @Override
    public Quiz getQuizById(Long id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz with given Id does not exist."));
        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
        return quiz;
    }
}
