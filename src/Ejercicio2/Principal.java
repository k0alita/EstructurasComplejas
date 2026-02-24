package Ejercicio2;

public class Principal {

    public static void main(String[] args) {
        try {
            // Crear profesores y alumnos
            Profesor profesor1 = new Profesor("11", "Pepe", 30);
            Profesor profesor2 = new Profesor("12", "Pepa", 32);
            Profesor profesor3 = new Profesor("13", "Ana", 28);

            Alumno alumno1 = new Alumno("20", "Carlos", 17, TipoEnsennanza.ESO, 4);
            Alumno alumno2 = new Alumno("21", "María", 15, TipoEnsennanza.ESO, 3);
            Alumno alumno3 = new Alumno("22", "Juan", 19, TipoEnsennanza.BACHILLERATO, 2);

            System.out.println("=== PRUEBA 1: Envío de mensajes válidos ===");
            profesor1.enviarCorreo("Hola Pepa, ¿cómo estás?", profesor2);
            profesor3.enviarCorreo("Buenos días Pepa", profesor2);
            profesor1.enviarCorreo("Adiós Pepa", profesor2);
            alumno3.enviarCorreo("Profesor, tengo una duda", profesor1);
            System.out.println("Mensajes enviados correctamente\n");

            System.out.println("=== PRUEBA 2: Mostrar mensajes de profesor2 ===");
            System.out.println(profesor2.mostrarMensajes());

            System.out.println("=== PRUEBA 3: Mostrar mensajes ordenados alfabéticamente ===");
            System.out.println(profesor2.mostrarMensajesOrdenados());

            System.out.println("=== PRUEBA 4: Buscar mensajes con texto 'Hola' ===");
            System.out.println(profesor2.buscarMensajesConTexto("Hola"));

            System.out.println("=== PRUEBA 5: Borrar mensaje número 2 ===");
            profesor2.borrarMensaje(2);
            System.out.println("Mensaje borrado. Mensajes restantes:");
            System.out.println(profesor2.mostrarMensajes());

            System.out.println("=== PRUEBA 6: Alumno menor de edad enviando a profesor ===");
            alumno1.enviarCorreo("Tengo una pregunta", profesor1);
            System.out.println("Mensaje enviado correctamente (permitido)\n");

            System.out.println("=== PRUEBA 7: Alumno menor de edad enviando a otro alumno (ERROR) ===");
            try {
                alumno1.enviarCorreo("Hola María", alumno2);
            } catch (IESException e) {
                System.out.println("Excepción capturada: " + e.getMessage() + "\n");
            }

            System.out.println("=== PRUEBA 8: Buscar texto que no existe (ERROR) ===");
            try {
                profesor2.buscarMensajesConTexto("examen");
            } catch (IESException e) {
                System.out.println("Excepción capturada: " + e.getMessage() + "\n");
            }

            System.out.println("=== PRUEBA 9: Borrar mensaje inexistente (ERROR) ===");
            try {
                profesor2.borrarMensaje(10);
            } catch (IESException e) {
                System.out.println("Excepción capturada: " + e.getMessage() + "\n");
            }

            System.out.println("=== PRUEBA 10: Mostrar mensajes de buzón vacío (ERROR) ===");
            try {
                System.out.println(profesor3.mostrarMensajes());
            } catch (IESException e) {
                System.out.println("Excepción capturada: " + e.getMessage());
            }

        } catch (IESException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
