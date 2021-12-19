package es.ADD.ae05;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

public class App {
	
	static Scanner teclado;
	static Session sesion;
	static List bookList;
	static int id;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		teclado = new Scanner(System.in);
		int seleccion = 0;
		
		
		

	}
	
	
	public static void mostrarTitulos() {
		System.out.println("BIBLIOTECA DE TÍTULOS");
		
		for(Object obj:bookList) {
			Libro libro = (Libro)obj;
			System.out.println(libro.getTitulo());
		}
	}
	
	
	public static void infoLibro() {
		try {
			teclado = new Scanner(System.in);
			
			System.out.println("ID del libro: ");
			id = teclado.nextInt();
			
			Libro libro = (Libro) sesion.get(Libro.class, id);
			
			System.out.println(libro.toString());
			
		}catch(Exception e) {
			System.out.println("Ese libro no está registrado en nuestra base de datos");
		}
	}
	
	
	public static void addLibro() {
		teclado = new Scanner(System.in);
		
		System.out.println("Título: ");
		String titulo = teclado.next();
		
		System.out.println("Autor: ");
		String autor = teclado.next();
		
		System.out.println("Año de nacimiento: ");
		int año_nacimiento = teclado.nextInt();
		
		System.out.println("Año de publicación: ");
		int año_publicacion = teclado.nextInt();
		
		System.out.println("Editorial: ");
		String editorial = teclado.next();
		
		System.out.println("Número de páginas: ");
		int num_paginas = teclado.nextInt();
		
		Libro libro = new Libro(titulo, autor, año_nacimiento, año_publicacion, editorial, num_paginas);
		
		sesion.persist(libro);
	}
	
	public static void modificarLibro() {
		try {
			teclado=new Scanner(System.in);

			System.out.print("Id del libro: ");
			
			id = teclado.nextInt();
					
			Libro libro = (Libro) sesion.load(Libro.class, id);
			
			System.out.print("Título nuevo: ");		
			libro.setTitulo(teclado.next());			
			
			System.out.print("Autor nuevo: ");
			libro.setAutor(teclado.next());	
			
			System.out.print("Año de nacimiento del autor nuevo: ");
			libro.setAñoNacimiento(teclado.nextInt());	

			System.out.print("Año de publicación del libro nuevo: ");
			libro.setAñoPublicacion(teclado.nextInt());
			
			System.out.print("Editorial nueva: ");
			libro.setEditorial(teclado.next());
			
			System.out.print("Número de páginas del libro nuevo: ");
			libro.setNumPaginas(teclado.nextInt());

			System.out.print("Datos del libro modificados con éxito.");
			
		}catch(Exception e) {
			System.out.println("Ese libro no está registrado en nuestra base de datos");
		}
	}
	
	public static void borrarLibro() {
		try {
			teclado = new Scanner(System.in);
			
			System.out.println("Id del libro que se desea eliminar: ");
			id = teclado.nextInt();
			
			Libro libro = (Libro) sesion.load(Libro.class, id);
			sesion.delete(libro);
			
			System.out.println("Libro eliminado con éxito.");
		}catch(Exception e) {
			System.out.println("Ese libro no está registrado en nuestra base de datos");
		}
	}

}
