#!/usr/bin/env bash

# Script starts here

readonly SCRIPT_DIR=$(dirname "$(realpath "$0")")
# TODO: change this line so that script doesn't break on version bumps
readonly JAR="${SCRIPT_DIR}/build/libs/gabof-1.0-SNAPSHOT.jar"

java -jar "${JAR}" "$@"

