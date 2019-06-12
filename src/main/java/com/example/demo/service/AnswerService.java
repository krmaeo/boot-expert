package com.example.demo.service;

import com.example.demo.domain.Answer;
import com.example.demo.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerService {
    @Autowired
    AnswerRepository answerRepository;

    public List<Answer> getAllAnswers() {
        List<Answer> answers = new ArrayList<Answer>();
        answerRepository.findAll().forEach(answer -> answers.add(answer));
        return answers;
    }

    public Answer getAnswerById(Integer id) {
        return answerRepository.findById(id).get();
    }

    public List<Answer> findByQuestionId(int questionId){
        List<Answer> answers = new ArrayList<>();
        Iterable<Answer> iterable = answerRepository.findByQuestionId(questionId);
        iterable.forEach(answers::add);
        return answers;
    }


}
