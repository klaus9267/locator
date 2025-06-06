#!/bin/bash

db() {
  docker-compose -f db.yml up
}

case "$1" in
	"db")
		db
		;;
	*) echo "사용법: $0 [db]"
		exit 1
		;;
esac