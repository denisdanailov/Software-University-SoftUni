DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value(sum DECIMAL(10, 4), interest DOUBLE, years INT)
RETURNS DECIMAL(19, 4)
DETERMINISTIC
BEGIN
RETURN sum * (POW((1 + interest), years));
END
$$

SELECT ufn_calculate_future_value(1000, 0.5, 5);