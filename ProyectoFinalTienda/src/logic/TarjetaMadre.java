package logic;

public class TarjetaMadre extends Componente {
	private String tipoConexion;
	private String tipoMemoriaRAM;
	private String conxionesDiscosDuros;
	
	public TarjetaMadre(String codigo, String numeroSerie, String marca, String modelo, double precio, int cantDisponible,
			String tipoConexion, String tipoMemoriaRAM, String conxionesDiscosDuros) {
		super(codigo, numeroSerie, marca, modelo, precio, cantDisponible);
		this.tipoConexion = tipoConexion;
		this.tipoMemoriaRAM = tipoMemoriaRAM;
		this.conxionesDiscosDuros = conxionesDiscosDuros;
	}
	
	public TarjetaMadre(int id, String codigo, String numeroSerie, String marca, String modelo, double precio, int cantDisponible,
			String tipoConexion, String tipoMemoriaRAM, String conxionesDiscosDuros) {
		super(id, codigo, numeroSerie, marca, modelo, precio, cantDisponible);
		this.tipoConexion = tipoConexion;
		this.tipoMemoriaRAM = tipoMemoriaRAM;
		this.conxionesDiscosDuros = conxionesDiscosDuros;
	}

	public TarjetaMadre() {
		// TODO Auto-generated constructor stub
		super();
	}

	public String getTipoConexion() {
		return tipoConexion;
	}

	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}

	public String getTipoMemoriaRAM() {
		return tipoMemoriaRAM;
	}

	public void setTipoMemoriaRAM(String tipoMemoriaRAM) {
		this.tipoMemoriaRAM = tipoMemoriaRAM;
	}

	public String getConxionesDiscosDuros() {
		return conxionesDiscosDuros;
	}

	public void setConxionesDiscosDuros(String conxionesDiscosDuros) {
		this.conxionesDiscosDuros = conxionesDiscosDuros;
	}
}
