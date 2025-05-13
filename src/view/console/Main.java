/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.console;

import java.util.Scanner;
import model.validations.UserDataValidations;
/**
 *
 * @author julioarrtor
 */
public class Main {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args){
        sc.useDelimiter("\n");
        String option;
        
        do{
            System.out.println("TESTER FUNCIONES UsededataValidations:");
            System.out.println("1.-testChekId");
            System.out.println("2.-testChekIdFormatDate");
            System.out.println("3.- testCalculateAge");
            System.out.println("4.-testChekPostalCode");
            System.out.println("5.-testChekisNumeric");
            System.out.println("6.-testChekisAlphabetic");
            System.out.println("7.-testChekEmail");
            System.out.println("8.-testChekName");
            System.out.println("Z.-Salir");
            
            System.out.println("Option: ");
            option = sc.next();
            
            switch (option){
                case "1":
                    testCheckId();
                    break;
                case "2":
                    testCheckFormatDate();
                    break;
                 case "3":
                    testCalculateAge();
                    break;
                case "4":
                    testCheckPostalCode();
                    break;
                case "5":
                    testCheckNumeric();
                    break;
                case "6":
                    testCheckAlphabetic();
                    break;
                case "7":
                    testCheckEmail();
                    break;
                case "8":
                    testCheckName();
                    break;
                case "Z":
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Incorrect option");
            }
            
        }while (!option.equals("Z"));
    }
    
    static void testCheckId(){
        System.out.println("Enter your id: ");
        String nif = sc.next();
        try {
            UserDataValidations.checkId(1, nif);
            System.out.println("The date format is correct.");
        } catch (InvalidDateException e){
            System.out.println("Wrong date format: " + e.getMessage());
        }

    }
    
    static void testCheckFormatDate(){
        System.out.println("Enter the date (dd/mm/yyyy): ");
        String date = sc.next();
        boolean dateOk = UserDataValidations.checkFormatDate(date);  // Corregido el uso del parámetro
        if (dateOk) {
            System.out.println("The date format is correct.");
        } else {
            System.out.println("Wrong date format.");
        }
    }
    
    static void testCalculateAge(){
        System.out.println("Enter your birthdate (dd/mm/yyyy): ");
        String birthDate = sc.next();
        int age = UserDataValidations.calculateAge(birthDate);
        if (age == -1) {
            System.out.println("Invalid date.");
        } else {
            System.out.println("Your age is: " + age);
        }
    }
    
    static void testCheckPostalCode(){
        System.out.println("Enter your postal code (5 digits): ");
        String zip = sc.next();
        boolean zipOk = UserDataValidations.checkPostalCode(zip);  // Corregido el uso del parámetro
        if (zipOk) {
            System.out.println("The postal code is correct.");
        } else {
            System.out.println("Wrong postal code.");
        }
    }
    
    static void testCheckNumeric(){
        System.out.println("Enter a numeric value: ");
        String value = sc.next();
        boolean isNumeric = UserDataValidations.isNumeric(value);  // Corregido el uso del parámetro
        if (isNumeric) {
            System.out.println("The value is numeric.");
        } else {
            System.out.println("The value is not numeric.");
        }
    }
    
    static void testCheckAlphabetic(){
        System.out.println("Enter a string to check if it contains only letters: ");
        String value = sc.next();
        boolean isAlphabetic = UserDataValidations.isAlphabetic(value);  // Corregido el uso del parámetro
        if (isAlphabetic) {
            System.out.println("The string contains only letters.");
        } else {
            System.out.println("The string contains non-alphabetic characters.");
        }
    }
    
    static void testCheckEmail(){
        System.out.println("Enter your email: ");
        String email = sc.next();
        boolean emailOk = UserDataValidations.checkEmail(email);  // Corregido el uso del parámetro
        if (emailOk) {
            System.out.println("The email is correct.");
        } else {
            System.out.println("Wrong email format.");
        }
    }
    
    static void testCheckName(){
        System.out.println("Enter your name: ");
        String name = sc.next();
        boolean nameOk = UserDataValidations.checkName(name);  // Corregido el uso del parámetro
        if (nameOk) {
            System.out.println("The name is valid.");
        } else {
            System.out.println("Wrong name format.");
        }
    }
}


    

