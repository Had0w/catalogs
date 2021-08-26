create table educ_year
(
    id serial not null
        constraint educ_year_pk
            primary key,
    title         varchar(100),
    year          integer,
    sdate         timestamp with time zone,
    edate         timestamp with time zone
);

insert into educ_year values (9, '2019/2020 учебный год', 2019, '2019-08-31 20:00:00.000000','2020-08-30 20:00:00.000000');
insert into educ_year values (10, '2020/2021 учебный год', 2020, '2020-08-31 20:00:00.000000','2021-08-30 20:00:00.000000');
