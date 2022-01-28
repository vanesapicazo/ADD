package es.ADD.ae06;

import java.util.Scanner;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;

public class App {
	
	static MongoCollection<Document> coleccion;
	
	public static void mostrarTitulos() {
		
		MongoCursor<Document> cursor = coleccion.find().iterator();
		
		while(cursor.hasNext()) {
			JSONObject obj = new JSONObject(cursor.next().toJson());
			System.out.println("ID: " + obj.getString("Id") + " - TITULO: " + obj.getString("Titol"));
		}
	}
	
	
	public static void infoLibro(String id) {
		Bson query= eq("Id", id);
		MongoCursor<Document> cursor = coleccion.find(query).iterator();
		while(cursor.hasNext()) {
			JSONObject obj = new JSONObject(cursor.next().toJson());
			System.out.println("Id: " + obj.getString("Id")); 
			System.out.println("Título: " + obj.getString("Titol"));
			System.out.println("Autor: " + obj.getString("Autor"));
			System.out.println("Año nacimiento: " + obj.getString("Any_naixement"));
			System.out.println("Año publicación: " + obj.getString("Any_publicacio"));
			System.out.println("Editorial: " + obj.getString("Editorial"));
			System.out.println("Nº páginas: " + obj.getString("Nombre_pagines"));
		}
	}
	
	public static void addLibro() {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Id: "); String id = teclado.nextLine(); 
		System.out.print("Título: "); String titulo = teclado.nextLine(); 
		System.out.print("Autor: "); String autor = teclado.nextLine(); 
		System.out.print("Año nacimiento: "); String any_nac = teclado.nextLine(); 
		System.out.print("Año publicación: "); String any_pub = teclado.nextLine(); 
		System.out.print("Editorial: "); String editorial = teclado.nextLine(); 
		System.out.print("Nº páginas: "); String n_pag = teclado.nextLine(); 
		Document doc= new Document();
		doc.append("Id", id);
		doc.append("Titol", titulo);
		doc.append("Autor", autor);
		doc.append("Any_naixement", any_nac);
		doc.append("Any_publicacio", any_pub);
		doc.append("Editorial", editorial);
		doc.append("Nombre_pagines", n_pag);
		coleccion.insertOne(doc);
	}
	
	public static void modificarLibro(String id) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce datos nuevos (introduce '.' para no realizar ninguna modificación)");
		Bson query= eq("Id", id);
		System.out.print("Título: ");
		String nuevoCampo = teclado.nextLine();
		if (!nuevoCampo.equals("."))
			coleccion.updateOne(query, new Document("$set", new Document("Titol", nuevoCampo)));
		System.out.print("Autor: ");
		nuevoCampo = teclado.nextLine();
		if (!nuevoCampo.equals("."))
			coleccion.updateOne(query, new Document("$set", new Document("Autor", nuevoCampo)));
		System.out.print("Año nacimiento: ");
		nuevoCampo = teclado.nextLine();
		if (!nuevoCampo.equals("."))
			coleccion.updateOne(query, new Document("$set", new Document("Any_naixement", nuevoCampo)));
		System.out.print("Año publicación: ");
		nuevoCampo = teclado.nextLine();
		if (!nuevoCampo.equals("."))
			coleccion.updateOne(query, new Document("$set", new Document("Any_publicacio", nuevoCampo)));
		System.out.print("Editorial: ");
		nuevoCampo = teclado.nextLine();
		if (!nuevoCampo.equals("."))
			coleccion.updateOne(query, new Document("$set", new Document("Editorial", nuevoCampo)));
		System.out.print("Nº páginas: ");
		nuevoCampo = teclado.nextLine();
		if (!nuevoCampo.equals("."))
			coleccion.updateOne(query, new Document("$set", new Document("Nombre_pagines", nuevoCampo)));
	}
	
	public static void borrarLibro(String id) {
		coleccion.deleteOne(eq("Id", id));
	}
	

	public static void main(String[] args) {
		
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("BIBLIOTECA");
		coleccion = database.getCollection("Libros");
		
		Scanner teclado = new Scanner(System.in);
		int seleccion;
		String id;
		
		Thread.sleep(100);
		
		while (seleccion != 6) {
			System.out.println("Introduce el número de la operación que desees realizar: ");
            System.out.println("1. Mostrar todos los titulos de la biblioteca.");
            System.out.println("2. Mostrar la información detallada de un libro a partir de su id.");
            System.out.println("3. Añadir un nuevo libro a la biblioteca.");
            System.out.println("4. Modificar atributos de un libro a partir de su id.");
            System.out.println("5. Borrar un libro a partir de su id.");
            System.out.println();
            System.out.println("0. Salir.");
            
			seleccion = Integer.parseInt(teclado.next());
			
			switch(seleccion) {
			case 1:
				mostrarTitulos();
				break;
				
			case 2:
				System.out.print("Id del libro: ");
				id = teclado.next();
				infoLibro(id);
				break;
				
			case 3:
				addLibro();
				break;
				
			case 4:
				System.out.print("Id del libro: ");
				id = teclado.next();
				modificarLibro(id);
				break;
				
			case 5:
				System.out.print("Id del libro: ");
				id = teclado.next();
				borrarLibro(id);
				break;
				
			case 6:
				System.out.println("Las operaciones han sido realizadas con éxito");
				teclado.close();
				mongoClient.close();
				break;
				
			default:
				break;
				
			}
		}

	}

}
