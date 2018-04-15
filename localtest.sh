#!/bin/bash

display_help() {
  echo "Usage:"
  echo "all         Test the whole application on port 80"
  echo "recipes     Test only recipes on port 8080"
}

test_all() {
  export HOST=localhost
  export PORT=80
  bundle exec cucumber --tags 'not @todo' $1 $2 $3 $4 $5 $6 $7 $8 $9
}

test_recipes() {
  export HOST=localhost
  export PORT=8080
  bundle exec cucumber --tags @recipes --tags 'not @todo' $1 $2 $3 $4 $5 $6 $7 $8 $9
}

if [ $# -eq 0 ]; then
  display_help
  exit 0
fi

while :
do
    case "$1" in
      -h | --help)
          display_help
          exit 0
          ;;
      all)
        test_all
        exit 0
        ;;
      recipes)
        test_recipes
        exit 0
        ;;
      *)  # No more options
        break
        ;;
    esac
done
