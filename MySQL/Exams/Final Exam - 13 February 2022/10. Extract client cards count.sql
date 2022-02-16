DELIMITER **
CREATE FUNCTION udf_customer_products_count(`name` VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
RETURN (SELECT COUNT(DISTINCT op.product_id) FROM customers AS `c` LEFT JOIN orders AS `o` ON o.customer_id = c.id LEFT JOIN orders_products AS `op` ON op.order_id = o.id WHERE c.first_name = name);
END
**

SELECT c.first_name,c.last_name, udf_customer_products_count('Shirley') as `total_products` FROM customers c
WHERE c.first_name = 'Shirley';
