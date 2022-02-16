DELIMITER **
CREATE FUNCTION udf_users_photos_count(username VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
RETURN (SELECT COUNT(up.photo_id) FROM users_photos AS up JOIN users AS u ON up.user_id = u.id WHERE u.username = username);
END
**

SELECT udf_users_photos_count('ssantryd') AS photosCount;