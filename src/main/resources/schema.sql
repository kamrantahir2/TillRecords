DROP TABLE IF EXISTS tills;

CREATE TABLE IF NOT EXISTS tills (
    id SERIAL PRIMARY KEY NOT NULL,
    date_time VARCHAR(50),
    coins_and_five_pounds NUMERIC(5, 2),
    remaining_notes NUMERIC(5, 2),
    over_under NUMERIC(5, 2)
);