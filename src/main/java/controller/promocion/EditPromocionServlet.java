package controller.promocion;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.Promocion;
import services.AttractionService;
import services.PromocionService;

@WebServlet("/editPromo.do")
public class EditPromocionServlet extends HttpServlet {

	private static final long serialVersionUID = 7598291131560345626L;
	private PromocionService promocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		Promocion promocion = promocionService.find(id);
		req.setAttribute("promocion", promocion);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/editPromo.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer id = Integer.parseInt(req.getParameter("id"));
		// String id = req.getParameter("id");
		String name = req.getParameter("name");
		Integer tipo = Integer.parseInt(req.getParameter("tipoPromo"));
		Double datoExtra = Double.parseDouble(req.getParameter("datoExtra"));
		Promocion promocion = promocionService.update(id, name, tipo, datoExtra);

		if (promocion.isValid()) {
			resp.sendRedirect("index.do");
		} else {
			req.setAttribute("promocion", promocion);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/editPromo.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
