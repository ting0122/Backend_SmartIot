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
  `current_temp` double DEFAULT NULL,
  `target_temp` double DEFAULT NULL,
  `id` bigint NOT NULL,
  `fan_speed` enum('AUTO','HIGH','LOW','MEDIUM') DEFAULT NULL,
  `mode` enum('AUTO','COOL','DRY','FAN','HEAT') DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKf91cnl6kisy6k2dt5l4dvjdsu` FOREIGN KEY (`id`) REFERENCES `device` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ac`
--

LOCK TABLES `ac` WRITE;
/*!40000 ALTER TABLE `ac` DISABLE KEYS */;
INSERT INTO `ac` VALUES (10.820652411659026,0,1,NULL,NULL),(10.340120740089317,0,2,NULL,NULL),(10.110700832968467,0,3,NULL,NULL),(10.13586976455465,0,4,NULL,NULL),(10.452596101589505,0,5,NULL,NULL),(10,0,6,NULL,NULL),(10.931874327530346,0,7,NULL,NULL),(10.253478970267508,0,8,NULL,NULL),(10.065943714851175,0,9,NULL,NULL),(10.061395588558563,0,10,NULL,NULL);
/*!40000 ALTER TABLE `ac` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `air_purifier`
--

DROP TABLE IF EXISTS `air_purifier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `air_purifier` (
  `air_quality` int NOT NULL,
  `fan_speed` int NOT NULL,
  `operating_time` double DEFAULT NULL,
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK6n7gmtpxxwf8bqy7hoig88si5` FOREIGN KEY (`id`) REFERENCES `device` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `air_purifier`
--

LOCK TABLES `air_purifier` WRITE;
/*!40000 ALTER TABLE `air_purifier` DISABLE KEYS */;
INSERT INTO `air_purifier` VALUES (51,0,0,11),(38,0,0,12),(35,0,0,13),(18,0,0,14),(34,0,0,15),(7,0,0,16),(0,0,0,17),(6,0,0,18),(19,0,0,19),(31,0,0,20);
/*!40000 ALTER TABLE `air_purifier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dehumidifier`
--

DROP TABLE IF EXISTS `dehumidifier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dehumidifier` (
  `current_humidity` double DEFAULT NULL,
  `tank_capacity` double DEFAULT NULL,
  `target_humidity` double DEFAULT NULL,
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK1myqt0cncg0llryf1km3l8oie` FOREIGN KEY (`id`) REFERENCES `device` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dehumidifier`
--

LOCK TABLES `dehumidifier` WRITE;
/*!40000 ALTER TABLE `dehumidifier` DISABLE KEYS */;
INSERT INTO `dehumidifier` VALUES (0.8763083694936835,0,0,21),(0,0,0,22),(0.5802365236394196,0,0,23),(1.622775930595207,0,0,24),(0,0,0,25),(0.7333020002913748,0,0,26),(0.730594646145802,0,0,27),(0.6870613364208195,0,0,28),(0.9472846250569232,0,0,29),(2.828624463422752,0,0,30);
/*!40000 ALTER TABLE `dehumidifier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `device`
--

DROP TABLE IF EXISTS `device`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `device` (
  `status` bit(1) DEFAULT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `room_id` bigint DEFAULT NULL,
  `time` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8nnipnjiephps7atqdnvmfndp` (`room_id`),
  CONSTRAINT `FK8nnipnjiephps7atqdnvmfndp` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device`
--

LOCK TABLES `device` WRITE;
/*!40000 ALTER TABLE `device` DISABLE KEYS */;
INSERT INTO `device` VALUES (_binary '\0',1,1,'2024-07-07 21:35:29.546041','冷氣機01號','冷氣機'),(_binary '\0',2,3,'2024-07-07 21:35:51.793654','冷氣機02號','冷氣機'),(_binary '\0',3,2,'2024-07-07 21:35:58.656135','冷氣機03號','冷氣機'),(_binary '\0',4,5,'2024-07-07 21:36:05.568895','冷氣機04號','冷氣機'),(_binary '\0',5,4,'2024-07-07 21:36:10.475633','冷氣機05號','冷氣機'),(_binary '\0',6,7,'2024-07-07 21:36:16.505876','冷氣機06號','冷氣機'),(_binary '\0',7,6,'2024-07-07 21:36:21.217280','冷氣機07號','冷氣機'),(_binary '\0',8,8,'2024-07-07 21:36:28.156846','冷氣機08號','冷氣機'),(_binary '\0',9,1,'2024-07-07 21:36:41.106331','冷氣機09號','冷氣機'),(_binary '\0',10,2,'2024-07-07 21:36:48.214230','冷氣機10號','冷氣機'),(_binary '\0',11,2,'2024-07-07 21:37:18.216414','空氣清淨機01號','空氣清淨機'),(_binary '\0',12,1,'2024-07-07 21:37:23.843476','空氣清淨機02號','空氣清淨機'),(_binary '\0',13,3,'2024-07-07 21:37:30.938587','空氣清淨機03號','空氣清淨機'),(_binary '\0',14,5,'2024-07-07 21:37:42.913831','空氣清淨機04號','空氣清淨機'),(_binary '\0',15,4,'2024-07-07 21:37:47.556897','空氣清淨機05號','空氣清淨機'),(_binary '\0',16,7,'2024-07-07 21:37:52.253063','空氣清淨機06號','空氣清淨機'),(_binary '\0',17,6,'2024-07-07 21:37:58.803436','空氣清淨機07號','空氣清淨機'),(_binary '\0',18,6,'2024-07-07 21:38:04.305751','空氣清淨機08號','空氣清淨機'),(_binary '\0',19,8,'2024-07-07 21:38:08.749303','空氣清淨機09號','空氣清淨機'),(_binary '\0',20,2,'2024-07-07 21:38:14.855664','空氣清淨機10號','空氣清淨機'),(_binary '\0',21,2,'2024-07-07 21:38:34.035560','除濕機01號','除濕機'),(_binary '\0',22,1,'2024-07-07 21:38:41.701449','除濕機02號','除濕機'),(_binary '\0',23,5,'2024-07-07 21:38:47.226242','除濕機03號','除濕機'),(_binary '\0',24,4,'2024-07-07 21:38:52.096374','除濕機04號','除濕機'),(_binary '\0',25,6,'2024-07-07 21:38:56.410263','除濕機05號','除濕機'),(_binary '\0',26,5,'2024-07-07 21:39:01.488721','除濕機06號','除濕機'),(_binary '\0',27,8,'2024-07-07 21:39:05.639875','除濕機07號','除濕機'),(_binary '\0',28,5,'2024-07-07 21:39:10.255528','除濕機08號','除濕機'),(_binary '\0',29,7,'2024-07-07 21:39:15.804157','除濕機09號','除濕機'),(_binary '\0',30,8,'2024-07-07 21:39:21.239771','除濕機10號','除濕機'),(_binary '\0',31,8,'2024-07-07 21:39:46.938656','燈01號','燈'),(_binary '\0',32,7,'2024-07-07 21:39:52.041869','燈02號','燈'),(_binary '\0',33,6,'2024-07-07 21:39:56.407853','燈03號','燈'),(_binary '\0',34,5,'2024-07-07 21:40:00.555105','燈04號','燈'),(_binary '\0',35,4,'2024-07-07 21:40:04.728001','燈05號','燈'),(_binary '\0',36,3,'2024-07-07 21:40:09.214876','燈06號','燈'),(_binary '\0',37,2,'2024-07-07 21:40:18.999745','燈06號','燈'),(_binary '\0',38,1,'2024-07-07 21:40:23.572877','燈07號','燈'),(_binary '\0',39,2,'2024-07-07 21:40:30.409398','燈08號','燈'),(_binary '\0',40,5,'2024-07-07 21:40:35.384950','燈09號','燈'),(_binary '\0',41,7,'2024-07-07 21:40:40.907092','燈10號','燈');
/*!40000 ALTER TABLE `device` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `error`
--

DROP TABLE IF EXISTS `error`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `error` (
  `timestamp` date DEFAULT NULL,
  `device_id` bigint DEFAULT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` tinytext,
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
  `device_id` bigint DEFAULT NULL,
  `event_time` datetime(6) DEFAULT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `event_type` varchar(255) DEFAULT NULL,
  `detail` tinytext,
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
  `brightness` int NOT NULL,
  `color_temp` int NOT NULL,
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKnga41f0gse0cg6vx8amtkx2ah` FOREIGN KEY (`id`) REFERENCES `device` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `light`
--

LOCK TABLES `light` WRITE;
/*!40000 ALTER TABLE `light` DISABLE KEYS */;
INSERT INTO `light` VALUES (0,0,31),(0,0,32),(0,0,33),(0,0,34),(0,0,35),(0,0,36),(0,0,37),(0,0,38),(0,0,39),(0,0,40),(0,0,41);
/*!40000 ALTER TABLE `light` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `status` bit(1) DEFAULT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `area` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (_binary '\0',1,'房間100號','彥宇辦公室','VIP套房'),(_binary '\0',2,'房間101號','紅帽男辦公室','個人閱讀室'),(_binary '\0',3,'大廳沙發區','請假王辦公室','大廳'),(_binary '\0',4,'房間103號','永義辦公室','小型辦公室'),(_binary '\0',5,'房間105號','巧翎訂餐處','小型辦公室'),(_binary '\0',6,'房間106號','男哥辦公室','中型辦公室'),(_binary '\0',7,'房間107號','董卓辦公室','中型辦公室'),(_binary '\0',8,'房間107號','俊傑辦公室','豪華辦公室');
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

-- Dump completed on 2024-07-07 21:43:40
