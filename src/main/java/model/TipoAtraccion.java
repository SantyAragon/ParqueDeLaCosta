package model;

public class TipoAtraccion {
	private int idTipoAtraccion;
	private String nombreTipoAtraccion;

	public TipoAtraccion(int idTipoAtraccion, String nombreTipoAtraccion) {
		super();
		this.idTipoAtraccion = idTipoAtraccion;
		this.nombreTipoAtraccion = nombreTipoAtraccion;
	}

	public int getIdTipoAtraccion() {
		return idTipoAtraccion;
	}

	public String getNombreTipoAtraccion() {
		return nombreTipoAtraccion;
	}
	

	@Override
	public String toString() {
		return "TipoAtraccion [idTipoAtraccion=" + idTipoAtraccion + ", nombreTipoAtraccion=" + nombreTipoAtraccion
				+ "]";
	}

}
