#!/usr/bin/env bash
set -e
cd "$(dirname "$0")/.."

javac -d out src/*.java
java -cp out Main
