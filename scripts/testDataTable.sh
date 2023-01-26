#!/bin/sh
curl -s $(oc get route people -o=go-template --template='{{ .spec.host }}')/person/birth/before/2000 | jq