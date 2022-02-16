DELIMITER ##
CREATE FUNCTION ufn_count_employees_by_town(town_name VARCHAR(100)) 
RETURNS INT
DETERMINISTIC
BEGIN
DECLARE employees_count INT;
SET employees_count := (SELECT COUNT(e.employee_id) FROM employees AS e INNER JOIN addresses AS a ON e.address_id = a.address_id INNER JOIN towns AS t ON a.town_id = t.town_id WHERE t.`name` = town_name);
RETURN employees_count;
END
##


