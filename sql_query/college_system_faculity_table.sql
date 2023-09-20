use college_system;


create table FACULITY(
 faacode varchar(5) primary key,
 name varchar(30),
 qual varchar(30),
 exp varchar(100)
);

describe faculity;

insert into faculity(faacode, name, qual, exp) values
('F001', 'John Smith', 'Ph.D. in Physics', '10 years of teaching physics at university level.'),
('F002', 'Mary Johnson', 'M.A. in Literature', '8 years of teaching literature and creative writing.'),
('F003', 'David Lee', 'M.Sc. in Chemistry', '15 years of research and teaching in chemistry.'),
('F004', 'Sarah White', 'B.A. in English', '3 years of teaching introductory English courses.'),
('F005', 'James Brown', 'Ph.D. in History', '12 years of history research and university lecturing.');

select * from faculity;