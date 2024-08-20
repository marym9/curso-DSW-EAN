/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mayornumero;

import java.util.Scanner;

/**
 *
 * @author maribelmoreno
 */
public class Mayornumero {

    // Función para retornar el mayor de dos números
    public static int obtenerMayor(int numero1, int numero2) {
        if (numero1 > numero2) {
            return numero1;
        } else {
            return numero2;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer dos números enteros del usuario
        System.out.print("Ingrese el primer número: ");
        int numero1 = scanner.nextInt();

        System.out.print("Ingrese el segundo número: ");
        int numero2 = scanner.nextInt();

        // Llamar a la función obtenerMayor y almacenar el resultado
        int mayor = obtenerMayor(numero1, numero2);

        // Imprimir el mayor de los dos números
        System.out.println("El número mayor es: " + mayor);
    }
}
