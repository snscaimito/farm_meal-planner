#!/bin/bash
docker-compose -f docker-compose-dev.yml down --rmi local
if [ $? -ne 0 ]; then
  exit
fi

cd styles
mvn install
if [ $? -ne 0 ]; then
  cd ..
  exit
fi
cd ..

cd navigation
mvn install
if [ $? -ne 0 ]; then
  cd ..
  exit
fi
cd ..

cd recipes
mvn install
if [ $? -ne 0 ]; then
  cd ..
  exit
fi
cd ..

docker-compose -f docker-compose-dev.yml up --build
