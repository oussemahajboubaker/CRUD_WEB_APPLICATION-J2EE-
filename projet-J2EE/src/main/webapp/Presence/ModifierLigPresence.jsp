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
	<h2 class="text-center fw-bold">Modifier Présence</h2>

	<%-- Formulaire pour ajouter une personne --%>
	<form method="POST"
		action="<%= request.getContextPath() %>/UpdateLigPresence"
		class="container bg-light text p-2 my-3 col-md-4">
		<label class="form-label fw-bold" for="id">ID:</label> <input
			class="form-control" type="number" id="ide" name="id"
			value="${ligPresence.id}" readonly><br> <label
			class="form-label fw-bold" for="Date">Date:</label> <input
			type="text" class="form-control" id="date" name="dateLP"
			value="${ligPresence.dateLP}"><br> <label
			class="form-label fw-bold" for="id">ID Etudiant:</label> <input
			class="form-control" type="number" id="ide" name="idetudiant"
			value="${ligPresence.idetudiant}"><br> <input
			class="btn btn-primary" type="submit" value="Modifier">
	</form>
</body>
</html>