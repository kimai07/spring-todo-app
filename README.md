# spring-todo-app

## start application

```
$ ./mvnw spring-boot:run
:
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.5.3)

:
2021-08-12 22:20:26.743  INFO 5250 --- [  restartedMain] o.s.b.a.h2.H2ConsoleAutoConfiguration    : H2 console available at '/h2-console'. Database available at 'jdbc:h2:mem:7ba4dd20-2809-4451-981b-60effd2a84b8'
:
2021-08-12 22:20:27.823  INFO 5250 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
2021-08-12 22:20:27.857  INFO 5250 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2021-08-12 22:20:27.867  INFO 5250 --- [  restartedMain] com.kimai07.todoapp.TodoappApplication   : Started TodoappApplication in 2.867 seconds (JVM running for 3.198)

```

- created db tables: [DDL](https://github.com/kimai07/spring-todo-app/blob/main/src/main/resources/schema.sql)
- inserted datum: [DML](https://github.com/kimai07/spring-todo-app/blob/main/src/main/resources/data.sql)


## access h2-console

- http://localhost:8080/h2-console

## todo request

#### Create

```bash
$ curl -s -X POST localhost:8080/v1/todo -d '{
  "title":"test4",
  "description":"test44",
  "deadline":"2021-09-30",
  "done":false
}' -H "Content-Type: application/json"
```

#### Read

```bash
$ curl -s localhost:8080/v1/todo/4 | jq .
{
  "id": 4,
  "title": "test4",
  "description": "test44",
  "deadline": "2021-09-30",
  "done": false
}
```


#### List

```bash
$ curl -s localhost:8080/v1/todos | jq .
[
  {
    "id": 1,
    "title": "test1",
    "description": "test11",
    "deadline": "2021-08-19",
    "done": false
  },
  {
    "id": 2,
    "title": "test2",
    "description": "test22",
    "deadline": "2021-08-29",
    "done": false
  },
  {
    "id": 3,
    "title": "test3",
    "description": "test33",
    "deadline": "2021-09-09",
    "done": false
  },
  {
    "id": 4,
    "title": "test4",
    "description": "test44",
    "deadline": "2021-09-30",
    "done": false
  }
]
```

