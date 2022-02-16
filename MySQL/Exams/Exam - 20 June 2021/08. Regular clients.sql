SELECT c.full_name, COUNT(DISTINCT ca.id) AS count_of_cars, SUM(co.bill) FROM clients AS c JOIN courses AS co ON c.id = co.client_id JOIN cars AS ca ON co.car_id = ca.id
WHERE LOWER(SUBSTRING(c.full_name, 2, 1)) = 'a'
GROUP BY c.id
HAVING count_of_cars > 1
ORDER BY c.full_name;