### Agenda
 - CI/CD Basics  
 - Scheduler 
 - Actuator  
 - Rest Template Client



### CI/CD
~~~
// Git 
development, main, tags ()

// Deploymemt 
dev, qa, cat, staging, prod 

// merge to development
 - run unit and integration tests 
 - if fails send out email 
 - run various scans 
 - build 
 - push to nexus : date.snapshot 
 - deploy to dev env 

// development to main 
 - run unit and integration tests 
 - if fails send out email 
 - run various scans 
 - build 
 - create git tags 0.0.(X+1)
 - push to nexus : 0.0.(X+1)
 - deploy to qa env 
~~~


### Read 
 - CI/CD https://www.atlassian.com/continuous-delivery/principles/continuous-integration-vs-delivery-vs-deployment
 - Schduling https://www.baeldung.com/spring-scheduled-tasks
 - CRON https://productresources.collibra.com/docs/collibra/latest/Content/Cron/co_spring-cron.htm
 - RestTemplate https://reflectoring.io/spring-resttemplate/