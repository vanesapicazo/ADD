package es.ADD.AE04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca","root","");
			
			String titulo, autor, anyo_nac, anyo_pub, editorial, num_pag;
			
			File ficheroCSV = new File("AE04_T1_4_JDBC_Dades.csv");
			FileReader fr = new FileReader(ficheroCSV);
			BufferedReader br = new BufferedReader(fr);
			
			String linea = br.readLine();
			
			while((linea = br.readLine()) != null) {
				String[] elementosLibro = linea.split(";");
				for (int i = 0; i < elementosLibro.length; i++) {
					if (elementosLibro[i].equals("")) {
						elementosLibro[i] = "N.C.";
					}
				}
				titulo = elementosLibro[0];
				autor = elementosLibro[1];
				anyo_nac = elementosLibro[2];
				anyo_pub = elementosLibro[3];
				editorial = elementosLibro[4];
				num_pag = elementosLibro[5];
				PreparedStatement ps = con.prepareStatement("INSERT INTO libros (titulo,autor,anyo_nac,anyo_pub,editorial,num_pag) "
						+ "VALUES (?,?,?,?,?,?)");
				ps.setString(1, titulo);
				ps.setString(2, autor);
				ps.setString(3, anyo_nac);
				ps.setString(4, anyo_pub);
				ps.setString(5, editorial);
				ps.setString(6, num_pag);
				int resultadoInsertar =ps.executeUpdate();
				if (resultadoInsertar == 1) {
					System.out.println("Fila insertada correctamente");
					System.out.println(ps.toString());
				}
				ps.close();
			}
			br.close();
			fr.close();
			
			String consulta1 = "SELECT titulo,autor,anyo_pub FROM libros WHERE anyo_nac < 1950";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(consulta1);
			System.out.println("\nCONSULTA 1: " + consulta1);
			while(rs.next()) {
				System.out.println(rs.getString(1) + "  " + rs.getString(2) + " " + rs.getString(3));
			}
			rs.close();
			stmt.close();
			
			String consulta2 = "SELECT editorial FROM libros WHERE anyo_pub > 2000";
			stmt = con.createStatement();
			rs = stmt.executeQuery(consulta2);
			System.out.println("\nCONSULTA 2: " + consulta2);
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
			rs.close();
			stmt.close();
			
			Scanner teclado = new Scanner(System.in);
			System.out.print("\n¿Introducir sentencia SQL manualmente (s/n)? ");
			String introducirSentencia = teclado.nextLine();
			while (introducirSentencia.equals("s")) {
				System.out.print("\nIntroducir sentencia SQL: ");
				String sentencia = teclado.nextLine();
				if (sentencia.contains("SELECT")) {
					stmt = con.createStatement();
					rs = stmt.executeQuery(sentencia);
					ResultSetMetaData rsmd = rs.getMetaData();
					int numCampos = rsmd.getColumnCount();
					while(rs.next()) {
						for (int i = 1; i <= numCampos; i++) {
							System.out.print(rs.getString(i) + " - ");
						}
						System.out.println("");
					}
					rs.close();
					stmt.close();
				} else {
					PreparedStatement ps = con.prepareStatement(sentencia);
					int resultado = ps.executeUpdate();
					if (resultado == 1) {
						System.out.println("Sentencia ejecutada correctamente.");
						System.out.println(ps.toString());
					} else {
						System.err.println("Error en la ejecucion de la sentencia.");
					}
				}
				System.out.print("\n¿Introducir sentencia SQL manualmente (s/n)? ");
				introducirSentencia = teclado.nextLine();
			}
			
			con.close();
			teclado.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}  
		 

	}

}
