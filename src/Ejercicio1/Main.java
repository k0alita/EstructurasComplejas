package Ejercicio1;

import ejemplos.EquipoExeption;

public class Main {
    public static void main(String[] args) {
        try {
            // Crear alumnos
            Alumno alumno1 = new Alumno("12345678A", "Juan Pérez");
            Alumno alumno2 = new Alumno("87654321B", "María García");
            Alumno alumno3 = new Alumno("11223344C", "Pedro López");
            Alumno alumno4 = new Alumno("44332211D", "Ana Martínez");
            Alumno alumno5 = new Alumno("55667788E", "Carlos Ruiz");

            System.out.println("=== CREACIÓN DE EQUIPOS ===");

            // Crear equipos
            Equipo equipo1 = new Equipo("Ejercicio1.Equipo A");
            Equipo equipo2 = new Equipo("Ejercicio1.Equipo B");

            // Añadir alumnos al equipo 1
            System.out.println("\n--- Añadiendo alumnos al Ejercicio1.Equipo A ---");
            equipo1.addAlumno(alumno1);
            equipo1.addAlumno(alumno2);
            equipo1.addAlumno(alumno3);
            System.out.println("Alumnos añadidos correctamente al Ejercicio1.Equipo A");

            // Añadir alumnos al equipo 2
            System.out.println("\n--- Añadiendo alumnos al Ejercicio1.Equipo B ---");
            equipo2.addAlumno(alumno3); // alumno3 está en ambos equipos
            equipo2.addAlumno(alumno4);
            equipo2.addAlumno(alumno5);
            System.out.println("Alumnos añadidos correctamente al Ejercicio1.Equipo B");

            // Mostrar listas de alumnos
            System.out.println("\n=== LISTADO DE ALUMNOS ===");
            System.out.println("Ejercicio1.Equipo A:");
            equipo1.devolverListaAlumnos().forEach(System.out::println);

            System.out.println("\nEjercicio1.Equipo B:");
            equipo2.devolverListaAlumnos().forEach(System.out::println);

            // Probar añadir alumno duplicado
            System.out.println("\n=== PRUEBA DE ALUMNO DUPLICADO ===");
            try {
                equipo1.addAlumno(alumno1);
            } catch (EquipoExeption e) {
                System.out.println("Excepción capturada: " + e.getMessage());
            }

            // Buscar alumno
            System.out.println("\n=== BUSCAR ALUMNO ===");
            Alumno encontrado = (Alumno) equipo1.buscarAlumno(alumno2);
            if (encontrado != null) {
                System.out.println("Ejercicio1.Alumno encontrado: " + encontrado);
            }

            Alumno noEncontrado = (Alumno) equipo1.buscarAlumno(alumno4);
            if (noEncontrado == null) {
                System.out.println("El alumno " + alumno4.getNombre() + " no está en el Ejercicio1.Equipo A");
            }

            // Eliminar alumno
            System.out.println("\n=== ELIMINAR ALUMNO ===");
            equipo1.removeAlumno(alumno2);
            System.out.println("Ejercicio1.Alumno eliminado correctamente del Ejercicio1.Equipo A");
            System.out.println("Nueva lista del Ejercicio1.Equipo A:");
            equipo1.devolverListaAlumnos().forEach(System.out::println);

            // Probar eliminar alumno que no existe
            System.out.println("\n=== PRUEBA DE ELIMINAR ALUMNO NO EXISTENTE ===");
            try {
                equipo1.removeAlumno(alumno2);
            } catch (EquipoExeption e) {
                System.out.println("Excepción capturada: " + e.getMessage());
            }

            // Unión de equipos
            System.out.println("\n=== UNIÓN DE EQUIPOS ===");
            Equipo union = equipo1.unirEquipos(equipo2);
            System.out.println("Alumnos en la unión:");
            union.devolverListaAlumnos().forEach(System.out::println);

            // Intersección de equipos
            System.out.println("\n=== INTERSECCIÓN DE EQUIPOS ===");
            Equipo interseccion = equipo1.interseccionEquipo("Nuevo", equipo2);
            System.out.println("Alumnos en la intersección:");
            if (interseccion.devolverListaAlumnos().isEmpty()) {
                System.out.println("No hay alumnos comunes");
            } else {
                interseccion.devolverListaAlumnos().forEach(System.out::println);
            }

        } catch (EquipoExeption e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}