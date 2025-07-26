package logic;

public class MemoriaRam extends Componente {
	private String cantMemoria;
	private String velocidadProcesamiento;
	private String tipoMemoriaRAM;
	
	public MemoriaRam(String codigo, String numeroSerie, String marca, String modelo, double precio, int cantDisponible,
			String cantMemoria, String velocidadProcesamiento, String tipoMemoriaRAM) {
		super(codigo, numeroSerie, marca, modelo, precio, cantDisponible);
		this.cantMemoria = cantMemoria;
		this.velocidadProcesamiento = velocidadProcesamiento;
		this.tipoMemoriaRAM = tipoMemoriaRAM;
	}
	
	public MemoriaRam(int id, String codigo, String numeroSerie, String marca, String modelo, double precio, int cantDisponible,
			String cantMemoria, String velocidadProcesamiento, String tipoMemoriaRAM) {
		super(id, codigo, numeroSerie, marca, modelo, precio, cantDisponible);
		this.cantMemoria = cantMemoria;
		this.velocidadProcesamiento = velocidadProcesamiento;
		this.tipoMemoriaRAM = tipoMemoriaRAM;
	}
	
	public String getTipoMemoriaRAM() {
		return tipoMemoriaRAM;
	}

	public void setTipoMemoriaRAM(String tipoMemoriaRAM) {
		this.tipoMemoriaRAM = tipoMemoriaRAM;
	}


	public String getCantMemoria() {
		return cantMemoria;
	}

	public void setCantMemoria(String cantMemoria) {
		this.cantMemoria = cantMemoria;
	}

	public String getVelocidadProcesamiento() {
		return velocidadProcesamiento;
	}

	public void setVelocidadProcesamiento(String velocidadProcesamiento) {
		this.velocidadProcesamiento = velocidadProcesamiento;
	}
	
	
}
