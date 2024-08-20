/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg12.diasiguiente;

import java.util.Scanner;

/**
 *
 * @author maribelmoreno
 */
public class DiaSiguiente {

    // Función para obtener el nombre del día siguiente
    public static String obtenerDiaSiguiente(String dia) {
        switch (dia.toLowerCase()) {
            case "lunes":
                return "martes";
            case "martes":
                return "miércoles";
            case "miércoles":
                return "jueves";
            case "jueves":
                return "viernes";
            case "viernes":
                return "sábado";
            case "sábado":
                return "domingo";
            case "domingo":
                return "lunes";
            default:
                return "Día no válido";
        }
    }

    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el nombre del día
        System.out.println("Ingrese el nombre de un día de la semana:");
        String dia = scanner.nextLine();

        // Obtener el nombre del día siguiente usando la función
        String diaSiguiente = obtenerDiaSiguiente(dia);

        // Imprimir el nombre del día siguiente
        if (diaSiguiente.equals("Día no válido")) {
            System.out.println(diaSiguiente);
        } else {
            System.out.println("El día siguiente a " + dia + " es " + diaSiguiente);
        }

        scanner.close();
    }
}
