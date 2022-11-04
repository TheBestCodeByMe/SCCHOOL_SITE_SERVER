drop database courseWorkSiTAiRIS;
create database if not exists courseWorkSiTAiRIS;
use courseWorkSiTAiRIS;
create table if not exists users (
                                     id bigint auto_increment primary key,
                                     role varchar(245) not null,
                                     login varchar(245) not null,
                                     password varchar(245) not null,
                                     status varchar(35) not null default 'unBlock',
                                     link varchar(245) default null
);
create table if not exists roles (
                                     id bigint auto_increment primary key,
                                     name varchar(245) not null
);
/*Связь многие ко многим не потому, что я так захотела,
а в примере авторизации для спринга через security, было именно так :)*/
create table if not exists roles_users (
                                           id bigint auto_increment primary key,
                                           role_id bigint not null,
                                           user_id bigint not null,
                                           CONSTRAINT FK_Role FOREIGN KEY (role_id)
                                               REFERENCES roles (id) ON DELETE CASCADE,
                                           CONSTRAINT FK_User FOREIGN KEY (user_id)
                                               REFERENCES users (id) ON DELETE CASCADE
);
create table if not exists parents (
                                       id bigint auto_increment primary key,
                                       name_mom varchar(245) not null,
                                       lastname_mom varchar(245) not null,
                                       patronymic_mom varchar(245) not null,
                                       name_dad varchar(245) not null,
                                       lastname_dad varchar(245) not null,
                                       patronymic_dad varchar(245) not null
);
create table if not exists subjects (
                                        id bigint auto_increment primary key,
                                        subject_name varchar(245) not null
);
create table if not exists teachers (
                                        id bigint auto_increment primary key,
                                        user_id bigint default 0,
                                        name varchar(245) not null,
                                        last_name varchar(245) not null,
                                        patronymic varchar(245) not null,
                                        email varchar(245) default null,
                                        qualification varchar(245) default null,
                                        position varchar(245) default 'учитель',
                                        FOREIGN KEY(user_id) REFERENCES users(id)
);
create table if not exists classroom (
                                         id bigint auto_increment primary key,
                                         classroom_teacher_id bigint not null,
                                         name varchar(245) not null,
                                         FOREIGN KEY(classroom_teacher_id) REFERENCES teachers(id)
);
create table if not exists pupil (
                                     id bigint auto_increment primary key,
                                     userId bigint default 0,
                                     name varchar(245) not null,
                                     lastname varchar(245) not null,
                                     patronymic varchar(245) not null,
                                     date_of_birthday date not null,
                                     email varchar(245) default null,
                                     personal_check varchar(245) default null,
                                     classroom_id bigint not null,
                                     parents_id bigint not null,
                                     FOREIGN KEY(parents_id) REFERENCES parents(id),
                                     FOREIGN KEY(user_id) REFERENCES users(id),
                                     FOREIGN KEY(classroom_id) REFERENCES classroom(id)
);
CREATE TABLE if not exists calendar(
                                       id
                                                   bigint auto_increment primary key,
                                       semester_id bigint not null,
                                       week_day INT not null,
                                       lesson_id
                                                   INT not null
-- LessonTime VARCHAR(20) not null
);
CREATE TABLE if not exists shedule(
                                      id
                                                   bigint auto_increment primary key,
                                      classroom_id bigint NOT NULL,-- CONSTRAINT FK_Schedule_ClassroomID REFERENCES dbo.Groups(ID),
                                      subject_id bigint NOT NULL, -- CONSTRAINT FK_Schedule_SubjectID REFERENCES dbo.Subjects(ID),
                                      teacher_id bigint NOT NULL,-- CONSTRAINT FK_Schedule_TeacherID REFERENCES dbo.Teachers(ID),
                                      week_day bigint NOT NULL, -- CONSTRAINT CK_Schedule_Weekday CHECK (WeekDay BETWEEN 1 AND 6),
                                      date date not null,
                                      calendar_id
                                                   bigint,
                                      hometask varchar(245),
                                      constraint FK_Schedule_ClassroomID foreign key(classroom_id) references classroom (id) ON DELETE cascade,
                                      constraint FK_Schedule_SubjectID foreign key(subject_id) references subjects (id) ON DELETE CASCADE,
                                      constraint FK_Schedule_TeacherID foreign key(teacher_id) references teachers (id) ON DELETE CASCADE,
                                      constraint FK_Schedule_CalendarID foreign key(calendar_id) references calendar (id) ON DELETE CASCADE,
                                      constraint CK_Schedule_Weekday CHECK (week_day between 1 AND 6)
);
CREATE TABLE if not exists attendance (
                                          id
                                                    bigint auto_increment primary key,
                                          pupil_id bigint not null,
                                          class_id
                                                    bigint not null,
                                          lesson_id bigint not null,
                                          FOREIGN KEY(pupil_id) REFERENCES pupil(id),
                                          FOREIGN KEY(class_id) REFERENCES classroom(id),
                                          FOREIGN KEY(lesson_id) REFERENCES shedule(id)
);
CREATE TABLE if not exists academicPerfomance (
                                                  id
                                                            bigint auto_increment primary key,
                                                  pupil_id bigint not null,
                                                  class_id
                                                            bigint not null,
                                                  lesson_id bigint not null,
                                                  grade
                                                            INT,
                                                  FOREIGN KEY(pupil_id) REFERENCES pupil(id),
                                                  FOREIGN KEY(class_id) REFERENCES classroom(id),
                                                  FOREIGN KEY(lesson_id) REFERENCES shedule(id)
);
CREATE TABLE if not exists questions_from_users (
                                                    id
                                                             bigint auto_increment primary key,
                                                    question varchar(245) not null,
                                                    responsevarchar(1000) default null,
flag
boolean default false
);