package Ejercicio6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class GestorCaja{
    private Caja[] cajas;
    private int contadorClientes;

    public GestorCaja() {
        cajas = new Caja[21]; // Índices 1-20
        for (int i = 1; i <= 20; i++) {
            cajas[i] = new Caja(i);
        }
        contadorClientes = 0;
    }

    public void abrirCaja(int numeroCaja) throws CajaException{
        if (numeroCaja < 1 || numeroCaja > 20) {
            throw new CajaException("Error: Numero de caja invalido (1-20)");
        }

        Caja caja = cajas[numeroCaja];

        if (caja.isAbierta()) {
            throw new CajaException("Error: La caja " + numeroCaja + " ya esta ABIERTA");
        } else {
            caja.abrir();
        }
    }

    public void cerrarCaja(int numeroCaja) throws CajaException {
        if (numeroCaja < 1 || numeroCaja > 20) {
            throw new CajaException("Error: Numero de caja invalido (1-20)");
        }

        Caja caja = cajas[numeroCaja];

        if (!caja.isAbierta()) {
            throw new CajaException("Error: La caja " + numeroCaja + " ya esta CERRADA");
        } else if (caja.tieneClientes()) {
            throw new CajaException("Error: La caja " + numeroCaja + " tiene clientes");
        } else {
            caja.cerrar();
        }
    }

    public void nuevoCliente() throws CajaException{
        Caja cajaSeleccionada = IntStream.rangeClosed(1,20)
                .mapToObj(i -> cajas[i])
                .filter(Caja::isAbierta)
                .min(Comparator.comparingInt(Caja::getNumeroClientes)
                        .thenComparingInt(Caja::getNumero))
                .orElseThrow(() -> new CajaException("Error: No hay cajas disponibles"));

        if (cajaSeleccionada == null) {
            throw new CajaException("Error: No hay cajas disponibles");
        }
        contadorClientes++;
        int numeroCliente = contadorClientes;

        cajaSeleccionada.agregarCliente(numeroCliente);

        System.out.println("Es usted el cliente numero " + numeroCliente + " y tiene que ir a la caja " + cajaSeleccionada.getNumero());

    }

    public void atenderCliente(int numeroCaja) throws CajaException {
        if (numeroCaja < 1 || numeroCaja > 20) {
            throw new CajaException("Error: Numero de caja invalido (1-20)");
        }

        Caja caja = cajas[numeroCaja];

        if (!caja.isAbierta()) {
            throw new CajaException("Error: La caja " + numeroCaja + " esta cerrada");
        } else if (!caja.tieneClientes()) {
            throw new CajaException("Error: No hay clientes en la caja " + numeroCaja);
        } else {
            int clienteAtendido = caja.atenderCliente();
            System.out.println("Se ha atendido al cliente numero " + clienteAtendido);
        }
    }

    public void mostrarEstadoCajas() {
        System.out.println("\n--- Estado de Cajas ---");
        for (int i = 1; i <= 20; i++) {
            Caja caja = cajas[i];
            String estado = caja.isAbierta() ? "ABIERTA" : "CERRADA";
            int numClientes = caja.getNumeroClientes();
            System.out.println("Caja " + i + ": " + estado + " - Clientes esperando: " + numClientes);
        }
        System.out.println("------------------------\n");
    }
}
