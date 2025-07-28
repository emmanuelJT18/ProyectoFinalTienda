package logic;

public class DetalleFactura {
	private int id;
	private int facturaId ;
	private Componente componente;
	private double descuento; 
	private int cantidadVendida ;
	private double total ;
	
	public DetalleFactura(int facturaId, Componente componente, double descuento, int cantidadVendida,
			double total) {
		super();
		this.facturaId = facturaId;
		this.componente = componente;
		this.descuento = descuento;
		this.cantidadVendida = cantidadVendida;
		this.total = total;
	}

	public DetalleFactura(int id, int facturaId, Componente componente, double descuento, int cantidadVendida,
			double total) {
		super();
		this.id = id;
		this.facturaId = facturaId;
		this.componente = componente;
		this.descuento = descuento;
		this.cantidadVendida = cantidadVendida;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFacturaId() {
		return facturaId;
	}

	public void setFacturaId(int facturaId) {
		this.facturaId = facturaId;
	}

	public Componente getComponente() {
		return componente;
	}

	public void setComponente(Componente componente) {
		this.componente = componente;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public int getCantidadVendida() {
		return cantidadVendida;
	}

	public void setCantidadVendida(int cantidadVendida) {
		this.cantidadVendida = cantidadVendida;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
