<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.87.0">
    <title>Inicio</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/carousel/">

    

    <!-- Bootstrap core CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/public/css/carousel.css" rel="stylesheet">
  </head>
  <body>
    
<header>
  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">CuponEpic</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav me-auto mb-2 mb-md-0">
          <li class="nav-item">
                </li>
          <li class="nav-item">
                     </li>
          <li class="nav-item">
                    </li>
        </ul>
        <form class="d-flex">
        <a href="${pageContext.request.contextPath}/clientes/loginClientes.jsp" class="btn btn-danger">Iniciar Sesion</a>
        </form>
      </div>
    </div>
  </nav>
</header>

<main>

  <div id="myCarousel" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-indicators">
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
      <div class="carousel-item active">
        <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#024059"/></svg>

        <div class="container">
               <div class="carousel-caption text-start">
                 <img src="https://as.com/meristation/imagenes/2019/12/20/noticias/1576844850_646679_1576845197_sumario_normal.jpg">
            <h1>¡No te lo Pierdas!</h1>
            <p>Si quieres adquirir cupones de distintas empresas. !Unetenos y Crea tu cuenta!<br>Dando click en el Boton de "Registrarme"</p>
                 <a href="${pageContext.request.contextPath}/clientes/registroClientes.jsp" class="btn btn-lg btn-primary">Registrarme</a>
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <svg class="bd-placeholder-img" width="400%" height="300%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#024059" /></svg>
		
        <div class="container">
          <div class="carousel-caption">
          <img src="https://www.vendesfacil.com/wp-content/uploads/2017/09/Vender-m%C3%A1s-por-medio-de-cupones.jpg">
            <h1>¡APROVECHA NO TE QUEDES SIN TU CUPON!</h1>
                       
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#024059"/></svg>

        <div class="container">
          <div class="carousel-caption text-end">
  <a href="https://ibb.co/TY1k0ZS"><img src="https://i.ibb.co/gmd3WGp/Cupon-Epic-Logo-Twitter-Header-Photo-1500x500.png" alt="Cupon-Epic-Logo-Twitter-Header-Photo-1500x500" border="0"></a>
            <h1>¡Que esperas para registrarte y unirte a la familia de CuponEpic!</h1>
            <p>Mantente informado acerca de todas las nuevas ofertas de cupones. <br> No olvides seguirnos en nuestras redes sociales para que no te pierdas nada y aproveches.</p>
            
          </div>
        </div>
      </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#myCarousel" data-bs-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#myCarousel" data-bs-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Next</span>
    </button>
  </div>


  <!-- Marketing messaging and featurettes
  ================================================== -->
  <!-- Wrap the rest of the page in another container to center all the content. -->

  <div class="container marketing">

    <!-- START THE FEATURETTES -->

    <hr styclass="featurette-divider">

    <div class="row featurette">
      <div class="col-md-7">
        <h2 class="featurette-heading">Cupon Epic</h2>
        <p class="lead">Tu sitio web de confianza, encuentra aca diferentes ofertas de cupones para que puedas canjearlos en las diferentes empresas.<br>Debes registrarte con una cuenta de correo para que seas parte de CUPONEPIC. Al registrarte tendrás grandes oportunidades de enterarte de las fabulosas ofertas que te ofreceremos.</p>
      </div>
      <div class="col-md-5">
      <img src="https://st2.depositphotos.com/4827821/7585/v/600/depositphotos_75850155-stock-illustration-online-store-logo-design-vector.jpg" class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto" width="500" height="500" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 500x500" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#eee"/>
      
       
      </div>
    </div>
    <hr class="featurette-divider">
    <div class="row featurette">
      <div class="col-md-7 order-md-2">
      
        <h2 class="featurette-heading">¿Quienes Somos?</h2>
        <p class="lead">Cupon Epic es una empresa que te ofrece las mejores opciones, con nuevas propuestas cada día, sobre qué hacer, ver, comer, disfrutar  y comprar.<br>Nuestro objetivo es ahorrarte tiempo, y dinero; y que puedas elegir y comprar cómodamente desde tu oficina, tu casa.<br>Nuestros descuentos son exclusivos, y nuestros socios sólo ofrecen productos de calidad y precios únicos.
</p>
      </div>
            <div class="col-md-5 order-md-1">
            <img src="https://picsvg.com/svg/ynjRAo.jpg" class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto" width="400" height="400" xmlns="http://www.w3.org/2000/svg" role="img"  aria-label="Placeholder: 500x500" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="300" height="300" fill="#eee"/></img>
                  </div>
    </div>
    <hr class="featurette-divider">

    <div class="row featurette">
      <div class="col-md-7">
        <h2 class="featurette-heading">Visitanos</h2>
        <p class="lead">Buscanos en nuestras redes sociales como CuponEpic en todas las plataformas Facebook, Twitter, Instagram y para WhatsApp Agreganos: +503 7520-8989.<br>No te pierdas de todas la novedades o noticias que agregamos a nuestras redes sociales</p>
      </div>
      <div class="col-md-5">
      <img src="https://conectamostuempresa.com/wp-content/uploads/2020/05/13832.jpg" class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto" width="500" height="500" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 500x500" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#eee"/>
      
       
      </div>
    </div>

    <hr class="featurette-divider">

    <!-- /END THE FEATURETTES -->

  </div><!-- /.container -->


  <!-- FOOTER -->
  <footer class="container">
    <p class="float-end"><a href="#">Regresar</a></p>
    <p>&copy; Universidad Don Bosco.2021 &middot; <a href="#">Privacidad</a> &middot; <a href="#">Terminos</a></p>
  </footer>
</main>


    <script src="${pageContext.request.contextPath}/public/js/bootstrap.bundle.min.js"></script>

      
  </body>
</html>
