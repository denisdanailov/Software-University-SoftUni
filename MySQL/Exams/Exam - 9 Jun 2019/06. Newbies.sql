SELECT 
    id,
    concat(first_name, ' ', last_name) as full_name,
    concat('$', salary) as salary,
    started_on
FROM
    employees
WHERE
    salary >= 100000
        AND started_on >= '2018-01-01'
ORDER BY salary DESC , id;