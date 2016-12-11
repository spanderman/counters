# counters

Build&run is maven based:

mvn spring-boot:run

App has three endpoints:

1. to increment a counter (POST): http://localhost:9000/counter/{counter}/increment

2. to query a counter value (GET): http://localhost:9000/counter/{counter}

3. to query all the counters (GET): http://localhost:9000/counter

App is currently deployed on Heroku:

1. to increment a counter (POST): https://salty-inlet-58034.herokuapp.com/counter/{counter}/increment

2. to query a counter value (GET): https://salty-inlet-58034.herokuapp.com/counter/{counter}

3. to query all the counters (GET): https://salty-inlet-58034.herokuapp.com/counter
