<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Editar Ofertas</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
    <div class="container">
        <div class="row">
            <div class="col-12 mt-5">
                <h3 class="text-center">Editar Ofertas</h3>
            </div>
            <div class="col-12 mt-5">
                <div class="d-flex justify-content-center align-items-center">
                    <form class="w-50 shadow-lg p-3 mb-5 bg-white rounded p-5" action="#" method="POST">
                        <div class="row">
                            <div class="col-8 mt-3">
                                <span style="text-align: center;">Titulo</span>
                                <input type="text" class="form-control" id="tituloOferta" required>
                            </div>
                            <div class="col-12 mt-3">
                                <span>Descripcion</span>
                                <textarea class="form-control " name="detalles" id="descripcionOferta" cols="10" rows="5"
                                required></textarea>
                            </div>

                            <div class="col-6 mt-3">
                                <span>Precio Regular</span>
                                <input class="form-control" type="number" name="total" min="0" step="0.01" required id="precioRegular">
                            </div>
                            
                            <div class="col-6 mt-3">
                                <span>Precio Oferta</span>
                                <input class="form-control" type="number" name="total" min="0" step="0.01" required id="precioOferta">
                            </div>
                            <div class="col-6 mt-3">
                                <span>Fecha Inicio</span>
                                <input type="datetime-local" class="form-control" id="fechaInicio" required>
                            </div>

                            <div class="col-6 mt-3">
                                <span>Fecha Final</span>
                                <input class="form-control" type="datetime-local" name="fechaFinal" required="" id="fechaFinal" />

                            </div>
                            <div class="col-6 mt-3">
                                <span>Cantidad de Cupones</span>
                                <input class="form-control" type="text" id="cantidadOfertas" required>
                            </div>
                            <div class="col-6 mt-3">
                                <span>Extras</span>
                                <input class="form-control" type="text" id="extrasOfertas" required>
                            </div>
                            <div class="col-12 mt-3">
                                <span>Observaciones</span>
                                <input class="form-control" type="text" id="observacionOfertas" required>
                            </div>
                             <div class="col-6 mt-3">
                                <span>Estado</span>
                                <input class="form-control" type="text" id="estadoOfertas" required>
                            </div>

                        </div>
                        <div class="col-10 m-3">
                            <div class="text-center">
                                <input class="btn btn-success mt-2" type="submit" value="Editar" />
                            </div>
                        </div>
                           
                        

                    </form>
                </div>
            </div>
        </div>


</body>

</html>