
CREATE TABLE course (
	id UUID NOT NULL,
	nome varchar(255) NOT NULL,
	CONSTRAINT course_pkey PRIMARY KEY (id)
);

CREATE TABLE subject (
	id UUID NOT NULL,
	nome varchar(255) NOT NULL,
	CONSTRAINT subject_pkey PRIMARY KEY (id)
);

CREATE TABLE degree (
	id UUID NOT NULL,
	nome varchar(255) NOT NULL,
	course_id int8 NOT NULL,
	CONSTRAINT degree_pkey PRIMARY KEY (id),
	CONSTRAINT course_fk
        FOREIGN KEY(course_id)
            REFERENCES course(id)
);

CREATE TABLE degree_subject (
	degree_id UUID NOT NULL,
	subject_id UUID NOT NULL,
	CONSTRAINT degree_subject_fk
        FOREIGN KEY(degree_id)
            REFERENCES degree(id),
    CONSTRAINT subject_degree_fk
        FOREIGN KEY(subject_id)
            REFERENCES subject(id)
);

CREATE SEQUENCE public.hibernate_sequence
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 11834992
    CACHE 1
    NO CYCLE;

ALTER SEQUENCE public.hibernate_sequence OWNER TO keycloak;
GRANT ALL ON SEQUENCE public.hibernate_sequence to keycloak;



CREATE SEQUENCE public.course_id_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    NO CYCLE;

ALTER SEQUENCE public.course_id_seq OWNER TO keycloak;
GRANT ALL ON SEQUENCE public.course_id_seq to keycloak;



CREATE SEQUENCE public.degree_id_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    NO CYCLE;

ALTER SEQUENCE public.degree_id_seq OWNER TO keycloak;
GRANT ALL ON SEQUENCE public.degree_id_seq to keycloak;



CREATE SEQUENCE public.subject_id_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    NO CYCLE;

ALTER SEQUENCE public.subject_id_seq OWNER TO keycloak;
GRANT ALL ON SEQUENCE public.subject_id_seq to keycloak;
