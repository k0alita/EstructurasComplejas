package Ejercicio6v2;

public class Cliente {
    private final int NUM_CLIENTE;
    private static int contador = 1;

    public Cliente() {
        this.NUM_CLIENTE = contador++;
    }

    public int getNUM_CLIENTE() {
        return NUM_CLIENTE;
    }
}
