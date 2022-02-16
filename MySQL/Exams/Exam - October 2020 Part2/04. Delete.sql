DELETE e1 FROM employees AS e1 LEFT JOIN employees AS e2 ON e1.manager_id = e2.id 
WHERE e2.id IS NOT NULL AND e1.salary >= 6000;