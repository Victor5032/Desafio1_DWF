<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.25/css/dataTables.bootstrap5.min.css">
    <title>Cupones vencidos</title>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-12 mt-5">
                <h3 class="text-center">Cupones vencidos</h3>
            </div>
            <div class="col-12 mt-5 mb-5">
                <div class="d-flex justify-content-center align-items-center">
                    <div class="w-50">
                        <table id="tablaCuponesVencidos" class="table table-striped shadow-lg p-3 mb-5 bg-white rounded">
                            <thead>
                                <tr>
                                    <th>Codigo promocional</th>
                                    <th>Fecha de vencimiento</th>
                                    <th>Estado</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>DWF1234</td>
                                    <td>12/12/2021</td>
                                    <td>Vencido</td>
                                </tr>
                                <tr>
                                    <td>DWF1234</td>
                                    <td>12/12/2021</td>
                                    <td>Vencido</td>
                                </tr>
                                <tr>
                                    <td>DWF1234</td>
                                    <td>12/12/2021</td>
                                    <td>Vencido</td>
                                </tr>
                                <tr>
                                    <td>DWF1234</td>
                                    <td>12/12/2021</td>
                                    <td>Vencido</td>
                                </tr>
                                <tr>
                                    <td>DWF1234</td>
                                    <td>12/12/2021</td>
                                    <td>Vencido</td>
                                </tr>
                                <tr>
                                    <td>DWF1234</td>
                                    <td>12/12/2021</td>
                                    <td>Vencido</td>
                                </tr>
                                <tr>
                                    <td>DWF1234</td>
                                    <td>12/12/2021</td>
                                    <td>Vencido</td>
                                </tr>
                                <tr>
                                    <td>DWF1234</td>
                                    <td>12/12/2021</td>
                                    <td>Vencido</td>
                                </tr>
                                <tr>
                                    <td>DWF1234</td>
                                    <td>12/12/2021</td>
                                    <td>Vencido</td>
                                </tr>
                                <tr>
                                    <td>DWF1234</td>
                                    <td>12/12/2021</td>
                                    <td>Vencido</td>
                                </tr>
                                <tr>
                                    <td>DWF1234</td>
                                    <td>12/12/2021</td>
                                    <td>Vencido</td>
                                </tr>
                                <tr>
                                    <td>DWF1234</td>
                                    <td>12/12/2021</td>
                                    <td>Vencido</td>
                                </tr>
                                <tr>
                                    <td>DWF1234</td>
                                    <td>12/12/2021</td>
                                    <td>Vencido</td>
                                </tr>
                                <tr>
                                    <td>DWF1234</td>
                                    <td>12/12/2021</td>
                                    <td>Vencido</td>
                                </tr>
                                <tr>
                                    <td>DWF1234</td>
                                    <td>12/12/2021</td>
                                    <td>Vencido</td>
                                </tr>
                                <tr>
                                    <td>DWF1234</td>
                                    <td>12/12/2021</td>
                                    <td>Vencido</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.25/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function() {
        $('#tablaCuponesVencidos').DataTable();
    });
    var table = $('#tablaCuponesVencidos').DataTable({
    language: {
        "decimal": "",
        "emptyTable": "No hay información",
        "info": "Mostrando _START_ a _END_ de _TOTAL_ Entradas",
        "infoEmpty": "Mostrando 0 to 0 of 0 Entradas",
        "infoFiltered": "(Filtrado de _MAX_ total entradas)",
        "infoPostFix": "",
        "thousands": ",",
        "lengthMenu": "Mostrar _MENU_ Entradas",
        "loadingRecords": "Cargando...",
        "processing": "Procesando...",
        "search": "Buscar:",
        "zeroRecords": "Sin resultados encontrados",
        "paginate": {
            "first": "Primero",
            "last": "Ultimo",
            "next": "Siguiente",
            "previous": "Anterior"
        }
    },
});
</script>
</html>