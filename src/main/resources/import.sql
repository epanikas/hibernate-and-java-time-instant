drop schema MY_SCHEMA cascade;
create schema MY_SCHEMA;
create sequence MY_SCHEMA.MY_ID_SEQUENCE start with 1 increment by 50;
create table MY_SCHEMA.users (id bigint not null, email varchar(255), name varchar(255), primary key (id));
