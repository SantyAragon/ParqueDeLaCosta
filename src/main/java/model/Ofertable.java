package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Ofertable {

	protected double tiempo;
	int tipoDeAtraccion;
	protected double costo;
	protected String nombre;
	int cupo;
	int id;
	Atraccion[] atraccionesEnPromocion;
	protected String descripcion;
	public Object getAtraccionesEnPromocion;

	public Atraccion[] getAtraccionesEnPromocion() {
		return null;
	}

	public double getTiempo() {
		return this.tiempo;
	}

	public double getCosto() {
		return this.costo;
	}

	public abstract int getCupo();

	public String getNombre() {
		return nombre;
	}

	public boolean esPromocion() {
		return this instanceof Promocion;

	}

	public abstract void actualizarCupo();

	public int getTipoAtraccion() {
		return tipoDeAtraccion;
	}

	public abstract boolean hayCupo();

	public abstract double calcularCosto(double datoExtra);

	public boolean contenidoEn(Map<Ofertable, String> compradas) {
		boolean estaContenida = false;
		int i = 0;
		if (this.esPromocion()) {
			while (i < this.getAtraccionesEnPromocion().length && estaContenida == false) {

				estaContenida = compradas.containsKey(this.getAtraccionesEnPromocion()[i]);

				i++;
			}
			return estaContenida;
		} else {
			return compradas.containsKey(this);
		}
	}

	public boolean contenidoEn(List<Atraccion> atraccionComprada) {
		boolean estaContenida = false;
		int i = 0;
		if (this.esPromocion()) {
			while (i < this.getAtraccionesEnPromocion().length && estaContenida == false) {

				estaContenida = atraccionComprada.contains(this.getAtraccionesEnPromocion()[i]);

				i++;
			}
			return estaContenida;
		} else {
			return atraccionComprada.contains(this);
		}
	}

	public abstract int getIdPromo();

	public abstract int getIdAtraccion();

	public boolean canHost(int i) {
		return cupo >= i;
	}

	public void host(int i) {
		this.cupo -= i;
	}

}