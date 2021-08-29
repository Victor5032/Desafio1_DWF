<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">

<title>Detalle de Ofertas</title>
</head>
<body>
<%@ include file="navbarCliente.jsp"%>
	<div class="container mt-5 mb-5">
		<div class="row">
			<div class="col-md-6 shadow-lg rounded mt-5">
				<h3 class="text-center mt-5 mb-5">Detalles de oferta</h3>
				<div class="card text-center w-100">
					<div class="card-header bg-transparent border-success">${detallesCupones.tituloOferta}</div>
					<div class="card-body text-primary ">
						<img src="https://animalcrossinglife.com/wp-content/uploads/2020/10/coupon-di-sahara-icona-assets-acnh-animal-crossing-new-horizons.png">
						<div class="container">
							<div class="row">
								<div class="col-6 p-3">
									<p class="card-text">Codigo de cupon: <br> ${cuponDisponible}</p>
								</div>
								<div class="col-6 p-3">
									<p class="card-text">Nombre de empresa: <br> ${empresa.nombreEmpresa}</p>
								</div>
								<div class="col-12 p-3">
									<p class="card-text">Descripcion: <br> ${detallesCupones.descripcionOferta}</p>
								</div>
								<div class="col-6 p-3">
									<p class="card-text">Precio regular: <br> <strike>$${detallesCupones.precioRegularOferta}</strike></p>
								</div>
								<div class="col-6 p-3">
									<p class="card-text">Precio oferta: <br> $${detallesCupones.precio_ofertaOferta}</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
            <div class="col-md-6 mt-5 shadow-lg rounded">
				<h3 class="text-center mt-5 mb-5">Metodo de pago</h3>
                <div class="d-flex justify-content-center align-items-center">
                    <form class="w-100 shadow-lg p-3 mb-5 bg-white rounded p-5" method="POST" action="">
						<input type="hidden" name="cupon" id="cupon" value="${cuponId}">
						<input type="hidden" name="idCliente" id="idCliente" value="${sessionScope.usser}">
						<input type="hidden" name="ultimos4" id="ultimos4" value="">
                        <div class="row">
                            <div class="col-6 mt-3">
                                <span>Numero de tarjeta</span>
                                <input type="text" class="form-control" id="numeroTarjeta" name="numeroTarjeta" value="">
                            </div>
                            <div class="col-6 mt-3">
                                <span>Fecha de expiracion (mm/aa)</span>
                                <input type="text" class="form-control" id="fechaExpiracion" name="fechaExpiracion" value="">
                            </div>
                            <div class="col-6 mt-3">
                                <span>Titular de la tarjeta</span>
                                <input type="text" class="form-control" id="titularTarjeta" name="titularTarjeta" value="">
                            </div>
                            <div class="col-6 mt-3">
                                <span>Codigo de seguridad</span>
                                <input type="password" class="form-control" id="codigoSeguridad" name="codigoSeguridad" value="">
                            </div>
                            <div class="text-center mt-5"><button type="submit" class="btn btn-warning">Realizar pago</button></div>
                        </div>
                    </form>
                </div>
            </div>
		</div>
	</div>
	</div>
</body>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js"></script>

<script>
	//Input de la tarjeta ingresada por el cliente
	var campoTarjeta = document.getElementById("numeroTarjeta");

	//Input hidden donde se ingresan los ultimos 4 digitos de la tarjeta
	var ultimos4 = document.getElementById("ultimos4");

	campoTarjeta.onchange = function(){
		var numTarjeta = campoTarjeta.value;
		var cadena = numTarjeta.split("-");
		var cuatroUltimos = cadena[3];
		ultimos4.value = cuatroUltimos;
	}
    window.onload = function(){
        $('#numeroTarjeta').mask('0000-0000-0000-0000');
        $('#fechaExpiracion').mask('00/00');
        $('#codigoSeguridad').mask('000');
    }


</script>
</html>


