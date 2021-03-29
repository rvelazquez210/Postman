package mapeo.Libros;

public class Libros {
	
	private String nombre_libro;
	private LibrosDetalles detalles;
	
	public Libros(String nombre_libro, LibrosDetalles detalles) {
		super();
		this.nombre_libro = nombre_libro;
		this.detalles = detalles;
	}

	public String getNombre_libro() {
		return nombre_libro;
	}

	public void setNombre_libro(String nombre_libro) {
		this.nombre_libro = nombre_libro;
	}

	public LibrosDetalles getDetalles() {
		return detalles;
	}

	public void setDetalles(LibrosDetalles detalles) {
		this.detalles = detalles;
	}
		
}
