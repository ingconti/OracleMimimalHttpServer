# OracleMimimalHttpServer

taken from:
// https://docs.oracle.com/en/java/javase/12/docs/api/jdk.httpserver/com/sun/net/httpserver/package-summary.html

USAGE:

POST:
curl -X POST "http://127.0.0.1:8000" -d "gimmeanswer=please&user=john"

GET:
curl "http://127.0.0.1:8000/?gimmeanswer=please&id=100"

You can use in Browser:

http://127.0.0.1:8000/?gimmeanswer=please&user=john

