package com.academy.quiz.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academy.quiz.entity.QuizEntity;
import com.academy.quiz.repository.QuizRespository;

@Service
public class QuizService {

	@Autowired
	private QuizRespository repository;
	
	@Transactional
	public Boolean createQuiz(QuizEntity entity) {
		try {
			repository.save(entity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public List<QuizEntity> getAllQuiz() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Transactional
	public QuizEntity getQuizResult(Integer id) {
		try {
			return repository.findById(id).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Transactional
	public List<QuizEntity> getActiveQuiz() {
		try {
			return repository.findAll().stream().filter(quiz -> 
				quiz.getStart().contains(new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
			).collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
