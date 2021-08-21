<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form role="form" action="${contextPath}/Desafio1_DWF/empresas.do" method="POST">	
	<input type="hidden" name="op" value="tokenRequest"> <input
			type="text" class="form-control" name="nombreEmpresa" id="codigo">
		<input type="text" class="form-control" name="direccionEmpresa"
			id="codigo"> <input type="text" class="form-control"
			name="contactoEmpresa" id="codigo"> <input type="text"
			class="form-control" name="telefonoEmpresa" id="codigo"> <input
			type="text" class="form-control" name="correoEmpresa" id="codigo">
		<input type="text" class="form-control" name="empresaPassword"
			id="codigo"> <input type="submit" class="btn btn-info"
			value="Guardar" name="Guardar">
	</form>
</body>
</html> 