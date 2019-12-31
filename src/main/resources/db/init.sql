CREATE DATABASE fgolfdb ENCODING = 'UTF8';
CREATE USER fgolfadmin WITH ENCRYPTED PASSWORD 'REPLACE_ME';
GRANT ALL PRIVILEGES ON DATABASE fgolfdb TO fgolfadmin;
\connect fgolfdb
CREATE SCHEMA fgolf;
ALTER SCHEMA fgolf OWNER TO fgolfadmin;
ALTER ROLE fgolfadmin SET search_path TO fgolf;