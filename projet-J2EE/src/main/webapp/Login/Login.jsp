<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../Css/Login.css">
</head>
<body>
	<div class="container" id="container">
		<div class="form-container log-in-container">
			<form  method="POST" action="../ServletLogin">
				<h1>Connexion</h1>
				<div class="social-container">
				</div>
				<label for="username">Login:</label>
				<input type="text" id="username" name="login" autocomplete="off" required>
				<br>
				<label for="password">Mot De Passe:</label>
				<input type="password" id="password" name="passe" autocomplete="off" required>
				<br><br>
				<input type="submit" value="Login" name="submit">
			</form>
		</div>
		<div class="overlay-container">
			<div class="overlay">
				<div class="overlay-panel overlay-right">
					<img src="../Css/login.jpg">
				</div>
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
</body>
</html>
