package com.example.schoolsite.graphQl;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.schoolsite.entity.Subject;
import com.example.schoolsite.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubjectMutation implements GraphQLMutationResolver {
    @Autowired
    private SubjectService subjectService;

    public Subject createSubject(final String subjectName) {
        return this.subjectService.createSubject(subjectName);
    }
}
