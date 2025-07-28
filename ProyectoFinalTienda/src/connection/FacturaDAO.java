package connection;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
				int clienteId = rs.getInt("cliente_id");
				Cliente cliente = ClienteDAO.searchClientebyId(clienteId);
				Double totalPagar = rs.getDouble("total");
				Timestamp ts = rs.getTimestamp("created_at");
				LocalDateTime fecha = ts.toLocalDateTime();
				Factura factura = new Factura(id, codigo, cliente, totalPagar, fecha);
				facturas.add(factura);
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		}

		return facturas;
	}

	public static Factura searchFacturaById(int id) {
		String query = "SELECT * FROM facturas WHERE id = ?";

		try(PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, id);
			try(ResultSet rs = stmt.executeQuery()){
				if(rs.next()) {
					String codigo = rs.getString("codigo");
					int cliente_id = rs.getInt("cliente_id");
					Cliente cliente = ClienteDAO.searchClientebyId(cliente_id);
					double totalPagar = rs.getDouble("total");
					Timestamp ts = rs.getTimestamp("created_at");
					LocalDateTime fecha = ts.toLocalDateTime();
					return new Factura(id, codigo, cliente, totalPagar, fecha);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();		
		}
		return null;
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
