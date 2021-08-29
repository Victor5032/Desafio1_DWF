<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">
	<head>
		<meta charset="UTF-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<title>Login - Administrador</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
		<link href="${pageContext.request.contextPath}/public/css/estiloadmin.css" rel="stylesheet" type=text/css>
	</head>
	<body>
		<main>
			<div class="container h-100">
				<div class="d-flex justify-content-center align-items-center h-100">
					<div class="card bg-silver">
						<div class="card-body p-5">
							<form method="POST">
								<input type="hidden" id="op" name="op" value="login">
								<div class="text-center mb-5">
									<strong>
										<h3>Inicia como Administrador</h3>
									</strong>
								</div>
								<div class="mb-3">
									<div class="row align-items-center">
										<div class="col-3">
											<label for="usuario_label" class="col-form-label">Usuario:</label>
										</div>
										<div class="col-9">
											<input type="text" id="usuario" name="usuario" class="form-control" required>
										</div>
									</div>
								</div>
								<div class="mb-3">
									<div class="row align-items-center">
										<div class="col-3">
											<label for="password_label" class="col-form-label">Contraseña:</label>
										</div>
										<div class="col-9">
											<input type="password" id="password" name="password" class="form-control" required>
										</div>
									</div>
								</div>
								<div class="text-center mt-5">
									<div class="row">
										<div class="col-12">
											<button type="submit" class="btn btn-dark">Ingresar</button>
										</div>
										<div class="col-12">
											<div class="mt-3">
												<a href="${pageContext.request.contextPath}/admin.do?op=recuperar" class="link-dark">Recuperar contraseña</a>
											</div>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
					<!-- <div class="contenedortotal">
						<form action="menu.jsp" method="post">

							<div class="parrafo">
								<img src="${pageContext.request.contextPath}/public/images/admin.jpg" hidden="80" width="80">
								<p style="text-align: center; font-size: 30px;">
									<strong>Bienvenido Administrador</strong>
								</p>
							</div>
							<div class="usuario" style="text-align: center;">
								<label style="font-size: 22px;" class="label">Usuario:</label> <input
									class="usuarioinput" type="text"
									placeholder="Ingrese el usuario dado" name="txtnombre">
							</div>
							<div class="password" style="text-align: center;" class="password">
								<label style="font-size: 22px;" class="label">Contraseña:</label> <input
									class="passwordinput" type="text"
									placeholder="Ingrese la contrase�a" name="txtpassword">
							</div>
							<br>
							<div style="text-align: center;" class="botonenviar">
								<input class="btnenviar" type="submit" name="accion"
									value="Registrarse" style="height: 30px; width: 100px;">
							</div>
						</form>
					</div> -->
				</div>
			</div>
		</main>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
	</body>
</html>
