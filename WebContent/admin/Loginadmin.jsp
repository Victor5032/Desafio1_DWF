<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login de administradores</title>
<link href="WebContent/admin/estiloadmin.css" rel="stylesheet" type=text/css>
</head>
<body>

<form action="menu.jsp" method="post">
<div class="contenedortotal" style="background-color: silver; border-radius: 10px; padding: 25px;
    margin-top: 50px;
    margin-right: 35%;
    margin-left: 35%;">
	<div class="parrafo">
	<img src="admin/admin.jpg" hidden="80" width="80">
	<p style="text-align:center; font-size: 30px;"><strong>Bienvenido Administrador</strong></p>
	</div>
	<div class="usuario" style="text-align: center;">
	<label style="font-size: 22px;" class="label">Usuario:</label>
	<input class="usuarioinput" type="text" placeholder="Ingrese el usuario dado" name="txtnombre">
	</div>
	<div class="password" style="text-align: center;" class="password">
	<label style="font-size: 22px;" class="label">Contraseña:</label>
		<input class="passwordinput" type="text" placeholder="Ingrese la contraseña" name="txtpassword">
	</div>
	<br>
	<div style="text-align:center;" class="botonenviar">
		<input class="btnenviar" type="submit" name="accion" value="Registrarse" style="    height:30px; width:100px;">
	</div>
</div>
</form>

</body>
</html>