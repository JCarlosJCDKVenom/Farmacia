package capaaccesodatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import capaaccesodatos.conexion.ConectarDB;
import capanegocios.Medicina;

public class CrudUsuario {
	public boolean usuarioExiste(String nombre, String clave){
		try {
			PreparedStatement ps = ConectarDB.getConnection().prepareStatement("SELECT * FROM usuario WHERE nombreUser = '"+nombre+"'"+ " AND passwordUser = '"+clave+"'");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return true;
			}
			ps.close();
			rs.close();
			return false;
		} catch (Exception e) {
			return false;
		}
	}
}
