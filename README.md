# Investment-Management-Application
This project is used to maintain a relationship between the Investors, Funds and Holdings. Using this application we can able to find the total market value on the basis of Investor Id and Funds Id.

Below are the API Contract.

1. API to add Investor and Fund. The value which we are passing in parent is Investor name and value which we are passing in the child is Fund name and level is 0.

Request :
curl --location --request POST 'localhost:8080/api/investment/entity' \
--header 'Content-Type: application/json' \
--data-raw '{
    "parent" : "A",
    "child" : "B",
    "level" : 0,
    "edge" : 20,
    "holdingValue" : 10
}'

Response :
{
    "investor": {
        "investorsId": 1,
        "investorsName": "A"
    },
    "funds": [
        {
            "fundsId": 2,
            "fundsName": "B"
        }
    ],
    "holdings": null
}


2. Same api is used to add Fund and Holding relation, At level 1 and level 2 value in the parent is Fund name and value in child is Holding name, edge means the quantity of funds and holding value means the price of holding.
Request :
curl --location --request POST 'localhost:8080/api/investment/entity' \
--header 'Content-Type: application/json' \
--data-raw '{
    "parent" : "B",
    "child" : "C",
    "level" : 1,
    "edge" : 20,
    "holdingValue" : 10
}'

Response :
{
    "investor": null,
    "funds": [
        {
            "fundsId": 2,
            "fundsName": "B"
        }
    ],
    "holdings": [
        {
            "holdingsId": 3,
            "holdingsName": "C"
        }
    ]
}

3. This api is used to get the total market value on the basis of the Investors Id and Funds Id
curl --location --request POST 'localhost:8080/api/totalMarketValue'
--header 'Content-Type: application/json'
--data-raw '{ "investorsId":1, "fundsId": 1 }'

Response:
{
    "totalMarketValueByInvestor": 200.0,
    "totalMarketValueByFunds": 0.0
}
