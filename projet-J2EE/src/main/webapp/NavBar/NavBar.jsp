<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <link rel="stylesheet" href="../Css\bootstrap.min.css">

</head>
<body class="bg-light">
<nav class="navbar navbar-expand-lg navbar-light">
    <div class="container-fluid">
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item dropdown">
                        <a class="nav-link " href="<%= request.getContextPath() %>/NavBar/Home.jsp" id="navbarDropdown" role="button"
                           aria-expanded="false">Home
                        </a>
                        
                    </li>
                      <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                            data-bs-toggle="dropdown" aria-expanded="false">
                            CRUD
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="<%= request.getContextPath() %>/Etudiant/AfficherEtudiant.jsp">Etudiant</a></li>
                            <li><a class="dropdown-item" href="<%= request.getContextPath() %>/Employee/AfficherEmployee.jsp">Employee</a></li>
                            <li><a class="dropdown-item"  href="<%= request.getContextPath() %>/Repas/AfficherRepas.jsp">Repas</a></li>
                             <li><a class="dropdown-item" href="<%= request.getContextPath() %>/Presence/AfficherLigPresence.jsp">Presence</a></li>
                           <li><a class="dropdown-item" href="<%= request.getContextPath() %>/Reclamation/AfficherReclamation.jsp">Reclamation</a></li>
                        
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                            data-bs-toggle="dropdown" aria-expanded="false">
                           Statistiques
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="<%= request.getContextPath() %>/Statistique/Revenu.jsp">Revenu</a></li>
                            <li><a class="dropdown-item" href="<%= request.getContextPath() %>/Statistique/Depense.jsp">Depense</a></li>
                        </ul>
                    </li>
                  
                    <li class="nav-item dropdown">
 <a class="nav-link " href="<%= request.getContextPath() %>/Login/Login.jsp" id="navbarDropdown" role="button"
                           aria-expanded="false">Deconnexion
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
</body>
</html>