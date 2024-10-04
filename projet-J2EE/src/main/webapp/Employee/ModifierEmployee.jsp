<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ include file="../NavBar/NavBar.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
	<h2 class="text-center fw-bold">Modifier Employee</h2>

	<form method="POST"
		action="<%= request.getContextPath() %>/UpdateEmployee"
		class="container bg-light text p-2 my-3 col-md-4">
		<label class="form-label fw-bold" for="id">ID:</label> 
		<input class="form-control" type="number" id="ide" name="id" value="${emp.id}" readonly><br> 
		<label class="form-label fw-bold" for="Date">Nom:</label> 
		<input type="text" class="form-control" id="date" name="nom" value="${emp.nom}"><br>
		<label class="form-label fw-bold" for="Date">Prenom:</label> 
		<input type="text" class="form-control" id="date" name="prenom" value="${emp.prenom}"><br>
		<label class="form-label fw-bold" for="Date">Tel:</label> 
		<input type="number" class="form-control" id="date" name="tel" value="${emp.tel}"><br>
		<label class="form-label fw-bold">Post:</label> 
		<input type="text" class="form-control" name="poste" value="${emp.poste}"><br>
		<input class="btn btn-primary" type="submit" value="Modifier">
	</form>
</body>
</html>