<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Inicio de Sesion</title>
</head>
<body>
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
						method="POST"
						action="${pageContext.request.contextPath}/clientes.do">
						<input hidden="hidden" value="verificacion" name="op">
						<div class="form-group mt-3">
							<h3>Ingrese el codigo</h3>
							<span>Codigo de verificacion</span> <input type="text"
								class="form-control" required name="correoEmpresa"
								placeholder="Ingrese el codigo de verificacion">
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>