create table if not exists users
(
    user_id       bigint primary key,
    user_login    varchar(100) not null,
    user_password varchar(200) not null,
    user_status   varchar(20)  not null,
    user_link     varchar(100) default null
);

create table if not exists role
(
    role_id   bigint primary key,
    role_name varchar(50) not null
);

create table if not exists role_user
(
    roles_users_id bigint primary key,
    role_id        bigint not null,
    user_id        bigint not null,
    CONSTRAINT FK_Role FOREIGN KEY (role_id)
        REFERENCES role (role_id) ON DELETE CASCADE,
    CONSTRAINT FK_User FOREIGN KEY (user_id)
        REFERENCES users (user_id) ON DELETE CASCADE
);

create table if not exists parents
(
    parents_id             bigint primary key,
    parents_name_mom       varchar(100),
    parents_lastname_mom   varchar(100),
    parents_patronymic_mom varchar(100),
    parents_name_dad       varchar(100),
    parents_lastname_dad   varchar(100),
    parents_patronymic_dad varchar(100)
);

create table if not exists subject
(
    subject_id   bigint primary key,
    subject_name varchar(100) not null
);

create table if not exists teacher
(
    teacher_id            bigint primary key,
    user_teacher_id       bigint,
    teacher_name          varchar(100) not null,
    teacher_lastname      varchar(100) not null,
    teacher_patronymic    varchar(100),
    teacher_email         varchar(100),
    teacher_qualification varchar(100),
    teacher_position      varchar(100),
    FOREIGN KEY (user_teacher_id) REFERENCES users (user_id)
);

create table if not exists classroom
(
    classroom_id         bigint primary key,
    teacher_classroom_id bigint       not null,
    classroom_name       varchar(100) not null,
    FOREIGN KEY (teacher_classroom_id) REFERENCES teacher (teacher_id)
);

create table if not exists pupil
(
    pupil_id               bigint primary key,
    user_pupil_id          bigint,
    pupil_name             varchar(100) not null,
    pupil_lastname         varchar(100) not null,
    pupil_patronymic       varchar(100) not null,
    pupil_date_of_birthday date         not null,
    pupil_email            varchar(100),
    pupil_personal_check   varchar(100),
    classroom_pupil_id     bigint       not null,
    parents_pupil_id       bigint       not null,
    FOREIGN KEY (parents_pupil_id) REFERENCES parents (parents_id),
    FOREIGN KEY (user_pupil_id) REFERENCES users (user_id),
    FOREIGN KEY (classroom_pupil_id) REFERENCES classroom (classroom_id)
);

-- Календарь. Хранит ID семестра, дни недели и время лекций
CREATE TABLE if not exists calendar
(
    calendar_id        bigint primary key,
    calendar_semester  int    not null,
    calendar_week_day  int    not null,
    lesson_calendar_id bigint not null
);

-- Расписание. Хранит пересечение всех всех таблиц
CREATE TABLE if not exists schedule
(
    schedule_id           bigint primary key,
    classroom_schedule_id bigint NOT NULL,
    subject_schedule_id   bigint NOT NULL,
    teacher_schedule_id   bigint NOT NULL,
    schedule_week_day     int    NOT NULL,
    schedule_date         date   not null,
    calendar_schedule_id  bigint not null,
    schedule_hometask     varchar(2000),
    constraint FK_Schedule_ClassroomID foreign key (classroom_schedule_id) references classroom (classroom_id) ON DELETE cascade,
    constraint FK_Schedule_SubjectID foreign key (subject_schedule_id) references subject (subject_id) ON DELETE CASCADE,
    constraint FK_Schedule_TeacherID foreign key (teacher_schedule_id) references teacher (teacher_id) ON DELETE CASCADE,
    constraint FK_Schedule_CalendarID foreign key (calendar_schedule_id) references calendar (calendar_id) ON DELETE CASCADE,
    constraint CK_Schedule_Weekday CHECK (schedule_week_day between 1 AND 6)
);

CREATE TABLE if not exists attendance
(
    attendance_id        bigint primary key,
    pupil_attendance_id  bigint not null,
    class_attendance_id  bigint not null,
    lesson_attendance_id bigint not null,
    FOREIGN KEY (pupil_attendance_id) REFERENCES pupil (pupil_id),
    FOREIGN KEY (class_attendance_id) REFERENCES classroom (classroom_id),
    FOREIGN KEY (lesson_attendance_id) REFERENCES schedule (schedule_id)
);

CREATE TABLE if not exists academic_performance
(
    academic_performance_id        bigint primary key,
    pupil_academic_performance_id  bigint not null,
    class_academic_performance_id  bigint not null,
    lesson_academic_performance_id bigint not null,
    academic_performance_grade     int,
    FOREIGN KEY (pupil_academic_performance_id) REFERENCES pupil (pupil_id),
    FOREIGN KEY (class_academic_performance_id) REFERENCES classroom (classroom_id),
    FOREIGN KEY (lesson_academic_performance_id) REFERENCES schedule (schedule_id)
);

CREATE TABLE if not exists questions_from_users
(
    questions_from_users_id       bigint primary key,
    questions_from_users_question varchar(2000) not null,
    questions_from_users_response varchar(10000),
    questions_from_users_flag     boolean
);
