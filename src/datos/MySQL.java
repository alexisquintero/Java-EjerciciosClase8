package datos;

import java.sql.*;
import java.util.ArrayList;

import entidades.*;


public class MySQL {
	
	  private Connection myConn = null;
	  private Statement stm = null;
	  private PreparedStatement pstm = null;
	  private ResultSet rsl = null;
	
	
	private static MySQL instance = null;

	public static MySQL getInstance() {
		if(instance == null) {
			
			instance = new MySQL();
			
			}
		
		return instance;
		
	}
	 
	 public void Connect() throws SQLException{
		 
		 String url = "jdbc:mysql://localhost:3306/javapersonaabm";
		 String user = "Java";
		 String password = "Java";
		 
		 myConn = DriverManager.getConnection(url, user, password);
		 
		 
	 }
	 
	 public void AgregaPersona(Persona p){
		 try{
			 Connect();
			 
			 pstm = myConn.prepareStatement("INSERT INTO persona(nombre, apellido, email, dni) VALUES (?,?,?,?)");
		 
			 pstm.setString(1, p.getsNombre());
			 pstm.setString(2, p.getsApellido());
			 pstm.setString(3, p.getsEmail());
			 pstm.setInt(4, p.getiDni());
		 
			 pstm.executeUpdate();
		 
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
		 finally{
			 Close(rsl, stm, myConn);
		 }

		 
	 }
	 
	 public void ModificaPersona(Persona p){
		 try {
			Connect();
			
			pstm = myConn.prepareStatement("UPDATE persona SET nombre = ?, apellido = ?, email = ? WHERE dni = ?");
			
			pstm.setString(1, p.getsNombre());
			pstm.setString(2, p.getsApellido());
			pstm.setString(3, p.getsEmail());
			pstm.setInt(4, p.getiDni());
			
			pstm.executeUpdate();                      
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			Close(rsl, stm, myConn);
		}
	 }
	 
	 public Persona BuscaPersona(int dni){
		 try{
			 Connect();
		 
			 stm = myConn.createStatement();
			 Persona p = new Persona();
			 
			 String query = "SELECT * FROM persona WHERE ( dni = " + dni + ")"; 
			 rsl = stm.executeQuery(query);
			 while(rsl.next()){
				 p.setsApellido(rsl.getString("apellido"));
				 p.setsNombre(rsl.getString("nombre"));
				 p.setsEmail(rsl.getString("email"));
				 p.setiDni(rsl.getInt("dni"));
			 }
			 return p;
		 	 
		 } catch(Exception e){
			 e.printStackTrace();
			 return null;
		 } finally{
			 Close(rsl, stm, myConn);
		 }
		 
	 }
	 

	public String BorrarPersona(int dni){
		
		String resp;
		
		 try{ 
			 Connect();
		 
			 resp = "La persona con el DNI " + String.valueOf(dni) + " no existe.";	
			
			 pstm = myConn.prepareStatement("DELETE FROM persona WHERE dni = ?");
			
			 pstm.setInt(1, dni);

			 int updatedRows = pstm.executeUpdate();
			 if (updatedRows > 0) {
				 resp = "Persona borrada.";
				
			}

		}catch(SQLException e){
			e.printStackTrace();
			resp = String.valueOf(e.getErrorCode());
		}finally{
			Close(rsl, stm, myConn);
		}
		return resp;	
	 }
	 
	 public ArrayList<Persona> Listado(){
		 
		 ArrayList<Persona> lista = new ArrayList<Persona>();
		 
		try{	 
			 Connect();
			 Statement stm = myConn.createStatement();			 
		 
			 String query = "SELECT * FROM persona";
			 ResultSet rsl = stm.executeQuery(query);
			 while (rsl.next()) {
				 
				 Persona per = new Persona();
				 per.setiDni(rsl.getInt("dni"));
				 per.setsApellido(rsl.getString("apellido"));
				 per.setsEmail(rsl.getString("email"));
				 per.setsNombre(rsl.getString("nombre"));
				 lista.add(per);			 
				
			}
		 }catch(SQLException e){
			 e.printStackTrace();
		 }finally{
			 Close(rsl, stm, myConn);
		 }
		 
		 return lista;
		 
	 }
	 
	 private void Close(ResultSet resultSet, Statement statement, Connection connect){
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
