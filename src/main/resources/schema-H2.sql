-- Table: Brand
CREATE TABLE brand
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Table: CarMaker
CREATE TABLE car_maker
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NUL
);

-- Table: CarModel
CREATE TABLE car_model
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    car_maker_id BIGINT       NOT NULL,
    FOREIGN KEY (car_maker_id) REFERENCES car_maker (id) ON DELETE CASCADE
);

-- Table: CarVersion
CREATE TABLE car_version
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    version      VARCHAR(255) NOT NULL,
    car_maker_id BIGINT       NOT NULL,
    car_model_id BIGINT       NOT NULL,
    FOREIGN KEY (car_maker_id) REFERENCES car_maker (id) ON DELETE CASCADE,
    FOREIGN KEY (car_model_id) REFERENCES car_model (id) ON DELETE CASCADE
);

-- Table: Part
CREATE TABLE parts
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    description TEXT,
    price       DOUBLE,
    category    VARCHAR(255),
    brand       VARCHAR(255),
    model       VARCHAR(255),
    image_url   VARCHAR(255)
);

-- Table: UserEntity
CREATE TABLE users
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    username     VARCHAR(255) NOT NULL UNIQUE,
    password     VARCHAR(255) NOT NULL,
    name         VARCHAR(255),
    surname      VARCHAR(255),
    email        VARCHAR(255) NOT NULL UNIQUE,
    user_type    VARCHAR(50),
    date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_car_model_car_maker_id ON car_model (car_maker_id);
CREATE INDEX idx_car_version_car_model_id ON car_version (car_model_id);