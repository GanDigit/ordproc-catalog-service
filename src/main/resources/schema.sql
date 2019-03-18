create table product
(
   id INT PRIMARY KEY ,
   category varchar(255) not null,
   name varchar(255) not null,
   description varchar(255) not null,
   price int
);

create table customer
(
   id INT PRIMARY KEY ,
   name varchar(255) not null,
   address varchar(255) not null
);



CREATE TABLE TEST(ID INT PRIMARY KEY, NAME VARCHAR(255));
