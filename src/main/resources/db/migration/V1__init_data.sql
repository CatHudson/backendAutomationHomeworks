CREATE TABLE authors (id bigserial primary key, name varchar(255));
INSERT INTO authors (name)
VALUES
('Herman Hesse'),
('Ayn Rend'),
('Fyodor Dostoevsky'),
('Steven Hawking'),
('Hunter Thompson'),
('Robert Stevenson');

CREATE TABLE books (id bigserial primary key, title varchar(255), author_id bigint REFERENCES authors(id));
INSERT INTO books (title, author_id)
VALUES
('Demian', 1),
('Gambler', 3),
('Atlas shrugged', 2),
('Brief theory of time', 4),
('Treasure island', 6),
('Rome diary', 5),
('Idiot', 3);