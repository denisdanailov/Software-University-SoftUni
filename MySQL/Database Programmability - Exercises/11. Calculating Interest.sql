DELIMITER $$
CREATE FUNCTION `ufn_calculate_future_value`(sum DECIMAL(10, 4), interest DOUBLE, years INT) 
RETURNS decimal(19,4)
DETERMINISTIC
BEGIN
RETURN sum * (POW((1 + interest), years));
END
$$

CREATE PROCEDURE usp_calculate_future_value_for_account(account_id INT, interest_rate DOUBLE(19, 4))
BEGIN
SELECT acc.id AS account_id, ah.first_name, ah.last_name, acc.balance AS current_balance, ufn_calculate_future_value(acc.balance, interest_rate, 5) AS balance_in_5_years 
FROM account_holders AS ah INNER JOIN accounts AS acc ON ah.id = acc.account_holder_id 
WHERE acc.id = account_id;
END
$$

CALL usp_calculate_future_value_for_account(1, 0.1);