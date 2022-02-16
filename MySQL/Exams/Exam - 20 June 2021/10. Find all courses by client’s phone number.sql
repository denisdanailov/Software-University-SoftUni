DELIMITER **
CREATE FUNCTION udf_courses_by_client(phone_num VARCHAR(20))
RETURNS INT
DETERMINISTIC
BEGIN
RETURN (SELECT COUNT(co.id) FROM courses AS co JOIN clients AS cl ON co.client_id = cl.id WHERE cl.phone_number = phone_num); 
END
**

SELECT udf_courses_by_client ('(803) 6386812') as `count`; 