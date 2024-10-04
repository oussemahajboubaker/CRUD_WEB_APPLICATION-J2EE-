<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="beans.Repas"%>
<%@ include file="../NavBar/NavBar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<br>
	<div id="menu">
		<a href="AjouterRepas.jsp" class="btn btn-primary"><b>+</b>
			Ajouter Repas</a>
	</div>
	<br>
	
	<br>
	<div class="tabscroll">
		<table id="tabusser" border="1"
			class="table table-hover  my-4  table-bordered text-center container">
			<thead class="tbl-header">
				<tr>
					<th>Id</th>
					<th>Cout</th>
					<th>NB Repas</th>
					<th>Date</th>
					<th>Nom_Repas</th>
					<th>Depense</th>
					<th>Modifier</th>
					<th>Supprimer</th>
				</tr>
			</thead>
			<tbody class="tbl-content">
				<%
            String url = "jdbc:mysql://localhost:3306/projetj2ee";
            String user = "root";
            String pwd = "";
            int number = 0;
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pwd);
                PreparedStatement pst = con.prepareStatement("SELECT * FROM repas");
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                	Repas repas = new Repas();
                	repas.setId_repas(rs.getInt(1));
                	repas.setCout(rs.getDouble(2));
                	repas.setNBR(rs.getInt(3));
                	repas.setDate(rs.getString(4));
                	repas.setNom_repas(rs.getString(5));
                	repas.setDepense(rs.getDouble(6));
                    %>
				<tr>
					<td><%= repas.getId_repas() %></td>
					<td><%= repas.getCout() %></td>
					<td><%= repas.getNBR() %></td>
					<td><%= repas.getDate() %></td>
					<td><%= repas.getNom_repas() %></td>
					<td><%= repas.getDepense() %></td>

					<td><a
						href="<%= request.getContextPath() %>/UpdateRepas?id=<%= repas.getId_repas() %>">Modifier</a></td>
					<td><a href="<%= request.getContextPath() %>/SupprimerRepas?id=<%= repas.getId_repas() %>">Supprimer</a></td>
				</tr>
				<%
                }
                pst = con.prepareStatement("SELECT COUNT(*) FROM repas");
                rs = pst.executeQuery();
                rs.next();
                number = rs.getInt(1);
                rs.close();
                pst.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            %>
			</tbody>
		</table>
		<p>
			Nombre des repas:<%= number %></p>
		<br>
</body>
</html>