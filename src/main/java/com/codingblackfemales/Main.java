package com.codingblackfemales;


import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        currencyTest();
    }

    public static void currencyTest() {
        Currencies currencies = new CurrenciesGBP();
        BasicCurrencyConverter basicCurrencyConverter = new BasicCurrencyConverter(currencies);

        System.out.println(basicCurrencyConverter.convertCurrency("EUR", "JPY", 10));
    }

    public static void currencyTestWithScanner(){
        Currencies currencies = new CurrenciesGBP();
        BasicCurrencyConverter basicCurrencyConverter = new BasicCurrencyConverter(currencies);

        Scanner scanner = new Scanner(new InputStreamReader(System.in));
 
        System.out.println("Enter the currency you want to convert from: ");  
        String sourceCurrency = scanner.next().toUpperCase();

        System.out.println("Enter the currency you want to convert to: ");  
        String destinationCurrency = scanner.next().toUpperCase();

        System.out.println("Enter the amount of " + sourceCurrency + " you want to convert to " + destinationCurrency);  
        double amountToConvert = scanner.nextDouble(); 
       
        System.out.println("Converting "+ amountToConvert+" "+sourceCurrency + " to " + destinationCurrency);
        
        System.out.println(basicCurrencyConverter.convertCurrency("USD", destinationCurrency, amountToConvert));
        
        scanner.close();
    }
}
