package com.example.demo.repository;

import com.example.demo.domain.Answer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Integer> {


    /*
    @Query("from Answer a join a.question_Id q where q =: questionId")
    public Iterable<Answer> findByQuestionId(@Param("questionId") String questionId);

     */
}
