DROP TABLE IF EXISTS authors, genres, books;
create table books(ID serial   PRIMARY KEY, name VARCHAR(255));
create table authors(ID serial  primary key, name VARCHAR(255),id_book int);
create table genres(ID serial  primary key, name VARCHAR(255),id_book int);


