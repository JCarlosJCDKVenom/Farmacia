package capanegocios;

public class Medicina {
	
	private int id;
	private String nomMed;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomMed() {
		return nomMed;
	}
	public void setNomMed(String nomMed) {
		this.nomMed = nomMed;
	}
	
	public Medicina(int id, String nomMed) {
		super();
		this.id = id;
		this.nomMed = nomMed;
	}
	public Medicina() {
		super();
	}
}
