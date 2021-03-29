package mapeo.Libros;

public class LibrosStock {
	
	private int total;
    private LibrosReservado reservado;
	
    public LibrosStock(int total, LibrosReservado reservado) {
		super();
		this.total = total;
		this.reservado = reservado;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public LibrosReservado getReservado() {
		return reservado;
	}

	public void setReservado(LibrosReservado reservado) {
		this.reservado = reservado;
	}

        
}
