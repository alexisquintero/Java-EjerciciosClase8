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
	 
	 public Connection Connect(){
		 
		 Connection conn = null;
		 
		 try{
			 
			 String url = "jdbc:mysql://localhost:3306/Java";
			 String user = "Java";
			 String password = "Java";
		 
			 conn = DriverManager.getConnection(url, user, password);
			 
		 } catch(SQLException e){
			 e.printStackTrace();	
		 }
		 
		 return conn;
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
