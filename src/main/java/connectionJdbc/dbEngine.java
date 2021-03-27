package connectionJdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbEngine {

	private static String ip = "127.0.0.1";
	private static String bd = "posjava";
	private static String url = "jdbc:postgresql://" +ip+ "/" +bd;
	private static String user = "postgres";
	private static String password = "123";
	private static Connection connection = null;
	
	static {
		conectar();
	}

	public dbEngine() {
		conectar();
	}
	
	private static void conectar() {
		try{	
			if(connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(url, user, password);
				//desativa o commit automatico
				connection.setAutoCommit(false); 
				
				System.out.println("Conectado com Sucesso!");
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
}
