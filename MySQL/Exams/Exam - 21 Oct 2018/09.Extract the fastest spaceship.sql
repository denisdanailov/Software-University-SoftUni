select s.name as spaceship_name, sp.name as spaceport_name from spaceships as s join journeys as j on j.spaceship_id = s.id join spaceports as sp on j.destination_spaceport_id = sp.id
order by s.light_speed_rate desc
limit 1;