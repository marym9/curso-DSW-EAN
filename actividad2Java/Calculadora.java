/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg10.calculadora;

import java.util.Scanner;

/**
 *
 * @author maribelmoreno
 */
public class Calculadora {

    // Método para aplicar la operación aritmética
    public static double aplicarOperacion(int num1, int num2, String operador) {
        switch (operador) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return (double) num1 / num2;
                } else {
                    throw new ArithmeticException("No se puede dividir por cero.");
                }
            case "%":
                if (num2 != 0) {
                    return num1 % num2;
                } else {
                    throw new ArithmeticException("No se puede calcular el módulo con divisor cero.");
                }
            case "**":
                return Math.pow(num1, num2);
            default:
                throw new IllegalArgumentException("Operador no soportado.");
        }
    }

    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer los dos números enteros
        System.out.println("Ingrese el primer número:");
        int num1 = scanner.nextInt();
        System.out.println("Ingrese el segundo número:");
        int num2 = scanner.nextInt();

        // Leer el operador aritmético
        System.out.println("Ingrese el operador aritmético (+, -, *, /, %, **):");
        String operador = scanner.next();

        // Calcular el resultado usando la función
        try {
            double resultado = aplicarOperacion(num1, num2, operador);
            System.out.printf("El resultado de %d %s %d es: %.2f%n", num1, operador, num2, resultado);
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
