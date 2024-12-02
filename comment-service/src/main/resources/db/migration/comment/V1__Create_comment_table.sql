CREATE TABLE comment (
    id SERIAL PRIMARY KEY,
    fundraiser_id INT NOT NULL,
    content TEXT NOT NULL,
    username VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);