DROP TABLE IF EXISTS users;

CREATE TABLE users (
                       id INT AUTO_INCREMENT  PRIMARY KEY,
                       username VARCHAR(250) NOT NULL,
                       email varchar(250) NOT NULL,
                       password VARCHAR(250) NOT NULL
);

INSERT INTO users (username, password, email) VALUES
('Aliko', 'Dangote', 'aliko@dangote.eu'),
('Bill', 'Gates', 'bill@gates.eu'),
('Folrunsho', 'Alakija', 'folrunsho@alkija.eu');