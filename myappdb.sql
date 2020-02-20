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

create table reply
(
    id number generated ALWAYS AS IDENTITY PRIMARY key,
    body varchar(255) not null,
    boardid number not null,
    memberid varchar(255) not null,
    inserted date default sysdate
);
select * from reply order by id desc;

alter table board
add (
    fileName varchar(255)
);


