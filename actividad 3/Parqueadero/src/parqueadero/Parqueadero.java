/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parqueadero;

import java.util.ArrayList;
import java.util.List;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author maribelmoreno
 */
public class Parqueadero {
    private List<Vehiculo> vehiculos = new ArrayList<>();

    public void registrarEntrada(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public double registrarSalida(String placa) {
        Vehiculo vehiculo = buscarVehiculoPorPlaca(placa);
        if (vehiculo != null) {
            vehiculos.remove(vehiculo);
            return calcularCosto(vehiculo);
        }
        return -1;  // Indica que no se encontró el vehículo
    }

    public List<Vehiculo> consultarEstado() {
        return new ArrayList<>(vehiculos);  // Devuelve una copia de la lista
    }

    private Vehiculo buscarVehiculoPorPlaca(String placa) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equals(placa)) {
                return vehiculo;
            }
        }
        return null;
    }

    private double calcularCosto(Vehiculo vehiculo) {
        LocalDateTime horaSalida = LocalDateTime.now();
        Duration duracion = Duration.between(vehiculo.getHoraEntrada(), horaSalida);
        long horas = duracion.toHours();
        if (duracion.toMinutes() % 60 > 0) {
            horas++;  // Considerar fracciones de hora como una hora completa
        }

        double tarifa = 0;
        if (vehiculo instanceof Automovil) {
            tarifa = 5000;  // Ejemplo de tarifa por hora
        } else if (vehiculo instanceof Motocicleta) {
            tarifa = 2000;
        } else if (vehiculo instanceof Camion) {
            tarifa = 10000;
        }
        return horas * tarifa;
    }
}