# Problem Statement


The outbreak of COVID-19 in 2020 has created numerous social, economic, and environmental repercussions. As governments announced lockdowns to minimize the spread of the virus, many businesses closed their doors and regular commuters stayed at home, resulting in a reduction in the amount of air pollution caused by traffic and business operations. In fact, the Air Quality Index (AQI) has improved throughout the world since lockdowns began. 


This project will address the problem of air pollution and the effects of COVID-19 lockdowns on air pollution by using air quality datasets to detect which areas of the world improved the most in terms of AQI index compared to the average AQI of the previous year. This data analysis will be important for climate groups and governments to detect which countries are most impacted by traffic pollution which will also be helpful for mitigating the inevitable rise of air pollution once the COVID-19 pandemic subsides and lockdowns end.  


# Proposed Solution

We will implement two queries as outlined by the DEBS Grand Challenge. The first query returns the top 50 cities in terms of air quality improvement as well as their current air quality indices. The AQI for each city will be calculated from the average particles coming from geo-distributed air quality sensors over a sliding window of 24 hours. These windows will be sized relative to the watermark for the result of the batch or relative to the point in time of a snapshot when the snapshot is taken. The average particles over this window will be mapped to AQIp1 and AQIp2 values using a lookup table and formula, and the higher of the two will be taken as the AQI. This query will result in a ranking of the top 50 cities by their improvement over a 5-Day Average AQI compared to the previous year. Additionally, only active cities are included, which means at least one measurement for a city has been received in the last 10 minutes. 


The second query results in a histogram of the longest streaks of good air quality for the last 7 days, defined as the time span in seconds since a city flipped to a ???good??? AQI value. The histogram will have 14 buckets of equal length from 0 to the maximum length, and only active cities will be included. Both query 1 and query 2 will run in parallel. 

## Considered solutions
- DIY framework to process the API call and process results
  - Possibility of higher performance
  - However may be time consuming and too technical
- Apache Flink
  - Supports batching
  - High-level API
    - `Map`
    - `GroupBy`
    - `Window`
    - `Join`
  - Guarantees *exactly-once* processing
- Apache Storm
  - High performance
  - No batching support
  - Guarantees *at-least-once* processing
    - *Exactly-once* processing requires **Trident**, another high level API

Since Flink offers easier implementation, faster development and more features, we choose to select Apache Flink to solve our problem.

**We suggest to use Apache Flink to solve our problem. We suggest the following setup:**

- First operator layer to query the API in order to feed it downstream
- Second operator to compute the longest streak of good air quality

In order to keep track of city data, we recommend the usage of `keyBy` to transfer data downstream.

# Expectations

The expected effects of the proposed solution are efficient processing of air quality data to solve the DEBS Grand Challenge, giving organizations more insight into how the pandemic has affected air quality throughout the world. While the general structure of what needs to be implemented is provided in the DEBS Grand Challenge guidelines, our solution will attempt to run the queries as efficiently as possible by tweaking implementation and other parameters in Apache Flink. 

# Experimental Plan

We plan to experiment our implementation by using the API provided by the DEBS Grand Challenge and running our solution with their tests to see how efficient and correct our solution is compared to solutions from other teams. We will use the dataset provided and starter code to build off of and compare accuracy. We plan to use Grafana dashboards to better identify bottlenecks and potential issues. 

# Success Indicators

The expected outcome of our solution is the implementation of the two specified queries in parallel that run correctly and efficiently. Success will be measured by the tests the DEBS Grand Challenge provides for us to utilize as well as our ranking compared to other teams. Our intermediate milestones include getting data from the API provided by the DEBS Grand Challenge by configuring Java gRPC to query the data from this API, completing operators for Query 1 and Query 2, running the Flink application with no congestion or crashes, and getting our solution accepted by the competition. 

### Intermediate milestones

1. Understanding what we need to do, process the results
2. Communicating with the API and streaming the data through gRPC
3. Get a working solution running
4. Having good accuracy, completeing a rudimentary MVP Flink application

# Task assignment

- Baiqing Lyu
    - Configuring Java gRPC to query data from the competition API
        - Completing the source layer within the Flink application
    - Helping in designing Flink application topology
    - Assist in Flink performance optimizations
- Snigdha Kalathur
    - Designing and implementing the operators for queries 1 and 2
    - Assisting in researching Flink usage
- Mina Morcos
    - Designing the operators for queries 1 and 2.
    - Implementing the operators for queries 1 and 2.
    - Final deployment of the application (docker work, etc...)

# Note about task dependency, task sequencing and duplicate tasks.

Some of the tasks depend on other tasks. There are design tasks and implementation tasks. Generally, we believe that implementation tasks depend on design tasks. We should be designing before we implement. Also, the final deployment task should be done at the very end (after we're done designing and implementing). So the order should be something like: design, then implement, then deploy. However, these rules are not 100% strict. We may adjust our designs while implementing. Also, after deployment, we may improve our design and then re-implement and then re-deploy. So it might turn out to be a bit of an iterative process.

For duplicate tasks, we will most definitely meet in order to discuss how we will tackle a task. During the meeting, we should decide whether we will divide the task into sub-tasks or whether we will just sit down together and collaborate on the task (maybe if the task seems to be tougher than usual). It should highly depend on the task.

Those were our thoughts about the topic. We think that these thoughts are like a blue print. Things will get clearer as we go deeper into the work.
