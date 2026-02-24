package Ejercicio6;

import java.util.LinkedList;
import java.util.Queue;

public class Caja {
    private int numero;
    private boolean abierta;
    private Queue<Integer> clientes;

    public Caja(int numero) {
        this.numero = numero;
        this.abierta = false;
        this.clientes = new LinkedList<>();
    }

    public boolean isAbierta() {
        return abierta;
    }

    public void abrir() {
        this.abierta = true;
    }

    public void cerrar() {
        this.abierta = false;
    }

    public int getNumero() {
        return numero;
    }

    public Queue<Integer> getClientes() {
        return clientes;
    }

    public int getNumeroClientes() {
        return clientes.size();
    }

    public void agregarCliente(int numeroCliente) {
        clientes.offer(numeroCliente);
    }

    public Integer atenderCliente() {
        return clientes.poll();
    }

    public boolean tieneClientes() {
        return !clientes.isEmpty();
    }
}
