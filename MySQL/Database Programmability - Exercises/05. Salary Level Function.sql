DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(salary DECIMAL(19, 4))
RETURNS VARCHAR(100)
DETERMINISTIC
BEGIN
DECLARE sal_level VARCHAR(7);
	IF salary < 30000 THEN SET sal_level := 'Low'; 
	ELSEIF salary >= 30000 AND salary <= 50000 THEN SET sal_level := 'Average';
	ELSEIF salary > 50000 THEN SET sal_level = 'High';
	END IF;
RETURN sal_level;
END
$$

