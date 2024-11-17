-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: dsw
-- ------------------------------------------------------
-- Server version	8.0.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bebida`
--

DROP TABLE IF EXISTS `bebida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bebida` (
  `graduacionAlcohol` double DEFAULT NULL,
  `tamaño` int DEFAULT NULL,
  `id_item_menu` int NOT NULL,
  PRIMARY KEY (`id_item_menu`),
  CONSTRAINT `FK5due5g7dlxsqmufj7qftsygqw` FOREIGN KEY (`id_item_menu`) REFERENCES `item_menu` (`id_item_menu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bebida`
--

LOCK TABLES `bebida` WRITE;
/*!40000 ALTER TABLE `bebida` DISABLE KEYS */;
INSERT INTO `bebida` VALUES (0,500,1),(0,500,5),(10,700,6),(15,1500,7),(0,500,8);
/*!40000 ALTER TABLE `bebida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `id_categoria` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `tipo` enum('PLATO','BEBIDA') DEFAULT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Coca Cola','BEBIDA'),(2,'Carne','PLATO'),(3,'Pasta','PLATO'),(4,'Agua','BEBIDA'),(5,'Jugo','BEBIDA'),(6,'Ensalada','PLATO');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `CUIT` varchar(255) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `id_coordenadas` bigint DEFAULT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `UK_tf2g2uahek1nvavm3tbh149wy` (`id_coordenadas`),
  CONSTRAINT `FKd9ov0n1pxpo451gdd1ejyn276` FOREIGN KEY (`id_coordenadas`) REFERENCES `coordenada` (`id_coordenadas`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'20448882226','Santa Fe','pablo@gmail.com',2),(2,'20446661532','Rafaela','ivo@gmail.com',3);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coordenada`
--

DROP TABLE IF EXISTS `coordenada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coordenada` (
  `id_coordenadas` bigint NOT NULL AUTO_INCREMENT,
  `latitud` double DEFAULT NULL,
  `longitud` double DEFAULT NULL,
  PRIMARY KEY (`id_coordenadas`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coordenada`
--

LOCK TABLES `coordenada` WRITE;
/*!40000 ALTER TABLE `coordenada` DISABLE KEYS */;
INSERT INTO `coordenada` VALUES (1,20.156489234,20.156234789),(2,10.156489234,15.156234789),(3,15.156489234,10.156234789);
/*!40000 ALTER TABLE `coordenada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_menu`
--

DROP TABLE IF EXISTS `item_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_menu` (
  `id_item_menu` int NOT NULL AUTO_INCREMENT,
  `aptoVegano` bit(1) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `id_categoria` int DEFAULT NULL,
  PRIMARY KEY (`id_item_menu`),
  KEY `FKogu8lesjpd372witkshsaa31e` (`id_categoria`),
  CONSTRAINT `FKogu8lesjpd372witkshsaa31e` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_menu`
--

LOCK TABLES `item_menu` WRITE;
/*!40000 ALTER TABLE `item_menu` DISABLE KEYS */;
INSERT INTO `item_menu` VALUES (1,_binary '\0','Bebida chica','Coca Cola',2000,1),(2,_binary '\0','Milanesa de carne','Milanesa de carne',5000,2),(3,_binary '','Tomate perita','Ensalada de tomate',2000,6),(4,_binary '\0','Ravioles','Ravioles',4000,3),(5,_binary '','Agua Mineral sin gas','Agua',1500,4),(6,_binary '\0','Cerveza heineken','Pinta',2000,5),(7,_binary '','Botella de vino malbec','Vino malbec',6000,5),(8,_binary '','Bebida chica','Jugo',1800,4),(9,_binary '\0','Empanada','Empanada',1000,2),(10,_binary '\0','Tallarines','Tallarines',3000,3);
/*!40000 ALTER TABLE `item_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `items_pedido`
--

DROP TABLE IF EXISTS `items_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `items_pedido` (
  `id_items_pedido` int NOT NULL AUTO_INCREMENT,
  `cantidad` int DEFAULT NULL,
  `id_item_menu` int DEFAULT NULL,
  `id_pedido` int NOT NULL,
  PRIMARY KEY (`id_items_pedido`),
  UNIQUE KEY `UK_9aq99a6xru83h6id9eeuog93u` (`id_item_menu`),
  KEY `FKqgixjlxbiehcl92ylo6d5hxx3` (`id_pedido`),
  CONSTRAINT `FKb0wt623dk9m7r40ig841eskgm` FOREIGN KEY (`id_item_menu`) REFERENCES `item_menu` (`id_item_menu`),
  CONSTRAINT `FKqgixjlxbiehcl92ylo6d5hxx3` FOREIGN KEY (`id_pedido`) REFERENCES `pedido` (`id_pedido`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items_pedido`
--

LOCK TABLES `items_pedido` WRITE;
/*!40000 ALTER TABLE `items_pedido` DISABLE KEYS */;
INSERT INTO `items_pedido` VALUES (1,3,2,1),(2,5,9,2);
/*!40000 ALTER TABLE `items_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS `pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pago` (
  `id_pago` int NOT NULL AUTO_INCREMENT,
  `monto` double DEFAULT NULL,
  `metodo_pago` enum('EFECTIVO','TRANSFERENCIA','MERCADOPAGO') DEFAULT NULL,
  PRIMARY KEY (`id_pago`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago`
--

LOCK TABLES `pago` WRITE;
/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
INSERT INTO `pago` VALUES (1,15000,'EFECTIVO'),(2,5000,'MERCADOPAGO');
/*!40000 ALTER TABLE `pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido` (
  `id_pedido` int NOT NULL AUTO_INCREMENT,
  `estado` enum('PENDIENTE','RECIBIDO','PREPARACION','ENVIADO','ENTREGADO','CANCELADO') DEFAULT NULL,
  `id_cliente` int DEFAULT NULL,
  `id_pago` int DEFAULT NULL,
  `id_vendedor` int DEFAULT NULL,
  PRIMARY KEY (`id_pedido`),
  UNIQUE KEY `UK_noah1h1cyxa58ij47111x4um7` (`id_pago`),
  KEY `FKbg7o1pi8ubap1xkv2arvpgtia` (`id_cliente`),
  KEY `FKcjfwpg3ifemx62wana1r1htsd` (`id_vendedor`),
  CONSTRAINT `FKbg7o1pi8ubap1xkv2arvpgtia` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
  CONSTRAINT `FKcjfwpg3ifemx62wana1r1htsd` FOREIGN KEY (`id_vendedor`) REFERENCES `vendedor` (`id_vendedor`),
  CONSTRAINT `FKgca3j2ughne4dq99opla814h5` FOREIGN KEY (`id_pago`) REFERENCES `pago` (`id_pago`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (1,'PENDIENTE',1,1,1),(2,'ENTREGADO',2,2,1);
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plato`
--

DROP TABLE IF EXISTS `plato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plato` (
  `aptoCeliaco` bit(1) DEFAULT NULL,
  `aptoVegetariano` bit(1) DEFAULT NULL,
  `cant_calorias` int DEFAULT NULL,
  `id_item_menu` int NOT NULL,
  PRIMARY KEY (`id_item_menu`),
  CONSTRAINT `FK2jxrt5yov0clool40uhak081b` FOREIGN KEY (`id_item_menu`) REFERENCES `item_menu` (`id_item_menu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plato`
--

LOCK TABLES `plato` WRITE;
/*!40000 ALTER TABLE `plato` DISABLE KEYS */;
INSERT INTO `plato` VALUES (_binary '\0',_binary '\0',400,2),(_binary '',_binary '',22,3),(_binary '\0',_binary '',355,4),(_binary '\0',_binary '\0',300,8),(_binary '\0',_binary '',250,9);
/*!40000 ALTER TABLE `plato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendedor`
--

DROP TABLE IF EXISTS `vendedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendedor` (
  `id_vendedor` int NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `DNI` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `id_coordenadas` bigint DEFAULT NULL,
  PRIMARY KEY (`id_vendedor`),
  UNIQUE KEY `UK_bs8u1xk90958kdpr8ugfub35n` (`id_coordenadas`),
  CONSTRAINT `FKgavtt1o5fq23iwamc4nxx5pra` FOREIGN KEY (`id_coordenadas`) REFERENCES `coordenada` (`id_coordenadas`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendedor`
--

LOCK TABLES `vendedor` WRITE;
/*!40000 ALTER TABLE `vendedor` DISABLE KEYS */;
INSERT INTO `vendedor` VALUES (1,'Quagliotti','Santo Tome','44888111','Franco',1);
/*!40000 ALTER TABLE `vendedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendedor_item`
--

DROP TABLE IF EXISTS `vendedor_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendedor_item` (
  `id_vendedor` int NOT NULL,
  `id_item_menu` int NOT NULL,
  KEY `FKbyreut6mj8v8ns7ljklgbj6d5` (`id_item_menu`),
  KEY `FK2rkq40gelwhsunlothf7eib69` (`id_vendedor`),
  CONSTRAINT `FK2rkq40gelwhsunlothf7eib69` FOREIGN KEY (`id_vendedor`) REFERENCES `vendedor` (`id_vendedor`),
  CONSTRAINT `FKbyreut6mj8v8ns7ljklgbj6d5` FOREIGN KEY (`id_item_menu`) REFERENCES `item_menu` (`id_item_menu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendedor_item`
--

LOCK TABLES `vendedor_item` WRITE;
/*!40000 ALTER TABLE `vendedor_item` DISABLE KEYS */;
INSERT INTO `vendedor_item` VALUES (1,5),(1,2),(1,10);
/*!40000 ALTER TABLE `vendedor_item` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-16 21:52:50
