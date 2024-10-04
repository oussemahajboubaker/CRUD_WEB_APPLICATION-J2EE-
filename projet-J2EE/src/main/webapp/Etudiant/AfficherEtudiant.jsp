<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.sql.*"%>
    <%@ include file="../NavBar/NavBar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../Css\bootstrap.min.css">
    <%@ page import="beans.Etudiant"%>

</head>
<body>
<br> 
    <div id="menu">      
        <a class="btn btn-primary"  href="AjouterEtudiant.jsp"><b>+</b> Ajouter Etudiant </a> 
    </div>
    <br>

    <br>
    <div class="tabscroll">
        <table id="tabusser" border="1" class="table table-hover  my-4  table-bordered text-center container">
            <thead class="tbl-header">
                <tr>
                    <th>Id étudiant</th>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>Téléphone</th>
                    <th>Faculté</th>
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
                 PreparedStatement pst=con.prepareStatement("SELECT * FROM etudiant");
                 ResultSet rs = pst.executeQuery();
                 while(rs.next()){
                	 Etudiant etudiant = new  Etudiant();
                     etudiant.setId(rs.getInt(1));
                     etudiant.setNom(rs.getString(2));
                     etudiant.setPrenom(rs.getString(3));
                     etudiant.setTel(rs.getInt(4));
                     etudiant.setFaculte(rs.getString(5));
                     
                     %>
                     <tr>
                         <td><%=etudiant.getId() %></td>
                         <td><%=etudiant.getNom() %></td>
                         <td><%=etudiant.getPrenom() %></td>
                         <td><%=etudiant.getTel() %></td>
                         <td><%=etudiant.getFaculte() %></td>
			<td><a href="<%= request.getContextPath() %>/UpdateEtudiant?id=<%=etudiant.getId()%>">Modifier</a></td>
			<td><a href="<%= request.getContextPath() %>/SupprimerEtudiant?id=<%=etudiant.getId()%>">Supprimer</a></td>
                     </tr>
                      <%
		}
		pst=con.prepareStatement("SELECT COUNT(*) FROM etudiant");
		rs = pst.executeQuery();
		rs.next();
		number = rs.getInt(1);
		rs.close();
		pst.close();
		con.close();
	}catch(Exception e) {
		System.out.print(e);
	}
	%>  
</tbody>
</table>
<p>Nomber des etudiants : <%=number %><p><br>
</div>

</body>
</html>