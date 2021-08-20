-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-08-2021 a las 20:18:33
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
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarEmpresa` (IN `_codigo_empresa` VARCHAR(15), IN `_nombre_empresa` VARCHAR(200), IN `_direccion_empresa` VARCHAR(120), IN `_contacto_empresa` VARCHAR(80), IN `_telefono_empresa` VARCHAR(12), IN `_correo_empresa` VARCHAR(75), IN `_empresa_password` VARCHAR(225), IN `_rubro_empresa_id` INT, IN `_comision_empresa` DECIMAL(10,2), IN `_estado` INT)  INSERT INTO empresas(`codigo`, `nombre`, `direccion`, `contacto`, `telefono`, `correo`, `empresa_password`, `rubro_id`, `comision`, `estado`) VALUES (_codigo_empresa,_nombre_empresa,_direccion_empresa,_contacto_empresa,_telefono_empresa,_correo_empresa,_empresa_password,_rubro_empresa_id,_comision_empresa,_estado)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarToken` (IN `_empresa_id` INT, IN `_token` VARCHAR(20))  INSERT INTO tokenempresa(`id_empresa`, `Token`) VALUES (_empresa_id,_token)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `obtenerTokenExistente` (IN `_token_usario` VARCHAR(10))  SELECT tokenempresa.id_empresa as empresa from tokenempresa WHERE tokenempresa.Token = _token_usario$$

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
(1, '1234ASDF', 'Prueba SA , SV', 'DIreccion de prueba', 'Contacto de prueba', '22501889', 'Prueba@email.com', 'PruebaPassword', 1, '10.00', '2021-08-13 17:34:48', 1),
(2, '4321fdsa', 'Segunda Empresa de prueba SA.CV', 'Colonia de prueba , calle falsa, San Salvador, El Salvador', 'Julano de tal', '26547410', 'SegundaEmpresa@email.com', 'SegundaEmpresa', 1, '10.00', '2021-08-13 18:33:18', 1),
(8, 'EMP003', 'Ravez pro industrial', 'Calle al volcan km1/2', 'Ligia Orellana', '2295-0196', 'aniya68r_r245d@xeoty.com', 'bf69c2dcdd3ceb3554e756f250d0f96cb51ad6a6', 1, '10.00', '2021-08-20 01:07:32', 3);

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
(1, 1, 'Descuento prueba en x cosa', 'Se le aplicara un descuento a tal cosa', '12.99', '10.00', '2021-08-13', '2021-08-17', 12, 'Sin extras', 'No me parece dice el damin, rechazada ', '2021-08-13 17:36:13', 1),
(2, 2, 'Segunda oferta prueba', 'segunda descripcion de oferta', '30.00', '25.99', '2021-08-18', '2021-08-26', 50, NULL, 'Segundas obervaciones de por que no se acepto', '2021-08-13 18:38:46', 1);

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
(1, 'Servicios', '2021-08-13 17:32:59', 1);

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tokenempresa`
--

CREATE TABLE `tokenempresa` (
  `tokenEmpresa_id` int(11) NOT NULL,
  `id_empresa` int(11) NOT NULL,
  `fecha_registro` datetime NOT NULL,
  `Token` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tokenempresa`
--

INSERT INTO `tokenempresa` (`tokenEmpresa_id`, `id_empresa`, `fecha_registro`, `Token`) VALUES
(1, 8, '0000-00-00 00:00:00', 'c2eRHeMx');

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
-- Indices de la tabla `tokenempresa`
--
ALTER TABLE `tokenempresa`
  ADD PRIMARY KEY (`tokenEmpresa_id`),
  ADD KEY `id_empresa` (`id_empresa`);

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
  MODIFY `cliente_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cliente_cupones`
--
ALTER TABLE `cliente_cupones`
  MODIFY `cliente_cupon_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cupones`
--
ALTER TABLE `cupones`
  MODIFY `cupon_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `empresas`
--
ALTER TABLE `empresas`
  MODIFY `empresa_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `ofertas`
--
ALTER TABLE `ofertas`
  MODIFY `oferta_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `rubros`
--
ALTER TABLE `rubros`
  MODIFY `rubro_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `tipos_usuarios`
--
ALTER TABLE `tipos_usuarios`
  MODIFY `tipo_usuario_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tokenempresa`
--
ALTER TABLE `tokenempresa`
  MODIFY `tokenEmpresa_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `usuario_id` int(11) NOT NULL AUTO_INCREMENT;

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
-- Filtros para la tabla `tokenempresa`
--
ALTER TABLE `tokenempresa`
  ADD CONSTRAINT `tokenempresa_ibfk_1` FOREIGN KEY (`id_empresa`) REFERENCES `empresas` (`empresa_id`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`tipo_usuario_id`) REFERENCES `tipos_usuarios` (`tipo_usuario_id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

