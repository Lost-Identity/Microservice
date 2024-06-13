package com.quiz.service;

import com.quiz.entities.QuizEntity;
import com.quiz.repository.QuizRepo;

import java.util.List;

public interface QuizService {

    QuizEntity add(QuizEntity quiz);

    QuizEntity get(Long id);

    List<QuizEntity> getAll();
}
