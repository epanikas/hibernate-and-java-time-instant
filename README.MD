this project to demonstrate two problems of using java.time.Instant with hibernate

1. the timestamp and date are not converted to instant properly, unless the preferred instant type is set to TIMESTAMP
because by default it is assigned to jdbc data type 3003 TIMESTAMP_UTC, which is not being treated correctly
2. if instant is used as version, and on the DB side its datatype is TIMESTAMP, the version doesn't work correctly, leading to exception "the row has been updated or deleted by another transaction"

to build oracle image i have used this tutorial:
https://blogs.oracle.com/connect/post/deliver-oracle-database-18c-express-edition-in-containers

commit docker image
```shell
docker commit java-time-instant-and-hibernate-oracle-db-18-xe-1 oracle/database/prebuilt/xe-18.4:1.0
```

should execute in DB 
```oracle-sql
create user MY_SCHEMA identified by password;
grant all privileges to my_schema;
```

deleting from flyway table to reapply migrations:
```oracle-sql
delete from "SYS"."flyway_schema_history" where "version" <> 1;
```

ref: https://stackoverflow.com/questions/75236228/how-to-properly-configure-timestamp-handling-for-timestamp-columns-in-hibernate6

problem:
Schema-validation: wrong column type encountered in column [DATE_VAL] in table [users]; found [date (Types#TIMESTAMP)], but expecting [timestamp(6) with time zone (Types#TIMESTAMP_UTC)]

solution:
- either set hibernate.type.preferred_instant_jdbc_type to TIMESTAMP
- or @Column(..., columnDefinition = "DATE")
- or @JdbcTypeCode(Types.TIMESTAMP)