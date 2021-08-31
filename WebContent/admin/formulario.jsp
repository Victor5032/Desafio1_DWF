<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
	<head>
        <meta charset="UTF-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<title>Oferta - Administrador</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
		<link href="//cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css" rel="stylesheet" type=text/css>
    </head>
	<body>
		<%@ include file="menu.jsp" %>
		<main>
			<section class="py-3">
				<div class="container">
					<div class="pb-3">
                        <h3 class="text-center">Oferta: ${oferta.tituloOferta}</h3>
                    </div>
                    <div class="pb-3">
                        <div>
                            <a href="${pageContext.request.contextPath}/admin.do?op=details&codigo=${oferta.idOferta}" class="btn btn-primary">Volver a detalles de la oferta</a>
                        </div>
                    </div>
					<div class="row">
						<div class="col-7">
                            <div class="card">
                                <h5 class="card-header"><i>Detalles de la oferta</i></h5>
                                <div class="card-body">
                                    <h5 class="card-title text-center">${oferta.tituloOferta}</h5>
                                    <p class="card-text"><strong>Descripción:&nbsp;</strong>${oferta.descripcionOferta}</p>
                                    <p class="card-text"><strong>Empresa:&nbsp;</strong>${oferta.nombreEmpresa}</p>
                                    <div class="row">
                                   		<div class="col-6">
                                   			<p class="card-text text-center">
                                    			<strong>Precio Regular:&nbsp;</strong>$<span>${oferta.precioRegularOferta}</span>
                                    		</p>
                                   		</div>
                                   		<div class="col-6">
                                   			<p class="card-text text-center">
                                    			<strong>Precio Regular:&nbsp;</strong>$<span>${oferta.precio_ofertaOferta}</span>
                                    		</p>
                                   		</div>
                                   	</div>
                                   	<br>
                                   	<div class="row">
                                   		<div class="col-6">
                                   			<p class="card-text text-center">
                                    			<strong>Fecha de inicio:&nbsp;</strong><span>${oferta.fechaInicioOferta}</span>
                                    		</p>
                                   		</div>
                                   		<div class="col-6">
                                   			<p class="card-text text-center">
                                    			<strong>Fecha de fin:&nbsp;</strong><span>${oferta.fechaFinOferta}</span>
                                    		</p>
                                   		</div>
                                   	</div>
                                   	<div class="row">
                                   		<div class="col-12">
                                   			<p class="card-text text-center">
                                    			<h4 class="text-center"><strong>Precio por cupón:&nbsp;</strong><span class="text-primary">$${oferta.precioXcupon}</span></h4>
                                    		</p>
                                   		</div>
                                   	</div>
                                    <br>
                                    <c:if test="${not empty oferta.extrasOferta}">
	                                	<p class="card-text"><strong>Extras:&nbsp;</strong>${oferta.extrasOferta}</p>
	                                </c:if>
                                </div>

                            </div>
                        </div>
						<div class="col-5">
							<h4 class="text-center">¿Qué desea realizar con esta oferta?</h4>
							<br>
							<form action="${pageContext.request.contextPath}/admin.do" method="POST">
								<input type="hidden" name="op" id="op" value="sale-status">
								<input type="hidden" name="codigo" id="codigo" value="${oferta.idOferta}">
								<div class="row">
									<div class="col-6">
										<div class="form-check">
											<input class="form-check-input" type="radio" name="estado-aprobar" id="estado-aprobar" value="1" checked>
											<label class="form-check-label" for="exampleRadios1">Aprobar</label>
										</div>
									</div>
									<div class="col-6">
										<div class="form-check">
											<input class="form-check-input" type="radio" name="estado-rechazar" id="estado-rechazar" value="2">
											<label class="form-check-label" for="exampleRadios1">Rechazar</label>
										</div>
									</div>
								</div>
								<div id="observaciones-block" class="mt-3 d-none">
									<label for="exampleFormControlTextarea1" class="form-label">Observaciones:</label>
									<textarea class="form-control" id="observaciones" name="observaciones" rows="3" style="resize: unset !important;"></textarea>
								</div>
								<div class="d-grid gap-2 mt-3">
									<button class="btn btn-info" type="submit">Enviar</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</section>
		</main>
		<script src="${pageContext.request.contextPath}/public/js/main.js"></script>
	</body>
</html>
