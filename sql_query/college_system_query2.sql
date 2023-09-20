-- MODULE 4
-- 1) What is required to join two tables?
-- Both table must have at list one common column with same column name and same data type.

-- 2) What is meant by self-join?
-- Self join a table joined to it self.
-- SELECT column_name(s)
-- FROM table1 T1, table1 T2
-- WHERE condition;

-- 3) How do you qualify a column that is existing in two or more tables that are being joined?
-- Using table alias

-- 4) What is table alias? Is it stored anywhere?
-- Alias are the temporary name of a given table column for the purpose of a particular sql query. It is used when the name of a column or table
-- is used other than the original name, but the modified name is temporary.

-- 5)What happens when you join two tables without any condition?
-- It result a cross join. In corss join each row of first table combine with every row of from the second table, resulting a combitation of all 
-- possible pair from the two table.


-- 6) Display rollno, student name, pay date and amount paid.
SELECT S.ROLLNO, S.NAME, P.AMOUNT, P.DP
FROM STUDENT AS S
INNER JOIN PAYMENTS AS P ON S.ROLLNO = P.ROLLNO;

-- 7) Display rollno , student name, batch code ,  stdate of batch  and faculty code.
SELECT S.ROLLNO, S.NAME, S.BCODE, B.FAACODE, B.STDATE
FROM STUDENT AS S
INNER JOIN BATCHES AS B ON S.BCODE = B.BCODE;

-- 8) Display rollno , student name, course name  ,  stdate  of batch  and faculty code.
SELECT S.ROLLNO, S.NAME AS STUDENTNAME, C.NAME AS CourseName, B.STDATE, B.FAACODE 
FROM STUDENT AS S 
JOIN batches AS B ON  S.BCODE = B.BCODE
JOIN COURSES AS C ON B.CCODE = C.CCODE;

-- 9) Display rollno , student name, course name , faculty code and enddate of all batches that were completed.
SELECT S.ROLLNO, S.NAME AS StudentName, C.NAME AS CourseName, B.FAACODE, B.ENDDATE
FROM STUDENT AS S
JOIN BATCHES AS B ON S.BCODE = B.BCODE
JOIN COURSES AS C ON B.CCODE = C.CCODE
WHERE B.ENDDATE IS NOT NULL;

-- 10) Display students who have got more number of characters in name than the student with roll number 10.
SELECT S.ROLLNO, S.NAME AS StudentName, C.NAME AS CourseName, B.FAACODE, B.ENDDATE
FROM STUDENT AS S
JOIN BATCHES AS B ON S.BCODE = B.BCODE
JOIN COURSES AS C ON B.CCODE = C.CCODE
WHERE B.ENDDATE IS NOT NULL;

-- 11) Display rollno, student name, email , pay date and amount paid.
SELECT S.ROLLNO, S.NAME AS StudentName, S.EMAIL, P.DP, P.AMOUNT
FROM STUDENT AS S
JOIN PAYMENTS AS P ON S.ROLLNO = P.ROLLNO;

-- 12) In previous query include the details of student who haven’t paid anything so far.
SELECT S.ROLLNO, S.NAME AS StudentName, S.EMAIL, P.DP, P.AMOUNT
FROM STUDENT AS S
LEFT JOIN PAYMENTS AS P ON S.ROLLNO = P.ROLLNO
WHERE P.AMOUNT IS NULL OR P.AMOUNT = 0;

-- 13) Display the details of students who have paid nothing so far.
SELECT S.ROLLNO, S.NAME AS StudentName, S.EMAIL
FROM STUDENTS AS S
LEFT JOIN PAYMENTS AS P ON S.ROLLNO = P.ROLLNO
WHERE P.AMOUNT IS NULL;



