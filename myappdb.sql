create table member 
(
memberid varchar(255) PRIMARY key,
password varchar(255) not null
);

alter table member
add (
    email varchar(255),
    nickname varchar(255)
);
select * from member;







