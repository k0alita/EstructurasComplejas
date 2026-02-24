package Ejercicio2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public abstract class Persona {
	
	private static final int EDAD_MINIMA = 12;
	
	// Atributos
	private String dni;
	private String nombre;
	private int edad;
	private ArrayList<Mensaje> mensajes;
	
	// Constructor
	public Persona(String dni,String nombre,int edad) throws IESException {
		this.dni=dni;
		this.nombre = nombre;
		mensajes=new ArrayList<>();
		setEdad(edad);
	}

	// Métodos get y set
	public int getEdad() {
		return edad;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	private void setEdad(int edad) throws IESException {
		if (edad < EDAD_MINIMA)
			throw new IESException("La edad minima es de" + EDAD_MINIMA);
		this.edad = edad;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

    /**
     * Método para enviar un mensaje a otra persona
     * @param msg El texto del mensaje
     * @param personaDestinatario La persona que recibirá el mensaje
     * @throws IESException Si un alumno menor de edad intenta enviar mensaje a otro alumno
     */
	public void enviarCorreo(String msg, Persona personaDestinatario) throws IESException{
		if (this instanceof Alumno && this.getEdad() < 18 && personaDestinatario instanceof Alumno) {
            throw new IESException("No puedes enviar un mensaje a otro alumno siendo menor de edad");
        }
        Mensaje mensaje = new Mensaje(this, msg);
        personaDestinatario.mensajes.add(mensaje);
		
	}

    /**
     * Muestra los mensajes ordenados alfabéticamente por nombre del remitente
     * @return String con los mensajes ordenados
     * @throws IESException Si no hay mensajes
     */
	public String mostrarMensajesOrdenados() throws IESException{
		if (mensajes.isEmpty()) {
            throw new IESException("No hay mensajes");
        }

        // Crear una copia para no modificar el orden original
        ArrayList<Mensaje> mensajesOrdenados = new ArrayList<>(mensajes);

        // Ordenar por nombre del remitente
        Collections.sort(mensajesOrdenados, new Comparator<Mensaje>() {
            @Override
            public int compare(Mensaje m1, Mensaje m2) {
                return m1.getRemitente().getNombre().compareToIgnoreCase(m2.getRemitente().getNombre());
            }
        });


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mensajesOrdenados.size(); i++) {
            sb.append("Mensaje ").append(i + 1).append(": ");
            sb.append(mensajesOrdenados.get(i).toString());
            sb.append("\n");
        }
        return sb.toString();

	}

	/**
	 *
	 * @param numeroMensaje De 1 en adelante
	 * @throws IESException
	 */
	public void borrarMensaje( int numeroMensaje) throws IESException{
        if (numeroMensaje < 1 || numeroMensaje > mensajes.size()) {
            throw new IESException("El numero de mensaje " + numeroMensaje + " no existe");
        }
        mensajes.remove(numeroMensaje - 1);
	}
	
	
	public String mostrarMensajes() throws IESException{
		if (mensajes.isEmpty()) {
            throw new IESException("No hay mensajes");
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mensajes.size(); i++) {
            sb.append("Mensaje ").append(i + 1).append(": ");
            sb.append(mensajes.get(i).toString());
            sb.append("\n");
        }
        return sb.toString();
	}	
	
	
	public String buscarMensajesConTexto( String texto) throws IESException{
		ArrayList<Mensaje> mensajesEncontrados = new ArrayList<>();

        for (Mensaje mensaje : mensajes) {
            if (mensaje.getTexto().toLowerCase().contains(texto.toLowerCase())) {
                mensajesEncontrados.add(mensaje);
            }
        }

        if (mensajesEncontrados.isEmpty()) {
            throw new IESException("No se encontraron mensajes con el texto: " + texto);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mensajesEncontrados.size(); i++) {
            sb.append("Mensaje ").append(i + 1).append(": ");
            sb.append(mensajesEncontrados.get(i).toString());
            sb.append("\n");
        }
        return sb.toString();
	}
}
