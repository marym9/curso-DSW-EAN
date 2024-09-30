-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 30-09-2024 a las 03:56:45
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bolsa_empleo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aspirantes`
--

CREATE TABLE `aspirantes` (
  `cedula` varchar(15) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `edad` int(3) NOT NULL,
  `experiencia` int(2) NOT NULL,
  `profesion` varchar(50) NOT NULL,
  `telefono` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `aspirantes`
--

INSERT INTO `aspirantes` (`cedula`, `nombre`, `edad`, `experiencia`, `profesion`, `telefono`) VALUES
('100862465', 'Oscar Daniel Moreno', 21, 2, 'Ingeniero', '3156463975'),
('1016106039', 'Alan Duvan Gamboa', 25, 2, 'Ingeniero', '3508493674'),
('1121947095', 'Maribel Moreno Escobar', 27, 3, 'adm financiera', '3014602080'),
('46578364', 'rosa letrado', 20, 2, 'ama de casa', '38758');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aspirantes`
--
ALTER TABLE `aspirantes`
  ADD PRIMARY KEY (`cedula`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
