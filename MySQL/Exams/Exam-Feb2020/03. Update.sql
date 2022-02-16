UPDATE `coaches` AS `c`
SET `c`.`coach_level` = `c`.`coach_level` + 1
WHERE (SELECT COUNT(*) FROM `players_coaches` WHERE `coach_id` = `c`.`id`) >= 1 AND UPPER(SUBSTRING(`first_name`, 1, 1)) = 'A' AND `c`.`id` <> 0;
