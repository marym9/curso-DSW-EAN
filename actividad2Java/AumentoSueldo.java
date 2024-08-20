/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg13.aumentosueldo;

import java.util.Scanner;

/**
 *
 * @author maribelmoreno
 */
public class AumentoSueldo {

    // Función para calcular el aumento del sueldo
    public static double calcularAumento(double sueldoActual) {
        double aumento;
        if (sueldoActual <= 800000) {
            aumento = sueldoActual * 0.10; // 10% de aumento
        } else if (sueldoActual <= 1200000) {
            aumento = sueldoActual * 0.08; // 8% de aumento
        } else {
            aumento = sueldoActual * 0.05; // 5% de aumento
        }
        return aumento;
    }

    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el sueldo actual del empleado
        System.out.println("Ingrese el sueldo actual del empleado:");
        double sueldoActual = scanner.nextDouble();

        // Calcular el aumento usando la función
        double aumento = calcularAumento(sueldoActual);

        // Calcular el nuevo sueldo
        double nuevoSueldo = sueldoActual + aumento;

        // Imprimir el aumento y el nuevo sueldo
        System.out.printf("El aumento del sueldo es: %.2f%n", aumento);
        System.out.printf("El nuevo sueldo del empleado es: %.2f%n", nuevoSueldo);

        scanner.close();
    }
}
