/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parqueadero;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author maribelmoreno
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parqueadero parqueadero = new Parqueadero();

        while (true) {
            System.out.println("\n--- GESTIÓN DE PARQUEADERO ---");
            System.out.println("1. Registrar entrada de vehículo");
            System.out.println("2. Registrar salida de vehículo");
            System.out.println("3. Consultar estado del parqueadero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    registrarEntrada(scanner, parqueadero);
                    break;
                case 2:
                    registrarSalida(scanner, parqueadero);
                    break;
                case 3:
                    consultarEstado(parqueadero);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void registrarEntrada(Scanner scanner, Parqueadero parqueadero) {
        System.out.print("Ingrese la placa del vehículo: ");
        String placa = scanner.nextLine();
        System.out.print("Ingrese la marca del vehículo: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese el modelo del vehículo: ");
        String modelo = scanner.nextLine();
        LocalDateTime horaEntrada = LocalDateTime.now();

        System.out.println("Seleccione el tipo de vehículo:");
        System.out.println("1. Automóvil");
        System.out.println("2. Motocicleta");
        System.out.println("3. Camión");
        int tipoVehiculo = scanner.nextInt();
        scanner.nextLine();  // Consumir la nueva línea

        Vehiculo vehiculo;
        switch (tipoVehiculo) {
            case 1:
                System.out.print("Ingrese el tipo de combustible: ");
                String tipoCombustible = scanner.nextLine();
                vehiculo = new Automovil(placa, marca, modelo, horaEntrada, tipoCombustible);
                break;
            case 2:
                System.out.print("Ingrese el cilindraje: ");
                int cilindraje = scanner.nextInt();
                scanner.nextLine();  // Consumir la nueva línea
                vehiculo = new Motocicleta(placa, marca, modelo, horaEntrada, cilindraje);
                break;
            case 3:
                System.out.print("Ingrese la capacidad de carga en toneladas: ");
                double capacidadCarga = scanner.nextDouble();
                scanner.nextLine();  // Consumir la nueva línea
                vehiculo = new Camion(placa, marca, modelo, horaEntrada, capacidadCarga);
                break;
            default:
                System.out.println("Tipo de vehículo no válido. No se registró la entrada.");
                return;
        }

        parqueadero.registrarEntrada(vehiculo);
        System.out.println("Entrada registrada correctamente.");
    }

    private static void registrarSalida(Scanner scanner, Parqueadero parqueadero) {
        System.out.print("Ingrese la placa del vehículo que desea registrar la salida: ");
        String placa = scanner.nextLine();
        double costo = parqueadero.registrarSalida(placa);
        if (costo >= 0) {
            System.out.println("Salida registrada correctamente. Costo total: $" + costo);
        } else {
            System.out.println("Vehículo no encontrado.");
        }
    }

    private static void consultarEstado(Parqueadero parqueadero) {
        List<Vehiculo> vehiculos = parqueadero.consultarEstado();
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos en el parqueadero.");
        } else {
            System.out.println("Vehículos en el parqueadero:");
            for (Vehiculo v : vehiculos) {
                System.out.println("Placa: " + v.getPlaca() + ", Marca: " + v.getMarca() + ", Modelo: " + v.getModelo());
            }
        }
    }
}