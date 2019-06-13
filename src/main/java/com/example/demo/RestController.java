package com.example.demo;

import com.example.demo.TimeConverter.Milliseconds;
import com.example.demo.domain.Answer;
import com.example.demo.domain.Question;
import com.example.demo.domain.SessionInfo;
import com.example.demo.errors.NoNewQuestionException;
import com.example.demo.responseClasses.CorrectAnswer;
import com.example.demo.responseClasses.Results;
import com.example.demo.responseClasses.SendQuestion;
import com.example.demo.service.AnswerService;
import com.example.demo.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    QuestionService questionService;
    AnswerService answerService;
    private List<Question> allQuestions;

    @Resource(name = "sessionInfo")
    private SessionInfo sessionInfo;

    public RestController(QuestionService questionService, AnswerService answerService, SessionInfo sessionInfo) {
        this.questionService = questionService;
        this.answerService = answerService;
        this.sessionInfo = new SessionInfo();
    }

    @GetMapping("/questions/{id}")
    private Question getQuestion(@PathVariable("id") int id) {
        return questionService.getQuestionById(id);
    }

    @DeleteMapping("/questions/{id}")
    private void deleteQuestion(@PathVariable("id") int id) {
        questionService.deleteById(id);
    }

    @PostMapping("/questions/question")
    private int saveQuestion(@RequestBody Question question) {
        questionService.saveOrUpdate(question);
        return question.getId();
    }

    @GetMapping("/questions")
    private List<Question> getQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/questions/unanswered/any")
    SendQuestion getQuestion() throws Exception {
        allQuestions = questionService.getAllQuestions();
        List<Question> notAnswered = allQuestions.stream().filter(question -> (!sessionInfo.getAnsweredQuestionsId().contains(question.getId()))).collect(Collectors.toList());
        Random rand = new Random();
        if (notAnswered.isEmpty()) {
            sessionInfo.setPassedTime();
            throw new NoNewQuestionException("There are no more questions.");
        }
        Question randomQuestion = notAnswered.get(rand.nextInt(notAnswered.size()));
        List<Answer> answersList = answerService.findByQuestionId(randomQuestion.getId());
        sessionInfo.startTime();
        return new SendQuestion(randomQuestion, answersList);
    }
    @PostMapping("/questions/{id}/answer")
    CorrectAnswer checkAnswer(@PathVariable("id") Integer questionID, @RequestBody Integer answerID) {
        List<Answer> answerList = answerService.findByQuestionId(questionID);
        Boolean isCorrect = answerList.stream().filter(answer -> answer.getId() == answerID).map(Answer::isCorrect).findAny().orElse(null);
        Question question = questionService.getQuestionById(questionID);
        sessionInfo.addQuestion(question);
        String additionalInfo = question.getAdditionalInfo();
        if (!isCorrect) {
            Integer rightAnswerID;
            rightAnswerID = answerList.stream().filter(Answer::isCorrect).map(Answer::getId).findAny().orElse(null);
            return new CorrectAnswer(question, rightAnswerID, additionalInfo);
        }
        sessionInfo.addScore();
        return new CorrectAnswer(question, additionalInfo);
    }

    @GetMapping("/session-info/results")
    public Results sendResults() {
        return new Results(sessionInfo.getScore(), sessionInfo.getFinalPassedTime());
    }

    @GetMapping("/session-info/time/final")
    public Milliseconds finalPassedTime() {
        return sessionInfo.getFinalPassedTime();
    }

    @GetMapping("/session-info/time/current")
    public Milliseconds currentPassedTime() {
        return sessionInfo.getCurrentPassedTime();
    }

    @GetMapping("/session-info/score")
    Integer score() {
        return sessionInfo.getScore();
    }

    @GetMapping("/questions/answers")
    private List<Answer> getAnswers() {
        return answerService.getAllAnswers();
    }

}