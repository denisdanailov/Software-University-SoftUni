delimiter **
create function udf_client_cards_count(name varchar(30))
returns int
deterministic
begin
return (select count(ca.id) as cards from clients as cl left join bank_accounts AS ba on ba.client_id = cl.id left join cards as ca on ca.bank_account_id = ba.id where cl.full_name = name group by cl.id);
end
**
SELECT c.full_name, udf_client_cards_count('Baxy David') as `cards` FROM clients c
WHERE c.full_name = 'Baxy David';

