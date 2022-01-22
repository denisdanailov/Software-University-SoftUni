CREATE OR REPLACE VIEW `v_employees_hired_after_2000` AS
SELECT `first_name`, `last_name` FROM `employees`
WHERE DATE(`hire_date`) >= '2001.01.01'
-- Вараиант #2: WHERE EXTRACT(YEAR FROM `hire_date`) > '2000';
ORDER BY `employee_id` ASC;  

SELECT * FROM `v_employees_hired_after_2000`;