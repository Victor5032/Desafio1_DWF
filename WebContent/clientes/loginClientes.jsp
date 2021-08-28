<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<title>Iniciar sesion</title>
</head>
<body>
<%@ include file="navbarCliente.jsp"%>
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
				<div class="d-flex justify-content-center align-items-center">
					<form class="w-25 shadow-lg p-3 mb-5 bg-white rounded p-5"
						method="post"
						action="${pageContext.request.contextPath}/clientes.do?op=login">
						<div class="form-group mt-3">
							<span>Correo</span> <input type="email" name="correoCliente"
								class="form-control" required>
						</div>
						<div class="form-group mt-3">
							<span>Contraseña</span> <input type="password"
								name="passwordCliente" class="form-control" required>
						</div>
						<div class="text-center mt-5">
							<button type="submit" class="btn btn-primary">Ingresar</button>
						</div>
						<br/>
						<p class="text-start mt-3">Has olvidado tu contraseña ?<a href="${pageContext.request.contextPath}/clientes/recuperarContraseña.jsp" class="mt-3">click aqui</a></p>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
	crossorigin="anonymous"></script>
</html>