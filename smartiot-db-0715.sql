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
INSERT INTO `ac` VALUES (1,24.773521493995005,'LOW','COOL',25),(2,23.06352753802034,'LOW','COOL',25),(3,23.274445319088283,'LOW','COOL',25),(4,23.3274435372862,'LOW','COOL',25),(5,23.498268532211956,'LOW','COOL',25),(6,10.553778884615289,'LOW','COOL',25),(7,10.375506581039254,'LOW','COOL',25),(8,10.334965151003615,'LOW','COOL',25),(9,10.647001108421922,'LOW','COOL',25);
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
INSERT INTO `air_purifier` VALUES (13,16,0,0),(14,2,0,0),(15,25,0,0),(16,38,0,0),(17,23,0,0),(18,30,0,0),(19,11,0,0),(20,59,0,0),(21,1,0,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `announcement`
--

LOCK TABLES `announcement` WRITE;
/*!40000 ALTER TABLE `announcement` DISABLE KEYS */;
INSERT INTO `announcement` VALUES (1,'為了提高大家對突發狀況的應對能力，我們將在下周進行一次全員停電演習。演習時間為下午3點到4點，請大家提前保存好重要的工作資料，並準備好應急照明設備。演習期間，我們會模擬停電情況，考察大家的應急反應能力。希望大家能夠認真對待，並在演習結束後提供反饋。我們的目標是確保在真實停電情況下，大家能夠迅速、安全地應對。','2024-07-15','全員停電演習'),(2,'為了提升辦公室的空氣質量，我們發起了淨化空氣大挑戰！在接下來的一周內，我們鼓勵大家多開窗通風，使用辦公室配備的空氣淨化器，並減少使用對空氣有害的化學製品。你可以在公告板上記錄下你的貢獻，看看誰能成為本周的淨化空氣之星。我們相信，在大家的共同努力下，辦公室的空氣會變得更加清新、健康。','2024-07-15','淨化空氣大挑戰'),(3,'大家好！工作壓力大嗎？來加入我們的午休瑜伽課吧！每天中午12點，我們會在會議室舉行一場放鬆身心的瑜伽課程。無論你是瑜伽新手還是高手，都歡迎參加。帶上你的瑜伽墊，換上舒適的運動服，來享受這段愉快的時光吧！瑜伽可以幫助你釋放壓力，增強身體柔韌性，是提升工作效率的絕佳方式。期待你的參與!','2024-07-15','午休瑜伽課');
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
INSERT INTO `announcement_room_ids` VALUES (1,1),(1,2),(1,3),(1,5),(1,7),(1,9),(2,1),(2,2),(2,3),(2,5),(2,7),(2,9),(3,1),(3,2),(3,3),(3,5),(3,7),(3,9);
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
INSERT INTO `dehumidifier` VALUES (10,78.40804262990427,NULL,0,0),(11,78.25677360104193,NULL,0,0),(12,78.645307867304,NULL,0,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device`
--

LOCK TABLES `device` WRITE;
/*!40000 ALTER TABLE `device` DISABLE KEYS */;
INSERT INTO `device` VALUES (1,'冷氣機01',1.43,_binary '\0','2024-07-15 22:17:21.910639','冷氣機',9),(2,'冷氣機02',1.43,_binary '\0','2024-07-15 22:17:23.779618','冷氣機',8),(3,'冷氣機03',1.43,_binary '\0','2024-07-15 22:17:25.697417','冷氣機',7),(4,'冷氣機04',1.43,_binary '\0','2024-07-15 22:17:27.438114','冷氣機',6),(5,'冷氣機06',1.43,_binary '\0','2024-07-15 22:17:29.651765','冷氣機',4),(6,'大米冷氣機05',1.43,_binary '\0','2024-07-15 22:17:35.858618','冷氣機',5),(7,'冷氣機06',1.43,_binary '\0','2024-07-15 22:17:37.832767','冷氣機',4),(8,'冷氣機08',1.43,_binary '\0','2024-07-15 22:17:40.001219','冷氣機',2),(9,'冷氣機09',1.43,_binary '\0','2024-07-15 22:17:41.955455','冷氣機',1),(10,'除濕機02',0.19,_binary '\0','2024-07-15 22:17:43.959803','除濕機',2),(11,'除濕機01',0.19,_binary '\0','2024-07-15 22:17:48.833260','除濕機',1),(12,'除濕機03',0.19,_binary '\0','2024-07-15 22:18:01.765267','除濕機',3),(13,'空氣清淨機01',0.048,_binary '\0','2024-07-15 22:20:50.235383','空氣清淨機',1),(14,'空氣清淨機02',0.048,_binary '\0','2024-07-15 22:20:59.259004','空氣清淨機',2),(15,'空氣清淨機03',0.048,_binary '\0','2024-07-15 22:21:05.257878','空氣清淨機',3),(16,'空氣清淨機04',0.048,_binary '\0','2024-07-15 22:21:10.586226','空氣清淨機',4),(17,'空氣清淨機05',0.048,_binary '\0','2024-07-15 22:21:15.647456','空氣清淨機',5),(18,'空氣清淨機06',0.048,_binary '\0','2024-07-15 22:21:19.336944','空氣清淨機',6),(19,'空氣清淨機07',0.048,_binary '\0','2024-07-15 22:21:23.935317','空氣清淨機',7),(20,'空氣清淨機08',0.048,_binary '\0','2024-07-15 22:21:28.329030','空氣清淨機',8),(21,'空氣清淨機09',0.048,_binary '\0','2024-07-15 22:21:32.472102','空氣清淨機',9),(22,'燈01',0.04,_binary '\0','2024-07-15 22:22:15.668606','燈',9),(23,'燈02',0.04,_binary '\0','2024-07-15 22:22:22.508786','燈',8),(24,'燈03',0.04,_binary '\0','2024-07-15 22:22:27.199986','燈',7),(25,'燈04',0.04,_binary '\0','2024-07-15 22:22:31.933542','燈',6),(26,'燈05',0.04,_binary '\0','2024-07-15 22:22:36.147254','燈',5),(27,'燈06',0.04,_binary '\0','2024-07-15 22:22:47.613770','燈',4),(28,'燈07',0.04,_binary '\0','2024-07-15 22:22:53.925742','燈',3),(29,'燈08',0.04,_binary '\0','2024-07-15 22:22:58.630348','燈',2),(30,'燈09',0.04,_binary '\0','2024-07-15 22:23:03.280685','燈',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
INSERT INTO `history` VALUES (1,'{\"roomArea\":\"600\",\"roomName\":\"快要倒閉的公司\",\"roomType\":\"公司\"}',1,'d34adda8-bab6-4943-9b51-943e675a6554','2024-07-15 22:16:49.129649','新增房間'),(2,'{\"roomArea\":\"601\",\"roomName\":\"傳接球美女公司\",\"roomType\":\"公司\"}',2,'e8103a8c-6989-429a-82e5-2444dccac583','2024-07-15 22:16:58.963677','新增房間'),(3,'{\"roomArea\":\"603\",\"roomName\":\"冠霖要開會了的會議室\",\"roomType\":\"會議室\"}',3,'5a42e5b9-fdb9-4e33-8a51-b3b9c0e9c6e7','2024-07-15 22:17:02.116898','新增房間'),(4,'{\"roomArea\":\"604\",\"roomName\":\"日本組的會議室\",\"roomType\":\"會議室\"}',4,'94598603-ba66-4cee-ae95-be269b0243c7','2024-07-15 22:17:04.631632','新增房間'),(5,'{\"roomArea\":\"605\",\"roomName\":\"學姐關自己的地方\",\"roomType\":\"公共區域\"}',5,'041c8d06-3e89-486d-a8b2-f0725a80617e','2024-07-15 22:17:07.193027','新增房間'),(6,'{\"roomArea\":\"606\",\"roomName\":\"卡比瘦的機房\",\"roomType\":\"機房\"}',6,'68ec9378-fe58-407c-9a77-0a75eafbe9be','2024-07-15 22:17:09.389612','新增房間'),(7,'{\"roomArea\":\"607\",\"roomName\":\"性別平等的廁所\",\"roomType\":\"廁所\"}',7,'1ec59f16-3637-4fff-9e83-6e5068ac6fc2','2024-07-15 22:17:11.575434','新增房間'),(8,'{\"roomArea\":\"608\",\"roomName\":\"紅帽男的哲學課\",\"roomType\":\"教室\"}',8,'c0445539-d79e-4ca1-96de-0e0300f6e470','2024-07-15 22:17:13.698203','新增房間'),(9,'{\"roomArea\":\"609\",\"roomName\":\"班吉拉斯躲起來的地方\",\"roomType\":\"其他\"}',9,'d43e93b9-831c-4c4c-b891-cacdad9b31fd','2024-07-15 22:17:15.545540','新增房間'),(10,'{\"deviceType\":\"冷氣機\",\"roomArea\":\"609\",\"deviceName\":\"冷氣機01\",\"roomName\":\"班吉拉斯躲起來的地方\"}',1,'423f7fa6-0ce4-413c-b560-0f2745ce07c0','2024-07-15 22:17:21.934613','新增設備'),(11,'{\"deviceType\":\"冷氣機\",\"roomArea\":\"608\",\"deviceName\":\"冷氣機02\",\"roomName\":\"紅帽男的哲學課\"}',2,'d765f49e-24f9-4ca2-8e9b-b25dbc5edd35','2024-07-15 22:17:23.798742','新增設備'),(12,'{\"deviceType\":\"冷氣機\",\"roomArea\":\"607\",\"deviceName\":\"冷氣機03\",\"roomName\":\"性別平等的廁所\"}',3,'ceb51df8-96ff-4f60-95ac-36f3777384fe','2024-07-15 22:17:25.709857','新增設備'),(13,'{\"deviceType\":\"冷氣機\",\"roomArea\":\"606\",\"deviceName\":\"冷氣機04\",\"roomName\":\"卡比瘦的機房\"}',4,'7b7251e7-6985-41d9-b90c-6db83edaa640','2024-07-15 22:17:27.450989','新增設備'),(14,'{\"deviceType\":\"冷氣機\",\"roomArea\":\"604\",\"deviceName\":\"冷氣機06\",\"roomName\":\"日本組的會議室\"}',5,'7bb350ec-3cf9-47c4-8092-e58c1392edc5','2024-07-15 22:17:29.664195','新增設備'),(15,'{\"deviceType\":\"冷氣機\",\"roomArea\":\"605\",\"deviceName\":\"大米冷氣機05\",\"roomName\":\"學姐關自己的地方\"}',6,'a1ce8271-6d65-4b1b-9019-fd9b52fefe98','2024-07-15 22:17:35.868165','新增設備'),(16,'{\"deviceType\":\"冷氣機\",\"roomArea\":\"604\",\"deviceName\":\"冷氣機06\",\"roomName\":\"日本組的會議室\"}',7,'5baab216-8a4f-4865-b265-6868518fef6c','2024-07-15 22:17:37.843838','新增設備'),(17,'{\"deviceType\":\"冷氣機\",\"roomArea\":\"601\",\"deviceName\":\"冷氣機08\",\"roomName\":\"傳接球美女公司\"}',8,'f8c82da8-b3c3-42c3-a0a3-3695b0471944','2024-07-15 22:17:40.017159','新增設備'),(18,'{\"deviceType\":\"冷氣機\",\"roomArea\":\"600\",\"deviceName\":\"冷氣機09\",\"roomName\":\"快要倒閉的公司\"}',9,'cbc4c1bc-4d63-4c9f-a8ae-db8946494de4','2024-07-15 22:17:41.965981','新增設備'),(19,'{\"deviceType\":\"除濕機\",\"roomArea\":\"601\",\"deviceName\":\"除濕機02\",\"roomName\":\"傳接球美女公司\"}',10,'318cc786-cc5b-4617-9ec6-adda18810724','2024-07-15 22:17:43.973320','新增設備'),(20,'{\"deviceType\":\"除濕機\",\"roomArea\":\"600\",\"deviceName\":\"除濕機01\",\"roomName\":\"快要倒閉的公司\"}',11,'95121810-c1e3-4295-b652-cdf2a8013a8f','2024-07-15 22:17:48.841990','新增設備'),(21,'{\"deviceType\":\"除濕機\",\"roomArea\":\"603\",\"deviceName\":\"除濕機03\",\"roomName\":\"冠霖要開會了的會議室\"}',12,'4ecb689c-3f9c-4911-b4e2-03d18f574eb3','2024-07-15 22:18:01.797732','新增設備'),(22,'{\"deviceType\":\"空氣清淨機\",\"roomArea\":\"600\",\"deviceName\":\"空氣清淨機01\",\"roomName\":\"快要倒閉的公司\"}',13,'b0602d63-066f-438c-abbb-2c2960b551a2','2024-07-15 22:20:50.244908','新增設備'),(23,'{\"deviceType\":\"空氣清淨機\",\"roomArea\":\"601\",\"deviceName\":\"空氣清淨機02\",\"roomName\":\"傳接球美女公司\"}',14,'1c92a100-9970-4940-b716-a037bd73ff7e','2024-07-15 22:20:59.269009','新增設備'),(24,'{\"deviceType\":\"空氣清淨機\",\"roomArea\":\"603\",\"deviceName\":\"空氣清淨機03\",\"roomName\":\"冠霖要開會了的會議室\"}',15,'c98239b6-5949-4015-9181-e3a5b585cee3','2024-07-15 22:21:05.265033','新增設備'),(25,'{\"deviceType\":\"空氣清淨機\",\"roomArea\":\"604\",\"deviceName\":\"空氣清淨機04\",\"roomName\":\"日本組的會議室\"}',16,'9306d47d-d1f3-4f34-8eef-817f5ba3b307','2024-07-15 22:21:10.594957','新增設備'),(26,'{\"deviceType\":\"空氣清淨機\",\"roomArea\":\"605\",\"deviceName\":\"空氣清淨機05\",\"roomName\":\"學姐關自己的地方\"}',17,'bc805fc4-c2d6-4b1e-9aea-a16acf36e10c','2024-07-15 22:21:15.655567','新增設備'),(27,'{\"deviceType\":\"空氣清淨機\",\"roomArea\":\"606\",\"deviceName\":\"空氣清淨機06\",\"roomName\":\"卡比瘦的機房\"}',18,'5a4e42d2-b746-4578-8182-28549e5114d3','2024-07-15 22:21:19.343924','新增設備'),(28,'{\"deviceType\":\"空氣清淨機\",\"roomArea\":\"607\",\"deviceName\":\"空氣清淨機07\",\"roomName\":\"性別平等的廁所\"}',19,'787b5653-b2b3-46bf-96b7-7b3ec8634426','2024-07-15 22:21:23.944885','新增設備'),(29,'{\"deviceType\":\"空氣清淨機\",\"roomArea\":\"608\",\"deviceName\":\"空氣清淨機08\",\"roomName\":\"紅帽男的哲學課\"}',20,'91a067db-fcdd-4b4a-982a-d4a87798f12c','2024-07-15 22:21:28.337162','新增設備'),(30,'{\"deviceType\":\"空氣清淨機\",\"roomArea\":\"609\",\"deviceName\":\"空氣清淨機09\",\"roomName\":\"班吉拉斯躲起來的地方\"}',21,'649440a7-ee69-4091-91ad-6c38bbaa7a95','2024-07-15 22:21:32.480406','新增設備'),(31,'{\"deviceType\":\"燈\",\"roomArea\":\"609\",\"deviceName\":\"燈01\",\"roomName\":\"班吉拉斯躲起來的地方\"}',22,'8eeee65d-32a1-40e1-a4d0-4283a0a358f7','2024-07-15 22:22:15.678371','新增設備'),(32,'{\"deviceType\":\"燈\",\"roomArea\":\"608\",\"deviceName\":\"燈02\",\"roomName\":\"紅帽男的哲學課\"}',23,'f16024ee-151c-4f8e-bd55-f03e6f982bfb','2024-07-15 22:22:22.515467','新增設備'),(33,'{\"deviceType\":\"燈\",\"roomArea\":\"607\",\"deviceName\":\"燈03\",\"roomName\":\"性別平等的廁所\"}',24,'857b6766-4835-4c0f-b64d-df692c5baa27','2024-07-15 22:22:27.209760','新增設備'),(34,'{\"deviceType\":\"燈\",\"roomArea\":\"606\",\"deviceName\":\"燈04\",\"roomName\":\"卡比瘦的機房\"}',25,'c6ad6921-2a83-403e-ab2c-0b509b59b2d5','2024-07-15 22:22:31.940891','新增設備'),(35,'{\"deviceType\":\"燈\",\"roomArea\":\"605\",\"deviceName\":\"燈05\",\"roomName\":\"學姐關自己的地方\"}',26,'36a6761d-a3f0-4b32-a53d-7583455ebf7c','2024-07-15 22:22:36.154609','新增設備'),(36,'{\"deviceType\":\"燈\",\"roomArea\":\"604\",\"deviceName\":\"燈06\",\"roomName\":\"日本組的會議室\"}',27,'8b117a0b-689d-41a6-911d-56da83180cf3','2024-07-15 22:22:47.620763','新增設備'),(37,'{\"deviceType\":\"燈\",\"roomArea\":\"603\",\"deviceName\":\"燈07\",\"roomName\":\"冠霖要開會了的會議室\"}',28,'61e7ecc5-42cd-4f21-8412-55990b8a1d1e','2024-07-15 22:22:53.932792','新增設備'),(38,'{\"deviceType\":\"燈\",\"roomArea\":\"601\",\"deviceName\":\"燈08\",\"roomName\":\"傳接球美女公司\"}',29,'3686ae40-caba-421b-8bb0-a8ebf8563add','2024-07-15 22:22:58.638292','新增設備'),(39,'{\"deviceType\":\"燈\",\"roomArea\":\"600\",\"deviceName\":\"燈09\",\"roomName\":\"快要倒閉的公司\"}',30,'55bdab37-2e7f-4266-b92d-cc412b07bc81','2024-07-15 22:23:03.287984','新增設備'),(40,'{\"deviceType\":\"冷氣機\",\"roomArea\":\"609\",\"deviceName\":\"冷氣機01\",\"roomName\":\"班吉拉斯躲起來的地方\",\"status\":\"開\"}',1,'14c27bf0-d396-423c-bfc0-5686702d6d3a','2024-07-15 22:24:53.901612','設備開關'),(41,'{\"deviceType\":\"冷氣機\",\"roomArea\":\"608\",\"deviceName\":\"冷氣機02\",\"roomName\":\"紅帽男的哲學課\",\"status\":\"開\"}',2,'14b8c2fb-4dec-4fe0-837b-60c28d90516b','2024-07-15 22:25:02.848032','設備開關'),(42,'{\"deviceType\":\"冷氣機\",\"roomArea\":\"607\",\"deviceName\":\"冷氣機03\",\"roomName\":\"性別平等的廁所\",\"status\":\"開\"}',3,'7d78defd-e622-4284-9161-096c5dfded28','2024-07-15 22:25:07.006882','設備開關'),(43,'{\"deviceType\":\"冷氣機\",\"roomArea\":\"606\",\"deviceName\":\"冷氣機04\",\"roomName\":\"卡比瘦的機房\",\"status\":\"開\"}',4,'b3fef45d-973a-44db-a2ef-54485ed040b3','2024-07-15 22:25:10.332877','設備開關'),(44,'{\"deviceType\":\"冷氣機\",\"roomArea\":\"604\",\"deviceName\":\"冷氣機06\",\"roomName\":\"日本組的會議室\",\"status\":\"開\"}',5,'9bab2bcf-4156-444a-9dca-50f88465543b','2024-07-15 22:25:13.160258','設備開關'),(45,'{\"deviceType\":\"冷氣機\",\"roomArea\":\"609\",\"deviceName\":\"冷氣機01\",\"target_temp\":25,\"roomName\":\"班吉拉斯躲起來的地方\"}',1,'0eeb0691-c201-48c8-830b-3aee69d423d6','2024-07-15 22:26:05.409664','設備參數調整'),(46,'{\"deviceType\":\"冷氣機\",\"roomArea\":\"609\",\"deviceName\":\"冷氣機01\",\"roomName\":\"班吉拉斯躲起來的地方\",\"status\":\"關\"}',1,'ab9d62e4-cd01-47fa-a4a3-f4435f9d474e','2024-07-15 22:35:54.696577','設備開關'),(47,'{\"deviceType\":\"冷氣機\",\"roomArea\":\"608\",\"deviceName\":\"冷氣機02\",\"roomName\":\"紅帽男的哲學課\",\"status\":\"關\"}',2,'5824c430-5ddf-47ea-bdea-a20934df9878','2024-07-15 22:36:03.310886','設備開關'),(48,'{\"deviceType\":\"冷氣機\",\"roomArea\":\"607\",\"deviceName\":\"冷氣機03\",\"roomName\":\"性別平等的廁所\",\"status\":\"關\"}',3,'1b662a77-7970-4d5c-897f-4b82010c5d44','2024-07-15 22:36:09.166220','設備開關'),(49,'{\"deviceType\":\"冷氣機\",\"roomArea\":\"606\",\"deviceName\":\"冷氣機04\",\"roomName\":\"卡比瘦的機房\",\"status\":\"關\"}',4,'e1916b39-3a59-42ec-a3f5-80b25993e4dd','2024-07-15 22:36:13.187111','設備開關'),(50,'{\"deviceType\":\"冷氣機\",\"roomArea\":\"604\",\"deviceName\":\"冷氣機06\",\"roomName\":\"日本組的會議室\",\"status\":\"關\"}',5,'74f1e723-ed09-438c-85e4-d9bd63a1915a','2024-07-15 22:36:19.079612','設備開關');
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
INSERT INTO `light` VALUES (22,0,0),(23,0,0),(24,0,0),(25,0,0),(26,0,0),(27,0,0),(28,0,0),(29,0,0),(30,0,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,'600','快要倒閉的公司',_binary '\0','公司'),(2,'601','傳接球美女公司',_binary '\0','公司'),(3,'603','冠霖要開會了的會議室',_binary '\0','會議室'),(4,'604','日本組的會議室',_binary '\0','會議室'),(5,'605','學姐關自己的地方',_binary '\0','公共區域'),(6,'606','卡比瘦的機房',_binary '\0','機房'),(7,'607','性別平等的廁所',_binary '\0','廁所'),(8,'608','紅帽男的哲學課',_binary '\0','教室'),(9,'609','班吉拉斯躲起來的地方',_binary '\0','其他');
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

-- Dump completed on 2024-07-15 22:39:44
