package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import logic.Componente;
import logic.DetalleFactura;
import logic.Factura;

public class DetalleFacuraDAO {
	private static Connection connection = ConnectToDB.getInstance().getConnection();
	
	public static ArrayList<DetalleFactura> loadDetalleFacturasData(int facturaId){
		ArrayList<DetalleFactura> detalles = new ArrayList<DetalleFactura>();
		String query = "SELECT * FROM detalle_factura WHERE factura_id = ?";
		try(PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, facturaId);
			try (ResultSet rs = stmt.executeQuery()){
				while(rs.next()) {
					int id = rs.getInt("id");
					int componenteId = rs.getInt("componente_id");
					Componente componente = ComponenteDAO.searchComponenteById(componenteId);
					double descuento = rs.getDouble("descuento");
					int cantidadVendida = rs.getInt("cant_vendida");
					double total = rs.getDouble("total");
					DetalleFactura detalle = new DetalleFactura(id, facturaId, componente, descuento, cantidadVendida, total);
					detalles.add(detalle);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return detalles;
	}
	
	public static void insertDetalleFactura(DetalleFactura df) {
		String query = "INSERT INTO detalle_factura (factura_id, componente_id, precio_unitario, descuento, cant_vendida, total)"
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		try(PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, df.getFacturaId());
			stmt.setInt(2, df.getComponente().getId());
			stmt.setDouble(3, df.getComponente().getPrecio());
			stmt.setDouble(4, df.getDescuento());
			stmt.setInt(5, df.getCantidadVendida());
			stmt.setDouble(6, df.getTotal());
			
			int rowsInserted = stmt.executeUpdate();
			if(rowsInserted > 0) System.out.println("DEtalle De Factura insertado WEPAAA");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
