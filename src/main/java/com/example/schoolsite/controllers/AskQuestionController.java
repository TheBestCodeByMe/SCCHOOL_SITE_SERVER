package com.example.schoolsite.controllers;

import com.example.schoolsite.dto.DiaryDTO;
import com.example.schoolsite.dto.PupilDTO;
import com.example.schoolsite.entity.*;
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
    @PostMapping("/h")
    public ResponseEntity<String> getQuestion(@RequestBody String name, @RequestBody String email, @RequestBody String description) {
        QuestionForDev question = new QuestionForDev(description.concat("question" + Math.random()), name, email, description,"");
        question.setCode(question.getQuestion().substring(10, 15).concat("question" + Math.random()));
        try {
            questionService.saveQuestionForDevelopers(question);
        }  catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("""
                <head>
                    <title>Getting Started: Serving Web Content</title>\s
                    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
                </head>
                <body>
                    <p>Ваш вопрос принят <a href="http://localhost:4200/main">Вернуться на главную страницу</a></p>
                </body>""");
    }

    @GetMapping("/h3")
    public String getHelp() {
        double a = 1;
        return """
                <!DOCTYPE html>
                <html lang="en">
                                
                <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
                    <title>contactWithSupport</title>
                    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
                    <style>
                    .contact-clean {
                      background: #f1f7fc;
                      padding: 80px 0;
                    }
                    
                    @media (max-width:767px) {
                      .contact-clean {
                        padding: 20px 0;
                      }
                    }
                    
                    .contact-clean form {
                      max-width: 480px;
                      width: 90%;
                      margin: 0 auto;
                      background-color: #ffffff;
                      padding: 40px;
                      border-radius: 4px;
                      color: #505e6c;
                      box-shadow: 1px 1px 5px rgba(0,0,0,0.1);
                    }
                    body {
                        margin: 0;
                        font-family: var(--bs-font-sans-serif);
                        font-size: 1rem;
                        font-weight: 400;
                        line-height: 1.5;
                        color: #212529;
                        background-color: #fff;
                        -webkit-text-size-adjust: 100%;
                        -webkit-tap-highlight-color: transparent
                    }
                    
                    .mb-1 {
                        margin-bottom: .25rem !important
                    }
                    
                    .mb-2 {
                        margin-bottom: .5rem !important
                    }
                    
                    .mb-3 {
                        margin-bottom: 1rem !important
                    }
                    
                    .mb-4 {
                        margin-bottom: 1.5rem !important
                    }
                    
                    .mb-5 {
                        margin-bottom: 3rem !important
                    }
                    
                    .mb-auto {
                        margin-bottom: auto !important
                    }
                    
                    .ms-0 {
                        margin-left: 0 !important
                    }
                    button, input, optgroup, select, textarea {
                        margin: 0;
                        font-family: inherit;
                        font-size: inherit;
                        line-height: inherit;
                        background-position: center;
                    }
                    form{
                    text-align: center;
                    }
                    @media (max-width:767px) {
                      .contact-clean form {
                        padding: 30px;
                      }
                    }
                    
                    .contact-clean h2 {
                      margin-top: 5px;
                      font-weight: bold;
                      font-size: 28px;
                      margin-bottom: 36px;
                      color: inherit;
                    }
                    
                    .contact-clean form .form-control {
                      background: #fff;
                      border-radius: 2px;
                      box-shadow: 1px 1px 1px rgba(0,0,0,0.05);
                      outline: none;
                      color: inherit;
                      padding-left: 12px;
                      height: 42px;
                    }
                    
                    .contact-clean form .form-control:focus {
                      border: 1px solid #b2b2b2;
                    }
                    
                    .contact-clean form textarea.form-control {
                      min-height: 100px;
                      max-height: 260px;
                      padding-top: 10px;
                      resize: vertical;
                    }
                    
                    .contact-clean form .btn {
                      padding: 16px 32px;
                      border: none;
                      background: none;
                      box-shadow: none;
                      text-shadow: none;
                      opacity: 0.9;
                      text-transform: uppercase;
                      font-weight: bold;
                      font-size: 13px;
                      letter-spacing: 0.4px;
                      line-height: 1;
                      outline: none !important;
                    }
                    
                    .contact-clean form .btn:hover {
                      opacity: 1;
                    }
                    
                    .contact-clean form .btn:active {
                      transform: translateY(1px);
                    }
                    
                    .contact-clean form .btn-primary {
                      background-color: #055ada !important;
                      margin-top: 15px;
                      color: #fff;
                    }
                    .footer-dark {
                      padding: 50px 0;
                      color: #f0f9ff;
                      background-color: #282d32;
                    }
                    
                    .footer-dark h3 {
                      margin-top: 0;
                      margin-bottom: 12px;
                      font-weight: bold;
                      font-size: 16px;
                    }
                    
                    .footer-dark ul {
                      padding: 0;
                      list-style: none;
                      line-height: 1.6;
                      font-size: 14px;
                      margin-bottom: 0;
                    }
                    
                    .footer-dark ul a {
                      color: inherit;
                      text-decoration: none;
                      opacity: 0.6;
                    }
                    
                    .footer-dark ul a:hover {
                      opacity: 0.8;
                    }
                    
                    @media (max-width:767px) {
                      .footer-dark .item:not(.social) {
                        text-align: center;
                        padding-bottom: 20px;
                      }
                    }
                    
                    .footer-dark .item.text {
                      margin-bottom: 36px;
                    }
                    
                    @media (max-width:767px) {
                      .footer-dark .item.text {
                        margin-bottom: 0;
                      }
                    }
                    
                    .footer-dark .item.text p {
                      opacity: 0.6;
                      margin-bottom: 0;
                    }
                    
                    .footer-dark .item.social {
                      text-align: center;
                    }
                    
                    @media (max-width:991px) {
                      .footer-dark .item.social {
                        text-align: center;
                        margin-top: 20px;
                      }
                    }
                    
                    .footer-dark .item.social > a {
                      font-size: 20px;
                      width: 36px;
                      height: 36px;
                      line-height: 36px;
                      display: inline-block;
                      text-align: center;
                      border-radius: 50%;
                      box-shadow: 0 0 0 1px rgba(255,255,255,0.4);
                      margin: 0 8px;
                      color: #fff;
                      opacity: 0.75;
                    }
                    
                    .footer-dark .item.social > a:hover {
                      opacity: 0.9;
                    }
                    
                    .footer-dark .copyright {
                      text-align: center;
                      padding-top: 24px;
                      opacity: 0.3;
                      font-size: 13px;
                      margin-bottom: 0;
                    }</style>
                </head>
                                
                <body>
                    <section class="contact-clean">
                        <form action="http://localhost:8080/api/v1/askQuestion/h" method="post">
                            <h2 class="text-center">Contact us</h2>
                            <div class="mb-3"><input class="form-control" type="text" name="name" placeholder="Name"></div>
                            <div class="mb-3"><input class="form-control" type="email" name="email" placeholder="Email"></div>
                            <div class="mb-3"><textarea class="form-control" name="message" placeholder="Message" rows="14"></textarea></div>
                            <div class="mb-3"><button class="btn btn-primary" type="submit">send</button></div>
                        </form>
                    </section>
                    <footer class="footer-dark">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-6 item text">
                                    <h3>SchoolSite</h3>
                                    <p>You can write on our email for your question :)</p>
                                </div>
                            </div>
                            <p class="copyright">UlianaBrand В© 2022</p>
                        </div>
                    </footer>
                    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
                </body>
                                
                </html>""";
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
    public String deleteQuestion(@PathVariable(value = "code") String code) {
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
