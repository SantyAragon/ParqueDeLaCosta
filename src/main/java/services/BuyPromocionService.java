package services;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import model.Atraccion;
import model.Itinerario;
import model.Ofertable;
import model.Promocion;
import model.Usuario;
import persistence.AtraccionDAO;
import persistence.ItinerarioDAO;
import persistence.PromocionDAO;
import persistence.UsuarioDAO;

public class BuyPromocionService {

	PromocionDAO promocionDAO = new PromocionDAO();
	UsuarioDAO userDAO = new UsuarioDAO();

	public Map<String, String> buy(int userId, int idPromo) throws SQLException {
		Map<String, String> errors = new HashMap<String, String>();

		Usuario user = userDAO.find(userId);
		Promocion promocion = promocionDAO.find(idPromo);
		Map<Ofertable, String> compradas = user.getCompradas();

		if (!promocion.canHost(1)) {
			errors.put("attraction", "No hay cupo disponible");
		}
		if (!user.puedeComprar(promocion)) {
			errors.put("user", "No tienes dinero suficiente");
		}
		if (!user.canAttend(promocion)) {
			errors.put("user", "No tienes tiempo suficiente");
		}
		if (promocion.contenidoEn(compradas)) {
			errors.put("compradas", "Esta promocion ya fue comprada");
		}
		if (errors.isEmpty()) {
			user.addToItinerary(promocion);
			promocion.actualizarCupo();

//			compradas.putIfAbsent(promocion, "0");
			for (int l = 0; l < promocion.getAtraccionesEnPromocion().length; l++) {
				compradas.putIfAbsent(promocion.getAtraccionesEnPromocion()[l], "0");

			}

			user.setCompradas(compradas);

			ItinerarioDAO itinerarioDAO = new ItinerarioDAO();
			Itinerario itinerario = new Itinerario(user.getIdUsuario(), promocion.getIdPromo(), 0);
			promocionDAO.updateCupo(promocion);
			userDAO.update(user);
			itinerarioDAO.insert(itinerario);

		}

		return errors;

	}

}
