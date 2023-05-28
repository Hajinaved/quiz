package com.academy.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academy.quiz.entity.QuizEntity;
import com.academy.quiz.service.QuizService;

@RestController
@RequestMapping("/api")
public class QuizController {

	@Autowired
	private QuizService service;
	
	@PostMapping("/quizzes")
	public ResponseEntity<String> createNewQuiz(@RequestBody QuizEntity request) {
		try {
			if(service.createQuiz(request)) {
				return new ResponseEntity<String>("Success", HttpStatus.CREATED);
			} else {
				return new ResponseEntity<String>("Failure", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {			
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/quizzes/all")
	public ResponseEntity<List<QuizEntity>> retrieveAllQuiz() {
		try {
			return new ResponseEntity<List<QuizEntity>>(service.getAllQuiz(), HttpStatus.OK);
		} catch (Exception e) {			
			return new ResponseEntity<List<QuizEntity>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/quizzes/{id}/result")
	public ResponseEntity<QuizEntity> retrieveQuiz(@PathVariable Integer id) {
		try {
			return new ResponseEntity<QuizEntity>(service.getQuizResult(id), HttpStatus.OK);
		} catch (Exception e) {			
			return new ResponseEntity<QuizEntity>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/quizzes/active")
	public ResponseEntity<List<QuizEntity>> retrieveActiveQuiz() {
		try {
			return new ResponseEntity<List<QuizEntity>>(service.getActiveQuiz(), HttpStatus.OK);
		} catch (Exception e) {			
			return new ResponseEntity<List<QuizEntity>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
