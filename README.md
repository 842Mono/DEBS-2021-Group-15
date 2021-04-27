# DSPA-8

DEBS Grand Challenge Project - Finding the most improved air quality indexes as an effect of covid

## Pre-reqs

- Apache Maven
- OpenJDK Version 15

## Code structure

### gRPC Client Communication

1. We first created a working gRPC client to communicate with the challenger API, this source code can be found in `src/gRPC`.

2. To run that client code alone and see the data being grabbed, you will need Apache Maven to compile the file. Please execute `compile.sh` in that source directory.

### Apache Flink execution

1. To compile the job for Apache Flink, you will need to also execute the corresponding `compile.sh` file located in the `src/flink` folder.

2. Navigate to your Flink job upload section, and upload the compiled jar file.

### Notes on interpreting Flink results

- Since the results are directly sent back to the server, we output the results sent using stout. You can take a look at the logs of the task managers to see what is currently going on within the application.