delimiter **
create procedure udp_clientinfo(full_name varchar(100))
begin
select cl.full_name, cl.age, ba.account_number, concat('$', ba.balance) as 'balance' from clients as cl join bank_accounts as ba on ba.client_id = cl.id where cl.full_name = full_name;
end
**

CALL udp_clientinfo('Hunter Wesgate');