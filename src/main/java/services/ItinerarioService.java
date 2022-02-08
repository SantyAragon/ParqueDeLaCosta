package services;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Atraccion;
import model.Itinerario;
import model.Ofertable;
import model.Promocion;
import persistence.AtraccionDAO;
import persistence.ItinerarioDAO;
import persistence.PromocionDAO;

public class ItinerarioService {
	public List<Ofertable> list(int idUsuario) throws SQLException {
		
		List<Ofertable> compradas = new LinkedList<Ofertable>();
		
		ItinerarioDAO itinerarioDAO = new ItinerarioDAO();
		List<Itinerario> itinerarios = itinerarioDAO.findByUser(idUsuario);
		PromocionDAO promocionDAO = new PromocionDAO();
		AtraccionDAO atraccionDAO = new AtraccionDAO();
		List<Atraccion> atracciones = new LinkedList<Atraccion>();
		List<Promocion> promociones = new LinkedList<Promocion>();
		for (Itinerario itinerario : itinerarios) {
			Promocion promocion = promocionDAO.find(itinerario.getIdPromocion());
			Atraccion atraccion = atraccionDAO.find(itinerario.getIdAtraccion());
			promociones.add(promocion);
			atracciones.add(atraccion);
			
		}

		compradas.addAll(promociones);
		compradas.addAll(atracciones);
		return compradas;
	}

//
//	public Itinerario create(int idUsuario, int idPromocion, int idAtraccion) throws SQLException {
//
//		Itinerario itinerario = new Itinerario(idUsuario, idPromocion, idAtraccion);
//		if (itinerario.isValid()) {
//			ItinerarioDAO itinerarioDAO = new ItinerarioDAO();
//			itinerarioDAO.insert(itinerario);
//			// XXX: si no devuelve "1", es que hubo más errores
//		}
//
//		return itinerario;
//	}
//
//	public Itinerario update(int idUsuario, int idPromocion, int idAtraccion) {
//		ItinerarioDAO itinerarioDAO = new ItinerarioDAO();
//		Itinerario itinerario = itinerarioDAO.find(idUsuario);
//
//		itinerario.setIdUsuario(idUsuario);
//		itinerario.setIdPromocion(idPromocion);
//		itinerario.setIdAtraccion(idAtraccion);
//		if (itinerario.isValid()) {
//			try {
//				itinerarioDAO.update(itinerario);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			// XXX: si no devuelve "1", es que hubo más errores
//		}
//
//		return itinerario;
//	}
//
//	public void delete(int id) {
//		ItinerarioDAO itinerarioDAO = new ItinerarioDAO();
//		Itinerario itinerario = new Itinerario(id, null, null);
//
//		itinerarioDAO.delete(itinerario);
//	}
//
//	public Itinerario find(int id) {
//		ItinerarioDAO promocionDAO = new ItinerarioDAO();
//		return promocionDAO.find(id);
//	}
}
