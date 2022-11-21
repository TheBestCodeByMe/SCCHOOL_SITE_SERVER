package com.example.schoolsite.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Data
@Entity
@Getter
@Setter
public class Subject implements Serializable {
    @Id
    @GeneratedValue //(strategy = GenerationType.AUTO)
    @Column(name="subject_id", nullable = false)
    private Long id;
    @Column(name = "subject_name", nullable = false)
    private String subjectName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(id, subject.id) && Objects.equals(subjectName, subject.subjectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subjectName);
    }
}
