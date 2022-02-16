DELIMITER **
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(num_value DECIMAL)
BEGIN
SELECT ah.first_name, ah.last_name FROM accounts AS a JOIN account_holders AS ah ON a.account_holder_id = ah.id
GROUP BY ah.id
HAVING SUM(a.balance) > num_value
ORDER BY ah.id;
END
**

CALL usp_get_holders_with_balance_higher_than(7000);