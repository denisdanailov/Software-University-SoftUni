SELECT 
    a.`name`,
    (CASE
        WHEN
            HOUR(co.`start`) >= 6
                AND HOUR(co.`start`) <= 20
        THEN
            'Day'
        ELSE
            'Night'
    END) AS day_time,
    co.bill,
    cl.full_name,
    ca.make,
    ca.model,
    cat.`name` AS category_name
FROM
    courses AS co
        LEFT JOIN
    addresses AS a ON co.from_address_id = a.id
        LEFT JOIN
    cars AS ca ON co.car_id = ca.id
        LEFT JOIN
    categories AS cat ON ca.category_id = cat.id
        LEFT JOIN
    clients AS cl ON co.client_id = cl.id
GROUP BY co.id
ORDER BY co.id;