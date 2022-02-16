DELIMITER &&
CREATE PROCEDURE usp_raise_salary_by_id(id INT)
BEGIN
	START TRANSACTION;
    UPDATE employees SET salary = salary * 1.05 WHERE employee_id = id;
    IF id <= 0 AND id > 293 
    THEN ROLLBACK;
    ELSE 
    COMMIT; 
    END IF;
END
&&
