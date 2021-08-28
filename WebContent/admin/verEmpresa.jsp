<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="UTF-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<title>Detalles de la empresa - Administrador</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
		<link href="//cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css" rel="stylesheet" type=text/css>
    </head>
    <body>
        <%@ include file="menu.jsp" %>
        <main>
            <section class="py-5">
                <div class="container">
                    <div class="pb-3">
                        <h3 class="text-center">Detalles de la empresa</h3>
                    </div>
                    <div class="pb-3">
                        <div>
                            <a href="${pageContext.request.contextPath}/admin.do?op=empresas" class="btn btn-primary">Regresar</a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <h5 class="card-header"><i>Detalles de la empresa</i></h5>
                                <div class="card-body">
                                	<p class="card-text">
                                		<center>
                                			<h4>${empresa.nombreEmpresa}</h4>
                                		</center>
                                	</p>
                                    <p class="card-text"><strong>Código:&nbsp;</strong>${empresa.codigo_empresa}</p>
                                    <p class="card-text"><strong>Dirección:&nbsp;</strong>${empresa.direccionEmpresa}</p>
                                   	<br>
                                   	<div class="row">
                                   		<div class="col-6">
                                   			<p class="card-text text-center">
                                    			<strong>Rubro:&nbsp;</strong><span>${empresa.rubroNombre}</span>
                                    		</p>
                                   		</div>
                                   		<div class="col-6">
                                   			<p class="card-text text-center">
                                    			<strong>Comisión:&nbsp;</strong><span>${empresa.comisionEmpresa}</span>
                                    		</p>
                                   		</div>
                                   	</div>
                                    <br>
                                   	<div class="row">
                                   		<div class="col-4">
                                   			<p class="card-text text-center">
                                    			<strong>Contacto:&nbsp;</strong><span>${empresa.contactoEmpresa}</span>
                                    		</p>
                                   		</div>
                                   		<div class="col-4">
                                   			<p class="card-text text-center">
                                    			<strong>Telefono:&nbsp;</strong><span>${empresa.telefonoEmpresa}</span>
                                    		</p>
                                   		</div>
                                   		<div class="col-4">
                                   			<p class="card-text text-center">
                                    			<strong>Correo:&nbsp;</strong><span>${empresa.correoEmpresa}</span>
                                    		</p>
                                   		</div>
                                   	</div>
                                </div>
                             </div>
                        </div>
                    </div>
                    <br>
                    <div class="pb-3">
                        <h3 class="text-center">Ofertas de la empresa</h3>
                    </div>
                    <div class="row">
                    	<div class="col-12">
                    		<table class="table table-striped table-hover" id="myTable">
                                <thead class="table-dark text-center">
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Oferta</th>
                                        <th scope="col">Cantidad de cupones</th>
                                        <th scope="col">Fecha de inicio</th>
                                        <th scope="col">Fecha de finalización</th>
                                        <th scope="col"></th>
                                    </tr>
                                </thead>
                                <tbody class="text-center">
                                	<c:forEach items="${requestScope.ofertas}" var="oferta">
                                		<tr>
	                                        <th scope="row">${oferta.idOferta}</th>
	                                        <td>${oferta.tituloOferta}</td>
	                                        <td>${oferta.cantidadCuponesOferta}</td>
	                                        <td>${oferta.fechaInicioOferta}</td>
	                                        <td>${oferta.fechaFinOferta}</td>
	                                        <td>
	                                            <div class="row">
	                                                <div class="col-12">
	                                                    <a href="${pageContext.request.contextPath}/admin.do?op=details&codigo=${oferta.idOferta}" class="btn btn-info">Ver oferta</a>
	                                                </div>
	                                            </div>
	                                        </td>
	                                    </tr>
                                	</c:forEach>
                                </tbody>
                            </table>
                    	</div>
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
