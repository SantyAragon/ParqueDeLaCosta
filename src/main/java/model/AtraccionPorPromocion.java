package model;

public class AtraccionPorPromocion {

	int idPromocion;
	int idAtraccion;

	public AtraccionPorPromocion(int idPromocion, int idAtraccion) {
		super();

		this.idPromocion = idPromocion;
		this.idAtraccion = idAtraccion;

	}

	public int getIdPromocion() {
		return idPromocion;
	}

	public int getIdAtraccion() {
		return idAtraccion;
	}

	@Override
	public String toString() {
		return "AtraccionPorPromocion [ idPromocion=" + idPromocion + ", idAtraccion=" + idAtraccion + "]";
	}

}
