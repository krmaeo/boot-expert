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
    QuestionService questionService;
    AnswerService answerService;
    private List<Question> allQuestions;
    private List<Integer> answeredQuestions;

    public RestController(QuestionService questionService, AnswerService answerService) {
        this.questionService = questionService;
        this.answerService = answerService;
    }

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

//    @PostMapping("/question/save")
//    private int savePerson(@RequestBody Question question) {
//        questionService.saveOrUpdate(question);
//        return question.getId();
//    }

    @GetMapping("/questions")
    private List<Question> getQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/question/any")
    Question getQuestion() throws Exception {
        allQuestions = questionService.getAllQuestions();
        List<Question> notAnswered = allQuestions.stream().filter(question -> !answeredQuestions.contains(question.getId())).collect(Collectors.toList());
        Random rand = new Random();
        if (notAnswered.isEmpty()) {
            throw new NoNewQuestionException("There are no more questions.");
        }
        Question randomQuestion = notAnswered.get(rand.nextInt(notAnswered.size()));
        return randomQuestion;
    }
    //@PostMapping("/checkAnswer")
    //private CorrectAnswer checkAnswer(@RequestBody Integer answerID) {

    //}

    @GetMapping("/answer/{id}")
    private Answer getAnswersById(@PathVariable("id") int id) {
        return answerService.getAnswerById(id);
    }

    @GetMapping("/answers")
    private List<Answer> getAnswers() {
        return answerService.getAllAnswers();
    }
                  
    @GetMapping("/question/{id}/answers")
    private List<Answer> getAnswersByQuestion (@PathVariable("id") int id){
        return answerService.findByQuestionId(id);
    }



}
