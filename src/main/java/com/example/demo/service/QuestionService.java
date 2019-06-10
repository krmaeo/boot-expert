package com.example.demo.service;

import com.example.demo.domain.Question;
import com.example.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<Question>();
        questionRepository.findAll().forEach(question -> questions.add(question));
        return questions;
    }

    public Question getQuestionById(Integer id) {
        return questionRepository.findById(id).get();
    }

    public void saveOrUpdate(Question question) {
        questionRepository.save(question);
    }

    public void deleteById(Integer id) {
        questionRepository.deleteById(id);
    }
}
