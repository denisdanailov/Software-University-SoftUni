INSERT INTO travel_cards(card_number, job_during_journey, colonist_id, journey_id)
select 
(case when birth_date > '1980-01-01' THEN concat(year(birth_date),day(birth_date),left(ucn, 4)) ELSE concat(year(birth_date),day(birth_date),right(ucn, 4)) END),
(case when id % 2 = 0 then 'Pilot' when id % 3 = 0 then 'Cook' else 'Engineer' END),
id,
substring(ucn, 1, 1)
from colonists 
where id between 96 and 100;