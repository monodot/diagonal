![Build Status][buildstatus]
![Project licence][licence]
![Egg Status][eggs]

# diagonal

A simple diagram generator API, built using [Plantuml][plantuml] and [Quarkus][quarkus].

There is an accompanying front-end for this application which can be found at [diagonal-fe][fe].

## Prerequisites

- JDK
- Maven
- Graphviz

## Running locally

To run using Maven:

    mvn compile quarkus:dev

To build and run in a container:

    mvn package
    docker build -f src/main/docker/Dockerfile.jvm -t monodot/diagonal .
    docker run -i --name diagonal --rm -p 8080:8080 monodot/diagonal

And to test locally - this will save the image to a file, `target/output.png`:

    curl -v -H "Content-Type: source/plain" \
        -H "skin: modern" \
        --data-binary @samples/sequence.puml \
        --output target/output.png \
        http://localhost:8080/diagram/standard

    curl -v -H "Content-Type: application/json" \
        --data-binary @src/test/data/samplerequest.json \
        http://localhost:8080/diagrams/standard

To build and run as a native image in a container (NB: this is **not working** right now unfortunately! dang!):

    export GRAALVM_HOME=/opt/java/graalvm
    mvn package -Pnative
    docker build -f src/main/docker/Dockerfile.native -t monodot/diagonal .
    docker run -i --name diagonal --rm -p 8080:8080 monodot/diagonal

[buildstatus]: https://api.travis-ci.org/monodot/halfbaked-diagrams.svg?branch=master
[licence]: https://img.shields.io/github/license/monodot/camel-demos.svg
[eggs]: https://img.shields.io/badge/eggs-scrambled-green.svg
[quarkus]: https://quarkus.io/
[plantuml]: https://github.com/plantuml/plantuml
[fe]: https://github.com/monodot/diagonal-fe

