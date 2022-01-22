SELECT `first_name`, `last_name` FROM `employees`
WHERE LOCATE('ei', LOWER(`last_name`)) <> 0
ORDER BY `employee_id` ASC;

-- Вариант #2
SELECT `first_name`, `last_name` FROM `employees`
WHERE LOWER(`last_name`) LIKE '%ei%'
ORDER BY `employee_id` ASC;