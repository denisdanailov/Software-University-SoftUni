SELECT e.employee_id, e.first_name, e.manager_id, (SELECT first_name FROM employees AS e1 WHERE e.manager_id = e1.employee_id) AS 'manager_name' FROM employees AS e
WHERE e.manager_id IN (3, 7)
ORDER BY e.first_name ASC;