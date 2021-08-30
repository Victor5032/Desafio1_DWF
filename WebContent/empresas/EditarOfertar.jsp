<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Editar Ofertas</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous" />
</head>

<body>
	<%@ include file="navbar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-12 mt-5">
				<h3 class="text-center">Editar Ofertas</h3>
			</div>
			<div class="col-12 mt-5">
				<div class="d-flex justify-content-center align-items-center">
					<form class="w-50 shadow-lg p-3 mb-5 bg-white rounded p-5"
						action="${pageContext.request.contextPath}/ofertas.do?op=updateOferta"
						method="POST">
						<input value="${sessionScope.usser}" name="empresaID" hidden>
						<input value="${oferta.idOferta}" name="ofertaID" hidden>
						<div class="row">
							<div class="col-8 mt-3">
								<span style="text-align: center;">Titulo</span> <input
									type="text" value="${oferta.tituloOferta }" name="ofertaTitulo"
									class="form-control" id="tituloOferta" required>
							</div>
							<div class="col-12 mt-3">
								<span>Descripcion</span>
								<textarea class="form-control " name="ofertaDescripcion"
									id="descripcionOferta" cols="10" rows="5" required>${oferta.descripcionOferta }</textarea>
							</div>

							<div class="col-6 mt-3">
								<span>Precio Regular</span> <input
									value="${oferta.precioRegularOferta }" class="form-control"
									type="number" name="regularOferta" min="0" step="0.01" required
									id="precioRegular">
							</div>

							<div class="col-6 mt-3">
								<span>Precio Oferta</span> <input
									value="${oferta.precio_ofertaOferta }" class="form-control"
									type="number" name="ofertaOferta" min="0" step="0.01" required
									id="precioOferta">
							</div>
							<div class="col-6 mt-3">
								<span>Fecha Inicio</span> <input
									value="${oferta.fechaInicioOferta }" type="date"
									name="ofertaInicio" class="form-control" id="fechaInicio"
									required>
							</div>

							<div class="col-6 mt-3">
								<span>Fecha Final</span> <input
									value="${oferta.fechaFinOferta }" class="form-control"
									type="date" name="ofertaFinal" required="" id="fechaFinal" />

							</div>
							<div class="col-6 mt-3">
								<span>Cantidad de Cupones</span> <input
									value="${oferta.cantidadCuponesOferta }" class="form-control"
									name="ofertaCantidadCupones" type="text" id="cantidadOfertas"
									required>
							</div>
							<div class="col-6 mt-3">
								<span>Extras</span> <input value="${oferta.extrasOferta }"
									class="form-control" name="ofertasExtras" type="text"
									id="extrasOfertas" >
							</div>
							<div class="col-12 mt-3">
								<span>Observaciones</span>
								<c:set value="" var="observaciones" />
								<c:choose>
									<c:when test="${oferta.observacionesOferta == null}">
										<c:set value="Pendiente de revision" var="observaciones" />
									</c:when>
									<c:otherwise>
										<c:set value="${oferta.observacionesOferta}"
											var="observaciones" />
									</c:otherwise>
								</c:choose>
								<input value='<c:out value="${observaciones}"/>'
									class="form-control" type="text" readonly
									id="observacionOfertas" >
							</div>
							<div class="col-12 mt-3">
								<span>Estado</span>
								<c:if test="${oferta.estadoOferta == 1}">
									<div class="alert alert-success" role="alert">Oferta
										aprobada</div>
								</c:if>
								<c:if test="${oferta.estadoOferta == 2}">
									<div class="alert alert-warning" role="alert">oferta
										rechazada</div>
								</c:if>
								<c:if test="${oferta.estadoOferta == 3}">
									<div class="alert alert-secondary" role="alert">Pendiente
										de revision</div>
								</c:if>
								<c:if test="${oferta.estadoOferta == 4}">
	                                        		Reenviado a revisión
	                                        	</c:if>
							</div>

						</div>
						<div class="col-10 m-3">
							<div class="text-center">
								<input class="btn btn-success mt-2" type="submit"
									value="Actualizar" />
								<button type="button" class="btn btn-danger mt-2"
									data-bs-toggle="modal" data-bs-target="#exampleModal">
									Eliminar oferta</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

		<div class="modal fade" id="exampleModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Eliminar
							oferta</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<p class="text">
							Esta accion es irreversible, una vez eliminada la oferta no se
							podra recuperar <br /> desea continuar?
						</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Cancelar</button>
						<a href="${pageContext.request.contextPath}/ofertas.do?op=delete&ofertaID=${oferta.idOferta}" class="btn btn-primary">Eliminar</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js"
		integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc"
		crossorigin="anonymous"></script>
</body>

</html>