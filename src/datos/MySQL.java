package datos;

import java.sql.*;



public class MySQL {
	

	
	
	private static MySQL instance = null;

	public static MySQL getInstance() {
		if(instance == null) {
			
			instance = new MySQL();
			
			}
		
		return instance;
		
	}
	 
	 public Connection Connect() throws SQLException{
		 
		 String url = "jdbc:mysql://localhost:3306/Java";
		 String user = "Java";
		 String password = "Java";
		 
		 return DriverManager.getConnection(url, user, password);
		 
		 
	 }

	 
	 protected void Close(ResultSet resultSet, Statement statement, Connection connect){
		    try {
		      if (resultSet != null) {
		        resultSet.close();
		      }

		      if (statement != null) {
		        statement.close();
		      }

		      if (connect != null) {
		        connect.close();
		      }
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
		  }
	 


}
