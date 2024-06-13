package com.quiz.controller;


import com.quiz.entities.QuizEntity;
import com.quiz.service.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private QuizService service;

    private QuizController(QuizService service){
        this.service = service;
    }

    @PostMapping("/")
    public QuizEntity add(@RequestBody QuizEntity quiz){
        System.out.println(quiz.toString());
        return service.add(quiz);
    }

    @GetMapping("/{id}")
    public QuizEntity get(@PathVariable Long id){
        return service.get(id);
    }

    @GetMapping("/")
    public List<QuizEntity> getAll(){
        return service.getAll();
    }
}
