package controller.promocion;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.Promocion;
import persistence.AtraccionDAO;
import services.PromocionService;

@WebServlet("/createPromo.do")
public class CreatePromocionServlet extends HttpServlet {

	private static final long serialVersionUID = 3455721046062278592L;
	private PromocionService promocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/createPromo.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Integer id = Integer.parseInt(req.getParameter("id"));
		String nombrePromocion = req.getParameter("name");
		Integer tipoPromo = Integer.parseInt(req.getParameter("tipoPromo"));
		Double datoExtra = Double.parseDouble(req.getParameter("datoExtra"));
		Integer tipoAtraccion = Integer.parseInt(req.getParameter("tipoAtraccion"));
		String atraccionesEnPromo = (String) req.getParameter("atraccionesEnPromocion");
		String[] s = atraccionesEnPromo.split(" ");
		Atraccion[] atraccionesEnPromocion = new Atraccion[s.length];
		AtraccionDAO atraccionDAO = new AtraccionDAO();
		List<Atraccion> atracciones = new LinkedList<Atraccion>();

		for (int i = 0; i < s.length; i++) {
			atracciones.add(atraccionDAO.find(Integer.parseInt(s[i])));
			for (Atraccion atraccion : atracciones) {
				atraccionesEnPromocion[i] = atraccion;
			}
		}
		Promocion promocion;
		try {
			promocion = promocionService.create(nombrePromocion, tipoPromo, tipoAtraccion, datoExtra,
					atraccionesEnPromocion);
			if (promocion.isValid()) {
				resp.sendRedirect("index.do");
			} else {
				req.setAttribute("promocion", promocion);

				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/createPromo.jsp");
				dispatcher.forward(req, resp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}