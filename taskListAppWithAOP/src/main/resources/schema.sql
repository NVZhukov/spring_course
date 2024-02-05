create table tasks (
                         id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         description VARCHAR(500) NOT NULL,
                         status VARCHAR(50),
                         created TIMESTAMP
);