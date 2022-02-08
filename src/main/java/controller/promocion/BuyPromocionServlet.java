package controller.promocion;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Ofertable;
import model.Usuario;
import persistence.UsuarioDAO;
import services.BuyPromocionService;

@WebServlet("/buyPromo.do")
public class BuyPromocionServlet extends HttpServlet {

	private static final long serialVersionUID = 3455721046062278592L;
	private BuyPromocionService buyPromocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.buyPromocionService = new BuyPromocionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		int promocionId = Integer.parseInt(req.getParameter("id"));
		Usuario user = (Usuario) req.getSession().getAttribute("user");

		Map<String, String> errors;
		Map<Ofertable, String> compradas;
		try {
			errors = buyPromocionService.buy(user.getIdUsuario(), promocionId);
			Usuario user2 = usuarioDAO.find(user.getIdUsuario());
			req.getSession().setAttribute("user", user2);

			if (errors.isEmpty()) {
				req.setAttribute("flash", "¡Gracias por comprar!");
			} else {
				req.setAttribute("errors", errors);
				req.setAttribute("flash", "No ha podido realizarse la compra");
			}
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listBuy.do");
			dispatcher.forward(req, resp);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
