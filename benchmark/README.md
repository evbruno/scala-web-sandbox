# Benchmark

Some dummy stats (no jMeter yet).

### First round

```
$ ab -n 10000 -c 8 http://localhost:9999/accounts

$ ab -n 10000 -c 8 -T "application/json" -p account.json http://localhost:9999/accounts
```

*[Scalatra + MongoDB](../source/scalatra-mongodb)*

| Concurreny | OP | Throughput | # erros |
|:----------:|----------------|:----------:|:-------:|
| 1 | Post /accounts | 650.38 | 0 |
| 2 | Post /accounts | 915.79 | 0 |
| 4 | Post /accounts | 804.82 | 0 |
| 8 | Post /accounts | 946.8 | 0 |
| 1 | Get /accounts | 702.66 | 0 |
| 2 | Get /accounts | 1030.34 | 0 |
| 4 | Get /accounts | 1017.36 | 0 |
| 8 | Get /accounts | 820.33 | 0 |

*[Rails + Sqlite3](https://github.com/evbruno/rails-sandbox)*

| Concurreny | OP | Throughput | # erros |
|:----------:|----------------|:----------:|:-------:|
| 1 | Post /accounts | 110.04 | 0 |
| 2 | Post /accounts | 42.16 | 0 |
| 4 | Post /accounts | 23.98 | 62 |
| 8 | Post /accounts | 9.25 | 137 |
| 1 | Get /accounts | 234.98 | 0 |
| 2 | Get /accounts | 241.79 | 0 |
| 4 | Get /accounts | 239.77 | 0 |
| 8 | Get /accounts | 214.89 | 0 |
