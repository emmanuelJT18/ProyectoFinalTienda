package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import logic.Cliente;
import logic.Factura;

public class FacturaDAO {
	private static Connection connection = ConnectToDB.getInstance().getConnection();
	
	public static ArrayList<Factura> loadFacturasData(){
		ArrayList<Factura> facturas = new ArrayList<Factura>();
		String query = "SELECT * FROM facturas";
		
		try(
			PreparedStatement stmt = connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
		){
			while(rs.next()) {
				int id = rs.getInt("id");
				String codigo = rs.getString("codigo");
				String clienteId = rs.getString("cliente_id");
				Cliente cliente = ClienteDAO.searchCliente(clienteId);
				Double totalPagar = rs.getDouble("total_pagar");
				
				Factura factura = new Factura(id, codigo, cliente, totalPagar);
				facturas.add(factura);
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return facturas;
	}
	
	
	public static void insertFactura(Factura factura) {
		String query = "INSERT INTO facturas (codigo, cliente_id, total) VALUES (?, ?, ?)";
		try(PreparedStatement stmt = connection.prepareStatement(query)){
			stmt.setString(1, factura.getCodigo());
			stmt.setInt(2, factura.getCliente().getId());
			stmt.setDouble(3, factura.getTotalPagar());
			
			int rowsInserted = stmt.executeUpdate();
			if(rowsInserted > 0) System.out.println("Factura insertada WEPAAA");
		}catch(Exception ex) {
			ex.printStackTrace();
		}

	}
	
	public static int getLastId() {
		String query = "SELECT MAX(id) FROM facturas";
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
}
