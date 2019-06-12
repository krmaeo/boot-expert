package com.example.demo;

import com.example.demo.domain.Answer;
import com.example.demo.domain.Question;
import com.example.demo.service.AnswerService;
import com.example.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private List<Question> asked_questions;

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerService answerService;

    @GetMapping("/questions")
    private List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/question/{id}")
    private Question getQuestion(@PathVariable("id") int id) {
        return questionService.getQuestionById(id);
    }

    @GetMapping("/answer/{id}")
    private Answer getAnswer(@PathVariable("id") int id) {
        return answerService.getAnswerById(id);
    }


    @PostMapping("/save_question")
    private int saveQuestion(@RequestBody Question question) {
        questionService.saveOrUpdate(question);
        return question.getId();
    }

    @GetMapping("/get_answers")
    private List<Answer> getAnswers() {
        return answerService.getAllAnswers();
    }

    /*
    @PostMapping("/getAnswersByQuestion/{questionId}")
    private List<Answer> getAnswersByQuestion(@PathVariable("questionId") String questionId) {
        return answerService.findByQuestionId(questionId);

    }

     */



}
