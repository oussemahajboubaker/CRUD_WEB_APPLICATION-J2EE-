package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Reclamation;



public class ReclamationDAO {

	public boolean addReclamation(Reclamation rec) {
		String sql = "INSERT INTO reclamation ( date,desc,idetudiant) VALUES (?,?,?) ";
		try (
				Connection cnx = dbc.createConnection();
				PreparedStatement stmt = cnx.prepareStatement(sql);) {
			stmt.setString(1, rec.getDate());
			stmt.setString(2, rec.getDesc());
			stmt.setInt(3, rec.getidetudiant());


			return	stmt.executeUpdate()>0;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Reclamation findReclamation(int id) {
		String sql = "SELECT * FROM reclamation  WHERE id = ?";
		try (Connection cnx = dbc.createConnection();
				PreparedStatement stmt = cnx.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			if (result.next()){
				int Id = result.getInt("id");
				String date = result.getString("date");
				String desc = result.getString("desc");
				int IdEtudiant = result.getInt("idetudiant");
				return new Reclamation(id, date, desc,IdEtudiant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteReclamation(int id) {
		String sql = "DELETE FROM reclamation WHERE id = ?";
		try (
				Connection cnx = dbc.createConnection();
				PreparedStatement stmt = cnx.prepareStatement(sql)) {
			stmt.setInt(1, id);
			int rowsDeleted = stmt.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Reclamation deleted successfully");
				return true;
			} else {
				System.out.println("Reclamation not found");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
	
	
	public boolean updateReclamation(Reclamation rec  ) {
	    String sql = "UPDATE reclamation SET date =?, desc =?,idetudiant =? WHERE id = ?";
	    try (Connection cnx = dbc.createConnection();
	        PreparedStatement stmt = cnx.prepareStatement(sql)) {
	        stmt.setString(1,rec.getDate());
	        stmt.setString(2, rec.getDesc());
	        stmt.setInt(3,rec.getidetudiant());
	        stmt.setInt(4, rec.getId());
	        int rowsUpdated = stmt.executeUpdate();
	        return rowsUpdated > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	
}