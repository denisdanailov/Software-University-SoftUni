select count(distinct c.id) from colonists as c join travel_cards as tc on tc.colonist_id = c.id join journeys as j on tc.journey_id = j.id
where j.purpose = 'Technical';