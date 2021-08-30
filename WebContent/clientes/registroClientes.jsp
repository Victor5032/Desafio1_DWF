<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <title>Registrar cliente</title>
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
                <h3 class="text-center">Registro para clientes</h3>
            </div>
            <div class="col-12 mt-5">
                <div class="d-flex justify-content-center align-items-center">
                    <form class="w-50 shadow-lg p-3 mb-5 bg-white rounded p-5" method="post" action="${pageContext.request.contextPath}/clientes.do">
                       <input value="registrarClienteSinVerificar" name="op" hidden>
                        <div class="row">
                            <div class="col-6 mt-3">
                                <span>Nombres</span>
                                <input type="text" name="nombreCliente" class="form-control" id="nombreRegistroClientes">
                            </div>
                            <div class="col-6 mt-3">
                                <span>Apellidos</span>
                                <input type="text" name="apellidoCliente" class="form-control" id="apellidosRegistroClientes">
                            </div>
                            <div class="col-12 mt-3">
                                <span>Direccion</span>
                                <input type="text" name="direccionCliente" class="form-control" id="direccionRegistroClientes">
                            </div>
                            <div class="col-6 mt-3">
                                <span>Telefono</span>
                                <input type="text" name="telefonoCliente" class="form-control" id="telefonoRegistroClientes">
                            </div>
                            <div class="col-6 mt-3">
                                <span>DUI</span>
                                <input type="text" name="duiCliente" class="form-control" id="duiRegistroClientes">
                            </div>
                            <div class="col-6 mt-3">
                                <span>Correo</span>
                                <input type="email" name="emailCliente" class="form-control" id="correoRegistroClientes">
                            </div>
                            <div class="col-6 mt-3">
                                <span>Contraseña</span>
                                <input type="password" name="passwordCliente" class="form-control" id="contraseñaRegistroClientes">
                            </div>
                            <div class="text-center mt-5"><button type="submit" class="btn btn-primary">Registrarse</button></div>
                           
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js"></script>
<script>
    window.onload = function(){
        $('#telefonoRegistroClientes').mask('0000-0000');
        $('#duiRegistroClientes').mask('00000000-0');
    }
</script>
</html>
