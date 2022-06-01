#!/bin/sh

psql -U postgres -tc "SELECT 1 FROM pg_database WHERE datname = 'keycloak'" | grep -q 1 | psql -U postgres -c "CREATE DATABASE keycloak"
psql -U postgres -tc "SELECT 1 FROM pg_database WHERE datname = 'my_registration'" | grep -q 1 | psql -U postgres -c "CREATE DATABASE my_registration"

exit