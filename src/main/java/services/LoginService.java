package services;

import model.Usuario;
import model.nullobjects.NullUser;
import persistence.UsuarioDAO;

public class LoginService {

	public Usuario login(String username, String password) {
		UsuarioDAO userDao = new UsuarioDAO();
		Usuario user = userDao.findByUsername(username);

		if (user.isNull() || !user.checkPassword(password)) {
			user = NullUser.build();
		}
		return user;
	}

}
