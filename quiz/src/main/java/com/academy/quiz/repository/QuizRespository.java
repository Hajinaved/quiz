package com.academy.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.academy.quiz.entity.QuizEntity;

@Repository
public interface QuizRespository extends JpaRepository<QuizEntity, Integer> {

}
