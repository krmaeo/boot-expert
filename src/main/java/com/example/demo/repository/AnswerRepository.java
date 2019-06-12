package com.example.demo.repository;

import com.example.demo.domain.Answer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Integer> {

    Iterable<Answer> findByQuestionId(int questionId);


}
