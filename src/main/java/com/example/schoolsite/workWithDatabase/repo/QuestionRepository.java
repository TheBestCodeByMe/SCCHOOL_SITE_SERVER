package com.example.schoolsite.workWithDatabase.repo;

import com.example.schoolsite.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
public interface QuestionRepository extends DefaultFirebaseRealtimeDatabaseRepository<Question, Long> {
    Question findByQuestion(String question);
}
*/
//@Repository
public interface QuestionRepository {//extends JpaRepository<Question, Long> {
    Question findByQuestion(String question);
}
