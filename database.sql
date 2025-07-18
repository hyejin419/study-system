use studysystem;

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255)
);

CREATE TABLE studies (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    description TEXT,
    creator_id BIGINT
);


CREATE TABLE study_applicant (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    study_id BIGINT
);

