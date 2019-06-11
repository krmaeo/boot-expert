package com.example.demo;

import com.example.demo.domain.Answer;
import com.example.demo.domain.Question;
import com.example.demo.errors.NoNewQuestionException;
import com.example.demo.responseClasses.CorrectAnswer;
import com.example.demo.service.AnswerService;
import com.example.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    QuestionService questionService;
    AnswerService answerService;

    private List<Question> allQuestions;
    private List<Integer> answeredQuestions;

    public static void main(String[] args) {
       new RestController();
    }

    public RestController() {
        answeredQuestions = new ArrayList<>();
    }



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

    @GetMapping("/getQuestion")
    Question getQuestion() throws Exception {
        allQuestions = questionService.getAllQuestions();
        List<Question> notAnswered = allQuestions.stream().filter(question -> !answeredQuestions.contains(question.getId())).collect(Collectors.toList());
        Random rand = new Random();
        Question randomQuestion = notAnswered.get(rand.nextInt(notAnswered.size()));
        if (notAnswered.isEmpty()) {
            throw new NoNewQuestionException("There are no more questions.");
        }
        return randomQuestion;
    }
    @PostMapping("/checkAnswer")
    private CorrectAnswer checkAnswer(@RequestBody Integer answerID) {
        
    }

    @GetMapping("/answers/{id}")
    private Answer getAnswersById(@PathVariable("id") int id) {
        return answerService.getAnswerById(id);
    }



}
