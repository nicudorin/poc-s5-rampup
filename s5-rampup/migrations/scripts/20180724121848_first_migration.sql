--// First migration.
-- Migration SQL that makes the change goes here.

CREATE TABLE public.people
(
    id bigint NOT NULL,
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
