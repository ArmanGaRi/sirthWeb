package mx.com.sirth.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

@ViewScoped
@ManagedBean (name="baseBean")
public class BaseBean {

	private String nombre = "armando";
	
	
	
	
	
	/////////////////////////////////////////
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
	
}
