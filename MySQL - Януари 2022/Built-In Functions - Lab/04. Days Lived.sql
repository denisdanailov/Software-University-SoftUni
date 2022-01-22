select CONCAT(`first_name`, ' ', `last_name`) as 'Full Name', timestampdiff(day, `born`, `died`) as 'Days Lived' from `authors`
order by `id` asc;