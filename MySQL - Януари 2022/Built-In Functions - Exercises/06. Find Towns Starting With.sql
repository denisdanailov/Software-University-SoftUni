SELECT * FROM `towns`
WHERE LOWER(SUBSTRING(`name`, 1, 1)) IN ('m', 'k', 'b', 'e')
ORDER BY `name` ASC;