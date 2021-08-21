<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Validacion</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

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
						action="${pageContext.request.contextPath}/empresas.do"
						method="POST">
						<input type="hidden" name="op" value="TokenValidate">
						<div class="form-group mt-3">
							<h3>Iniciar Sesion</h3>
							<span>Ingrese el codigo que le fue enviado a su correo</span> 
							<input type="text" class="form-control" name="userToken" required placeholder="Ingrese el codigo">
						</div>
						<div class="text-center mt-5">
							<input class="btn btn-success mt-2" type="submit"
								value="ingresar" />
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>