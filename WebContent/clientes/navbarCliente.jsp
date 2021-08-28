<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
									value="${sessionScope.name} ${sessionScope.apellido}" /></strong></a>
						<a class="nav-link"
							href="${pageContext.request.contextPath}/clientes.do?op=logout">Cerrar
							sesión</a>
					</c:when>
				</c:choose>
			</div>
		</div>
	</div>
</nav>