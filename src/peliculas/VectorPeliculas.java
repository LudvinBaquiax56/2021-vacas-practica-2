package src.peliculas;

import src.tienda.*;
import java.util.*;

public class VectorPeliculas {

	private Pelicula [] peliculas = new Pelicula[0]; 
	private String [] categoriaPelicula;
	private Scanner scanner = new Scanner(System.in);

	public VectorPeliculas(){
		llenarCategorias();
	}
	
	public void agregarPelicula(){
		String nombre = IngresoDatos.getTexto("Ingrese el nombre de la pelicula");
        int id = IngresoDatos.getEntero("Ingrese el id de la pelicula", false);
        int anio = IngresoDatos.getEntero("Ingrese el anio de la pelicula", false);
        String categoria = seleccionarCategoriaPelicula();
        agregarPelicula(new Pelicula(id,nombre,anio,categoria, true));
	}

	public void agregarPelicula (Pelicula pelicula){
        Pelicula aux [] = new Pelicula[peliculas.length + 1];
        for (int i = 0; i < peliculas.length ; i++ ) {
            aux[i] = peliculas[i];
        }
        aux[peliculas.length] = pelicula;
        peliculas = aux;
    }



    /**
     * Ordena las peliculas con el metodo Burbuja
     */
    public void ordenarPeliculas(boolean ascendente){
    	boolean cambio;
        if (peliculas.length == 0 || peliculas.length == 1) {
            System.out.println("No hay suficientes peliculas para ordenar");
        }else {
            System.out.println("Ordenar peliculas");
            System.out.println("......................................");
            for (int i = 1; i < peliculas.length; i++ ) {
                for (int j = 0; j< peliculas.length-i;j++ ) {
                	if (ascendente) {
                		cambio = peliculas[j].getNombre().compareTo(peliculas[j+1].getNombre()) > 0;
                	} else{
                		cambio = peliculas[j].getNombre().compareTo(peliculas[j+1].getNombre()) < 0;
                	}
                    if (cambio) {
                        Pelicula aux = peliculas[j];
                        peliculas[j] = peliculas[j + 1];
                        peliculas[j+1] = aux;
                    }
                }
            }
            System.out.println("Las peliculas han sido ordenadas de manera Ascendente");
        }
        
    }


    /**
     * Muestra todas las peliculas
     */
    public void mostrarPelicula(){
        if (peliculas.length==0) {
            System.out.println("No hay peliculas que mostrar");
        } else {
            System.out.println("-----------------------------------------------");
            System.out.println("Las peliculas de Memorabilia son:");
            System.out.println("ID--Nombre--Anio--Categoria--Disponibilidad");
            System.out.println("-----------------------------------------------");
            System.out.println(" ");
            for (int i = 0;i<peliculas.length ;i++ ) {
                System.out.println( (i+1) + ". " + peliculas[i].mostrarDatos());
            }
        }
    }

	 /**
     * Muestra las categorias de peliculas y retorna la categoria escogida
     */
    public String seleccionarCategoriaPelicula(){
        boolean salir = true;
        int opcion = 0;
        String categoria = "";
        do {
            System.out.println("Seleccione la categoria de la pelicula");
            for (int i = 0; i < categoriaPelicula.length ; i++ ) {
                System.out.println((i+1) + ". " + categoriaPelicula[i]);
            }

            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= categoriaPelicula.length) {
                categoria = categoriaPelicula[opcion-1];
                salir = false;
            } else {
                System.out.println("Opcion incorrecta");
            }
        } while (salir);
        return categoria;
    }

	/**
     * Llena las categorias con las que dispondra el sistema
     */
    public void llenarCategorias(){
        categoriaPelicula = new String[5];
        categoriaPelicula[0] = "Drama";
        categoriaPelicula[1] = "Infantil";
        categoriaPelicula[2] = "Accion";
        categoriaPelicula[3] = "Comedia";
        categoriaPelicula[4] = "Romance";
    }
}