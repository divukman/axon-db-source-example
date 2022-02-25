# Example of custom spring boot axon db source configuration

## Main branch (H2 db)

- Using H2 database for AXON event store
- Using separate H2 database for orders 
- You can change AXON H2 to store in a file, thus being able to replay events on startup!
- Boostrap class will replay the axon events and this will, in turn populate the orders in memory H2 database



## Running Postgres version -> Go to postgres branch

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

