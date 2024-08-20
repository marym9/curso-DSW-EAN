/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg3.escalera;

import java.util.Scanner;

/**
 *
 * @author maribelmoreno
 */
public class Escalera {

    // Función para calcular la longitud de la escalera
    public static double calcularLongitudEscalera(double altura, double angulo) {
        // Convertimos el ángulo de grados a radianes
        double anguloRadianes = Math.toRadians(angulo);

        // Calculamos la longitud de la escalera usando la fórmula y = x / sin(α)
        double longitudEscalera = altura / Math.sin(anguloRadianes);

        return longitudEscalera;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer la altura de la escalera
        System.out.print("Ingrese la altura de la escalera (x): ");
        double altura = scanner.nextDouble();

        // Leer el ángulo de inclinación de la escalera
        System.out.print("Ingrese el ángulo de inclinación de la escalera (α en grados): ");
        double angulo = scanner.nextDouble();

        // Llamar a la función calcularLongitudEscalera y almacenar el resultado
        double longitudEscalera = calcularLongitudEscalera(altura, angulo);

        // Imprimir la longitud de la escalera
        System.out.println("La longitud de la escalera es: " + longitudEscalera);
    }
}
