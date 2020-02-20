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

create table board
(
    id number GENERATED ALWAYS as IDENTITY primary key,
    title varchar(255) not null,
    body varchar(255) not null,
    memberid varchar(255) not null,
    inserted date default sysdate
);

select * from board order by id desc;



