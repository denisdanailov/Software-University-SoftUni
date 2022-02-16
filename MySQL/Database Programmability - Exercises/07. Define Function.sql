DELIMITER $$
CREATE FUNCTION `ufn_is_word_comprised`(`set_of_letters` VARCHAR(50), `word` VARCHAR(50))
RETURNS TINYINT
DETERMINISTIC
BEGIN
RETURN LOWER(`word`) REGEXP LOWER(CONCAT('^[',`set_of_letters`,']+$'));
END
$$

SELECT ufn_is_word_comprised('itmiahfs', 'Sofia');
