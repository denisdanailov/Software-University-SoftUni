select title from books
where substring(title, 1, 3) = 'The'
order by id asc;