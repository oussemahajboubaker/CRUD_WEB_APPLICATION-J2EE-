package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Employee;


public class EmployeeDAO {
	
	public void addEmployee(Employee employee) {
		String sql = "INSERT INTO employee (nom	,prenom	,Tel,Poste) VALUES (?,?,?,?)";
		try (Connection cnx = dbc.createConnection();
				PreparedStatement stmt = cnx.prepareStatement(sql);) {
			stmt.setString(1, employee.getNom());
			stmt.setString(2, employee.getPrenom());
			stmt.setInt(3, employee.getTel());
			stmt.setString(4, employee.getPoste());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Employee findEmployee(int id) {
		String sql = "SELECT * FROM employee WHERE id = ?";
		try (Connection cnx = dbc.createConnection();
				PreparedStatement stmt = cnx.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			if (result.next()) {
				int Id = result.getInt("id");
				String nom = result.getString("nom");
				String prenom = result.getString("prenom");
				int Tel = result.getInt("Tel");
				String Poste = result.getString("Poste");
				return new Employee(id, nom, prenom,Tel,Poste);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean deleteLigPresence(int id) {
		String sql = "DELETE FROM employee WHERE id = ?";
	    try (
	    		Connection cnx = dbc.createConnection();
	         PreparedStatement stmt = cnx.prepareStatement(sql)) {
	        stmt.setInt(1, id);
	        int rowsDeleted = stmt.executeUpdate();
	        if (rowsDeleted > 0) {
	            System.out.println("employee deleted successfully");
	            return true;
	        } else {
	            System.out.println("employee not found");
	            return false;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	
	}
	
	
	public boolean updateEmployee(Employee emp ) {
	    String sql = "UPDATE employee SET nom = ?, prenom = ?,tel = ?,poste = ? WHERE id = ?";
	    try (Connection cnx = dbc.createConnection();
	         PreparedStatement stmt = cnx.prepareStatement(sql)) {
	        stmt.setString(1, emp.getNom());
	        stmt.setString(2, emp.getPrenom());
	        stmt.setInt(3,emp.getTel());
	        stmt.setString(4, emp.getPoste());
	        stmt.setInt(5,emp.getId());


	        int rowsUpdated = stmt.executeUpdate();
	        return rowsUpdated > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	
	

}
