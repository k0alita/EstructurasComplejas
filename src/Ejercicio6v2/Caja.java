package Ejercicio6v2;

import java.util.ArrayDeque;
import java.util.Queue;

public class Caja implements Comparable<Caja> {
    private final int NUM_CAJA;
    private static int contator = 1;
    private boolean estaAbierta;

    private Queue<Cliente> clientes;

    public Caja(int NUM_CAJA, boolean estaAbierta, Queue<Integer> clientes) {
        this.NUM_CAJA = contator++;
        this.estaAbierta = false;
        this.clientes = new ArrayDeque<>();
    }

    public void añadirCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public int comprobarNumeroClientes() {
       return clientes.size();
    }


    @Override
    public int compareTo(Caja o) {
        if (comprobarNumeroClientes() == o.comprobarNumeroClientes()) {
            return NUM_CAJA - o.NUM_CAJA;
        }
        return comprobarNumeroClientes() - o.comprobarNumeroClientes();
    }
}
