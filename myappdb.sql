create table member 
(
memberid varchar(255) PRIMARY key,
password varchar(255) not null
);
select * from member;

create table board
(
id number GENERATED always as identity primary key,
title varchar(255) not null,
body varchar(255) not null,
memberid varchar(255),
posted date default sysdate
);




