select p.name as planet_name, count(j.id) as journeys_count from planets as p join spaceports as s on s.planet_id = p.id join journeys as j on j.destination_spaceport_id = s.id
group by p.id
order by journeys_count desc, planet_name;
