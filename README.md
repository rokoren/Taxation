# Taxation
Home Assignment

## Description

Taxation is a term for when a taxing authority (usually a government) imposes a tax. Imagine having multiple web sites in many countries (let's call these sites traders) out of which each must follow different local taxation rules and calculations. Site users bets an amount on the give odd, e.g. 5 EUR * 1.5 = 7.5 EUR. Everything will be done in EUR currency to keep it simple.

## Task

Prepare a REST service with specified input/output:

```json
"incoming": {
   "traderId": 1,
   "playedAmount": 5,
   "odd": 3.2
}
```

```json
"outgoing" {
   "possibleReturnAmount": Q,
   "possibleReturnAmountBefTax": W,
   "possibleReturnAmountAfterTax": X,
   "taxRate": Y,
   "taxAmount" Z
}
```

Your service must support two types of taxation:

1. General

   - taxation is done per rate or per amount:

   rate: 10%

       7.5EUR * 0.1 = 0.75EUR => possible return amount is 7.5EUR - 0.75EUR = 6.75

   amount: 2EUR

       7.5EUR - 2EUR = 5.5EUR => possible return amount is 5.5EUR


2. Winnings

   - winnings amount: 7.5EUR - 5EUR = 2.5EUR

   - taxation is done per rate or per amount:



   rate: 10%

       2.5EUR * 0.1 = 0.25EUR => possible return amount is 7.5EUR - 0.25EUR = 7.25EUR

   amount: 1EUR

       2.5EUR - 1EUR = 1.5EUR => possible return amount is 1.5EUR



Since your doing a REST service you don't have to bother with UI. The correctness of implementation can be shown with unit/integration tests or Postman (www.getpostman.com) calls. Technologies: JEE, Spring, Spring Boot, Maven, etc. How data is stored it's up to you :)
