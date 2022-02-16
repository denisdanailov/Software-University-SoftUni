UPDATE addresses
SET country = 'Blocked'
WHERE UPPER(SUBSTRING(country, 1, 1)) = 'B' AND id <> 0;

UPDATE addresses
SET country = 'Test'
WHERE UPPER(SUBSTRING(country, 1, 1)) = 'T' AND id <> 0;

UPDATE addresses 
SET country = 'In Progress'
WHERE UPPER(SUBSTRING(country, 1, 1)) = 'P' AND id <> 0;

-- Вариант #2 
UPDATE addresses AS a
SET a.country = (CASE 
					WHEN a.country LIKE 'B%' THEN 'Blocked'
                    WHEN a.country LIKE 'T%' THEN 'Test'
                    WHEN a.country LIKE 'P%' THEN 'In Progress'
                    ELSE a.country
				 END)
WHERE a.id <> 0;