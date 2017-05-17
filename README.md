# person-rs-app

HTML5 friendly JAX-RS sample with Java EE 7

## Build & Deploy

1. Build sample code using Apache maven.

~~~
$ mvn clean package
~~~

This will create two deployable war modules.

* person-rs-web/target/person-rs-web.war
* person-rs-client-web/target/person-rs-client-web.war

2. Start JBoss EAP 7 server.

~~~
$ ${EAP_HOME}/bin/standalone.sh
~~~

3. Deploy war modules into EAP server.

~~~
$ mvn deploy
~~~

## Test Flight

Access the following URLs.

~~~
http://localhost:8080/person-rs-web/
or,
http://localhost:8080/person-rs-client-web/
~~~