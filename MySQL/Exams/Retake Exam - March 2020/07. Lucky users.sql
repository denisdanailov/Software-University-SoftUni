SELECT CONCAT(u.id, ' ', u.username) AS id_username, u.email FROM users as u JOIN users_photos AS up ON u.id = up.user_id JOIN photos AS p ON up.photo_id = p.id
WHERE up.user_id = up.photo_id; 