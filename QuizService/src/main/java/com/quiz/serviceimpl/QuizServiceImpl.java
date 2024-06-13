package com.quiz.serviceimpl;

import com.quiz.entities.QuizEntity;
import com.quiz.repository.QuizRepo;
import com.quiz.service.QuestionClient;
import com.quiz.service.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    private QuizRepo repo;

    private QuestionClient questionClient;

    public QuizServiceImpl(QuizRepo repo, QuestionClient questionClient) {
        this.repo = repo;
        this.questionClient = questionClient;
    }

    @Override
    public QuizEntity add(QuizEntity quiz) {
        System.out.println(quiz.getName());
        return repo.save(quiz);
    }

    @Override
    public QuizEntity get(Long id) {

        QuizEntity quiz = repo.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
        quiz.setQuestion(questionClient.getQuestionsOfQuiz(quiz.getId()));
        return quiz;
    }

    @Override
    public List<QuizEntity> getAll() {
        List<QuizEntity> quizes = repo.findAll();
        List<QuizEntity> newQuizList = quizes.stream().map(quiz -> {
            quiz.setQuestion(questionClient.getQuestionsOfQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
        return newQuizList;
    }
}
