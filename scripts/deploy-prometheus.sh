#!/bin/sh

oc create configmap prom --from-file=prometheus.yml=../src/main/kubernetes/prometheus.yml
oc new-app --name prometheus quay.io/prometheus/prometheus
oc set volume deployment/prometheus --add -t configmap --configmap-name=prom -m /etc/prometheus/prometheus.yml --sub-path=prometheus.yml
oc expose svc/prometheus
