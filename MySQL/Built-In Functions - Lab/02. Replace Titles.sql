select insert(title, 1, 3, repeat('*', 3)) as 'title' from books
where substring(title, 1, 3) = 'The'
order by id asc;