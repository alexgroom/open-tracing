#!/bin/bash
oc new-app postgresql-ephemeral \
    --param=DATABASE_SERVICE_NAME=postgres-database \
    --param=POSTGRESQL_DATABASE=person \
    --param=POSTGRESQL_USER=sa \
    --param=POSTGRESQL_PASSWORD=sa \
    --labels=app.openshift.io/runtime=postgresql \
    --as-deployment-config
oc label dc/postgres-database  app.openshift.io/runtime=postgresql --overwrite && \
oc label dc/people app.kubernetes.io/part-of=people --overwrite && \
oc label dc/postgres-database app.kubernetes.io/part-of=people --overwrite && \
oc annotate dc/people app.openshift.io/connects-to=postgres-database --overwrite
