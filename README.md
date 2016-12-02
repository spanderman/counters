# counters

Build&run is maven based:

mvn spring-boot:run

App has three endpoints:

1. to increment a counter (POST): http://localhost:9000/counter/{counter}/increment

2. to query a counter value (GET): http://localhost:9000/counter/{counter}

3. to query all the counters (GET): http://localhost:9000/counter
