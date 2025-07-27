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
				
				//addToComponentesList(id, codigo, numeroSerie, marca, modelo, precio, cantDisponible, cantMemoria, tipoConexion, velocidadProcesamiento, conexionesDiscosDuros, tipoMemoriaRAM);
				Componente componente = createComponentesFromTableData(id, codigo, numeroSerie, marca, modelo, precio, cantDisponible, cantMemoria, tipoConexion, velocidadProcesamiento, conexionesDiscosDuros, tipoMemoriaRAM);
				componentes.add(componente);
				//controller.addComponente(componente);
			}
		}catch(Exception ex) {
			System.out.println("Ha ocurrido un error: ");
			ex.printStackTrace();
		}
		return componentes;
	}

	public static void insertDiscoDuro(DiscoDuro dd) {
		String query = "INSERT INTO componentes (codigo, numero_serie, marca, modelo, precio, cant_disponible, tipo_conexion, tipo_memoria_ram)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try(PreparedStatement stmt = connection.prepareStatement(query)){
			stmt.setString(1, dd.getCodigo());
			stmt.setString(2, dd.getNumeroSerie());
			stmt.setString(3, dd.getMarca());
			stmt.setString(4, dd.getModelo());
			stmt.setDouble(5, dd.getPrecio());
			stmt.setInt(6, dd.getCantDisponible());
			stmt.setString(7, dd.getTipoConexion());
			stmt.setString(8, dd.getCantMemoria());
			
			int rowsInserted = stmt.executeUpdate();
			if(rowsInserted > 0) System.out.println("Disco Duro insertado");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void updateDiscoDuro(DiscoDuro dd) {
		String query = "UPDATE componentes SET codigo = ?, numero_serie = ?, marca = ?, modelo = ?, precio = ?, cant_disponible = ?, tipo_conexion = ?, tipo_memoria_ram = ?"
				+ "WHERE codigo = ?";

		try(PreparedStatement stmt = connection.prepareStatement(query)){
			stmt.setString(1, dd.getCodigo());
			stmt.setString(2, dd.getNumeroSerie());
			stmt.setString(3, dd.getMarca());
			stmt.setString(4, dd.getModelo());
			stmt.setDouble(5, dd.getPrecio());
			stmt.setInt(6, dd.getCantDisponible());
			stmt.setString(7, dd.getTipoConexion());
			stmt.setString(8, dd.getCantMemoria());
			stmt.setString(9, dd.getCodigo());

			int rowsUpdated = stmt.executeUpdate();
			if(rowsUpdated > 0) {
				System.out.println("DiscoDuro actualizado WEPAAA");
			} else {
				System.out.println("DiscoDuro con el codigo: "+dd.getCodigo()+" no ha sido encontrado");
			}		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void insertMicroProcesador(MicroProcesador mp) {
		String query = "INSERT INTO componentes(codigo, numero_serie, marca, modelo, precio, cant_disponible, tipo_conexion, velocidad_procesamiento)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try(PreparedStatement stmt = connection.prepareStatement(query)){
			stmt.setString(1, mp.getCodigo());
			stmt.setString(2, mp.getNumeroSerie());
			stmt.setString(3, mp.getMarca());
			stmt.setString(4, mp.getModelo());
			stmt.setDouble(5, mp.getPrecio());
			stmt.setInt(6, mp.getCantDisponible());
			stmt.setString(7, mp.getTipoConexion());
			stmt.setString(8, mp.getVelocidadProcesamiento());
			
			int rowsInserted = stmt.executeUpdate();
			if(rowsInserted > 0) System.out.println("MicroProcesador insertado");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void updateMicroProcesador(MicroProcesador mp) {
		String query = "UPDATE componentes SET codigo = ?, numero_serie = ?, marca = ?, modelo = ?, precio = ?, cant_disponible = ?, tipo_conexion = ?, velocidad_procesamiento = ?"
				+ "WHERE codigo = ?";
		try(PreparedStatement stmt = connection.prepareStatement(query)){
			stmt.setString(1, mp.getCodigo());
			stmt.setString(2, mp.getNumeroSerie());
			stmt.setString(3, mp.getMarca());
			stmt.setString(4, mp.getModelo());
			stmt.setDouble(5, mp.getPrecio());
			stmt.setInt(6, mp.getCantDisponible());
			stmt.setString(7, mp.getTipoConexion());
			stmt.setString(8, mp.getVelocidadProcesamiento());
			stmt.setString(9, mp.getCodigo());
			
			int rowsUpdated = stmt.executeUpdate();
			if(rowsUpdated > 0) System.out.println("MicroProcesador actualizado");
		}catch(Exception ex) {
			ex.printStackTrace();
		}

	}
	public static void insertTarjetaMadre(TarjetaMadre tm) {
		String query = "INSERT INTO componentes (codigo, numero_serie, marca, modelo, precio, cant_disponible, tipo_conexion, tipo_memoria_ram, conexiones_discos_duros)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try(PreparedStatement stmt = connection.prepareStatement(query)){
			stmt.setString(1, tm.getCodigo());
			stmt.setString(2, tm.getNumeroSerie());
			stmt.setString(3, tm.getMarca());
			stmt.setString(4, tm.getModelo());
			stmt.setDouble(5, tm.getPrecio());
			stmt.setInt(6, tm.getCantDisponible());
			stmt.setString(7, tm.getTipoConexion());
			stmt.setString(8, tm.getTipoMemoriaRAM());
			stmt.setString(9, tm.getConxionesDiscosDuros());
			
			int rowsInserted = stmt.executeUpdate();
			if(rowsInserted > 0) System.out.println("Tarjeta madre insertada");
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void updateTarjetaMadre(TarjetaMadre tm) {
		String query = "UPDATE componentes SET codigo = ?, numero_serie = ?, marca = ?, modelo = ?, precio = ?, cant_disponible = ?, tipo_conexion = ?, tipo_memoria_ram = ?, conexiones_discos_duros = ?"
				+"WHERE codigo = ?";
		
		try(PreparedStatement stmt = connection.prepareStatement(query)){
			stmt.setString(1, tm.getCodigo());
			stmt.setString(2, tm.getNumeroSerie());
			stmt.setString(3, tm.getMarca());
			stmt.setString(4, tm.getModelo());
			stmt.setDouble(5, tm.getPrecio());
			stmt.setInt(6, tm.getCantDisponible());
			stmt.setString(7, tm.getTipoConexion());
			stmt.setString(8, tm.getTipoMemoriaRAM());
			stmt.setString(9, tm.getConxionesDiscosDuros());
			stmt.setString(10, tm.getCodigo());
			
			int rowsUpdated = stmt.executeUpdate();
			if(rowsUpdated > 0) System.out.println("Tarjeta madre actualizada");
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void insertMemoriaRam(MemoriaRam ram) {
		String query = "INSERT INTO componentes(codigo, numero_serie, marca, modelo, precio, cant_disponible, tipo_memoria_ram, velocidad_procesamiento, cant_memoria)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try(PreparedStatement stmt = connection.prepareStatement(query)){
			stmt.setString(1, ram.getCodigo());
			stmt.setString(2, ram.getNumeroSerie());
			stmt.setString(3, ram.getMarca());
			stmt.setString(4, ram.getModelo());
			stmt.setDouble(5, ram.getPrecio());
			stmt.setInt(6, ram.getCantDisponible());
			stmt.setString(7, ram.getTipoMemoriaRAM());
			stmt.setString(8, ram.getVelocidadProcesamiento());
			stmt.setString(9, ram.getCantMemoria());
			
			int rowsInserted = stmt.executeUpdate();
			if(rowsInserted > 0) System.out.println("Memoria Ram insertada");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void updateMemoriaRam(MemoriaRam ram) {
		String query = "UPDATE componentes SET codigo = ?, numero_serie = ?, marca = ?, modelo = ?, precio = ?, cant_disponible = ?, tipo_memoria_ram = ?, velocidad_procesamiento = ?, cant_memoria = ?"
				+ "WHERE codigo = ?";
		try(PreparedStatement stmt = connection.prepareStatement(query)){
			stmt.setString(1, ram.getCodigo());
			stmt.setString(2, ram.getNumeroSerie());
			stmt.setString(3, ram.getMarca());
			stmt.setString(4, ram.getModelo());
			stmt.setDouble(5, ram.getPrecio());
			stmt.setInt(6, ram.getCantDisponible());
			stmt.setString(7, ram.getTipoMemoriaRAM());
			stmt.setString(8, ram.getVelocidadProcesamiento());
			stmt.setString(9, ram.getCantMemoria());
			stmt.setString(10, ram.getCodigo());
			
			int rowsUpdated = stmt.executeUpdate();
			if(rowsUpdated > 0) System.out.println("Memoria Ram actualizada");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void deleteComponente(String codigo) {
		String query = "DELETE FROM componentes WHERE codigo = ?";
		try(PreparedStatement stmt = connection.prepareStatement(query)){
			stmt.setString(1, codigo);
			
			int rowsDeleted = stmt.executeUpdate();
			if(rowsDeleted > 0) {
				System.out.println("Componente deleted WEPAA");
			}else {
				System.out.println("Componente con el codigo: "+codigo+" no ha sido encontrado");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static Componente createComponentesFromTableData(int id, String codigo, String numeroSerie, String marca, String modelo,
			Double precio, int cantDisponible, String cantMemoria, String tipoConexion,
	        String velocidadProcesamiento, String conexionesDiscosDuros, String tipoMemoriaRAM) {

	        if (codigo.contains("DD")) {
	            return new DiscoDuro(id, codigo, numeroSerie, marca, modelo, precio, cantDisponible, tipoConexion, cantMemoria);
	        } else if (codigo.contains("RAM")) {
	            return new MemoriaRam(id, codigo, numeroSerie, marca, modelo, precio, cantDisponible, cantMemoria, velocidadProcesamiento, tipoMemoriaRAM);
	        } else if (codigo.contains("MP")) {
	            return new MicroProcesador(id, codigo, numeroSerie, marca, modelo, precio, cantDisponible, tipoConexion, velocidadProcesamiento);
	        } else if (codigo.contains("TM")) {
	            return new TarjetaMadre(id, codigo, numeroSerie, marca, modelo, precio, cantDisponible, tipoConexion, tipoMemoriaRAM, conexionesDiscosDuros);
	        } else {
	            System.out.println("Tipo de componente desconocido: " + codigo);
	            return null;
	        }
	    }
	
	public static void addToComponentesList(int id, String codigo, String numeroSerie, String marca, String modelo, Double precio, int cantDisponible, String cantMemoria, String tipoConexion, String velocidadProcesamiento, String conexionesDiscosDuros, String tipoMemoriaRAM) {
		if(codigo.contains("DD")) {
			DiscoDuro dd = new DiscoDuro(id, codigo, numeroSerie, marca, modelo, precio, cantDisponible, tipoConexion, cantMemoria);
			controller.getComponentes().add(dd);
			System.out.println(DiscoDuro.class);
			
		} else if(codigo.contains("RAM")) {
			MemoriaRam ram = new MemoriaRam(id, codigo, numeroSerie, marca, modelo, precio, cantDisponible, cantMemoria, velocidadProcesamiento, tipoMemoriaRAM);
			controller.getComponentes().add(ram);
			System.out.println(MemoriaRam.class);
			
		} else if(codigo.contains("MP")) {
			MicroProcesador mp = new MicroProcesador(id, codigo, numeroSerie, marca, modelo, precio, cantDisponible, tipoConexion, velocidadProcesamiento);
			controller.getComponentes().add(mp);
			System.out.println(MicroProcesador.class);
			
		} else if(codigo.contains("TM")) {
			TarjetaMadre tm = new TarjetaMadre(id, codigo, numeroSerie, marca, modelo, precio, cantDisponible, tipoConexion, tipoMemoriaRAM, conexionesDiscosDuros);
			controller.getComponentes().add(tm);
			System.out.println(TarjetaMadre.class);

		} else {
			System.out.println("Codigo no para agregar al componente a la lista es desconocido");
		}
		
	}
}
