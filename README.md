# BankDemo
Demo application for banking transactions

The RESTful application will receive bank transaction data and store it into the PostGres database. The incoming data model should have the following fields:
- currency
- amount
- source account ID
 POST URL : http://localhost:8080/bankingservice/transcations/1002
 
 e.g json body
{
        "sourceAccountId": 1002,
        "amount": 200,
        "currency": "USD"
}

 
This application also returns all transactions and transactions specific to a particular source account id
Get All transactions : http://localhost:8080/bankingservice/transactions
Get transactions for a specific source account id : http://localhost:8080/bankingservice/transactions/1002

Health checks and probes:
http://localhost:8080/actuator/health
