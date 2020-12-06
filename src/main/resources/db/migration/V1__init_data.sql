CREATE TABLE products (id bigserial primary key, title varchar(255), price int);
INSERT INTO products (title, price)
VALUES
('Milk', 50),
('Bread', 30),
('Gold', 500),
('Silver', 300),
('Happiness', 9999),
('Water bottle', 25);