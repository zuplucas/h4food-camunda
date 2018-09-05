alter database camunda OWNER TO camunda;
\connect camunda;
create SCHEMA IF NOT EXISTS rw_camunda;
GRANT ALL PRIVILEGES ON SCHEMA rw_camunda TO GROUP camunda;