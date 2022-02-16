SELECT 
    CONCAT(e.first_name, ' ', e.last_name) AS full_name,
    s.name,
    a.name,
    e.salary
FROM
    employees AS e
        INNER JOIN
    stores AS s ON e.store_id = s.id
        INNER JOIN
    addresses AS a ON s.address_id = a.id
WHERE
	e.salary < 4000 
	AND a.name LIKE '%5%'
	AND CHAR_LENGTH(s.name) > 8
	AND RIGHT(e.last_name, 1) = 'n'; 