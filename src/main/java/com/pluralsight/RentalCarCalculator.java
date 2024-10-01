package com.pluralsight;
import java.util.*;

public class RentalCarCalculator {
    static Scanner scanner = new Scanner(System.in);
    static final double rentalPrice = 29.99;
    static final double tollTag = 3.95;
    static final double GPS = 2.95;
    static final double roadsideAssist = 3.95;
    static final double surcharge = 0.30;

    public static void main(String[] args){
        double runningTotal = 0.00;
        String eTag = promptUserYesOrNo("Do you want an electronic toll tag included ($3.95/day) ?");
        runningTotal += handleOptionCost(eTag, tollTag);
        String gpsOption = promptUserYesOrNo("Do you want an GPS included ($2.95/day) ?");
        runningTotal += handleOptionCost(gpsOption, GPS);
        String roadsideAssistOption = promptUserYesOrNo("Do you want roadside assistance ($3.95/day) ?");
        runningTotal += handleOptionCost(roadsideAssistOption, roadsideAssist);
        int userAge = promptUserNumeric("Enter your age: ");
        int numberOfDaysRenting = promptUserNumeric("How many days do you plan on renting for? ");
        System.out.println("--------------------------------------------------------------------------------------------");
        displayAndCalculate(rentalPrice*numberOfDaysRenting,userAge,runningTotal, numberOfDaysRenting);
    }

    public static double handleOptionCost(String userChoice, double costOfOption){
        double additionalCost = 0.00;
        if(userChoice.equalsIgnoreCase("Yes")||userChoice.equalsIgnoreCase("Y")) additionalCost+=costOfOption;

        return additionalCost;
    }

    public static String promptUserYesOrNo(String prompt){
        System.out.print(prompt);

        return scanner.nextLine();
    }

    public static int promptUserNumeric(String prompt){
        System.out.print(prompt);

        return scanner.nextInt();
    }

    public static void displayAndCalculate(double basicCarRental, int age, double optionsCost, int rentalDays){
        System.out.printf("Basic car rental price:   $%.2f" , basicCarRental);
        System.out.println("\nUnderage driver surcharge: " + ((age < 25)?30:0) + "%");
        System.out.printf("\nOptions cost:             $%.2f" , optionsCost);
        System.out.printf("\nTotal Cost:               $%.2f" , (age < 25)? ((basicCarRental + (basicCarRental * surcharge) + optionsCost)) : (basicCarRental + optionsCost));
    }
}
