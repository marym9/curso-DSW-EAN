/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg11.numeroromano;

import java.util.Scanner;

/**
 *
 * @author maribelmoreno
 */
public class NumeroRomano {

    // Función para obtener la cifra de las decenas
    public static int obtenerDecenas(int numero) {
        return numero / 10;
    }

    // Función para obtener la cifra de las unidades
    public static int obtenerUnidades(int numero) {
        return numero % 10;
    }

    // Función para convertir un dígito de 0-9 a número romano
    public static String convertirUnidadesARomano(int unidades) {
        switch (unidades) {
            case 1: return "I";
            case 2: return "II";
            case 3: return "III";
            case 4: return "IV";
            case 5: return "V";
            case 6: return "VI";
            case 7: return "VII";
            case 8: return "VIII";
            case 9: return "IX";
            default: return "";
        }
    }

    // Función para convertir un dígito de 0-9 a número romano en decenas
    public static String convertirDecenasARomano(int decenas) {
        switch (decenas) {
            case 1: return "X";
            case 2: return "XX";
            case 3: return "XXX";
            case 4: return "XL";
            case 5: return "L";
            case 6: return "LX";
            case 7: return "LXX";
            case 8: return "LXXX";
            case 9: return "XC";
            default: return "";
        }
    }

    // Programa principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número entero
        System.out.println("Ingrese un número entero entre 1 y 99:");
        int numero = scanner.nextInt();

        // Verificar si el número está en el rango válido
        if (numero < 1 || numero > 99) {
            System.out.println("Error: El número debe estar entre 1 y 99.");
        } else {
            // Obtener las cifras de decenas y unidades
            int decenas = obtenerDecenas(numero);
            int unidades = obtenerUnidades(numero);

            // Convertir cifras a números romanos
            String romanoDecenas = convertirDecenasARomano(decenas);
            String romanoUnidades = convertirUnidadesARomano(unidades);

            // Mostrar el resultado
            System.out.println("Número en romanos: " + romanoDecenas + romanoUnidades);
        }

        scanner.close();
    }
}
