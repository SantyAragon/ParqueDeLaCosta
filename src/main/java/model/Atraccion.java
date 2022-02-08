package model;

import java.util.HashMap;
import java.util.Map;

public class Atraccion extends Ofertable {
	private int id;
	private String nombre;
	private double costo;
	private double tiempo;
	protected int cupo;
	protected int tipo;
	protected boolean estado;
	protected String imagen;
	protected String descripcion;
	private Map<String, String> errors;

	public Atraccion(int id, Object object, Object object2, Object object3, Object object4) {
		this.id = id;

	}

	public Atraccion(int idAtraccion, String nombre, double costo, double tiempo, int cupo, int tipo) {
		this.id = idAtraccion;
		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.tipo = tipo;
	}

	public Atraccion(String nombre, double costo, double tiempo, int cupo, int tipo) {

		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.tipo = tipo;
	}

	public Atraccion(int idAtraccion, String nombre, double costo, double tiempo, int cupo, int tipo, boolean estado) {
		this.id = idAtraccion;
		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.tipo = tipo;
		this.estado = estado;
	}

	public Atraccion(int idAtraccion, String nombre, double costo, double tiempo, int cupo, int tipo, boolean estado,
			String imagen) {
		this.id = idAtraccion;
		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.tipo = tipo;
		this.estado = estado;
		this.imagen = imagen;
	}

	public Atraccion(int idAtraccion, String nombre, double costo, double tiempo, int cupo, int tipo, boolean estado,
			String imagen, String descripcion) {
		this.id = idAtraccion;
		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.tipo = tipo;
		this.estado = estado;
		this.imagen = imagen;
		this.descripcion = descripcion;
	}

	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public void validate() {
		errors = new HashMap<String, String>();
		if (costo <= 0) {
			errors.put("costo", "Debe ser positivo");
		}
		if (tiempo <= 0) {
			errors.put("duracion", "Debe ser positivo");
		}
		if (cupo <= 0) {
			errors.put("cupo", "Debe ser positivo");
		}
		if (tipo == 0) {
			errors.put("tipo", "No puede ser 0");
		}
//		if(nombre == ?) {
//			errors.put("nombre", "Ya existe una atraccion con este nombre")
//			}
	}

	@Override
	public String toString() {
		return this.nombre + ", Duracion: " + this.tiempo + "hs, Cupo maximo: " + this.cupo + ", Tipo: " + this.tipo
				+ ", Costo Original: $" + this.costo + ".\n";
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setId(int id) {
		if (this.id == 0) {
			this.id = id;
		}
	}

	public int getCupo() {
		return this.cupo;
	}

	public double getTiempo() {
		return this.tiempo;
	}

	public double getCosto() {
		return this.costo;
	}

	@Override
	public int getTipoAtraccion() {

		return this.tipo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	@Override
	public void actualizarCupo() {
		this.cupo -= 1;
	}

	public void actualizarCupo(int i) {
		this.cupo -= i;
	}

	@Override
	public boolean hayCupo() {
		return this.cupo > 0;
	}

	public boolean hayCupo(int i) {
		return cupo >= i;
	}

	@Override
	public int getIdPromo() {

		return 0;
	}

	@Override
	public int getIdAtraccion() {

		return id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	@Override
	public double calcularCosto(double datoExtra) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean canHost(int i) {
		return cupo >= i;
	}

	public void host(int i) {
		this.cupo -= i;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;

	}

	public boolean estaDeshabilitado() {
		return estado;
	}

}