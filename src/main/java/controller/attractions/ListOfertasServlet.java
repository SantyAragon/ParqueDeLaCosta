package controller.attractions;

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
import services.OfertaService;

@WebServlet("/index.do")
public class ListOfertasServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -8346640902238722429L;
	private OfertaService ofertaService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.ofertaService = new OfertaService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Ofertable> ofertas;
		try {
			ofertas = ofertaService.list();
			req.setAttribute("ofertas", ofertas);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
			dispatcher.forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
