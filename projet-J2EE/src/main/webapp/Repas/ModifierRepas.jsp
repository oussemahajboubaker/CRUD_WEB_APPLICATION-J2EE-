<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../NavBar/NavBar.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
    <h2 class="text-center fw-bold">Modifier Repas</h2>
    <form method="POST" action="<%= request.getContextPath() %>/UpdateRepas" class="container bg-light text p-2 my-3 col-md-4">
        <label class="form-label fw-bold" for="cout" >ID</label>
        <input readonly type="number" class="form-control"  value="${rep.id_repas}" name="id"><br>
        <label class="form-label fw-bold" for="cout" >Cout:</label>
        <input type="number" class="form-control" id="cout" value="${rep.cout }" name="cout"><br>
        <label class="form-label fw-bold" for="NBR" >NBR:</label>
        <input type="number" class="form-control" value="${rep.NBR }" name="nbr"><br>
        <label class="form-label fw-bold" for="date" >Date:</label>
        <input type="text" class="form-control" id="date" value="${rep.date }" name="date"><br>
        <label class="form-label fw-bold" for="nom_repas" >Nom repas:</label>
        <input type="text" class="form-control" id="nom_repas" value="${rep.nom_repas }" name="nom"><br>
        <label  class="form-label fw-bold" for="nom_repas" >Depsense:</label>
        <input readonly type="text" class="form-control" value="${rep.depense }"><br>
       
        <input class="btn btn-primary" type="submit" value="Modifier">
    </form>
</body>
</html>
