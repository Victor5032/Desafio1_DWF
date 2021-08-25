<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">Bienvenido </a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNavAltMarkup"
			aria-controls="navbarNavAltMarkup" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="d-flex">
			<div class="navbar-nav">
				<c:choose>
					<c:when test="${not empty sessionScope.usser}">
						<a class="nav-link" href="#">Activo como: <strong><c:out
									value="${sessionScope.name}" /></strong></a>
						<a class="nav-link"
							href="${pageContext.request.contextPath}/empresas.do?op=logout">Cerrar
							sesión</a>
					</c:when>
					<c:when test="${empty sessionScope.name}">
						<a class="btn btn-outline-success my-2 my-sm-0" href="${pageContext.request.contextPath}/empresas.do?op=logIn">Iniciar sesion</a>
						<a class="btn btn-outline-secondary my-2 my-sm-0 ml-3"
							href="${pageContext.request.contextPath}/empresas.do?op=nuevaEmpresa">Registrarse</a>

					</c:when>
				</c:choose>
			</div>
		</div>
	</div>
</nav>
