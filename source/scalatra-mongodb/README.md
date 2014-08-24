# scalatra-mongodb

## Build & Run

```sh
$ cd scalatra-mongodb
$ ./sbt
> container:start
> browse
> ~ ;copy-resources;aux-compile
```

If `browse` doesn't launch your browser, manually open [http://localhost:8080/](http://localhost:8080/) in your browser.

## Assembling

*[Deploy fat JARs. Restart processes.](https://github.com/sbt/sbt-assembly)*

```sh
$ cd scalatra-mongodb
$ ./sbt clean assembly
$ java -jar target/scala-2.11/ScalatraSandbox.jar.jar
```

## Techs

``` scala

val ScalaVersion = "2.11.1"
val ScalatraVersion = "2.3.0"
val CasbahMongoDBVersion = "2.7.3"
val JettyWebappVersion = "9.1.3.v20140225

```
