package com.example.schoolsite.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "academic_performance")
@ToString
public class AcademicPerfomance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="academic_performance_id")
    private Long id;
    @Column(name = "pupil_academic_performance_id", nullable = false)
    private Long pupilID; // TODO: сделать внешним ключом
    @Column(name = "class_academic_performance_id", nullable = false)
    private Long classID; // TODO: сделать внешним ключом
    @Column(name = "lesson_academic_performance_id", nullable = false)
    private Long lessonID; // TODO: сделать внешним ключом
    @Column(name = "academic_performance_grade", nullable = false)
    private int grade;

    public AcademicPerfomance(Long pupilID, Long classID, Long lessonID, int grade) {
        this.pupilID = pupilID;
        this.classID = classID;
        this.lessonID = lessonID;
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcademicPerfomance that = (AcademicPerfomance) o;
        return grade == that.grade && Objects.equals(id, that.id) && Objects.equals(pupilID, that.pupilID) && Objects.equals(classID, that.classID) && Objects.equals(lessonID, that.lessonID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pupilID, classID, lessonID, grade);
    }
}
