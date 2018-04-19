package capapresentacion;

import java.util.List;



public class FaturaClass {

    //private MaestroFactura maestro;
    private static List<Factura> productos;
    public String ticket1;
    public static List<Factura> getProductos() {
        return productos;
    }

    public void setProductos(List<Factura> productos) {
        this.productos = productos;
    }

	public String getTicket() {
		return ticket1;
	}

	public void setTicket(String ticket) {
		ticket1 = ticket;
	}

   /* public MaestroFactura getMaestro() {
        return maestro;
    }

    public void setMaestro(MaestroFactura maestro) {
        this.maestro = maestro;
    }*/
}