DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with(str_param VARCHAR(100))
BEGIN
SELECT `name` AS town_name FROM towns WHERE LOWER(SUBSTRING(`name`, 1, CHAR_LENGTH(str_param))) = LOWER(str_param) ORDER BY `name` ASC;
END
$$

DELIMITER ;
CALL usp_get_towns_starting_with('b');
