#!/bin/sh
curl -s http://$(oc get route people -o=go-template --template='{{ .spec.host }}')/person/swpeople | jq