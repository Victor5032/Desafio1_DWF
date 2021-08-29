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
<title>Recuperar contraseña - Administrador</title>
</head>
<body>
	<div class="container">
		<c:if test="${not empty mensajes}">
			<div class="alert alert-dark">
				<ul>
					<c:forEach var="mensajes" items="${requestScope.mensajes}">
						<li>${mensajes}</li>
					</c:forEach>
				</ul>
			</div>
		</c:if>
		<div class="row">
			<div class="col-12 mt-5">
				<div class="d-flex justify-content-center align-items-center">
					<form class="w-50 shadow-lg p-3 mb-5 bg-white rounded p-5"
						method="POST"
						action="${pageContext.request.contextPath}/admin.do">
						<input hidden="hidden" name="op" id="op" value="recuperarPassword">
						<div class="form-group mt-3">
							<h3>Recuperar contraseña</h3>
							<span>Correo electronico de la cuenta a recuperar</span>
							<input type="text"
								class="form-control mt-3" required name="correoAdmin"
								placeholder="Correo electronico">
						</div>
						<div class="text-center mt-5">
							<button type="submit" class="btn btn-primary">Enviar</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
