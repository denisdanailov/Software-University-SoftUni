UPDATE `employees`
SET `salary` = `salary` + (`salary` * 10/100)
WHERE `salary` IS NOT NULL;

SELECT `salary` FROM `employees`;