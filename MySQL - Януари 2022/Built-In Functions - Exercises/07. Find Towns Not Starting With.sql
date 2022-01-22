SELECT * FROM `towns`
WHERE UPPER(SUBSTRING(`name`, 1, 1)) NOT IN ('R', 'B', 'D')
ORDER BY `name` ASC;