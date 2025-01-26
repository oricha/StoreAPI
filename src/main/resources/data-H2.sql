INSERT INTO car_model (id, name, year, car_maker_id)
VALUES (5789790, 'Corolla', 2020, 144), -- Toyota
       (5789791, 'Civic', 2021, 58),    -- Honda
       (5789792, 'Model S', 2023, 140), -- Tesla
       (5789793, 'Golf', 2022, 152); -- Volkswagen

INSERT INTO car_version (id, name, version, car_maker_id, car_model_id)
VALUES (10001, 'Corolla LE', '1.8L Hybrid', 144, 5789790),          -- Corolla version
       (10002, 'Corolla SE', '2.0L Gasoline', 144, 5789790),
       (10003, 'Civic Sport', '1.5L Turbo', 58, 5789791),           -- Civic version
       (10004, 'Model S Long Range', 'Electric AWD', 140, 5789792), -- Tesla Model S
       (10005, 'Golf GTI', '2.0L Turbo', 152, 5789793); -- Golf version
INSERT INTO parts (id, name, description, price, category, brand, model, image_url)
VALUES (1, 'Brake Pads', 'High-performance brake pads for Corolla LE.', 49.99, 'Brakes', 'Toyota', 'Corolla',
        'https://example.com/brake-pads.jpg'),
       (2, 'Oil Filter', 'Premium oil filter for Civic Sport.', 19.99, 'Filters', 'Honda', 'Civic',
        'https://example.com/oil-filter.jpg'),
       (3, 'Windshield Wipers', 'Durable wipers for Tesla Model S.', 29.99, 'Accessories', 'Tesla', 'Model S',
        'https://example.com/windshield-wipers.jpg'),
       (4, 'Alloy Wheels', 'Stylish 18-inch alloy wheels for Golf GTI.', 399.99, 'Wheels', 'Volkswagen', 'Golf',
        'https://example.com/alloy-wheels.jpg'),
       (5, 'Air Filter', 'Replacement air filter for Corolla SE.', 24.99, 'Filters', 'Toyota', 'Corolla',
        'https://example.com/air-filter.jpg');
INSERT INTO category (name, icon, part_count)
VALUES ('Air conditioning-heating system/radiators', 'icon-air-conditioning', 797),
       ('Body/body parts/hook', 'icon-body-parts', 245),
       ('Brake system', 'icon-brake-system', 230),
       ('Cabin/interior', 'icon-cabin', 1040),
       ('Devices/switches/electronic system', 'icon-devices', 1217),
       ('Door', 'icon-door', 456),
       ('Engine', 'icon-engine', 70),
       ('Exterior front body parts', 'icon-exterior-front', 476),
       ('Exterior rear body parts', 'icon-exterior-rear', 305),
       ('Front axle', 'icon-front-axle', 232),
       ('Fuel mixture system', 'icon-fuel', 37),
       ('Gas exhaust system', 'icon-exhaust', 0),
       ('Gearbox/clutch/transmission', 'icon-gearbox', 32),
       ('Glass', 'icon-glass', 27),
       ('Headlight/headlamp washing/cleaning system', 'icon-headlight', 88),
       ('Lighting system', 'icon-lighting', 267),
       ('Other parts', 'icon-other', 117),
       ('Rear axle', 'icon-rear-axle', 291),
       ('Wheels/tires/caps', 'icon-wheels', 72);
