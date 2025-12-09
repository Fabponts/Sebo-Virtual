CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    address VARCHAR(100) NOT NULL
);

CREATE TABLE books  (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
    author VARCHAR(50) NOT NULL,
    sinopse VARCHAR(500) NOT NULL,
    genre VARCHAR(20) NOT NULL,
    publisher VARCHAR(30) NOT NULL
);

CREATE TABLE ad (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    book_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    book_condition VARCHAR(20) NOT NULL,
    publisher VARCHAR(30) NOT NULL,
    ad_date DATE NOT NULL,
    ad_status VARCHAR(20) NOT NULL,

    FOREIGN KEY (book_id) REFERENCES books(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);
