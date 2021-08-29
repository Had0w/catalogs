ALTER TABLE educ_year ADD updated_at timestamp default now(), ADD nsi_global_id integer;
ALTER TABLE educ_year ADD nsi_title varchar(30), ADD nsi_id integer;
ALTER TABLE educ_year ADD nsi_del boolean;