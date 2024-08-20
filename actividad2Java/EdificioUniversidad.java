/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg8.edificiouniversidad;

import java.util.Scanner;

/**
 *
 * @author maribelmoreno
 */
public class EdificioUniversidad {

    // Método para calcular el número de salones
    public static int calcularNumeroSalones(int numeroEstudiantes, int capacidadSalon) {
        // Asegurarse de que el número de salones sea un entero y que no haya salones fraccionarios
        return (int) Math.ceil((double) numeroEstudiantes / capacidadSalon);
    }

    // Método para calcular el número de pisos
    public static int calcularNumeroPisos(int numeroSalones, int salonesPorPiso) {
        // Asegurarse de que el número de pisos sea un entero y que no haya pisos fraccionarios
        return (int) Math.ceil((double) numeroSalones / salonesPorPiso);
    }

    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de estudiantes
        System.out.println("Ingrese el número de estudiantes:");
        int numeroEstudiantes = scanner.nextInt();

        // Leer la capacidad de un salón
        System.out.println("Ingrese la capacidad de un salón:");
        int capacidadSalon = scanner.nextInt();

        // Leer el número de salones por piso
        System.out.println("Ingrese el número de salones por piso:");
        int salonesPorPiso = scanner.nextInt();

        // Calcular el número de salones
        int numeroSalones = calcularNumeroSalones(numeroEstudiantes, capacidadSalon);
        System.out.println("Número de salones necesarios: " + numeroSalones);

        // Calcular el número de pisos
        int numeroPisos = calcularNumeroPisos(numeroSalones, salonesPorPiso);
        System.out.println("Número de pisos necesarios: " + numeroPisos);

        scanner.close();
    }
}
