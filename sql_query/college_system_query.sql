use college_student;

-- 1) Display records from students (Batch-wise total no.of students exists)

select bcode ,count(*) as totalst 
from student 
group by bcode;

-- 2) Display total payment paid by all students from payment table student-wise

SELECT ROLLNO, SUM(AMOUNT) AS TotalPayment
FROM PAYMENTS
GROUP BY ROLLNO;

-- 3) Display total no.of records from Payment table
select count(rollno) from payments;

-- 4) Display total no.fo records from payment table, by eliminating duplicate student No
select count(distinct rollno) as total_unique from payments;

-- 5) Display the ccode, max(stdate) from batches table.
select max(STDATE) as max_date from batches;

-- 6) Display max. fee from Course table. 
select max(amount) as max_amount from payments;

-- 7) Display max. fee from Course table w.r.t. Ccode 
select ccode , max(fee) as maxfee from COURSES group by ccode;

-- 8) Display total courses from batches table which are started in last 3 months
select count(distinct ccode) as totalcourse 
from batches
where stdate >= DATE_SUB(NOW(), INTERVAL 3 MONTH);

-- 9) Display all courses from batches table w.r.t. Ccode (min 2 entries required)
select name as course_name from courses group by ccode;

-- 10) Display all records from batches table, which courses are started last 3 months 
-- and min. 2 records to be entered. 
select * from batches where stdate >= DATE_SUB(NOW(), INTERVAL 3 MONTH);

-- 11) Display information from course_faculty table, as which faculty taking how many courses in ascending order w.r.t. Count
select faacode,  count(ccode) as course_count from faculity group by faacode order by course_count asc;


-- Module 2
-- 2) Select count(*) from students;  Is it a valid query.
select count(*) from student;

-- 4) Display ROLLNO of students who have paid for more than twice.
select rollno, count(rollno) as count_roll from payments group by rollno
having count(rollno)>1;

-- 5) Display average time taken for subject ORA.
select avg(duration) as avg_time from courses;
SELECT AVG(duration) AS AvgTimeTaken
FROM courses
WHERE name = 'ORA';

-- 6) Display faculty who can take more than 2 courses.
select faacode, count(faacode) as count_faculity from faculity group  by faacode having count(faacode)>2;

-- 7) Display least course fee.
select name, fee as min_fee from courses order by fee asc limit 1;

-- 8) Display the number of months between first and last batches of course Java.
SELECT TIMESTAMPDIFF(MONTH, MIN(STDATE), MAX(STDATE)) AS MonthsBetween
FROM BATCHES
WHERE CCODE = 'Java';

-- 9) Display Year, course and number of batches of that course.

-- 11) Display the number of students joined in each month.
SELECT EXTRACT(MONTH FROM DJ) AS Month, COUNT(*) AS StudentsJoined
FROM STUDENT
GROUP BY EXTRACT(MONTH FROM DJ)
ORDER BY Month;

-- 12) Display the number of students joined in each month  of the current year.
SELECT MONTH(DJ) AS Month, COUNT(*) AS StudentsJoined
FROM STUDENT
WHERE YEAR(DJ) = YEAR(CURDATE())
GROUP BY MONTH(DJ)
ORDER BY Month;

-- Module 3
-- 1) Display all matching records from batches and course table.
select * from batches
inner join courses
on batches.ccode = courses.ccode;

-- 2) Display matching/unmatching records from batches and courses table.
-- SELECT * FROM BATCHES FULL OUTER JOIN COURSE ON BATCHES.CCODE = COURSE.CCODE;

-- 3) Display all matching records ascending order of stdate
SELECT *
FROM BATCHES
INNER JOIN COURSES ON BATCHES.CCODE = COURSES.CCODE
ORDER BY BATCHES.STDATE ASC;

-- 4) Display all matching and unmatching records from batches, courses and faculty table. 
-- SELECT * FROM BATCHES 
-- LEFT JOIN COURSES ON BATCHES.CCODE = COURSES.CCODE
-- union ALL


