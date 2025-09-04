CREATE DATABASE weatherdb;
USE weatherdb;

CREATE TABLE readings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    temperature INT,
    humidity INT,
    pressure INT,
    timestamp DATETIME
);
