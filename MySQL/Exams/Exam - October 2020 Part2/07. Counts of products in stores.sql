SELECT s.name, COUNT(ps.product_id) AS 'product_count', ROUND(AVG(p.price), 2) AS 'avg' FROM stores AS s LEFT JOIN products_stores AS ps ON ps.store_id = s.id LEFT JOIN products AS p ON ps.product_id = p.id
GROUP BY s.id
ORDER BY product_count DESC, avg DESC, s.id;