package com.example.schoolsite.graphQl;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.schoolsite.entity.Subject;
import com.example.schoolsite.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SubjectQuery implements GraphQLQueryResolver {
    @Autowired
    private SubjectService subjectService;

    public List<Subject> getSubjects(final int count) {
        return this.subjectService.getAllSubjects(count);
    }
    public Optional<Subject> getSubject(final Long id) {
        return this.subjectService.getSubject(id);
    }
}
