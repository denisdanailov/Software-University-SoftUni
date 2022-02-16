DELIMITER **
CREATE PROCEDURE udp_find_playmaker(min_dribble_points INT, team_name VARCHAR(45))
BEGIN
SELECT CONCAT(p.first_name, ' ', p.last_name) AS full_name, p.age, p.salary, sd.dribbling, sd.speed, t.name AS team_name 
FROM players AS p INNER JOIN skills_data AS sd ON p.skills_data_id = sd.id INNER JOIN teams AS t ON p.team_id = t.id
WHERE t.name = team_name AND sd.dribbling > min_dribble_points AND sd.speed > (SELECT AVG(sd.speed) FROM skills_data AS sd JOIN players AS p ON sd.id = p.skills_data_id)
ORDER BY sd.speed DESC
LIMIT 1;
END
**

DELIMITER ;
-- Average само за ентритата реферирани от таблицата players
SELECT AVG(sd.speed) FROM skills_data AS sd JOIN players AS p ON sd.id = p.skills_data_id;
-- Average за всички ентрита 
SELECT AVG(sd.speed) FROM skills_data AS sd;
