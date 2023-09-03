.DEFAULT_GOAL := build-run

clean:
	./gradlew clean

setup:
	gradle wrapper --gradle-version 8.3

build:
	./gradlew clean build

install:
	./gradlew clean install

test:
	./gradlew test

run:
	./gradlew run

build-dist:
	./gradlew clean installDist

run-dist:
	./build/install/app/bin/app

build-run: build run

.PHONY: build