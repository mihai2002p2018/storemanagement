CREATE DATABASE store;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);

CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    quantity INTEGER NOT NULL
);


INSERT INTO users(username, password, role) VALUES ('admin', '$2a$10$GQbOtVoPp3Q7pp/gDpKuAOT33biA1zayMGOMeSikRRGhUI9OQ15he', 'ROLE_ADMIN'); --pass in clear: admin.1234
INSERT INTO users(username, password, role) VALUES ('user', '$2a$10$krpn85c6p95WXTEHGZYY7ulMH13NDfHrs4RZ9byqLFezTzC1uKcCe', 'ROLE_USER');   --pass in clear: user.1234
