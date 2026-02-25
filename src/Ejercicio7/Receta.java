package Ejercicio7;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

public class Receta {
    private String nombre;
    private int tiempoPreparacion;
    HashSet<Ingrediente> ingredientes = new HashSet<>();
    LinkedList<String> pasos = new LinkedList<>();

    public Receta(String nombre, int tiempoPreparacion) {
        this.nombre = nombre;
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getTiempoPreparacion() { return tiempoPreparacion; }
    public void setTiempoPreparacion(int t) { this.tiempoPreparacion = t; }
    public HashSet<Ingrediente> getIngredientes() { return ingredientes; }
    public LinkedList<String> getPasos() { return pasos; }

    public boolean nesecitaIngrediente(String ingredienteNuevo) {
        for (Ingrediente ing : ingredientes) {
            if (ing.getNombre().equalsIgnoreCase(ingredienteNuevo)) {
                return true;
            }
        }
        return false;
    }

    public void añadirIngrediente(Ingrediente ingredienteNuevo) {
        for (Ingrediente ing : ingredientes) {
            if (ing.getNombre().equalsIgnoreCase(ingredienteNuevo.getNombre())) {
                ing.setCantidad(ing.getCantidad() + ingredienteNuevo.getCantidad());
                return;
            }
        }
        ingredientes.add(ingredienteNuevo);
    }

    public void borrarIngrediente(Ingrediente ingredienteABorrar) throws RecetaException {
        String nombre = ingredienteABorrar.getNombre();

        boolean eliminado = ingredientes.removeIf(i -> i.getNombre().equalsIgnoreCase(nombre));
        if (!eliminado) {
            throw new RecetaException("El ingrediente " + nombre + " no existe en la receta");
        }

        pasos.removeIf(p -> p.toLowerCase().contains(nombre.toLowerCase()));
    }

    public void añadirPasoDetrasDe(String pasoNuevo, String pasoExistente) throws RecetaException {
        int indice = pasos.indexOf(pasoExistente);
        if (indice == -1) {
            throw new RecetaException("El paso " + pasoExistente + "");
        }
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Receta receta)) return false;

        return tiempoPreparacion == receta.tiempoPreparacion && Objects.equals(nombre, receta.nombre) && Objects.equals(ingredientes, receta.ingredientes) && Objects.equals(pasos, receta.pasos);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(nombre);
        result = 31 * result + tiempoPreparacion;
        result = 31 * result + Objects.hashCode(ingredientes);
        result = 31 * result + Objects.hashCode(pasos);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Receta{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", tiempoPreparacion=").append(tiempoPreparacion);
        sb.append(", ingredientes=").append(ingredientes);
        sb.append(", pasos=").append(pasos);
        sb.append('}');
        return sb.toString();
    }
}
