<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <title>Oferta de cupones</title>
</head>
<body>
    <div class="container mt-5">
        <div class="row">
            <div class="col-12 shadow-lg p-3 mb-5 rounded">
                <h3 class="text-center mt-5 mb-5">Oferta de cupones</h3>
                <div class="container">
                    <div class="row">
                       <c:forEach items="${requestScope.ofertasEmpresa}" var="ofertacupon">
                        <div class="col-4 shadow-sm p-3 mb-5 rounded">
                            <div class="card text-center">
                                <div class="card-header">
                                  ${ofertacupon.tituloOferta}
                                </div>
									
									<div class="card-body">
                                  <p class="card-text">${ofertacupon.descripcionOferta}</p>
                                  <p class="">${ofertacupon.precio_ofertaOferta}</p>
                                  <p class="card-text"><strike>${ofertacupon.precioRegularOferta}</strike></p>
                                  <p class="card-text">${ofertacupon.cantidadCuponesOferta}</p>
                                  <a href="${pageContext.request.contextPath}/ofertacupon.do?op=confirmar&idoferta=${ofertacupon.idOferta}&idempresa=${ofertacupon.idEmpresaOferta}"
									class="btn btn-primary">Adquirir</a>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</html>