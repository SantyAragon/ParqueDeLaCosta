package model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import utils.Crypt;

public class Usuario {

	private int idUsuario;
	private String nombre;
	private String password;
	private double tiempo;
	private double dinero;
	private int tipo;
	private boolean admin;
	LinkedList<Ofertable> itinerario = new LinkedList<Ofertable>();
	LinkedList<Ofertable> atraccionComprada = new LinkedList<Ofertable>();
	protected Map<Ofertable, String> compradas;

	public LinkedList<Ofertable> getAtraccionComprada() {
		return atraccionComprada;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPassword() {
		return password;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public int getTipo() {
		return tipo;
	}

	public double getTiempo() {
		return tiempo;
	}

	public double getDinero() {
		return dinero;
	}
//
//	public Usuario(int idUsuario, String nombre, int tipo, double dinero, double tiempo) {
//
//		this.idUsuario = idUsuario;
//		this.nombre = nombre;
//
//		this.tiempo = tiempo;
//		this.dinero = dinero;
//		this.tipo = tipo;
//	}

	public Usuario(int idUsuario, String nombre, int tipo, double tiempo, double dinero, boolean admin,
			String password) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.tipo = tipo;
		this.tiempo = tiempo;
		this.dinero = dinero;
		this.admin = admin;
		this.password = password;
		this.compradas = new HashMap<Ofertable, String>();
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", password=" + password + ", tiempo="
				+ tiempo + ", dinero=" + dinero + ", tipo=" + tipo + ", admin=" + admin + "]";
	}

	public void comprar(Ofertable oferta, HashMap<Atraccion, String> atraccionComprada) throws SQLException {
		itinerario.add(oferta);
		this.dinero -= oferta.getCosto();
		this.tiempo -= oferta.getTiempo();
		if (oferta.esPromocion()) {
//			oferta.actualizarCupo(oferta.getAtraccionesEnPromocion());

			for (int l = 0; l < oferta.getAtraccionesEnPromocion().length; l++) {
				atraccionComprada.putIfAbsent(oferta.getAtraccionesEnPromocion()[l], "0");

			}
		} else {
			atraccionComprada.putIfAbsent((Atraccion) oferta, "0");
			oferta.actualizarCupo();
		}

	}

//	public boolean puedeComprar(Ofertable oferta, HashMap<Atraccion, String> atraccionComprada) {
//
//		return this.dinero >= oferta.getCosto() && this.tiempo >= oferta.getTiempo() && oferta.getCupo() > 0
//				&& !oferta.contenidoEn(atraccionComprada);
//	}

	public boolean puedeComprar(Ofertable oferta) {

		return this.dinero >= oferta.getCosto() && this.tiempo >= oferta.getTiempo() && oferta.getCupo() > 0;
//				&& !oferta.contenidoEn(this.compradas);
	}

	public boolean puedeComprar2(Ofertable oferta) {
		return oferta.getCosto() <= this.dinero && oferta.getTiempo() <= this.tiempo;
	}

	public boolean yaCompro(Ofertable oferta) {
		return oferta.contenidoEn(this.compradas);
	}

//	public boolean puedeComprar(Ofertable oferta, List<Atraccion> atraccionComprada) {
//
//		return this.dinero >= oferta.getCosto() && this.tiempo >= oferta.getTiempo() && oferta.getCupo() > 0
//				&& !oferta.contenidoEn(atraccionComprada);
//	}
	public Map<Ofertable, String> getCompradas() {
		return this.compradas;
	}

	public LinkedList<Ofertable> getItinerario() {
		return itinerario;
	}

	public void setCompradas(Map<Ofertable, String> compradas) {
		this.compradas = compradas;
	}

	public boolean canAfford(Ofertable oferta) {
		return oferta.getCosto() <= this.dinero;
	}

	public boolean canAttend(Ofertable oferta) {
		return oferta.getTiempo() <= this.tiempo;
	}

	public Boolean isAdmin() {

		return admin;
	}

	public boolean isNull() {
		return false;
	}

//	public boolean checkPassword(String password) {
////		String hashed = Crypt.hash(this.password);
//		return Crypt.match(password, this.password);
//	}
	public boolean checkPassword(String password) {
		String hashed = Crypt.hash(this.password);
		return Crypt.match(password, hashed);
	}

	public void imprimirItinerario(LinkedList<Ofertable> itinerario, String file) throws IOException {

		file = "salida/" + file;
		PrintWriter salida = new PrintWriter(new FileWriter(file));

		for (Ofertable oferta : itinerario) {
			salida.println(oferta);
		}
		salida.close();

	}

	public void addToItinerary(Ofertable oferta) {
		this.dinero -= oferta.getCosto();
		this.tiempo -= oferta.getTiempo();
		// TODO agregar a su lista
	}

}
