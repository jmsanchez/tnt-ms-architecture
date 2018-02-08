drop table product if exists;
create table product (code int, ean varchar(25), name varchar(50), description varchar(512), quantity int, primary key (code));