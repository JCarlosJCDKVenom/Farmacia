package capaaccesodatos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import capaaccesodatos.conexion.ConectarDB;
import capanegocios.Item;
import capanegocios.Medicina;
import capanegocios.Mercancia;

public class CrudItem {
	
	
	public List<Item> findAllLike(String valor){
		try {
			List<Item> listItems = new ArrayList<>();
			PreparedStatement ps = ConectarDB.getConnection().prepareStatement("SELECT * FROM item WHERE nombre LIKE '"+valor+"%'");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Item p = new Item();
				p.setNombre(rs.getString("nombre"));
				p.setLote(rs.getString("lote"));
				p.setVencimiento(rs.getDate("vencimiento"));
				p.setDisponible(rs.getInt("disponible"));
				listItems.add(p);
			}
			ps.close();
			rs.close();
			return listItems;
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Item> findAllLikeByDate(String valor){
		try {
			List<Item> listItems = new ArrayList<>();
			PreparedStatement ps = ConectarDB.getConnection().prepareStatement(
			"SELECT * FROM mercancia WHERE nombre LIKE '"+valor+"%'  AND disponible > 0 order by `mercancia`.`id` ASC");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Item p = new Item();
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setLote(rs.getString("lote"));
				p.setVencimiento(rs.getDate("vencimiento"));
				p.setPrecio(rs.getDouble("precio"));
				p.setDisponible(rs.getInt("disponible"));
				listItems.add(p);
			}
			ps.close();
			rs.close();
			return listItems;
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Item> listarMercanciaVencida(){
		try {
			List<Item> listItems = new ArrayList<>();
			PreparedStatement ps = ConectarDB.getConnection().prepareStatement(
			"SELECT * FROM item WHERE disponible > 0 order by `mercancia`.`id` ASC");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Item p = new Item();
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setLote(rs.getString("lote"));
				p.setVencimiento(rs.getDate("vencimiento"));
				p.setPrecio(rs.getDouble("precio"));
				p.setDisponible(rs.getInt("disponible"));
				listItems.add(p);
			}
			ps.close();
			rs.close();
			return listItems;
		} catch (Exception e) {
			return null;
		}
	}
	
	public boolean create(Mercancia itmercancia1){
		try {
			PreparedStatement ps = ConectarDB.getConnection().prepareStatement(
"insert into mercancia (nombre, presentacion, proveedor, cantidad, disponible, costo, precio, lote, vencimiento) values (?, ?, ?, ?, ?, ?, ?, ?, ?) ;");
			ps.setString(1, itmercancia1.getNombre());
			ps.setString(2, itmercancia1.getPresentacion());
			ps.setString(3, itmercancia1.getProveedor());
			ps.setInt   (4, itmercancia1.getCantidad());
			ps.setInt   (5, itmercancia1.getDisponible());
			ps.setDouble(6, itmercancia1.getCosto());
			ps.setDouble(7, itmercancia1.getPrecio());
			ps.setString(8, itmercancia1.getLote());
			//java.util.Date() date2 = java.util.Date();
			ps.setDate  (9,  (Date) itmercancia1.getVencimiento());
			
			return ps.executeUpdate() > 0;
			
		} catch (Exception e) {
			System.out.println(e);
			return false;
			
		}
	}
	
	public boolean editDisponible(Mercancia im){
		try {
			PreparedStatement ps = ConectarDB.getConnection().prepareStatement(
			"update mercancia set disponible=? where id=? order by `mercancia`.`id` ASC");
			ps.setInt (2, im.getId());
			ps.setInt (1, im.getDisponible());
			
			
			if(ps.executeUpdate() > 0) {
				ps.close();
				return true;
			}else return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Mercancia findItem(int id){
		try {
			Mercancia p = new Mercancia();
			PreparedStatement ps = ConectarDB.getConnection().prepareStatement("select * from mercancia where id=? order by `mercancia`.`id` ASC");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {				
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setLote(rs.getString("lote"));
				p.setVencimiento(rs.getDate("vencimiento"));
				p.setDisponible(rs.getInt("disponible"));
			}
			ps.close();
			rs.close();
			return p;
		} catch (Exception e) {
			return null;
		}
	}
}