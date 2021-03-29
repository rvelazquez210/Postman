package mapeo.Libros;

public class LibrosDetalles {

	private int precio;
	private String categoria;
	private LibrosStock stock;
	
	public LibrosDetalles(int precio, String categoria, LibrosStock stock) {
		super();
		this.precio = precio;
		this.categoria = categoria;
		this.stock = stock;
	}
	
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public LibrosStock getStock() {
		return stock;
	}
	public void setStock(LibrosStock stock) {
		this.stock = stock;
	}
	
	
	
}
