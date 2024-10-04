<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*"%>
<%@ page import="beans.Employee"%>
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
		<a class="btn btn-primary" href="AjoutEmployee.jsp"><b>+</b>
			Ajouter Employee </a>
	</div>
	<br>

	<br>
	<div class="tabscroll">
		<table id="tabusser" border="1"
			class="table table-hover my-4 table-bordered text-center container">
			<thead class="tbl-header">
				<tr>
					<th>Id Employee</th>
					<th>Nom</th>
					<th>Prénom</th>
					<th>Téléphone</th>
					<th>Poste</th>
					<th>Modifier</th>
					<th>Supprimer</th>
				</tr>
			</thead>
			<tbody class="tbl-content">
				<% 
            String url  = "jdbc:mysql://localhost:3306/projetj2ee";
            String user = "root";
            String pwd  = "";
            int number = 0;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pwd);
                PreparedStatement pst=con.prepareStatement("SELECT * FROM employee");
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    Employee employee = new Employee();
                    employee.setId(rs.getInt(1));
                    employee.setNom(rs.getString(2));
                    employee.setPrenom(rs.getString(3));
                    employee.setTel(rs.getInt(4));
                    employee.setPoste(rs.getString(5));
                    
                    %>
				<tr>
					<td><%=employee.getId() %></td>
					<td><%=employee.getNom() %></td>
					<td><%=employee.getPrenom() %></td>
					<td><%=employee.getTel() %></td>
					<td><%=employee.getPoste() %></td>
					<td><a
						href="<%= request.getContextPath() %>/UpdateEmployee?id=<%=employee.getId()%>">Modifier</a></td>

					<td><a
						href="<%= request.getContextPath() %>/SupprimerEmployee?id=<%=employee.getId()%>">Supprimer</a></td>

				</tr>
				<%
                }
                pst=con.prepareStatement("SELECT COUNT(*) FROM employee");
                rs = pst.executeQuery();
                rs.next();
                number = rs.getInt(1);
                rs.close();
                pst.close();
                con.close();
            } catch(Exception e) {
                System.out.print(e);
            }
            %>
			</tbody>
		</table>
		<p>
			Nombre des employés:
			<%=number %></p>
		<br>
	</div>

</body>
</body>
</html>