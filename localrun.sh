#!/bin/bash
docker-compose -f docker-compose-dev.yml down

cd meal_planner_service
mvn package
cd ..

docker-compose -f docker-compose-dev.yml up
