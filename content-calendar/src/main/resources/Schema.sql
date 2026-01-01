CREATE TABLE IF NOT EXISTS Content(
    id SERIAL PRIMARY KEY,
    title VARCHAR(250) NOT NULL,
    description text,
    Status VARCHAR(250) NOT NULL,
    content_type VARCHAR(50) NOT NULL,
    date_created TIMESTAMP NOT NULL,
    date_updated TIMESTAMP,
    url VARCHAR(255)
    );


INSERT INTO Content(title, description, status, content_type, date_created)
VALUES ('My First Blog Post', 'A post about Spring Boot', 'IDEA', 'ARTICLE', CURRENT_TIMESTAMP);