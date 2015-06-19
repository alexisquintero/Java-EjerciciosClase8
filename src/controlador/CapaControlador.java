package controlador;

import datos.*;

import entidades.*;
import java.util.ArrayList;

public class CapaControlador {
	
	CapaDatosPersona cda = new CapaDatosPersona();
	
	public String CreaModificaPersona(Persona p){	
			
		return cda.CreaModificaPersona(p);
	}
	
	public Persona BuscaPersona(int dni){
		
		return cda.BuscaPersona(dni);
		
	}
	
	public String BajaPersona(int dni){
		
		return cda.BorrarPersona(dni);
		
	}
	
	public ArrayList<Persona> Listado(){
		
		return cda.Listado();
		
	}
	
}
