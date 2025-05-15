package com.exam.quiz.controller;

import com.exam.quiz.entity.Quiz;
import com.exam.quiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/quiz")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @PostMapping("/add")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz) {
        Quiz newQuiz = quizService.add(quiz);

//        URI location = URI.create("/api/v1/quiz" + newQuiz.getId());
//        return ResponseEntity.created(location).body(newQuiz);

        ResponseEntity<Quiz> quizResponseEntity = new ResponseEntity<>(newQuiz, HttpStatus.CREATED);
        return quizResponseEntity;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        return ResponseEntity.ok(quizService.getAllQuizzes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Long id) {
        return ResponseEntity.ok(quizService.getQuizById(id));
    }
}
