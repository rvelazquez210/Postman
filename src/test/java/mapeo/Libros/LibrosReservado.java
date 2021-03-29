package mapeo.Libros;

public class LibrosReservado {

	private int total_reservados;
    private LibrosPagados pagados;
    
	public LibrosReservado(int total_reservados, LibrosPagados pagados) {
		super();
		this.total_reservados = total_reservados;
		this.pagados = pagados;
	}
	
	public int getTotal_reservados() {
		return total_reservados;
	}
	public void setTotal_reservados(int total_reservados) {
		this.total_reservados = total_reservados;
	}
	public LibrosPagados getPagados() {
		return pagados;
	}
	public void setPagados(LibrosPagados pagados) {
		this.pagados = pagados;
	}
    
    
}
