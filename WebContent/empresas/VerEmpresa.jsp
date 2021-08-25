<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<%@ include file="navbar.jsp"%>
	<div class="container">
	<c:if test="${not empty listaEventos}">
			<div class="alert alert-dark">
				<ul>
					<c:forEach var="eventos" items="${requestScope.listaEventos}">
						<li>${eventos}</li>
					</c:forEach>
				</ul>
			</div>
		</c:if>
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
									class="form-control" value="${empresa.nombreEmpresa}"
									id="nombreRegistroEmpresa" required>
							</div>
							<div class="col-6 mt-3">
								<span>Contacto</span> <input type="text" class="form-control"
									id="contactoEmpresa" value="${empresa.contactoEmpresa}"
									required>
							</div>

							<div class="col-12 mt-3">
								<span>Direccion</span> <input type="text" class="form-control"
									id="direccionEmpresa" value="${empresa.direccionEmpresa}"
									required>
							</div>

							<div class="col-6 mt-3">
								<span>Telefono</span> <input type="text" class="form-control"
									id="telefonoEmpresa" pattern="^[0-9]{4}-?[0-9]{4}$"
									title="Solo acepta nï¿½meros en el siguiente formato: 2222-2222"
									value="${empresa.telefonoEmpresa}" required>
							</div>

							<div class="col-6 mt-3">
								<span>Correo Electronico</span> <input type="email"
									class="form-control" value="${empresa.correoEmpresa}"
									id="emialEmpresa" required>
							</div>


						</div>
						<div class="col-10 m-3">
							<div class="text-center">
								<a href="${pageContext.request.contextPath}/empresas/IngresarOferta.jsp" class="btn btn-success mt-2">Ingresar una oferta</a>
								<a href="#" class="btn btn-warning mt-2">Editar informacion</a>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="junbotron">
				<h1 class="display-4 center">Ofertas</h1>
				<p class="lead">Lista de ofertas realizadas</p>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">Titulo</th>
						<th scope="col">Fecha creacion</th>
						<th scope="col">precio regular</th>
						<th scope="col">precio oferta</th>
						<th scope="col">Estado de la oferta</th>
						<th scope="col">Mas informacion</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${requestScope.listaOfertas}" var="ofertas">
						<tr>
							<td>${ofertas.tituloOferta}</td>
							<td>${ofertas.fechaRegistroOferta}</td>
							<td>${ofertas.precioRegularOferta}</td>
							<td>${ofertas.precio_ofertaOferta}</td>
							<td><c:if test="${ofertas.estadoOferta == 1}">
	                                        		Aprobada
	                                        	</c:if> <c:if
									test="${ofertas.estadoOferta == 2}">
	                                        		Rechazada
	                                        	</c:if> <c:if
									test="${ofertas.estadoOferta == 3}">
	                                        		Pendiente de aprobación
	                                        	</c:if> <c:if
									test="${ofertas.estadoOferta == 4}">
	                                        		Reenviado a revisión
	                                        	</c:if></td>
							<td><a href="${pageContext.request.contextPath}/ofertas.do?op=detallesOferta&idOferta=${ofertas.idOferta}" class="btn btn-secondary"><svg
										xmlns="http://www.w3.org/2000/svg" width="23" height="23"
										fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
  <path
											d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z" />
  <path
											d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z" />
</svg></a></td>
						</tr>


					</c:forEach>

				</tbody>
			</table>
		</div>
</body>

</html>