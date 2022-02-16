select p.name as planet_name, s.name as spaceport_name from planets as p join spaceports as s on s.planet_id = p.id join journeys as j on j.destination_spaceport_id = s.id
where j.purpose = 'Educational'
order by s.name desc;