package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RevenuDAO {
	public double getAllRevenu(String Jour) {
		String sql = "SELECT count(idetudiant) FROM ligpresence WHERE dateLP= ?";
		try (
			Connection cnx = dbc.createConnection();
			PreparedStatement stmt = cnx.prepareStatement(sql)
		) {
			stmt.setString(1, Jour);
			ResultSet result = stmt.executeQuery();
			if (result.next()) {
				int nbe = result.getInt(1);
				double totalRevenu=nbe*0.2;
				return totalRevenu;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
