<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="UTF-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<title>Datos del cliente - Administrador</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
		<link href="//cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css" rel="stylesheet" type=text/css>
    </head>
    <body>
        <%@ include file="menu.jsp" %>
        <main>
            <section class="py-5">
                <div class="container">
                    <div class="pb-3">
                        <h3 class="text-center">Datos del cliente</h3>
                    </div>
                    <div class="pb-3">
                        <div>
                            <a href="${pageContext.request.contextPath}/admin.do?op=clientes" class="btn btn-primary">Regresar</a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                            	<h5 class="card-header"><i>Regitrado: ${cliente.fechaRegistro}</i></h5>
                                <div class="card-body">
                                	<p class="card-text">
                                		<center>
                                			<h4>${cliente.nombres}&nbsp;${cliente.apellidos}</h4>
                                		</center>
                                	</p>
                                    <br>
                                   	<div class="row">	
                                   		<div class="col-6">
                                   			<p class="card-text text-center">
                                    			<strong>Direccion:&nbsp;</strong><span>${cliente.direccion}</span>
                                    		</p>
                                   		</div>
                                   		<div class="col-6">
                                   			<p class="card-text text-center">
                                    			<strong>DUI:&nbsp;</strong><span>${cliente.dui}</span>
                                    		</p>
                                   		</div>
                                   	</div>
                                   	<br>
                                   	<div class="row">	
                                   		<div class="col-6">
                                   			<p class="card-text text-center">
                                    			<strong>Telefono:&nbsp;</strong><span>${cliente.telefono}</span>
                                    		</p>
                                   		</div>
                                   		<div class="col-6">
                                   			<p class="card-text text-center">
                                    			<strong>Correo electronico:&nbsp;</strong><span>${cliente.email}</span>
                                    		</p>
                                   		</div>
                                   	</div>
                                </div>
                                <c:if test="${cliente.estadoVerificacion == 1}">
                            		<div class="card-footer text-center bg-success text-white">
							    		<strong>Cliente verificado</strong>
							  		</div>
                            	</c:if>
                                <c:if test="${cliente.estadoVerificacion == 0}">
                            		<div class="card-footer text-center bg-warning">
							    		<strong>Cliente no verificado</strong>
							  		</div>
                            	</c:if>
                             </div>
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
