-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-02-2020 a las 05:40:11
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bus`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bus`
--

CREATE TABLE `bus` (
  `Id` int(11) NOT NULL,
  `type` varchar(20) NOT NULL,
  `motor` varchar(20) NOT NULL,
  `brakes` varchar(20) NOT NULL,
  `concessionaireId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `bus`
--

INSERT INTO `bus` (`Id`, `type`, `motor`, `brakes`, `concessionaireId`) VALUES
(1, 'Bi-articulado', 'Diesel', 'Disco', 1),
(2, 'Articulado', 'Gas', 'Normal', 2),
(3, 'Bi-articulado', 'Diesel', 'Disco', 1),
(6, 'Bi-articulado', 'Diesel', 'Disco', 2),
(7, 'Bi-articulado', 'Diesel', 'Disco', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `concessionaire`
--

CREATE TABLE `concessionaire` (
  `Id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `concessionaire`
--

INSERT INTO `concessionaire` (`Id`, `name`) VALUES
(1, 'Concessionaire 1'),
(2, 'Concessionaire 2'),
(3, 'Concessionaire 3'),
(7, 'Concessionaire 4');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `device`
--

CREATE TABLE `device` (
  `id` int(11) NOT NULL,
  `ip` varchar(20) NOT NULL,
  `deviceTypeId` int(11) NOT NULL,
  `busId` int(11) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `device`
--

INSERT INTO `device` (`id`, `ip`, `deviceTypeId`, `busId`, `status`) VALUES
(1, '10.120.95.2', 1, 2, 'Active'),
(2, '10.120.95.3', 2, 2, 'Active'),
(3, '10.120.50.50', 2, 1, 'Active');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `devicetype`
--

CREATE TABLE `devicetype` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `devicetype`
--

INSERT INTO `devicetype` (`id`, `name`) VALUES
(1, 'CANBUS'),
(2, 'NVR');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bus`
--
ALTER TABLE `bus`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `concessionaireId` (`concessionaireId`);

--
-- Indices de la tabla `concessionaire`
--
ALTER TABLE `concessionaire`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `device`
--
ALTER TABLE `device`
  ADD PRIMARY KEY (`id`),
  ADD KEY `deviceTypeId` (`deviceTypeId`),
  ADD KEY `busId` (`busId`);

--
-- Indices de la tabla `devicetype`
--
ALTER TABLE `devicetype`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bus`
--
ALTER TABLE `bus`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `concessionaire`
--
ALTER TABLE `concessionaire`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `device`
--
ALTER TABLE `device`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `devicetype`
--
ALTER TABLE `devicetype`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bus`
--
ALTER TABLE `bus`
  ADD CONSTRAINT `bus_ibfk_1` FOREIGN KEY (`concessionaireId`) REFERENCES `concessionaire` (`Id`);

--
-- Filtros para la tabla `device`
--
ALTER TABLE `device`
  ADD CONSTRAINT `device_ibfk_1` FOREIGN KEY (`deviceTypeId`) REFERENCES `devicetype` (`id`),
  ADD CONSTRAINT `device_ibfk_2` FOREIGN KEY (`busId`) REFERENCES `bus` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
