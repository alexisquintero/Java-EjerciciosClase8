package entidades;

public class Persona {
	
	
//	private int iIdPersona;
	private int iDni;
	private String sNombre;
	private String sApellido;
	private String sEmail;
			
	public int getiDni() {
		return iDni;
	}
	public void setiDni(int iDni) {
		this.iDni = iDni;
	}
	public String getsNombre() {
		return sNombre;
	}
	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}
	public String getsApellido() {
		return sApellido;
	}
	public void setsApellido(String sApellido) {
		this.sApellido = sApellido;
	}
	public String getsEmail() {
		return sEmail;
	}
	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}
/*	public int getiIdPersona() {
		return iIdPersona;
	}
	public void setiIdPersona(int iIdPersona) {
		this.iIdPersona = iIdPersona;
	}
*/
}

