-- Drop tables if they exist
DROP TABLE IF EXISTS articles;
DROP TABLE IF EXISTS sections;

-- Create sections table
CREATE TABLE sections (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Create articles table
CREATE TABLE articles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    date TIMESTAMP NOT NULL,
    section_id BIGINT,
    FOREIGN KEY (section_id) REFERENCES sections(id)
); 