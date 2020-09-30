create sequence hibernate_sequence start 1 increment 1;
create table message (
    id int8 not null,
    tag varchar(255),
    text varchar(255),
    user_id int8,
    primary key (id)
);

create table user_role (
    user_id int8 not null,
    roles varchar(255)
);

create table usr (
    id int8 not null,
    active boolean not null,
    name varchar(255),
    password varchar(255),
    patronymic varchar(255),
    surname varchar(255),
    username varchar(255),
    email varchar(255),
    primary key (id)
);

alter table if exists message
    add constraint message_user_fk
    foreign key (user_id) references usr;

alter table if exists user_role
    add constraint user_role_user_fk
    foreign key (user_id) references usr;