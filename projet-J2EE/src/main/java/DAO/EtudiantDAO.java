package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Etudiant;




public class EtudiantDAO {
	public void addEtudiant(Etudiant etudiant) {
		String sql = "INSERT INTO etudiant (nom	,prenom	,Tel,Faculte) VALUES (?,?,?,?)";
		try (Connection cnx = dbc.createConnection();
			PreparedStatement stmt = cnx.prepareStatement(sql);) {
			stmt.setString(1, etudiant.getNom());
			stmt.setString(2, etudiant.getPrenom());
			stmt.setInt(3, etudiant.getTel());
			stmt.setString(4, etudiant.getFaculte());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Etudiant findEtudiant(int id) {
		String sql = "SELECT * FROM etudiant WHERE id = ?";
		try (Connection cnx = dbc.createConnection();
				PreparedStatement stmt = cnx.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			if (result.next()) {
				Etudiant et = new Etudiant();
				et.setId(result.getInt(1));
                et.setNom(result.getString(2));
                et.setPrenom(result.getString(3));
                et.setTel(result.getInt(4));
                et.setFaculte(result.getString(5));
                return et;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean deleteetudiant(int id) {
		String sql = "DELETE FROM etudiant WHERE id = ?";
	    try (
	    		Connection cnx = dbc.createConnection();
	         PreparedStatement stmt = cnx.prepareStatement(sql)) {
	        stmt.setInt(1, id);
	        int rowsDeleted = stmt.executeUpdate();
	        if (rowsDeleted > 0) {
	            System.out.println("etudiant deleted successfully");
	            return true;
	        } else {
	            System.out.println("etudiant not found");
	            return false;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	
	}
	public boolean updateEtudiant(Etudiant etudiant ) {
	    String sql = "UPDATE etudiant SET nom = ?, prenom = ?,tel = ?,faculte = ? WHERE id = ?";
	    try (Connection cnx = dbc.createConnection();
	         PreparedStatement stmt = cnx.prepareStatement(sql)) {
	        stmt.setString(1, etudiant.getNom());
	        stmt.setString(2, etudiant.getPrenom());
	        stmt.setInt(3,etudiant.getTel());
	        stmt.setString(4, etudiant.getFaculte());
	        stmt.setInt(5,etudiant.getId());


	        int rowsUpdated = stmt.executeUpdate();
	        return rowsUpdated > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
}
