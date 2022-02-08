package model;

import java.util.HashMap;
import java.util.Map;

public class Promocion extends Ofertable {

	protected int tipoPromo;
	protected int tipoAtraccion;
	protected String nombre;
	protected Atraccion[] atraccionesEnPromocion;
	protected double datoExtra;
	protected String atracciones;
	protected double costo;
	protected int id;
	protected int cupo;
	protected double tiempo;
	protected boolean estado;
	protected String imagen;
	protected String descripcion;
	protected String atraccionesEnPromo;
	private Map<String, String> errors;

	public Promocion(String nombrePromocion, int tipoPromo, int tipoAtraccion, double datoExtra,
			Atraccion[] atraccionesEnPromocion) {
		super();
		this.tipoPromo = tipoPromo;
		this.nombre = nombrePromocion;
		this.atraccionesEnPromocion = atraccionesEnPromocion;
		this.tipoAtraccion = tipoAtraccion;
		this.costo = this.calcularCosto(datoExtra);
		this.cupo = this.calcularCupo(atraccionesEnPromocion);
		this.datoExtra = datoExtra;
		this.atraccionesEnPromo = atraccionesEnPromocion.toString();

	}

//No Borrar
	public Promocion(int id, Object object, Object object2, Object object3, Object object4) {
		this.id = id;

	}

	public Promocion(String nombrePromocion) {
		this.nombre = nombrePromocion;
	}

	public Promocion(int idPromo, String nombrePromocion, int tipoPromo, int tipoAtraccion, double datoExtra,
			Atraccion[] atraccionesEnPromocion, boolean estado) {
		super();
		this.tipoPromo = tipoPromo;
		this.id = idPromo;
		this.nombre = nombrePromocion;
		this.atraccionesEnPromocion = atraccionesEnPromocion;
		this.tipoAtraccion = tipoAtraccion;
		this.costo = this.calcularCosto(datoExtra);
		this.cupo = this.calcularCupo(atraccionesEnPromocion);
		this.estado = estado;
		this.datoExtra = datoExtra;
		this.atraccionesEnPromo = atraccionesEnPromocion.toString();
	}

	public Promocion(int idPromo, String nombrePromocion, int tipoPromo, int tipoAtraccion, double datoExtra,
			boolean estado, String imagen, Atraccion[] atraccionesEnPromocion) {
		super();
		this.tipoPromo = tipoPromo;
		this.id = idPromo;
		this.nombre = nombrePromocion;
		this.atraccionesEnPromocion = atraccionesEnPromocion;
		this.tipoAtraccion = tipoAtraccion;
		this.costo = this.calcularCosto(datoExtra);
		this.cupo = this.calcularCupo(atraccionesEnPromocion);
		this.estado = estado;
		this.imagen = imagen;
		this.datoExtra = datoExtra;
		this.atraccionesEnPromo = atraccionesEnPromocion.toString();

	}

	public Promocion(int idPromo, String nombrePromocion, int tipoPromo, int tipoAtraccion, double datoExtra,
			boolean estado, String imagen, String descripcion, Atraccion[] atraccionesEnPromocion) {
		super();
		this.tipoPromo = tipoPromo;
		this.id = idPromo;
		this.nombre = nombrePromocion;
		this.atraccionesEnPromocion = atraccionesEnPromocion;
		this.tipoAtraccion = tipoAtraccion;
		this.costo = this.calcularCosto(datoExtra);
		this.cupo = this.calcularCupo(atraccionesEnPromocion);
		this.estado = estado;
		this.imagen = imagen;
		this.datoExtra = datoExtra;
		this.descripcion = descripcion;
		this.atraccionesEnPromo = this.convertirATexto();

	}

	public double calcularCosto(double datoExtra) {

		switch (tipoPromo) {

		case 1:
			this.costo = datoExtra;
			break;
		case 2:
			this.costo = sumaPrecio(getAtraccionesEnPromocion()) * (1 - datoExtra);
			break;
		case 3:

			this.costo = sumaPrecio(getAtraccionesEnPromocion());

			break;
		}

		return costo;
	}

	public double sumaPrecio(Atraccion[] atraccionesPromo) {
		double precioTotal = 0;

		for (int i = 0; i < atraccionesEnPromocion.length; i++) {
			precioTotal += atraccionesEnPromocion[i].getCosto();
		}
		return precioTotal;
	}

	public double calcularTiempo(Atraccion[] atraccionesEnPromocion) {
		double tiempoTotal = 0;
		for (int i = 0; i < atraccionesEnPromocion.length; i++) {
			tiempoTotal += atraccionesEnPromocion[i].getTiempo();
		}
		return tiempoTotal;
	}

	public double calcularDuracion(Atraccion[] atraccionesEnPromocion) {
		for (int i = 0; i < atraccionesEnPromocion.length; i++) {
			this.tiempo += atraccionesEnPromocion[i].getTiempo();
		}
		return this.tiempo;
	}

	public int calcularCupo(Atraccion[] atraccionesEnPromocion) {
//		int cupo = 0;
		for (int i = 0; i < atraccionesEnPromocion.length; i++) {
			this.cupo += atraccionesEnPromocion[i].getCupo();
		}
		return this.cupo;
	}

	public void actualizarCupo() {
		Atraccion[] atraccionesEnPromocion = this.atraccionesEnPromocion;
		for (int i = 0; i < atraccionesEnPromocion.length; i++) {
			atraccionesEnPromocion[i].actualizarCupo();
		}
	}

	public void imprimirPromociones(Promocion[] promociones) {
		for (int i = 0; i < promociones.length; i++) {
			this.toString();
		}
	}

	@Override
	public double getTiempo() {
		return calcularDuracion(atraccionesEnPromocion);
	}

	public int getTipoAtraccion() {
		return this.tipoAtraccion;
	}

	public int getCupo() {
		return this.cupo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getImagen() {
		return this.imagen;
	}

	public double getCosto() {
		return this.costo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public Atraccion[] getAtraccionesEnPromocion() {
		return this.atraccionesEnPromocion;
	}

	public String convertirATexto() {
		String convertido = "";
		for (int i = 0; i < this.atraccionesEnPromocion.length; i++) {
			int texto = this.atraccionesEnPromocion[i].getIdAtraccion();
			convertido += Integer.toString(texto) +" ";

		}
		return convertido;
	}

	public String getAtraccionesEnPromo() {
		return this.atraccionesEnPromo;
	}

	@Override
	public int getIdPromo() {
		return this.id;
	}

	public double getDatoExtra() {
		return this.datoExtra;
	}

	@Override
	public int getIdAtraccion() {
		return 0;
	}

	public int getTipoPromocion() {
		return this.tipoPromo;
	}

	public void setId(int id) {
		this.id = id;

	}

	public void setTipoPromo(int tipoPromo) {
		this.tipoPromo = tipoPromo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDatoExtra(double datoExtra) {
		this.datoExtra = datoExtra;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public void validate() {
		errors = new HashMap<String, String>();

		if (nombre == null) {
			errors.put("Nombre", "No puede ser nulo");
		}
		if (tipoPromo < 1 || tipoPromo > 3) {
			errors.put("Tipo de promoción", "Debe ser un número entre 1 y 3");
		}
		if (tipoAtraccion <= 0) {
			errors.put("Tipo de Atracción", "Debe ser un número entre 1 y 4");
		}
		if (datoExtra <= 0) {
			errors.put("Tipo de descuento", "No puede ser 0");
		}
		if (atraccionesEnPromocion.length == 0) {
			errors.put("Atracciones en promoción", "No pueden ser 0");
		}

	}

	@Override
	public boolean hayCupo() {
		return false;
	}

	public boolean estaDeshabilitado() {
		return estado;
	}

	public void host(int i) {
		this.cupo -= i;
	}

	public boolean canHost(int x) {
		int i = 0;
		boolean hayCupo = true;
		while (i < this.getAtraccionesEnPromocion().length) {
			if (getAtraccionesEnPromocion()[i].canHost(x))
				i++;
			else {
				hayCupo = false;
				break;
			}
		}
		return hayCupo;
	}

	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}

	public boolean esPromocion() {
		return this instanceof Promocion;

	}

	@Override
	public String toString() {
		return "Promocion [id=" + id + ", nombre=" + nombre + ", tipoPromo=" + tipoPromo + ", tipoAtraccion="
				+ tipoAtraccion + ", datoExtra=" + datoExtra + ", atraccionesEnPromo=" + atraccionesEnPromo + ", costo="
				+ costo + ", cupo=" + cupo + ", tiempo=" + tiempo + ", descripcion=" + descripcion + ", estado="
				+ estado + ", imagen=" + imagen + ", errors=" + errors + "]";
	}

}