# Example of custom spring boot axon db source configuration

## Running

### Create local Postgres axon database

Following script will pull the Postgres docker image and create multiple databases.
NB! Passwords set for users are axon:axon and testdb:testdb. Customize if needed.

```sh
$ cd docker-postgres-local 
$ docker-compose up
```


### Run spring boot app

```sh
$ cd db-source
$ mvn clean package
$ mvn spring-boot:run
```

## To do
- Feel free to create a PR and add more stuff to the example.

## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE) file.
