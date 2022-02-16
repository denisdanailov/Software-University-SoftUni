SELECT 
    employees.employee_id,
    employees.job_title,
    employees.address_id,
    addresses.address_text
FROM
    employees
        INNER JOIN
    addresses ON employees.address_id = addresses.address_id
ORDER BY employees.address_id ASC
LIMIT 5;