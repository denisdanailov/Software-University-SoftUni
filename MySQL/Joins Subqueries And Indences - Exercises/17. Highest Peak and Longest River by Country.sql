SELECT 
    c.country_name,
    MAX(p.elevation) AS highest_peak_elevation,
    MAX(r.length) AS longest_river_length
FROM
    countries AS c
        INNER JOIN
    mountains_countries AS mc ON c.country_code = mc.country_code
        INNER JOIN
    mountains AS m ON mc.mountain_id = m.id
        INNER JOIN
    peaks AS p ON m.id = p.mountain_id
        INNER JOIN
    countries_rivers AS cr ON c.country_code = cr.country_code
        INNER JOIN
    rivers AS r ON cr.river_id = r.id
GROUP BY c.country_code
ORDER BY highest_peak_elevation DESC , longest_river_length DESC , c.country_name ASC
LIMIT 5;