<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <title>Listado de Empresas</title>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-12 mt-5">
                <h3 class="text-center">Perfil de General Empresas</h3>
            </div>
            <div class="col-12 mt-5 mb-5">
                <div class="d-flex justify-content-center align-items-center">
                    <div class="w-30">
                        <table id="listaEmpresas"  class="table table-striped shadow-lg p-3 mb-5 bg-white rounded">
                                <tr>
                                    <th>ID Empresa</th>
                                    <th>Codigo</th>
                                    <th>Nombre Empresa</th>
                                    <th>Contacto</th>
                                    <th>Direccion</th>
                                    <th>Telefono</th>
                                    <th>Correo</th>
                                    <th>Contraseña Empresa</th>
                                    <th>ID Rubro</th>
                                    <th>Comision</th>
                                    <th>Fecha Registro</th>
                                    <th>Estado</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>ACM1PTE</td>
                                    <td>UDB</td>
                                    <td>Contacto 1</td>
                                    <td>Direccion 1</td>
                                    <td>2020-2020</td>
                                    <td>empresa@gmail.com</td>
                                    <td>TejaditaDios</td>
                                    <td>1</td>
                                    <td>25.00</td>
                                    <td>25/05/2020</td>
                                    <td>Revision</td>
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
        $('#listaEmpresas').DataTable();
    });
   
</script>
</html>