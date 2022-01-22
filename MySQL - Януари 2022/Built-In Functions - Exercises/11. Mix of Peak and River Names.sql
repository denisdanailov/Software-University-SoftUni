SELECT `peaks`.`peak_name`, `rivers`.`river_name`, LOWER(CONCAT(LEFT(`peaks`.`peak_name`, CHAR_LENGTH(`peaks`.`peak_name`) - 1), `rivers`.`river_name`)) AS 'mix' FROM `peaks`, `rivers`
WHERE LOWER(RIGHT(`peaks`.`peak_name`, 1)) = LOWER(LEFT(`rivers`.`river_name`, 1))
ORDER BY `mix` ASC;