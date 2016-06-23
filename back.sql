--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: myschema; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA myschema;


ALTER SCHEMA myschema OWNER TO postgres;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = myschema, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: test; Type: TABLE; Schema: myschema; Owner: postgres; Tablespace: 
--

CREATE TABLE test (
    name character(50)
);


ALTER TABLE myschema.test OWNER TO postgres;

SET search_path = public, pg_catalog;

--
-- Name: company; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE company (
    id integer NOT NULL,
    name text NOT NULL,
    age integer NOT NULL,
    address character(50),
    salary real
);


ALTER TABLE public.company OWNER TO postgres;

--
-- Name: student; Type: TABLE; Schema: public; Owner: bob; Tablespace: 
--

CREATE TABLE student (
    name character(100),
    age integer,
    roll integer
);


ALTER TABLE public.student OWNER TO bob;

--
-- Name: test; Type: TABLE; Schema: public; Owner: bob; Tablespace: 
--

CREATE TABLE test (
    name character(50)
);


ALTER TABLE public.test OWNER TO bob;

SET search_path = myschema, pg_catalog;

--
-- Data for Name: test; Type: TABLE DATA; Schema: myschema; Owner: postgres
--

COPY test (name) FROM stdin;
af                                                
\.


SET search_path = public, pg_catalog;

--
-- Data for Name: company; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY company (id, name, age, address, salary) FROM stdin;
123	MY COMPANY	21	SOME ADDRESS                                      	24.3999996
\.


--
-- Data for Name: student; Type: TABLE DATA; Schema: public; Owner: bob
--

COPY student (name, age, roll) FROM stdin;
Krishna Prasad                                                                                      	28	123
\.


--
-- Data for Name: test; Type: TABLE DATA; Schema: public; Owner: bob
--

COPY test (name) FROM stdin;
hari                                              
\.


--
-- Name: company_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY company
    ADD CONSTRAINT company_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


SET search_path = myschema, pg_catalog;

--
-- Name: test; Type: ACL; Schema: myschema; Owner: postgres
--

REVOKE ALL ON TABLE test FROM PUBLIC;
REVOKE ALL ON TABLE test FROM postgres;
GRANT ALL ON TABLE test TO postgres;
GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE test TO bob;


--
-- PostgreSQL database dump complete
--

