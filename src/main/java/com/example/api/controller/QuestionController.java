package com.example.api.controller;

import com.example.api.dao.QuestionRepository;
import com.example.api.model.Question;
import com.example.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:19006")
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/questions")
    public List<Question> getQuestions() {
        return questionRepository.findAll();
    }
    @GetMapping("/questions/{id}")
    public Question getQuestion(@PathVariable Long id) {
        Optional<Question> question = questionRepository.findById(id);
        if (question.isPresent())
            return question.get();
        return null;
    }

    @PostMapping("/questions")
    public Question saveQuestion(@RequestBody Question question) {
        return questionRepository.save(question);
    }

    @DeleteMapping("/questions/{id}")
    public void delQuestion(@PathVariable Long id) {

        Optional<Question> question = questionRepository.findById(id);

        if (question.isPresent()) {
            questionRepository.delete(question.get());
        }
    }
    @PutMapping("/questions/{id}")
    public Question updateQuestion(@PathVariable Long id, @RequestBody Question question) {
        question.setId(id);
        return questionRepository.save(question);
    }

}
