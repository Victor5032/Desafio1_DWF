<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="UTF-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<title>Cambiar contraseña - Administrador</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
		<link href="//cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css" rel="stylesheet" type=text/css>
    </head>
    <body>
        <%@ include file="menu.jsp" %>
        <main>
            <section class="py-5">
                <div class="container">
                    <div class="pb-3">
                        <h3 class="text-center">Mi perfil</h3>
                    </div>
                    <div class="pb-3">
                        <div>
                            <a href="${pageContext.request.contextPath}/admin.do" class="btn btn-primary">Regresar</a>
                        </div>
                    </div>
                    <div class="row">
                    	<div class="col-12">
                    		<nav class="nav nav-pills nav-justified">
                                <a class="nav-link" aria-current="page" href="admin.do?op=profile">Mis datos</a>
                                <a class="nav-link active" aria-current="page" href="admin.do?op=password">Cambiar mi contraseña</a>
                            </nav>
                    	</div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-body">
                                	<form method="POST" action="${pageContext.request.contextPath}/admin.do">
                                		<input type="hidden" name="op" id="op" value="change-password" >
									  <div class="mb-3">
									  	<div class="row">
										  	<div class="col-12">
										  		<label for="exampleInputEmail1" class="form-label">Contraseña actual:</label>
	    										<input type="text" class="form-control" id="actual" name="actual" value="${usuario.nombre}">
										  	</div>
										  </div>
									  </div>
									  <div class="mb-3">
									  	<div class="row">
										  	<div class="col-6">
										  		<label for="exampleInputEmail1" class="form-label">Nueva contraseña:</label>
	    										<input type="text" class="form-control" id="nueva" name="nueva" value="${usuario.nombre}">
										  	</div>
										  	<div class="col-6">
										  		<label for="exampleInputEmail1" class="form-label">Confirmar nueva contraseña:</label>
	    										<input type="text" class="form-control" id="confirmar" name="confirmar" value="${usuario.apellido}">
										  	</div>
										  </div>
									  </div>
									  <center>
									  	<button type="submit" class="btn btn-warning">Actualizar contraseña</button>
									  </center>
									</form>
                                </div>
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
