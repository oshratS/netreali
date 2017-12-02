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
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `extracted_meta`
--

LOCK TABLES `extracted_meta` WRITE;
/*!40000 ALTER TABLE `extracted_meta` DISABLE KEYS */;
INSERT INTO `extracted_meta` VALUES (1,1,'elon,elat,etan,yesha,lod,neta,netanya,eli','january,october,dec,august,mar,mar,saturday','ara,ari,ari,aya,ben,benjamin,eban,edi,eli,etan,eve,evie,ham,haya,ira,ira,israel,mary,ori,orin,oz,rae,rani,shai,shay,shay,tal,uma,uri,yeshaya'),(2,2,'elon,adi,eli','mar,sep,mar,july,mar,sept,friday','abra,ann,ara,avi,aya,eban,eitan,eli,eve,hadar,hadar,ham,haya,israel,nera,rae,tal'),(3,3,'erez,adi,eli','','afra,ari,ari,dina,eli,este,eva,eve,ori,peri,sam,sam,uri'),(4,4,'ora,dan,samar,eli','mar,mar,mar,mar,mar,friday','amari,amari,amit,ari,ari,aria,dan,edi,eli,este,eva,eve,gil,gila,israel,jordan,jordan,jude,rae,sam,sam,tal,uri'),(5,5,'ortal,dan,tene,samar,eli','mar,mar,mar,mar,thursday','amari,amari,ara,ari,ari,aria,busy,dagan,dan,dina,eli,eva,eve,israel,jude,matt,oz,rae,sam,sam,shem,tal,uma,uri,yisrael'),(6,6,'ora,dan,eli,arad','12:00,may,may,sunday','ara,avi,aviv,aya,ben,boaz,dan,edi,eli,este,eve,ham,idan,ilan,ilana,matt,nera,nissa,nissan,ori,peri,uri,yitzhak'),(7,7,'ora,etan,nov,neta,netanya,arad','12:00,may,nov,sunday','amon,ara,aron,avi,aviv,ben,benjamin,edi,etan,eve,gil,gila,ham,ilan,ilana,matt,nera,nissa,nissan,ori,peri,reuven,sam,sam,uri,uriel,yaron,yitzhak'),(8,8,'ora,elon,dan,tire,adi','dec,dec,sept','ann,anne,dan,este,eve,ham,israel,ori,oz,rae,reuven,sem,shem,uri,yosef'),(9,9,'omen,erez,kissufim,samar,adi,eli','12:00,dec,mar,mar,dec,thursday,wednesday','amari,amari,amon,ann,anne,ara,ari,ari,aria,ben,dina,edi,eitan,eli,este,eve,ham,israel,jude,liz,nera,ori,rae,rei,sam,sam,sem,shai,uri,vered'),(10,10,'adi,eli,arad,rame','21:26,may,thursday','ara,aram,avi,ben,edi,eli,ephraim,eva,eve,gil,gila,ham,ilan,ilana,ira,ira,lem,liz,nera,nissa,nissan,ori,oz,uri,uriel,ziv'),(11,11,'dor,dan,eli','dec,thursday','ari,ari,avi,dan,eli,eve,ham,idan,israel,rae,rei'),(12,12,'elon,erez,dan,adi,eli','','ann,anne,ari,ari,dan,edi,eli,eve,ham,idan,israel,nera,ori,oz,rae,sam,sam,uri'),(13,13,'elon,erez,dan','wednesday','ari,ari,ben,dan,eva,eve,ham,idan,ori,rei,sam,sam,shai,uri'),(14,14,'ortal,dan,samar,eli,rame','mar,mar,mar,thursday','amari,amari,ann,ara,aram,ari,ari,aria,dagan,dan,dina,edi,eli,eva,eve,israel,jude,oz,rae,sam,sam,tal,uri,zak'),(15,15,'ora,elon,elat,adi,eli','mar,march,dec','ann,anne,ara,ari,ari,asa,asa,eban,eli,eva,eve,israel,job,lev,machi,nomi,ori,peri,rae,rei,rena,saul,simi,tal,tali,uri'),(16,16,'ohad,omen,ora,elon,tire,jerusalem,eli','march 20,december,wednesday','amon,ben,eban,eli,elisha,elisha,emmanuel,este,eva,eve,hillel,israel,lem,meir,oren,ori,rae,rei,riva,shlomo,simi,uri,zion,zion'),(17,17,'adi','mar,dec,monday','ann,ara,ari,ari,israel,lem,nava,nomi,oz,peri,rae,riva,simi,uri'),(18,18,'gadot,eli','','aitan,aliza,ann,ari,ari,eban,edi,eli,este,eve,ham,israel,liz,liza,nera,rae,ruth,sam,sam,uri,zia'),(19,19,'dor,dan,lod,adi,eli','thursday','ann,anne,ara,ari,ari,dan,dani,dania,eli,eve,ira,ira,israel,james,james,jordan,jordan,ori,orit,rae,rei,roni,roni,sam,sam,vered'),(20,20,'ora,elat,dan,natur,eli','aug,august,december 2,thursday','aliza,amon,ann,anne,ara,ari,ari,dan,eban,eden,edi,eli,este,eve,ham,israel,lem,liz,liza,nera,rae,sam,sam,tal,uri,zia'),(21,21,'omen','friday,monday','abba,abbas,aitan,aliza,amon,ann,ara,ari,ari,avi,bara,eban,este,eve,israel,lev,levi,liz,liza,rae,sam,sam,uri,yosef,zia'),(22,22,'metula,eli','january,friday,monday','avi,david,eban,eli,este,eve,israel,lem,rae,uri,vered'),(23,23,'ora,elon,eli','dec','eli,enos,eve,israel,rae,raphael,rei,tal'),(24,24,'dor,dan,eli','may','ara,bara,barak,ben,dan,edi,eli,eve,ira,ira,israel,jordan,jordan,ori,rae,rei,tal,vered'),(25,25,'ora,elat,ashdod,gan yavne,dan,yavne,nov','nov,may 20,nov,may 20,may 20,nov,nov,nov,nov,nov,february 20,thursday','ann,dan,este,eve,ham,hana,hanan,israel,jude,lem,ori,rae,sam,sam,uri,vered,zak'),(26,26,'kissufim,adi,eli','','eli,este,eve,ham,israel,nera,ori,rae,rei,sheba,uri'),(27,27,'ora,elat,lod,eli,porat','mar,mar,dec,may,mar,thursday','aliza,ann,anne,ari,ari,avi,david,eli,eva,eve,israel,lem,lev,liz,liza,nava,ori,orit,oz,porat,rae,rei,shai,simi,uri,zion,zion'),(28,28,'ora,elat,dan,tire,nov,adi,eli','november,august,oct,oct,oct,oct,oct,oct,oct,oct,oct,mar,oct,dec,oct','ari,ari,bette,dan,edi,eli,este,eve,idan,liz,nera,ori,orin,peri,tal,uri'),(29,29,'ora,jerusalem,mevo horon,eli','aug,aug','aya,bette,daya,eli,elijah,eve,ham,israel,lem,michal,nehama,nera,oz,rae,shem,shmuel,uri,zac'),(30,30,'dan,tire,adi,ofer,ofra,eli','jun,jun,april,may,april 6,jun,dec','ann,anne,dan,eli,eve,ham,israel,lev,ofra,ori,rae'),(31,31,'ora,dan','dec,sept','ann,anne,aron,dan,este,eve,ham,israel,lem,ori,rae,reuven,sam,sam,sem,sharon,yosef'),(32,32,'ortal,itamar,dan,tene,samar,eli','mar,aug,aug,mar,mar,thursday','amari,amari,amon,ann,anne,ara,ari,ari,aria,avi,dagan,dan,edi,eli,eve,ilan,ira,ira,israel,ori,oz,rachel,rae,sam,sam,tal,tali,tamar,uma,uri,yehuda,yitzhak'),(33,33,'ora,dan,tene,kerem shalom,eli','dec,october 23,thursday','ann,anne,dan,eli,eva,eve,ham,israel,lem,ori,orit,rae,sam,sam,shalom,shalom,uri'),(34,34,'ora,elon,ashdod,dan,tene,kerem shalom,netivot','october 23,thursday','dan,eva,eve,ham,israel,lem,ori,orit,rae,sam,sam,shalom,shalom,uri'),(35,35,'ora,elon,ashdod,dan,tene,kerem shalom,netivot','october 23,thursday','dan,eva,eve,ham,israel,lem,ori,orit,rae,sam,sam,shalom,shalom,uri'),(36,36,'migdal,migdalim,eli','thursday','ara,edi,eli,eva,ham,israel,oz,rae,tal,uri'),(37,37,'dan,tire,migdal,migdalim,samar,eli','mar,mar,mar','amari,amari,ara,ari,ari,aria,dan,dina,edi,eli,eva,israel,jude,lem,oz,rae,riva,sam,sam,tal,uri'),(38,38,'ora,adi,eli,alma,rame','dec,mar,dec,dec','amon,ann,ara,aram,ari,ari,eli,este,eve,gali,galil,israel,nera,nima,nima,rachel,rae,rahel,rena,tal,tali,talia,uri'),(39,39,'ora,adi,eli,alma,rame','dec,mar,dec,dec','amon,ann,ara,aram,ari,ari,eli,este,eve,gali,galil,israel,nera,nima,nima,rachel,rae,rahel,rena,tal,tali,talia,uri'),(40,40,'omen,ora,elon,dan,jerusalem,eli','wednesday','avi,dan,eli,eva,eve,ham,israel,lem,nera,ori,oz,rae,rei,simi,uri,zion,zion'),(41,41,'ohad,ora,dan,adi,eli','','amon,ann,ara,ari,ari,ariel,ariel,aron,avi,aviv,avraham,ben,dan,dani,daniel,david,dina,eban,edi,eitan,eli,eliab,eve,ham,ira,ira,israel,lem,nera,peri,rae,rani,roni,roni,ruth,sharon,tal,uri'),(42,42,'mishmar hanegev','mar,jun,dec,dec,monday','aron,eve,lem,matt,ori,sam,sam,sheba,uri,yaron'),(43,43,'adi','','ann,ara,ari,ari,aria,asa,asa,azaria,eban,eila,eve,ira,ira,israel,nera,rae,rani'),(44,44,'omen,elat,itamar,adi','dec,dec,mar,mar','afra,amon,ann,anne,ara,ari,ari,arye,aya,bina,edi,eva,eve,lev,nera,ori,orit,oz,peri,sam,sam,tal,tali,tamar,uri'),(45,45,'elat','monday','ann,ari,ari,aya,edi,eve,ham,haya,lem,lev,levi,ori,orit,peri,rei,riva,tal,uri'),(46,46,'omen,merav,natur,adi,eli','dec,dec,mar,october 20,friday','ann,ara,ari,ari,ayelet,ben,dina,eli,eliya,eliyahu,eve,lem,liya,michael,michael,michal,nera,oz,sam,sam,tal,tali,tamar,zion,zion'),(47,47,'ashalim,dor,dan,tene,eli,revivim','','ara,aram,ari,ari,avi,aviv,dan,eli,eve,israel,lem,ori,rae,tal,tali,talia'),(48,48,'ora,elon,dor,tire,moran,neta','mar,sunday','aliza,avi,eve,liz,liza'),(49,49,'dan,eli','mar,dec,dec,dec,dec,saturday','dan,eli,eve,ham,israel,matt,ori,orit,rae,tal,tali,talia,zia,zion,zion'),(50,50,'ora,elat,etan,almog,dan,hosen,nov,natur,neta,adi,eli,amir,rame','mar,november 25,aug,mar,oct,dec,mar,dec,aug,dec,mar,aug,may,dec,saturday','afra,amir,amira,amon,ann,anne,ara,ari,ari,aria,asa,asa,asher,azaria,bered,bette,dan,dani,daniel,eban,edi,eli,este,etan,eva,eve,gideon,hana,hanan,hillel,ira,ira,israel,job,lem,lev,levi,liz,matt,nera,nima,nima,ori,orit,oz,peri,rae,rei,rena,roni,roni,sam,sam,saul,sera,tal,tali,uma,uri,vered'),(51,51,'omen,jerusalem,samar,adi','mar,thursday','amari,amari,amon,ari,ari,aria,avi,elza,este,eve,israel,jude,lem,rae,sam,sam,uri,zion,zion'),(52,52,'ora,dan,tene,kerem shalom,eli','sept,october 23,october 30,thursday','ann,dan,eli,este,eva,eve,ham,israel,lem,lev,ori,orit,rae,sam,sam,shalom,shalom,uri'),(53,53,'itamar,dan,eli','mar,thursday','amon,ann,ari,ari,aya,dan,danny,eli,eliab,eva,eve,israel,lem,lev,ori,orit,rae,tamar,uri,vered'),(54,54,'elat,tene,eli','august,jan,july,august,jan,jan','ann,anne,ari,ari,avi,eli,este,eva,eve,israel,lev,levi,ori,orit,peri,rae,rei,tal,uri,zion,zion'),(55,55,'elon,tene,adi,amir,shani','dec','amir,ann,ara,ari,ari,bara,barak,este,eve,hana,lem,shani,yitzhak'),(56,56,'ora,elat,etan,almog,dan,hosen,nov,natur,neta,adi,eli,amir,rame','mar,november 25,aug,mar,oct,dec,mar,dec,aug,dec,mar,aug,may,dec,saturday','afra,amir,amira,amon,ann,anne,ara,ari,ari,aria,asa,asa,asher,azaria,bered,bette,dan,dani,daniel,eban,edi,eli,este,etan,eva,eve,gideon,hana,hanan,hillel,ira,ira,israel,job,lem,lev,levi,liz,matt,nera,nima,nima,ori,orit,oz,peri,rae,rei,rena,roni,roni,sam,sam,saul,sera,tal,tali,uma,uri,vered'),(57,57,'ora,elat,etan,almog,dan,hosen,nov,natur,neta,adi,eli,amir,rame','mar,november 25,aug,mar,oct,dec,mar,dec,aug,dec,mar,aug,may,dec,saturday','afra,amir,amira,amon,ann,anne,ara,ari,ari,aria,asa,asa,asher,azaria,bered,bette,dan,dani,daniel,eban,edi,eli,este,etan,eva,eve,gideon,hana,hanan,hillel,ira,ira,israel,job,lem,lev,levi,liz,matt,nera,nima,nima,ori,orit,oz,peri,rae,rei,rena,roni,roni,sam,sam,saul,sera,tal,tali,uma,uri,vered'),(58,58,'omen,jerusalem,samar,adi','mar,thursday','amari,amari,amon,ari,ari,aria,avi,elza,este,eve,israel,jude,lem,rae,sam,sam,uri,zion,zion'),(59,59,'ora,dan,tene,kerem shalom,eli','sept,october 23,october 30,thursday','ann,dan,eli,este,eva,eve,ham,israel,lem,lev,ori,orit,rae,sam,sam,shalom,shalom,uri'),(60,60,'itamar,dan,eli','mar,thursday','amon,ann,ari,ari,aya,dan,danny,eli,eliab,eva,eve,israel,lem,lev,ori,orit,rae,tamar,uri,vered'),(61,61,'elat,tene,eli','august,jan,july,august,jan,jan','ann,anne,ari,ari,avi,eli,este,eva,eve,israel,lev,levi,ori,orit,peri,rae,rei,tal,uri,zion,zion'),(62,62,'elon,tene,adi,amir,shani','dec','amir,ann,ara,ari,ari,bara,barak,este,eve,hana,lem,shani,yitzhak'),(63,63,'etan,dor,dan,tene,jerusalem,neta,netanya,eli','may,may,dec,thursday','ann,anne,avi,ben,benjamin,dan,edi,eli,etan,eve,ira,ira,israel,james,james,lem,ori,rae,rei,roni,roni,tal,uri'),(64,64,'etan,dor,dan,tene,jerusalem,neta,netanya,eli','may,may,dec,thursday','ann,anne,avi,ben,benjamin,dan,edi,eli,etan,eve,ira,ira,israel,james,james,lem,ori,rae,rei,roni,roni,tal,uri'),(65,65,'ofra','dec','ann,edi,eve,ezra,israel,liz,matt,moshe,ofra,rae,simi,uri'),(66,66,'omen,ora,dan,kerem shalom','','ari,ari,dan,eve,israel,lem,ori,orit,peri,rae,sam,sam,shalom,shalom,tal,uma,uri'),(67,67,'omen,ora,dan,kerem shalom','','ari,ari,dan,eve,israel,lem,ori,orit,peri,rae,sam,sam,shalom,shalom,tal,uma,uri'),(68,68,'jerusalem,mevo horon,magen','13:30,march 20,wednesday','ann,anne,avi,aya,david,daya,dina,eve,hadassah,ham,lem,nechama,nehama,nera,ori,tal,uma,uri,zehava'),(69,69,'ohad,eli','may,march 14,tuesday','eli,este,eve,israel,issac,ori,orit,rae,sam,sam,uri'),(70,70,'adi,eli','','eban,edi,eli,eve,ira,ira,israel,rae,rani,sam,sam'),(71,71,'eli','saturday','eban,edi,eli,ira,ira,israel,lev,levi,rae'),(72,72,'dan,jerusalem','','ara,dan,dani,dania,jordan,jordan,lem,ori,uri'),(73,73,'eli','friday','eli,eve,israel,nera,rae'),(74,74,'etan,dor,neta,netanya','august,tuesday','ann,avi,ben,benjamin,etan,ira,ira,israel,rae,rani,sam,sam,uri'),(75,75,'ora,jerusalem','','edi,este,lem,shlomo,tal,uma'),(76,76,'jerusalem,eli','thursday','ann,edi,eli,israel,lem,rae,tal'),(77,77,'','thursday','ara,eve,uri'),(78,78,'eli','wednesday','eli,eve,israel,liz,rae'),(79,79,'ora,tene','dec,sept,dec,jun','nera,oz'),(80,80,'dor,dan,jerusalem,eli','july,wednesday','ara,dan,dani,dania,eli,israel,jordan,jordan,lem,rae,rei'),(81,81,'hosen,kissufim','thursday','ann,ham'),(82,82,'','thursday',''),(83,83,'','thursday','ann,eve,oz'),(84,84,'etan,neta,netanya,enat','mar,mar,wednesday','ann,anne,ben,benjamin,etan,eva'),(85,85,'','december 10,dec,mar,dec,wednesday','eve,ham,lem,ori,orit,uri,zia');
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

-- Dump completed on 2017-12-02 17:48:58
