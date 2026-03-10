package Ejercicio7Mio;

import java.beans.Introspector;
import java.util.*;

public class Receta {
    private String nombre;
    private int duracion;
    private Set<Ingrediente> ingredientes;
    private List<String> pasos;

    public Receta(String nombre, int duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
        ingredientes = new HashSet<>();
        pasos = new LinkedList<>();
    }

    public void anadirPaso(String paso) {
        pasos.add(paso);
    }

    public void anadirPasosDetrasDe(String pasoNuevo, String pasoExistente) throws RecetaException{
        int posicion = pasos.indexOf(pasoExistente);
        if (posicion != -1) {
            pasos.set(posicion + 1, pasoNuevo);
        } else {
            throw new RecetaException("No existe el paso especificado");
        }
    }

    public Set<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Set<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void anadirIngrediente(Ingrediente ingrediente) {
        if (!ingredientes.add(ingrediente)) {
            for (Ingrediente i : ingredientes) {
                if (i.equals(ingrediente)) {
                    i.setCantidad(i.getCantidad() + ingrediente.getCantidad());
                }
            }
        }
    }

    public void borrarIngrediente(Ingrediente ingrediente) throws RecetaException {
        if (ingredientes.remove(ingrediente)){
            Iterator<String> it = pasos.iterator();
            while (it.hasNext()) {
                String paso = it.next();
                if (paso.contains(ingrediente.getNombre())) {
                    it.remove();
                }
            }
        } else {
            throw new RecetaException("El ingrediente " + ingrediente.getNombre() + " no existe en la receta");
        }
    }

}
