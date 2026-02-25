package Ejercicio7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Recetario {
    HashMap<String, Receta> recetas = new HashMap<>();

    public void añadirReceta(Receta nuevaReceta) throws RecetaException {
        if (recetas.containsKey(nuevaReceta.getNombre())) {
            throw new RecetaException("Ya existe una receta con el nombre " + nuevaReceta.getNombre() + ".");
        }
        recetas.put(nuevaReceta.getNombre(), nuevaReceta);
    }

    public String listadoRecetasOrdenadasAlfabeticamente() throws RecetaException {
        if (recetas.isEmpty()) {
            throw new RecetaException("No hay recetas en el recetario");
        }
        List<Receta> lista = new ArrayList<>(recetas.values());
        lista.sort(Comparator.comparing(Receta::getNombre));

        StringBuilder sb = new StringBuilder("Recetas ordenadas alfabéticamente:\n");
        for (Receta r : lista) {
            sb.append("  - ").append(r.getNombre())
                    .append(" (").append(r.getTiempoPreparacion()).append(" min)\n");
        }
        return sb.toString();
     }

    public String listadoConIngredienteOrdenadasPorTiempoPreparacion(String ingrediente) throws RecetaException {
        List<Receta> filtradas = new ArrayList<>();
        for (Receta r : recetas.values()) {
            if (r.nesecitaIngrediente(ingrediente)) {
                filtradas.add(r);
            }
        }
        if (filtradas.isEmpty()) {
            throw new RecetaException("No hay recetas que contengan el ingrediente " + ingrediente);
        }

        filtradas.sort(Comparator.comparingInt(Receta::getTiempoPreparacion));
        StringBuilder sb = new StringBuilder("Recetas con ingredientes ordenadas por tiempo de preparacion:\n");
        for (Receta r : filtradas) {
            sb.append("  - ").append(r.getNombre())
                    .append(" (").append(r.getTiempoPreparacion()).append(" min)\n");
        }
        return  sb.toString();
    }
}
