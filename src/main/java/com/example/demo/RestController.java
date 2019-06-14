package com.example.demo;

import com.example.demo.domain.Device;
import com.example.demo.errors.NoResponseFromDevices;
import com.example.demo.responseClasses.*;
import com.example.demo.service.DeviceService;
import com.example.demo.timeConverter.Milliseconds;
import com.example.demo.domain.Answer;
import com.example.demo.domain.Question;
import com.example.demo.errors.NoNewQuestionException;
import com.example.demo.service.AnswerService;
import com.example.demo.service.QuestionService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    QuestionService questionService;
    AnswerService answerService;
    DeviceService deviceService;
    RfIdInfo rfIdInfo = null;

    @Resource(name = "sessionInfo")
    private SessionInfo sessionInfo;

    public RestController(QuestionService questionService, AnswerService answerService, DeviceService deviceService) {
        this.questionService = questionService;
        this.answerService = answerService;
        this.deviceService = deviceService;
        this.sessionInfo = new SessionInfo();
    }



    @PostMapping("/rfidinfo")
    private RfIdInfo getDeviceInfo(@RequestBody RfIdInfo rfIdInfo) {
        this.rfIdInfo = rfIdInfo;
        return rfIdInfo;
    }

    @GetMapping("/rfidinfo")
    private Map getDeviceInfo(@RequestParam Map<String, String> map) {
        rfIdInfo = new RfIdInfo(map);
        System.out.println(rfIdInfo);
        return map;
    }

    @GetMapping("/get-changes")
    private SendChanges changes() throws Exception{
        if (rfIdInfo == null) {
            throw new NoResponseFromDevices("No changes yet.");
        }
        return rfIdInfo.checkForChanges();
    }

    @GetMapping("/questions/{id}")
    private Question getQuestion(@PathVariable("id") int id) {
        return questionService.getQuestionById(id);
    }

    @DeleteMapping("/questions/{id}")
    private void deleteQuestion(@PathVariable("id") int id) {
        questionService.deleteById(id);
    }

    @PostMapping("/questions")
    private int saveQuestion(@RequestBody Question question) {
        questionService.saveOrUpdate(question);
        return question.getId();
    }

    @GetMapping("/questions")
    private List<Question> getQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/questions/unanswered/any")
    GetQuestionResponse getQuestionAny() throws Exception {
        List<Question> allQuestions = questionService.getAllQuestions();
        List<Question> notAnswered = allQuestions.stream().filter(question -> (!sessionInfo.getAnsweredQuestionsId().contains(question.getId()))).collect(Collectors.toList());
        return getQuestion(notAnswered);
    }

    @GetMapping("devices/{id}/questions/unanswered/any")
    GetQuestionResponse getQuestionAny(@PathVariable("id") int id) throws Exception {
        List<Question> allQuestionsForDevice = questionService.getAllQuestions().stream().filter(question -> question.getDeviceId() ==id).collect(Collectors.toList());
        List<Question> notAnswered = allQuestionsForDevice.stream().filter(question -> (!sessionInfo.getAnsweredQuestionsId().contains(question.getId()))).collect(Collectors.toList());
        return getQuestion(notAnswered);
    }

    GetQuestionResponse getQuestion(List<Question> notAnswered) throws Exception{
        if (notAnswered.isEmpty()) {
            sessionInfo.setPassedTime();
            throw new NoNewQuestionException("There are no more questions.");
        }
        Random rand = new Random();
        Question randomQuestion = notAnswered.get(rand.nextInt(notAnswered.size()));
        List<Answer> answersList = answerService.findByQuestionId(randomQuestion.getId());
        sessionInfo.startTime();
        return new GetQuestionResponse(randomQuestion, answersList);
    }

    @PostMapping("devices/{device-id}/questions/{id}/answer")
    CorrectAnswer checkAnswerWIthDevice(@PathVariable("id") Integer questionID, @RequestBody Integer answerID) {
        return getCorrectAnswer(questionID, answerID);
    }

    @PostMapping("/questions/{id}/answer")
    CorrectAnswer checkAnswer(@PathVariable("id") Integer questionID, @RequestBody AnswerId answerId) {
        return getCorrectAnswer(questionID, answerId.getAnswerId());
    }

    private CorrectAnswer getCorrectAnswer(@PathVariable("id") Integer questionID, @RequestBody Integer answerID) {
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


    @GetMapping("/devices")
    private List<Device> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @GetMapping("/devices/{id}")
    private Device getDeviceById(@PathVariable("id") Integer deviceId) {
        return deviceService.getDeviceById(deviceId);
    }

    @GetMapping("/session-info/results")
    public Results sendResults() {
        return new Results(sessionInfo.getScore(), sessionInfo.getFinalPassedTime());
    }

    @GetMapping("devices/{id}/session-info/results")
    public Results sendResultsDevice() {
        return new Results(sessionInfo.getScore(), sessionInfo.getFinalPassedTime());
    }

    @GetMapping("/session-info/time/final")
    public Milliseconds finalPassedTime() {
        return sessionInfo.getFinalPassedTime();
    }

    @GetMapping("/devices/{id}/session-info/time/final")
    public Milliseconds finalPassedTimeDevice() {
        return sessionInfo.getFinalPassedTime();
    }

    @GetMapping("/session-info/time/current")
    public Milliseconds currentPassedTime() {
        return sessionInfo.getCurrentPassedTime();
    }

    @GetMapping("/devices/{id}/session-info/time/current")
    public Milliseconds currentPassedTimeDevice() {
        return sessionInfo.getCurrentPassedTime();
    }

    @GetMapping("/session-info/score")
    Integer score() {
        return sessionInfo.getScore();
    }

    @GetMapping("/device/{id}/session-info/score")
    Integer getScoreWithDeviceId() {
        return sessionInfo.getScore();
    }

    @GetMapping("/questions/answers")
    private List<Answer> getAnswers() {
        return answerService.getAllAnswers();
    }

    @GetMapping("/device/{id}/questions/answers")
    private List<Answer> getAnswersDevice() {
        return answerService.getAllAnswers();
    }
}