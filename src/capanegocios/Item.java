package capanegocios;

import java.util.Date;

public class Item {
	private int id;
	private String nombre;
	private String presentacion;
	private String laboratorio;
	private int cantidad;
	private int disponible;
	private Double costo;
	private Double precio;
	private String lote;
	private Date vencimiento;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPresentacion() {
		return presentacion;
	}
	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}
	public String getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getDisponible() {
		return disponible;
	}
	public void setDisponible(int disponible) {
		this.disponible = disponible;
	}
	public Double getCosto() {
		return costo;
	}
	public void setCosto(Double costo) {
		this.costo = costo;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public Date getVencimiento() {
		return vencimiento;
	}
	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}
	
	public Item(int id, String nombre, String presentacion, String laboratorio, int cantidad, int disponible,
			Double costo, Double precio, String lote, Date vencimiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.presentacion = presentacion;
		this.laboratorio = laboratorio;
		this.cantidad = cantidad;
		this.disponible = disponible;
		this.costo = costo;
		this.precio = precio;
		this.lote = lote;
		this.vencimiento = vencimiento;
	}
	public Item() {
		super();
	}
	

}