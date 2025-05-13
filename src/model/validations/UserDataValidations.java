/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import javax.naming.InvalidNameException;
import model.exceptions.InvalidDateExceptions;

/**
 *
 * @author julioarrtor
 */
public class UserDataValidations {
    
    /**
     * Debe validar si el documento idneficativo recibido es correcto o no. 
     * @param typeDoc indica el tipo de documento identidicativo (NIF - 1,....)
     * @param id  contiene el documento identificativo a validar
     * @return devuelve true si el formato del documento es correcto y false en caso contrario
     */
    public static void checkId(int typeDoc, String id) throws InvalidNameException {

        // Verificamos que el número de documento sea 1 (NIF)
        if (typeDoc != 1) {
            throw new InvalidNameException("El tipo de documento no es válido.");
        }

        // Validamos si el NIF contiene 9 caracteres
        if (id == null || id.length() != 9) {
            throw new InvalidNameException("El NIF debe tener 9 caracteres.");
        }

        // Se separa los 8 primeros caracteres (que son números) y el último (que es letra)
        String numbersPart = id.substring(0, 8);
        char letterPart = id.charAt(8);

        // Validación de los 8 primeros caracteres sean dígitos
        if (!numbersPart.matches("\\d{8}")) {
            throw new InvalidNameException("El NIF debe contener 8 dígitos seguidos.");
        }

        // Se calcula la letra correcta
        String validLetters = "TRWAGMYFPDXBNJZSQVHLCKE";
        int number = Integer.parseInt(numbersPart);
        char correctLetter = validLetters.charAt(number % 23);

        // Comprobar si la letra proporcionada es la correcta
        if (letterPart != correctLetter) {
            throw new InvalidNameException("La letra del NIF no es válida.");
        }
    }

    /**
     * Valida que el formato de la fecha y su valor sea correcto
     * @param date la fecha a validar
     * @throws InvalidDateException si el formato o valor de la fecha es incorrecto
     */
    public static void checkFormatDate(String date) throws InvalidDateExceptions {

        // Usamos split para separar la fecha en día, mes y año
        String[] parts = date.split("/");

        // Verificamos si hay exactamente 3 partes (día, mes, año)
        if (parts.length != 3) {
            throw new InvalidDateExceptions("La fecha debe tener el formato DD/MM/AAAA.");
        }

        try {
            // Convertimos día, mes y año a enteros
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);

            // Verificamos que el mes esté entre 1 y 12
            if (month < 1 || month > 12) {
                throw new InvalidDateExceptions("El mes debe estar entre 1 y 12.");
            }

            // Verificamos que el día sea válido para el mes y año dados
            int maxDay = getMaxDayForMonth(month, year);
            if (day < 1 || day > maxDay) {
                throw new InvalidDateExceptions("El día no es válido para el mes y año dados.");
            }

        } catch (NumberFormatException e) {
            throw new InvalidDateExceptions("La fecha contiene valores no válidos.");
        }
    }

    // Función auxiliar para obtener el número máximo de días de un mes
    private static int getMaxDayForMonth(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                // Año bisiesto
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 0;
        }
    }

    /**
     * Calcular la edad basada en la fecha de nacimiento
     * @param birthDate la fecha de nacimiento
     * @return la edad calculada, o -1 si la fecha es inválida
     */
    public static int calculateAge(String birthDate) {
        try {
            checkFormatDate(birthDate); // Lanza una excepción si la fecha es incorrecta
        } catch (InvalidDateExceptions e) {
            return -1; // Fecha inválida
        }

        String[] parts = birthDate.split("/"); // Dividimos la fecha
        int birthYear = Integer.parseInt(parts[2]);
        int birthMonth = Integer.parseInt(parts[1]);
        int birthDay = Integer.parseInt(parts[0]);

        int currentYear = 2025; // Año actual (simulado)
        int currentMonth = 1;  // Mes actual
        int currentDay = 27;   // Día actual

        int age = currentYear - birthYear;

        // Ajustar la edad si no ha pasado el cumpleaños este año
        if (birthMonth > currentMonth || (birthMonth == currentMonth && birthDay > currentDay)) {
            age--;
        }

        return age;
    }

    // Otros métodos como checkPostalCode, isNumeric, isAlphabetic y checkEmail permanecen igual

    public static boolean checkPostalCode(String zip) {
        return zip.length() == 5 && isNumeric(zip);
    }

    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isAlphabetic(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }

        return true;
    }

    public static boolean checkEmail(String email) {
        if (email == null || !email.contains("@")) {
            return false;
        }

        String[] parts = email.split("@");
        if (parts.length != 2) {
            return false;
        }

        String domain = parts[1];
        if (!domain.contains(".")) {
            return false;
        }

        String[] domainParts = domain.split("\\.");
        String extension = domainParts[domainParts.length - 1];
        if (extension.length() < 2 || extension.length() > 3) {
            return false;
        }

        return true;
    }
}

    

