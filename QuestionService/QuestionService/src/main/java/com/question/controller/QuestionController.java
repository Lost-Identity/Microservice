package com.question.controller;


import com.question.entities.QuestionEntity;
import com.question.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private QuestionService service;

    private QuestionController(QuestionService service){
        this.service = service;
    }

    @PostMapping("/")
    public QuestionEntity add(@RequestBody QuestionEntity question){
        return service.add(question);
    }

    @GetMapping("/{id}")
    public QuestionEntity get(@PathVariable Long id){
        return service.get(id);
    }

    @GetMapping("/")
    public List<QuestionEntity> getAll(){
        return service.getAll();
    }

    // Get all question of specific quiz
    @GetMapping("/quiz/{quizId}")
    public List<QuestionEntity> getQuestionsOfQuiz(@PathVariable Long quizId){
        return service.getQuestionsOfQuiz(quizId);
    }

}
