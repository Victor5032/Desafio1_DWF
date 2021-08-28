-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-08-2021 a las 17:14:13
-- Versión del servidor: 10.4.19-MariaDB
-- Versión de PHP: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cupones_dwf`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `activarCliente` (IN `_clienteID` INT, IN `_estado` INT)  UPDATE `clientes` SET `verificacion`= _estado WHERE clientes.cliente_id = _clienteID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `actualPassword` (IN `_password` VARCHAR(255), IN `_empresaID` INT)  SELECT empresas.empresa_id FROM `empresas` WHERE empresas.empresa_id = _empresaID and empresas.empresa_password = _password$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `correoClienteExistente` (IN `_correoCliente` VARCHAR(100))  SELECT clientes.cliente_id from clientes WHERE clientes.email = _correoCliente$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `correoExistente` (IN `_correoEmpresa` TEXT)  SELECT empresas.empresa_id FROM empresas WHERE empresas.correo = _correoEmpresa$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteOferta` (IN `_ofertaID` INT)  DELETE FROM `ofertas` WHERE ofertas.oferta_id = _ofertaID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarClientePendienteVerificacion` (IN `_nombres` VARCHAR(100), IN `_apellidos` VARCHAR(150), IN `_telefono` VARCHAR(15), IN `_direccion` TEXT, IN `_dui` VARCHAR(15), IN `_email` VARCHAR(100), IN `_password` VARCHAR(150), IN `_verificaion` INT, IN `_estado` INT)  INSERT INTO `clientes`(`nombres`, `apellidos`, `telefono`, `direccion`, `dui`, `email`, `password`, `verificacion`, `estado`) VALUES (_nombres,_apellidos,_telefono,_direccion,_dui,_email,_password,_verificaion,_estado)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarEmpresa` (IN `_codigo_empresa` VARCHAR(15), IN `_nombre_empresa` VARCHAR(200), IN `_direccion_empresa` VARCHAR(120), IN `_contacto_empresa` VARCHAR(80), IN `_telefono_empresa` VARCHAR(12), IN `_correo_empresa` VARCHAR(75), IN `_empresa_password` VARCHAR(225), IN `_rubro_empresa_id` INT, IN `_comision_empresa` DECIMAL(10,2), IN `_estado` INT)  INSERT INTO empresas(`codigo`, `nombre`, `direccion`, `contacto`, `telefono`, `correo`, `empresa_password`, `rubro_id`, `comision`, `estado`) VALUES (_codigo_empresa,_nombre_empresa,_direccion_empresa,_contacto_empresa,_telefono_empresa,_correo_empresa,_empresa_password,_rubro_empresa_id,_comision_empresa,_estado)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarToken` (IN `_clienteID` INT, IN `_token` VARCHAR(20))  INSERT INTO `tokencliente`(`cliente_id`, `Token`) VALUES (_clienteID , _token)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertOfertaEnEspera` (IN `_empresa_id` INT, IN `_titulo` VARCHAR(150), IN `_descipcion` TEXT, IN `_precio_regular` DECIMAL(10,2), IN `_precio_oferta` DECIMAL(10,2), IN `_fecha_inicio` DATE, IN `_fecha_fin` DATE, IN `_cantidad_cupones` INT, IN `_extras` TEXT)  INSERT INTO `ofertas`( `empresa_id`, `titulo`, `descripcion`, `precio_regular`, `precio_oferta`, `fecha_inicio`, `fecha_fin`, `cantidad_cupones`, `extras`,  `estado`) VALUES ( _empresa_id , _titulo , _descipcion , _precio_regular , _precio_oferta , _fecha_inicio , _fecha_fin , _cantidad_cupones , _extras , 3)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `loginCliente` (IN `_password` VARCHAR(255), IN `_correo` VARCHAR(150))  SELECT clientes.cliente_id , clientes.nombres , clientes.apellidos  from clientes WHERE clientes.email = _correo  and clientes.password = _password and clientes.verificacion = 1$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `loginEmpresa` (IN `_empresaCorreo` VARCHAR(75), IN `_empresaPassword` VARCHAR(255))  SELECT empresas.empresa_id, empresas.nombre, empresas.direccion, empresas.contacto, empresas.telefono, empresas.correo, empresas.rubro_id FROM `empresas` WHERE empresas.estado = 1 and empresas.correo = _empresaCorreo and empresas.empresa_password = _empresaPassword$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `obtenerEmpresa` (IN `_empresa_id` INT)  SELECT * from empresas WHERE empresas.empresa_id = _empresa_id and empresas.estado = 1$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `obtenerTokenExistente` (IN `_token_usario` VARCHAR(10))  SELECT tokencliente.cliente_id as cliente from tokencliente WHERE tokencliente.Token = _token_usario$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `recuperarPassword` (IN `_empresaPassword` VARCHAR(255), IN `_empresaID` INT)  UPDATE `empresas` SET `empresa_password`= _empresaPassword WHERE empresas.empresa_id = _empresaID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `recuperarPasswordCliente` (IN `_password` VARCHAR(255), IN `_clienteID` INT)  UPDATE clientes SET clientes.password = _password WHERE clientes.cliente_id = _clienteID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateEmpresa` (IN `_nombreEmpresa` VARCHAR(200), IN `_direccion` VARCHAR(120), IN `_contacto` VARCHAR(80), IN `_telefono` VARCHAR(12), IN `_correo` VARCHAR(75), IN `_rubro` INT, IN `_empresaID` INT)  UPDATE `empresas` SET `nombre`=_nombreEmpresa ,`direccion`= _direccion ,`contacto`= _contacto ,`telefono`=_telefono,`correo`= _correo , `rubro_id`=_rubro,`fecha_registro`= CURRENT_TIMESTAMP() WHERE empresas.empresa_id = _empresaID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateOferta` (IN `_titulo_oferta` VARCHAR(150), IN `_dscrpcion` TEXT, IN `_precioRegular` DECIMAL(10,2), IN `_precioOferta` DECIMAL(10,2), IN `_fechaInicio` DATE, IN `_fechaFin` DATE, IN `_cantidadCupones` INT, IN `_extras` TEXT, IN `_idOferta` INT, IN `_empresaID` INT)  UPDATE `ofertas` SET `titulo`= _titulo_oferta ,`descripcion`= _dscrpcion ,`precio_regular`= _precioRegular ,`precio_oferta`= _precioOferta ,`fecha_inicio`= _fechaInicio ,`fecha_fin`=_fechaFin ,`cantidad_cupones`= _cantidadCupones ,`extras`= _extras ,`fecha_registro` = CURRENT_TIMESTAMP(),`estado`= 3  WHERE ofertas.oferta_id = _idOferta and ofertas.empresa_id = _empresaID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updatePassword` (IN `_password` VARCHAR(255), IN `_empresaID` INT)  UPDATE `empresas` SET `empresa_password`= _password WHERE empresas.empresa_id = _empresaID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `validarCorreoExistenteCliente` (IN `_correoCliente` VARCHAR(100))  SELECT clientes.email FROM clientes WHERE clientes.email = _correoCliente$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `validarCorreoExistenteEmpresa` (IN `_correoEmpresa` TEXT)  SELECT empresas.correo FROM `empresas` WHERE empresas.correo = _correoEmpresa$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `cliente_id` int(11) NOT NULL,
  `nombres` varchar(100) NOT NULL,
  `apellidos` varchar(150) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `direccion` text NOT NULL,
  `dui` varchar(15) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(150) NOT NULL,
  `verificacion` int(5) NOT NULL,
  `fecha_registro` timestamp NOT NULL DEFAULT current_timestamp(),
  `estado` tinyint(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`cliente_id`, `nombres`, `apellidos`, `telefono`, `direccion`, `dui`, `email`, `password`, `verificacion`, `fecha_registro`, `estado`) VALUES
(11, 'Stefany', 'Galdamez', '2234-0398', 'Colonia Santa Lucia Calle N5 casa #3', '84756347-9', 'stefanyr505@gmail.com', 'd315af7d53791845b88bad33483a8a5f1f96a3f6', 1, '2021-08-28 04:33:58', 1),
(12, 'Edwin Alberto', 'Orellana Rosales', '2234-5344', 'Colonia Santa Rosa calle principal Casa #10', '23412312-3', 'e.edwirosales@gmail.com', '9fb7dd266d41187aa997f229d1c721b07410d068', 1, '2021-08-28 06:44:06', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente_cupones`
--

CREATE TABLE `cliente_cupones` (
  `cliente_cupon_id` int(11) NOT NULL,
  `cupon_id` int(11) NOT NULL,
  `cliente_id` int(11) NOT NULL,
  `ultimos4` int(5) NOT NULL,
  `marca_tarjeta` varchar(50) NOT NULL,
  `fecha_compra` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cupones`
--

CREATE TABLE `cupones` (
  `cupon_id` int(11) NOT NULL,
  `oferta_id` int(11) NOT NULL,
  `codigo_promocional` varchar(50) NOT NULL,
  `fecha_vencimiento` date NOT NULL,
  `fecha_registro` timestamp NOT NULL DEFAULT current_timestamp(),
  `estado` tinyint(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cupones`
--

INSERT INTO `cupones` (`cupon_id`, `oferta_id`, `codigo_promocional`, `fecha_vencimiento`, `fecha_registro`, `estado`) VALUES
(1, 8, 'EMP004', '2021-08-31', '2021-08-27 04:58:45', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresas`
--

CREATE TABLE `empresas` (
  `empresa_id` int(11) NOT NULL,
  `codigo` varchar(15) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `direccion` varchar(120) NOT NULL,
  `contacto` varchar(80) NOT NULL,
  `telefono` varchar(12) NOT NULL,
  `correo` varchar(75) NOT NULL,
  `empresa_password` varchar(255) NOT NULL,
  `rubro_id` int(11) NOT NULL,
  `comision` decimal(10,2) NOT NULL,
  `fecha_registro` timestamp NOT NULL DEFAULT current_timestamp(),
  `estado` tinyint(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empresas`
--

INSERT INTO `empresas` (`empresa_id`, `codigo`, `nombre`, `direccion`, `contacto`, `telefono`, `correo`, `empresa_password`, `rubro_id`, `comision`, `fecha_registro`, `estado`) VALUES
(2, 'EMP001', 'Ravez pro industrial', 'Boulevard de los heroes km 2/1', 'Ligia Orellana', '2254-9999', 'aniya68r_r245d@xeoty.com', 'e11c8e891b64342512a7a05da0bd7018dcc49ed7', 2, '10.00', '2021-08-24 02:16:24', 1),
(4, 'EMP002', 'La concha loca', 'Sta Lucia calle principal casa #23', 'Deniz', '2247-8554', 'xexek46596@fxseller.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 3, '10.00', '2021-08-26 04:46:05', 1),
(5, 'EMP003', 'Empresa prueba', 'Colonia al volcan', 'Carolina', '2295-0186', 'aniya68r_r245d@xeoty.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 4, '2.50', '2021-08-27 03:57:07', 1),
(7, 'EMP004', 'Lana Rhoades', 'Colonia el pepeto', 'StarYukii', '2295-8741', 'e.orellana04@outlook.com', 'c0f6c446c34e54889306877e9f24347ac582d763', 3, '5.00', '2021-08-27 04:33:47', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ofertas`
--

CREATE TABLE `ofertas` (
  `oferta_id` int(11) NOT NULL,
  `empresa_id` int(11) NOT NULL,
  `titulo` varchar(150) NOT NULL,
  `descripcion` text NOT NULL,
  `precio_regular` decimal(10,2) NOT NULL,
  `precio_oferta` decimal(10,2) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `cantidad_cupones` int(11) NOT NULL,
  `extras` text DEFAULT NULL,
  `observaciones` text DEFAULT NULL,
  `fecha_registro` timestamp NOT NULL DEFAULT current_timestamp(),
  `estado` tinyint(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ofertas`
--

INSERT INTO `ofertas` (`oferta_id`, `empresa_id`, `titulo`, `descripcion`, `precio_regular`, `precio_oferta`, `fecha_inicio`, `fecha_fin`, `cantidad_cupones`, `extras`, `observaciones`, `fecha_registro`, `estado`) VALUES
(5, 2, 'Compras kuchao un kuchao en oferta', 'Se pude llevar un kuchao al precio de dos kuchao oferton', '7.99', '10.50', '2021-08-24', '2021-08-31', 50, 'No lo se, kuchao', NULL, '2021-08-24 03:00:42', 3),
(6, 2, 'A dormir', 'Feli como lombriz', '30.99', '27.00', '2021-09-01', '2021-09-30', 20, 'Hola mundo', NULL, '2021-08-24 04:01:02', 3),
(8, 2, 'Oferta de prueba de esta cuestion', 'La descripcion de esta oferta conciste en probar primero que luego de ingresar me mandes a mi perfil luego--- Editado espero jale a la primera ojala...', '40.33', '34.00', '2021-08-26', '2021-09-24', 200, 'Bueno si jalo al final', NULL, '2021-08-25 21:24:58', 3),
(18, 2, 'Esta oferta deberia de aparecer', 'si mal no estamos todo deberia de salir', '30.00', '12.00', '2021-08-23', '2021-08-31', 200, NULL, NULL, '2021-08-27 01:20:30', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rubros`
--

CREATE TABLE `rubros` (
  `rubro_id` int(11) NOT NULL,
  `rubro` varchar(50) NOT NULL,
  `fecha_registro` timestamp NOT NULL DEFAULT current_timestamp(),
  `estado` tinyint(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `rubros`
--

INSERT INTO `rubros` (`rubro_id`, `rubro`, `fecha_registro`, `estado`) VALUES
(1, 'Servicios', '2021-08-13 17:32:59', 1),
(2, 'Turismo', '2021-08-25 21:53:42', 1),
(3, 'Restaurantes', '2021-08-26 03:52:29', 1),
(4, 'Cosmeticos', '2021-08-26 03:52:29', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipos_usuarios`
--

CREATE TABLE `tipos_usuarios` (
  `tipo_usuario_id` int(11) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `fecha_registro` timestamp NOT NULL DEFAULT current_timestamp(),
  `estado` tinyint(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipos_usuarios`
--

INSERT INTO `tipos_usuarios` (`tipo_usuario_id`, `tipo`, `fecha_registro`, `estado`) VALUES
(1, 'admin', '2021-08-27 04:24:41', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tokencliente`
--

CREATE TABLE `tokencliente` (
  `id_cliente` int(11) NOT NULL,
  `cliente_id` int(11) NOT NULL,
  `fecha_registro` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `Token` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tokencliente`
--

INSERT INTO `tokencliente` (`id_cliente`, `cliente_id`, `fecha_registro`, `Token`) VALUES
(8, 11, '2021-08-28 04:34:00', 'gjTevSCL'),
(9, 12, '2021-08-28 06:44:10', 'joWU8nhT');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `usuario_id` int(11) NOT NULL,
  `nombres` varchar(50) NOT NULL,
  `apellidos` varchar(75) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `correo` varchar(75) NOT NULL,
  `password` varchar(255) NOT NULL,
  `tipo_usuario_id` int(11) NOT NULL,
  `fecha_registro` timestamp NOT NULL DEFAULT current_timestamp(),
  `estado` tinyint(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`usuario_id`, `nombres`, `apellidos`, `usuario`, `correo`, `password`, `tipo_usuario_id`, `fecha_registro`, `estado`) VALUES
(1, 'Edwin', 'Orellana', 'edwin', 'staryukii@edwin.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 1, '2021-08-27 04:25:38', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`cliente_id`);

--
-- Indices de la tabla `cliente_cupones`
--
ALTER TABLE `cliente_cupones`
  ADD PRIMARY KEY (`cliente_cupon_id`),
  ADD KEY `cliente_id` (`cliente_id`),
  ADD KEY `cupon_id` (`cupon_id`);

--
-- Indices de la tabla `cupones`
--
ALTER TABLE `cupones`
  ADD PRIMARY KEY (`cupon_id`),
  ADD KEY `oferta_id` (`oferta_id`);

--
-- Indices de la tabla `empresas`
--
ALTER TABLE `empresas`
  ADD PRIMARY KEY (`empresa_id`),
  ADD KEY `rubro_id` (`rubro_id`);

--
-- Indices de la tabla `ofertas`
--
ALTER TABLE `ofertas`
  ADD PRIMARY KEY (`oferta_id`),
  ADD KEY `empresa_id` (`empresa_id`);

--
-- Indices de la tabla `rubros`
--
ALTER TABLE `rubros`
  ADD PRIMARY KEY (`rubro_id`);

--
-- Indices de la tabla `tipos_usuarios`
--
ALTER TABLE `tipos_usuarios`
  ADD PRIMARY KEY (`tipo_usuario_id`);

--
-- Indices de la tabla `tokencliente`
--
ALTER TABLE `tokencliente`
  ADD PRIMARY KEY (`id_cliente`),
  ADD KEY `cliente_id` (`cliente_id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`usuario_id`),
  ADD KEY `tipo_usuario_id` (`tipo_usuario_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `cliente_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `cliente_cupones`
--
ALTER TABLE `cliente_cupones`
  MODIFY `cliente_cupon_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cupones`
--
ALTER TABLE `cupones`
  MODIFY `cupon_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `empresas`
--
ALTER TABLE `empresas`
  MODIFY `empresa_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `ofertas`
--
ALTER TABLE `ofertas`
  MODIFY `oferta_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `rubros`
--
ALTER TABLE `rubros`
  MODIFY `rubro_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tipos_usuarios`
--
ALTER TABLE `tipos_usuarios`
  MODIFY `tipo_usuario_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `tokencliente`
--
ALTER TABLE `tokencliente`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `usuario_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente_cupones`
--
ALTER TABLE `cliente_cupones`
  ADD CONSTRAINT `cliente_cupones_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`cliente_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `cliente_cupones_ibfk_2` FOREIGN KEY (`cupon_id`) REFERENCES `cupones` (`cupon_id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `cupones`
--
ALTER TABLE `cupones`
  ADD CONSTRAINT `cupones_ibfk_1` FOREIGN KEY (`oferta_id`) REFERENCES `ofertas` (`oferta_id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `empresas`
--
ALTER TABLE `empresas`
  ADD CONSTRAINT `empresas_ibfk_1` FOREIGN KEY (`rubro_id`) REFERENCES `rubros` (`rubro_id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `ofertas`
--
ALTER TABLE `ofertas`
  ADD CONSTRAINT `ofertas_ibfk_1` FOREIGN KEY (`empresa_id`) REFERENCES `empresas` (`empresa_id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `tokencliente`
--
ALTER TABLE `tokencliente`
  ADD CONSTRAINT `tokencliente_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`cliente_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`tipo_usuario_id`) REFERENCES `tipos_usuarios` (`tipo_usuario_id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
