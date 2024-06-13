package com.question.service;

import com.question.entities.QuestionEntity;

import java.util.List;

public interface QuestionService {

    QuestionEntity add(QuestionEntity question);

    QuestionEntity get(Long id);

    List<QuestionEntity> getAll();

    List<QuestionEntity> getQuestionsOfQuiz(Long quizId);
}
