SELECT employee_id AS id , CONCAT(first_name, ' ', last_name) AS full_name, d.department_id, d.`name` FROM employees AS e 
JOIN departments AS d ON d.manager_id = e.employee_id 
ORDER BY id ASC
LIMIT 5;