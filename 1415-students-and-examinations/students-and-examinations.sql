# Write your MySQL query statement below

SELECT stu.student_id,
       stu.student_name,
       sub.subject_name,
       COUNT(e.subject_name) AS attended_exams
FROM students stu
CROSS JOIN subjects sub
LEFT JOIN examinations e
    ON stu.student_id = e.student_id
    AND sub.subject_name = e.subject_name
GROUP BY stu.student_id, stu.student_name, sub.subject_name
ORDER BY stu.student_id, sub.subject_name;