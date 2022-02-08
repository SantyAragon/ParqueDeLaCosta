package controller.itinerario;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Ofertable;
import services.ItinerarioService;

@WebServlet("/itinerario.do")
public class ListItinerariosServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -8346640902238722429L;
	private ItinerarioService itinerarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.itinerarioService = new ItinerarioService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		List<Ofertable> compradas;
		try {
			compradas = itinerarioService.list(id);
			req.setAttribute("compradas", compradas);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/itinerario.jsp");
			dispatcher.forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
