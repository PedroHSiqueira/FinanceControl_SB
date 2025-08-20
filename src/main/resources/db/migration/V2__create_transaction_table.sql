CREATE TABLE Transactions
(
    id          BIGSERIAL PRIMARY KEY,
    description VARCHAR(100)   NOT NULL,
    amount      NUMERIC(15, 2) NOT NULL,
    date        TIMESTAMP      NOT NULL,
    type        VARCHAR(50),
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_id     UUID NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES Users (id) ON DELETE CASCADE
);
