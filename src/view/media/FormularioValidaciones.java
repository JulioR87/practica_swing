/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.media;

import javax.swing.*;
import model.validations.UserDataValidations;

/**
 *
 * @author julioarrtor
 */
public class FormularioValidaciones extends JFrame {

    private JTextField txtNIF, txtFecha, txtNombre, txtEmail, txtEdad, txtCP;
    private JLabel lblResultadoNIF, lblResultadoFecha, lblResultadoNombre, lblResultadoEmail, lblResultadoEdad, lblResultadoCP;
    private JButton btnValidarNIF, btnValidarFecha, btnValidarNombre, btnValidarEmail, btnCalcularEdad, btnValidarCP;

    public FormularioValidaciones() {
        setTitle("Validador de Datos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(null);

        // NIF
        addLabel("NIF:", 30, 30);
        txtNIF = addTextField(150, 30);
        btnValidarNIF = addButton("Validar NIF", 350, 30);
        lblResultadoNIF = addLabelResultado(150, 60);

        btnValidarNIF.addActionListener(e -> {
            boolean valido = UserDataValidations.checkId(1, txtNIF.getText());  // Añadido el parámetro 1
            lblResultadoNIF.setText(valido ? "✔ Válido" : "✘ Inválido");
        });


        // Fecha
        addLabel("Fecha (dd/MM/yyyy):", 30, 90);
        txtFecha = addTextField(150, 90);
        btnValidarFecha = addButton("Validar Fecha", 350, 90);
        lblResultadoFecha = addLabelResultado(150, 120);

        btnValidarFecha.addActionListener(e -> {
            boolean valido = UserDataValidations.checkFormatDate(txtFecha.getText());  // Corregido el uso del parámetro
            lblResultadoFecha.setText(valido ? "✔ Válida" : "✘ Inválida");
        });

        // Nombre
        addLabel("Nombre:", 30, 150);
        txtNombre = addTextField(150, 150);
        btnValidarNombre = addButton("Validar Nombre", 350, 150);
        lblResultadoNombre = addLabelResultado(150, 180);

        btnValidarNombre.addActionListener(e -> {
            boolean valido = UserDataValidations.checkName(txtNombre.getText());  // Corregido el uso del parámetro
            lblResultadoNombre.setText(valido ? "✔ Válido" : "✘ Inválido");
        });

        // Email
        addLabel("Email:", 30, 210);
        txtEmail = addTextField(150, 210);
        btnValidarEmail = addButton("Validar Email", 350, 210);
        lblResultadoEmail = addLabelResultado(150, 240);

        btnValidarEmail.addActionListener(e -> {
            boolean valido = UserDataValidations.checkEmail(txtEmail.getText());  // Corregido el uso del parámetro
            lblResultadoEmail.setText(valido ? "✔ Válido" : "✘ Inválido");
        });

        // Edad
        addLabel("Edad (desde fecha):", 30, 270);
        txtEdad = addTextField(150, 270);
        btnCalcularEdad = addButton("Calcular Edad", 350, 270);
        lblResultadoEdad = addLabelResultado(150, 300);

        btnCalcularEdad.addActionListener(e -> {
            int edad = UserDataValidations.calculateAge(txtEdad.getText());
            lblResultadoEdad.setText(edad >= 0 ? "Edad: " + edad : "Fecha inválida");
        });

        // Código Postal
        addLabel("Código Postal:", 30, 330);
        txtCP = addTextField(150, 330);
        btnValidarCP = addButton("Validar CP", 350, 330);
        lblResultadoCP = addLabelResultado(150, 360);

        btnValidarCP.addActionListener(e -> {
            boolean valido = UserDataValidations.checkPostalCode(txtCP.getText());  // Corregido el uso del parámetro
            lblResultadoCP.setText(valido ? "✔ Válido" : "✘ Inválido");
        });
    }

    private void addLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 120, 25);
        this.add(label);
    }

    private JTextField addTextField(int x, int y) {
        JTextField field = new JTextField();
        field.setBounds(x, y, 180, 25);
        add(field);
        return field;
    }

    private JButton addButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 120, 25);
        add(button);
        return button;
    }

    private JLabel addLabelResultado(int x, int y) {
        JLabel label = new JLabel();
        label.setBounds(x, y, 200, 25);
        add(label);
        return label;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FormularioValidaciones().setVisible(true);
        });
    }
}