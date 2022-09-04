FROM postgres
COPY basedatos.sql /docker-entrypoint-initdb.d/