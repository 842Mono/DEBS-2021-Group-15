# Flink implementation

This directory contains the source code for our flink application, taken and adapted from the wiki-edits project provided in class.



## Query 1

- Add details

## Query 2

- Add details

---

**Flink operator layout**



Source layer

- Contacts the debs servers and pulls data using gRPC

- Passed down data
  
  1. `List<Location>`
  
  2. `Batch` - Contains measurements
  
  3. 