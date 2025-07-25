package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import logic.Cliente;

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
		
		Cliente cliente = new Cliente(5,"test", "test", "test", "test");
		//ClienteDAO.createCliente(cliente);
		//cliente.setNombre("Juanito Pedro");
		//ClienteDAO.updateCliente(cliente);
		//ClienteDAO.deleteCliente("test");
		
		int id = 1;
		String codigo = "DD1";
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
		
		
	}

}
