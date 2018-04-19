package capanegocios;

import java.util.Date;

public class Usuario {
	private int idUser;
	private String nombreUser;
	private String passwordUser;
	private int activoUser;
	private Date vencimiento;
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getNombreUser() {
		return nombreUser;
	}
	public void setNombreUser(String nombreUser) {
		this.nombreUser = nombreUser;
	}
	public String getPasswordUser() {
		return passwordUser;
	}
	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}
	public int getActivoUser() {
		return activoUser;
	}
	public void setActivoUser(int activoUser) {
		this.activoUser = activoUser;
	}
	public Date getVencimiento() {
		return vencimiento;
	}
	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}
	
}
