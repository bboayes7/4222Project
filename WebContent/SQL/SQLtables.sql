drop table if exists Musician CASCADE;
drop table if exists Album CASCADE;
drop table if exists Instrument CASCADE;
drop table if exists Song CASCADE;
drop table if exists Playedby CASCADE;
drop table if exists performedby CASCADE;

CREATE TABLE Musician (
    ssn int PRIMARY KEY ,
    name varchar(255) NOT NULL,
    phone int NOT NULL,
    address varchar(255) NOT NULL,
    ifPoor boolean default true
);

CREATE TABLE Album (
    id int PRIMARY KEY ,
    albumId int NOT NULL,
    pSSN int  REFERENCES Musician (ssn) ON DELETE CASCADE ON UPDATE CASCADE,
    copyrightDate date NOT NULL,
    title varchar(255) NOT NULL,
    format varchar(255) NOT NULL
);

CREATE TABLE Instrument (
    id int PRIMARY KEY  ,
    name varchar(255) NOT NULL,
    musicalKey varchar(255) NOT NULL
);

CREATE TABLE Song(
    song_id int PRIMARY KEY,
    album_id int REFERENCES Album (id) ON DELETE CASCADE ON UPDATE CASCADE,
    title varchar(255) NOT NULL
);

CREATE TABLE Playedby(
    Mssn int  REFERENCES Musician (ssn) ON DELETE CASCADE ON UPDATE CASCADE,
    Instrument_id int REFERENCES Instrument (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE performedby(
    Mssn int  REFERENCES Musician (ssn) ON DELETE CASCADE ON UPDATE CASCADE,
    song_id int REFERENCES Song (song_id) ON DELETE CASCADE ON UPDATE CASCADE
);

insert into Musician values (1,'juan',123456789,'201 fake street',true);
insert into Album values (1,1,1,NOW(),'NUBMERONE','CD');
insert into Instrument values (1,'Bass','C4');
insert into Song values (1,1,'FIRST HIT');
insert into Playedby values (1,1);
insert into performedby values (1,1);





