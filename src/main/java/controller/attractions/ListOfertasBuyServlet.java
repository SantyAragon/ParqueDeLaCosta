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
import model.ComparadorDeOfertas;
import model.Ofertable;
import model.Usuario;
import persistence.UsuarioDAO;
import services.OfertaService;

@WebServlet("/listBuy.do")
public class ListOfertasBuyServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -8346640902238722429L;
	private OfertaService ofertaService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.ofertaService = new OfertaService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Ofertable> paraComprar;
		try {

			UsuarioDAO usuarioDAO = new UsuarioDAO();

			paraComprar = ofertaService.list();
			int id = Integer.parseInt(req.getParameter("id"));
			Usuario user = usuarioDAO.find(id);
			int atraccionFavorita = user.getTipo();
			req.setAttribute("paraComprar", paraComprar);

			paraComprar.sort(new ComparadorDeOfertas(atraccionFavorita));
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/buy.jsp");
			dispatcher.forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
