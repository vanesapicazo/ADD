package es.ADD.ae05;

public class Libro {
	
	private int identificador;
	private String título;
	private String autor;
	private int año_nacimiento;
	private int año_publicacion;
	private String editorial;
	private int num_páginas;
	
	
	public Libro() {
		this.identificador = 0;
		this.título = "";
		this.autor = "";
		this.año_nacimiento = 0;
		this.año_publicacion = 0;
		this.editorial = "";
		this.num_páginas = 0;
	}
	
	
	public Libro(String título, String autor, int año_nacimiento, int año_publicacion, String editorial, int num_páginas){
        this.identificador = 0;
        this.título = título;
        this.autor = autor;
        this.año_nacimiento = año_nacimiento;
        this.año_publicacion = año_publicacion;
        this.editorial = editorial;
        this.num_páginas = num_páginas;
    }
	
	
	//GETTERS Y SETTERS
	
	public int getId() {
		return this.identificador;
	}
	public void setId(int identificador) {
		this.identificador = identificador;
	}
	
	
	public String getTitulo() {
		return this.título;
	}
	public void setTitulo(String título) {
		this.título = título;
	}
	
	
	public String getAutor() {
		return this.autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	
	public int getAñoNacimiento() {
		return this.año_nacimiento;
	}
	public void setAñoNacimiento(int año_nacimiento) {
		this.año_nacimiento = año_nacimiento;
	}
	
	
	public int getAñoPublicacion() {
		return this.año_publicacion;
	}
	public void setAñoPublicacion(int año_publicacion) {
		this.año_publicacion = año_publicacion;
	}
	
	
	public String getEditorial() {
		return this.editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	
	public int getNumPaginas() {
		return this.num_páginas;
	}
	public void setNumPaginas(int num_páginas) {
		this.num_páginas = num_páginas;
	}
	
	
	
	public String toString() {
		return "Id: " + this.identificador +
				"\nTítulo: " + this.título + 
				"\nAutor: " + this.autor + 
				"\nAño de nacimiento: " + this.año_nacimiento +
				"\nAño publicación: " + this.año_publicacion +
				"\nEditorial: " + this.editorial + 
				"\nNúmero de páginas: " + this.num_páginas;
	}

}
