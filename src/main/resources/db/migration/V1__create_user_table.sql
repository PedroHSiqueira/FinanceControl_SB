CREATE TABLE Users
(
    id          UUID PRIMARY KEY,
    username    VARCHAR(255) NOT NULL UNIQUE,
    password    VARCHAR(255) NOT NULL,
    create_at   TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    update_at   TIMESTAMPTZ NOT NULL DEFAULT NOW()
);
