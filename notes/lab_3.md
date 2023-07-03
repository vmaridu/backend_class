### Agenda
 - Container (podman)
 - MySQL Setup 
 - Table Design 
 - IDEA DB Setup 
 - Spring Data JDBC
 - Spring Config and Profiling 
 - Error Handling
 - OAS and Swagger 

### Contaier 
~~~
Image 
Container 
Image Repository (Local, Remote)
Overlay File system 
Making Image 
Running Image 
OCI (Open Container Initiative)
~~~

### Table Design 
~~~
// 1-1 user address
user     (id, user_name, first_name, last_name, address_id)
address  (id, street_address, apt, city, state, country, zip)

// m-1 employee department (1-m)
employee    (id, first_name, last_name, dept_id)
department  (id, dept_name)

// m-m user role 
user  (id, user_name, first_name, last_name, role_id)
role  (id, role_name, user_id)

> user
id      un    fn    ln   rid
1       un1   fn1   ln1  
2       un2   fn2   ln2  
3       un3   fn3   ln3  
4       un4   fn4   ln4   

> role 
id    n           uid
1     staff       
2     admin     

> user_role_map 
uid   rid 
1     s
1     a
2     s
2     a
~~~

### Tables
~~~ sql
-- employee
CREATE TABLE `lab`.`employee` (
  `uuid` VARCHAR(40) NOT NULL,
  `first_name` VARCHAR(100) NULL,
  `last_name` VARCHAR(100) NULL,
  `salary` DECIMAL(10) NULL,
  `date_of_birth` DATE NULL,
  `joined_date_time` DATETIME NULL,
  `manager_uuid` VARCHAR(45) NULL,
  `department_uuid` VARCHAR(45) NULL,
  PRIMARY KEY (`uuid`));

-- department 
CREATE TABLE `lab`.`department` (
  `uuid` VARCHAR(40) NOT NULL,
  `name` VARCHAR(100) NULL,
  `head_uuid` VARCHAR(40) NULL,
  PRIMARY KEY (`uuid`));
~~~

### Maven 
~~~
// scopes
 - compile 
 - test
 - provided 
 - system 
~~~

### Read 
 - Linux Directories explained : https://www.howtogeek.com/117435/htg-explains-the-linux-directory-structure-explained/
 - YAML https://www.youtube.com/watch?v=1uFVr15xDGg
 - Docker https://www.youtube.com/watch?v=pg19Z8LL06w
 - Docker https://github.com/vmaridu/notes/blob/master/cloud/docker/01-docker-commands.md
 - Docker File https://github.com/vmaridu/notes/blob/master/cloud/docker/03-docker-file.md
 - API Error handling https://www.baeldung.com/exception-handling-for-rest-with-spring
 - Spring JDBC https://www.tutorialspoint.com/springjdbc/springjdbc_update_query.htm
 - Spring JDBC https://medium.com/beingcoders/java-concepts-jdbctemplate-querying-spring-3192bed61f44
 - Spring Data JPA https://www.youtube.com/watch?v=8SGI_XS5OPw
 - Read API, Spring Data Pagination : https://www.baeldung.com/spring-data-jpa-pagination-sorting
 - OpenAPI Spec https://www.youtube.com/watch?v=InE6Odx--xo
 - OpenAPI Spec https://spec.openapis.org/oas/v3.1.0
