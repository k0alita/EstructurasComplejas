package Ejercicio1;

public class Alumno {
    private String nombre;
    private String DNI;

    public Alumno(String DNI, String nombre) {
        this.DNI = DNI;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ejercicio1.Alumno{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", DNI='").append(DNI).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Alumno alumno = (Alumno) o;
        return nombre.equals(alumno.nombre) && DNI.equals(alumno.DNI);
    }

    @Override
    public int hashCode() {
        int result = nombre.hashCode();
        result = 31 * result + DNI.hashCode();
        return result;
    }
}
