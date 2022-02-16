SELECT 
    g.name,
    IF(g.budget < 50000, 'Normal budget', 'Insufficient budget') AS budget_level,
    t.name,
    a.name
FROM
    games AS g
        LEFT JOIN
    teams AS t ON g.team_id = t.id
        LEFT JOIN
    offices AS o ON t.office_id = o.id
        LEFT JOIN
    addresses AS a ON o.address_id = a.id
		LEFT JOIN
	games_categories AS gc ON gc.game_id = g.id
WHERE g.release_date IS NULL AND gc.category_id IS NULL
ORDER BY g.name;