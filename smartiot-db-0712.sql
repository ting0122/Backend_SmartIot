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
  `mode` enum('AUTO','COOL','FAN','HEAT') DEFAULT NULL,
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
INSERT INTO `ac` VALUES (4,10.106981797142435,NULL,NULL,0),(5,10.467154969144701,NULL,NULL,0),(6,10.217162038212274,NULL,NULL,0),(7,10,NULL,NULL,0),(8,10.071866574351846,NULL,NULL,0),(9,10.086997415787705,NULL,NULL,0),(10,10.89805761058542,NULL,NULL,0),(11,10.738406555613647,NULL,NULL,0),(12,10.670212480305333,NULL,NULL,0),(13,10.12443468588425,NULL,NULL,0),(14,10.897216605008815,NULL,NULL,0),(15,10.322641786249147,NULL,NULL,0),(16,10.652261647103675,NULL,NULL,0),(17,10.574262297316984,NULL,NULL,0),(18,10.33088869481131,NULL,NULL,0),(19,10.136974346626214,NULL,NULL,0),(41,10.252097642482191,NULL,NULL,0),(42,10.217055627624537,NULL,NULL,0),(43,10,NULL,NULL,0),(44,10.02567672669763,NULL,NULL,0),(45,10,NULL,NULL,0);
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
INSERT INTO `air_purifier` VALUES (35,50,0,0),(36,65,0,0),(37,53,0,0),(38,57,0,0),(39,38,0,0),(40,84,0,0);
/*!40000 ALTER TABLE `air_purifier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `announcement`
--

DROP TABLE IF EXISTS `announcement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `announcement` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `publish_time` date DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `announcement`
--

LOCK TABLES `announcement` WRITE;
/*!40000 ALTER TABLE `announcement` DISABLE KEYS */;
/*!40000 ALTER TABLE `announcement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `announcement_room_ids`
--

DROP TABLE IF EXISTS `announcement_room_ids`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `announcement_room_ids` (
  `announcement_id` bigint NOT NULL,
  `room_ids` bigint DEFAULT NULL,
  KEY `FK14oo49k9dotjydwscfycdgih8` (`announcement_id`),
  CONSTRAINT `FK14oo49k9dotjydwscfycdgih8` FOREIGN KEY (`announcement_id`) REFERENCES `announcement` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `announcement_room_ids`
--

LOCK TABLES `announcement_room_ids` WRITE;
/*!40000 ALTER TABLE `announcement_room_ids` DISABLE KEYS */;
/*!40000 ALTER TABLE `announcement_room_ids` ENABLE KEYS */;
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
  `fan_speed` enum('AUTO','HIGH','LOW','MEDIUM') DEFAULT NULL,
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
INSERT INTO `dehumidifier` VALUES (28,72.64849492761545,NULL,0,0),(29,80.02327735243244,NULL,0,0),(30,84.24344803010072,NULL,0,0),(31,82.05931481353998,NULL,0,0),(32,76.49735473711851,NULL,0,0),(33,67.83216429779745,NULL,0,0),(34,82.11408480764948,NULL,0,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device`
--

LOCK TABLES `device` WRITE;
/*!40000 ALTER TABLE `device` DISABLE KEYS */;
INSERT INTO `device` VALUES (4,'冷氣機04號',_binary '\0','2024-07-12 00:03:04.442414','冷氣機',4),(5,'冷氣機05號',_binary '\0','2024-07-12 00:03:12.447077','冷氣機',5),(6,'冷氣機05號',_binary '\0','2024-07-12 00:03:12.974551','冷氣機',5),(7,'冷氣機06號',_binary '\0','2024-07-12 00:03:27.620643','冷氣機',7),(8,'冷氣機07號',_binary '\0','2024-07-12 00:03:36.118634','冷氣機',8),(9,'冷氣機08號',_binary '\0','2024-07-12 00:03:47.107844','冷氣機',10),(10,'冷氣機09號',_binary '\0','2024-07-12 00:04:01.403950','冷氣機',12),(11,'冷氣機10號',_binary '\0','2024-07-12 00:04:13.148337','冷氣機',11),(12,'冷氣機11號',_binary '\0','2024-07-12 00:04:23.561182','冷氣機',13),(13,'冷氣機12號',_binary '\0','2024-07-12 00:04:33.013833','冷氣機',14),(14,'冷氣機13號',_binary '\0','2024-07-12 00:04:45.203213','冷氣機',15),(15,'冷氣機14號',_binary '\0','2024-07-12 00:04:59.449575','冷氣機',16),(16,'冷氣機15號',_binary '\0','2024-07-12 00:05:11.794460','冷氣機',17),(17,'冷氣機16號',_binary '\0','2024-07-12 00:05:19.854406','冷氣機',18),(18,'冷氣機17號',_binary '\0','2024-07-12 00:05:29.368980','冷氣機',19),(19,'冷氣機18號',_binary '\0','2024-07-12 00:05:41.866812','冷氣機',20),(20,'燈18號',_binary '\0','2024-07-12 00:06:10.051597','燈',1),(21,'燈19號',_binary '\0','2024-07-12 00:06:20.759570','燈',1),(22,'燈12號',_binary '\0','2024-07-12 00:06:31.677356','燈',1),(23,'燈15號',_binary '\0','2024-07-12 00:06:43.251152','燈',3),(24,'燈20號',_binary '\0','2024-07-12 00:07:03.609129','燈',1),(25,'燈21號',_binary '\0','2024-07-12 00:07:09.418658','燈',1),(26,'燈22號',_binary '\0','2024-07-12 00:07:14.818894','燈',1),(27,'燈23號',_binary '\0','2024-07-12 00:07:20.674560','燈',1),(28,'除濕機24號',_binary '\0','2024-07-12 00:07:41.370748','除濕機',1),(29,'除濕機25號',_binary '\0','2024-07-12 00:07:49.095917','除濕機',1),(30,'除濕機26號',_binary '\0','2024-07-12 00:07:54.481712','除濕機',1),(31,'除濕機27號',_binary '\0','2024-07-12 00:08:00.550620','除濕機',1),(32,'除濕機28號',_binary '\0','2024-07-12 00:08:05.745988','除濕機',1),(33,'除濕機29號',_binary '\0','2024-07-12 00:08:10.841950','除濕機',1),(34,'除濕機30號',_binary '\0','2024-07-12 00:08:17.080248','除濕機',1),(35,'空氣清淨機30號',_binary '\0','2024-07-12 00:08:46.248042','空氣清淨機',1),(36,'空氣清淨機31號',_binary '\0','2024-07-12 00:08:51.896088','空氣清淨機',1),(37,'空氣清淨機32號',_binary '\0','2024-07-12 00:08:57.839816','空氣清淨機',1),(38,'空氣清淨機33號',_binary '\0','2024-07-12 00:09:03.221142','空氣清淨機',1),(39,'空氣清淨機34號',_binary '\0','2024-07-12 00:09:08.969164','空氣清淨機',1),(40,'空氣清淨機35號',_binary '\0','2024-07-12 00:09:15.865945','空氣清淨機',1),(41,'冷氣機35號',_binary '\0','2024-07-12 00:10:38.087316','冷氣機',1),(42,'冷氣機36號',_binary '\0','2024-07-12 00:10:42.681636','冷氣機',1),(43,'冷氣機37號',_binary '\0','2024-07-12 00:10:45.495299','冷氣機',1),(44,'冷氣機38號',_binary '\0','2024-07-12 00:10:49.056114','冷氣機',1),(45,'冷氣機無敵號',_binary '\0','2024-07-12 00:58:16.838056','冷氣機',1);
/*!40000 ALTER TABLE `device` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `history` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `detail` varchar(255) DEFAULT NULL,
  `device_id` bigint NOT NULL,
  `event_id` varchar(255) NOT NULL,
  `event_time` datetime(6) NOT NULL,
  `event_type` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
INSERT INTO `history` VALUES (1,'{\"status\":\"開\"}',1,'86224a8b-178d-45ca-94b3-b171c3567b9f','2024-07-12 00:56:01.396986','設備開關'),(2,'{\"status\":\"關\"}',1,'43b754e0-1c22-4449-bef0-8354909b8832','2024-07-12 00:56:30.466651','設備開關');
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
INSERT INTO `light` VALUES (20,0,0),(21,0,0),(22,0,0),(23,0,0),(24,0,0),(25,0,0),(26,0,0),(27,0,0);
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
  `status` bit(1) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,'房間100號','子慧辦公室',_binary '\0','公司'),(2,'房間101號','彥宇辦公室',_binary '\0','公司'),(3,'房間102號','巧翎辦公室',_binary '\0','公司'),(4,'房間103號','南哥棒棒辦公室',_binary '\0','公司'),(5,'房間104號','董卓的樂園',_binary '\0','公司'),(6,'房間105號','冠廷的全球超級豪奢辦公室',_binary '\0','公司'),(7,'房間106號','傳接球美女辦公室',_binary '\0','公司'),(8,'房間107號','冠霖股份有限公司',_binary '\0','公司'),(9,'房間108號','冠文股份有限公司',_binary '\0','公司'),(10,'房間109號','吟臻股份有限公司',_binary '\0','公司'),(11,'房間110號','玉娟股份有限公司',_binary '\0','公司'),(12,'房間201號','中餐討論會議室',_binary '\0','會議室'),(13,'房間202號','子慧專屬會議室',_binary '\0','會議室'),(14,'房間203號','宿舍成員專屬會議室',_binary '\0','會議室'),(15,'房間204號','永義的小小小小小會議室',_binary '\0','會議室'),(16,'房間205號','品嘉的虛擬會議室',_binary '\0','會議室'),(17,'房間206號','卡比獸的大大大會議室',_binary '\0','會議室'),(18,'房間207號','永誠的會議室',_binary '\0','會議室'),(19,'房間208號','董卓的會議室',_binary '\0','會議室'),(20,'房間209號','沒有人會去的會議室',_binary '\0','會議室'),(21,'房間210號','万十的會議室',_binary '\0','會議室'),(22,'公共區域001號','員工餐廳',_binary '\0','公共區域'),(23,'公共區域002號','員工健身房',_binary '\0','公共區域'),(24,'公共區域003號','一樓男廁',_binary '\0','公共區域'),(25,'公共區域004號','一樓女廁',_binary '\0','公共區域'),(26,'公共區域005號','請假王的睡覺沙發區',_binary '\0','公共區域'),(27,'公共區域006號','卡卡西的小空間',_binary '\0','公共區域'),(28,'公共區域007號','船長的練兵場',_binary '\0','公共區域'),(29,'機房01號','傳說中的秘境',_binary '\0','機房'),(30,'機房02號','老司機房',_binary '\0','機房'),(31,'機房03號','秘密雞地',_binary '\0','機房'),(32,'廁所01號','永義常去的那間',_binary '\0','廁所'),(33,'廁所02號','冠停不去的那間',_binary '\0','廁所'),(34,'廁所03號','冠町專屬的那間',_binary '\0','廁所'),(35,'廁所04號','冠廷的宮廷風衛浴',_binary '\0','廁所'),(36,'教室01號','卡卡西的GPT大講堂',_binary '\0','教室'),(37,'教室02號','請假王的後端學院',_binary '\0','教室'),(38,'教室03號','俊傑的物件導向教室',_binary '\0','教室'),(39,'教室04號','學姊的Socket培訓營',_binary '\0','教室'),(40,'教室05號','董卓的前端課',_binary '\0','教室'),(41,'其他01號','巧翎的訂餐處',_binary '\0','其他'),(42,'其他02號','預捐的桌遊天地',_binary '\0','其他');
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

-- Dump completed on 2024-07-12  1:05:20
