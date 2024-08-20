/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg1.metodoestatico;

import java.util.Scanner;

/**
 *
 * @author maribelmoreno
 */
public class Metodoestatico {
    // Función estática para calcular f(x, y)
    public static int calcularFuncion(int x, int y) {
        return (x * x) + (2 * x * y) + (y * y);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer los valores de x e y
        System.out.print("Ingrese el valor de x: ");
        int x = scanner.nextInt();

        System.out.print("Ingrese el valor de y: ");
        int y = scanner.nextInt();

        // Llamar a la función calcularFuncion y almacenar el resultado
        int resultado = calcularFuncion(x, y);

        // Imprimir el resultado
        System.out.println("El valor de la función f(x, y) es: " + resultado);
    }
}



