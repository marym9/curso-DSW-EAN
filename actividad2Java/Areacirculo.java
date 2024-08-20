/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg5.areacirculo;

import java.util.Scanner;

/**
 *
 * @author maribelmoreno
 */
public class Areacirculo {

    // Función para calcular el área de un círculo
    public static double calcularAreaCirculo(double radio) {
        return Math.PI * Math.pow(radio, 2);
    }

    // Función para calcular el área de la corona circular
    public static double calcularAreaCoronaCircular(double radioGrande, double radioPequeno) {
        // Calcular el área del círculo grande
        double areaGrande = calcularAreaCirculo(radioGrande);

        // Calcular el área del círculo pequeño
        double areaPequeno = calcularAreaCirculo(radioPequeno);

        // Calcular el área de la corona circular
        return areaGrande - areaPequeno;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el valor del radio pequeño
        System.out.print("Ingrese el valor del radio pequeño (r): ");
        double radioPequeno = scanner.nextDouble();

        // Leer el valor del radio grande
        System.out.print("Ingrese el valor del radio grande (R): ");
        double radioGrande = scanner.nextDouble();

        // Calcular el área de la corona circular usando la función correspondiente
        double areaCorona = calcularAreaCoronaCircular(radioGrande, radioPequeno);

        // Imprimir el resultado
        System.out.println("El área de la corona circular es: " + areaCorona);
    }
}
