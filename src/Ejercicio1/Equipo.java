package Ejercicio1;

import ejemplos.EquipoExeption;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Equipo<T> {
    private String nombre;
    private Set<T> alumnos;

    public Equipo(String nombre) {
        this.nombre = nombre;
        alumnos = new HashSet<>();
    }

    public Equipo(String nombre, Set<T> alumnos) {
        this.nombre = nombre;
        this.alumnos = alumnos;
    }

    public void addAlumno(T alumno) throws EquipoExeption {
        if (!alumnos.add(alumno)) {
            throw new EquipoExeption("No se ha podido añadir al alumno");
        }
    }

    public void removeAlumno(T a) throws EquipoExeption{
        if (!alumnos.remove(a)) {
            throw new EquipoExeption("El alumno no pertenece al equipo");
        }
    }

    public T buscarAlumno(T a) throws EquipoExeption{
        if (!alumnos.contains(a)) {
            return null;
        }
        return a;
    }

    public List<T> devolverListaAlumnos() {
        return new ArrayList<>(alumnos);
    }

    public Equipo<T> unirEquipos(Equipo<T> a) {
        Set<T> union = new HashSet<>(this.alumnos);
        union.addAll(alumnos);
        union.addAll(a.alumnos);

        return new Equipo("Union FC", union);

//        Ejercicio1.Equipo resultante = new Ejercicio1.Equipo("Union FC");
//        resultante.alumnos = union;
//
//        return resultante;
    }

    public Equipo<T> interseccionEquipo(String nombreEquipo, Equipo<T> a) {
        Set<T> interseccion = new HashSet<>(this.alumnos);
        interseccion.retainAll(a.alumnos);

        return new Equipo("Interseccion FC", interseccion);
    }
}
