# Checkout Service

Checkout service is a Java based SpringBoot RESTful API designed to provide a checkout functionality for an e-commerce site. 
Promotions are introduced as a dependency allowing for them to be changed in line with the client's needs. 
Accessing the service using a POST call provides a simple way to access the service and to allow for scalability in line with the growth of the e-commerce business.


## Installation

Java 11 or higher is required. All other dependencies are managed within the build.gradle file.

## Usage

The service can be initialised through the DemoCheckoutApplication class or by running
```bash
gradle bootRun
```


Whilst running the service can be hit through a CURL request, a sample of which can be found below. 

```
curl --location --request POST 'http://localhost:8080/purchase' \
--header 'x-lbg-txn-correlation-id: test' \
--header 'Content-Type: application/json' \
--data-raw '{
    "items": [
        "0002",
        "0002",
        "0003",
        "0003"
    ]
}'
```

## Additional Promotions

Should additional promotions be required, a class implementing the Promotion interface should be created and included within the promotionalRules map. 