package com.example.schoolsite.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "schedule")
@ToString
public class Shedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="schedule_id")
    private Long id;
    @Column(name = "classroom_schedule_id", nullable = false)
    private Long classroomID; // TODO: сделать внешним ключом
    @Column(name = "subject_schedule_id", nullable = false)
    private Long subjectID; // TODO: сделать внешним ключом
    @Column(name = "teacher_schedule_id", nullable = false)
    private Long teacherID; // TODO: сделать внешним ключом
    @Column(name = "schedule_week_day", nullable = false)
    private int weekDay;
    @Column(name = "schedule_date", nullable = false)
    private Date date;
    @Column(name = "calendar_schedule_id", nullable = false)
    private Long calendarId;
    @Column(name = "schedule_hometask")
    private String hometask;

    public Shedule(Long classroomID, Long subjectID, Long teacherID, int weekDay, Date date, Long calendarId, String hometask) {
        this.classroomID = classroomID;
        this.subjectID = subjectID;
        this.teacherID = teacherID;
        this.weekDay = weekDay;
        this.date = date;
        this.calendarId = calendarId;
        this.hometask = hometask;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shedule shedule = (Shedule) o;
        return Objects.equals(id, shedule.id) && Objects.equals(classroomID, shedule.classroomID) && Objects.equals(subjectID, shedule.subjectID) && Objects.equals(teacherID, shedule.teacherID) && Objects.equals(weekDay, shedule.weekDay) && Objects.equals(date, shedule.date) && Objects.equals(calendarId, shedule.calendarId) && Objects.equals(hometask, shedule.hometask);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, classroomID, subjectID, teacherID, weekDay, date, calendarId, hometask);
    }
}
