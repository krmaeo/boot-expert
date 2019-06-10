package com.example.demo;

import com.example.demo.domain.Question;
import com.example.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

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
}
