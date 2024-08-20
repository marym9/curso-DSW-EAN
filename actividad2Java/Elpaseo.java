/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg2.elpaseo;

import java.util.Scanner;

/**
 *
 * @author maribelmoreno
 */
public class Elpaseo {

    // Función para calcular el número de buses necesarios
    public static int calcularBuses(int sillasPorBus, int estudiantesGordos, int estudiantesFlacos) {
        // Calculamos el número total de sillas requeridas
        int sillasRequeridas = (estudiantesGordos * 2) + estudiantesFlacos;

        // Calculamos el número de buses necesarios
        int numeroDeBuses = sillasRequeridas / sillasPorBus;

        // Si sobra alguna silla que no llena un bus, se necesita un bus adicional
        if (sillasRequeridas % sillasPorBus != 0) {
            numeroDeBuses++;
        }

        return numeroDeBuses;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer la cantidad de sillas por bus
        System.out.print("Ingrese el número de sillas por bus: ");
        int sillasPorBus = scanner.nextInt();

        // Leer la cantidad de estudiantes gordos
        System.out.print("Ingrese la cantidad de estudiantes gordos: ");
        int estudiantesGordos = scanner.nextInt();

        // Leer la cantidad de estudiantes flacos
        System.out.print("Ingrese la cantidad de estudiantes flacos: ");
        int estudiantesFlacos = scanner.nextInt();

        // Llamar a la función calcularBuses y almacenar el resultado
        int numeroDeBuses = calcularBuses(sillasPorBus, estudiantesGordos, estudiantesFlacos);

        // Imprimir el número de buses necesarios
        System.out.println("Se necesitan " + numeroDeBuses + " buses para el paseo.");
    }
}
