CREATE TABLE IF NOT EXISTS doctype
(
    id        SERIAL PRIMARY KEY,
    type_name VARCHAR(128)
);


CREATE TABLE IF NOT EXISTS authority
(
    id             SERIAL PRIMARY KEY,
    authority_name VARCHAR(128)

);

CREATE TABLE IF NOT EXISTS users
(
    id       BIGSERIAL PRIMARY KEY,
    name     VARCHAR(128) NOT NULL,
    surname  VARCHAR(128) NOT NULL,
    role     VARCHAR(30)  NOT NULL DEFAULT 'USER',
    email    VARCHAR(128) NOT NULL UNIQUE,
    password VARCHAR(15)  NOT NULL

);


CREATE TABLE IF NOT EXISTS document
(
    id            BIGSERIAL PRIMARY KEY,
    document_code VARCHAR(30)                       NOT NULL UNIQUE,
    description   TEXT                              NOT NULL,
    doctype_id    INTEGER REFERENCES doctype (id)   NOT NULL,
    issue_date    DATE                              NOT NULL,
    expiry_date   DATE                              NOT NULL,
    authority_id  INTEGER REFERENCES authority (id) NOT NULL,
    user_id       BIGINT REFERENCES users (id)      NOT NULL,
    deleted       BOOLEAN DEFAULT FALSE             NOT NULL

);