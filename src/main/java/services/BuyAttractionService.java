package services;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import model.Atraccion;
import model.Itinerario;
import model.Ofertable;
import model.Usuario;
import persistence.AtraccionDAO;
import persistence.ItinerarioDAO;
import persistence.UsuarioDAO;

public class BuyAttractionService {

	AtraccionDAO attractionDAO = new AtraccionDAO();
	UsuarioDAO userDAO = new UsuarioDAO();

	public Map<String, String> buy(int userId, int attractionId) throws SQLException {
		Map<String, String> errors = new HashMap<String, String>();

		Usuario user = userDAO.find(userId);
		Map<Ofertable, String> compradas = user.getCompradas();
		Atraccion attraction = attractionDAO.find(attractionId);

		if (!attraction.hayCupo(1)) {
			errors.put("attraction", "No hay cupo disponible");
		}
		if (!user.canAfford(attraction)) {
			errors.put("user", "No tienes dinero suficiente");
		}
		if (!user.canAttend(attraction)) {
			errors.put("user", "No tienes tiempo suficiente");
		}

		if (errors.isEmpty()) {
			compradas.putIfAbsent(attraction, "0");
			user.setCompradas(compradas);
			user.addToItinerary(attraction);
			attraction.actualizarCupo(1);
			ItinerarioDAO itinerarioDAO = new ItinerarioDAO();
			Itinerario itinerario = new Itinerario(user.getIdUsuario(), 0, attraction.getIdAtraccion());
			attractionDAO.update(attraction);
			userDAO.update(user);
			itinerarioDAO.insert(itinerario);
		}

		return errors;

	}

}
