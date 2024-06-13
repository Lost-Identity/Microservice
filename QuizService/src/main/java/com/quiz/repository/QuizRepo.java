package com.quiz.repository;

import com.quiz.entities.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface QuizRepo extends JpaRepository<QuizEntity, Long> {
}
