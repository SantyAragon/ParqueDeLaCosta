package model;

public class TipoPromocion {
	private String tipoPromocion;
	private int idTipoPromo;

	public TipoPromocion(int idTipoPromo, String tipoPromocion) {
		super();
		this.idTipoPromo = idTipoPromo;
		this.tipoPromocion = tipoPromocion;

	}

	public String getTipoPromocion() {
		return tipoPromocion;
	}

	public int getIdTipoPromo() {
		return idTipoPromo;
	}

	@Override
	public String toString() {
		return "TipoPromocion [tipoPromocion=" + tipoPromocion + ", idTipoPromo=" + idTipoPromo + "]";
	}

}
