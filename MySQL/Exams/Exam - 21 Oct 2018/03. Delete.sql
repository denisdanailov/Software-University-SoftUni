delete c from colonists as c left join travel_cards as tc on tc.colonist_id = c.id 
where tc.colonist_id is null;