package logic;

import java.util.ArrayList;

public class Combo {
	private String id;
	private String codigo;
	private String  nombre;
	private ArrayList<Componente> componentes;
	private Double descuento;
	
	public Combo(String id,String codigo, String nombre, Double descuento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descuento = descuento;
		this.codigo = codigo;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(ArrayList<Componente> componentes) {
		this.componentes = componentes;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}
	
	
}
