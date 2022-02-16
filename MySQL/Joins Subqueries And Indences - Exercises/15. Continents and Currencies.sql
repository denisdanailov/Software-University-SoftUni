SELECT 
    c.continent_code,
    c.currency_code,
    COUNT(c.country_code) AS 'currancy_usage'
FROM
    countries AS c
GROUP BY c.continent_code , c.currency_code
HAVING `currancy_usage` > 1
    AND `currancy_usage` = (SELECT 
        COUNT(*) AS `most_used_curr`
    FROM
        countries AS c1
    WHERE
        c1.continent_code = c.continent_code
    GROUP BY c1.currency_code
    ORDER BY most_used_curr DESC 
    LIMIT 1)
ORDER BY c.continent_code , c.currency_code;