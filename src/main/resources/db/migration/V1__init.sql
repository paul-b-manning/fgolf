-- League Sequence

CREATE SEQUENCE league_sequence
    START WITH 1000
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE league_sequence OWNER TO fgolfadmin;

-- Leagues

CREATE TABLE leagues (
    id bigint NOT NULL,
    name character varying(255)
);

ALTER TABLE leagues OWNER TO fgolfadmin;

ALTER TABLE ONLY leagues
    ADD CONSTRAINT leagues_pkey PRIMARY KEY (id);
   
   
-- Season Sequence

CREATE SEQUENCE season_sequence
    START WITH 1000
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE season_sequence OWNER TO fgolfadmin;

-- Seasons

CREATE TABLE seasons (
    id bigint NOT NULL,
    name character varying(255),
    year integer NOT NULL,
    league_id bigint NOT NULL
);

ALTER TABLE seasons OWNER TO fgolfadmin;

ALTER TABLE ONLY seasons
    ADD CONSTRAINT seasons_pkey PRIMARY KEY (id);

ALTER TABLE ONLY seasons
    ADD CONSTRAINT fk_season_league FOREIGN KEY (league_id) REFERENCES leagues(id);


 -- Tournament Sequence
   
CREATE SEQUENCE tournament_sequence
    START WITH 1000
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE tournament_sequence OWNER TO fgolfadmin;

-- Tournament

CREATE TABLE tournaments (
    id bigint NOT NULL,
    name character varying(255),
    season_id bigint NOT NULL
);

ALTER TABLE tournaments OWNER TO fgolfadmin;

ALTER TABLE ONLY tournaments
    ADD CONSTRAINT tournaments_pkey PRIMARY KEY (id);

ALTER TABLE ONLY tournaments
    ADD CONSTRAINT fk_tournament_season FOREIGN KEY (season_id) REFERENCES seasons(id);



