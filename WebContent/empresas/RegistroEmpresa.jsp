<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Registro de Empresas</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>

<body>
	<%@ include file="../admin/menu.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-12 mt-5 mb-3">
				<h3 class="text-center">Ingreso de nueva Empresas</h3>
			</div>
			<div class="container-fluid">
				<a class="btn btn-primary" href="${pageContext.request.contextPath}/admin.do?op=empresas">Regresar</a>
			</div>
			<div class="col-12 mt-3">
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
								<span>Correo Electronico</span> <input type="email"
									class="form-control" id="emialEmpresa" name="correoEmpresa"
									required>
							</div>
							<div class="col-6 mt-3">
								<span>Seleccione un rubro</span>
								<select class="form-select" name="rubro" aria-label="Default select example">
									<c:forEach items="${requestScope.rubros}" var="rubros">
										<option value="${rubros.rubroID}">${rubros.rubro}</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-6 mt-3">
								<span>Comision</span> <input type="text"
									class="form-control" id="emialEmpresa" name="comision"
									required>
							</div>
						</div>
						<div class="col-10 m-3">
							<div class="text-center">
								<input class="btn btn-success mt-2" type="submit" value="Registrar" />
								<a href="${pageContext.request.contextPath}/admin.do?op=empresas" class="btn btn-danger mt-2">Cancelar</a>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>

</html>