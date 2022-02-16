DELIMITER $$
CREATE PROCEDURE usp_raise_salaries( department_name VARCHAR(100))
BEGIN
UPDATE employees AS e 
SET e.salary = e.salary * 1.05 
WHERE e.department_id = (SELECT d.department_id FROM departments AS d WHERE d.`name` = department_name);
END
$$

-- Вариант #2 на процедурата 

-- CREATE PROCEDURE usp_raise_salaries2( department_name VARCHAR(100))
-- BEGIN
-- UPDATE employees AS e INNER JOIN departments AS d ON e.department_id = d.department_id
-- SET salary = salary * 1.05 
-- WHERE d.`name` = department_name AND e.employee_id <> 0;
-- END
-- $$