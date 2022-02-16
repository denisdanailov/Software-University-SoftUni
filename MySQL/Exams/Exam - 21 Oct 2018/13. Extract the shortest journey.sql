select j.id, p.name as planet_name, s.name as spaceport_name, j.purpose as journey_purpose from planets as p join spaceports as s on s.planet_id = p.id join journeys as j on j.destination_spaceport_id = s.id
group by j.id
order by timestampdiff(day, j.journey_start, journey_end)
limit 1;