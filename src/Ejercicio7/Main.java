package Ejercicio7;

public class Main {
    public static void main(String[] args) {
        try {
            // --- Crear recetas ---
            Receta tortilla = new Receta("Tortilla", 20);
            tortilla.añadirIngrediente(new Ingrediente("Huevo", 3));
            tortilla.añadirIngrediente(new Ingrediente("Patata", 2));
            tortilla.añadirIngrediente(new Ingrediente("Sal", 5));
            tortilla.añadirIngrediente(new Ingrediente("Huevo", 2)); // Suma cantidad → Huevo: 5
            tortilla.pasos.add("Pelar y cortar las patatas");
            tortilla.pasos.add("Batir los huevos con sal");
            tortilla.pasos.add("Mezclar patatas y huevo");

            Receta gazpacho = new Receta("Gazpacho", 10);
            gazpacho.añadirIngrediente(new Ingrediente("Tomate", 4));
            gazpacho.añadirIngrediente(new Ingrediente("Pepino", 1));
            gazpacho.añadirIngrediente(new Ingrediente("Sal", 3));

            Receta paella = new Receta("Paella", 60);
            paella.añadirIngrediente(new Ingrediente("Arroz", 300));
            paella.añadirIngrediente(new Ingrediente("Sal", 10));

            // --- Recetario ---
            Recetario recetario = new Recetario();
            recetario.añadirReceta(tortilla);
            recetario.añadirReceta(gazpacho);
            recetario.añadirReceta(paella);

            // Excepción al añadir duplicada
            try {
                recetario.añadirReceta(new Receta("Tortilla", 15));
            } catch (RecetaException e) {
                System.out.println(e.getMessage());
            }

            // Listado alfabético
            System.out.println(recetario.listadoRecetasOrdenadasAlfabeticamente());

            // Listado por ingrediente y tiempo
            System.out.println(
                    recetario.listadoConIngredienteOrdenadasPorTiempoPreparacion("Sal")
            );

            // Añadir paso detrás de otro
            tortilla.añadirPasoDetrasDe("Freír las patatas en aceite", "Pelar y cortar las patatas");
            System.out.println(tortilla);

            // Borrar ingrediente y sus pasos asociados
            tortilla.borrarIngrediente(new Ingrediente("Huevo", 0));
            System.out.println("Tras borrar Huevo:\n" + tortilla);

        } catch (RecetaException e) {
            System.out.println("EXCEPCIÓN: " + e.getMessage());
        }
    }
}
