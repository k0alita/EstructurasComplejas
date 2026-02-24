package Ejercicio1;

import ejemplos.EquipoExeption;

public class PruebaIntegrer {
    static void main(String[] args) {
        Equipo<Integer> numEquipo = new Equipo<>("Delanterios");

        try {
            numEquipo.addAlumno(10);
            numEquipo.addAlumno(20);
            numEquipo.addAlumno(10);
        } catch (EquipoExeption e) {
            System.out.println(e.getMessage());
        }
    }
}
