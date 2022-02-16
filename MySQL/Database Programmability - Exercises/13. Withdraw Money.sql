DELIMITER $$
CREATE PROCEDURE usp_withdraw_money(account_id INT, money_amount DECIMAL(19, 4))
BEGIN
START TRANSACTION;
    UPDATE accounts SET balance = balance - money_amount WHERE accounts.id = account_id;
    IF money_amount < 0 OR (SELECT acc.balance FROM accounts AS acc WHERE acc.id = account_id) < 0 THEN ROLLBACK;
    END IF;
COMMIT;
END
$$

DELIMITER ;
CALL usp_withdraw_money(1, -124);
SELECT * FROM accounts WHERE id = 1;