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
<h2  class="text-center fw-bold">Ajout d'un Etudiant</h2>
    
    <%-- Formulaire pour ajouter une personne --%>
    <form class="container bg-light text p-2 my-3 col-md-4" action="<%= request.getContextPath()%>/AddEtudiant" method="POST" >
       <label  class="form-label fw-bold" for="nom">Nom:</label>
         <input class="form-control" id="nom" name="nom"><br>
       <label  class="form-label fw-bold" for="prenom">Prénom:</label>
        <input class="form-control" id="prenom" name="prenom"><br>
       <label  class="form-label fw-bold" for="tel">Téléphone:</label>
       <input class="form-control" id="tel" name="Tel"><br>
       <label  class="form-label fw-bold" for="faculte">Faculté:</label>
        <input class="form-control" id="fac" name="Faculte"><br>
         <input class="btn btn-primary" type="submit" value="Ajouter">
    </form>
</body>
</html>