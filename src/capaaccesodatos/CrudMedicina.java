package capaaccesodatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import capaaccesodatos.conexion.ConectarDB;
import capanegocios.Medicina;


public class CrudMedicina {
	public List<Medicina> findAll(){
		try {
			List<Medicina> listMedicinas = new ArrayList<>();
			PreparedStatement ps = ConectarDB.getConnection().prepareStatement("select * from medicina");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Medicina p = new Medicina();
				p.setId(rs.getInt("id"));
				p.setNomMed(rs.getString("medicina"));
				listMedicinas.add(p);
			}
			ps.close();
			rs.close();
			return listMedicinas;
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Medicina> findAllLike(String valor){
		try {
			List<Medicina> listMedicinas = new ArrayList<>();
			PreparedStatement ps = ConectarDB.getConnection().prepareStatement("SELECT * FROM mercanciacategoria WHERE nombreMed LIKE '"+valor+"%'");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Medicina p = new Medicina();
				p.setId(rs.getInt("id"));
				p.setNomMed(rs.getString("nombreMed"));
				listMedicinas.add(p);
			}
			ps.close();
			rs.close();
			return listMedicinas;
		} catch (Exception e) {
			return null;
		}
	}
	
	public Medicina find(int id){
		try {
			Medicina p = new Medicina();
			PreparedStatement ps = ConectarDB.getConnection().prepareStatement("select * from medicina where idProducto=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {				
				p.setId(rs.getInt("idProducto"));
				p.setNomMed(rs.getString("nombreProducto"));
			
			}
			ps.close();
			rs.close();
			return p;
		} catch (Exception e) {
			return null;
		}
	}
	
	public boolean create(Medicina p){
		try {
			PreparedStatement ps = ConectarDB.getConnection().prepareStatement(
			"insert into medicina (idProducto, nombreProducto, unidadesPorPaqueteNormal, descProducto) values (NULL, ?, ?, ?)");
			ps.setString (1, p.getNomMed());

			ps.close();
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean edit(Medicina p){
		try {
			PreparedStatement ps = ConectarDB.getConnection().prepareStatement(
			"update medicina set nombreProducto=?, unidadesPorPaqueteNormal=?, descProducto=? where idProducto=?");
			ps.setString (1, p.getNomMed());

			ps.close();
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean delete(Medicina p){
		try {
			PreparedStatement ps = ConectarDB.getConnection().prepareStatement(
			"delete from medicina where idProducto=?");

			ps.setInt    (1, p.getId());
			
			ps.close();
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			return false;
		}
	}
}