package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import persistence.commons.ConnectionProvider;
import model.Itinerario;

public class ItinerarioDAO {

	public int insert(Itinerario itinerario) throws SQLException {
		String sql = "INSERT INTO itinerarios (id_usuario, id_promo, id_atraccion) VALUES (?, ?, ?)";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, itinerario.getIdUsuario());
		statement.setInt(2, itinerario.getIdPromocion());
		statement.setInt(3, itinerario.getIdAtraccion());
		int rows = statement.executeUpdate();

		return rows;

	}

	public int update(Itinerario itinerario) throws SQLException {
		String sql = "UPDATE ITINERARIOS SET id_promocion = ?, id_atraccion=?,  WHERE id_usuario = ?";
		Connection conn = ConnectionProvider.getConnection();

		PreparedStatement statement = conn.prepareStatement(sql);
		// CHEQUEAR SI ESTÁ BIEN EL ORDEN
		statement.setInt(1, itinerario.getIdPromocion());
		statement.setInt(2, itinerario.getIdAtraccion());
		statement.setInt(3, itinerario.getIdUsuario());
		int rows = statement.executeUpdate();

		return rows;
	}

	public List<Itinerario> findAll() throws SQLException {
		String sql = "SELECT * FROM itinerarios";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();

		List<Itinerario> itinerarios = new LinkedList<Itinerario>();
		while (resultados.next()) {
			itinerarios.add(toItinerario(resultados));
		}

		return itinerarios;
	}

	private Itinerario toItinerario(ResultSet resultados) throws SQLException {
		return new Itinerario(resultados.getInt(1), resultados.getInt(2), resultados.getInt(3));
	}

	public void delete(Itinerario itinerario) {
		// TODO Auto-generated method stub

	}

	public List<Itinerario> findByUser(int idUsuario) throws SQLException {
		String sql = "SELECT * FROM itinerarios WHERE id_usuario=?";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, idUsuario);

		ResultSet resultados = statement.executeQuery();

		List<Itinerario> itinerarios = new LinkedList<Itinerario>();
		while (resultados.next()) {
			itinerarios.add(toItinerario(resultados));
		}

		return itinerarios;
	}
}