<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="UTF-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<title>Detalles del rubro - Administrador</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
		<link href="//cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css" rel="stylesheet" type=text/css>
    </head>
    <body>
        <%@ include file="menu.jsp" %>
        <main>
            <section class="py-5">
                <div class="container">
                    <div class="pb-3">
                        <h3 class="text-center">Detalles del rubro</h3>
                    </div>
                    <div class="pb-3">
                        <div>
                            <a href="${pageContext.request.contextPath}/admin.do?op=headings" class="btn btn-primary">Regresar</a>
                        </div>
                    </div>
                    <c:if test="${param.message == 2}">
                    	<div class="alert alert-success alert-dismissible d-flex align-items-center" role="alert">
	                    	<div>	
								Rubro actualizado
							</div>
							<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
						</div>
                    </c:if>
                    <c:if test="${param.message == 1}">
                    	<div class="alert alert-success alert-dismissible d-flex align-items-center" role="alert">
	                    	<div>	
								Rubro ingresado exitosamente
							</div>
							<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
						</div>
                    </c:if>
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <h5 class="card-header"><i>Rubro</i></h5>
                                <div class="card-body">
                                    <p class="card-text"><strong>Rubro:&nbsp;</strong>${rubro.rubro}</p>
                                    <p class="card-text"><strong>Fecha de registro:&nbsp;</strong>${rubro.fecha_registro}</p>
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
    </body>
</html>
