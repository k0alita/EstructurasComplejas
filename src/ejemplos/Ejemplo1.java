package ejemplos;

import java.util.ArrayList;
import java.util.Collection;

public class Ejemplo1 {
    public static void main(String[] args) {
        Collection<String> nombres = new ArrayList<>();

        nombres.add("ale");
        nombres.add("pepe");
        nombres.add("juan");

        System.out.println(nombres);

        for (String nombre : nombres) {
            System.out.println(nombre);
        }
        if (nombres.contains("ale")) {
            System.out.println("==== Si, pero lo borro ====");
            if (nombres.remove("ale")) {
                System.out.println("Se ha eliminado correctamente");
            }
            nombres.remove("ale");

        } else {
            System.out.println("==== No lo contiene ====");
        }
        for (String nombre : nombres) {
            System.out.println(nombre);
        }
        System.out.println(nombres);
    }


}
