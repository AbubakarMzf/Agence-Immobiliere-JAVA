package bdd;
import org.postgresql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;


public class TestBdd {
	
	private final String url = "jdbc:postgresql://localhost/postgres"; 
	private final String user = "postgres"; 
	private final String pass = "azerty"; 

	
	public void connect() {
		try (Connection connection = DriverManager.getConnection(url, user, pass);){
			if(connection !=null) {
				System.out.println("Connection java psql réussis ! \n");
				Statement stmt = connection.createStatement();
				int update = stmt.executeUpdate("INSERT INTO client VALUES (default,'ching chong','Yunfey')");
				ResultSet rs = stmt.executeQuery("SELECT * FROM client"); 
				while (rs.next()) {
					  int i = rs.getInt("id_client");
					  String str = rs.getString("l_name"); 
					  String str2 = rs.getString("f_name");
					  System.out.println(i + " " + str + " " + " " + str2 + "\n");
				}
				connection.close();
			}
			
			else {
				System.out.println("connexion raté");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		TestBdd sqlConnect = new TestBdd(); 
		sqlConnect.connect();
		
	}
	
	

}
