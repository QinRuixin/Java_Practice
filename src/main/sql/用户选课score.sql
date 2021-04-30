create table students
(
    s_id       int primary key,
    s_name     varchar(10),
    s_birthday date,
    s_sex      varchar(2)
);

create table courses
(
    c_id   int primary key,
    c_name varchar(10),
    t_id   int
);

create table teachers
(
    t_id   int primary key,
    t_name varchar(10)
);

drop table if exists scores;
create table scores
(
    s_id    int,
    c_id    int,
    s_score int
);

insert into students (s_id, s_name, s_birthday, s_sex)
values (1, '赵雷', '1990-01-01', '男'),
       (2, '钱电', '1990-12-21', '男'),
       (3, '孙风', '1990-05-20', '男'),
       (4, '李云', '1990-08-06', '男'),
       (5, '周梅', '1991-12-01', '女'),
       (6, '吴兰', '1992-03-01', '女');

insert into courses (c_id, c_name, t_id)
values (1, '英语', 2),
       (2, '数学', 1),
       (3, '语文', 3);

insert into teachers(t_id, t_name)
values (1, '张三'),
       (2, '李四'),
       (3, '王五');

insert into scores (s_id, c_id, s_score)
values (1, 1, 80),
       (1, 2, 90),
       (1, 3, 99),
       (2, 1, 70),
       (2, 3, 60),
       (3, 2, 80),
       (3, 3, 80),
       (4, 1, 50),
       (4, 2, 30),
       (4, 3, 20),
       (5, 1, 76),
       (6, 1, 31),
       (6, 3, 34);
