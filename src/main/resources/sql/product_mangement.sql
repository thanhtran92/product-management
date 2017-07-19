create database product_management;

use product_management;

create table product (
    id bigint(16) auto_increment primary key,
    name varchar(128) not null,
    price varchar(64) not null,
    category varchar(64),
    description text
);

create table user (
    username varchar(64) not null primary key,
    password varchar(64) not null
);
