### TODO
  - Practice all Java stuff
  - Watch Rest API Standards Video
    - https://www.youtube.com/watch?v=5WXYw4J4QOU
    - https://adidas.gitbook.io/api-guidelines/rest-api-guidelines/protocol
    - https://adidas.gitbook.io/api-guidelines/rest-api-guidelines/message
    - https://adidas.gitbook.io/api-guidelines/rest-api-guidelines/execution
    - https://adidas.gitbook.io/api-guidelines/rest-api-guidelines/evolution
  - Create Spring Boot Service and Expose In memory Rest API (department and employee)

### Rest API
 - SOAP VS REST  
 - GET, PUT, POST, PATCH, DELETE, (HEAD, OPTIONS)
 - Idempotency 
 - Naming Standards 
 - Google and Read Interview Questions 
 - What is CORS ?


### API Design Example 
~~~
 - department (uuid, name, head)
 - employees (uuid, first_ame, last_name, manager, salery, date_of_birth, joined_date_time, department_uuid)

// get all employess 
GET /api/v1/employees?offset={offset}&limit={limit}

// get employee by department_uuid
GET /api/v1/employees?offset={offset}&limit={limit}&department_uuid={department_uuid}
 - pagination : ?offset={offset}&limit={limit}
 - filter     : ?department_uuid={department_uuid}

// get employee by uuid 
GET /api/v1/employees/{uuid}

// delete employee by uuid
DELETE /api/v1/employees/{uuid}

// update employee by uuid
PUT   /api/v1/employees/{uuid}
PATCH /api/v1/employees/{uuid}

// create employee
POST /api/v1/employees

// get departments 
GET /api/v1/departments?offset={offset}&limit={limit}

// get department by name 
GET /api/v1/departments?offset={offset}&limit={limit}&name={name}

// get department by uuid
GET /api/v1/departments/{uuid}

// delete department by uuid
DELETE /api/v1/departments/{uuid}

// update department by uuid
PUT   /api/v1/departments/{uuid}
PATCH /api/v1/departments/{uuid}

// create department 
POST /api/v1/departments

// http codes 
2xx, 4xx, 5xx  
2xx : 200, 201, 202, 204 
4xx : 400, 401, 403, 404, 409 
5xx : 500, 502 
~~~
