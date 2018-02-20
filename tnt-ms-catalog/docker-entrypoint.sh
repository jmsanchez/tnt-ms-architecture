#!/bin/bash

set -e

cd /opt/metricbeat-linux-x86_64/
./metricbeat -e &

cd /opt/filebeat-linux-x86_64/
./filebeat -e &

java -Xmx128m -Djava.security.egd=file:/dev/./urandom -jar /app/app.jar --spring.profiles.active=structural,docker

exec "$@"