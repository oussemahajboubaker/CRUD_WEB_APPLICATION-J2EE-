<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="beans.Reclamation"%>
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
		<a href="AjouterReclamation.jsp" class="btn btn-primary"><b>+</b>
			Ajouter Reclamation</a>
	</div>
	<br>
	 

	<br>
	<div class="tabscroll">
		<table id="tabusser" border="1"
			class="table table-hover  my-4  table-bordered text-center container">
			<thead class="tbl-header">
				<tr>
					<th>Id</th>
					<th>Date</th>
					<th>Id étudiant</th>
					<th>Description</th>
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
                PreparedStatement pst = con.prepareStatement("SELECT * FROM reclamation");
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                	Reclamation rec = new Reclamation();
                    rec.setId((rs.getInt(1)));
                    
                    rec.setDate(rs.getString(2));
                    rec.setDesc(rs.getString(3));
                    rec.setidetudiant(rs.getInt(4));
                  

                    
                    %>
				<tr>
					<td><%= rec.getId() %></td>
					<td><%= rec.getDate() %></td>
					<td><%= rec.getidetudiant() %></td>
					<td><%= rec.getDesc() %></td>
					

					<td><a
						href="<%= request.getContextPath() %>/UpdateReclamation?id=<%= rec.getId() %>">Modifier</a></td>
					<td><a
						href="<%= request.getContextPath() %>/SupprimerReclamation?id=<%= rec.getId() %>">Supprimer</a></td>
				</tr>
				<%
                }
                pst = con.prepareStatement("SELECT COUNT(*) FROM reclamation");
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
			Nombre des Reclamations :
			<%= number %></p>
		<br>
</body>
</html>