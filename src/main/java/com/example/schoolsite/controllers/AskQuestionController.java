package com.example.schoolsite.controllers;

import com.example.schoolsite.dto.DiaryDTO;
import com.example.schoolsite.dto.PupilDTO;
import com.example.schoolsite.entity.Classroom;
import com.example.schoolsite.entity.Parents;
import com.example.schoolsite.entity.Pupil;
import com.example.schoolsite.entity.Question;
import com.example.schoolsite.map.Mapper;
import com.example.schoolsite.services.QuestionService;
import com.example.schoolsite.workWithDatabase.repo.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/askQuestion")
public class AskQuestionController {
    @GetMapping("/h")
    public String getQuestion()  {
        return "<!DOCTYPE HTML>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>Getting Started: Serving Web Content</title> \n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
                "</head>\n" +
                "<body>\n" +
                "    <p>Get your greeting <a href=\"/greeting\">here</a></p>\n" +
                "</body>\n" +
                "</html>";
    }

    @Autowired
    private QuestionService questionService;

    @GetMapping("/getQuestionDetails/{code}")
    public Question getQuestion(@PathVariable(value = "code") String code) throws InterruptedException, ExecutionException {
        return questionService.getQuestionDetails(code);
    }

    @PostMapping("/addQuestion")
    public String createQuestion(@RequestBody Question question) throws InterruptedException, ExecutionException {
        question.setCode(question.getQuestion().substring(10, 15).concat("question" + Math.random()));
        return questionService.saveQuestion(question);
    }

    @PostMapping("/updateQuestion")
    public String updateQuestion(@RequestBody Question question) throws InterruptedException, ExecutionException {
        return questionService.updateQuestionDetails(question);
    }

    @DeleteMapping("/deleteQuestion/{code}")
    public String deleteQuestion(@PathVariable(value = "code")  String code) {
        return questionService.deleteQuestion(code);
    }
    /*
    @Autowired
    private QuestionRepository questionRepository;

    @PostMapping("/addQuestion")
    public Question createQuestion(@Validated @RequestBody Question question) {
        Question questionFromRepo = questionRepository.findByQuestion(question.getQuestion());
        if (questionFromRepo == null) {
            questionRepository.save(question);
        }
        return question;
    }
    */
}
