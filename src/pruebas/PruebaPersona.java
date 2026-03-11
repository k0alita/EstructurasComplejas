package pruebas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PruebaPersona {
    private List<Persona> personas;

    public PruebaPersona() {
        personas = new ArrayList<>();
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public static void main(String[] args) {
        PruebaPersona p = new PruebaPersona();

        List<Persona> personas = p.getPersonas();

        personas.add(new Persona(35, "Mateo"));
        personas.add(new Persona(29, "Daniela"));
        personas.add(new Persona(34, "Alejandro"));
        personas.add(new Persona(30, "Pepe"));
        personas.add(new Persona(32, "Javier"));
        personas.add(new Persona(38, "Mateo"));
        personas.add(new Persona(22, "Pepillo"));

        System.out.println(personas.stream()
                .max(Comparator.comparingInt(Persona::getEdad)).orElseThrow());


        System.out.println(
                personas.stream()
                        .map(Persona::getNombre)
                        .collect(Collectors.joining(","))
        );


        System.out.println(personas.stream()
                .mapToLong(Persona::getEdad)
                .reduce(1, (edad1, edad2) -> edad1 * edad2 ));
    }
}
