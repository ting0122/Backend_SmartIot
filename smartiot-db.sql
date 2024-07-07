-- MySQL dump 10.13  Distrib 8.4.0, for Win64 (x86_64)
--
-- Host: localhost    Database: smartiot
-- ------------------------------------------------------
-- Server version	8.4.0

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
-- Table structure for table `ac`
--

DROP TABLE IF EXISTS `ac`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ac` (
  `id` bigint NOT NULL,
  `current_temp` double DEFAULT NULL,
  `fan_speed` enum('AUTO','HIGH','LOW','MEDIUM') DEFAULT NULL,
  `mode` enum('AUTO','COOL','DRY','FAN','HEAT') DEFAULT NULL,
  `target_temp` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKf91cnl6kisy6k2dt5l4dvjdsu` FOREIGN KEY (`id`) REFERENCES `device` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ac`
--

LOCK TABLES `ac` WRITE;
/*!40000 ALTER TABLE `ac` DISABLE KEYS */;
INSERT INTO `ac` VALUES (27,10.086408785984798,NULL,NULL,0),(28,10,NULL,NULL,0),(29,10.021573065563118,NULL,NULL,0),(30,10.064569697682307,NULL,NULL,0),(31,10.200652985481392,NULL,NULL,0),(32,10.118201729360232,NULL,NULL,0),(33,10,NULL,NULL,0),(34,10.351747326962816,NULL,NULL,0),(35,10,NULL,NULL,0),(36,10.099073013630361,NULL,NULL,0);
/*!40000 ALTER TABLE `ac` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `air_purifier`
--

DROP TABLE IF EXISTS `air_purifier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `air_purifier` (
  `id` bigint NOT NULL,
  `air_quality` int NOT NULL,
  `fan_speed` int NOT NULL,
  `operating_time` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK6n7gmtpxxwf8bqy7hoig88si5` FOREIGN KEY (`id`) REFERENCES `device` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `air_purifier`
--

LOCK TABLES `air_purifier` WRITE;
/*!40000 ALTER TABLE `air_purifier` DISABLE KEYS */;
INSERT INTO `air_purifier` VALUES (1,27,0,0),(2,22,0,0),(3,4,0,0),(4,14,0,0),(5,7,0,0),(6,9,0,0),(7,17,0,0),(8,3,0,0),(9,5,0,0),(10,13,0,0);
/*!40000 ALTER TABLE `air_purifier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dehumidifier`
--

DROP TABLE IF EXISTS `dehumidifier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dehumidifier` (
  `id` bigint NOT NULL,
  `current_humidity` double DEFAULT NULL,
  `tank_capacity` double DEFAULT NULL,
  `target_humidity` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK1myqt0cncg0llryf1km3l8oie` FOREIGN KEY (`id`) REFERENCES `device` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dehumidifier`
--

LOCK TABLES `dehumidifier` WRITE;
/*!40000 ALTER TABLE `dehumidifier` DISABLE KEYS */;
INSERT INTO `dehumidifier` VALUES (11,1.7721707091640941,0,0),(12,0.49892824525902446,0,0),(13,0.9084057756421882,0,0),(14,1.0084248698156153,0,0),(15,3.0125726364714254,0,0),(16,0.7149379247621281,0,0),(17,0.7308788408902349,0,0);
/*!40000 ALTER TABLE `dehumidifier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `device`
--

DROP TABLE IF EXISTS `device`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `device` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `time` datetime(6) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `room_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8nnipnjiephps7atqdnvmfndp` (`room_id`),
  CONSTRAINT `FK8nnipnjiephps7atqdnvmfndp` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device`
--

LOCK TABLES `device` WRITE;
/*!40000 ALTER TABLE `device` DISABLE KEYS */;
INSERT INTO `device` VALUES (1,'空氣清潔器1號',_binary '\0','2024-07-07 01:19:56.381049','air_purifier',NULL),(2,'空氣清潔器2號',_binary '\0','2024-07-07 01:22:27.822441','air_purifier',1),(3,'空氣清潔器3號',_binary '\0','2024-07-07 01:22:37.808787','air_purifier',2),(4,'空氣清潔器4號',_binary '\0','2024-07-07 01:22:46.695272','air_purifier',3),(5,'空氣清潔器5號',_binary '\0','2024-07-07 01:22:59.554689','air_purifier',4),(6,'空氣清潔器6號',_binary '\0','2024-07-07 01:23:12.041976','air_purifier',4),(7,'空氣清潔器7號',_binary '\0','2024-07-07 01:23:18.514475','air_purifier',3),(8,'空氣清潔器8號',_binary '\0','2024-07-07 01:23:25.702109','air_purifier',2),(9,'空氣清潔器9號',_binary '\0','2024-07-07 01:23:31.523020','air_purifier',1),(10,'空氣清潔器10號',_binary '\0','2024-07-07 01:23:45.080298','air_purifier',4),(11,'除濕機1號',_binary '\0','2024-07-07 01:24:06.957912','dehumidifier',2),(12,'除濕機3號',_binary '\0','2024-07-07 01:24:15.785640','dehumidifier',4),(13,'除濕機6號',_binary '\0','2024-07-07 01:24:25.276793','dehumidifier',3),(14,'除濕機7號',_binary '\0','2024-07-07 01:24:30.848115','dehumidifier',1),(15,'除濕機8號',_binary '\0','2024-07-07 01:24:35.319321','dehumidifier',2),(16,'除濕機9號',_binary '\0','2024-07-07 01:24:39.321514','dehumidifier',3),(17,'除濕機10號',_binary '\0','2024-07-07 01:24:44.144283','dehumidifier',4),(18,'燈1號',_binary '\0','2024-07-07 01:25:07.116467','light',1),(19,'燈2號',_binary '\0','2024-07-07 01:25:14.092111','light',3),(20,'燈3號',_binary '\0','2024-07-07 01:25:18.877413','light',4),(21,'燈5號',_binary '\0','2024-07-07 01:25:23.074157','light',1),(22,'燈6號',_binary '\0','2024-07-07 01:25:29.068692','light',3),(23,'燈7號',_binary '\0','2024-07-07 01:25:33.368738','light',2),(24,'燈8號',_binary '\0','2024-07-07 01:25:37.052109','light',4),(25,'燈9號',_binary '\0','2024-07-07 01:25:43.145753','light',1),(26,'燈10號',_binary '\0','2024-07-07 01:25:47.274570','light',3),(27,'冷氣機1號',_binary '\0','2024-07-07 01:26:29.254528','air_conditioner',1),(28,'冷氣機2號',_binary '\0','2024-07-07 01:26:34.717033','air_conditioner',3),(29,'冷氣機3號',_binary '\0','2024-07-07 01:26:40.188287','air_conditioner',4),(30,'冷氣機4號',_binary '\0','2024-07-07 01:26:45.256152','air_conditioner',1),(31,'冷氣機5號',_binary '\0','2024-07-07 01:26:50.101504','air_conditioner',3),(32,'冷氣機6號',_binary '\0','2024-07-07 01:26:53.707437','air_conditioner',2),(33,'冷氣機7號',_binary '\0','2024-07-07 01:26:57.443789','air_conditioner',1),(34,'冷氣機8號',_binary '\0','2024-07-07 01:27:01.594171','air_conditioner',3),(35,'冷氣機9號',_binary '\0','2024-07-07 01:27:06.258630','air_conditioner',4),(36,'冷氣機10號',_binary '\0','2024-07-07 01:27:10.352802','air_conditioner',4);
/*!40000 ALTER TABLE `device` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `error`
--

DROP TABLE IF EXISTS `error`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `error` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` tinytext,
  `timestamp` date DEFAULT NULL,
  `device_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1ukfxlobj8kgu8isgp44xhvj6` (`device_id`),
  CONSTRAINT `FK1ukfxlobj8kgu8isgp44xhvj6` FOREIGN KEY (`device_id`) REFERENCES `device` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `error`
--

LOCK TABLES `error` WRITE;
/*!40000 ALTER TABLE `error` DISABLE KEYS */;
/*!40000 ALTER TABLE `error` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `history` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `detail` tinytext,
  `event_time` datetime(6) DEFAULT NULL,
  `event_type` varchar(255) DEFAULT NULL,
  `device_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfjtl9djg0db1cbj1aa260r0fl` (`device_id`),
  CONSTRAINT `FKfjtl9djg0db1cbj1aa260r0fl` FOREIGN KEY (`device_id`) REFERENCES `device` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
/*!40000 ALTER TABLE `history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `light`
--

DROP TABLE IF EXISTS `light`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `light` (
  `id` bigint NOT NULL,
  `brightness` int NOT NULL,
  `color_temp` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKnga41f0gse0cg6vx8amtkx2ah` FOREIGN KEY (`id`) REFERENCES `device` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `light`
--

LOCK TABLES `light` WRITE;
/*!40000 ALTER TABLE `light` DISABLE KEYS */;
INSERT INTO `light` VALUES (18,0,0),(19,0,0),(20,0,0),(21,0,0),(22,0,0),(23,0,0),(24,0,0),(25,0,0),(26,0,0);
/*!40000 ALTER TABLE `light` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `area` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,'房間604','永義辦公室','小型會議室'),(2,'房間605','哲宇辦公室','小型會議室'),(3,'房間605','某人辦公室','廁所'),(4,'房間609','傳接球辦公室','豪華辦公室');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-07  1:34:48
