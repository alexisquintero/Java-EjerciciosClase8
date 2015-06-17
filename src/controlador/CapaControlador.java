package controlador;

import datos.*;
import entidades.*;
import java.util.ArrayList;

public class CapaControlador {
	
	CapaDatos cd = new CapaDatos();
	
	public String CreaModificaPersona(Persona p){	
			
		return cd.CreaModificaPersona(p);
	}
	
	public Persona BuscaPersona(int dni){
		
		return cd.BuscaPersona(dni);
		
	}
	
	public String BajaPersona(int dni){
		
		return cd.BajaPersona(dni);
		
	}
	
	public ArrayList<Persona> Listado(){
		
		return cd.Listado();
		
	}
	
}
