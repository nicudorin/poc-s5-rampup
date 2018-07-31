--// Add people table
-- Migration SQL that makes the change goes here.

CREATE SEQUENCE people_id_seq;

CREATE TABLE public.people
(
    id integer NOT NULL DEFAULT nextval('people_id_seq'::regclass),
    first_name character(50) COLLATE pg_catalog."default" NOT NULL,
    last_name character(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT people_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.people
    OWNER to postgres;

--//@UNDO
-- SQL to undo the change goes here.

DROP TABLE public.people;
