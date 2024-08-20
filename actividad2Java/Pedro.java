/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg4.pedro;

import java.util.Scanner;
/**
 *
 * @author maribelmoreno
 */
public class Pedro {
    
    // Función para calcular el gasto en arriendo
    public static double calcularGastoArriendo(double sueldo) {
        return sueldo * 0.40;
    }

    // Función para calcular el gasto en comida
    public static double calcularGastoComida(double sueldo) {
        return sueldo * 0.15;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el sueldo de Pedro
        System.out.print("Ingrese el sueldo de Pedro: ");
        double sueldo = scanner.nextDouble();

        // Llamar a las funciones para calcular el gasto en arriendo y comida
        double gastoArriendo = calcularGastoArriendo(sueldo);
        double gastoComida = calcularGastoComida(sueldo);

        // Calcular cuánto dinero le queda a Pedro
        double dineroRestante = sueldo - (gastoArriendo + gastoComida);

        // Imprimir los resultados
        System.out.println("Gasto en arriendo: $" + gastoArriendo);
        System.out.println("Gasto en comida: $" + gastoComida);
        System.out.println("Dinero restante: $" + dineroRestante);
    }
}


    