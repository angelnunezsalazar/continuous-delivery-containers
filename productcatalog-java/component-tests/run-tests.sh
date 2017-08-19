#!/bin/bash

if [ "$(uname -s)" = "Darwin" ] ; then
		if [ -n $DOCKER_HOST ]; then
			#extract the hostame from DOCKER_HOST
		    service_ip=$(echo $DOCKER_HOST | awk -F/ '{print $3}' | awk -F: '{print $1}')
		else
			service_ip=$(docker-machine ip)
		fi
		echo "Using Service IP $service_ip"
else
		echo "Currently only supports MacOS"
		exit 1
fi

function setup {
	echo "Setup Tests"
	docker-compose up -d
}


function quit {
	echo "Cleaning Tests"
	docker-compose down
	docker-compose rm -f
	exit $1
}

function test {
	echo "Running Tests"
	rc=$(curl --write-out %{http_code} --silent --output /dev/null http://192.168.99.100:8080/api/products)
	if [[ $rc != 200 ]]; then 
		echo "Fail =("
		quit 1;
	else
		echo "Pass =)"
	fi
}

setup
sleep 30 # Make sure service are ready to receive requests
test
quit 0