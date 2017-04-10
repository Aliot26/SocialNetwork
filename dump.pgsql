--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.1
-- Dumped by pg_dump version 9.6.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: network; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA network;


ALTER SCHEMA network OWNER TO postgres;

SET search_path = network, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: friends; Type: TABLE; Schema: network; Owner: postgres
--

CREATE TABLE friends (
    id integer NOT NULL,
    user_alfa integer,
    status boolean,
    user_beta integer
);


ALTER TABLE friends OWNER TO postgres;

--
-- Name: friends_id_seq; Type: SEQUENCE; Schema: network; Owner: postgres
--

CREATE SEQUENCE friends_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE friends_id_seq OWNER TO postgres;

--
-- Name: friends_id_seq; Type: SEQUENCE OWNED BY; Schema: network; Owner: postgres
--

ALTER SEQUENCE friends_id_seq OWNED BY friends.id;


--
-- Name: news; Type: TABLE; Schema: network; Owner: postgres
--

CREATE TABLE news (
    id integer NOT NULL,
    title character varying,
    author integer,
    content text,
    date date
);


ALTER TABLE news OWNER TO postgres;

--
-- Name: news_id_seq; Type: SEQUENCE; Schema: network; Owner: postgres
--

CREATE SEQUENCE news_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE news_id_seq OWNER TO postgres;

--
-- Name: news_id_seq; Type: SEQUENCE OWNED BY; Schema: network; Owner: postgres
--

ALTER SEQUENCE news_id_seq OWNED BY news.id;


--
-- Name: role; Type: TABLE; Schema: network; Owner: postgres
--

CREATE TABLE role (
    id integer NOT NULL,
    type character varying(255) NOT NULL
);


ALTER TABLE role OWNER TO postgres;

--
-- Name: users; Type: TABLE; Schema: network; Owner: postgres
--

CREATE TABLE users (
    id integer NOT NULL,
    username character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    firstname character varying(255) DEFAULT '0'::character varying NOT NULL,
    surname character varying(255) DEFAULT '0'::character varying NOT NULL,
    photo character varying(255) DEFAULT '0'::character varying NOT NULL
);


ALTER TABLE users OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: network; Owner: postgres
--

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE users_id_seq OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: network; Owner: postgres
--

ALTER SEQUENCE users_id_seq OWNED BY users.id;


--
-- Name: users_role; Type: TABLE; Schema: network; Owner: postgres
--

CREATE TABLE users_role (
    users_id integer NOT NULL,
    role_id integer NOT NULL
);


ALTER TABLE users_role OWNER TO postgres;

--
-- Name: friends id; Type: DEFAULT; Schema: network; Owner: postgres
--

ALTER TABLE ONLY friends ALTER COLUMN id SET DEFAULT nextval('friends_id_seq'::regclass);


--
-- Name: news id; Type: DEFAULT; Schema: network; Owner: postgres
--

ALTER TABLE ONLY news ALTER COLUMN id SET DEFAULT nextval('news_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: network; Owner: postgres
--

ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);


--
-- Data for Name: friends; Type: TABLE DATA; Schema: network; Owner: postgres
--

COPY friends (id, user_alfa, status, user_beta) FROM stdin;
10	40	t	37
13	41	t	35
14	42	t	39
15	42	t	35
12	37	t	29
11	40	t	29
16	29	t	39
18	37	f	35
17	37	t	42
19	37	f	41
\.


--
-- Name: friends_id_seq; Type: SEQUENCE SET; Schema: network; Owner: postgres
--

SELECT pg_catalog.setval('friends_id_seq', 19, true);


--
-- Data for Name: news; Type: TABLE DATA; Schema: network; Owner: postgres
--

COPY news (id, title, author, content, date) FROM stdin;
5	newsss	\N	enews	2017-04-03
6	nesw	\N	nesw	2017-04-03
7	1233	\N	1234	2017-04-03
8	1234	\N	1234	2017-04-03
9	741	\N	741	2017-04-03
10	123	\N	123	2017-04-03
11	852	\N	258	2017-04-03
17	Землетрясения	41	Несколько землетрясений были зафиксированы минувшей ночью в Греции. Самые сильные толчки произошли незадолго до полуночи и около 6:00	2017-04-07
18	Наводнение	41	Наводнение в Новой Зеландии: эвакуированы 2 тыс. человек Местами уровень воды достигает двух метров. Полиция ведет поиски одного пропавшего без вести	2017-04-07
19	Пятна на Солнце	42	Пятна на Солнце: вероятность новых вспышек остается Другое крупное пятно остается на диске Солнца — AR2645. Гигантская активная область имеет нестабильное «бета-гамма-дельта» магнитное поле	2017-04-07
20	Взрыв на вулкане	39	Гватемала: взрыв на вулкане Фуэго осветил небо Гватемальский вулкан Фуэго успокоился в первые часы в воскресенье утром после более чем половины дня активной деятельности, которая вызвала лавовые потоки	2017-04-07
21	Кратковременные дожди	37	В Беларуси 5 апреля местами пройдут небольшие дожди Ночью и утром преимущественно без осадков, днем местами пройдут кратковременные дожди, местами возможны грозы	2017-04-07
22	Два пятна на Солнце	37	Два пятна на Солнце несут угрозу сильных вспышек На сегодняшний день существует два пятна на Солнце, которые представляют угрозу для сильных вспышек: AR2644 и AR2645	2017-04-07
24	Оползень в Индонезии: 5 человек пропали без вести	40	Почва сошла на людей, которые работали на рисовых полях и плантациях на склоне холма. Ведутся поиски пропавших без вести	2017-04-10
\.


--
-- Name: news_id_seq; Type: SEQUENCE SET; Schema: network; Owner: postgres
--

SELECT pg_catalog.setval('news_id_seq', 24, true);


--
-- Data for Name: role; Type: TABLE DATA; Schema: network; Owner: postgres
--

COPY role (id, type) FROM stdin;
1	ROLE_ADMIN
2	ROLE_USER
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: network; Owner: postgres
--

COPY users (id, username, password, firstname, surname, photo) FROM stdin;
1	admin	1234	Endy 	Qwe 	Photo
39	Senya	1234	Senya	Senya	
29	Ivan	1234	Ivan	Ivanov	photo
35	Kate	1234	Kate	Ivanova	111
40	Anna	1234	Anna	Ivanova	
41	Alex	1234	Alexej	Alexandrov	
42	Mary	1234	Mary	Ivanova	
37	Olga	1234	Olga	Olga	My photo
\.


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: network; Owner: postgres
--

SELECT pg_catalog.setval('users_id_seq', 63, true);


--
-- Data for Name: users_role; Type: TABLE DATA; Schema: network; Owner: postgres
--

COPY users_role (users_id, role_id) FROM stdin;
1	1
39	2
29	2
35	2
40	2
41	2
42	2
37	2
\.


--
-- Name: friends friends_pkey; Type: CONSTRAINT; Schema: network; Owner: postgres
--

ALTER TABLE ONLY friends
    ADD CONSTRAINT friends_pkey PRIMARY KEY (id);


--
-- Name: news news_pkey; Type: CONSTRAINT; Schema: network; Owner: postgres
--

ALTER TABLE ONLY news
    ADD CONSTRAINT news_pkey PRIMARY KEY (id);


--
-- Name: role role_pk; Type: CONSTRAINT; Schema: network; Owner: postgres
--

ALTER TABLE ONLY role
    ADD CONSTRAINT role_pk PRIMARY KEY (id);


--
-- Name: users users_pk; Type: CONSTRAINT; Schema: network; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pk PRIMARY KEY (id);


--
-- Name: fki_friend1; Type: INDEX; Schema: network; Owner: postgres
--

CREATE INDEX fki_friend1 ON friends USING btree (user_alfa);


--
-- Name: fki_friends2; Type: INDEX; Schema: network; Owner: postgres
--

CREATE INDEX fki_friends2 ON friends USING btree (user_beta);


--
-- Name: users_role fk_0; Type: FK CONSTRAINT; Schema: network; Owner: postgres
--

ALTER TABLE ONLY users_role
    ADD CONSTRAINT fk_0 FOREIGN KEY (users_id) REFERENCES users(id);


--
-- Name: users_role fk_1; Type: FK CONSTRAINT; Schema: network; Owner: postgres
--

ALTER TABLE ONLY users_role
    ADD CONSTRAINT fk_1 FOREIGN KEY (role_id) REFERENCES role(id);


--
-- Name: news fk_author; Type: FK CONSTRAINT; Schema: network; Owner: postgres
--

ALTER TABLE ONLY news
    ADD CONSTRAINT fk_author FOREIGN KEY (author) REFERENCES users(id);


--
-- Name: friends friends1; Type: FK CONSTRAINT; Schema: network; Owner: postgres
--

ALTER TABLE ONLY friends
    ADD CONSTRAINT friends1 FOREIGN KEY (user_alfa) REFERENCES users(id);


--
-- Name: friends friends2; Type: FK CONSTRAINT; Schema: network; Owner: postgres
--

ALTER TABLE ONLY friends
    ADD CONSTRAINT friends2 FOREIGN KEY (user_beta) REFERENCES users(id);


--
-- PostgreSQL database dump complete
--

