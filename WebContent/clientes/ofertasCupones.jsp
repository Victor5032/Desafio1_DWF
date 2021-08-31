<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<title>Oferta de cupones</title>
</head>
<body>
<%@ include file="navbarCliente.jsp"%>
	<div class="container mt-5">
		<div class="row">
			<div class="col-12 shadow-lg p-3 mb-5 rounded">
				<h3 class="text-center mt-5 mb-5">Oferta de cupones</h3>
				<div class="container">
					<div class="row">
						<c:forEach items="${requestScope.ofertasCupones}" 
							var="ofertacupon">
							<div class="col-4 shadow-sm p-3 mb-5 rounded">
								<div class="card text-center">
									<div class="card-header">
									Titulo:
									${ofertacupon.tituloOferta}</div>
									<center><img class="w-50" src="https://animalcrossinglife.com/wp-content/uploads/2020/10/coupon-di-sahara-icona-assets-acnh-animal-crossing-new-horizons.png"></center>
									<div class="card-body">
										<p class="card-text">Descripción: <br>  ${ofertacupon.descripcionOferta}</p>
										<p class="card-text text-success">Precio Oferta: <br>$${ofertacupon.precio_ofertaOferta}</p>
										<p class="card-text">
											Precio Regular: <br></b>$<strike>${ofertacupon.precioRegularOferta}</strike>
										
										</p>
										<p class="card-text">
											Precio por cupón: <br></b><span class="text-primary"><strong>$${ofertacupon.precioXcupon}</strong></span>
										
										</p>
										<c:if test="${ofertacupon.cantidadCuponesOferta > 0}">
											<a href="${pageContext.request.contextPath}/ofertacupon.do?op=detallesCupones&idoferta=${ofertacupon.idOferta}&empresa=${ofertacupon.idEmpresaOferta}"
											class="btn btn-primary">Adquirir</a>
										</c:if>
										
										<c:if test="${ofertacupon.cantidadCuponesOferta == 0}">
										Agotados
										</c:if>
																				
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
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
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</html>