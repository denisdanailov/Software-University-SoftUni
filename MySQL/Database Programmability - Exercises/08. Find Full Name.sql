DELIMITER $$
CREATE PROCEDURE usp_get_holders_full_name()
BEGIN
SELECT CONCAT(ah.first_name, ' ', ah.last_name) AS full_name FROM account_holders AS ah ORDER BY full_name ASC, id ASC;
END
$$

CALL usp_get_holders_full_name();