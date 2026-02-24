package Ejercicio6;

import java.util.Scanner;

public class Principal {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorCaja gestor = new GestorCaja();
        int numeroCaja;
        int opcion;
        do {
            System.out.println("\n===== MENÚ GESTIÓN DE CAJAS =====");
            System.out.println("1. Abrir caja");
            System.out.println("2. Cerrar caja");
            System.out.println("3. Nuevo cliente");
            System.out.println("4. Atender cliente");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Introduce el numero de la caja (1-20)");
                    numeroCaja = sc.nextInt();
                    try {
                        gestor.abrirCaja(numeroCaja);
                        System.out.println("Caja abierta correctamente");
                    } catch (CajaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Introduce el numero de la caja (1-20)");
                    numeroCaja = sc.nextInt();
                    try {
                        gestor.cerrarCaja(numeroCaja);
                    } catch (CajaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        gestor.nuevoCliente();
                    } catch (CajaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Introduce el numero de la caja (1-20)");
                    numeroCaja = sc.nextInt();
                    try {
                        gestor.atenderCliente(numeroCaja);
                    } catch (CajaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }

            if (opcion >= 1 && opcion <= 4) {
               gestor.mostrarEstadoCajas();
            }
        } while (opcion != 5);
    }


}
