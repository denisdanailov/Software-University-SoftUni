DELETE clients FROM clients LEFT JOIN courses ON clients.id = courses.client_id WHERE courses.id IS NULL AND CHAR_LENGTH(clients.full_name) > 3;
