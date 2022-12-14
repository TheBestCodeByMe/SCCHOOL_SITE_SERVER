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
@Table(name = "calendar")
@ToString
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="calendar_id")
    private Long id;
    @Column(name = "calendar_semester", nullable = false)
    private int semesterID;
    @Column(name = "calendar_week_day", nullable = false)
    private int weekDay;
    @Column(name = "lesson_calendar_id", nullable = false)
    private int lessonNumber;

    public Calendar(int semesterID, int weekDay, int lessonNumber) {
        this.semesterID = semesterID;
        this.weekDay = weekDay;
        this.lessonNumber = lessonNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calendar calendar = (Calendar) o;
        return weekDay == calendar.weekDay && lessonNumber == calendar.lessonNumber && Objects.equals(id, calendar.id) && Objects.equals(semesterID, calendar.semesterID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, semesterID, weekDay, lessonNumber);
    }
}