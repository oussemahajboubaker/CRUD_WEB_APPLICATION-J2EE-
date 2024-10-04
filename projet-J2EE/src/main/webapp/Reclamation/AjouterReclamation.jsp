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
    <h2 class="text-center fw-bold">Ajouter une Reclamation</h2>
    <form method="POST" action="<%= request.getContextPath() %>/AddReclamation" class="container bg-light text p-2 my-3 col-md-4">
        <label class="form-label fw-bold" for="id">Date:</label>
        <input class="form-control" type="text" name="date"><br>
        <label class="form-label fw-bold" for="Date">Description:</label>
        <input type="text" class="form-control" name="desc"><br>
        <label class="form-label fw-bold" for="Date">ID Etudiant:</label>
        <input type="number" class="form-control" id="date" name="idetudiant"><br>
        <input class="btn btn-primary" type="submit" value="Ajouter">
    </form>
</body>
</html>