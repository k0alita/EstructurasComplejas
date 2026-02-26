package Ejercicio6v2;

import Ejercicio6v2.Cliente;
import Ejercicio6v2.SupermercadoException;

import java.util.*;

public class Caja implements Comparable<Caja> {

    private final int NUMERO_DE_CAJA;
    private static int contador = 1;
    private boolean estaAbierta;

    Queue<Cliente> clientes;

    public Caja() {
        this.NUMERO_DE_CAJA = contador++;
        this.estaAbierta = false;
        this.clientes = new ArrayDeque<>();
    }

    public void anadirCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public void abrirCaja() throws SupermercadoException {
        if (estaAbierta){
            throw new SupermercadoException("La caja ya esta abierta");
        } else {
            estaAbierta = true;
        }
    }

    public void cerrarCaja() throws SupermercadoException{
        if (!estaAbierta || !clientes.isEmpty()){
            throw new SupermercadoException("No se puede cerrar esta caja");
        } else {
            estaAbierta = false;
        }
    }

    public Cliente atenderCliente() throws SupermercadoException {
        if (!estaAbierta) {
            throw new SupermercadoException("La caja esta cerrada");
        } else if (clientes.isEmpty()) {
            throw new SupermercadoException("No hay clientes en la caja");
        }
        return clientes.poll();
    }

    public int comprobarNumeroClientes(){
        return clientes.size();
    }

    public boolean isEstaAbierta() {
        return estaAbierta;
    }

    public void setEstaAbierta(boolean estaAbierta) {
        this.estaAbierta = estaAbierta;
    }

    public int getNUMERO_DE_CAJA() {
        return NUMERO_DE_CAJA;
    }

    @Override
    public int compareTo(Caja o) {
        if (comprobarNumeroClientes() == o.comprobarNumeroClientes()){
            return NUMERO_DE_CAJA - o.NUMERO_DE_CAJA;
        }
        return comprobarNumeroClientes() - o.comprobarNumeroClientes();
    }
}