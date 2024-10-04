<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../NavBar/NavBar.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2 class="text-center fw-bold">Ajout Repas</h2>
    <form method="POST" action="<%= request.getContextPath() %>/AddRepas" class="container bg-light text p-2 my-3 col-md-4">
        <label class="form-label fw-bold" for="cout">Cout:</label>
        <input type="number" class="form-control" id="cout" name="cout"><br>
        <label class="form-label fw-bold" for="NBR">NBR:</label>
        <input type="number" class="form-control" id="NBR" name="NBR"><br>
        <label class="form-label fw-bold" for="date">Date:</label>
        <input type="Date" class="form-control" id="date" name="date"><br>
        <label class="form-label fw-bold" for="nom_repas">Nom repas:</label>
        <input type="text" class="form-control" id="nom_repas" name="nom_repas"><br>
       
        <input class="btn btn-primary" type="submit" value="Ajouter">
    </form>
</body>
</html>
