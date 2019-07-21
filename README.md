# simple-benchmarking
Benchmarking collections and maps

# Run complete. Total time: 00:05:08 
putIfAbsent method

Benchmark| Mode | Cnt | Score | Error | Units
----------|------|-----|-------|-------|-------
Benchmarking.concurrentHashMap | thrpt | 25 | 43372761.247 | ± 651429.108 | ops/s
Benchmarking.concurrentSkipListMap | thrpt | 25 | 5086856.400 | ± 714719.454 | ops/s
Benchmarking.hashMap | thrpt | 25 | 101762845.018 | ± 22137242.257 | ops/s
Benchmarking.hashedMap | thrpt | 25 | 202934398.754 | ± 1196360.229 | ops/s
Benchmarking.linkedHashMap | thrpt | 25 | 134959663.750 | ± 1826147.825 | ops/s
Benchmarking.linkedMap | thrpt | 25 | 202828417.574 | ± 852522.297 | ops/s
Benchmarking.treeMap | thrpt | 25 | 12736632.683  | ± 1022799.291 | ops/s
