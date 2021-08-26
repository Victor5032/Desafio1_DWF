<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Registro de Empresas</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body>
	<%@ include file="navbar.jsp"%>
	<div class="container">

		<div class="row">
			<div class="col-12 mt-5">
				<h3 class="text-center">Registro para Empresas</h3>
			</div>
			<div class="col-12 mt-5">
				<div class="d-flex justify-content-center align-items-center">
					<form class="w-50 shadow-lg p-3 mb-5 bg-white rounded p-5"
						action="${pageContext.request.contextPath}/empresas.do"
						method="POST">
						<input type="hidden" name="op" value="validar">
						<div class="row">
							<div class="col-6 mt-3">
								<span>Nombre Empresa</span> <input type="text"
									class="form-control" id="nombreRegistroEmpresa"
									name="empresaNombre" required>
							</div>
							<div class="col-6 mt-3">
								<span>Contacto</span> <input type="text" class="form-control"
									id="contactoEmpresa" name="empresaContacto" required>
							</div>

							<div class="col-12 mt-3">
								<span>Direccion</span> <input type="text" class="form-control"
									id="direccionEmpresa" name="direccionEmpresa" required>
							</div>

							<div class="col-6 mt-3">
								<span>Telefono</span> <input type="text" class="form-control"
									id="telefonoEmpresa" pattern="^[0-9]{4}-?[0-9]{4}$"
									title="Solo acepta números en el siguiente formato: 2222-2222"
									name="telefonoEmpresa" required>
							</div>
							<div class="col-6 mt-3">
								<span>Contraseña Empresa</span> <input type="password"
									class="form-control" id="passwordEmpresa"
									name="passwordEmpresa" required>
							</div>
							<div class="col-6 mt-3">
								<span>Correo Electronico</span> <input type="email"
									class="form-control" id="emialEmpresa" name="correoEmpresa"
									required>
							</div>
							<div class="col-6 mt-3">
								<span>Seleccione un rubro</span> <select
									class="form-select" name="rubro" aria-label="Default select example">
									<c:forEach items="${requestScope.rubros}" var="rubros">
									<option value="${rubros.rubroID}">${rubros.rubro}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-10 m-3">
							<div class="text-center">
								<input class="btn btn-success mt-2" type="submit"
									value="Registrar" /> <a href="#" class="btn btn-danger mt-2">Cancelar</a>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>

</html>