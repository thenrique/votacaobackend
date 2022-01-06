default:
	cat ./Makefile


dist:
	./mvnw clean package

compose:
	docker-compose build

run:
	docker-compose up -d

down:
	docker-compose down

up:
	docker-compose ps

build-mvn:
	mvn clean package spring-boot:build-image