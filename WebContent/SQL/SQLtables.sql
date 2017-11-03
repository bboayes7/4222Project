drop table if exists Musician;
drop table if exists Album;
drop table if exists Instrument;
drop table if exists Song;

CREATE TABLE Musician (
    ssn int,
    name varchar(255),
    phone int,
   address varchar(255),
    ifPoor boolean default true
);

CREATE TABLE Album (
    id int,
    albumId int,
    pSSN int,
    copyrightDate date,
    title varchar(255),
   format varchar(255)
);
CREATE TABLE Instrument (
    id int,
   name varchar(255),
   musicalKey varchar(255)
);

CREATE TABLE Song(
    album_id int,
    song_id int,
    title varchar(255)
);


