#!/bin/bash

PROJECT=todoapp

GENERATED_SOURCE=generated-src/src/main/java/com/kimai07/${PROJECT}/generated
GENERATED_DESTINATION=../src/main/java/com/kimai07/${PROJECT}/generated

rm -f ${GENERATED_DESTINATION}/controller/*.java
rm -f ${GENERATED_DESTINATION}/model/*.java
rm -rf generated-src

mkdir generated-src

java -Dline.separator=$'\n' -jar ./openapi-generator-cli-5.2.1.jar generate \
  -i api/openapi.yaml \
  -c ./openapi.config \
  -o generated-src \
  --skip-validate-spec

if [ $? -ne 0 ]; then
    echo "Oops..."
    exit 1
fi

if [ -e ${GENERATED_SOURCE}/controller ]; then
    cp ${GENERATED_SOURCE}/controller/*.java ${GENERATED_DESTINATION}/controller/.
fi
if [ -e ${GENERATED_SOURCE}/model ]; then
    cp ${GENERATED_SOURCE}/model/*.java ${GENERATED_DESTINATION}/model/.
fi
