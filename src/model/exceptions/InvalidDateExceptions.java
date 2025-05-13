/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.exceptions;

/**
 *
 * @author julioarrtor
 */
public class InvalidDateExceptions extends Exception {
    // Constructor que recibe un mensaje de error personalizado
    public InvalidDateExceptions(String message) {
        super(message);  // Llama al constructor de la clase base Exception con el mensaje
    }
}