package capaaccesodatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import capaaccesodatos.conexion.ConectarDB;
import capanegocios.Laboratorio;
import capanegocios.Presentacion;

public class CrudPresentacion {
	public List<Presentacion> findAllLike(String valor){
		try {
			List<Presentacion> listLabs = new ArrayList<>();
			PreparedStatement ps = ConectarDB.getConnection().prepareStatement("SELECT * FROM presentacion WHERE nomPresent LIKE '"+valor+"%'");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Presentacion p = new Presentacion();
				p.setId(rs.getInt("id"));
				p.setPresentacion(rs.getString("nomPresent"));
				listLabs.add(p);
			}
			ps.close();
			rs.close();
			return listLabs;
		} catch (Exception e) {
			return null;
		}
	}
}
