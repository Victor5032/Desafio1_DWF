<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <title>Listado de Ofertas</title>
</head>

<body>
    <div class="container">
        <div class="row">
            <div class="col-12 mt-5">
                <h3 class="text-center">Lista de General de Ofertas</h3>
            </div>
            <div class="col-12 mt-5 mb-5">
                <div class="d-flex justify-content-center align-items-center">
                    <div class="w-30">
                        <table id="tablaOfertas"  class="table table-striped shadow-lg p-3 mb-5 bg-white rounded">
                                <tr>
                                    <th>Titulo</th>
                                    <th>Descripcion</th>
                                    <th>Precio Regular</th>
                                    <th>Precio Oferta</th>
                                    <th>Fecha Inicio</th>
                                    <th>Fecha Final</th>
                                    <th>Cantidad Cupones</th>
                                    <th>Extras</th>
                                    <th>Observaciones</th>
                                    <th>Estado</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Oferta 1</td>
                                    <td>Dulces</td>
                                    <td>0.50</td>
                                    <td>0.25</td>
                                    <td>25/02/2021</td>
                                    <td>28/02/2021</td>
                                    <td>2</td>
                                    <td>3</td>
                                    <td>Precio Fijo</td>
                                    <td>Por Finalizar</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.25/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function() {
        $('#tablaCuponesUsados').DataTable();
    });
   
</script>
</html>