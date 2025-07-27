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
}
