DELIMITER **
CREATE FUNCTION udf_top_paid_employee_by_store(store_name VARCHAR(50))
RETURNS VARCHAR(1000)
DETERMINISTIC
BEGIN
DECLARE full_name VARCHAR(1000);
SET full_name = (SELECT CONCAT(e.first_name,' ', e.middle_name,'. ', e.last_name,' works in store for ', TIMESTAMPDIFF(YEAR,e.hire_date, '2020-10-18'),' years') FROM stores AS s JOIN employees AS e ON e.store_id = s.id WHERE s.name = store_name ORDER BY e.salary DESC LIMIT 1);	
RETURN full_name;
END
**
