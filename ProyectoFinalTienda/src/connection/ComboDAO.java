package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import logic.Combo;
import logic.Componente;
import logic.Tienda;

public class ComboDAO {
	private final static Connection connection = ConnectToDB.getInstance().getConnection();
	private final static Tienda controller = Tienda.getInstance();
	
	public static void insertCombo(Combo cb) {
		String query = "INSERT INTO combos (codigo, nombre, descuento) VALUES (?, ?, ?)";
		
		try(PreparedStatement stmt = connection.prepareStatement(query)){
			stmt.setString(1, cb.getCodigo());
			stmt.setString(2, cb.getNombre());
			stmt.setDouble(3, cb.getDescuento());
			
			int rowsInserted = stmt.executeUpdate();
			if(rowsInserted > 0) System.out.println("Combo insertado WEPAAA");
			int lastId = getLastId();
			query = "INSERT INTO combos_componentes (combo_id, componente_id) VALUES (?, ?)";
			try(PreparedStatement stmt2 = connection.prepareStatement(query)){
				rowsInserted = 0;
				for(Componente c : cb.getComponentes()) {
					stmt2.setInt(1, lastId);
					stmt2.setInt(2, c.getId());
					rowsInserted = stmt2.executeUpdate();
					if(rowsInserted > 0) System.out.println("Combo insertado WEPAAA");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static ArrayList<Combo> loadCombosData() {
	    ArrayList<Combo> combos = new ArrayList<>();
	    String queryCombos = "SELECT * FROM combos";
	    String queryComponentes = "SELECT componente_id FROM combos_componentes WHERE combo_id = ?";

	    try (
	        PreparedStatement stmtCombos = connection.prepareStatement(queryCombos);
	        ResultSet rsCombos = stmtCombos.executeQuery();
	    ) {
	        while (rsCombos.next()) {
	            int id = rsCombos.getInt("id");
	            String codigo = rsCombos.getString("codigo");
	            String nombre = rsCombos.getString("nombre");
	            Double descuento = rsCombos.getDouble("descuento");

	            Combo combo = new Combo(id, codigo, nombre, descuento);

	            try (
	                PreparedStatement stmtComponentes = connection.prepareStatement(queryComponentes);
	            ) {
	                stmtComponentes.setInt(1, id);  
	                try (ResultSet rsComponentes = stmtComponentes.executeQuery()) {
	                    while (rsComponentes.next()) {
	                        int compId = rsComponentes.getInt("componente_id");
	                        Componente comp = ComponenteDAO.searchComponenteById(compId);
	                        if (comp != null) {
	                            combo.getComponentes().add(comp);
	                        }
	                    }
	                }
	            }

	            combos.add(combo);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return combos;
	}
	
	public static int getLastId() {
		String query = "SELECT MAX(id) FROM combos";
		int id = 0;
		try(PreparedStatement stmt = connection.prepareStatement(query);
				ResultSet rs = stmt.executeQuery();
				){
			if(rs.next()) {
				id = rs.getInt(1);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}

		return id;
	}
	
	public static Combo searchComboeById(int id) {
		String queryCombo = "SELECT * FROM combos WHERE id = ?";
	    String queryComponentes = "SELECT componente_id FROM combos_componentes WHERE combo_id = ?";
		
		try(
			PreparedStatement stmtCombo = connection.prepareStatement(queryCombo);
			){
			stmtCombo.setInt(1, id);
			ResultSet rsCombos = stmtCombo.executeQuery();
			if(rsCombos.next()) {
	            String codigo = rsCombos.getString("codigo");
	            String nombre = rsCombos.getString("nombre");
	            Double descuento = rsCombos.getDouble("descuento");

	            Combo combo = new Combo(id, codigo, nombre, descuento);

	            try (
	                PreparedStatement stmtComponentes = connection.prepareStatement(queryComponentes);
	            ) {
	                stmtComponentes.setInt(1, id);  
	                try (ResultSet rsComponentes = stmtComponentes.executeQuery()) {
	                    while (rsComponentes.next()) {
	                        int compId = rsComponentes.getInt("componente_id");
	                        Componente comp = ComponenteDAO.searchComponenteById(compId);
	                        if (comp != null) {
	                            combo.getComponentes().add(comp);
	                        }
	                    }
	                }
	            }
	            return combo;
			}
			
		}catch (Exception ex) {
	        ex.printStackTrace();
		}
		return null;
	}
	
	public static void deleteCombo(int id) {
		String query = "DELETE FROM combos WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)){
			stmt.setInt(1, id);
			int rowsDeleted = stmt.executeUpdate();
			if(rowsDeleted > 0) {
				System.out.println("Componente deleted WEPAA");
			}else {
				System.out.println("Componente con el codigo: "+id+" no ha sido encontrado");
			}
		} catch (Exception ex) {
	        ex.printStackTrace();
		}
	}
}
