#!/bin/bash

PROJECT=todoapp
ARTIFACT=todoapp

GENERATED_SOURCE=generated-src/src/main/java/com/kimai07/${PROJECT}/generated
GENERATED_DESTINATION=../src/main/java/com/kimai07/${PROJECT}/generated

rm -f ${GENERATED_DESTINATION}/controller/*.java
rm -f ${GENERATED_DESTINATION}/model/*.java
rm -rf generated-src

java -Dline.separator=$'\n' -jar ./swagger-codegen-cli-3.0.21.jar generate  \
  -i api/openapi.yaml \
  -c ./swagger.config \
  --api-package com.kimai07.$PROJECT.generated.controller \
  --model-package com.kimai07.$PROJECT.generated.model \
  --group-id com.kimai07.$PROJECT \
  --artifact-id $ARTIFACT \
  --artifact-version 0.0.1-SNAPSHOT \
  -l spring \
  -o generated-src

if [ $? -ne 0 ]; then
    echo "Oops..."
    exit 1
fi

if [ -e ${GENERATED_SOURCE}/controller ]; then
    cp ${GENERATED_SOURCE}/controller/*Api.java ${GENERATED_DESTINATION}/controller/.
fi
if [ -e ${GENERATED_SOURCE}/model ]; then
    cp ${GENERATED_SOURCE}/model/*.java ${GENERATED_DESTINATION}/model/.
fi
