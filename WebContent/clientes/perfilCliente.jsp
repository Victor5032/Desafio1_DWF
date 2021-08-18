<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <title>Perfil del cliente</title>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-12 mt-5">
                <h3 class="text-center">Perfil del cliente</h3>
            </div>
            <div class="col-12 mt-5">
                <div class="d-flex justify-content-center align-items-center">
                    <form class="w-50 shadow-lg p-3 mb-5 bg-white rounded p-5">
                        <div class="row">
                            <div class="col-6 mt-3">
                                <span>Nombres</span>
                                <input type="text" class="form-control" id="nombrePerfilClientes" disabled>
                            </div>
                            <div class="col-6 mt-3">
                                <span>Apellidos</span>
                                <input type="text" class="form-control" id="apellidosPerfilClientes" disabled>
                            </div>
                            <div class="col-12 mt-3">
                                <span>Direccion</span>
                                <input type="text" class="form-control" id="direccionPerfilClientes" disabled>
                            </div>
                            <div class="col-6 mt-3">
                                <span>Telefono</span>
                                <input type="text" class="form-control" id="telefonoPerfilClientes" disabled>
                            </div>
                            <div class="col-6 mt-3">
                                <span>DUI</span>
                                <input type="text" class="form-control" id="duiPerfilClientes" disabled>
                            </div>
                            <div class="col-6 mt-3">
                                <span>Correo</span>
                                <input type="email" class="form-control" id="correoPerfilClientes" disabled>
                            </div>
                            <div class="col-6 mt-3">
                                <span>Contraseña</span>
                                <input type="password" class="form-control" id="contraseñaPerfilClientes" disabled>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</html>
