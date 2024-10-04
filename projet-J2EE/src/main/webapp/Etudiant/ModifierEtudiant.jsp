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
<h2  class="text-center fw-bold">Modifier Etudiant</h2>
    
    <%-- Formulaire pour ajouter une personne --%>
    <form class="container bg-light text p-2 my-3 col-md-4" action="<%= request.getContextPath()%>/UpdateEtudiant" method="POST" >
       <label  class="form-label fw-bold" for="nom">ID:</label>
         <input class="form-control" type="text" name="id" value="${et.id }"><br>
       <label  class="form-label fw-bold" for="nom">Nom:</label>
         <input class="form-control" type="text" name="nom" value="${et.nom }"><br>
       <label  class="form-label fw-bold" for="prenom">Prénom:</label>
        <input class="form-control" type="text" name="prenom" value="${et.prenom }"><br>
       <label  class="form-label fw-bold" for="tel">Telephone:</label>
       <input class="form-control" type="number" name="Tel" value="${et.tel }"><br>
       <label  class="form-label fw-bold" for="faculte">Faculte:</label>
        <input class="form-control" type="text" name="Faculte" value="${et.faculte }"><br>
         <input class="btn btn-primary" type="submit" value="Modifier">
    </form>
</body>
</html>