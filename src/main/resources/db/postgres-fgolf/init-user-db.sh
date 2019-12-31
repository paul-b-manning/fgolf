#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE DATABASE fgolfdb ENCODING = 'UTF8';
    CREATE USER fgolfadmin;
    ALTER ROLE fgolfadmin WITH PASSWORD 'REPLACE_ME';
    GRANT ALL PRIVILEGES ON DATABASE fgolfdb TO fgolfadmin;
    \connect fgolfdb
	CREATE SCHEMA fgolf;
	ALTER SCHEMA fgolf OWNER TO fgolfadmin;
	ALTER ROLE fgolfadmin SET search_path TO fgolf;
EOSQL