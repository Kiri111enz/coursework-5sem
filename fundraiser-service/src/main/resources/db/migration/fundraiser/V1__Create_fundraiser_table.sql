CREATE TABLE fundraiser (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    username VARCHAR(255) NOT NULL,
    money_goal DECIMAL(15, 2) NOT NULL,
    money_current DECIMAL(15, 2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);