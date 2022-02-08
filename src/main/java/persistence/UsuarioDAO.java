package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;
import model.Usuario;
import model.nullobjects.NullUser;

public class UsuarioDAO {
	public List<Usuario> findAll() throws SQLException {
		String sql = "SELECT * FROM usuarios";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();

		List<Usuario> usuarios = new LinkedList<Usuario>();
		while (resultados.next()) {
			usuarios.add(toUsuario(resultados));
		}

		return usuarios;
	}

	public int update(Usuario usuario) throws SQLException {
		String sql = "UPDATE usuarios SET dinero_disponible = ?, tiempo_disponible=? WHERE id = ?";
		Connection conn = ConnectionProvider.getConnection();

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setDouble(1, usuario.getDinero());
		statement.setDouble(2, usuario.getTiempo());
		statement.setInt(3, usuario.getIdUsuario());

		int rows = statement.executeUpdate();

		return rows;
	}

	public Usuario findByUsername(String username) {
		try {
			String sql = "SELECT * FROM usuarios WHERE nombre = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet resultados = statement.executeQuery();

			Usuario user = NullUser.build();

			if (resultados.next()) {
				user = toUsuario(resultados);
			}

			return user;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public Usuario find(int id) {
		try {
			String sql = "SELECT * FROM usuarios WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();

			Usuario user = NullUser.build();

			if (resultados.next()) {
				user = toUsuario(resultados);
			}

			return user;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Usuario toUsuario(ResultSet resultados) throws SQLException {
		return new Usuario(resultados.getInt(1), resultados.getString(2), resultados.getInt(3), resultados.getDouble(4),
				resultados.getDouble(5), resultados.getBoolean(6), resultados.getString(7));
	}

}