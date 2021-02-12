# Problem Statement

Through using the air quality dataset to find which areas improved the most in terms of AQI index compared to the average AQI of the previous year.

# Proposed Solution

**We suggest to use Apache Flink to solve our problem. We suggest the following setup:**

- First operator layer to query the API in order to feed it downstream
- Second operator to compute the longest streak of good air quality

In order to keep track of city data, we recommend the usage of `keyBy` to transfer data downstream.

# Expectations

Efficient processing of air quality data in order to solve the challenge, give us more insight into air data to understand how the pandemic affected the global air changes.

# Experimental Plan

- Experiement with our Flink application by using the provded API test
- Use test data and provided logic code to compare our accuracy
- Use the API to test against our solution with the desired ones
- Grafana dashboards to better identitfy bottlenecks and potential issues

# Success Indicators

- Getting data back from the competition API
- Running the Flink application with no congestion or crashes
- Getting our solution past the competition

### Intermediate milestones

1. Understanding what we need to do, process the results
2. Communicating with the API and streaming the data through gRPC
3. Get a working solution running
4. Having good accuracy, completeing a rudimentary MVP Flink application

# Task assignment
