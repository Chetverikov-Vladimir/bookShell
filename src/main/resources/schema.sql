DROP TABLE IF EXISTS authors, genres, books;
create table books(ID int  PRIMARY KEY, name VARCHAR(255),idAuthor int,idGenre int);
create table authors(ID int primary key, name VARCHAR(255));
create table genres(ID int primary key, name VARCHAR(255));


