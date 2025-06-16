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
    id VARCHAR(36) PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    description TEXT,
    image_url1 VARCHAR(255),
    image_url2 VARCHAR(255),
    image_url3 VARCHAR(255),
    content TEXT NOT NULL,
    date_published TIMESTAMP NOT NULL,
    date_updated TIMESTAMP,
    section_id BIGINT,
    FOREIGN KEY (section_id) REFERENCES sections(id)
); 