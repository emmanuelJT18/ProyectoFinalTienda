package logic;

import java.util.ArrayList;

public class Combo {
	private final static String prefix = "CB-";
	private int id;
	private String codigo;
	private String  nombre;
	private ArrayList<Componente> componentes;
	private Double descuento;
	public Combo() {
		
	}
	public Combo(int id,String codigo, String nombre, Double descuento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descuento = descuento;
		this.codigo = codigo;
		componentes = new ArrayList<Componente>();
	}
	
	public Combo(String codigo, String nombre, Double descuento) {
		super();
		this.nombre = nombre;
		this.descuento = descuento;
		this.codigo = codigo;
		componentes = new ArrayList<Componente>();
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	
	public static String getPrefix() {
		return prefix;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getCodigo() +" - "+getNombre();
	}
}
