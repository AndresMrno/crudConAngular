-- MariaDB dump 10.19  Distrib 10.4.25-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: evaluacionC
-- ------------------------------------------------------
-- Server version	10.4.25-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ciudades`
--

DROP TABLE IF EXISTS `ciudades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ciudades` (
  `id_ciudad` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre_ciudad` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_ciudad`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudades`
--

LOCK TABLES `ciudades` WRITE;
/*!40000 ALTER TABLE `ciudades` DISABLE KEYS */;
INSERT INTO `ciudades` VALUES (1,'Arauca'),(2,'Armenia'),(3,'Barrancabermeja'),(4,'Barranquilla'),(5,'Bogotá D.C'),(6,'Bucaramanga'),(7,'Buenaventura'),(8,'Buga'),(9,'Cali'),(10,'Catagena'),(11,'Cartago'),(12,'Cucuta'),(13,'Manizales'),(14,'Monteria'),(15,'Neiva'),(16,'Palmira'),(17,'Pasto'),(18,'Popayan'),(19,'Santa Marta'),(20,'Valledupar'),(21,'Villavicencio');
/*!40000 ALTER TABLE `ciudades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ocupaciones`
--

DROP TABLE IF EXISTS `ocupaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ocupaciones` (
  `id_ocupacion` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre_ocupacion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_ocupacion`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ocupaciones`
--

LOCK TABLES `ocupaciones` WRITE;
/*!40000 ALTER TABLE `ocupaciones` DISABLE KEYS */;
INSERT INTO `ocupaciones` VALUES (1,'Empleado'),(2,'Independiente'),(3,'Pensionado');
/*!40000 ALTER TABLE `ocupaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `numero_identidad` bigint(20) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `correo_electronico` varchar(255) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `id_ciudad_fk` bigint(20) DEFAULT NULL,
  `id_ocupacion_fk` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`numero_identidad`),
  KEY `FK1b7k0m8r39lmw2mpnavkhgwqm` (`id_ciudad_fk`),
  KEY `FKq4w7g4dh2n70ygf9j7x6yp0uc` (`id_ocupacion_fk`),
  CONSTRAINT `FK1b7k0m8r39lmw2mpnavkhgwqm` FOREIGN KEY (`id_ciudad_fk`) REFERENCES `ciudades` (`id_ciudad`),
  CONSTRAINT `FKq4w7g4dh2n70ygf9j7x6yp0uc` FOREIGN KEY (`id_ocupacion_fk`) REFERENCES `ocupaciones` (`id_ocupacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-18 16:18:38
