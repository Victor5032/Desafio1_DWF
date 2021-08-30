<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <title>Perfil del cliente</title>
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
    <div class="container">
        <div class="row">
            <div class="col-12 mt-5">
                <h3 class="text-center">Perfil del cliente</h3>
            </div>
            <div class="col-12 mt-5">
                <div class="d-flex justify-content-center align-items-center">
                    <form class="w-50 shadow-lg p-3 mb-5 bg-white rounded p-5" method="post" action="${pageContext.request.contextPath}/clientes.do?op=updateInfo" >
                        <input value="${sessionScope.usser}" name="clienteID" hidden="hidden">
                        <div class="row">
                            <div class="col-6 mt-3">
                                <span>Nombres</span>
                                <input type="text" value="${cliente.nombres}" name="nombreCliente" class="form-control" id="nombrePerfilClientes" >
                            </div>
                            <div class="col-6 mt-3">
                                <span>Apellidos</span>
                                <input type="text" value="${cliente.apellidos}" name="apellidoCliente" class="form-control" id="apellidosPerfilClientes" >
                            </div>
                            <div class="col-12 mt-3">
                                <span>Direccion</span>
                                <input type="text" value="${cliente.direccion}" name="direccionCliente" class="form-control" id="direccionPerfilClientes" >
                            </div>
                            <div class="col-6 mt-3">
                                <span>Telefono</span>
                                <input type="text" value="${cliente.telefono}" name="telefonoCliente" class="form-control" id="telefonoPerfilClientes" >
                            </div>
                            <div class="col-6 mt-3">
                                <span>DUI</span>
                                <input type="text" value="${cliente.dui}" name="duiCliente" class="form-control" id="duiPerfilClientes" >
                            </div>
                            <div class="col-6 mt-3">
                                <span>Correo</span>
                                <input type="email" value="${cliente.email}" name="correoCliente" class="form-control" id="correoPerfilClientes" >
                            </div>
                           <div class="col-6 mt-3">
								<a
									href="${pageContext.request.contextPath}/clientes/cambiarPassword.jsp"
									class="link-secondary mt-3">cambiar contraseña</a>
							</div>
                            <input class="btn btn-warning mt-3" type="submit" value="Actualizar informacion">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="row">
			<div class="junbotron">
				<h1 class="display-4 center">Cupones</h1>
				<p class="lead">Lista de sus cupones adquiridos</p>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">Titulo</th>
						<th scope="col">Descripcion</th>
						<th scope="col">Precio regular</th>
						<th scope="col">Precio oferta</th>
						<th scope="col">Fecha de compra</th>
						<th scope="col">Estado del cupon</th>
						<th scope="col">Codigo del cupon</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${requestScope.listacupones}" var="cupones">
						<tr>
							<td>${cupones.tituloClienteCupon}</td>
							<td>${cupones.descripcionClienteCupon}</td>
							<td>${cupones.precioRegular}</td>
							<td>${cupones.precioOferta}</td>
							<td>${cupones.fechaCompraDate}</td>
							<td><c:if test="${cupones.estadoCupon == 1}">
	                                        		Disponible
	                                        	</c:if> <c:if
									test="${cupones.estadoCupon == 2}">
	                                        		Comprado
	                                        	</c:if> <c:if
									test="${cupones.estadoCupon == 3}">
	                                        		usado
	                                        	</c:if> <c:if
									test="${cupones.estadoCupon == 4}">
	                                        		vencido
	                                        	</c:if></td>
	                                        	<td>${cupones.codigoCupon}</td>
							
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
    </div>
</body>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</html>
