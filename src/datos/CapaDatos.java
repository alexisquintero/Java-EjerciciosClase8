package datos;

import java.util.ArrayList;

import entidades.*;

public class CapaDatos {
	
	MySQL db = MySQL.getInstance();
	
	public String CreaModificaPersona(Persona p){
		
		Persona personaBusqueda = this.BuscaPersona(p.getiDni());
		String resp = "Valor inicial";
		
		if (personaBusqueda.getsApellido() == null) {
			
			db.AgregaPersona(p);
			resp = p.getsNombre() + " " + p.getsApellido() + " agregado.";
			
			}else {
				
				resp = personaBusqueda.getsNombre() + " " + personaBusqueda.getsApellido() + " modificado a ";
				db.ModificaPersona(p);
				resp = resp + p.getsNombre() + " " + p.getsApellido();
				
			}
		
		return resp;
		
		}
		
	
	
	public Persona BuscaPersona(int dni){
		
		return db.BuscaPersona(dni);
		
	}
	
	public String BajaPersona(int dni){
		
		return db.BorrarPersona(dni);
	}
	
	
	public ArrayList<Persona> Listado(){
		
		return db.Listado();
		
	}
	
}
