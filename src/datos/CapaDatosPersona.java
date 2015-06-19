package datos;

import java.sql.*;
import java.util.ArrayList;

import entidades.Persona;

public class CapaDatosPersona {
	
	MySQL sql = MySQL.getInstance();	
	private Connection myConn = null;
	private Statement stm = null;
	private PreparedStatement pstm = null;
	private ResultSet rsl = null;
	
	public String CreaModificaPersona(Persona p){
		
		Persona personaBusqueda = this.BuscaPersona(p.getiDni());
		String resp = "Valor inicial";
		
		if (personaBusqueda.getsApellido() == null) {
			
			int aut_id = -1;
			
			aut_id = AgregaPersona(p);
			resp = p.getsNombre() + " " + p.getsApellido() + " agregado con el ID: " + aut_id + ".";
			
			}else {
				
				resp = personaBusqueda.getsNombre() + " " + personaBusqueda.getsApellido() + " modificado a ";
				ModificaPersona(p);
				resp = resp + p.getsNombre() + " " + p.getsApellido();
				
			}
		
		return resp;
		
	}
	 
	public int AgregaPersona(Persona p){
		
		int aut_id = -2;
		
		 try{
			 myConn = sql.Connect();
			 
			 pstm = myConn.prepareStatement("INSERT INTO persona(nombre, apellido, email, dni) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
		 
			 pstm.setString(1, p.getsNombre());
			 pstm.setString(2, p.getsApellido());
			 pstm.setString(3, p.getsEmail());
			 pstm.setInt(4, p.getiDni());
		 
			 pstm.executeUpdate();
			 rsl = pstm.getGeneratedKeys();
			 if(rsl.next()){
				 aut_id = rsl.getInt(1);
			 }
			 
			 
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
		 finally{
			 sql.Close(rsl, stm, myConn);
		 }

		 return aut_id;
		 
	 }
	 
	 public void ModificaPersona(Persona p){
		 try {
			 myConn = sql.Connect();
			
			pstm = myConn.prepareStatement("UPDATE persona SET nombre = ?, apellido = ?, email = ? WHERE dni = ?");
			
			pstm.setString(1, p.getsNombre());
			pstm.setString(2, p.getsApellido());
			pstm.setString(3, p.getsEmail());
			pstm.setInt(4, p.getiDni());
			
			pstm.executeUpdate();                      
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			sql.Close(rsl, stm, myConn);
		}
	 }
	 
	 public Persona BuscaPersona(int dni){
		 try{
			 myConn = sql.Connect();
		 
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
			 sql.Close(rsl, stm, myConn);
		 }
		 
	 }
	 

	public String BorrarPersona(int dni){
		
		String resp;
		
		 try{ 
			 myConn = sql.Connect();
		 
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
			sql.Close(rsl, stm, myConn);
		}
		return resp;	
	 }
	 
	 public ArrayList<Persona> Listado(){
		 
		 ArrayList<Persona> lista = new ArrayList<Persona>();
		 
		try{	 
			myConn = sql.Connect();
			 Statement stm = myConn.createStatement();			 
		 
			 String query = "SELECT * FROM persona";
			 ResultSet rsl = stm.executeQuery(query);
			 while (rsl.next()) {
				 
				 Persona per = new Persona();
				 per.setiDni(rsl.getInt("dni"));
				 per.setsApellido(rsl.getString("apellido"));
				 per.setsEmail(rsl.getString("email"));
				 per.setsNombre(rsl.getString("nombre"));
				 per.setiIdPersona(rsl.getInt("id_persona"));
				 lista.add(per);			 
				
			}
		 }catch(SQLException e){
			 e.printStackTrace();
		 }finally{
			 sql.Close(rsl, stm, myConn);
		 }
		 
		 return lista;
		 
	 }

}
