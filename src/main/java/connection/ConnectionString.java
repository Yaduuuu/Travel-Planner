package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionString {
	/*
	 * static Connection con=null; //single connection object for whole application
	 * since we used static static{ try{ //we can use provider object properties
	 * because we statically imported Provider object
	 * 
	 * Class.forName("com.mysql.cj.jdbc.Driver");
	 * 
	 * //con=DriverManager.getConnection(CONNECTION_URL,USERNAME,PASSWORD);
	 * con=DriverManager.getConnection(
	 * "jdbc:mysql://localhost:3306/travelplanner?user=root&password=Y@du0404");
	 * 
	 * }catch(Exception e){ e.printStackTrace(); } }
	 */
	//returns already existing connection object
	public static Connection getCon(){
		
		Connection connection = null;

		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		    e.printStackTrace();
		}
		String jdbcURL = "jdbc:mysql://localhost:3306/travelplanner";
		String username = "root";
		String password = "Y@du0404";

		try {
		     connection = DriverManager.getConnection(jdbcURL, username, password);
		    // Proceed with operations on the connection
		    // ...
		   // connection.close(); // Close the connection when done
		} catch (SQLException e) {
		    e.printStackTrace();
		    // Handle SQL exception - Connection error
		}

		
		return connection;
	}
}
