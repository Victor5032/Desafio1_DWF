<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Perfil de Empresa</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-12 mt-5">
				<h3 class="text-center">Perfil de Empresa</h3>
			</div>
			<div class="col-12 mt-5">
				<div class="d-flex justify-content-center align-items-center">
					<form class="w-50 shadow-lg p-3 mb-5 bg-white rounded p-5"
						action="#" method="POST">
						<div class="row">

							<div class="col-6 mt-3">
								<span>Nombre Empresa</span> <input type="text"
									class="form-control" id="nombreRegistroEmpresa" required>
							</div>
							<div class="col-6 mt-3">
								<span>Contacto</span> <input type="text" class="form-control"
									id="contactoEmpresa" required>
							</div>

							<div class="col-12 mt-3">
								<span>Direccion</span> <input type="text" class="form-control"
									id="direccionEmpresa" required>
							</div>

							<div class="col-6 mt-3">
								<span>Telefono</span> <input type="text" class="form-control"
									id="telefonoEmpresa" pattern="^[0-9]{4}-?[0-9]{4}$"
									title="Solo acepta n�meros en el siguiente formato: 2222-2222"
									required>
							</div>

							<div class="col-6 mt-3">
								<span>Correo Electronico</span> <input type="email"
									class="form-control" id="emialEmpresa" required>
							</div>


						</div>
						<div class="col-10 m-3">
							<div class="text-center">
								<input class="btn btn-success mt-2" type="submit"
									value="Generar Oferta" /> <a href="#"
									class="btn btn-danger mt-2">Volver</a>
							</div>
						</div>
					</form>
					<a href="${pageContext.request.contextPath}/empresas/IngresarOferta.jsp" class="btn btn-">ingresar nueva oferta</a>
				</div>
			</div>
		</div>
</body>

</html>