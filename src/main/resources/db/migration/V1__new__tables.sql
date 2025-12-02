CREATE TABLE users (
    id Long PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(20) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    address VARCHAR (100) NOT NULL
)
CREATE TABLE books(
    id Long PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    author VARCHAR(50) NOT NULL,
    sinopse VARCHAR(500) NOT NULL,
    genre VARCHAR(20) NOT NULL,
    release_year DATE NOT NULL,

)
CREATE TABLE ad(
    id Long PRIMARY KEY,
    book_id Long FOREIGN KEY,
    user_id Long FOREIGN KEY,
    price DOUBLE NOT NULL,
    book_condition VARCHAR(20) NOT NULL,
    ad_date DATE NOT NULL,
    
)