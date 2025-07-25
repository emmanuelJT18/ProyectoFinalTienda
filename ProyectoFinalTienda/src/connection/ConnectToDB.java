package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB {
	private static ConnectToDB instance;
	private Connection connection;
	private final String URL = "jdbc:mysql://localhost:3306/tienda_electronica";
	private final String USER = "root";
	private final String PASSWORD = "admin";
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	
	private ConnectToDB() {
		createConnection();
	}
	
	public static ConnectToDB getInstance() {
		if(instance == null) {
			instance = new ConnectToDB();
		}
		return instance;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public void closeConnection() {
		try {
			if(connection != null && !connection.isClosed()) {
				connection.close();
				System.out.println("Connection closed. WEPA!!!!");
			}
		} catch(SQLException e) {
			// TODO: handle finally clause
			System.err.println("Error when closing connection: "+e.getStackTrace());
		}
	}
	
	private void createConnection() {
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connection establecida. WEPA!!!");
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println("Error al conectar la base de datos: ");
					e.printStackTrace();
			// TODO: handle exception
		}
	}
}
