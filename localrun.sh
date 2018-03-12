#!/bin/bash

docker_down() {
  docker-compose -f docker-compose-dev.yml down --rmi local
  if [ $? -ne 0 ]; then
    exit
  fi
}

build_jars() {
  cd styles
  mvn install
  if [ $? -ne 0 ]; then
    cd ..
    exit
  fi
  cd ..

  cd common
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
  
  cd cookbooks
  mvn install
  if [ $? -ne 0 ]; then
    cd ..
    exit
  fi
  cd ..

}

docker_build_up() {
  docker-compose -f docker-compose-dev.yml up --build
}

docker_up() {
  docker-compose -f docker-compose-dev.yml up
}

display_help() {
  echo "Usage:"
  echo "--help    displays help"
  echo "up        run without rebuilding"
  echo "down      put all containers down"
  echo "rebuild   rebuild and run"
}

while :
do
    case "$1" in
      -h | --help)
          display_help
          exit 0
          ;;
      up)
          docker_up
          exit 0
          ;;
      down)
          docker_down
          exit 0
          ;;
      rebuild)
          docker_down
          build_jars
          docker_build_up
          exit 0
          ;;
      *)  # No more options
          break
          ;;
    esac
done
