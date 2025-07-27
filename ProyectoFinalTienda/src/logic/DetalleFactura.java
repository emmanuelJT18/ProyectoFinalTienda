package logic;

public class DetalleFactura {
	private int id;
	private String facturaCodigo ;
	private Componente componente;
	private double descuento; 
	private int cantidadVendida ;
	private double total ;
	
	public DetalleFactura(String facturaCodigo, Componente componente, double descuento, int cantidadVendida,
			double total) {
		super();
		this.facturaCodigo = facturaCodigo;
		this.componente = componente;
		this.descuento = descuento;
		this.cantidadVendida = cantidadVendida;
		this.total = total;
	}

	public DetalleFactura(int id, String facturaCodigo, Componente componente, double descuento, int cantidadVendida,
			double total) {
		super();
		this.id = id;
		this.facturaCodigo = facturaCodigo;
		this.componente = componente;
		this.descuento = descuento;
		this.cantidadVendida = cantidadVendida;
		this.total = total;
	}
}
