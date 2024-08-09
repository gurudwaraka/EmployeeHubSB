CREATE TABLE if not exists employee_profiles (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20),
    job_role VARCHAR(255) NOT NULL,
    manager_id BIGINT,
    last_updated TIMESTAMP NOT NULL,
    last_modified_by VARCHAR(255) NOT NULL,
    image VARCHAR(255)
);