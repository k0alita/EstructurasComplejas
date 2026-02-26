package Ejercicio6v2;

import Ejercicio6v2.Caja;
import Ejercicio6v2.Cliente;
import utils.MiEntradaSalidaException;
import Ejercicio6v2.SupermercadoException;
import utils.MiEntradaSalida;

import java.util.ArrayList;
import java.util.List;

public class Almacen {

    private final int MAX_CAJAS = 20;
    private List<Caja> cajas;

    public Almacen() {
        cajas = new ArrayList<>(MAX_CAJAS);
        crearCajas();
    }

    public void crearCajas() {
        for (int i = 0; i < MAX_CAJAS; i++) {
            Caja caja = new Caja();
            cajas.add(caja);
        }
    }

    public void abrirCaja() {
        try {
            int numCaja = MiEntradaSalida.leerEnteroRango("Elige la caja que quieras abrir", 1, 20);
            cajas.get(numCaja - 1).abrirCaja();

        } catch (MiEntradaSalidaException | SupermercadoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void cerrarCaja() {
        try {
            int numCaja = MiEntradaSalida.leerEnteroRango("Elige la caja que quieras cerrar", 1, 20);
            cajas.get(numCaja - 1).cerrarCaja();
        } catch (SupermercadoException | MiEntradaSalidaException e) {
            System.out.println(e.getMessage());
        }
    }


    public void nuevoCliente() throws SupermercadoException {
        Cliente cliente = new Cliente();

        Caja c = cajas.stream().filter(Caja::isEstaAbierta).min(Caja::compareTo).orElseThrow(() -> new SupermercadoException("No hay cajas abiertas"));
        c.anadirCliente(cliente);
        System.out.println("El cliente numero " + cliente.getNUM_CLIENTE() + " se ha ido a la caja " + c.getNUMERO_DE_CAJA());
    }

    public void atenderCliente() throws MiEntradaSalidaException, SupermercadoException {

        int numeroDeCajaElegida = MiEntradaSalida.leerEnteroRango("Que caja quieres atender", 1, cajas.size()) - 1;
        Cliente clienteAtendido = cajas.get(numeroDeCajaElegida).atenderCliente();

        System.out.println("Se ha atendido al cliente con numero " + clienteAtendido.getNUM_CLIENTE());

    }


    static void main(String[] args) {


        Almacen almacen = new Almacen();

        int opcion = 0;


        System.out.println("==================================");
        System.out.println("    Bienvenido al Supermercado");
        System.out.println("==================================");

        do {
            try {


                System.out.println("Elige una de estas opciones: ");
                System.out.println("1. Abrir caja");
                System.out.println("2. Cerrar caja");
                System.out.println("3. Nuevo cliente");
                System.out.println("4. Atender cliente");
                System.out.println("5. Salir");

                opcion = MiEntradaSalida.leerEnteroRango("Que quieres hacer: ", 1, 5);

                switch (opcion) {
                    case 1 -> {
                        almacen.abrirCaja();
                    }
                    case 2 -> {
                        almacen.cerrarCaja();
                    }
                    case 3 -> {
                        almacen.nuevoCliente();
                    }
                    case 4 -> {
                        almacen.atenderCliente();
                    }
                    case 5 -> {
                        break;
                    }
                }

            } catch (MiEntradaSalidaException | SupermercadoException e) {
                System.out.println(e.getMessage());
            }
        } while (opcion != 5);
    }
}