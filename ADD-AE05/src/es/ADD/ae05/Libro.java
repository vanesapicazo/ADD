package es.ADD.ae05;

public class Libro {
	
	private int identificador;
	private String t�tulo;
	private String autor;
	private int a�o_nacimiento;
	private int a�o_publicacion;
	private String editorial;
	private int num_p�ginas;
	
	
	public Libro() {
		this.identificador = 0;
		this.t�tulo = "";
		this.autor = "";
		this.a�o_nacimiento = 0;
		this.a�o_publicacion = 0;
		this.editorial = "";
		this.num_p�ginas = 0;
	}
	
	
	public Libro(String t�tulo, String autor, int a�o_nacimiento, int a�o_publicacion, String editorial, int num_p�ginas){
        this.identificador = 0;
        this.t�tulo = t�tulo;
        this.autor = autor;
        this.a�o_nacimiento = a�o_nacimiento;
        this.a�o_publicacion = a�o_publicacion;
        this.editorial = editorial;
        this.num_p�ginas = num_p�ginas;
    }
	
	
	//GETTERS Y SETTERS
	
	public int getId() {
		return this.identificador;
	}
	public void setId(int identificador) {
		this.identificador = identificador;
	}
	
	
	public String getTitulo() {
		return this.t�tulo;
	}
	public void setTitulo(String t�tulo) {
		this.t�tulo = t�tulo;
	}
	
	
	public String getAutor() {
		return this.autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	
	public int getA�oNacimiento() {
		return this.a�o_nacimiento;
	}
	public void setA�oNacimiento(int a�o_nacimiento) {
		this.a�o_nacimiento = a�o_nacimiento;
	}
	
	
	public int getA�oPublicacion() {
		return this.a�o_publicacion;
	}
	public void setA�oPublicacion(int a�o_publicacion) {
		this.a�o_publicacion = a�o_publicacion;
	}
	
	
	public String getEditorial() {
		return this.editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	
	public int getNumPaginas() {
		return this.num_p�ginas;
	}
	public void setNumPaginas(int num_p�ginas) {
		this.num_p�ginas = num_p�ginas;
	}
	
	
	
	public String toString() {
		return "Id: " + this.identificador +
				"\nT�tulo: " + this.t�tulo + 
				"\nAutor: " + this.autor + 
				"\nA�o de nacimiento: " + this.a�o_nacimiento +
				"\nA�o publicaci�n: " + this.a�o_publicacion +
				"\nEditorial: " + this.editorial + 
				"\nN�mero de p�ginas: " + this.num_p�ginas;
	}

}
