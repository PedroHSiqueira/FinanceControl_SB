CREATE TABLE usuarios
(
    id         UUID PRIMARY KEY,
    username   VARCHAR(255) NOT NULL,
    password   varchar(255) NOT NULL,
    created_at TIMESTAMPTZ  NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ  NOT NULL DEFAULT NOW()
);