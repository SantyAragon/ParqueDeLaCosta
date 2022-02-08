package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;
import model.Atraccion;
import model.Promocion;

public class PromocionDAO {
	public List<Promocion> findAll(List<Atraccion> atracciones) throws SQLException {
		String sql = "SELECT promociones.*, group_concat(ap.id_atraccion, ' ') AS lista_atracciones\r\n"
				+ "FROM promociones\r\n" + "join atracciones_promo ap on ap.id_promocion = promociones.id\r\n"
				+ "GROUP BY promociones.id";

		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();

		List<Promocion> promociones = new LinkedList<Promocion>();
		while (resultados.next()) {
			promociones.add(toPromocion(resultados, atracciones));
		}

		return promociones;
	}

	public List<String> findAtracciones() throws SQLException {
		String sql = "SELECT  group_concat(ap.id_atraccion, ' ') AS lista_atracciones\r\n" + "FROM promociones\r\n"
				+ "join atracciones_promo ap on ap.id_promocion = promociones.id\r\n" + "GROUP BY promociones.id";

		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();

		List<String> Lista_atracciones = new LinkedList<String>();
		while (resultados.next()) {
			Lista_atracciones.add(toString(resultados));
		}

		return Lista_atracciones;
	}

	private String toString(ResultSet resultados) throws SQLException {
		return new String(resultados.getString(1));
	}

	public int countAll() throws SQLException {
		String sql = "SELECT COUNT(1) AS TOTAL FROM promociones";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();

		resultados.next();
		int total = resultados.getInt("TOTAL");

		return total;
	}

	public Promocion toPromocion(ResultSet resultados, List<Atraccion> atracciones) throws SQLException {
		String[] s = resultados.getString(9).split(" ");
		Atraccion[] atraccionesEnPromo = new Atraccion[s.length];

		for (int i = 0; i < s.length; i++) {

			for (Atraccion atraccion : atracciones) {
				if (atraccion.getIdAtraccion() == Integer.parseInt(s[i])) {
					atraccionesEnPromo[i] = atraccion;
				}
			}
		}

		return new Promocion(resultados.getInt(1), resultados.getString(2), resultados.getInt(3), resultados.getInt(4),
				resultados.getDouble(5), resultados.getBoolean(6), resultados.getString(7), resultados.getString(8),
				atraccionesEnPromo);
	}

	public Promocion toPromocion2(ResultSet resultados) throws SQLException {
		String[] s = resultados.getString(9).split(" ");
		Atraccion[] atraccionesEnPromo = new Atraccion[s.length];
		AtraccionDAO atraccionDAO = new AtraccionDAO();
		List<Atraccion> atracciones = atraccionDAO.findAll();
		for (int i = 0; i < s.length; i++) {

			for (Atraccion atraccion : atracciones) {
				if (atraccion.getIdAtraccion() == Integer.parseInt(s[i])) {
					atraccionesEnPromo[i] = atraccion;
				}
			}
		}

		return new Promocion(resultados.getInt(1), resultados.getString(2), resultados.getInt(3), resultados.getInt(4),
				resultados.getDouble(5), resultados.getBoolean(6), resultados.getString(7), resultados.getString(8),
				atraccionesEnPromo);
	}

	public Promocion find(Integer id) {
		try {
			String sql = "SELECT promociones.*, group_concat(ap.id_atraccion, ' ') AS lista_atracciones\r\n"
					+ "FROM promociones\r\n" + "join atracciones_promo ap on ap.id_promocion = promociones.id\r\n"
					+ "WHERE id=?" + "GROUP BY promociones.id";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet resultados = statement.executeQuery();

			Promocion promocion = null;
			if (resultados.next()) {
				promocion = toPromocion2(resultados);
			}

			return promocion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int habilite(Promocion promocion) {
		try {
			String sql = "UPDATE promociones SET deshabilitado=0 WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, promocion.getIdPromo());
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int delete(Promocion promocion) {
		try {
			String sql = "UPDATE promociones SET deshabilitado=1 WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, promocion.getIdPromo());
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int update(Promocion promocion) {
		try {
			String sql = "UPDATE promociones SET nombre = ?, id_tipo_promocion = ?, dato_extra = ? WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, promocion.getNombre());
			statement.setInt(2, promocion.getTipoPromocion());
			statement.setDouble(3, promocion.getDatoExtra());
			statement.setInt(4, promocion.getIdPromo());

			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}

	public int updateCupo(Promocion promocion) {
		try {
			String sql = "UPDATE atracciones SET cupo=? WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			Atraccion[] atraccionesPromo = promocion.getAtraccionesEnPromocion();
			int rows = 0;
			for (int i = 0; i < atraccionesPromo.length; i++) {
				statement.setInt(1, atraccionesPromo[i].getCupo());
				statement.setInt(2, atraccionesPromo[i].getIdAtraccion());

				rows = statement.executeUpdate();
			}
			return rows;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int insert(Promocion promocion) throws SQLException {
		String sql = "INSERT INTO promociones (nombre, id_tipo_promocion, id_tipo_atracciones, dato_extra) VALUES ( ?, ?, ?, ?);";
		String sql2 = "INSERT INTO atracciones_promo(id_promocion,id_atraccion) values(?,?);";
		Connection conn = ConnectionProvider.getConnection();

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, promocion.getNombre());
		statement.setInt(2, promocion.getTipoPromocion());
		statement.setInt(3, promocion.getTipoAtraccion());
		statement.setDouble(4, promocion.getDatoExtra());
		int rows = statement.executeUpdate();
		ResultSet rs = statement.getGeneratedKeys();
		rs.next();
		int idPromo = rs.getInt(1);
		promocion.setId(idPromo);

		PreparedStatement statement2 = conn.prepareStatement(sql2);
		Atraccion[] atraccionesPromo = promocion.getAtraccionesEnPromocion();

		statement2.setObject(1, promocion.getIdPromo());

		for (int i = 0; i < atraccionesPromo.length; i++) {
			statement2.setObject(2, atraccionesPromo[i].getIdAtraccion());
			@SuppressWarnings("unused")
			int rows2 = statement2.executeUpdate();
		}

		return rows;

	}
}
