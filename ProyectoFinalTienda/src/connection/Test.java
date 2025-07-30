package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import logic.Cliente;
import logic.Combo;
import logic.Componente;
import logic.DetalleFactura;
import logic.Factura;
import logic.Tienda;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		/*Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/tienda_electronica";
		Connection con = DriverManager.getConnection(url, "root", "admin");
		System.out.println("Connection created");
		con.close();*/
		
		//ConnectToDB conn = ConnectToDB.getInstance();
		//cd.loadClientesData();
		
		Cliente cliente = ClienteDAO.searchClientebyId(2);
		Factura factura = FacturaDAO.searchFacturaById(7);
		System.out.println(factura.getId());
		System.out.println(factura.getCodigo());
		System.out.println(factura.getCliente().getNombre());
		System.out.println(factura.getTotalPagar());
		
		Combo cb = new Combo("CB-1", "Combo 1", 0.1);
		ComboDAO.insertCombo(cb);
		/*
		Componente componente = ComponenteDAO.searchComponenteById(1);
		DetalleFactura df = new DetalleFactura(factura.getId(), componente, 0.1, 5, 1000.0);
		DetalleFacuraDAO.insertDetalleFactura(df);
		DetalleFacuraDAO.insertDetalleFactura(df);
		DetalleFacuraDAO.insertDetalleFactura(df);
		ArrayList<DetalleFactura> detalles = DetalleFacuraDAO.loadDetalleFacturasData(7);
		for(DetalleFactura detalle : detalles) {
			System.out.println();
			System.out.println(detalle.getId());
			System.out.println(detalle.getFacturaId());
			System.out.println(detalle.getComponente().getCodigo());
			System.out.println(detalle.getDescuento()*100);
			System.out.println(detalle.getCantidadVendida());
			System.out.println(detalle.getTotal());
			System.out.println();
		}*/
		
		//ClienteDAO.createCliente(cliente);
		//cliente.setNombre("Juanito Pedro");
		//ClienteDAO.updateCliente(cliente);
		//ClienteDAO.deleteCliente("test");
		/*
		int id = 1;
		String codigo = "001";
		String numeroSerie = "numero_serie";
		String marca = "marca";
		String modelo = "modelo";
		Double precio = 999.0;
		int cantDisponible = 5;
		String cantMemoria = "cant_memoria";
		String tipoConexion = "tipo_conexion";
		String tipoMemoriaRAM = "tipo_memoria_ram";
		String velocidadProcesamiento = "velocidad_procesamiento";
		String conexionesDiscosDuros = "conexiones_discos_duros";
		
		Tienda.getInstance();
		
		ArrayList<Componente> comps = ComponenteDAO.loadComponentesData();
		for(Componente c : comps) {
			System.out.println(c.getCodigo());
		}
		
		ComponenteDAO.searchComponenteById(1);
		System.out.println(ClienteDAO.searchClientebyId(10).getNombre());
		*/
		/*
		Factura factura = new Factura(Tienda.generateCodigo(), cliente, 12000);
		FacturaDAO.insertFactura(factura);
		System.out.println("MaxID ===========> "+FacturaDAO.getLastId());
		*/
	}

}
