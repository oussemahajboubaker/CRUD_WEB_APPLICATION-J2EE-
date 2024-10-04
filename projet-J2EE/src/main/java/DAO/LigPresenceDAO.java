package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.LigPresence;

public class LigPresenceDAO {

	public void addLigPresence(LigPresence ligPresence) {
		String sql = "INSERT INTO ligpresence (idetudiant,dateLP) VALUES (?, ?)";
		try (Connection cnx = dbc.createConnection();
				PreparedStatement stmt = cnx.prepareStatement(sql);) {
			stmt.setInt(1, ligPresence.getIdetudiant());
			stmt.setString(2, ligPresence.getDateLP());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public LigPresence findLigPresence(int id) {
		String sql = "SELECT * FROM ligpresence WHERE id = ?";
		try (Connection cnx = dbc.createConnection();
				PreparedStatement stmt = cnx.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			if (result.next()) {
				LigPresence ligPresence = new LigPresence();
                ligPresence.setid(result.getInt(1));
                ligPresence.setDateLP(result.getString(2));
                ligPresence.setIdetudiant(result.getInt(3));
				return ligPresence;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateLigPresence(LigPresence ligPresence) {
		String sql = "UPDATE ligpresence SET dateLP = ?, idetudiant=? WHERE id = ?";
		try (Connection cnx = dbc.createConnection();
				PreparedStatement stmt = cnx.prepareStatement(sql)) {
			stmt.setString(1, ligPresence.getDateLP());
			stmt.setInt(2, ligPresence.getIdetudiant());
			stmt.setInt(3, ligPresence.getid());
			int rowsUpdated = stmt.executeUpdate();
			return rowsUpdated > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean deleteLigPresence(int id) {
		String sql = "DELETE FROM ligpresence WHERE id = ?";
	    try (
	    		Connection cnx = dbc.createConnection();
	         PreparedStatement stmt = cnx.prepareStatement(sql)) {
	        stmt.setInt(1, id);
	        int rowsDeleted = stmt.executeUpdate();
	        if (rowsDeleted > 0) {
	            System.out.println("ligpresence deleted successfully");
	            return true;
	        } else {
	            System.out.println("ligpresence not found");
	            return false;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	
	}

}
