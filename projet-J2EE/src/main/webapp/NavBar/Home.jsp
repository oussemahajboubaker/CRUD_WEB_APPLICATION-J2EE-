<%@ page language="java" %>
<%@ page import="java.sql.*"%>
<%
String login = "";
 if(session.getAttribute("login")!=null){
	 login = session.getAttribute("login").toString();
 }
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 60vh;
}

.image {
  width: 400px; /* Définir la largeur souhaitée */
  height: auto; /* Permettre à la hauteur de s'ajuster proportionnellement */
  margin: 30px auto; /* Ajouter des marges supérieure et inférieure auto pour centrer verticalement */
}

.centered-text {
  text-align: center;
}
</style>
</head>
<body>
<%@ include file="../NavBar/NavBar.jsp" %>
<div class="centered-text">
<br>
  <h3>Bienvenu <%=login %><br></h3>
  <br>
  
</div>
<div class="container">
    <img src="../Css/login.jpg" class="image">
</div>
</body>
</html>
