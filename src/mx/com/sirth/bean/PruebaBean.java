package mx.com.sirth.bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import mx.com.sirth.Entidad.Usuario;

@ViewScoped
@ManagedBean (name="pruebaBean")
public class PruebaBean {
	
	ConnectionDAO dao = new ConnectionDAO();
	
	private ArrayList<Usuario> lista = new ArrayList<Usuario>();
	private String error = null;
	private boolean verErrores = false;
	private boolean verUsuarios = false;
	
	public void consulta() {
		
		try {
			this.lista = dao.getUsuarios();
			if(this.lista.size() == 0) {
				this.error = "no se encontraron datos";
				this.verErrores = true;
			}else {
				this.verUsuarios = true;
			}
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
			e1.printStackTrace();
		}
		
	}
	
	
	
	
	
	public ArrayList<Usuario> getLista() {
		return lista;
	}
	public void setLista(ArrayList<Usuario> lista) {
		this.lista = lista;
	}


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}


	public boolean isVerErrores() {
		return verErrores;
	}


	public void setVerErrores(boolean verErrores) {
		this.verErrores = verErrores;
	}


	public boolean isVerUsuarios() {
		return verUsuarios;
	}


	public void setVerUsuarios(boolean verUsuarios) {
		this.verUsuarios = verUsuarios;
	}
 
}
