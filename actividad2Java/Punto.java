/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg7.punto;

import java.util.Scanner;

/**
 *
 * @author maribelmoreno
 */
public class Punto {

    private double x;
    private double y;

    // Constructor
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Métodos para obtener coordenadas
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Método para calcular la distancia entre dos puntos
    public static double calcularDistancia(Punto p1, Punto p2) {
        double dx = p2.getX() - p1.getX();
        double dy = p2.getY() - p1.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Método para calcular la pendiente de la recta que une dos puntos
    public static double calcularPendiente(Punto p1, Punto p2) {
        double dx = p2.getX() - p1.getX();
        double dy = p2.getY() - p1.getY();
        if (dx == 0) {
            throw new ArithmeticException("La pendiente es indefinida (división por cero).");
        }
        return dy / dx;
    }

    // Método principal para ejecutar el programa
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer las coordenadas del primer punto
        System.out.println("Ingrese las coordenadas del primer punto (x1 y1):");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        Punto punto1 = new Punto(x1, y1);

        // Leer las coordenadas del segundo punto
        System.out.println("Ingrese las coordenadas del segundo punto (x2 y2):");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        Punto punto2 = new Punto(x2, y2);

        // Calcular distancia y pendiente
        double distancia = Punto.calcularDistancia(punto1, punto2);
        double pendiente = Punto.calcularPendiente(punto1, punto2);

        // Imprimir resultados
        System.out.printf("La distancia entre los puntos es: %.2f%n", distancia);
        System.out.printf("La pendiente de la recta que une los puntos es: %.2f%n", pendiente);

        scanner.close();
    }
}
