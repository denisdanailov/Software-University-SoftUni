select s.name, s.manufacturer
from spaceships as s join journeys as j on j.spaceship_id = s.id join travel_cards as tc on tc.journey_id = j.id join colonists as c on tc.colonist_id = c.id
where tc.job_during_journey = 'Pilot' and timestampdiff(year,c.birth_date, '2019-01-01') < 30
group by s.id
order by s.name;