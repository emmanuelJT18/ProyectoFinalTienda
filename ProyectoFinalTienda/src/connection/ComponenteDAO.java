package connection;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

import logic.Componente;
import logic.DiscoDuro;
import logic.MemoriaRam;
import logic.MicroProcesador;
import logic.TarjetaMadre;
import logic.Tienda;
public class ComponenteDAO {
	private final static Connection connection = ConnectToDB.getInstance().getConnection();
	private final static Tienda controller = Tienda.getInstance();
	public ComponenteDAO() {}
	
	public static ArrayList<Componente> loadComponentesData(){
		ArrayList<Componente> componentes = new ArrayList<Componente>();
		//String query = "SELECT id, codigo, numero_serie, marca, modelo, precio, cant_disponible FROM componentes";
		String query = "SELECT * FROM componentes";
		try(
			PreparedStatement stmt = connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);
		){
			while(rs.next()) {
				int id = rs.getInt("id");
				String codigo = rs.getString("codigo");
				String numeroSerie = rs.getString("numero_serie");
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				Double precio = rs.getDouble("precio");
				int cantDisponible = rs.getInt("cant_disponible");
				String cantMemoria = rs.getString("cant_memoria");
				String tipoConexion = rs.getString("tipo_conexion");
				String tipoMemoriaRAM = rs.getString("tipo_memoria_ram");
				String velocidadProcesamiento = rs.getString("velocidad_procesamiento");
				String conexionesDiscosDuros = rs.getString("conexiones_discos_duros");
				//LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();
				
				addToComponentesList(id, codigo, numeroSerie, marca, modelo, precio, cantDisponible, cantMemoria, tipoConexion, velocidadProcesamiento, conexionesDiscosDuros, tipoMemoriaRAM);
			}
		}catch(Exception ex) {
			System.out.println("Ha ocurrido un error: "+ex.getStackTrace());
		}
		return componentes;
	}
	
	private static void addToComponentesList(int id, String codigo, String numeroSerie, String marca, String modelo, Double precio, int cantDisponible, String cantMemoria, String tipoConexion, String velocidadProcesamiento, String conexionesDiscosDuros, String tipoMemoriaRAM) {
		if(codigo.contains("DD")) {
			DiscoDuro dd = new DiscoDuro(id, codigo, numeroSerie, marca, modelo, precio, cantDisponible, tipoConexion, cantMemoria);
			controller.getComponentes().add(dd);
			System.out.println(DiscoDuro.class);
		} else if(codigo.contains("RAM")) {
			MemoriaRam ram = new MemoriaRam(id, codigo, numeroSerie, marca, modelo, precio, cantDisponible, cantMemoria, velocidadProcesamiento, tipoMemoriaRAM);
			controller.getComponentes().add(ram);
			System.out.println();
		} else if(codigo.contains("MP")) {
			MicroProcesador mp = new MicroProcesador(id, codigo, numeroSerie, marca, modelo, precio, cantDisponible, tipoConexion, velocidadProcesamiento);
			controller.getComponentes().add(mp);
		} else if(codigo.contains("TM")) {
			TarjetaMadre tm = new TarjetaMadre(id, codigo, numeroSerie, marca, modelo, precio, cantDisponible, tipoConexion, tipoMemoriaRAM, conexionesDiscosDuros);
			controller.getComponentes().add(tm);
		} else {
			System.out.println("Codigo no para agregar al componente a la lista es desconocido");
		}
		
	}
}
