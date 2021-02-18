# Problem Statement


The outbreak of COVID-19 in 2020 has created numerous social, economic, and environmental repercussions. As governments announced lockdowns to minimize the spread of the virus, many businesses closed their doors and regular commuters stayed at home, resulting in a reduction in the amount of air pollution caused by traffic and business operations. In fact, the Air Quality Index (AQI) has improved throughout the world since lockdowns began. 


This project will address the problem of air pollution and the effects of COVID-19 lockdowns on air pollution by using air quality datasets to detect which areas of the world improved the most in terms of AQI index compared to the average AQI of the previous year. This data analysis will be important for climate groups and governments to detect which countries are most impacted by traffic pollution which will also be helpful for mitigating the inevitable rise of air pollution once the COVID-19 pandemic subsides and lockdowns end.  


# Proposed Solution

We will implement two queries as outlined by the DEBS Grand Challenge. The first query returns the top 50 cities in terms of air quality improvement as well as their current air quality indices. The AQI for each city will be calculated from the average particles coming from geo-distributed air quality sensors over a sliding window of 24 hours. These windows will be sized relative to the watermark for the result of the batch or relative to the point in time of a snapshot when the snapshot is taken. The average particles over this window will be mapped to AQIp1 and AQIp2 values using a lookup table and formula, and the higher of the two will be taken as the AQI. This query will result in a ranking of the top 50 cities by their improvement over a 5-Day Average AQI compared to the previous year. Additionally, only active cities are included, which means at least one measurement for a city has been received in the last 10 minutes. 


The second query results in a histogram of the longest streaks of good air quality for the last 7 days, defined as the time span in seconds since a city flipped to a “good” AQI value. The histogram will have 14 buckets of equal length from 0 to the maximum length, and only active cities will be included. Both query 1 and query 2 will run in parallel. 


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
