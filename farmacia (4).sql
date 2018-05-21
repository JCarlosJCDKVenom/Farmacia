-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 21-05-2018 a las 21:37:44
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
-- Base de datos: `farmacia`
--
CREATE DATABASE IF NOT EXISTS `farmacia` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci;
USE `farmacia`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallefactura`
--

DROP TABLE IF EXISTS `detallefactura`;
CREATE TABLE IF NOT EXISTS `detallefactura` (
  `idDetalle` int(11) NOT NULL,
  `idFact` int(11) NOT NULL,
  `idMerca` int(11) NOT NULL,
  `cantidadDeta` int(11) DEFAULT NULL,
  `importeTotal` decimal(11,5) DEFAULT NULL,
  PRIMARY KEY (`idDetalle`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

DROP TABLE IF EXISTS `factura`;
CREATE TABLE IF NOT EXISTS `factura` (
  `idFac` int(11) NOT NULL,
  `codFactura` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `idCliente` int(11) NOT NULL,
  `fechaFact` date DEFAULT NULL,
  PRIMARY KEY (`idFac`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturas`
--

DROP TABLE IF EXISTS `facturas`;
CREATE TABLE IF NOT EXISTS `facturas` (
  `idFac` int(11) NOT NULL AUTO_INCREMENT,
  `NUM_FAC` varchar(10) COLLATE utf8mb4_spanish_ci NOT NULL,
  `FECHA` date NOT NULL,
  `ID_CLI` varchar(6) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `ID_VEN` varchar(6) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `FOR_PAG` varchar(7) COLLATE utf8mb4_spanish_ci NOT NULL,
  `DESCU` int(2) NOT NULL,
  `PREC_FINAL` double(10,2) NOT NULL,
  `TOT_DES` double(10,2) NOT NULL,
  `VUELTO` double(10,2) NOT NULL,
  `OBSERVAC` varchar(100) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `PAGO_INI` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`idFac`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mercancia`
--

DROP TABLE IF EXISTS `mercancia`;
CREATE TABLE IF NOT EXISTS `mercancia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(1000) COLLATE utf8mb4_spanish_ci NOT NULL,
  `presentacion` varchar(100) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `proveedor` varchar(100) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `disponible` int(11) DEFAULT NULL,
  `costo` decimal(10,5) DEFAULT NULL,
  `precio` decimal(11,5) DEFAULT NULL,
  `descuento1` decimal(11,5) DEFAULT NULL,
  `descuento2` decimal(11,5) DEFAULT NULL,
  `lote` varchar(80) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `vencimiento` date DEFAULT NULL,
  `idMerc_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idMerc_fk` (`idMerc_fk`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mercanciacategoria`
--

DROP TABLE IF EXISTS `mercanciacategoria`;
CREATE TABLE IF NOT EXISTS `mercanciacategoria` (
  `id` int(11) NOT NULL,
  `nombreMed` varchar(1000) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `mercanciacategoria`
--

INSERT INTO `mercanciacategoria` (`id`, `nombreMed`) VALUES
(1, 'AB BRONCOL NF 1.2g Polvo para Suspension Inyectable Vial + Solv X 5 mL x 1 unid. MEDIFARMA - N25382'),
(2, 'ACICLAV x 14 TAB OQPHARMA'),
(3, 'ACICLOVIR 200mg Tableta Caja Tab. x 100 unid. NAT. Y GEN. - NG3216'),
(4, 'ACICLOVIR 400 mg TABLETA CAJA x 100 TAB MEDROCK EN-01793'),
(5, 'ACICLOVIR 5% Crema Tubo x 5 g x 1 unid. FARMINDUSTRIA - EN00023'),
(6, 'ACIDO FOLICO 0,5 mg x 100 UND IQFARMA'),
(7, 'ACIDO FOLICO x 100 TAB TERBONOVA'),
(8, 'AGUA PARA INYECCION x 100 UND PHARMAGEN'),
(9, 'ALBENDAZOL 200 MG x 100 TAB IQFARMA'),
(10, 'ALBENDAZOL 100 mg/5 ml x 20 ml farmindustria X 2 fco'),
(11, 'ALOPURINOL 100mg Tableta Caja Tab. x 30 unid. FARMINDUSTRIA - NG3409'),
(12, 'AMBROXOL 15mg/5mL Jarabe Fco. X 120 mL x 1 unid. PORTUGAL - NG2238'),
(13, 'AMBROXOL 30mg/5mL Jarabe Fco. X 120 mL x 1 unid. PORTUGAL - NG4556'),
(14, 'AMIKACINA 500mg/2mL Solucion Inyectable IV Caja Vial x 2 mL x 10 unid. LABOT'),
(15, 'AMIKACINA 1 g/4mL Solucion Inyectable IV Caja Vial x 2 mL x MEDIFARMA'),
(16, 'AMLODIPINO 10 mg Tableta Caja Tab. x 100 unid. NAT. Y GEN. - NG5615'),
(17, 'AMLODIPINO 5mg Tableta Caja Tab. x 100 unid. NAT. Y GEN. - NG5615'),
(18, 'AMOX 1 gr. X 20 TAB OQPHARMA SAC'),
(19, 'AMOXICILINA + ACIDO CLAVULANICO 500mg+125mg Tableta Recubierta Caja Tab. x 10 unid. NAT. Y GEN. - NG5043'),
(20, 'AMOXICILINA + BROMHEXINA 250mg+4mg/5mL Polvo para Suspension Oral Caja Fco. X 60 mL x 1 unid. NAT. Y GEN. - NG6179'),
(21, 'AMOXICILINA + BROMHEXINA 500mg+8mg Tableta Recubierta Caja Tab. x 100 unid. NAT. Y GEN. - NG5957'),
(22, 'AMOXICILINA 250mg/5mL Polvo para Suspension Oral Caja Fco. X 60 mL x 1 unid. NAT. Y GEN. - NG5032'),
(23, 'AMOXICILINA 500mg Tableta Caja Tab. x 100 unid. NAT Y GENER'),
(24, 'AMPICILINA 1g Polvo para Solucion Inyectable Caja Vial x 25 unid. DANY - EG5223'),
(25, 'AMPICILINA 500 mg CAPSULA  CAJA 100 UND NAT Y GENER'),
(26, 'ANTALGINA 500mg Tableta Caja Tab. x 100 unid. TEVA - N855'),
(27, 'APRONAX 550mg Tableta Caja Tab. x 120 unid. BAYER - N25562'),
(28, 'AROVIT 50 000 UI x 30 TAB BAYER'),
(29, 'ASPIRINA 100 100mg Tableta Caja Tab. x 140 unid. BAYER - E22787'),
(30, 'ASPIRINA 500 mg TAB x 100 - BAYER'),
(31, 'ATORMED-20 20mg Tableta Recubierta Caja Tab. x 100 unid. KFARMA - EE00258'),
(32, 'ATORVASTATINA 10mg Tableta Recubierta Caja Tab. x 100 unid. NAT. Y GEN. - NG5161'),
(33, 'ATROPINA SULFATO 1 mg /ml IM.IV  x 50 UND PHARMAGEN'),
(34, 'AZITROMICINA 500mg Tableta Recubierta Caja Tab. x 3 unid. NAT. Y GEN. - NG4588'),
(35, 'AZITROMICINA 500mg Tableta Recubierta Caja Tab. x 30 TAB AC FARMA'),
(36, 'AZITROMICINA 200 mg / 5 ml x 30 ml  NAT Y GEN'),
(37, 'BACTRIM FORTE 800mg+160mg Comprimido Caja Comp. x 100 unid. ROCHE - E12808'),
(38, 'BENCILPENICILINA PROCAINICA 1000000UI Polvo para Suspension Inyectable Caja Vial x 10'),
(39, 'BENCILPENICILINA BENZATINICA 1200 000 UI x 25 DANY EG- 5718'),
(40, 'BENZOATO DE BENCILO 25% x 120 ml ROXFARMA '),
(41, 'BETAPLUSS 0.05% Crema Caja Tbo. X 20 g x 1 unid. PORTUGAL - N20961'),
(42, 'BEXADERM CREMA x 20 gr. PORTUGAL'),
(43, 'BICARBONATO DE SODIO 8.4% Solucion para Inyeccion Amp. X 20 mL x 25 unid. LUSA - NG3633'),
(44, 'BISMUTOL 262mg Tableta Masticable Caja Tab. x 160 unid. TEVA - N17721'),
(45, 'BISMUTOL 87.33mg/5mL Suspension Fco. X 150 mL x 1 unid. TEVA - N17531'),
(46, 'BROMURO DE VECURONIO 4 mg /ml VITALIS FCO VIAL'),
(47, 'BRONCOMEXINA 250 + 4 mg/ 5 ml x 60 ml'),
(48, 'BRONCOMEXINA 500 mg/8 mg x 100 TAB PORTUGAL'),
(49, 'BUPIVACAINA HIPERBARICA 0.5% Solucion Inyectable IV Caja Amp. X 20 mL x 5 unid. DANY'),
(50, 'BUPIVACAINA HIPERBARICA 0.5% Solucion Inyectable IV Caja Amp. X 4 mL x 1 unid. VEINFAR'),
(51, 'CAPTOPRIL 25mg Tableta Caja Tab. x 100 unid. NAT. Y GEN. - NG3966'),
(52, 'CARAMELOS BUCK x 56 SOBRES'),
(53, 'CEFALEXINA 500 mg x 100 cap FARMINDUSTRIA - NG-4488'),
(54, 'CEFALEXINA 500 mg x 100 cap IQFARMA'),
(55, 'CEFAZOLINA 1g Polvo para Solucion Inyectable Caja Vial x 10 unid. PHARMAGEN'),
(56, 'CEFRADINA 500mg Capsula Caja Cap. x 120 unid. FARMINDUSTRIA - NG0024'),
(57, 'CEFTAZIDIMA 1g Polvo para Solucion Inyectable Caja Vial x 10 unid. PHARMAGEN'),
(58, 'CEFTRIAXONA 1g Polvo para Solucion Inyectable Caja Vial x 25 unid. DANY - EG5227'),
(59, 'CELECOXIB 200mg Capsula Caja Cap. x 100 unid. NAT. Y GEN. - NG5660'),
(60, 'CETIRIZINA 10mg Tableta Caja Tab. x 100 unid. NAT. Y GEN. - NG4577'),
(61, 'CETIRIZINA 5mg/5mL Jarabe Caja Fco. X 60 mL x 1 unid. PORTUGAL - NG4727'),
(62, 'CIPROFLOXACINO 500mg Tableta Caja Tab. x 100 unid. NAT. Y GEN.'),
(63, 'CIPRONOR 200mg/100mL Solucion para Inyeccion Caja Vial X 100 mL x 1 unid. NORDIC - E19789'),
(64, 'CIROCAINA 2% Jalea Caja Tbo. X 30 g x 10 unid. JPS DISTRIBUCIONES - E21224'),
(65, 'CLARITROMICINA 500mg Tableta Caja Tab. x 100 unid. NAT. Y GEN. - NG4763'),
(66, 'CLINDAMICINA 300mg Capsula Caja Cap. X100 ACFARMA'),
(67, 'CLONAZEPAM 0.5 mg TAB x 100 TAB REC FARMINDUSTRIA'),
(68, 'CLOPIDOGREL 75 mg x 30 TAB NAT Y GENER'),
(69, 'CLORANFENICOL 1g Polvo para Solucion Inyectable Caja Vial x 1 unid. PHARMAGEN - EG6019'),
(70, 'CLORFENAMINA MALEATO 10mg/mL Solucion para Inyeccion Caja Amp. x 100 unid. SANDERSON - EG893'),
(71, 'CLORFENAMINA MALEATO 4 mg x 100 TAB PORTUGAL'),
(72, 'CLORURO DE SODIO 9% x 5 ml x 25 AMP LUSA'),
(73, 'CLORURO DE SODIO 0,9 % SOLUCION PARA INYECCION ENV. X 100 ml x 1 UND'),
(74, 'CLORURO DE SODIO 0.9% Solucion para Inyeccion Env. X 1 L x 1 unid. B.BRAUN - NG2775'),
(75, 'CLORURO DE SODIO 0.9% Solucion para Inyeccion Env. X 500 ML BRAUN'),
(76, 'CLOTRIMAZOL 500mg Tableta Vaginal Caja Tab. x 50 unid. NAT. Y GEN. - NG3394'),
(77, 'CLOTRY 1 % CREMA - JPS EIRL'),
(78, 'CLOTRIMAZOL 1% x 20 gr. NAT. Y GEN. - NG2991'),
(79, 'COLUQUIM 500mg Tableta Caja Tab. x 6 unid. QUIMICA SUIZA - N21533'),
(80, 'COMPLEJO B x 300 CAP PORTUGAL'),
(81, 'COMPLEJO B JBE x 120 ML PORTUGAL'),
(82, 'DALCYNVAX 600 mg/ml (clindamicina) x 25 AMP OTARSVAQ EN02901'),
(83, 'DESHIDRAL 20% Solucion para Inyeccion Amp. X 20 mL x 25 unid. LUSA - N14629'),
(84, 'DEXAMETASONA 4mg Tableta Caja Tab. x 100 unid. FARMINDUSTRIA'),
(85, 'DEXAMETASONA 4mg/2mL Solucion para Inyeccion Caja Amp. x 2 mL x 100 unid. LABOT - EG5931'),
(86, 'DEXTRO LUSA 33% Solucion para Inyeccion Caja Amp. X 20 mL x 25 unid. LUSA - N587'),
(87, 'DEXTROMETORFANO x 120 ml PORTUGAL'),
(88, 'DEXTROSA 5% Solucion para Inyeccion Env. X 1 L x 1 unid. B.BRAUN - NG2866'),
(89, 'DEXTROSA 5% Solucion para Inyeccion Env. X 100 mL x 1 unid. B.BRAUN - NG2866'),
(90, 'DEXTROSA 5% Solucion para Inyeccion Env. X 500 mL x 1 unid. B.BRAUN - NG2866'),
(91, 'DICLOFENACO 1% Gel Tubo X 20 g x 1 unid. PORTUGAL - NG4821'),
(92, 'DICLOFENACO 1% Gel Tubo X 50 g x 1 unid. PORTUGAL'),
(93, 'DICLOFENACO 75mg/3mL Solucion para Inyeccion Fco. Amp. X 3 mL x 10 unid. VITALIS - EG2537'),
(94, 'DICLOFENACO SODICO 50mg Tableta de Liberacion Retardada Caja Tab. x 100 unid. BIOSYNTEC'),
(95, 'DICLOFENACO SODICO 50mg Tableta de Liberacion Retardada Caja Tab. x 50 LA SANTE'),
(96, 'DICLOXACILINA 250mg/5mL Polvo para Suspension Oral Fco. X 60 mL x 1 unid. NAT. Y GEN. - NG4874'),
(97, 'DICLOXACILINA 500mg Capsula Caja Cap. x 100 unid. NAT Y GEN'),
(98, 'DICYNONE 500mg Capsula Caja Cap. x 100 unid. OM PHARMA - N22665'),
(99, 'DIMENHIDRINATO 50mg Tableta Caja Tab. x 100 unid. NAT. Y GEN. - NG4848'),
(100, 'DIMENHIDRINATO 50mg  /5 ml AMP x 25 AMP dany'),
(101, 'DINITRATO DE ISOSORBIDA 10 mg x 20 TAB'),
(102, 'DOLO NEUROBION  Solucion para Inyeccion Caja 2 Amp.  x 2 AMP MERK'),
(103, 'DOLODRAN EXTRA FORTE 500mg+50mg Tableta Caja Tab. x 100 unid. NAT. Y GEN. - N25322'),
(104, 'DOLOFLAM doble accion 200 mg Tableta Caja Tab. x 150 unid. JOHNSON&JOHNSON - E23109'),
(105, 'DOLORAL 100 mg x 5 ml x 60 ML HERSIL'),
(106, 'DOLO-QUIMAGESICO C50 x 120 CAP FARMINDUSTRIA'),
(107, 'DOXICICLINA 100mg Capsula Caja Cap. x 100 unid. NAT. Y GEN. - NG6057'),
(108, 'DUO CVP K  Capsula Caja Cap. x 40 unid. FARMINDUSTRIA - N10936'),
(109, 'EPINEFRINA 1 °/oo 1 mg / 1 ml x 100 UND SANDERSON'),
(110, 'ERITROMICINA ESTEARATO 500mg Tableta Caja Tab. x 100 unid. NAT. Y GEN. - NG5275'),
(111, 'ERITROMICINA ETILSUCCINATO 250mg/5mL Polvo para Suspension Oral Caja Fco. X 60 mL x 1 unid. FARMINDUSTRIA NG-5839'),
(112, 'MIGRADORIXINA  (ERGOTAMINA+      ) x 100 TAB'),
(113, 'ESCOPOLAMINA N-BUTILBROMURO 20 mg/ml x 25 AMP DANY'),
(114, 'ETILEFRINA 10 mg /1 ml VEINFAR ICSA RS. -EG-4784'),
(115, 'EUTIROX 100 mcg x 50 TAB MERCK'),
(116, 'FENAZOPIRIDINA 100mg Tableta Recubierta Caja Tab. x 100 unid. FARMINDUSTRIA'),
(117, 'FENITOINA SODICA 100mg x 100 MARFAN'),
(118, 'FENITOINA SODICA 100mg/2mL Solucion para Inyeccion Caja Amp. X 2 mL x 25 unid. DANY - NG5376'),
(119, 'FENOTEC 5 mg - FENOTEROL'),
(120, 'FITOMENADIONA 10mg/mL Solucion Inyectable IV Caja Amp. X 1 mL x 50 PHARMAGEN'),
(121, 'FLAGYL 500 mg OVULO x 10  SANOFI  E-14214'),
(122, 'FLAGYSTATINE  Ovulo Caja Ov. x 10 unid. SANOFI - E14355'),
(123, 'FLAPLEX-E x 100 CAP ABL PHARMA'),
(124, 'FLORATIL 250mg Polvo para Suspension Oral Caja Sobre x 10 unid. AXON - BE00822'),
(125, 'FLUCONAZOL 150mg Capsula Caja Cap. x 2 unid. NAT . Y GENER'),
(126, 'FLUCONAZOL 150mg Tableta Caja Tab. x 100 unid. AC FARMA - NG2558'),
(127, 'FLUCONAZOL 150mg Tableta Caja Tab. x 100 unid. NAT. Y GEN. - NG5260'),
(128, 'FLUNGOFYL 200 mg x 100 ml OTARVASQ'),
(129, 'FRUTENZYMA ENZIMAS DIGESTIVAS FARMINDUSTRIA C 120 CAP'),
(130, 'FURAZOLIDONA 50 mg/15 ml x 120 ML PORTUGAL '),
(131, 'FUROSEMIDA 20 mg 2 ml x 100 UND SANDERSON'),
(132, 'FUROSEMIDA 40 mg TAB x 100 UND FARMINDUSTRIA'),
(133, 'GASEOPLUS GOTAS x 15 ml HERSIL'),
(134, 'GEMFIBROZILO 600mg Tableta Caja Tab. x 100 unid. NAT. Y GEN. - NG3231'),
(135, 'GENFARBET-3 CREMA 20 G GENFAR'),
(136, 'GENTAMICINA 0,3% SOL OFT 5 ml CAJA x 1 FRASCO - LUSA'),
(137, 'GENTAMICINA 160mg/2mL Solucion para Inyeccion Caja Amp. X 2 mL x 10 UND VITALIS'),
(138, 'GENTAMICINA 80mg/2mL Inyectable Amp. X 2 mL x 50 PHARMAGEN'),
(139, 'GINEDAZOL  Ovulo Disp. Ov. x 100 unid. TEVA - E8032'),
(140, 'GINGISONA - B PASTILLA x 60 SOBRES TEVA'),
(141, 'GINGISONA B 0.3% Spray Fco. Spray X 15 mL x 1 unid. TEVA - E20671'),
(142, 'GLIBENCLAMIDA 5mg Tableta Caja Tab. x 100 unid. FARMINDUSTRIA'),
(143, 'GLUCONATO DE CALCIO 10% Solucion para Inyeccion Caja Amp. x 10 mL x 25 DANY'),
(144, 'GRAVOL 50mg Tableta Caja Tab. x 100 unid. MEDIFARMA - N2867'),
(145, 'GRIPALIV x 100 TAB NAT Y GEN'),
(146, 'HEPABIONTA AMP x 3 UND - MERCK'),
(147, 'HEPABIONTA x 100 GAGEAS - MERCK'),
(148, 'HIDROCLOROTIAZIDA 50mg Tableta Caja Tab. x 30 unid. GENFAR - EG3036'),
(149, 'HIDROCORTISONA 100mg Polvo para Solucion Inyectable Caja Fco. Amp. x 1 unid. PHARMAGEN - '),
(150, 'HIIDROCLOROTIAZIDA 25 mg x 100 TAB - MEDROCK'),
(151, 'HIIDROCLOROTIAZIDA 12.5 mg x 100 TAB - MEDROCK'),
(152, 'HIDROXIDO DE ALUMINIO + HIDROXIDO DE MAGNESIO x 120 ML PORTUGAL'),
(153, 'HIDROXIDO DE ALUMINIO + HIDROXIDO DE MAGNESIO x 120 ML con caja  PORTUGAL'),
(154, 'HIOSCINA BUTIL BROMURO 20 mg x10 AMP VITALIS'),
(155, 'IBUPROFENO 100mg/5mL Suspension Caja Fco. X 60 mL x 1 unid. FARMINDUSTRIA'),
(156, 'IBUPROFENO 400 mg x 100 TAB NAT Y GEN'),
(157, 'IBUPROFENO 400 mg x 100 TAB FARMINDUSTRIA'),
(158, 'IBUPROFENO 800 mg x 100 UND NAT Y GEN'),
(159, 'KALIUM 20% Solucion para Inyeccion Amp. X 10 mL x 25 unid. LUSA - N264'),
(160, 'KETAMINA 500 mg / 10 ml x 10 AMP SANDERSON'),
(161, 'KETANEN 60 mg/ml x 25 UND OTARVASQ (KETOROLACO 60 mg)'),
(162, 'KETOCONAZOL 2% Crema Tubo X 20 g x 1 unid. PORTUGAL - NG4769'),
(163, 'KETOCONAZOL 200mg Tableta Caja Tab. x 100 unid. MEDROCK'),
(164, 'KETOPAN 100 mg (ketoprofeno IV ) x 25 AMP OTARVASQ '),
(165, 'KETOPROFENO 100 mg IM AMP x 6 AMP GENFAR'),
(166, 'KETOPROFENO 100mg Tableta Caja Tab. x 100 unid. INDUQUIMICA - NG3306'),
(167, 'KETOROLACO 10mg Tableta Caja Tab. x 100 unid. INDUQUIMICA'),
(168, 'KETOROLACO 30 mg INY 1 ml x 100 AMP SANDERSON'),
(169, 'KETOROLACO 30 mg/ ml x 25 UND - DANY'),
(170, 'KITADOL MIGRANA X 80 TAB - TEVA'),
(171, 'LACTATO RINGER  Solucion para Inyeccion Amp. X 10 mL x 25 unid. LUSA - NG3616'),
(172, 'LACTULOSA 3.3g/5mL Solucion Oral Caja Fco. X 120 mL x 1 unid. PORTUGAL - NG5885'),
(173, 'LANSOPRAZOL 30mg Capsula de Liberacion Retardada Caja Cap. x 100 unid. NAT. Y GEN. - NG5655'),
(174, 'LEVOCTRIM 500mg Tableta Recubierta Caja Tab. x 10 unid. NAT. Y GEN. - N25193'),
(175, 'LIDOCAINA 2 % CON EPINEFRINA SIN PRESERVANTE 2% Solucion para Inyeccion Caja Fco. Vial X 20 mL x 25 unid. LUSA - NG5285'),
(176, 'LIDOCAINA 2% Solucion para Inyeccion Vial X 20 mL x 1 unid. LUSA - NG1206'),
(177, 'LINCOMICINA 500 mg x 20 CAP FARMINDUSTRIA'),
(178, 'LINCOMICINA 600 mg INY 2 ml CAJA x 6 AMP GENFAR'),
(179, 'LOPERAMIDA 2mg Tableta Caja Tab. x 100 unid. NAT. Y GEN. - NG6412'),
(180, 'LORATADINA 10 mg TAB x 100 UND NG-6371'),
(181, 'LOSARTAN 50 mg TAB x 60 UND MARFAN'),
(182, 'MAGNESOL  x 33 SOBRES CIFARMA'),
(183, 'MAGNESOL x 33 SOBRE SABOR NARANJA'),
(184, 'MEBENDAZOL 100mg Tableta Caja Tab. x 100 unid. NAT. Y GEN. - NG3038'),
(185, 'MEDICORT 4 MG INY/2 ml MEDIFARMA'),
(186, 'MELOXICAM 15 mg Tableta Caja Tab. x 100 unid. NAT. Y GEN. - NG6196'),
(187, 'MENTHOLATUM  Ungüento Tubo X 5 g x 1 unid. MEDIFARMA - N2187'),
(188, 'MERGYNEX  PLUS 1.5mg Tableta Caja Tab. x 30 unid. OQ PHARMA - E21090'),
(189, 'METAMIZOL SODICO 1g/2mL Solucion para Inyeccion Caja Amp. x 100 MACROFARMA'),
(190, 'METAMIZOL SODICO 500mg/mL Solucion Oral Caja Env. X 10 mL x 1 unid. PORTUGAL - NG4555'),
(191, 'METFORMINA CLORHIDRATO 850mg Tableta Caja Tab. x 100 unid. NAT. Y GEN. - NG5631'),
(192, 'METOCLOPRAMIDA 10mg/2mL Inyectable Caja Amp. X 2 mL x 100 unid. BIOSANO'),
(193, 'METRONIDAZOL 250 mg x 60 ml FCO PORTUGAL '),
(194, 'METRONIDAZOL 500mg OVULOS X 10 UND NAT Y GENER'),
(195, 'METRONIDAZOL 500mg Tableta Caja Tab. x 100 unid. NAT. Y GEN. - NG3175'),
(196, 'METROSTAT 500mg/100mL Solucion para Inyeccion Caja Fco. Amp. x 1 unid. NORDIC - E19214'),
(197, 'MISOPROLEN 250 mcg x 30 TAB INTIPHARMA SAC'),
(198, 'MIODOLEN RELAX x 60 TAB RECUBIERTAS NATURGEN'),
(199, 'MULTIACTIV x 60 CAP NATURGEN'),
(200, 'MYCTRIM BALSAMICO x 100 TAB REC MEDROCK'),
(201, 'NAPROXENO 550mg Tableta Caja Tab. x 100 unid. FARMINDUSTRIA NG-3607'),
(202, 'NAPROXENO SODICO 275mg Tableta Caja Tab. x 100 unid. NAT. Y GEN. - NG3179'),
(203, 'NASTIZOL  Jarabe Fco. X 60 mL x 1 unid. BAGO - E12727'),
(204, 'NASTIZOL COMPOSITUM NF ANTIGRIPAL  Capsula Caja Cap. x 200 unid. BAGO - E21648'),
(205, 'NEOSTIGMINA METIL SULFATO 0.5mg/mL Solucion para Inyeccion Caja Amp. x 1 unid. SANDERSON - EG957'),
(206, 'NIKZON x 90 UND GENOMA LAB'),
(207, 'NOVALGINA 500mg Tableta Caja Tab. x 100 unid. SANOFI - E21807'),
(208, 'OMEPRAZOL 20 mg x 100 CAP PORTUGAL'),
(209, 'OMEPRAZOL 40mg Inyectable Caja Vial x 10 unid. VITALIS'),
(210, 'ORFENADRINA CITRATO 100mg Tableta Caja Tab. x 100 unid. FARMINDUSTRIA'),
(211, 'ORFENADRINA CITRATO 60mg/2mL Solucion para Inyeccion Caja Amp. X 2 mL x 25 unid.FARMINDUSTRIA'),
(212, 'OXACILINA 1 gr/VIAL x 10 VIALES PHARMAGEN'),
(213, 'OXACILINA 1 gr/VIAL x 10 VIALES VITALIS'),
(214, 'OXITOCINA 10UI/mL Solucion para Inyeccion Caja Amp. X 1 mL x 100 unid. SANDERSON'),
(215, 'PANADOL EFERVESCENTE x 24 TAB GSK'),
(216, 'PANADOL ANTIGRIPAL x 100 TAB GSK'),
(217, 'PANADOL PARA NINOS TABLETA MASTICABLE CAJ x 100 UND GSK'),
(218, 'PANTOPRAZOL 40 mg x 14 TAB FARMINDUSTRIA'),
(219, 'PARACETAMOL 120mg/5mL Jarabe Env. X 60 mL c/caja x 1 unid. PORTUGAL - NG2481'),
(220, 'PARACETAMOL 100 mg/ ml GTAS x 10 ml CAJA PORTUGAL'),
(221, 'PARACETAMOL 500mg Tableta Caja Tab. x 100 unid. NAT. Y GEN. - NG3030'),
(222, 'PIRIALIVx 100 mg x 30 TAB'),
(223, 'PIRIDOXINA CLORHIDRATO 300mg/3mL Solucion para Inyeccion Caja Amp. X 3 mL x 25 unid. DANY - NG5323'),
(224, 'PLATSIDERM x 20 gr TUBO CON CAJA PORTUGAL'),
(225, 'PLIDAN COMPUESTO NF x 100 TAB ROEMERS'),
(226, 'PORTIL  Crema Caja Tbo. X 20 g x 1 unid. PORTUGAL - N19660'),
(227, 'PREDNISONA 5 mg TABLETA x 100 UNID PORTUGAL'),
(228, 'PREDNISONA 20mg Tableta Caja Tab. x 100 unid. Quimica suiza'),
(229, 'PREDNISONA 20mg Tableta Caja Tab. x 100 unid.  ACFARMA'),
(230, 'PREDNISONA 5mg/5mL Jarabe Caja Fco. X 60 mL x 1 unid. PORTUGAL - NG5485'),
(231, 'RANITIDINA 300mg Tableta Caja Tab. x 100 unid. Farmindustria'),
(232, 'RANITIDINA 300mg Tableta Caja Tab. x 100 unid. PORTUGAL'),
(233, 'RANITIDINA 150mg Tableta Caja Tab. x 100 unid. Farmindustria'),
(234, 'RANITIDINA 50mg Inyectable Amp x 10 AMP VITALIS'),
(235, 'REPRIMAN 500mg Comprimido Caja Comp. x 100 unid. QUIMICA SUIZA - N20459'),
(236, 'RESPIRA MEJOR x 10 TIRAS'),
(237, 'REUMAFROST  Pomada Pote X 100 g x 1 unid. PORTUGAL - N22179'),
(238, 'REUMAFROST  Pomada Pote X 60 g x 1 unid. PORTUGAL - N22179'),
(239, 'REUMAFROST POMADA POTE x 30 gr x 1 UND PORTUGAL'),
(240, 'ROWATINEX  Capsula Blanda Caja Cap. x 100 unid. DROG. REYES - E20683'),
(241, 'SAL DE ANDREWS TRIPLE ACCION x 90 SOBRES '),
(242, 'SAL DE ANDREWS 5 gr X 100 UND'),
(243, 'SALVADO DE TRIGO x 300 gr PORTUGAL'),
(244, 'SILDENAFILO 50mg Tableta Caja Tab. x 4 unid. NAT. Y GEN. - NG4785'),
(245, 'SILDENAFILO 100mg Tableta Caja Tab. x 4 unid. NAT. Y GEN. - NG4227'),
(246, 'SIMEVET 80 mg x 15 ml  PORTUGAL'),
(247, 'SINACHIS  Tableta Recubierta Caja Tab. x 120 unid. CONTINENTAL - N23746'),
(248, 'SUCRAGANT  1 g x 200 ml ROXFARMA'),
(249, 'SULFAMETOXAZOL + TRIMETOPRIMA + GUAIFENESINA 200mg+40mg+50mg/5mL Suspension Fco. X 60 mL x 1 unid. PORTUGAL - NG2988'),
(250, 'SULFAMETOXAZOL + TRIMETOPRIMA 200 mg + 40 mg/5 ml x 60 ml CAJA PORTUGAL'),
(251, 'SULFAMETOXAZOL + TRIMETOPRIMA 800mg+160mg Tableta Caja Tab. x 100 unid. NAT. Y GEN. - NG3180'),
(252, 'SULFAMETOXAZOL + TRIMETOPRIMA 400mg+80mg Tableta Caja Tab. x 100 unid. NAT. Y GEN. '),
(253, 'SUBSALICILATO DE BISMUTO 87.33 X 15 ML x 150 ML PORTUGAL'),
(254, 'SULFATO FERROSO 300mg Tableta Caja Tab. x 100 unid. NAT. Y GEN. - NG5931'),
(255, 'SULFATO FERROSO 300mg Tableta Caja Tab. x 100 unid. TEVA - NG1070'),
(256, 'SULFATO FERROSO 75 mg /5 ml x 180 ml CAJA PORTUGAL'),
(257, 'SULFATO DE MAGNESIO 20 % AMP PHARMAGEN'),
(258, 'TAMSULOSINA 0,40 mg x 50 CAP AC FARMA'),
(259, 'TAPSIN COMPUESTO CALIENTE DIA CITRUS  Polvo para Solucion Oral Caja Sobre x 24 unid. MAVER - E19321'),
(260, 'TERBINAFINA 1 % x 20 gr PORTUGAL'),
(261, 'TERBINAFINA 250 mg x 100 TAB PORTUGAL'),
(262, 'TIOCTAN FORTE  Gragea Caja Grag. x 100 unid. FARMINDUSTRIA - N4664'),
(263, 'TRAMADOL 10 mg x 2 ml INY CAJA x 100 AMP'),
(264, 'ULCEPRAZOLE 20 mg x 100 CAP  JPS '),
(265, 'URODIF FORTE  Tableta Caja Tab. x 100 unid. ANDREU - N21407'),
(266, 'UROQUILAB  Comprimido Recubierto Caja Comp. x 100 unid. QUIMICA SUIZA - N20788'),
(267, 'VITACOSE SOL INY 2 ml + 1 JERINGA CIPA'),
(268, 'VITAMINA C GENFAR X 144 TAB MAST x 12 PAQ'),
(269, 'VOLTAREN 50mg Gragea Caja Grag. x 30 unid. NOVARTIS BIOSCIENCES - E21425'),
(270, 'ZALDIAR (TRAMADOL/PARACETAMOL 37,5/ 325 mg x 10 COMPR GRUNENTHAL E-17534'),
(271, 'ZALDIAR (TRAMADOL/PARACETAMOL 37,5/ 325 mg x 60 COMPR GRUNENTHAL E-17534'),
(272, 'AMERITON (NITROFURAL 0.2 %) x 30 GR CREMA AMERICA'),
(273, 'AGUA SAN LUIS x 625 ml'),
(274, 'ALGODON CKF x 25 gr'),
(275, 'ALGODON CKF x 10 gr'),
(276, 'ALGODON STERILAB x 50 gr'),
(277, 'ALGODON COPPON x 100 gr'),
(278, 'ALGODON COPPON x 25 gr'),
(279, 'ALGODON COPPON x 50 gr'),
(280, 'AQUARIUS x 500 ml'),
(281, 'BABY TEST'),
(282, 'BICARBONATO DE SODIO POTE X 100 GRAMOS PORTUGAL'),
(283, 'BLOQUEADOR SOLAR 45 x 20 SACHETS'),
(284, 'BLOQUEADOR SOLAR BAHIA KIDS 45 x 20 SACHETS'),
(285, 'BLOQUEADOR SOLAR BAHIA 90 x 20 SACHETS'),
(286, 'CERA DENTAL  x 12 UND PORTUGAL'),
(287, 'COLGATE TRIPLE ACCION x 75 ml '),
(288, 'CORTAUNAS ADULTO'),
(289, 'CREMA NIVEA x 30 GR'),
(290, 'GATORADE x 500 ml'),
(291, 'GATORADE x 550 ml'),
(292, 'SHICK HOJA DE AFEITAR'),
(293, 'HISOPOS DESCARTABLES 100 UND'),
(294, 'HISOPOS DUBBIES'),
(295, 'HISOPOS x 75 COTONETES'),
(296, 'INTIMA x 24 SACHET'),
(297, 'JABON CAMAY x 90 gr'),
(298, 'JABON CARBOLICO x 2 '),
(299, 'JABON HENO DE PRAVIA x 85 gr'),
(300, 'JABON NEKO ANTIBACTERIAL x 75 gr'),
(301, 'LIPSTICK X 7 - PORTUGAL'),
(302, 'LIPSALIV x 100  PORTUGAL'),
(303, 'MENTOL CHINO'),
(304, 'NITRATO DE PLATA 3 GR X 12 LAPICES - PORTUGAL'),
(305, 'OLD SPICE DESODORANTE x 150 ml'),
(306, 'DENTO ANTISARRO x 75 GR'),
(307, 'DENTITO x 90 ml'),
(308, 'OXIDO DE ZINC x 50 gr'),
(309, 'PAMPERS G x 8 UND'),
(310, 'PAMPERS XXG x 8 UND'),
(311, 'PAMPERS XG x 8 UND'),
(312, 'PANUELOS ELITE x 27 PAQ'),
(313, 'PAPEL TOALLA ELITE'),
(314, 'PAPEL HIGIENICO SUAVE x 2 '),
(315, 'PONDS  C x 20 SACHETS'),
(316, 'PONDS CLARANT PIEL GRASA x 20 SACHETS'),
(317, 'PONDS CLARANT PIEL SECA x 20 SACHETS'),
(318, 'POWERADE x 473 ml'),
(319, 'PRACTIPANAL x 10'),
(320, 'PRESERVATIVOS MALE x 3 x 48 SOB'),
(321, 'PRESERVATIVOS PIEL CLASICO x 3 x 24 CAJ'),
(322, 'PRESERVATIVOS PIEL CON AROS x 3 x 24 CAJ'),
(323, 'PRESERVATIVOS PIEL FANTASIA x 3 x 24 CAJ'),
(324, 'PRESERVATIVOS PIEL SENSITIVO x 3 x 24 CAJ'),
(325, 'PRESERVATIVOS SENSATION x 3 x 60 CAJ'),
(326, 'PRESERVATIVOS GENTS RETARDANTE x 24 CAJ x 3 UND'),
(327, 'PRESERVATIVOS GENTS (3X) x 24 CAJ x 3 UND'),
(328, 'PRESERVATIVOS GENTS AROS x 24 CAJ x 3 UND'),
(329, 'TOALLITAS HUMEDAS TUINIES x 48'),
(330, 'QUITA ESMALTE x 70 ml - PORTUGAL'),
(331, 'REXONA MEN x 18'),
(332, 'SHAMPOO SEDAL 2 EN 1 x 20 SACHETS'),
(333, 'SHAMPO H & S x 90 ml (MEN)'),
(334, 'TALCO JHONSONS x 100 gr'),
(335, 'TENSOPLAST 10 cm x 4.5 m'),
(336, 'TENSOPLAST 5 cm x 4.5 m'),
(337, 'TENSOPLAST 7.5 cm x 4.5 m'),
(338, 'TETINA PARA LAPIO LEPORINO NUK MEDIC PRO'),
(339, 'TOALLAS HIGIENICAS DIARIAS KOTEX x 15 '),
(340, 'TOALLAS HIGIENICAS INDIVIDUALES'),
(341, 'TOALLAS HIGIENICAS KOTEX  NORMAL x10'),
(342, 'TOALLAS HIGIENICAS NOSOTRAS NORMAL x 10'),
(343, 'TOALLAS HIGIENICAS NOSOTRAS NOCHE x 10'),
(344, 'VASELINA x 30 GR SIN PERFUME'),
(345, 'VENDITAS x 100 CUREBAND'),
(346, 'ESTETOSCOPIO ( REPUESTO)'),
(347, 'SHICK EXACTA 2'),
(348, 'GILLETTE PRESTOBARBA ULTRAGRIP'),
(349, 'PILAS PANASONIC AA x 2 UND  CAJA x 10 PARES'),
(350, 'ALGODON 5GR');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `presentacion`
--

DROP TABLE IF EXISTS `presentacion`;
CREATE TABLE IF NOT EXISTS `presentacion` (
  `id` int(11) NOT NULL,
  `nomPresent` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `presentacion`
--

INSERT INTO `presentacion` (`id`, `nomPresent`) VALUES
(1, 'presentacion 1'),
(2, 'crema'),
(3, 'ampolla'),
(4, 'Tabletas'),
(5, 'Crema'),
(6, 'Spray'),
(7, 'BOLSA'),
(8, 'Carton');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
CREATE TABLE IF NOT EXISTS `proveedor` (
  `idProv` int(11) NOT NULL,
  `nombreProv` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`idProv`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`idProv`, `nombreProv`) VALUES
(1, 'laboratorio1'),
(2, 'ace farma'),
(3, 'Intilee'),
(4, 'Lab5'),
(5, 'bayer'),
(6, 'labora percy');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `idUser` int(11) NOT NULL,
  `nombreUser` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL,
  `passwordUser` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL,
  `activoUser` tinyint(1) DEFAULT NULL,
  `fechaCreacion` date DEFAULT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUser`, `nombreUser`, `passwordUser`, `activoUser`, `fechaCreacion`) VALUES
(1, 'sa', 'sa', 1, '2018-02-14');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
