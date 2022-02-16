SELECT 
    job_during_journey AS job_name
FROM
    travel_cards
WHERE
    journey_id = (SELECT 
            j.id
        FROM
            journeys AS j
                JOIN
            travel_cards AS tc ON tc.journey_id = j.id
        GROUP BY j.id
        ORDER BY TIMESTAMPDIFF(DAY,
            j.journey_start,
            journey_end) DESC
        LIMIT 1)
GROUP BY job_during_journey
ORDER BY COUNT(colonist_id)
LIMIT 1;