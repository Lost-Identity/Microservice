package com.question.serviceimpl;


import com.question.entities.QuestionEntity;
import com.question.repository.QuestionRepo;
import com.question.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepo repo;

    private QuestionServiceImpl(QuestionRepo repo){
        this.repo = repo;
    }

    @Override
    public QuestionEntity add(QuestionEntity question) {
        return repo.save(question);
    }

    @Override
    public QuestionEntity get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Question not found"));
    }

    @Override
    public List<QuestionEntity> getAll() {
        return repo.findAll();
    }

    @Override
    public List<QuestionEntity> getQuestionsOfQuiz(Long quizId) {
        return repo.findByQuizId(quizId);
    }
}
