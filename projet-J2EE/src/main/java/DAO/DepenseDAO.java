package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepenseDAO {

	public double getAllDepense(String Jour) {
		String sql = "SELECT SUM(depense) FROM repas WHERE date= ?";
		try (
			Connection cnx = dbc.createConnection();
			PreparedStatement stmt = cnx.prepareStatement(sql)
		) {
			stmt.setString(1, Jour);
			ResultSet result = stmt.executeQuery();
			if (result.next()) {
				double totalDepense = result.getDouble(1);
				return totalDepense;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
}