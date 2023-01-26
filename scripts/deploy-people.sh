#!/bin/bash

USERXX=$1

if [ -z "$USERXX" -o "$USERXX" = "userXX" ]
  then
    echo "Usage: Input your username like deploy-people.sh user1"
    exit;
fi

echo Your username is $USERXX
echo Deploy people service........

oc project $USERXX-project
oc delete dc,deployment,bc,build,svc,route,pod,is --all

echo "Waiting 30 seconds to finialize deletion of resources..."
sleep 30

mvn clean package -DskipTests

oc rollout status -w dc/people