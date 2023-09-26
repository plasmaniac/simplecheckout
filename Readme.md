Simple checkout api that accepts an array of strings as body, the array elements needs to be in known range (see spec).
Given this input this endpoint will calculate price according to pricelist and discounts where that apply (see spec again :-).

To run:
mvn install, then
java -jar target/checkout-0.0.1-SNAPSHOT.jar
will listen on 8080, so a valid curl would be;
curl -H "accept: application/json" -H "Content-Type:application/json" -d '["0001", "0002"]' http://localhost:8080/api/v1/checkout
{"price":1080.0,"error":null}%

Note that I included minimal error-handling here

 