<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="UTF-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<title>Detalles de la oferta - Administrador</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
		<link href="//cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css" rel="stylesheet" type=text/css>
    </head>
    <body>
        <%@ include file="menu.jsp" %>
        <main>
            <section class="py-5">
                <div class="container">
                    <div class="pb-3">
                        <h3 class="text-center">Detalles de la oferta</h3>
                    </div>
                    <div class="pb-3">
                        <div>
                            <a href="${pageContext.request.contextPath}/admin.do?op=home" class="btn btn-primary">Regresar</a>
                        </div>
                    </div>
                    <c:if test="${param.message == 1}">
                    	<div class="alert alert-success alert-dismissible d-flex align-items-center" role="alert">
	                    	<div>	
								Oferta aprobada
							</div>
							<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
						</div>
                    </c:if>
                    <c:if test="${param.message == 2}">
                    	<div class="alert alert-danger alert-dismissible d-flex align-items-center" role="alert">
	                    	<div>
								La oferta ha sido rechazada
							</div>
							<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
						</div>
                    </c:if>
                    <div class="row">
                        <div class="col-12">
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
                                    			<strong>Precio Oferta:&nbsp;</strong>$<span>${oferta.precio_ofertaOferta}</span>
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
                                    <br>
                                    <c:if test="${not empty oferta.extrasOferta}">
	                                	<p class="card-text"><strong>Extras:&nbsp;</strong>${oferta.extrasOferta}</p>
	                                </c:if>
									<br>
									<c:if test="${empty oferta.observacionesOferta}">
										<c:if test="${oferta.estadoOferta == 3}">
											<div class="text-center">
												<a href="${pageContext.request.contextPath}/admin.do?op=sale&codigo=${oferta.idOferta}" class="btn btn-primary">Realizar acción</a>
											</div>
										</c:if>
									</c:if>
                                </div>
                                <c:if test="${oferta.estadoOferta == 1}">
                                	<div class="card-footer text-center text-white bg-success">Oferta aprobada</div>
                                </c:if>
                                <c:if test="${oferta.estadoOferta == 2}">
                                	<div class="card-footer text-center text-white bg-danger">Oferta rechazada</div>
                                </c:if>
                                <c:if test="${oferta.estadoOferta == 3}">
                                	<div class="card-footer text-center text-black bg-warning">Pendiente de aprobación</div>
                                </c:if>
                            </div>
                        </div>
                        <c:if test="${not empty oferta.observacionesOferta}">
                        	<div class="col-12">
	                    		<div class="pt-5 pb-3">
	                    			<div class="card">
									  	<div class="card-header text-center">
									  		<strong>Observaciones</strong>
									  	</div>
									  	<div class="card-body">
									    	<p class="card-text">${oferta.observacionesOferta}</p>
									    	<c:if test="${oferta.estadoOferta == 3}">
									    		<div class="text-center">
										    		<a href="${pageContext.request.contextPath}/admin.do?op=sale&codigo=${oferta.idOferta}" class="btn btn-primary">Realizar acción</a>
										    	</div>
									    	</c:if>
									  	</div>
									</div>
	                    		</div>
	                    	</div>
                        </c:if>
						<c:if test="${oferta.estadoOferta == 1}">
							<div class="pt-5 pb-3">
								<h3 class="text-center">
									Cupones generados
								</h3>
						  	</div>
						  	<div class="card">
						  		<div class="card-header text-center">
							  		<strong>Cupones solicitados:</strong>&nbsp;${oferta.cantidadCuponesOferta}
							  	</div>
							  	<div class="card-body">
							  		<table class="table table-striped table-hover" id="myTable">
		                                <thead class="table-dark text-center">
		                                    <tr>
		                                        <th scope="col">#</th>
		                                        <th scope="col">Codigo promocional</th>
		                                        <th scope="col">Fecha de Vencimiento</th>
		                                        <th scope="col">Estado</th>
		                                    </tr>
		                                </thead>
		                                <tbody class="text-center">
		                                	<c:forEach items="${requestScope.cupones}" var="cupon">
		                                		<tr>
			                                        <th scope="row">${cupon.cuponId}</th>
			                                        <td>${cupon.codigoPromocional}</td>
			                                        <td>${cupon.fechaVencimiento}</td>
			                                        <td>
			                                        	<c:if test="${cupon.estado == 1}">
			                                        		<span class="text-success">
			                                        			<strong>Disponible</strong>
			                                        		</span>
			                                        	</c:if>
			                                        	<c:if test="${cupon.estado == 2}">
			                                        		<span class="text-primary">
			                                        			<strong>Adquirido</strong>
			                                        		</span>
			                                        	</c:if>
			                                        	<c:if test="${cupon.estado == 3}">
			                                        		<span class="text-warning">
			                                        			<strong>Usado</strong>
			                                        		</span>
			                                        	</c:if>
			                                        	<c:if test="${cupon.estado == 4}">
			                                        		<span class="text-danger">
			                                        			<strong>Vencido</strong>
			                                        		</span>
			                                        	</c:if>
			                                        </td>
			                                    </tr>
		                                	</c:forEach>
		                                </tbody>
		                            </table>
							  	</div>
						  	</div>
						</c:if>
                    </div>
                </div>
            </section>
        </main>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="//cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
        <script src="https://use.fontawesome.com/7e8731e53c.js"></script>
        <script src="${pageContext.request.contextPath}/public/js/dataTable.js"></script>
    </body>
</html>
