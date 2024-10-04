<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../NavBar/NavBar.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<body>
    <h2 class="text-center fw-bold">Ajout Présence</h2>
    <form method="POST" action="<%= request.getContextPath() %>/AddLigPresence" class="container bg-light text p-2 my-3 col-md-4">
        <label class="form-label fw-bold" for="id">ID Etudiant:</label>
        <input class="form-control" type="number" id="ide" name="idetudiant"><br>
        <label class="form-label fw-bold" for="Date">Date:</label>
        <input type="text" class="form-control" id="date" name="dateLP"><br>
        <input class="btn btn-primary" type="submit" value="Ajouter">
    </form>
</body>
</html>