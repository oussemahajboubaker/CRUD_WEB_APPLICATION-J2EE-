<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="beans.LigPresence" %>
<%@ include file="../NavBar/NavBar.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>

<br> 
<div id="menu">      
    <a href="AjouterPresence.jsp"  class="btn btn-primary" ><b>+</b> Ajouter Présence</a> 
</div>
<br>

<br>
<div class="tabscroll">
    <table id="tabusser" border="1" class="table table-hover  my-4  table-bordered text-center container">
        <thead class="tbl-header">
            <tr>
                <th>Id</th>
               
                <th>Date</th>
                 <th>Id étudiant</th>
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
                PreparedStatement pst = con.prepareStatement("SELECT * FROM ligpresence");
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    LigPresence ligPresence = new LigPresence();
                    ligPresence.setid(rs.getInt(1));
                    ligPresence.setDateLP(rs.getString(2));
                    ligPresence.setIdetudiant(rs.getInt(3));
                  

                    
                    %>
                    <tr>
                        <td><%= ligPresence.getid() %></td>
                         <td><%= ligPresence.getDateLP() %></td>
                        <td><%= ligPresence.getIdetudiant() %></td>
                       
			<td><a href="<%= request.getContextPath() %>/UpdateLigPresence?id=<%= ligPresence.getid() %>">Modifier</a></td>
	
			<td><a href="<%= request.getContextPath() %>/SupprimerLigPresence?id=<%= ligPresence.getid() %>">Supprimer</a></td>
                    </tr>
                    <%
                }
                pst = con.prepareStatement("SELECT COUNT(*) FROM ligpresence");
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
    <p>Nombre des lignes d'absences: <%= number %></p><br>
</body>
</html>