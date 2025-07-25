package logic;

public class Cliente {
	private int id;
	private String codigo;
	private String nombre;
	private String telefono;
	private String direccion;
	
	public Cliente(String codigo, String nombre, String telefono, String direccion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}
	public Cliente(int id, String codigo, String nombre, String telefono, String direccion) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}
	public int getId() { return id; }
	
	public String getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
}
