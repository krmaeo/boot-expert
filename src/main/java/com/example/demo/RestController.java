package com.example.demo;

import com.example.demo.domain.Answer;
import com.example.demo.domain.Question;
import com.example.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private List<Question> allQuestions;
    private List<Integer> answeredQuestions;

    public static void main(String[] args) {
       new RestController();
    }

    public RestController() {
    }

    private List<Question> asked_questions;

    @Autowired
    QuestionService questionService;

    @GetMapping("/questions")
    private List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/question/{id}")
    private Question getPerson(@PathVariable("id") int id) {
        return questionService.getQuestionById(id);
    }

    @DeleteMapping("/question/{id}")
    private void deletePerson(@PathVariable("id") int id) {
        questionService.deleteById(id);
    }
    @PostMapping("/save_question")
    private int savePerson(@RequestBody Question question) {
        questionService.saveOrUpdate(question);
        return question.getId();
    }
    @GetMapping("/get_questions")
    private List<Question> getQuestions() {
        return questionService.getAllQuestions();
    }

    /*@PostMapping("/new_game")
    private Question newGame(@RequestBody String request) {
        Question given_question = null;
        if (request.equals("get new question")) {
            List<Question> questionList = questionService.getAllQuestions();
            if (asked_questions.size() == questionList.size()) {
                asked_questions.clear();
            }
            for (Question question : questionList) {
                if (!asked_questions.contains(question)) {
                    asked_questions.add(question);
                    given_question = question;
                }
            }
        }
        return given_question;
    }*/

    @GetMapping("/getQuestion")
    Question getQuestion() {
        List<Question> notAnswered = allQuestions.stream().filter(question -> !answeredQuestions.contains(question.getId())).collect(Collectors.toList());
        Random rand = new Random();
        Question randomQuestion = notAnswered.get(rand.nextInt(notAnswered.size()));
        if (notAnswered.isEmpty()) {
            System.exit(1);
        }
        return randomQuestion;
    }



}
