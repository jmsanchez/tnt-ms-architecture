
#!/usr/bin/env bash

set -eo pipefail

modules=( tnt-ms-config tnt-ms-eureka tnt-ms-zuul tnt-ms-hystrix tnt-ms-zipkin tnt-ms-catalog tnt-ms-orders)

for module in "${modules[@]}"; do
    docker build -t "tnt-ms-architecture/${module}:latest" ${module}
done