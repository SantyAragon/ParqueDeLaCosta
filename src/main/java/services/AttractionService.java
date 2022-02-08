package services;

import java.sql.SQLException;
import java.util.List;

import model.Atraccion;
import persistence.AtraccionDAO;

public class AttractionService {

	public List<Atraccion> list() throws SQLException {
		AtraccionDAO atraccionDAO = new AtraccionDAO();
		return atraccionDAO.findAll();
	}

	public Atraccion create(String name, double cost, double duration, int capacity, int tipo)
			throws SQLException {

		Atraccion attraction = new Atraccion(name, cost, duration, capacity, tipo);

		if (attraction.isValid()) {
			AtraccionDAO attractionDAO = new AtraccionDAO();
			attractionDAO.insert(attraction);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return attraction;
	}

	public Atraccion update(int id, String name, double cost, double duration, int capacity, int tipo, String descripcion) {
		AtraccionDAO atraccionDAO = new AtraccionDAO();
		Atraccion attraction = atraccionDAO.find(id);

		attraction.setNombre(name);
		attraction.setCosto(cost);
		attraction.setTiempo(duration);
		attraction.setCupo(capacity);
		attraction.setTipo(tipo);
		attraction.setDescripcion(descripcion);

		if (attraction.isValid()) {
			atraccionDAO.update(attraction);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return attraction;
	}

	public void delete(int id) {
		AtraccionDAO atraccionDAO = new AtraccionDAO();
		Atraccion attraction = new Atraccion(id, null, null, null, null);

		atraccionDAO.delete(attraction);
	}

	public Atraccion find(int id) {
		AtraccionDAO atraccionDAO = new AtraccionDAO();
		return atraccionDAO.find(id);
	}

	public void habilite(int id) {
		AtraccionDAO atraccionDAO = new AtraccionDAO();
		Atraccion attraction = new Atraccion(id, null, null, null, null);

		atraccionDAO.habilite(attraction);
	}

}
