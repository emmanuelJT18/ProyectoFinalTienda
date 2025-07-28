package logic;

import java.time.LocalDateTime;
import java.util.ArrayList;

import connection.FacturaDAO;

public class Factura {
	private final static String prefix = "F-";
	private int id;
	private String codigo;
	private Cliente cliente;
	private ArrayList<DetalleFactura> detalles;
	private LocalDateTime fecha;
	private double totalPagar;
	
	public Factura(int id, String codigo, Cliente cliente, double totalPagar, LocalDateTime fecha) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.cliente = cliente;
		this.detalles = new ArrayList<DetalleFactura>();
		this.fecha = fecha;
		this.totalPagar = totalPagar;
	}

	public Factura(String codigo, Cliente cliente, double totalPagar) {
		super();
		this.codigo = codigo;
		this.cliente = cliente;
		this.detalles = new ArrayList<DetalleFactura>();
		this.totalPagar = totalPagar;
	}
	
	public static String getPrefix() {
		return prefix;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<DetalleFactura> getDetalles() {
		return detalles;
	}

	public void setDetalles(ArrayList<DetalleFactura> detalles) {
		this.detalles = detalles;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public double getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}
	
}
