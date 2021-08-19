<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Inicio de Sesion</title>
</head>
<body>
 <div class="container">
        <div class="row">
            <div class="col-12 mt-5">
                <div class="d-flex justify-content-center align-items-center">
                    <form class="w-25 shadow-lg p-3 mb-5 bg-white rounded p-5">
                        <div class="form-group mt-3">
                            <h3>Iniciar Sesion</h3>
                            <span>Usuario</span>
                            <input type="text" class="form-control" required placeholder="Ingresar Usuario">
                        </div>
                        <div class="form-group mt-3">
                            <span>Contraseña</span>
                            <input type="password" class="form-control"required placeholder="Ingresar su Contraseña">
                        </div>
                        <div class="text-center mt-5"><button type="submit" class="btn btn-primary">Ingresar</button></div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>