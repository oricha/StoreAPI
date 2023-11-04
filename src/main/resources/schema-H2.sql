CREATE TABLE CarMaker (
              id INT AUTO_INCREMENT PRIMARY KEY,
              name VARCHAR(255) NOT NULL,
              web VARCHAR(255)
);

CREATE TABLE CarModel (
              id INT AUTO_INCREMENT PRIMARY KEY,
              model VARCHAR(255) NOT NULL,
              year INT,
              carmaker_id INT,
              FOREIGN KEY (carmaker_id) REFERENCES CarMaker(id)
);

CREATE TABLE CarModelMotor
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    motor VARCHAR(255) NOT NULL ,
    FOREIGN KEY (carmodel_id) REFERENCES CarModel(id)

);

CREATE TABLE CarPart(
    id INT AUTO_INCREMENT PRIMARY KEY ,
    vin_number VARCHAR(255) NOT NUll,
    FOREIGN KEY (carmodelmotor_id) REFERENCES CarModelMotor(id)
);
