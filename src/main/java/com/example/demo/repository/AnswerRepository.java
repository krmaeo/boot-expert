package com.example.demo.repository;

import com.example.demo.domain.Answer;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Integer> {
}
