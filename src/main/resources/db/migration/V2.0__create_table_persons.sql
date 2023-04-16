CREATE TABLE persons
(
    id              UUID PRIMARY KEY,
    name            VARCHAR(100) NOT NULL,
    date_of_birth   DATE NOT NULL,
    document        VARCHAR(14) NOT NULL,
    type            VARCHAR(10) NOT NULL,
    mail            VARCHAR(100) NOT NULL
);