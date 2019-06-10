package com.example.demo.repository;

import com.example.demo.domain.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Integer> {
}
