package logic;

import java.util.ArrayList;

import connection.ClienteDAO;
import connection.ComponenteDAO;
import connection.FacturaDAO;

public class Tienda {
	private ArrayList<Componente> componentes;
	private ArrayList<Cliente> clientes;
	private static Tienda uniqueInstance;
	private int cantMemoriasRam = 0;
	private int cantTarjetasMadre = 0;
	private int cantMicroProcesadores = 0;
	private int cantDiscosDuros = 0;
	
	public static Tienda getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new Tienda();

		}
		return uniqueInstance;
	}

	private Tienda() {
		componentes = new ArrayList<Componente>();
		clientes = new ArrayList<Cliente>();
		//LOADdata();
		getCountOfEachComponente();
	}
	
	public ArrayList<Componente> getComponentes() {
		componentes = ComponenteDAO.loadComponentesData();
		return componentes;
	}
	public void setComponentes(ArrayList<Componente> componentes) {
		this.componentes = componentes;
	}

	public ArrayList<Cliente> getClientes() {
		clientes = ClienteDAO.loadClientesData();
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public void getCountOfEachComponente() {
		for(Componente componente : this.componentes) {
			if(componente instanceof DiscoDuro) {
				cantDiscosDuros++;
			} else if(componente instanceof MemoriaRam) {
				cantMemoriasRam++;
			} else if(componente instanceof TarjetaMadre) {
				cantTarjetasMadre++;
			} else {
				cantMicroProcesadores++;
			}
		}

	}
	
	public void addComponente(Componente componente) {
		if(componente instanceof DiscoDuro) {
			cantDiscosDuros++;
		} else if(componente instanceof MemoriaRam) {
			cantMemoriasRam++;
		} else if(componente instanceof TarjetaMadre) {
			cantTarjetasMadre++;
		} else {
			cantMicroProcesadores++;
		}
		componentes.add(componente);
	}
	
	public Componente searchComponente(String codigo) {
		Componente componente = ComponenteDAO.searchComponente(codigo.toUpperCase());
		if(componente == null) return null;
		return componente;
	}

	public void addCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public Cliente searchCliente(String codigo) {
		Cliente cliente = ClienteDAO.searchCliente(codigo.toUpperCase());
		if(cliente == null) return null;
		return cliente;
	}
	
	public void createFactura(Factura factura) {
		FacturaDAO.insertFactura(factura);
		factura.setId(FacturaDAO.getLastId());
	}
	
	public String genCodigoFactura() {
		return Factura.getPrefix()+(FacturaDAO.getLastId() + 1);
	}
	public void LOADdata() {
		    DiscoDuro dd1 = new DiscoDuro("DD001", "SN1234", "Seagate", "Barracuda", 1200.0, 10, "SATA", "1TB");
	        DiscoDuro dd2 = new DiscoDuro("DD002", "SN5678", "Western Digital", "Blue", 1350.0, 3, "SATA", "2TB");
	        
	        // 2 memorias RAM
	        MemoriaRam ram1 = new MemoriaRam("RAM001", "SN1111", "Corsair", "Vengeance", 850.0, 10, "8GB", "3200MHz", "DDR3");
	        MemoriaRam ram2 = new MemoriaRam("RAM002", "SN2222", "Kingston", "Fury", 900.0, 7, "16GB", "3600MHz", "DDR4");
	        
	        // 2 microprocesadores
	        MicroProcesador mp1 = new MicroProcesador("MP001", "SN3333", "Intel", "i5-10400F", 7500.0, 4, "LGA1200", "2.9GHz");
	        MicroProcesador mp2 = new MicroProcesador("MP002", "SN4444", "AMD", "Ryzen 5 5600", 8200.0, 5, "AM4", "3.5GHz");
	        
	        // 2 tarjetas madre
	        TarjetaMadre tm1 = new TarjetaMadre("TM001", "SN5555", "Asus", "Prime B460", 5600.0, 3, "LGA1200", "DDR4", "SATA/NVMe");
	        TarjetaMadre tm2 = new TarjetaMadre("TM002", "SN6666", "Gigabyte", "B550 AORUS", 6400.0, 2, "AM4", "DDR4", "SATA/NVMe");

	        // Agregamos todos los objetos a la lista
	        componentes.add(dd1);
	        componentes.add(dd2);
	        componentes.add(ram1);
	        componentes.add(ram2);
	        componentes.add(mp1);
	        componentes.add(mp2);
	        componentes.add(tm1);
	        componentes.add(tm2);
	        
	        
	     // Creamos 6 clientes
	        Cliente c1 = new Cliente("C001", "Juan Perez", "809-123-4567", "Santo Domingo");
	        Cliente c2 = new Cliente("C002", "María Gomez", "809-234-5678", "Santiago");
	        Cliente c3 = new Cliente("C003", "Pedro Rodriguez", "829-345-6789", "La Romana");
	        Cliente c4 = new Cliente("C004", "Ana Fernandez", "849-456-7890", "San Cristóbal");
	        Cliente c5 = new Cliente("C005", "Luis Martinez", "809-567-8901", "Puerto Plata");
	        Cliente c6 = new Cliente("C006", "Carla Lopez", "849-678-9012", "Higüey");

	        // Agregar clientes al ArrayList
	        clientes.add(c1);
	        clientes.add(c2);
	        clientes.add(c3);
	        clientes.add(c4);
	        clientes.add(c5);
	        clientes.add(c6);
	        
	}
	
	

}
