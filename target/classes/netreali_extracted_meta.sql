CREATE DATABASE  IF NOT EXISTS `netreali` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `netreali`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: netreali
-- ------------------------------------------------------
-- Server version	5.7.11-log

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
-- Table structure for table `extracted_meta`
--

DROP TABLE IF EXISTS `extracted_meta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `extracted_meta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) NOT NULL,
  `settlements` longtext,
  `dates` longtext,
  `names` longtext,
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `primary_key` (`id`,`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `extracted_meta`
--

LOCK TABLES `extracted_meta` WRITE;
/*!40000 ALTER TABLE `extracted_meta` DISABLE KEYS */;
INSERT INTO `extracted_meta` VALUES (1,1,'','',''),(2,2,'','',''),(3,3,'','',''),(4,4,'','',''),(5,5,'','',''),(6,6,'','12:00',''),(7,7,'','12:00',''),(8,8,'','',''),(9,9,'','',''),(10,10,'','21:26',''),(11,11,'','',''),(12,12,'','',''),(13,13,'','',''),(14,14,'','',''),(15,15,'','',''),(16,16,'','',''),(17,17,'','',''),(18,18,'','',''),(19,19,'','',''),(20,20,'','14:00',''),(21,21,'','',''),(22,22,'','',''),(23,23,'','',''),(24,24,'','',''),(25,25,'','',''),(26,26,'','',''),(27,27,'','',''),(28,28,'','',''),(29,29,'','',''),(30,30,'','',''),(31,31,'','',''),(32,32,'','',''),(33,33,'','',''),(34,34,'','',''),(35,35,'','',''),(36,36,'','november 30',''),(37,37,'','',''),(38,38,'','',''),(39,39,'','',''),(40,40,'','',''),(41,41,'','',''),(42,42,'','',''),(43,43,'','',''),(44,44,'','',''),(45,45,'','',''),(46,46,'','',''),(47,47,'','',''),(48,48,'','',''),(49,49,'','',''),(50,50,'','',''),(51,51,'','',''),(52,52,'','',''),(53,53,'','',''),(54,54,'','',''),(55,55,'','',''),(56,56,'','',''),(57,57,'','',''),(58,58,'','',''),(59,59,'','13:30',''),(60,60,'','',''),(61,61,'','',''),(62,62,'','',''),(63,63,'','',''),(64,64,'','',''),(65,65,'','',''),(66,66,'','',''),(67,67,'','',''),(68,68,'','',''),(69,69,'','',''),(70,70,'','',''),(71,71,'','',''),(72,72,'','',''),(73,73,'','',''),(74,74,'','',''),(75,75,'','',''),(76,76,'','',''),(77,77,'','',''),(78,78,'','',''),(79,79,'','',''),(80,80,'','',''),(81,81,'','',''),(82,82,'','',''),(83,83,'','',''),(84,84,'','',''),(85,85,'','','');
/*!40000 ALTER TABLE `extracted_meta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-16 16:11:40
