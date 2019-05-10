package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;

public class ConnectDB 
{
	
	public ConnectDB() {
		super();
	}
	public ConnectDB(Connection conn) {
		super();
		this.conn = conn;
	}
	private Connection conn;
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public Connection Connect(String username,String pass) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String dbName="web";
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		    try {
		    	conn =
						   DriverManager.getConnection("jdbc:mysql://localhost:3306/web?autoReconnect=true&useSSL=false", "root", "Hunghung324");
		    	//conn =
				   //DriverManager.getConnection("jdbc:mysql://den1.mysql1.gear.host/webthionline?autoReconnect=true&useSSL=false", "webthionline", "Rs4n7QO!115~");
			} catch (SQLException ex) {
			    System.out.println("SQLException: " + ex.getMessage());
			    System.out.println("SQLState: " + ex.getSQLState());
			    System.out.println("VendorError: " + ex.getErrorCode());
			}
			return conn;


	}
}
