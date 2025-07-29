package connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import logic.Cliente;

public class ClienteDAO {
	private final static Connection connection = ConnectToDB.getInstance().getConnection();
	
	public ClienteDAO() {}
	
	public static ArrayList<Cliente> loadClientesData() {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		String query = "SELECT id, codigo, nombre, direccion, telefono FROM clientes";
		try (
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery();
			){
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String codigo = resultSet.getString("codigo");
				String nombre = resultSet.getString("nombre");
				String direccion = resultSet.getString("direccion");
				String telefono = resultSet.getString("telefono");
				
				Cliente cliente = new Cliente(id, codigo, nombre, telefono, direccion);
				clientes.add(cliente);
			}
			
		}catch (Exception ex) {
			System.err.println("Ha ocurrido un error: ");
			ex.printStackTrace();
		}
		return clientes;
	}
	
	public static Cliente searchCliente(String codigo) {
		Cliente cliente = null;
		String query = "SELECT * FROM clientes WHERE codigo = ?";
		
		try(PreparedStatement stmt = connection.prepareStatement(query)){
			stmt.setString(1, codigo);
			try(ResultSet resultSet = stmt.executeQuery()){
				if(resultSet.next()) {
					int id = resultSet.getInt("id");
					String nombre = resultSet.getString("nombre");
					String direccion = resultSet.getString("direccion");
					String telefono = resultSet.getString("telefono");
					cliente = new Cliente(id, codigo, nombre, telefono, direccion);
				}
			}
			
		} catch (Exception ex) {
	        ex.printStackTrace();
		}
		return cliente;
	}
	
	public static Cliente searchClientebyId(int id) {
		Cliente cliente = null;
		String query = "SELECT * FROM clientes WHERE id = ?";
		
		try(PreparedStatement stmt = connection.prepareStatement(query)){
			stmt.setInt(1, id);
			try(ResultSet resultSet = stmt.executeQuery()){
				if(resultSet.next()) {
					String codigo = resultSet.getString("codigo");
					String nombre = resultSet.getString("nombre");
					String direccion = resultSet.getString("direccion");
					String telefono = resultSet.getString("telefono");
					cliente = new Cliente(id, codigo, nombre, telefono, direccion);
				}
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return cliente;
	}
	
	public static void createCliente(Cliente cliente) {
		String query = "INSERT INTO clientes (codigo, nombre, direccion, telefono) VALUES (?, ?, ?, ?)";
		
		try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
			preparedStatement.setString(1, cliente.getCodigo());
			preparedStatement.setString(2, cliente.getNombre());
			preparedStatement.setString(3, cliente.getDireccion());
			preparedStatement.setString(4, cliente.getTelefono());
			
			int rowsInserted = preparedStatement.executeUpdate();
			if(rowsInserted > 0) System.out.println("Cliente insertado WEPAAA");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void updateCliente(Cliente cliente) {
		String query = "UPDATE clientes SET nombre = ?, direccion = ?, telefono = ? WHERE codigo = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
			preparedStatement.setString(1, cliente.getNombre());
			preparedStatement.setString(2, cliente.getDireccion());
			preparedStatement.setString(3, cliente.getTelefono());
			preparedStatement.setString(4, cliente.getCodigo());
			
			int rowsUpdated = preparedStatement.executeUpdate();
			if(rowsUpdated > 0) {
				System.out.println("Cliente actualizado WEPAAA");
			} else {
				System.out.println("Cliente con el codigo: "+cliente.getCodigo()+" no ha sido encontrado");
			}
		} catch(Exception ex) {
				System.out.println("Ha ocurrido un error: "+ex.getStackTrace());
			}
	}
	
	public static void deleteCliente(String codigo) {
		String query = "DELETE FROM clientes WHERE codigo = ?";
		
		try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
			preparedStatement.setString(1, codigo);
			int rowsDeleted = preparedStatement.executeUpdate();
			
			if(rowsDeleted > 0) {
				System.out.println("Cliente deleted WEPAA");
			}else {
				System.out.println("Cliente con el codigo: "+codigo+" no ha sido encontrado");
			}
		}catch (SQLException e) {
		    if (e.getErrorCode() == 1451) {
		        // Código de error 1451 = Cannot delete or update a parent row (foreign key fails)
		    	JOptionPane.showConfirmDialog(null, "Este cliente posee facturas asociadas por lo cual no se puede eliminar.");
		    } else {
		        e.printStackTrace();
		    }
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
