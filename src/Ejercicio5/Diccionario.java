package Ejercicio5;

import java.util.*;

public class Diccionario {
    // Creacion del diccionario con la key de la propia palabra y un ArrayList para el significado
    private Map<String, List<String>> diccionario;

    public Diccionario() {
        diccionario = new HashMap<>();
    }

    public void addPalabra(String palabra, String significado) {
        palabra = palabra.trim().toLowerCase();

        if (diccionario.containsKey(palabra)) {
            diccionario.get(palabra).add(significado);
        } else {
            List<String> nuevaLista = new ArrayList<>();
            nuevaLista.add(significado);
            diccionario.put(palabra, nuevaLista);
        }
// Otras formas de harclo
//        diccionario.computeIfAbsent(palabra, k -> new ArrayList<>()).add(significado);
//        diccionario.putIfAbsent(palabra, new ArrayList<>());
//        diccionario.get(palabra).add(significado);
//        System.out.println("Sginificado añadido correctamente");
    }

    public void borrarPalabra(String palabra) {
        palabra = palabra.trim().toLowerCase();
        diccionario.remove(palabra);
//        if (diccionario.remove(palabra) != null) {
//            System.out.println("Palabra: " + palabra + " eliminada correctamente del diccionario");
//        }
    }

    public List<String> buscarPalabra(String palabra) {
        return diccionario.get(palabra);
//        palabra = palabra.trim().toLowerCase();
//
//        if (diccionario.containsKey(palabra)) {
//            List<String> significados = diccionario.get(palabra);
//            System.out.println("Significados de " + palabra + " :");
//            for (int i = 0; i < significados.size(); i++) {
//                System.out.println(" " + (i + 1) + "." + significados.get(i));
//            }
//
//        } else {
//            throw new DicionarioException("La palabra: " + palabra + " no esta en el diccionario ");
//        }

    }

    public List<String> listadoPalabras(String prefijo) {
        prefijo = prefijo.trim().toLowerCase();
        List<String> palabrasQueEmpiezanPor = new LinkedList<>();

        for (String k : diccionario.keySet()) {
            if (k.startsWith(prefijo)) {
                palabrasQueEmpiezanPor.add(k);
            }
        }
        palabrasQueEmpiezanPor.sort(null);
        return palabrasQueEmpiezanPor;

//        if (resultado.isEmpty()) {
//            throw new DicionarioException("No hay palabra que empiezen por: " + prefijo);
//        } else {
//            Collections.sort(resultado);
//            System.out.println("Palabras que comienzan por: " + prefijo);
//            for (String p : resultado) {
//                System.out.println("  - " + p);
//            }
//
//        }
    }
}
