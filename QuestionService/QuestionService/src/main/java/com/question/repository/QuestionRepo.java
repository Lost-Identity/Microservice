package com.question.repository;

import com.question.entities.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepo extends JpaRepository<QuestionEntity, Long> {

    List<QuestionEntity> findByQuizId(Long quizId);
}
