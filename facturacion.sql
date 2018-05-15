-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 14-05-2018 a las 23:45:35
-- Versión del servidor: 5.7.21
-- Versión de PHP: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `facturacion`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulos`
--

DROP TABLE IF EXISTS `articulos`;
CREATE TABLE IF NOT EXISTS `articulos` (
  `ID_ART` varchar(6) NOT NULL,
  `DES_ART` varchar(80) NOT NULL,
  `MARCA` varchar(20) NOT NULL,
  `PAIS` varchar(20) DEFAULT NULL,
  `STOCK` int(10) NOT NULL,
  `PVP_ART` double(10,2) NOT NULL,
  `PCO_ART` double(10,2) NOT NULL,
  `EX_MAX` int(10) NOT NULL,
  `EX_MIN` int(10) NOT NULL,
  PRIMARY KEY (`ID_ART`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `articulos`
--

INSERT INTO `articulos` (`ID_ART`, `DES_ART`, `MARCA`, `PAIS`, `STOCK`, `PVP_ART`, `PCO_ART`, `EX_MAX`, `EX_MIN`) VALUES
('AR0001', 'TELEVISOR FLATRON XS32 SONY', 'SONY', 'JAPON', 45, 2500.50, 1800.00, 50, 5),
('AR0002', 'REFRIGERADORA ECASA 16 PIES FAMILIA', 'ECASA', 'ECUADOR', 25, 1100.25, 950.25, 30, 8),
('AR0003', 'LICUADORA 5 VELOCIDADES OSTER', 'OSTER', 'CHILE', 54, 125.50, 78.00, 60, 10),
('AR0004', 'DVD LG SGX134', 'LG', 'INDONESIA', 50, 180.50, 150.50, 60, 15),
('AR0005', 'DVD S34E SONY', 'SONY', 'JAPON', 30, 220.56, 195.25, 45, 10),
('AR0006', 'LAVADORA LG 16LLG', 'LG', 'INDONESIA', 25, 850.50, 705.50, 45, 15),
('AR0007', 'LAVADORA ELECTROLUX 18XLBL', 'ELECTROLUX', 'USA', 44, 950.45, 790.00, 60, 10),
('AR0008', 'COCINA INDURAMA ROMA', 'INDURAMA', 'CHILE', 0, 650.25, 520.20, 30, 10),
('AR0009', 'COCINA INDURAMA VENECIA', 'INDURAMA', 'CHILE', 26, 780.50, 595.25, 45, 15),
('AR0010', 'TELEVISOR PHILLIPS 27PP', 'PHILLIPS', 'USA', 35, 950.60, 780.45, 60, 15),
('AR0011', 'TELEVISOR AYWA 52HD', 'AYWA', 'JAPON', 30, 2150.50, 1900.25, 60, 10),
('AR0012', 'EQUIPO DE SONIDO SONY 8000WPS', 'SONY', 'JAPON', 50, 1350.50, 990.50, 60, 10),
('AR0013', 'EQUIPO DE SONIDO AYWA 7500 PMP', 'AYWA', 'JAPON', 50, 1050.50, 780.26, 60, 15),
('AR0014', 'LICUADORA 8 VEL BLACK AND DECKER', 'BLACK&DECKER', 'CANADA', 48, 85.48, 58.45, 50, 10),
('AR0015', 'PROCESADOR DE ALIMENTOS OSTER', 'OSTER', 'CHILE', 45, 98.00, 80.25, 50, 15),
('AR0016', 'TOSTADORA XS15 OSTER', 'OSTER', 'CHILE', 36, 45.00, 35.50, 45, 15),
('AR0017', 'TELEVISOR SAMSUNG 42P', 'SAMSUNG', 'KOREA', 30, 1850.50, 1500.00, 45, 10),
('AR0018', 'REFRIGERADORA ELECTROLUX NF21', 'ELECTROLUX', 'CHILE', 20, 1050.75, 850.50, 35, 10),
('AR0019', 'MICROONDAS LG XRT12', 'LG', 'INDONESIA', 15, 250.50, 158.90, 35, 10),
('AR0020', 'MICROONDAS OSTER OM12WW', 'OSTER', 'CHILE', 17, 180.25, 154.25, 25, 10),
('AR0021', 'GRABADORA SONY 300WW SN300', 'SONY', 'JAPON', 25, 350.00, 330.00, 50, 10),
('AR0022', 'GRABADORA LG 500WLG', 'LG', 'INDONESIA', 24, 420.00, 395.50, 60, 10),
('AR0023', 'PROCESADOR DE ALIMENTOS BD', 'BLACK&DECKER', 'CANADA', 15, 105.50, 89.65, 50, 10),
('AR0024', 'TOSTADORA OSTER OS50', 'OSTER', 'CHILE', 35, 85.50, 70.50, 60, 10),
('AR0025', 'BATIDORA OSTER 15VOS', 'OSTER', 'CHILE', 45, 105.50, 90.00, 50, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE IF NOT EXISTS `clientes` (
  `ID_CLI` varchar(6) NOT NULL,
  `NOM_CLI` varchar(30) NOT NULL,
  `APE_CLI` varchar(30) NOT NULL,
  `DIR_CLI` varchar(80) NOT NULL,
  `CER_CLI` varchar(13) NOT NULL,
  `TEL_CLI` varchar(9) DEFAULT NULL,
  `CEL_CLI` varchar(9) DEFAULT NULL,
  `SEX_CLI` varchar(9) NOT NULL,
  `EMA_CLI` varchar(100) DEFAULT NULL,
  `SAL_CLI` double(10,2) NOT NULL,
  `FEC_ING` date NOT NULL,
  `ACTIVO` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`ID_CLI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

DROP TABLE IF EXISTS `factura`;
CREATE TABLE IF NOT EXISTS `factura` (
  `NUM_FAC` varchar(10) NOT NULL,
  `FECHA` date NOT NULL,
  `ID_CLI` varchar(6) NOT NULL,
  `ID_VEN` varchar(6) NOT NULL,
  `FOR_PAG` varchar(7) NOT NULL,
  `DESCU` int(2) NOT NULL,
  `SUB_GEN` double(10,2) NOT NULL,
  `TOT_DES` double(10,2) NOT NULL,
  `TOT_IVA` double(10,2) NOT NULL,
  `OBSERVAC` varchar(100) DEFAULT NULL,
  `ANULADA` int(1) NOT NULL DEFAULT '0',
  `PAGO_INI` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`NUM_FAC`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facura_det`
--

DROP TABLE IF EXISTS `facura_det`;
CREATE TABLE IF NOT EXISTS `facura_det` (
  `NUM_DET` int(10) NOT NULL AUTO_INCREMENT,
  `ID_ART` varchar(6) NOT NULL,
  `PVP` double(10,2) NOT NULL,
  `CANT` int(10) NOT NULL,
  `NUM_FACV` varchar(10) NOT NULL,
  PRIMARY KEY (`NUM_DET`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facv_cab`
--

DROP TABLE IF EXISTS `facv_cab`;
CREATE TABLE IF NOT EXISTS `facv_cab` (
  `NUM_FACV` varchar(10) NOT NULL,
  `FECHA` date NOT NULL,
  `ID_CLI` varchar(6) NOT NULL,
  `ID_VEN` varchar(6) NOT NULL,
  `FOR_PAG` varchar(7) NOT NULL,
  `DESCU` int(2) NOT NULL,
  `SUB_GEN` double(10,2) NOT NULL,
  `TOT_DES` double(10,2) NOT NULL,
  `TOT_IVA` double(10,2) NOT NULL,
  `OBSERVAC` varchar(100) DEFAULT NULL,
  `ANULADA` int(1) NOT NULL DEFAULT '0',
  `PAGO_INI` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`NUM_FACV`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `facv_cab`
--

INSERT INTO `facv_cab` (`NUM_FACV`, `FECHA`, `ID_CLI`, `ID_VEN`, `FOR_PAG`, `DESCU`, `SUB_GEN`, `TOT_DES`, `TOT_IVA`, `OBSERVAC`, `ANULADA`, `PAGO_INI`) VALUES
('0000000001', '2013-01-11', 'CL0007', 'VE0004', 'CONTADO', 0, 1050.50, 0.00, 126.06, '', 0, 1176.56);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facv_det`
--

DROP TABLE IF EXISTS `facv_det`;
CREATE TABLE IF NOT EXISTS `facv_det` (
  `NUM_DET` int(10) NOT NULL AUTO_INCREMENT,
  `ID_ART` varchar(6) NOT NULL,
  `PVP` double(10,2) NOT NULL,
  `CANT` int(10) NOT NULL,
  `NUM_FACV` varchar(10) NOT NULL,
  PRIMARY KEY (`NUM_DET`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `facv_det`
--

INSERT INTO `facv_det` (`NUM_DET`, `ID_ART`, `PVP`, `CANT`, `NUM_FACV`) VALUES
(1, 'AR0013', 1050.50, 1, '0000000001'),
(2, 'AR0001', 2500.50, 1, '0000000002');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vendedores`
--

DROP TABLE IF EXISTS `vendedores`;
CREATE TABLE IF NOT EXISTS `vendedores` (
  `ID_VEN` varchar(6) NOT NULL,
  `NOM_VEN` varchar(30) NOT NULL,
  `APE_VEN` varchar(30) NOT NULL,
  `DIR_VEN` varchar(100) NOT NULL,
  `CER_VEN` varchar(13) DEFAULT NULL,
  `TEL_VEN` varchar(9) DEFAULT NULL,
  `CEL_VEN` varchar(9) DEFAULT NULL,
  `SEX_VEN` varchar(9) NOT NULL,
  `FEC_ING` date NOT NULL,
  `FEC_NAC` date DEFAULT NULL,
  `EMA_VEN` varchar(100) DEFAULT NULL,
  `VENTAS` double(10,2) DEFAULT NULL,
  `LABORA` int(1) DEFAULT '1',
  `SUELDO` double(10,2) NOT NULL,
  PRIMARY KEY (`ID_VEN`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `vendedores`
--

INSERT INTO `vendedores` (`ID_VEN`, `NOM_VEN`, `APE_VEN`, `DIR_VEN`, `CER_VEN`, `TEL_VEN`, `CEL_VEN`, `SEX_VEN`, `FEC_ING`, `FEC_NAC`, `EMA_VEN`, `VENTAS`, `LABORA`, `SUELDO`) VALUES
('VE0001', 'ANDRES ROBERTOjiodskcxl', 'MOLINA FAREZ', 'AV. LAS PALMERAS no se que', '0702365988', '072946565', '095632562', 'MASCULINO', '2011-05-15', '1989-04-10', 'andrhjsdlujwkees@hotmail.com', 0.00, 1, 350.50);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
