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
		System.out.println("BIBLIOTECA DE T�TULOS");
		
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
			System.out.println("Ese libro no est� registrado en nuestra base de datos");
		}
	}
	
	
	public static void addLibro() {
		teclado = new Scanner(System.in);
		
		System.out.println("T�tulo: ");
		String titulo = teclado.next();
		
		System.out.println("Autor: ");
		String autor = teclado.next();
		
		System.out.println("A�o de nacimiento: ");
		int a�o_nacimiento = teclado.nextInt();
		
		System.out.println("A�o de publicaci�n: ");
		int a�o_publicacion = teclado.nextInt();
		
		System.out.println("Editorial: ");
		String editorial = teclado.next();
		
		System.out.println("N�mero de p�ginas: ");
		int num_paginas = teclado.nextInt();
		
		Libro libro = new Libro(titulo, autor, a�o_nacimiento, a�o_publicacion, editorial, num_paginas);
		
		sesion.persist(libro);
	}
	
	public static void modificarLibro() {
		try {
			teclado=new Scanner(System.in);

			System.out.print("Id del libro: ");
			
			id = teclado.nextInt();
					
			Libro libro = (Libro) sesion.load(Libro.class, id);
			
			System.out.print("T�tulo nuevo: ");		
			libro.setTitulo(teclado.next());			
			
			System.out.print("Autor nuevo: ");
			libro.setAutor(teclado.next());	
			
			System.out.print("A�o de nacimiento del autor nuevo: ");
			libro.setA�oNacimiento(teclado.nextInt());	

			System.out.print("A�o de publicaci�n del libro nuevo: ");
			libro.setA�oPublicacion(teclado.nextInt());
			
			System.out.print("Editorial nueva: ");
			libro.setEditorial(teclado.next());
			
			System.out.print("N�mero de p�ginas del libro nuevo: ");
			libro.setNumPaginas(teclado.nextInt());

			System.out.print("Datos del libro modificados con �xito.");
			
		}catch(Exception e) {
			System.out.println("Ese libro no est� registrado en nuestra base de datos");
		}
	}
	
	public static void borrarLibro() {
		try {
			teclado = new Scanner(System.in);
			
			System.out.println("Id del libro que se desea eliminar: ");
			id = teclado.nextInt();
			
			Libro libro = (Libro) sesion.load(Libro.class, id);
			sesion.delete(libro);
			
			System.out.println("Libro eliminado con �xito.");
		}catch(Exception e) {
			System.out.println("Ese libro no est� registrado en nuestra base de datos");
		}
	}

}
