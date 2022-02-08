package model;

public class Itinerario {
	private int idUsuario;
	private int idPromocion;
	private int idAtraccion;

	public Itinerario(int idUsuario, int idPromocion, int idAtraccion) {
		super();
		this.idUsuario = idUsuario;
		this.idPromocion = idPromocion;
		this.idAtraccion = idAtraccion;
	}

	public Itinerario(int idUsuario, int idPromo) {
		super();
		this.idPromocion = idPromo;
		this.idUsuario = idUsuario;
	}

	public Itinerario(Integer idUsuario, int idAtraccion) {
		super();
		this.idUsuario = idUsuario;
		this.idAtraccion = idAtraccion;
	}

	public Itinerario(int id, Object object, Object object2) {
		// TODO Auto-generated constructor stub
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public int getIdPromocion() {
		return idPromocion;
	}

	public int getIdAtraccion() {
		return idAtraccion;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setIdPromocion(int idPromocion) {
		this.idPromocion = idPromocion;
	}

	public void setIdAtraccion(int idAtraccion) {
		this.idAtraccion = idAtraccion;
	}

	@Override
	public String toString() {
		return "Itinerario [idUsuario=" + idUsuario + ", idPromocion=" + getIdPromocion() + ", idAtraccion="
				+ idAtraccion + "]";
	}

	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

}