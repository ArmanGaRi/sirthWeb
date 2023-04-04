package mx.com.sirth.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mx.com.sirth.Entidad.Usuario;

public class ConnectionDAO {
	
	public static Connection conexion;
	public String url="jdbc:mysql://127.0.0.1/sirth";
	public String usr = "root";
	public String psw = "";
	
		public Connection Conectar() throws ClassNotFoundException {
			try {
				 Class.forName("com.mysql.cj.jdbc.Driver");
				 conexion = DriverManager.getConnection(url,usr,psw);
				 if(conexion == null) {
					 System.out.println("No se conecto a la base de datos");
				 }else {
					 System.out.println("Conectado a la base");
				 }
			} catch (SQLException e) {
				System.out.println("Ocurrio un error de tipo: "+e.getMessage());
			}
			return conexion;
		}
		

		public ArrayList<Usuario> getUsuarios() throws Exception {
			ArrayList<Usuario> lista = new ArrayList<Usuario>();
			Usuario usuario = null;
			ConnectionDAO conn = new ConnectionDAO();
					ResultSet resultSet = null;
					PreparedStatement prepareStatement = null;
			        conexion = conn.Conectar();
			        try {
			            prepareStatement = conexion.prepareCall("SELECT * FROM USUARIOS ;");
			            resultSet = prepareStatement.executeQuery();
			            while(resultSet.next()){
			            	usuario = new Usuario();
			            	usuario.setIdUsuario(resultSet.getString("ID_USUARIO"));
			            	usuario.setNombre(resultSet.getString("NOMBRE_USUARIO"));
			            	usuario.setApePat(resultSet.getString("APELLIDO_PAT"));
			            	usuario.setApeMat(resultSet.getString("APELLIDO_MAT"));
			            	usuario.setTelefono(resultSet.getString("TELEFONO"));
			            	lista.add(usuario);
			            }
			            
			            if(lista.size()== 0) {
			            	System.out.println("No se encontraron registros");
			            }else {
			            	return lista;
			            }
			        } catch (SQLException e) {
			           throw new Exception(e.getMessage());
			           
			        }finally{
			            try {
			                if(prepareStatement != null){
			                    prepareStatement.close();
			                }
			                if(resultSet != null){
			                    resultSet.close();
			                }
			                if(conexion != null){
			                    conexion.close();
			                }
			            } catch (SQLException e) {
			                throw new Exception(e.getMessage());
			            }
			        } 
			
			return lista;
			
		}
}
