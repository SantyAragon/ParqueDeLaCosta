package services;

import java.sql.SQLException;
import model.Atraccion;
import model.Promocion;
import persistence.AtraccionDAO;
import persistence.PromocionDAO;

public class PromocionService {

	public Promocion create(String nombrePromocion, int tipoPromo, int tipoAtraccion, double datoExtra,
			Atraccion[] atraccionesEnPromocion) throws SQLException {

		Promocion promocion = new Promocion(nombrePromocion, tipoPromo, tipoAtraccion, datoExtra,
				atraccionesEnPromocion);
		if (promocion.isValid()) {
			PromocionDAO promocionDAO = new PromocionDAO();
			promocionDAO.insert(promocion);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return promocion;
	}

	public Promocion update(Integer id, String name, Integer tipoPromo, Double datoExtra) {
		PromocionDAO promocionDAO = new PromocionDAO();
		Promocion promocion = promocionDAO.find(id);

		promocion.setNombre(name);
		promocion.setDatoExtra(datoExtra);
		promocion.setTipoPromo(tipoPromo);
		if (promocion.isValid()) {
			promocionDAO.update(promocion);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return promocion;
	}

	public void delete(int id) {
		PromocionDAO promocionDAO = new PromocionDAO();
		Promocion promocion = new Promocion(id, null, null, null, null);

		promocionDAO.delete(promocion);
	}

	public void habilite(int id) {
		PromocionDAO promocionDAO = new PromocionDAO();
		Promocion promocion = new Promocion(id, null, null, null, null);

		promocionDAO.habilite(promocion);
	}

	public Promocion find(int id) {
		PromocionDAO promocionDAO = new PromocionDAO();
		return promocionDAO.find(id);
	}
}
