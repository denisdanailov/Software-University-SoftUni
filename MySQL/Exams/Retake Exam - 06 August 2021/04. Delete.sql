DELETE g FROM games AS g LEFT JOIN games_categories AS gc ON gc.game_id = g.id
WHERE g.release_date IS NULL AND gc.category_id IS NULL;