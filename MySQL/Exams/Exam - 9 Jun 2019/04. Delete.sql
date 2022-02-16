delete e from employees as e left join employees_clients as ec on ec.employee_id = e.id
where ec.client_id is null; 
