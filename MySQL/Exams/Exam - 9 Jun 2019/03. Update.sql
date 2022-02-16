DELIMITER **
CREATE FUNCTION udf_least_clients_employee()
RETURNS INT
DETERMINISTIC
BEGIN
RETURN (select ec.employee_id from employees_clients AS ec group by ec.employee_id order by count(ec.client_id) ASC, ec.employee_id ASC limit 1);
END
**

UPDATE employees_clients 
SET 
    employee_id = UDF_LEAST_CLIENTS_EMPLOYEE()
WHERE
    employee_id = client_id;

