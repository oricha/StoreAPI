CREATE TABLE CarMaker (
              id INT AUTO_INCREMENT PRIMARY KEY,
              name VARCHAR(255) NOT NULL,
              web VARCHAR(255)
);

CREATE TABLE CarModel (
              id INT AUTO_INCREMENT PRIMARY KEY,
              name VARCHAR(255) NOT NULL,
              year INT,
              carmaker_id INT,
              FOREIGN KEY (carmaker_id) REFERENCES CarMaker(id)
);