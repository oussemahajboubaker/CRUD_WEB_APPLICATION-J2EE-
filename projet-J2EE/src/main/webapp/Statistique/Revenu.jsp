<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../NavBar/NavBar.jsp"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
    <form  class="container bg-light text p-2 my-3 col-md-4" action="<%= request.getContextPath() %>/GetRevenu" method="post">
    <h2 class="text-center fw-bold">Chercher Revenu</h2>
    <label  class="form-label fw-bold"for="">Jour  </label>
    <input class="form-control" type="date" name="jour" ><br>
    <button class="btn btn-primary" type="submit" name="submit">Chercher</button>
    </form>
    <% if (request.getAttribute("res") != null) { %>
    
<p>Revenu total du jour : <%= request.getAttribute("jour") + "  est: " + String.format("%.3f", request.getAttribute("res")) %> Dt</p>
    <% } %>
</body>
</html>