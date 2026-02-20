INSERT INTO countries (id, name, code) VALUES (1, 'Ukraine', 'UKR');
INSERT INTO countries (id, name, code) VALUES (2, 'Russia', 'RUS');

INSERT INTO conflicts (id, name, start_date, status, description)
VALUES (1, 'Ukraine Conflict', '2022-02-24', 'ACTIVE', 'Ongoing war in Ukraine');

INSERT INTO conflict_countries (conflict_id, country_id) VALUES (1, 1);
INSERT INTO conflict_countries (conflict_id, country_id) VALUES (1, 2);
