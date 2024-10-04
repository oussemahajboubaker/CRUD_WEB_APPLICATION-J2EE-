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
<body>
    <h2 class="text-center fw-bold">Modifier une Reclamation</h2>
    <form method="POST" action="<%= request.getContextPath() %>/UpdateReclamation" class="container bg-light text p-2 my-3 col-md-4">
        
         <label class="form-label fw-bold" for="id">ID:</label>
        <input class="form-control" type="text" name="id" value="${rec.id}"  readonly><br>
        <label class="form-label fw-bold" for="id">Date:</label>
        <input class="form-control" type="text" name="date" value="${rec.date}"><br>
        <label class="form-label fw-bold" for="Date">Description:</label>
        <input type="text" class="form-control" name="desc"  value="${rec.desc}"><br>
        <label class="form-label fw-bold" for="Date">ID Etudiant:</label>
        <input type="number" class="form-control" id="date" name="idetudiant"  value="${rec.idetudiant}"><br>
        <input class="btn btn-primary" type="submit" value="Modifier">
    </form>
</body>
</html>