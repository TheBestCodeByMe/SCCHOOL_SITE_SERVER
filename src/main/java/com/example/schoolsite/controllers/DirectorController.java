package com.example.schoolsite.controllers;

import com.example.schoolsite.dto.ClassroomDTO;
import com.example.schoolsite.entity.Classroom;
import com.example.schoolsite.entity.Teacher;
import com.example.schoolsite.map.Mapper;
import com.example.schoolsite.workWithDatabase.repo.ClassroomRepository;
import com.example.schoolsite.workWithDatabase.repo.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class DirectorController {
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ClassroomRepository classroomRepository;

    @GetMapping("/classroomDTO")
    public List<ClassroomDTO> getAllClassroom() {
        List<Teacher> teachers = teacherRepository.findAll();
        List<Classroom> classroom = classroomRepository.findAll();
        List<ClassroomDTO> classroomDTOList = new ArrayList<>();

        for (Classroom value : classroom) {
            for (Teacher teacher : teachers) {
                if(Objects.equals(value.getClassroomTeacherId(), teacher.getId())){
                classroomDTOList.add(Mapper.mapClassroomToClassroomDTO(value, teacher));}
            }
        }
        return classroomDTOList;
    }
}
