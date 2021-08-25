<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/admin.do?op=home">Administrador</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-link" href="${pageContext.request.contextPath}/admin.do?op=home">Ofertas</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/admin.do?op=headings">Rubros</a>
            </div>
        </div>
        <div class="d-flex">
            <div class="navbar-nav">
                <a class="nav-link" href="${pageContext.request.contextPath}/admin.do?op=profile">Activo como: <strong><c:out value="${cookie['usuario'].getValue()}" /></strong></a>
                <a class="nav-link" href="${pageContext.request.contextPath}/admin.do?op=logout">Cerrar sesión</a>
            </div>
        </div>
    </div>
</nav>
