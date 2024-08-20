/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg6.terreno;

import java.util.Scanner;

/**
 *
 * @author maribelmoreno
 */
public class Terreno {

    // Función para calcular el área de un rectángulo
    public static double calcularAreaRectangulo(double base, double altura) {
        return base * altura;
    }

    // Función para calcular la hipotenusa de un triángulo rectángulo
    public static double calcularHipotenusa(double catetoA, double catetoB) {
        return Math.sqrt(Math.pow(catetoA, 2) + Math.pow(catetoB, 2));
    }

    // Función para calcular el área de un triángulo
    public static double calcularAreaTriangulo(double base, double altura) {
        return 0.5 * base * altura;
    }

    // Función para calcular el perímetro del terreno
    public static double calcularPerimetroTerreno(double ladoA, double ladoB, double ladoC) {
        // Calcular la hipotenusa usando los lados A y B
        double hipotenusa = calcularHipotenusa(ladoA, ladoB);
        // El perímetro es la suma de todos los lados
        return ladoA + ladoB + ladoC + hipotenusa;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer las dimensiones de los lados A, B y C
        System.out.print("Ingrese la dimensión del lado A: ");
        double ladoA = scanner.nextDouble();

        System.out.print("Ingrese la dimensión del lado B: ");
        double ladoB = scanner.nextDouble();

        System.out.print("Ingrese la dimensión del lado C: ");
        double ladoC = scanner.nextDouble();

        // Calcular el área del rectángulo
        double areaRectangulo = calcularAreaRectangulo(ladoA, ladoB);

        // Calcular el área del triángulo
        double areaTriangulo = calcularAreaTriangulo(ladoC, ladoB);

        // Calcular el área total del terreno (suma del área del rectángulo y del triángulo)
        double areaTerreno = areaRectangulo + areaTriangulo;

        // Calcular el perímetro del terreno
        double perimetroTerreno = calcularPerimetroTerreno(ladoA, ladoB, ladoC);

        // Imprimir los resultados
        System.out.println("El área del terreno es: " + areaTerreno);
        System.out.println("El perímetro del terreno es: " + perimetroTerreno);
    }
}
