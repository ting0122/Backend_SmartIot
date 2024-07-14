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
INSERT INTO `ac` VALUES (21,10.319741180968666,'LOW','COOL',17),(22,10.08780993860783,'LOW','COOL',17),(23,10.218122023268203,'LOW','COOL',17),(24,10.028593077235904,'LOW','COOL',17),(25,10,'LOW','COOL',17),(26,10.09342906852786,'LOW','COOL',17),(27,10.34441446953169,'LOW','COOL',17),(28,10.281926850423408,'LOW','COOL',17),(29,10.59594728116102,'LOW','COOL',17),(30,10.09753698494332,'LOW','COOL',17);
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
INSERT INTO `air_purifier` VALUES (1,35,0,0),(2,15,0,0),(3,5,0,0),(4,44,0,0),(5,10,0,0),(6,36,0,0),(7,4,0,0),(8,20,0,0),(9,42,0,0),(10,13,0,0);
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
INSERT INTO `dehumidifier` VALUES (11,79.58334819177607,NULL,0,0),(12,78.12822102648839,NULL,0,0),(13,82.65578460803786,NULL,0,0),(14,79.96407328935544,NULL,0,0),(15,74.19838134614405,NULL,0,0),(16,80.13054950011221,NULL,0,0),(17,77.11676261341705,NULL,0,0),(18,84.78387916857322,NULL,0,0),(19,77.00205720940811,NULL,0,0),(20,79.45620936287455,NULL,0,0);
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
  `power_consumption_rate` double DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `time` datetime(6) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `room_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8nnipnjiephps7atqdnvmfndp` (`room_id`),
  CONSTRAINT `FK8nnipnjiephps7atqdnvmfndp` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device`
--

LOCK TABLES `device` WRITE;
/*!40000 ALTER TABLE `device` DISABLE KEYS */;
INSERT INTO `device` VALUES (1,'戴森空氣清淨機01號',0,_binary '\0','2024-07-15 00:41:15.561354','空氣清淨機',1),(2,'戴森空氣清淨機02號',0,_binary '\0','2024-07-15 00:42:00.600096','空氣清淨機',2),(3,'戴森空氣清淨機03號',0.048,_binary '\0','2024-07-15 00:55:40.904299','空氣清淨機',3),(4,'戴森空氣清淨機04號',0.048,_binary '\0','2024-07-15 00:55:53.018922','空氣清淨機',4),(5,'戴森空氣清淨機05號',0.048,_binary '\0','2024-07-15 00:56:00.802846','空氣清淨機',5),(6,'戴森空氣清淨機06號',0.048,_binary '\0','2024-07-15 00:56:06.704340','空氣清淨機',6),(7,'戴森空氣清淨機07號',0.048,_binary '\0','2024-07-15 00:56:15.309121','空氣清淨機',1),(8,'戴森空氣清淨機08號',0.048,_binary '\0','2024-07-15 00:56:22.478010','空氣清淨機',2),(9,'戴森空氣清淨機09號',0.048,_binary '\0','2024-07-15 00:56:27.677675','空氣清淨機',3),(10,'戴森空氣清淨機10號',0.048,_binary '\0','2024-07-15 00:56:32.935900','空氣清淨機',1),(11,'小米除濕機01號',0.19,_binary '\0','2024-07-15 00:56:57.186641','除濕機',1),(12,'小米除濕機02號',0.19,_binary '\0','2024-07-15 00:57:05.429983','除濕機',1),(13,'小米除濕機03號',0.19,_binary '\0','2024-07-15 00:57:09.772970','除濕機',2),(14,'小米除濕機04號',0.19,_binary '\0','2024-07-15 00:57:14.157351','除濕機',3),(15,'小米除濕機05號',0.19,_binary '\0','2024-07-15 00:57:19.543867','除濕機',6),(16,'小米除濕機06號',0.19,_binary '\0','2024-07-15 00:57:24.770609','除濕機',7),(17,'小米除濕機07號',0.19,_binary '\0','2024-07-15 00:57:30.022022','除濕機',3),(18,'小米除濕機08號',0.19,_binary '\0','2024-07-15 00:57:34.168547','除濕機',2),(19,'小米除濕機09號',0.19,_binary '\0','2024-07-15 00:57:38.639186','除濕機',1),(20,'小米除濕機10號',0.19,_binary '\0','2024-07-15 00:57:43.426647','除濕機',3),(21,'大金冷氣機01號',1.43,_binary '\0','2024-07-15 00:58:13.678839','冷氣機',4),(22,'大金冷氣機02號',1.43,_binary '\0','2024-07-15 00:58:27.098408','冷氣機',1),(23,'大金冷氣機03號',1.43,_binary '\0','2024-07-15 00:58:32.528979','冷氣機',1),(24,'大金冷氣機04號',1.43,_binary '\0','2024-07-15 00:58:35.939393','冷氣機',1),(25,'大金冷氣機05號',1.43,_binary '\0','2024-07-15 00:58:40.913347','冷氣機',2),(26,'大金冷氣機06號',1.43,_binary '\0','2024-07-15 00:58:45.690726','冷氣機',3),(27,'大金冷氣機07號',1.43,_binary '\0','2024-07-15 00:58:50.132078','冷氣機',4),(28,'大金冷氣機08號',1.43,_binary '\0','2024-07-15 00:58:55.763676','冷氣機',5),(29,'大金冷氣機09號',1.43,_binary '\0','2024-07-15 00:58:59.947743','冷氣機',6),(30,'大金冷氣機10號',1.43,_binary '\0','2024-07-15 00:59:04.222124','冷氣機',7),(31,'燈泡01號',0.04,_binary '\0','2024-07-15 00:59:43.146919','燈',7),(32,'燈泡02號',0.04,_binary '\0','2024-07-15 00:59:49.070893','燈',6),(33,'燈泡03號',0.04,_binary '\0','2024-07-15 00:59:54.764217','燈',5),(34,'燈泡04號',0.04,_binary '\0','2024-07-15 01:00:00.046868','燈',3),(35,'燈泡05號',0.04,_binary '\0','2024-07-15 01:00:03.906106','燈',2),(36,'燈泡06號',0.04,_binary '\0','2024-07-15 01:00:09.419224','燈',1),(37,'燈泡07號',0.04,_binary '\0','2024-07-15 01:00:12.475814','燈',1),(38,'燈泡08號',0.04,_binary '\0','2024-07-15 01:00:15.066999','燈',1),(39,'燈泡09號',0.04,_binary '\0','2024-07-15 01:00:17.807598','燈',1),(40,'燈泡10號',0.04,_binary '\0','2024-07-15 01:00:21.003719','燈',1),(41,'燈泡11號',0.04,_binary '\0','2024-07-15 01:00:38.319366','燈',10),(42,'燈泡12號',0.04,_binary '\0','2024-07-15 01:00:45.489426','燈',12),(43,'燈泡13號',0.04,_binary '\0','2024-07-15 01:00:49.795804','燈',13),(44,'燈泡14號',0.04,_binary '\0','2024-07-15 01:00:53.793774','燈',14),(45,'燈泡15號',0.04,_binary '\0','2024-07-15 01:00:58.090195','燈',15),(46,'燈泡16號',0.04,_binary '\0','2024-07-15 01:01:02.055129','燈',16),(47,'燈泡17號',0.04,_binary '\0','2024-07-15 01:01:05.837303','燈',17),(48,'燈泡18號',0.04,_binary '\0','2024-07-15 01:01:09.641182','燈',18),(49,'燈泡19號',0.04,_binary '\0','2024-07-15 01:01:15.012057','燈',19),(50,'燈泡20號',0.04,_binary '\0','2024-07-15 01:01:19.529561','燈',20);
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
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
INSERT INTO `history` VALUES (1,'{\"name\":\"永義會議室\",\"type\":\"會議室\"}',1,'2bd5d219-baba-4e51-b5b0-19cc12b4e0d8','2024-07-15 00:28:48.993055','新增房間'),(2,'{\"name\":\"巧翎會議室\",\"type\":\"會議室\"}',2,'e90d507c-dbfb-4895-b18e-74984459d871','2024-07-15 00:29:09.930287','新增房間'),(3,'{\"name\":\"冠文會議室\",\"type\":\"會議室\"}',3,'05eba0a8-67d6-46cc-9e55-000ecb9d5b77','2024-07-15 00:29:28.855745','新增房間'),(4,'{\"name\":\"冠霖會議室\",\"type\":\"會議室\"}',4,'c9b7a699-1085-47be-afe1-1c02804232fd','2024-07-15 00:29:37.418674','新增房間'),(5,'{\"name\":\"彥宇會議室\",\"type\":\"會議室\"}',5,'e7f6bf4b-4f76-4bd1-926a-5fa322480545','2024-07-15 00:29:52.813451','新增房間'),(6,'{\"name\":\"學姊會議室\",\"type\":\"會議室\"}',6,'ccd11d86-78e0-4886-b8dc-f34d2385a6b5','2024-07-15 00:30:04.356898','新增房間'),(7,'{\"name\":\"紅帽男會議室\",\"type\":\"會議室\"}',7,'249cc863-2c3e-43ae-b982-2aff49fcbc14','2024-07-15 00:30:24.262091','新增房間'),(8,'{\"name\":\"請假王會議室\",\"type\":\"會議室\"}',8,'e5ab8bcb-7081-4b61-965c-52b2e10ff58c','2024-07-15 00:30:38.964537','新增房間'),(9,'{\"name\":\"班吉拉斯會議室\",\"type\":\"會議室\"}',9,'df6f2fb8-2678-4ff7-9e0e-df28a25ac845','2024-07-15 00:30:59.757437','新增房間'),(10,'{\"name\":\"男哥會議室\",\"type\":\"會議室\"}',10,'93c3ac0d-e687-48d0-83c4-ed3e4cefd03f','2024-07-15 00:31:16.516876','新增房間'),(11,'{\"name\":\"男哥公司\",\"type\":\"公司\"}',11,'d5c397d1-6b5b-4f3d-9527-c1995bad48d5','2024-07-15 00:32:02.456443','新增房間'),(12,'{\"name\":\"山口組公司\",\"type\":\"公司\"}',12,'6514a4ca-f58f-40cc-b4eb-bbe5ae4b92ca','2024-07-15 00:32:19.016950','新增房間'),(13,'{\"name\":\"軒豪公司\",\"type\":\"公司\"}',13,'f7bdbbeb-f5f9-4925-8adb-0592e82e916f','2024-07-15 00:32:38.131529','新增房間'),(14,'{\"name\":\"俊傑公司\",\"type\":\"公司\"}',14,'d79a9628-e9a3-4af7-aadb-6da4b9f2d279','2024-07-15 00:32:53.009790','新增房間'),(15,'{\"name\":\"子慧公司\",\"type\":\"公司\"}',15,'08cb40a3-8cb2-42c9-a10c-5ce06f2f360f','2024-07-15 00:33:14.210555','新增房間'),(16,'{\"name\":\"彥宇公司\",\"type\":\"公司\"}',16,'ba3588f8-f2fd-4a92-9e5c-647e110f903c','2024-07-15 00:33:27.655305','新增房間'),(17,'{\"name\":\"董卓公司\",\"type\":\"公司\"}',17,'241b3b4f-680d-4be7-b866-8c718ad7ac6a','2024-07-15 00:33:39.988961','新增房間'),(18,'{\"name\":\"SWAG公司\",\"type\":\"公司\"}',18,'372b9817-baf1-4d53-82f8-248e5a14565d','2024-07-15 00:33:57.858514','新增房間'),(19,'{\"name\":\"正門門口\",\"type\":\"公共區域\"}',19,'31ddd57c-eb83-4e20-8a9e-bbcd5ec318b5','2024-07-15 00:34:48.694929','新增房間'),(20,'{\"name\":\"側門門口\",\"type\":\"公共區域\"}',20,'c4f91fdc-d9a2-4be9-893e-b15d855e5017','2024-07-15 00:34:59.217679','新增房間'),(21,'{\"name\":\"後門門口\",\"type\":\"公共區域\"}',21,'dba8a179-ac7f-41ae-8dfd-8f00d8123192','2024-07-15 00:35:07.908877','新增房間'),(22,'{\"name\":\"男廁\",\"type\":\"廁所\"}',22,'48228c75-623d-46b9-99d4-6840bf8ef284','2024-07-15 00:35:42.777847','新增房間'),(23,'{\"name\":\"女廁\",\"type\":\"廁所\"}',23,'c9c2e67d-d648-42c9-a05f-cb3ccd5eba6c','2024-07-15 00:35:50.740408','新增房間'),(24,'{\"name\":\"傳說中的秘境\",\"type\":\"機房\"}',24,'29fd87e1-18d1-41a3-ac95-e2c17bd077ce','2024-07-15 00:36:20.596097','新增房間'),(25,'{\"name\":\"天堂路\",\"type\":\"機房\"}',25,'3782e1dc-5448-49ab-acab-33af8075eef4','2024-07-15 00:36:31.656523','新增房間'),(26,'{\"name\":\"紅帽男的概念大講堂\",\"type\":\"教室\"}',26,'77e44ce9-251c-431f-b153-452c10b6906e','2024-07-15 00:37:03.753004','新增房間'),(27,'{\"name\":\"請假王的使用者驗證教學\",\"type\":\"教室\"}',27,'271dc3df-98ab-47a9-b72d-d4f892b3d468','2024-07-15 00:37:37.619180','新增房間'),(28,'{\"name\":\"董卓的前端學院\",\"type\":\"教室\"}',28,'3d9ff6c0-f14b-439d-a4d0-73294606bc65','2024-07-15 00:38:02.431281','新增房間'),(29,'{\"name\":\"學姊被關的地方\",\"type\":\"其他\"}',29,'2458c1a1-63df-4254-9cf2-084bb821cae6','2024-07-15 00:38:35.550439','新增房間'),(30,'{\"name\":\"請假王睡覺的地方\",\"type\":\"其他\"}',30,'fef4cb4d-cb23-4ac1-b885-a17e695c8f62','2024-07-15 00:39:30.302168','新增房間'),(31,'{\"room_name\":\"永義會議室\",\"name\":\"戴森空氣清淨機01號\",\"room_area\":\"房間001號\",\"type\":\"空氣清淨機\"}',1,'24d8e2c1-71d1-4b1d-afa3-ee36238f1a77','2024-07-15 00:41:15.587344','新增設備'),(32,'{\"room_name\":\"巧翎會議室\",\"name\":\"戴森空氣清淨機02號\",\"room_area\":\"房間002號\",\"type\":\"空氣清淨機\"}',2,'02a72025-400b-498d-8967-5ee82b076191','2024-07-15 00:42:00.612583','新增設備'),(33,'{\"room_name\":\"冠文會議室\",\"name\":\"戴森空氣清淨機03號\",\"room_area\":\"房間003號\",\"type\":\"空氣清淨機\"}',3,'105e3244-5f2c-4245-999d-df26e8b4dbae','2024-07-15 00:55:40.979939','新增設備'),(34,'{\"room_name\":\"冠霖會議室\",\"name\":\"戴森空氣清淨機04號\",\"room_area\":\"房間004號\",\"type\":\"空氣清淨機\"}',4,'708fdc3e-016d-48d6-a16a-dd3ec901300b','2024-07-15 00:55:53.035748','新增設備'),(35,'{\"room_name\":\"彥宇會議室\",\"name\":\"戴森空氣清淨機05號\",\"room_area\":\"房間005號\",\"type\":\"空氣清淨機\"}',5,'2d43e0d0-2656-4362-8195-f32f643d3115','2024-07-15 00:56:00.815942','新增設備'),(36,'{\"room_name\":\"學姊會議室\",\"name\":\"戴森空氣清淨機06號\",\"room_area\":\"房間006號\",\"type\":\"空氣清淨機\"}',6,'01202cf0-c3ad-493d-bfd9-7ee67fef87dd','2024-07-15 00:56:06.716375','新增設備'),(37,'{\"room_name\":\"永義會議室\",\"name\":\"戴森空氣清淨機07號\",\"room_area\":\"房間001號\",\"type\":\"空氣清淨機\"}',7,'fb9616d3-4cc8-4e3a-b8e5-a22b7c6331c5','2024-07-15 00:56:15.321702','新增設備'),(38,'{\"room_name\":\"巧翎會議室\",\"name\":\"戴森空氣清淨機08號\",\"room_area\":\"房間002號\",\"type\":\"空氣清淨機\"}',8,'37d20e51-0fe6-44bc-a60d-a2cd7b675aac','2024-07-15 00:56:22.487905','新增設備'),(39,'{\"room_name\":\"冠文會議室\",\"name\":\"戴森空氣清淨機09號\",\"room_area\":\"房間003號\",\"type\":\"空氣清淨機\"}',9,'da01d5b5-a075-47b5-acc6-20da6e09b292','2024-07-15 00:56:27.689684','新增設備'),(40,'{\"room_name\":\"永義會議室\",\"name\":\"戴森空氣清淨機10號\",\"room_area\":\"房間001號\",\"type\":\"空氣清淨機\"}',10,'5b92bd50-b211-49fe-9bbc-5eebe5bd7223','2024-07-15 00:56:32.947579','新增設備'),(41,'{\"room_name\":\"永義會議室\",\"name\":\"小米除濕機01號\",\"room_area\":\"房間001號\",\"type\":\"除濕機\"}',11,'c17726af-4a65-461d-aada-ab81980b7a38','2024-07-15 00:56:57.196953','新增設備'),(42,'{\"room_name\":\"永義會議室\",\"name\":\"小米除濕機02號\",\"room_area\":\"房間001號\",\"type\":\"除濕機\"}',12,'5948fb61-b5ec-4795-ab2b-f67d85c914e6','2024-07-15 00:57:05.443249','新增設備'),(43,'{\"room_name\":\"巧翎會議室\",\"name\":\"小米除濕機03號\",\"room_area\":\"房間002號\",\"type\":\"除濕機\"}',13,'07701c24-283a-4bec-a9aa-9c17e6697e03','2024-07-15 00:57:09.783232','新增設備'),(44,'{\"room_name\":\"冠文會議室\",\"name\":\"小米除濕機04號\",\"room_area\":\"房間003號\",\"type\":\"除濕機\"}',14,'c460a4cb-526f-489d-a49e-e9f810e5bb0a','2024-07-15 00:57:14.168527','新增設備'),(45,'{\"room_name\":\"學姊會議室\",\"name\":\"小米除濕機05號\",\"room_area\":\"房間006號\",\"type\":\"除濕機\"}',15,'f29187bf-1966-4e1e-b03c-9aef4d4de9bb','2024-07-15 00:57:19.553810','新增設備'),(46,'{\"room_name\":\"紅帽男會議室\",\"name\":\"小米除濕機06號\",\"room_area\":\"房間007號\",\"type\":\"除濕機\"}',16,'4d0fdee3-c73c-4997-a4fe-8ce27bed29c2','2024-07-15 00:57:24.780308','新增設備'),(47,'{\"room_name\":\"冠文會議室\",\"name\":\"小米除濕機07號\",\"room_area\":\"房間003號\",\"type\":\"除濕機\"}',17,'baa3bbfa-933f-4eb5-a1c7-70b4f1ec4928','2024-07-15 00:57:30.029487','新增設備'),(48,'{\"room_name\":\"巧翎會議室\",\"name\":\"小米除濕機08號\",\"room_area\":\"房間002號\",\"type\":\"除濕機\"}',18,'51ff6fb3-bbba-4205-a69b-ecb497ad841f','2024-07-15 00:57:34.180270','新增設備'),(49,'{\"room_name\":\"永義會議室\",\"name\":\"小米除濕機09號\",\"room_area\":\"房間001號\",\"type\":\"除濕機\"}',19,'a3fd0ac3-98b6-4189-9978-b8709887f85c','2024-07-15 00:57:38.650039','新增設備'),(50,'{\"room_name\":\"冠文會議室\",\"name\":\"小米除濕機10號\",\"room_area\":\"房間003號\",\"type\":\"除濕機\"}',20,'ddc802f5-1f09-4c8b-9074-ba3a259d09e2','2024-07-15 00:57:43.434661','新增設備'),(51,'{\"room_name\":\"冠霖會議室\",\"name\":\"大金冷氣機01號\",\"room_area\":\"房間004號\",\"type\":\"冷氣機\"}',21,'ea6e4e8e-868b-4fd8-959c-add1932f3bd7','2024-07-15 00:58:13.689269','新增設備'),(52,'{\"room_name\":\"永義會議室\",\"name\":\"大金冷氣機02號\",\"room_area\":\"房間001號\",\"type\":\"冷氣機\"}',22,'7793f769-70e2-42a3-afa7-3302f62c00d4','2024-07-15 00:58:27.109970','新增設備'),(53,'{\"room_name\":\"永義會議室\",\"name\":\"大金冷氣機03號\",\"room_area\":\"房間001號\",\"type\":\"冷氣機\"}',23,'4d04a636-3bd5-4468-b9ae-c9a5ce06f550','2024-07-15 00:58:32.537688','新增設備'),(54,'{\"room_name\":\"永義會議室\",\"name\":\"大金冷氣機04號\",\"room_area\":\"房間001號\",\"type\":\"冷氣機\"}',24,'9cd330ef-93ee-4cb0-8904-d31c01d77201','2024-07-15 00:58:35.951093','新增設備'),(55,'{\"room_name\":\"巧翎會議室\",\"name\":\"大金冷氣機05號\",\"room_area\":\"房間002號\",\"type\":\"冷氣機\"}',25,'eb963776-1fab-43da-bd06-4a38b12c1879','2024-07-15 00:58:40.919874','新增設備'),(56,'{\"room_name\":\"冠文會議室\",\"name\":\"大金冷氣機06號\",\"room_area\":\"房間003號\",\"type\":\"冷氣機\"}',26,'ced4efd5-bdfb-4447-9e74-87ad953a3928','2024-07-15 00:58:45.698163','新增設備'),(57,'{\"room_name\":\"冠霖會議室\",\"name\":\"大金冷氣機07號\",\"room_area\":\"房間004號\",\"type\":\"冷氣機\"}',27,'6c27185b-217b-497f-948f-790b4249bb4e','2024-07-15 00:58:50.141044','新增設備'),(58,'{\"room_name\":\"彥宇會議室\",\"name\":\"大金冷氣機08號\",\"room_area\":\"房間005號\",\"type\":\"冷氣機\"}',28,'1665082c-435b-4377-aef2-84fb28a604a3','2024-07-15 00:58:55.771196','新增設備'),(59,'{\"room_name\":\"學姊會議室\",\"name\":\"大金冷氣機09號\",\"room_area\":\"房間006號\",\"type\":\"冷氣機\"}',29,'719360e3-61c6-4b0c-bcb8-9b00294a35f1','2024-07-15 00:58:59.958020','新增設備'),(60,'{\"room_name\":\"紅帽男會議室\",\"name\":\"大金冷氣機10號\",\"room_area\":\"房間007號\",\"type\":\"冷氣機\"}',30,'1c947292-5d0c-45c4-9612-654bedb767b0','2024-07-15 00:59:04.228614','新增設備'),(61,'{\"room_name\":\"紅帽男會議室\",\"name\":\"燈泡01號\",\"room_area\":\"房間007號\",\"type\":\"燈\"}',31,'bf096862-5ed7-4c0b-8dd1-3ea1dc09fdd4','2024-07-15 00:59:43.154564','新增設備'),(62,'{\"room_name\":\"學姊會議室\",\"name\":\"燈泡02號\",\"room_area\":\"房間006號\",\"type\":\"燈\"}',32,'923d52f5-5933-495c-8d32-cf5756cbae7f','2024-07-15 00:59:49.076052','新增設備'),(63,'{\"room_name\":\"彥宇會議室\",\"name\":\"燈泡03號\",\"room_area\":\"房間005號\",\"type\":\"燈\"}',33,'159b4862-ae52-4a77-b356-594f009f5b6f','2024-07-15 00:59:54.770020','新增設備'),(64,'{\"room_name\":\"冠文會議室\",\"name\":\"燈泡04號\",\"room_area\":\"房間003號\",\"type\":\"燈\"}',34,'1b79c061-70d3-40c8-83de-2160f70338c3','2024-07-15 01:00:00.054021','新增設備'),(65,'{\"room_name\":\"巧翎會議室\",\"name\":\"燈泡05號\",\"room_area\":\"房間002號\",\"type\":\"燈\"}',35,'84932430-4dc2-41a7-854d-6239dfc53104','2024-07-15 01:00:03.912115','新增設備'),(66,'{\"room_name\":\"永義會議室\",\"name\":\"燈泡06號\",\"room_area\":\"房間001號\",\"type\":\"燈\"}',36,'d31258ab-9398-488e-bb66-ac7d37a642ec','2024-07-15 01:00:09.427058','新增設備'),(67,'{\"room_name\":\"永義會議室\",\"name\":\"燈泡07號\",\"room_area\":\"房間001號\",\"type\":\"燈\"}',37,'42ddf5f5-cf2a-4c43-90bd-1bb98bb99eac','2024-07-15 01:00:12.481746','新增設備'),(68,'{\"room_name\":\"永義會議室\",\"name\":\"燈泡08號\",\"room_area\":\"房間001號\",\"type\":\"燈\"}',38,'84253f5a-f4fc-4652-ad08-359c4784bc11','2024-07-15 01:00:15.073452','新增設備'),(69,'{\"room_name\":\"永義會議室\",\"name\":\"燈泡09號\",\"room_area\":\"房間001號\",\"type\":\"燈\"}',39,'ea5b8eca-b859-4f0c-a691-3da920023381','2024-07-15 01:00:17.812594','新增設備'),(70,'{\"room_name\":\"永義會議室\",\"name\":\"燈泡10號\",\"room_area\":\"房間001號\",\"type\":\"燈\"}',40,'bc7e5323-d597-4e87-a90b-b9d882e3f45e','2024-07-15 01:00:21.012583','新增設備'),(71,'{\"room_name\":\"男哥會議室\",\"name\":\"燈泡11號\",\"room_area\":\"房間010號\",\"type\":\"燈\"}',41,'167fd897-e3d7-4875-b3a8-35cde0c3d943','2024-07-15 01:00:38.326896','新增設備'),(72,'{\"room_name\":\"山口組公司\",\"name\":\"燈泡12號\",\"room_area\":\"房間012號\",\"type\":\"燈\"}',42,'d3a35071-e480-432b-9011-7098f7117906','2024-07-15 01:00:45.495926','新增設備'),(73,'{\"room_name\":\"軒豪公司\",\"name\":\"燈泡13號\",\"room_area\":\"房間013號\",\"type\":\"燈\"}',43,'f859b943-7228-4528-aaf4-10cd138484b8','2024-07-15 01:00:49.803145','新增設備'),(74,'{\"room_name\":\"俊傑公司\",\"name\":\"燈泡14號\",\"room_area\":\"房間014號\",\"type\":\"燈\"}',44,'0f29bd12-4b5c-436a-8864-21ce81f17b57','2024-07-15 01:00:53.802399','新增設備'),(75,'{\"room_name\":\"子慧公司\",\"name\":\"燈泡15號\",\"room_area\":\"房間015號\",\"type\":\"燈\"}',45,'7e62db7e-329d-4258-a504-84dbd51c854a','2024-07-15 01:00:58.099148','新增設備'),(76,'{\"room_name\":\"彥宇公司\",\"name\":\"燈泡16號\",\"room_area\":\"房間016號\",\"type\":\"燈\"}',46,'b2b2be69-5fa0-4149-b731-dfc4c7dc0c06','2024-07-15 01:01:02.061639','新增設備'),(77,'{\"room_name\":\"董卓公司\",\"name\":\"燈泡17號\",\"room_area\":\"房間017號\",\"type\":\"燈\"}',47,'9f266d16-0125-4fe6-856d-02e642b0d787','2024-07-15 01:01:05.843410','新增設備'),(78,'{\"room_name\":\"SWAG公司\",\"name\":\"燈泡18號\",\"room_area\":\"房間018號\",\"type\":\"燈\"}',48,'6ee3d009-5932-4e71-abdc-70c81b3d92cc','2024-07-15 01:01:09.647589','新增設備'),(79,'{\"room_name\":\"正門門口\",\"name\":\"燈泡19號\",\"room_area\":\"公共區域01號\",\"type\":\"燈\"}',49,'fd72f425-d40d-49d5-a327-f95a1e1e3160','2024-07-15 01:01:15.019754','新增設備'),(80,'{\"room_name\":\"側門門口\",\"name\":\"燈泡20號\",\"room_area\":\"公共區域02號\",\"type\":\"燈\"}',50,'81c8a1a1-858f-45d8-af74-4cdf0b7f3a3e','2024-07-15 01:01:19.536077','新增設備');
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
INSERT INTO `light` VALUES (31,0,0),(32,0,0),(33,0,0),(34,0,0),(35,0,0),(36,0,0),(37,0,0),(38,0,0),(39,0,0),(40,0,0),(41,0,0),(42,0,0),(43,0,0),(44,0,0),(45,0,0),(46,0,0),(47,0,0),(48,0,0),(49,0,0),(50,0,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,'房間001號','永義會議室',_binary '\0','會議室'),(2,'房間002號','巧翎會議室',_binary '\0','會議室'),(3,'房間003號','冠文會議室',_binary '\0','會議室'),(4,'房間004號','冠霖會議室',_binary '\0','會議室'),(5,'房間005號','彥宇會議室',_binary '\0','會議室'),(6,'房間006號','學姊會議室',_binary '\0','會議室'),(7,'房間007號','紅帽男會議室',_binary '\0','會議室'),(8,'房間008號','請假王會議室',_binary '\0','會議室'),(9,'房間009號','班吉拉斯會議室',_binary '\0','會議室'),(10,'房間010號','男哥會議室',_binary '\0','會議室'),(11,'房間011號','男哥公司',_binary '\0','公司'),(12,'房間012號','山口組公司',_binary '\0','公司'),(13,'房間013號','軒豪公司',_binary '\0','公司'),(14,'房間014號','俊傑公司',_binary '\0','公司'),(15,'房間015號','子慧公司',_binary '\0','公司'),(16,'房間016號','彥宇公司',_binary '\0','公司'),(17,'房間017號','董卓公司',_binary '\0','公司'),(18,'房間018號','SWAG公司',_binary '\0','公司'),(19,'公共區域01號','正門門口',_binary '\0','公共區域'),(20,'公共區域02號','側門門口',_binary '\0','公共區域'),(21,'公共區域03號','後門門口',_binary '\0','公共區域'),(22,'廁所01號','男廁',_binary '\0','廁所'),(23,'廁所02號','女廁',_binary '\0','廁所'),(24,'機房01號','傳說中的秘境',_binary '\0','機房'),(25,'機房02號','天堂路',_binary '\0','機房'),(26,'教室01號','紅帽男的概念大講堂',_binary '\0','教室'),(27,'教室02號','請假王的使用者驗證教學',_binary '\0','教室'),(28,'教室03號','董卓的前端學院',_binary '\0','教室'),(29,'其他01號','學姊被關的地方',_binary '\0','其他'),(30,'其他02號','請假王睡覺的地方',_binary '\0','其他');
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

-- Dump completed on 2024-07-15  1:05:48
