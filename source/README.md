# Source

:hammer: All the fun! (=

## Each project should "obey" this protocol

### gets (text/html) echo message

```bash
$ curl -i localhost:3000/echo/World

HTTP/1.1 200 OK
Content-Type: text/html; charset=UTF-8
Content-Length: 21
Server: Jetty(9.1.3.v20140225)

<p>Echoing World!</p>
```

### gets (text/html) the number of accounts

```bash
$ curl -i localhost:3000/accounts

HTTP/1.1 200 OK
Content-Type: text/html; charset=UTF-8
Content-Length: 18
Server: Jetty(9.1.3.v20140225)

Stored Accounts: 3
```

### posts (application/json) new account and returns (application/json) a message

```bash
$ curl -i -H "Content-Type:application/json" -d \
 '{"account" : { "key" : "wallet", "description" : "My wallet"}}' \
  localhost:3000/accounts

HTTP/1.1 200 OK
Content-Type: application/json; charset=UTF-8
Transfer-Encoding: chunked
Server: Jetty(9.1.3.v20140225)

{"msg":"Account 'wallet' was created."}
```
