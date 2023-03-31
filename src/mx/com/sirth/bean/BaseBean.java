package mx.com.sirth.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

@ViewScoped
@ManagedBean (name="baseBean")
public class BaseBean {

	private String nombre = "armando";
	private String raul	= "raul";
	
	
	
	
	
	/////////////////////////////////////////
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaul() {
		return raul;
	}

	public void setRaul(String raul) {
		this.raul = raul;
	}	
	
}
