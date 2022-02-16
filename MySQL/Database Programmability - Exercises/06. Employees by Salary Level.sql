DELIMITER $$
CREATE FUNCTION `ufn_get_salary_level`(salary DECIMAL(19, 4)) 
RETURNS varchar(100)
DETERMINISTIC
BEGIN
DECLARE sal_level VARCHAR(7);
	IF salary < 30000 THEN SET sal_level = 'Low'; 
	ELSEIF salary >= 30000 AND salary <= 50000 THEN SET sal_level = 'Average';
	ELSEIF salary > 50000 THEN SET sal_level = 'High';
	END IF;
RETURN sal_level;
END
$$

CREATE PROCEDURE `usp_get_employees_by_salary_level`(sal_level VARCHAR(7))
BEGIN
SELECT first_name, last_name FROM employees WHERE LOWER(ufn_geufn_get_salary_levelt_salary_level(`salary`)) = LOWER(sal_level) ORDER BY first_name DESC, last_name DESC;
END
$$