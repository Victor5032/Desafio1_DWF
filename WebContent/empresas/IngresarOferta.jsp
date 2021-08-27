<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Ingresar Nueva Oferta</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
<%@ include file="navbar.jsp"%>
    <div class="container">
        <div class="row">
            <div class="col-12 mt-5">
                <h3 class="text-center">Registro para Nuevas Ofertas</h3>
            </div>
            <div class="col-12 mt-5">
                <div class="d-flex justify-content-center align-items-center">
                    <form class="w-50 shadow-lg p-3 mb-5 bg-white rounded p-5" action="${pageContext.request.contextPath}/ofertas.do" method="POST">
                        <input value="insert" name="op" hidden>
                        <input value="${sessionScope.usser}" name="empresaID" hidden>
                        <div class="row">
                            <div class="col-8 mt-3">
                                <span style="text-align: center;">Titulo</span>
                                <input type="text" name="ofertaTitulo" class="form-control" id="tituloOferta" required>
                                
                            </div>
                            <div class="col-12 mt-3">
                                <span>Descripcion</span>
                                <textarea class="form-control" name="ofertaDescripcion" id="descripcionOferta" cols="10" rows="5"
                                required></textarea>
                            </div>

                            <div class="col-6 mt-3">
                                <span>Precio Regular</span>
                                <input class="form-control" type="number" name="regularOferta" min="0" step="0.01" required id="precioRegular">
                            </div>
                            
                            <div class="col-6 mt-3">
                                <span>Precio Oferta</span>
                                <input class="form-control" type="number" name="ofertaOferta" min="0" step="0.01" required id="precioOferta">
                            </div>
                            <div class="col-6 mt-3">
                                <span>Fecha Inicio</span>
                                <input type="date" name="ofertaInicio" class="form-control" required>
                            </div>

                            <div class="col-6 mt-3">
                                <span>Fecha Final</span>
                                <input class="form-control" type="date" name="ofertaFinal"  required="" id="fechaFinal" />

                            </div>
                            <div class="col-6 mt-3">
                                <span>Cantidad de Cupones</span>
                                <input class="form-control" name="ofertaCantidadCupones"  type="text" id="cantidadOfertas" required>
                            </div>
                            <div class="col-6 mt-3">
                                <span>Extras</span>
                                <input class="form-control" name="ofertasExtras" type="text" id="extrasOfertas" >
                            </div>
                        </div>
                        <div class="col-10 m-3">
                            <div class="text-center">
                                <input class="btn btn-success mt-2" type="submit" value="Registrar" />
                                <a href="${pageContext.request.contextPath}/empresas.do?op=perfilEmpresa" class="btn btn-danger mt-2">Cancelar</a>
                            </div>
                        </div>
                           
                        

                    </form>
                </div>
            </div>
        </div>


</body>

</html>