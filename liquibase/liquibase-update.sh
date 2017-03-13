#!/bin/bash

CLASSPATH="lib/postgresql-9.4.1212.jre7.jar"

database="local"
#database="prod"


if [ $database == "local" ]; then
	URL="jdbc:postgresql://localhost:5432/springrtsru"
	USER="local"
	PASS="local"
elif [ $database == "prod" ]; then
	URL="jdbc:postgresql://104.236.78.36:5432/springrtsru"
	USER=""
	PASS=""
fi

echo "========================================================================="

java -jar lib/liquibase-core-3.5.3.jar --driver=org.postgresql.Driver \
 --classpath=$CLASSPATH\
 --changeLogFile=db.changelog.xml \
 --url="$URL" \
 --logLevel=info\
 --username=$USER \
 --password=$PASS \
 updateSQL

echo "Using database $database "
echo " URL: $URL"
echo " User: $USER"
echo "========================================================================="
echo "Continue ? (y/N)"
read answer

if [ "x$answer" == "xy" ]; then
echo "Updating..."
	java -jar lib/liquibase-core-3.5.3.jar --driver=org.postgresql.Driver \
	 --classpath=$CLASSPATH\
	 --changeLogFile=db.changelog.xml \
	 --url="$URL" \
	 --logLevel=info\
	 --username=$USER \
	 --password=$PASS \
	 update
else
	echo "Abort"
fi


