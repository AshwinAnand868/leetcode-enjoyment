SELECT e.name as name, b.bonus as bonus
FROM employee e
LEFT JOIN
bonus b
ON e.empId = b.empId
WHERE b.bonus < 1000 or b.bonus IS NULL;