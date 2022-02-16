SELECT 
    branches.name, COUNT(cards.id) AS 'count_of_cards'
FROM
    branches
        LEFT JOIN
    employees ON employees.branch_id = branches.id
        LEFT JOIN
    employees_clients ON employees_clients.employee_id = employees.id
        LEFT JOIN
    clients ON employees_clients.client_id = clients.id
        LEFT JOIN
    bank_accounts ON bank_accounts.client_id = clients.id
        LEFT JOIN
    cards ON cards.bank_account_id = bank_accounts.id
GROUP BY branches.id
ORDER BY count_of_cards DESC , branches.name;