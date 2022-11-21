package com.example.schoolsite.services;

import com.example.schoolsite.entity.Subject;
import com.example.schoolsite.workWithDatabase.repo.SubjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;
    public SubjectService(final SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository ;
    }
    @Transactional
    public Subject createSubject(final String subjectName) {
        final Subject subject = new Subject();
        subject.setSubjectName(subjectName);
        return this.subjectRepository.save(subject);
    }
    @Transactional(readOnly = true)
    public List<Subject> getAllSubjects(final int count) {
        return this.subjectRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public Optional<Subject> getSubject(final Long id) {
        return this.subjectRepository.findById(id);
    }
}
