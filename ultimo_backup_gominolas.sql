-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: gominolas
-- ------------------------------------------------------
-- Server version	5.7.13-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `ci` varchar(10) NOT NULL,
  PRIMARY KEY (`ci`),
  CONSTRAINT `FK_Generalization_2` FOREIGN KEY (`ci`) REFERENCES `persona` (`ci`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('0400688669'),('1718323213');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleado` (
  `ci` varchar(10) NOT NULL,
  `contrasena` varchar(254) DEFAULT NULL,
  `cargo` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`ci`),
  CONSTRAINT `FK_Generalization_1` FOREIGN KEY (`ci`) REFERENCES `persona` (`ci`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES ('1234567897','12345','empleado'),('1718323205','12345','empleado'),('1718323221','12345','empleado'),('1718977687','12345','gerente'),('1718977703','12345','empleado');
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nota_venta`
--

DROP TABLE IF EXISTS `nota_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nota_venta` (
  `numero` int(11) NOT NULL,
  `ci_cli` varchar(10) DEFAULT NULL,
  `nombre_pro` varchar(50) DEFAULT NULL,
  `fecha_contrato` date DEFAULT NULL,
  `fecha_evento` date DEFAULT NULL,
  PRIMARY KEY (`numero`),
  KEY `FK_Association_3` (`ci_cli`),
  KEY `FK_Reference_10` (`nombre_pro`),
  CONSTRAINT `FK_Association_3` FOREIGN KEY (`ci_cli`) REFERENCES `cliente` (`ci`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`nombre_pro`) REFERENCES `promocion` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nota_venta`
--

LOCK TABLES `nota_venta` WRITE;
/*!40000 ALTER TABLE `nota_venta` DISABLE KEYS */;
INSERT INTO `nota_venta` VALUES (1,'0400688669','Añonuevo','2019-01-25','2019-01-28'),(2,'0400688669','Añonuevo','2019-01-25','2019-02-01'),(3,'0400688669',NULL,'2019-01-25','2019-03-02'),(4,'0400688669',NULL,'2019-01-25','2019-01-26'),(5,'0400688669',NULL,'2019-01-25','2019-02-23'),(6,'0400688669','Añonuevo','2019-01-25','2019-01-27'),(7,'0400688669','Añonuevo','2019-01-25','2019-03-11'),(8,'1718323213','Añonuevo','2019-01-25','2019-01-26');
/*!40000 ALTER TABLE `nota_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paquete`
--

DROP TABLE IF EXISTS `paquete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paquete` (
  `nombre` varchar(50) NOT NULL,
  `costo` float DEFAULT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paquete`
--

LOCK TABLES `paquete` WRITE;
/*!40000 ALTER TABLE `paquete` DISABLE KEYS */;
INSERT INTO `paquete` VALUES ('Alegría',65),('Bombón',80),('Diversión',95),('Estelar',105),('Felicidad',85),('Gominola',35),('hola',60),('Regalo',25),('Sorpresa',145);
/*!40000 ALTER TABLE `paquete` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paquete_nota`
--

DROP TABLE IF EXISTS `paquete_nota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paquete_nota` (
  `nombre` varchar(50) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  KEY `FK_Reference_8` (`nombre`),
  KEY `FK_Reference_9` (`numero`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`nombre`) REFERENCES `paquete` (`nombre`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`numero`) REFERENCES `nota_venta` (`numero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paquete_nota`
--

LOCK TABLES `paquete_nota` WRITE;
/*!40000 ALTER TABLE `paquete_nota` DISABLE KEYS */;
INSERT INTO `paquete_nota` VALUES ('Diversión',1),('Alegría',2),('Gominola',3),('Alegría',4),('Estelar',5),('Estelar',6),('Alegría',7),('Alegría',8);
/*!40000 ALTER TABLE `paquete_nota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `ci` varchar(10) NOT NULL,
  `nombre` varchar(254) DEFAULT NULL,
  `apellido` varchar(254) DEFAULT NULL,
  `direccion` varchar(254) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `correo` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`ci`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES ('0000000000','sadsda','sadsd','sadasd','1232131231','dsa@espe.edu'),('0400688669','Demetrio','Poma','Quito','0996587782','dempo@hotmail.com'),('1234567897','Jhon','Arcos','Quito','0225485544','jhon@espe.com'),('1718323205','Diego','Arcos','Latacunga','0999555078','diegoa@hotmail.com'),('1718323213','Jhon','Arcos','Miranda','0995597046','jhondari@hotmail.com'),('1718323221','Jhon','Arcos','Loja','5645456654','jhon@espe.edu'),('1718977687','Silvana','Silva','Quito','123044455','silvy@gmail.com'),('1718977703','Heidy','Silva','Loma de Puengasí','022606392','heidysilva1@hotmail.com');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promocion`
--

DROP TABLE IF EXISTS `promocion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `promocion` (
  `nombre` varchar(50) NOT NULL,
  `descuento` float DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promocion`
--

LOCK TABLES `promocion` WRITE;
/*!40000 ALTER TABLE `promocion` DISABLE KEYS */;
INSERT INTO `promocion` VALUES ('Añonuevo',10,'2019-01-01','2019-01-31'),('Carnaval',10,'2019-01-01','2019-05-01'),('Cliente frecuente',15,'2019-01-01','2019-12-31'),('Corporativo',25,'2019-01-01','2019-12-31'),('Día del amor',10,'2019-02-01','2019-02-20');
/*!40000 ALTER TABLE `promocion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicio`
--

DROP TABLE IF EXISTS `servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servicio` (
  `nombre` varchar(100) NOT NULL,
  `costo` float DEFAULT NULL,
  `descripcion` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicio`
--

LOCK TABLES `servicio` WRITE;
/*!40000 ALTER TABLE `servicio` DISABLE KEYS */;
INSERT INTO `servicio` VALUES ('arreglo de escenario',60,'Manteles de mesa principal, arcos de globos y piñata'),('Fotografías',30,'Material fotográfico digital (50 fotos/videos) y fotografías impresas(20 fotos)'),('globoforma',10,'Realización de figuras con globos (50 unidades)'),('hora animador',25,'Una hora de animacion con dinamicas grupales para adultos y niños'),('hora animador adicional',15,'Una hora de animacion con dinamicas grupales para adultos y niños'),('hora inflable grande',50,'Una hora de uso de saltarín inflable grande, capacidad para 30 niños'),('hora inflable pequeño',30,'Una hora de uso de saltarín inflable pequeño, capacidad para 10 niños'),('hora maquina de burbujas',20,'Una hora de uso de maquina de burbujas, incluye liquido necesario'),('hora maquina de humo',20,'Una hora de uso de maquina de humo, incluye liquido necesario'),('Mago',50,'Show de mago de aproximadamente 30 minutos'),('mimo',60,'Show de mimo de aproximadamente 30 minutos'),('pastel',20,'Una hora de animacion con dinamicas grupales para adultos y niños'),('personaje adicional',20,'Personaje adicional que acompaña en la animación'),('piñata',20,'Piñata de personaje a elección del cliente'),('pintucaritas',15,'Pintura de heroes y personajes en rostros infantiles (50 niños)');
/*!40000 ALTER TABLE `servicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicio_nota`
--

DROP TABLE IF EXISTS `servicio_nota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servicio_nota` (
  `nombre` varchar(100) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  KEY `FK_Reference_6` (`nombre`),
  KEY `FK_Reference_7` (`numero`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`nombre`) REFERENCES `servicio` (`nombre`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`numero`) REFERENCES `nota_venta` (`numero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicio_nota`
--

LOCK TABLES `servicio_nota` WRITE;
/*!40000 ALTER TABLE `servicio_nota` DISABLE KEYS */;
INSERT INTO `servicio_nota` VALUES ('globoforma',1),('globoforma',2),('mimo',2),('hora inflable grande',3),('Fotografías',3),('Mago',3),('piñata',4),('Fotografías',6),('globoforma',6),('pastel',6),('piñata',7),('hora animador adicional',8);
/*!40000 ALTER TABLE `servicio_nota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicio_paquete`
--

DROP TABLE IF EXISTS `servicio_paquete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servicio_paquete` (
  `nombre_ser` varchar(100) DEFAULT NULL,
  `nombre_pac` varchar(50) DEFAULT NULL,
  KEY `FK_Reference_4` (`nombre_ser`),
  KEY `FK_Reference_5` (`nombre_pac`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`nombre_ser`) REFERENCES `servicio` (`nombre`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`nombre_pac`) REFERENCES `paquete` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicio_paquete`
--

LOCK TABLES `servicio_paquete` WRITE;
/*!40000 ALTER TABLE `servicio_paquete` DISABLE KEYS */;
INSERT INTO `servicio_paquete` VALUES ('hora animador','Regalo'),('hora animador','Gominola'),('hora animador','Alegría'),('hora animador adicional','Alegría'),('pintucaritas','Alegría'),('hora animador','Sorpresa'),('hora animador adicional','Sorpresa'),('pintucaritas','Sorpresa'),('hora maquina de burbujas','Sorpresa'),('hora animador','Diversión'),('hora animador adicional','Diversión'),('pintucaritas','Diversión'),('hora inflable pequeño','Diversión'),('hora animador','Felicidad'),('hora animador adicional','Felicidad'),('personaje adicional','Felicidad'),('pintucaritas','Felicidad'),('hora animador','Estelar'),('hora animador adicional','Estelar'),('personaje adicional','Estelar'),('personaje adicional','Estelar'),('pintucaritas','Estelar'),('mimo','Sorpresa'),('arreglo de escenario','hola'),('Fotografías','hola'),('hora animador','Bombón'),('piñata','Bombón'),('pintucaritas','Bombón'),('piñata','Bombón'),('hora animador adicional','Alegría');
/*!40000 ALTER TABLE `servicio_paquete` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'gominolas'
--
/*!50003 DROP FUNCTION IF EXISTS `registrarEmpleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `registrarEmpleado`(ci1 varchar(10),nombre1 varchar(254), apellido1 varchar(254), direccion1 varchar(254), telefono1 varchar(10), correo1 varchar(254), contraseña1 varchar(254), cargo1 varchar(8)) RETURNS int(11)
BEGIN
INSERT INTO persona VALUES (ci1,nombre1,apellido1,direccion1,telefono1,correo1);
INSERT INTO empleado VALUES (ci1,contraseña1,cargo1);
RETURN 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminarEmp` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarEmp`(ci1 varchar(10))
BEGIN
DELETE FROM empleado WHERE empleado.ci=ci1;
DELETE FROM persona WHERE persona.ci=ci1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `modificarEmp` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarEmp`(ci1 varchar(254),nombre1 varchar(254), apellido1 varchar(254), direccion1 varchar(254), telefono1 varchar(10), correo1 varchar(254))
BEGIN
UPDATE persona SET nombre=nombre1, apellido=apellido1,direccion=direccion1,telefono=telefono1,correo=correo1 WHERE ci=ci1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `modificarEmp1` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarEmp1`(ci1 varchar(10),nombre1 varchar(254), apellido1 varchar(254), direccion1 varchar(254), telefono1 varchar(10), correo1 varchar(254), contraseña1 varchar(254))
BEGIN
UPDATE persona SET nombre=nombre1, apellido=apellido1,direccion=direccion1,telefono=telefono1,correo=correo1 WHERE persona.ci=ci1;
UPDATE empleado SET contrasena=contraseña1 WHERE empleado.ci=ci1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `registrarEmp` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `registrarEmp`(ci1 varchar(10),nombre1 varchar(254), apellido1 varchar(254), direccion1 varchar(254), telefono1 varchar(10), correo1 varchar(254), contraseña1 varchar(254), cargo1 varchar(8))
BEGIN
INSERT INTO persona VALUES (ci1,nombre1,apellido1,direccion1,telefono1,correo1);
INSERT INTO empleado VALUES (ci1,contraseña1,cargo1);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `restablecerCon` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `restablecerCon`(ci1 varchar(10))
BEGIN
UPDATE empleado SET contrasena="12345"WHERE ci=ci1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-28  8:29:47
