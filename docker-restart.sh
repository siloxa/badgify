docker-compose down
mvn clean install -DskipTests -Dcheckstyle.skip
docker-compose build
docker-compose up -d
echo '✔ badgify is up'
