DROP DATABASE university;
CREATE DATABASE university;

\connect university

CREATE SCHEMA info;

CREATE TABLE info.students_list
(
    id integer,
    student text
);

CREATE TABLE info.crosstable
(
groupname text,
studentid integer
);