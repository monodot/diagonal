![Build Status][buildstatus]
![Project licence][licence]
![Egg Status][eggs]

# diagonal

An attempt at a diagram generator webapp, using [Plantuml][plantuml] and [Quarkus][quarkus].

To run (in development):

    mvn compile quarkus:dev

To build:

    mvn package
    docker build -f src/main/docker/Dockerfile.jvm -t monodot/diagonal .
    docker run -i --rm -p 8080:8080 monodot/diagonal

And to test locally - this will save the image to a file, `target/basic.png`:

    curl -v -H "Content-Type: text/plain" \
        -H "skin: modern" \
        --data-binary @samples/sequence.puml \
        --output target/output.png \
        http://localhost:8080/diagram/standard

[buildstatus]: https://api.travis-ci.org/monodot/halfbaked-diagrams.svg?branch=master
[licence]: https://img.shields.io/github/license/monodot/camel-demos.svg
[eggs]: https://img.shields.io/badge/eggs-scrambled-green.svg
[quarkus]: https://quarkus.io/
[plantuml]: https://github.com/plantuml/plantuml
