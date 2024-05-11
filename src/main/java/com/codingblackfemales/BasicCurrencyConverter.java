package com.codingblackfemales;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class BasicCurrencyConverter implements CurrencyConverter {

    Currencies currencies = new CurrenciesGBP();

    public BasicCurrencyConverter(Currencies currencies) { 
        this.currencies = currencies;
}

    public double convertCurrency (String sourceCurrencyCode, String destinationCurrencyCode, double amount) {
        double convertedAmount = 0;
        
        // if invalid amount
        if (amount <= 0) return convertedAmount;
        // check if currency code is in the list of currencies
        boolean sourceCurrencyFound = false;
        boolean destinationCurrencyFound = false;

        for (String code: getCurrencyCodes()) {
            if (code==sourceCurrencyCode) {
                sourceCurrencyFound = true;
            }
            if (code==destinationCurrencyCode) {
                destinationCurrencyFound = true;
            }
        }
        // if both source currency and destination are valid
		if(sourceCurrencyFound && destinationCurrencyFound) {
            convertedAmount = getExchangeRate(sourceCurrencyCode, destinationCurrencyCode) * amount;
        } else if (sourceCurrencyCode == "" || !sourceCurrencyFound) { //empty string or unsupported currencies
            System.out.println("Please enter a valid currency to convert from");
            convertedAmount = 0;
        } else if (destinationCurrencyCode == "" || !destinationCurrencyFound) { //empty string or unsupported currencies
            System.out.println("Please enter a valid currency to convert to");
            convertedAmount = 0;
        } else convertedAmount = 0; // for invalid amounts
        return convertedAmount;
}

    // returns the list of currencies
    public String[] getCurrencyCodes() {
        Set<String> currencyKeys = currencies.getAllExchangeRates().keySet();
        String[] currencyCodes = currencyKeys.toArray(String[]::new);
        return currencyCodes;
    }

    // get the conversion rate
    public double getExchangeRate (String sourceCurrencyCode, String destinationCurrencyCode) {
        double sourceValue = 0;
        double destinationValue = 0;
        double exchangeRate;

        HashMap<String, Double> currencyMap = currencies.getAllExchangeRates();

        for (Entry<String, Double> currency: currencyMap.entrySet()) {
            if (currency.getKey() == sourceCurrencyCode) {
                sourceValue = currency.getValue();
            }
        }

        for (Entry<String, Double> currency: currencyMap.entrySet()) {
            if (currency.getKey() == destinationCurrencyCode) {
                destinationValue = currency.getValue();
            }
        }
        exchangeRate = destinationValue/sourceValue;
        return exchangeRate;
    }
}