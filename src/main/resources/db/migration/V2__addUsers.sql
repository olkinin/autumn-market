DROP TABLE IF EXISTS buyers CASCADE;
CREATE TABLE buyers(id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO buyers(name) VALUES('Irina'),('Olga'),('Ivan');