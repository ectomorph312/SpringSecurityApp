create table todo (
    id int8 not null,
    completed timestamp,
    created timestamp,
    description varchar(255),
    status varchar(255),
    title varchar(255),
    todo_id int8,
    primary key (id)
);

alter table if exists todo
    add constraint FKmr4way13n30ivpavm6fqad4d1
    foreign key (todo_id) references usr;