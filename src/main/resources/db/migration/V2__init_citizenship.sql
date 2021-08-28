create table citizenship
(
    id serial not null
    constraint citizenship_pk
    primary key,
    code varchar(5) not null,
    title varchar(255) not null,
    updated_at timestamp default now()
);

insert into citizenship values
(270, 'BMU', 'Бермуды', '2020-04-28 22:44:59'),
(209, 'CHN', 'КНР', '2020-04-28 22:44:59'),
(246, 'BEL', 'Бельгия', '2020-04-28 22:44:59');
