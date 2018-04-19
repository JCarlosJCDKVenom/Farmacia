package capaaccesodatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import capaaccesodatos.conexion.ConectarDB;
import capanegocios.Laboratorio;
import capanegocios.Medicina;

public class CrudLab {
	public List<Laboratorio> findAll(){
		try {
			List<Laboratorio> listLabs = new ArrayList<>();
			PreparedStatement ps = ConectarDB.getConnection().prepareStatement("select * from medicina");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Laboratorio p = new Laboratorio();
				p.setId(rs.getInt("id"));
				p.setLaboratorio(rs.getString("laboratorio"));
				listLabs.add(p);
			}
			ps.close();
			rs.close();
			return listLabs;
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Laboratorio> findAllLike(String valor){
		try {
			List<Laboratorio> listLabs = new ArrayList<>();
			PreparedStatement ps = ConectarDB.getConnection().prepareStatement("SELECT * FROM proveedor WHERE nombreProv LIKE '"+valor+"%'");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Laboratorio p = new Laboratorio();
				p.setId(rs.getInt("idProv"));
				p.setLaboratorio(rs.getString("nombreProv"));
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
