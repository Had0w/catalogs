CREATE TABLE sex (
    id serial not null,
    code char,
    updated_at timestamp default now()
);