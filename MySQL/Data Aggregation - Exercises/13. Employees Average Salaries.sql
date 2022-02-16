CREATE TABLE `high_paid_employees` AS
SELECT * FROM employees
WHERE salary > 30000;

ALTER TABLE `high_paid_employees`
ADD CONSTRAINT `pk_high_paid_employees`
PRIMARY KEY `high_paid_employees`(`employee_id`);

DELETE FROM `high_paid_employees`
WHERE manager_id = 42 AND employee_id <> 0; 

UPDATE `high_paid_employees`
SET `salary` = `salary` + 5000
WHERE department_id = 1 AND employee_id <> 0;

SELECT department_id, AVG(salary) FROM `high_paid_employees`
GROUP BY `department_id`
ORDER BY `department_id` ASC;
