## What is it

This repository has two main folders; the Main and the Test. The Main contains my implementation of the Currency Converter Application.

The Main folder has five java files:

1. BasicCurrencyConverter.java - this contains a class which implements CurrencyConverter interface, and 3 methods.

2. Currencies.java - has a Currencies interface with a getAllExchangeRates() method.

3. CurrenciesGBP.java - a class which implements the Currencies interface and stores the hard-coded map of currencies and their values (relative to GBP).

4. CurrencyConverter.java - has a CurrencyConverter interface with three (abstract) methods.

5. Main.java - with a main class where the currency converter application can run.

## How it works
To use the methods in the BasicCurrencyConverter class, an instance of the class needs to be created. 
BasicCurrencyConverter also takes an implementation of Currencies, so an instance of Currencies (e.g. CurrenciesGBP or CurrenciesStub in the Test folder) needs to be created - see Main.java.

The actual method which does the conversion is the convertCurrency() method. It requires 3 arguments to be parsed into it:

- the source currency, a string

- the destination currency, a string

- the amount, a double

There are 4 currencies currently supported: GBP, EUR, USD and JPY. The method returns 0 when null or unsupported currencies are parsed and if an invalid amount is parsed. 

### Miscellanous
- Although the README.MD says the CurrencyConverter interface should have 3 methods with certain return requirements; this methods have been defined as abstract for the class implementation to define, rather than default.

- Although the  README.MD also says exceptions should be handled, these have been handled with an if-else block rather than throwing and catching exceptions, as this is what the tests support (and it's less expensive).

