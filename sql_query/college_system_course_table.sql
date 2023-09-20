create database college_system;
use college_system;

drop table courses;
create table COURSES(
  ccode varchar(5) primary key,
  name varchar(30),
  duration int(3) check(duration>0),
  fee int(5) check(fee>0),
  PREREQUISITE varchar(100)
);

describe courses;

insert into courses(ccode, name, duration, fee, prerequisite) values
("C001","Math",50,10000," Algebra knowledge "),
("C002", 'Physics', 25, 4500, 'Calculus basics'),
("C003", 'Chemistry', 28, 4800, 'General science'),
("C004", 'English', 20, 3500, NULL),
("C005", 'History', 22, 3800, NULL);
select * from courses;