### Agenda
 - CI/CD Basics  

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
