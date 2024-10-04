package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Repas;


public class RepasDAO {
	public void addRepas(Repas repas) {
		String sql = "INSERT INTO repas (cout,NBR,date,nom_repas,depense) VALUES ( ?,?, ?,?, ?)";
		try (Connection cnx = dbc.createConnection();
			PreparedStatement stmt = cnx.prepareStatement(sql);) {
			stmt.setDouble(1, repas.getCout());
			stmt.setInt(2, repas.getNBR());
			stmt.setString(3, repas.getDate());
			stmt.setString(4, repas.getNom_repas());
			stmt.setDouble(5, repas.getDepense());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Repas findRepas(int id) {
		String sql = "SELECT * FROM repas WHERE id_repas = ?";
		try (Connection cnx = dbc.createConnection();
				PreparedStatement stmt = cnx.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			if (result.next()) {
				int id_repas = result.getInt("id_repas");
				Double cout = result.getDouble("cout");
				int NBR = result.getInt("NBR");
				String date = result.getString("date");
				String nom_repas = result.getString("nom_repas");
				Double depense = result.getDouble("depense");
				return new Repas(id_repas, cout, NBR,date,nom_repas,depense);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateRepas(Repas repas) {
		String sql = "UPDATE repas SET cout = ?, NBR = ?,date = ?, nom_repas = ?, depense = ? WHERE id_repas= ?";
		try (Connection cnx = dbc.createConnection();
				PreparedStatement stmt = cnx.prepareStatement(sql)) {
			stmt.setDouble(1, repas.getCout());
			stmt.setInt(2, repas.getNBR());
			stmt.setString(3, repas.getDate());
			stmt.setString(4, repas.getNom_repas());
			stmt.setDouble(5, repas.getDepense());
			stmt.setDouble(6, repas.getId_repas());
			int rowsUpdated = stmt.executeUpdate();
			return rowsUpdated > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteRepas(int id) {
		String sql = "DELETE FROM repas WHERE id_repas = ?";
	    try (
	    		Connection cnx = dbc.createConnection();
	         PreparedStatement stmt = cnx.prepareStatement(sql)) {
	        stmt.setInt(1, id);
	        int rowsDeleted = stmt.executeUpdate();
	        if (rowsDeleted > 0) {
	            System.out.println("Repas deleted successfully");
	            return true;
	        } else {
	            System.out.println("Repas not found");
	            return false;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	
	}

}
