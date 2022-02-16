DELIMITER &&
CREATE PROCEDURE usp_get_employees_salary_above(compare_salary DECIMAL(10, 4))
BEGIN
SELECT first_name, last_name FROM employees WHERE salary >= compare_salary ORDER BY first_name ASC, last_name ASC, employee_id ASC;
END
&&

DELIMITER ;
CALL usp_get_employees_salary_above(45000);
