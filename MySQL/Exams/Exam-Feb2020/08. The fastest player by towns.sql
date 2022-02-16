SELECT MAX(sd.speed) AS max_speed, tn.name AS town_name 
FROM players AS p 
RIGHT JOIN skills_data AS sd ON p.skills_data_id = sd.id 
RIGHT JOIN teams AS t ON p.team_id = t.id
RIGHT JOIN stadiums AS s ON t.stadium_id = s.id
RIGHT JOIN towns AS tn ON s.town_id = tn.id
WHERE NOT t.name = 'Devify'
GROUP BY tn.name
ORDER BY max_speed DESC, town_name ASC;