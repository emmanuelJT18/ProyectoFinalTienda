package logic;

public class MicroProcesador extends Componente {
	private String tipoConexion;
	private String velocidadProcesamiento;
	
	public MicroProcesador(String codigo, String numeroSerie, String marca, String modelo, double precio,
			int cantDisponible, String tipoConexion, String velocidadProcesamiento) {
		super(codigo, numeroSerie, marca, modelo, precio, cantDisponible);
		this.tipoConexion = tipoConexion;
		this.velocidadProcesamiento = velocidadProcesamiento;
	}
	public MicroProcesador(int id, String codigo, String numeroSerie, String marca, String modelo, double precio,
			int cantDisponible, String tipoConexion, String velocidadProcesamiento) {
		super(id, codigo, numeroSerie, marca, modelo, precio, cantDisponible);
		this.tipoConexion = tipoConexion;
		this.velocidadProcesamiento = velocidadProcesamiento;
	}

	public MicroProcesador() {
		// TODO Auto-generated constructor stub
		super();
	}
	public String getTipoConexion() {
		return tipoConexion;
	}

	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}

	public String getVelocidadProcesamiento() {
		return velocidadProcesamiento;
	}

	public void setVelocidadProcesamiento(String velocidadProcesamiento) {
		this.velocidadProcesamiento = velocidadProcesamiento;
	}
	
	
}
