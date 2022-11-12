create table if not exists users (
user_id tidbigcode primary key,
user_login tstr100 not null,
user_password tstr200 not null,
user_status tstr20 not null,
user_link tstr100 default null
);

create table if not exists role (
role_id tidbigcode primary key,
role_name tstr50 not null
);

create table if not exists role_user (
roles_users_id tidbigcode primary key,
role_id tidbigcode not null,
user_id tidbigcode not null,
CONSTRAINT FK_Role FOREIGN KEY (role_id)
        REFERENCES role (role_id) ON DELETE CASCADE,
    CONSTRAINT FK_User FOREIGN KEY (user_id)
        REFERENCES users (user_id) ON DELETE CASCADE
);

create table if not exists parents (
parents_id tidbigcode primary key,
parents_name_mom tstr100,
parents_lastname_mom tstr100,
parents_patronymic_mom tstr100,
parents_name_dad tstr100,
parents_lastname_dad tstr100,
parents_patronymic_dad tstr100
);

create table if not exists subject (
subject_id tidbigcode primary key,
subject_name tstr100 not null
);

create table if not exists teacher (
teacher_id tidbigcode primary key,
user_teacher_id tidbigcode,
teacher_name tstr100 not null,
teacher_lastname tstr100 not null,
teacher_patronymic tstr100,
teacher_email tstr100,
teacher_qualification tstr100,
teacher_position tstr100,
FOREIGN KEY(user_teacher_id) REFERENCES users(user_id)
);

create table if not exists classroom (
classroom_id tidbigcode primary key,
teacher_classroom_id tidbigcode not null,
classroom_name tstr100 not null,
FOREIGN KEY(teacher_classroom_id) REFERENCES teacher(teacher_id)
);

create table if not exists pupil (
pupil_id tidbigcode primary key,
user_pupil_id tidbigcode,
pupil_name tstr100 not null,
pupil_lastname tstr100 not null,
pupil_patronymic tstr100 not null,
pupil_date_of_birthday tdate not null,
pupil_email tstr100,
pupil_personal_check tstr100,
classroom_pupil_id tidbigcode not null,
parents_pupil_id tidbigcode not null,
FOREIGN KEY(parents_pupil_id) REFERENCES parents(parents_id),
FOREIGN KEY(user_pupil_id) REFERENCES users(user_id),
FOREIGN KEY(classroom_pupil_id) REFERENCES classroom(classroom_id)
);

-- Календарь. Хранит ID семестра, дни недели и время лекций
CREATE TABLE if not exists calendar(
    calendar_id          tidbigcode primary key,
    calendar_semester  tinteger not null,
    calendar_week_day     tinteger not null,
    lesson_calendar_id	tidbigcode not null
    -- LessonTime  VARCHAR(20) not null
);

-- Расписание. Хранит пересечение всех всех таблиц
CREATE TABLE if not exists schedule(
    schedule_id          tidbigcode primary key,
    classroom_schedule_id     tidbigcode NOT NULL,-- CONSTRAINT FK_Schedule_ClassroomID REFERENCES dbo.Groups(ID),
    subject_schedule_id  tidbigcode NOT NULL, -- CONSTRAINT FK_Schedule_SubjectID REFERENCES dbo.Subjects(ID),
    teacher_schedule_id   tidbigcode NOT NULL,-- CONSTRAINT FK_Schedule_TeacherID REFERENCES dbo.Teachers(ID),
    schedule_week_day     tinteger NOT NULL, -- CONSTRAINT CK_Schedule_Weekday CHECK (WeekDay BETWEEN 1 AND 6),
    schedule_date      tdate not null,
    calendar_schedule_id	bigint not null,
    schedule_hometask    tstr2000,
    constraint FK_Schedule_ClassroomID foreign key(classroom_schedule_id) references classroom (classroom_id) ON DELETE cascade,
	constraint FK_Schedule_SubjectID foreign key(subject_schedule_id) references subject (subject_id) ON DELETE CASCADE,
    constraint FK_Schedule_TeacherID foreign key(teacher_schedule_id) references teacher (teacher_id) ON DELETE CASCADE,
	constraint FK_Schedule_CalendarID foreign key(calendar_schedule_id) references calendar (calendar_id) ON DELETE CASCADE,
    constraint CK_Schedule_Weekday CHECK (schedule_week_day between 1 AND 6)
);

CREATE TABLE if not exists attendance (
    attendance_id          tidbigcode primary key,
    pupil_attendance_id     tidbigcode not null,
    class_attendance_id		tidbigcode not null,
    lesson_attendance_id    tidbigcode not null,
    FOREIGN KEY(pupil_attendance_id) REFERENCES pupil(pupil_id),
    FOREIGN KEY(class_attendance_id) REFERENCES classroom(classroom_id),
	FOREIGN KEY(lesson_attendance_id) REFERENCES schedule(schedule_id)
);

CREATE TABLE if not exists academic_performance (
    academic_performance_id          tidbigcode primary key,
    pupil_academic_performance_id     tidbigcode not null,
    class_academic_performance_id		tidbigcode not null,
    lesson_academic_performance_id    tidbigcode not null,
    academic_performance_grade		tinteger,
    FOREIGN KEY(pupil_academic_performance_id) REFERENCES pupil(pupil_id),
    FOREIGN KEY(class_academic_performance_id) REFERENCES classroom(classroom_id),
	FOREIGN KEY(lesson_academic_performance_id) REFERENCES schedule(schedule_id)
);

CREATE TABLE if not exists questions_from_users (
    questions_from_users_id          tidbigcode primary key,
    questions_from_users_question	tstr2000 not null,
    questions_from_users_response	tstr10000,
    questions_from_users_flag		tboolean
);
