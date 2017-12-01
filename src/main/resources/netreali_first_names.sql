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
-- Table structure for table `first_names`
--

DROP TABLE IF EXISTS `first_names`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `first_names` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=837 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `first_names`
--

LOCK TABLES `first_names` WRITE;
/*!40000 ALTER TABLE `first_names` DISABLE KEYS */;
INSERT INTO `first_names` VALUES (1,'aaron'),(2,'abba'),(3,'abbas'),(4,'abbigail'),(5,'abbott'),(6,'abby'),(7,'abdiel'),(8,'abel'),(9,'abelia'),(10,'abiah'),(11,'abiel'),(12,'abiela'),(13,'abigail'),(14,'abijah'),(15,'abijah'),(16,'abimael'),(17,'abir'),(18,'abital'),(19,'abner'),(20,'abra'),(21,'abraham'),(22,'abram'),(23,'abriana'),(24,'absalom'),(25,'abush'),(26,'adah'),(27,'adaiah'),(28,'adalia'),(29,'adalyn'),(30,'adam'),(31,'adamina'),(32,'adara'),(33,'addar'),(34,'adina'),(35,'adine'),(36,'adira'),(37,'adlai'),(38,'adonijah'),(39,'adriel'),(40,'afra'),(41,'ahab'),(42,'aharon'),(43,'aitan'),(44,'akiva'),(45,'akiva'),(46,'aleeza'),(47,'alef'),(48,'aleph'),(49,'alijah'),(50,'alisa'),(51,'aliza'),(52,'alva'),(53,'amael'),(54,'amahl'),(55,'amalia'),(56,'amari'),(57,'amari'),(58,'amariah'),(59,'amarli'),(60,'amiel'),(61,'amir'),(62,'amira'),(63,'amit'),(64,'amon'),(65,'amos'),(66,'amzi'),(67,'anaïs'),(68,'ann'),(69,'anna'),(70,'anne'),(71,'aphra'),(72,'ara'),(73,'aram'),(74,'arava'),(75,'arda'),(76,'ardith'),(77,'arela'),(78,'arella'),(79,'ari'),(80,'ari'),(81,'aria'),(82,'ariel'),(83,'ariel'),(84,'ariza'),(85,'aron'),(86,'arye'),(87,'arza'),(88,'asa'),(89,'asa'),(90,'asahel'),(91,'asaiah'),(92,'asher'),(93,'ashira'),(94,'astera'),(95,'atalia'),(96,'atara'),(97,'athalia'),(98,'avdel'),(99,'avi'),(100,'aviv'),(101,'aviva'),(102,'avraham'),(103,'avri'),(104,'avrom'),(105,'avron'),(106,'avrum'),(107,'avshalom'),(108,'aya'),(109,'ayelet'),(110,'ayla'),(111,'azaiah'),(112,'azaria'),(113,'azariah'),(114,'azariah'),(115,'azarias'),(116,'aziel'),(117,'aziza'),(118,'azrael'),(119,'azriel'),(120,'bara'),(121,'barack'),(122,'barak'),(123,'bart'),(124,'bartholomew'),(125,'bartlett'),(126,'baruch'),(127,'bathsheba'),(128,'batya'),(129,'belshazzar'),(130,'ben'),(131,'benaiah'),(132,'benajah'),(133,'benjamin'),(134,'benjamina'),(135,'benoni'),(136,'benyamin'),(137,'berakhiah'),(138,'bered'),(139,'beriah'),(140,'bessie'),(141,'bethany'),(142,'bethea'),(143,'bethel'),(144,'bethenny'),(145,'bethesda'),(146,'bethia'),(147,'betsy'),(148,'betta'),(149,'bette'),(150,'betty'),(151,'beulah'),(152,'bezai'),(153,'bige'),(154,'bina'),(155,'bitsy'),(156,'bizzy'),(157,'bluma'),(158,'boaz'),(159,'bram'),(160,'briella'),(161,'busy'),(162,'cager'),(163,'cain'),(164,'calah'),(165,'caleb'),(166,'carmel'),(167,'carmelita'),(168,'carmelo'),(169,'castiel'),(170,'chaim'),(171,'chaka'),(172,'chalil'),(173,'chanah'),(174,'chaniel'),(175,'chasin'),(176,'chava'),(177,'chaviv'),(178,'chaya'),(179,'chazaiah'),(180,'chazon'),(181,'cherith'),(182,'cohen'),(183,'dagan'),(184,'dalfon'),(185,'dalia'),(186,'dan'),(187,'dani'),(188,'dania'),(189,'daniel'),(190,'danielle'),(191,'danit'),(192,'danny'),(193,'danya'),(194,'dara'),(195,'dathan'),(196,'datyah'),(197,'dave'),(198,'david'),(199,'davida'),(200,'davina'),(201,'davis'),(202,'daya'),(203,'deborah'),(204,'debra'),(205,'debs'),(206,'delilah'),(207,'dina'),(208,'dinah'),(209,'dorit'),(210,'doron'),(211,'dov'),(212,'dovev'),(213,'doveva'),(214,'eban'),(215,'eben'),(216,'ebenezer'),(217,'eden'),(218,'edi'),(219,'edna'),(220,'efron'),(221,'eila'),(222,'eilam'),(223,'eilon'),(224,'eitan'),(225,'elan'),(226,'elazer'),(227,'eleazar'),(228,'eleazer'),(229,'eli'),(230,'eliab'),(231,'eliakim'),(232,'eliam'),(233,'eliana'),(234,'eliane'),(235,'eliaz'),(236,'eliezer'),(237,'elihu'),(238,'elijah'),(239,'eliora'),(240,'eliphalet'),(241,'elisabeth'),(242,'elisha'),(243,'elisha'),(244,'elisheva'),(245,'eliska'),(246,'elissa'),(247,'eliya'),(248,'eliyahu'),(249,'eliza'),(250,'elizabeth'),(251,'elliana'),(252,'elul'),(253,'elula'),(254,'elyse'),(255,'elza'),(256,'emmanuel'),(257,'emmet'),(258,'emmet'),(259,'emmett'),(260,'enoch'),(261,'enos'),(262,'ephai'),(263,'ephraim'),(264,'ephram'),(265,'erela'),(266,'erelah'),(267,'erga'),(268,'erlinda'),(269,'esau'),(270,'este'),(271,'etan'),(272,'etana'),(273,'ethan'),(274,'eva'),(275,'eve'),(276,'evie'),(277,'ezekiel'),(278,'ezra'),(279,'ezri'),(280,'feya'),(281,'gabi'),(282,'gabriel'),(283,'gadiel'),(284,'gahan'),(285,'gail'),(286,'gali'),(287,'galil'),(288,'galila'),(289,'gallio'),(290,'galya'),(291,'ganya'),(292,'gavi'),(293,'gavriel'),(294,'gavriela'),(295,'gavriella'),(296,'gavrielle'),(297,'gavrilla'),(298,'gedaliah'),(299,'geela'),(300,'gershom'),(301,'gideon'),(302,'gidon'),(303,'gil'),(304,'gila'),(305,'gilead'),(306,'gili'),(307,'goliath'),(308,'gomer'),(309,'goren'),(310,'guri'),(311,'guryon'),(312,'habakkuk'),(313,'hadar'),(314,'hadar'),(315,'hadassah'),(316,'hadriel'),(317,'hagar'),(318,'ham'),(319,'hana'),(320,'hanan'),(321,'hanna'),(322,'hannah'),(323,'hanoch'),(324,'harrell'),(325,'havilah'),(326,'haviva'),(327,'haya'),(328,'hazael'),(329,'hazaiah'),(330,'heber'),(331,'hephzibah'),(332,'hepzibah'),(333,'hershel'),(334,'hezekiah'),(335,'hillel'),(336,'hiram'),(337,'hosanna'),(338,'hosea'),(339,'hulda'),(340,'ichabod'),(341,'idan'),(342,'ido'),(343,'ilan'),(344,'ilana'),(345,'ilisha'),(346,'ira'),(347,'ira'),(348,'isaac'),(349,'isabella'),(350,'isaiah'),(351,'isaias'),(352,'ishmael'),(353,'isibeal'),(354,'israel'),(355,'issac'),(356,'ivria'),(357,'izaiah'),(358,'jabin'),(359,'jace'),(360,'jachin'),(361,'jacob'),(362,'jacoba'),(363,'jacobina'),(364,'jacoby'),(365,'jaden'),(366,'jaden'),(367,'jadon'),(368,'jadon'),(369,'jael'),(370,'jael'),(371,'jaffa'),(372,'jaiden'),(373,'jair'),(374,'jake'),(375,'jaliyah'),(376,'james'),(377,'james'),(378,'jamie'),(379,'jamie'),(380,'japheth'),(381,'japhy'),(382,'jarah'),(383,'jarden'),(384,'jardena'),(385,'jareb'),(386,'jared'),(387,'jaron'),(388,'jasiel'),(389,'javan'),(390,'javon'),(391,'jaydon'),(392,'jeb'),(393,'jebediah'),(394,'jedaiah'),(395,'jedidiah'),(396,'jehu'),(397,'jemima'),(398,'jemuel'),(399,'jeremiah'),(400,'jerusha'),(401,'jessa'),(402,'jesse'),(403,'jesse'),(404,'jessica'),(405,'jessie'),(406,'jessie'),(407,'jesus'),(408,'jethra'),(409,'jethro'),(410,'jezebel'),(411,'joab'),(412,'joachim'),(413,'joah'),(414,'job'),(415,'jobina'),(416,'joby'),(417,'jody'),(418,'joe'),(419,'joel'),(420,'joella'),(421,'johanna'),(422,'john'),(423,'jola'),(424,'jon'),(425,'jonah'),(426,'jonathan'),(427,'jonathon'),(428,'jora'),(429,'jorah'),(430,'jordan'),(431,'jordan'),(432,'jordana'),(433,'jordyn'),(434,'joseph'),(435,'josepha'),(436,'joshua'),(437,'josiah'),(438,'jotham'),(439,'jothan'),(440,'joëlle'),(441,'jubilee'),(442,'judah'),(443,'jude'),(444,'judith'),(445,'kaleb'),(446,'kaniel'),(447,'kayla'),(448,'kaylie'),(449,'kelila'),(450,'kelilah'),(451,'kemuel'),(452,'keren'),(453,'keryn'),(454,'keturah'),(455,'kezia'),(456,'keziah'),(457,'kiah'),(458,'kiriah'),(459,'koren'),(460,'laban'),(461,'lael'),(462,'lazer'),(463,'leah'),(464,'leeza'),(465,'lem'),(466,'lemuel'),(467,'leora'),(468,'lesia'),(469,'lev'),(470,'levi'),(471,'libi'),(472,'lilah'),(473,'lior'),(474,'lior'),(475,'lisa'),(476,'livana'),(477,'liya'),(478,'liz'),(479,'liza'),(480,'lizzie'),(481,'machi'),(482,'mahala'),(483,'mahlon'),(484,'makayla'),(485,'malachi'),(486,'malaki'),(487,'malka'),(488,'maoz'),(489,'mara'),(490,'margalit'),(491,'mariah'),(492,'marie'),(493,'marnie'),(494,'maro'),(495,'mary'),(496,'matt'),(497,'matthew'),(498,'mattie'),(499,'maven'),(500,'maya'),(501,'mayer'),(502,'mehira'),(503,'mehitabel'),(504,'meir'),(505,'menachem'),(506,'menashe'),(507,'meribah'),(508,'meshach'),(509,'meyer'),(510,'micah'),(511,'micah'),(512,'micaiah'),(513,'micajah'),(514,'michael'),(515,'michael'),(516,'michaiah'),(517,'michal'),(518,'midian'),(519,'miriam'),(520,'misael'),(521,'molly'),(522,'mordecai'),(523,'moriah'),(524,'moselle'),(525,'moshe'),(526,'naamah'),(527,'naaman'),(528,'naarah'),(529,'naava'),(530,'nachum'),(531,'nagida'),(532,'nahir'),(533,'namir'),(534,'nancy'),(535,'naomi'),(536,'naor'),(537,'naphtali'),(538,'nasia'),(539,'natania'),(540,'nathan'),(541,'nathaniel'),(542,'nava'),(543,'navi'),(544,'nazareth'),(545,'nechama'),(546,'nehama'),(547,'nehemiah'),(548,'neila'),(549,'neima'),(550,'nera'),(551,'neri'),(552,'neriah'),(553,'neriah'),(554,'neviah'),(555,'nima'),(556,'nima'),(557,'nimrod'),(558,'nir'),(559,'nira'),(560,'niria'),(561,'nissa'),(562,'nissan'),(563,'niva'),(564,'nizana'),(565,'noa'),(566,'noah'),(567,'noah'),(568,'noam'),(569,'noaz'),(570,'nomi'),(571,'nuria'),(572,'nuriel'),(573,'nyomi'),(574,'obadiah'),(575,'odeda'),(576,'odelia'),(577,'ofira'),(578,'ofra'),(579,'omer'),(580,'omri'),(581,'oprah'),(582,'oren'),(583,'orev'),(584,'ori'),(585,'orin'),(586,'orit'),(587,'orli'),(588,'orpah'),(589,'othello'),(590,'othniel'),(591,'oz'),(592,'ozara'),(593,'ozni'),(594,'pagiel'),(595,'palti'),(596,'panna'),(597,'paz'),(598,'paz'),(599,'pazel'),(600,'paziah'),(601,'pella'),(602,'peniel'),(603,'penina'),(604,'peretz'),(605,'peri'),(606,'pesah'),(607,'phineas'),(608,'phinnaeus'),(609,'pinchas'),(610,'porat'),(611,'poriel'),(612,'raanan'),(613,'raanana'),(614,'rachael'),(615,'racham'),(616,'rachel'),(617,'rae'),(618,'rafaela'),(619,'raffaela'),(620,'raffaella'),(621,'rafia'),(622,'rafya'),(623,'rahel'),(624,'raia'),(625,'rani'),(626,'ranita'),(627,'raphael'),(628,'raphaela'),(629,'raphia'),(630,'raya'),(631,'rayna'),(632,'reba'),(633,'rebecca'),(634,'rebekka'),(635,'rei'),(636,'rena'),(637,'reuben'),(638,'reuelle'),(639,'reuven'),(640,'riah'),(641,'rimona'),(642,'rishona'),(643,'riva'),(644,'rivka'),(645,'roni'),(646,'roni'),(647,'ronia'),(648,'ronja'),(649,'rosh'),(650,'ruth'),(651,'saar'),(652,'sabra'),(653,'sada'),(654,'sadie'),(655,'salome'),(656,'sam'),(657,'sam'),(658,'samala'),(659,'samantha'),(660,'samara'),(661,'sameh'),(662,'sami'),(663,'sampson'),(664,'samson'),(665,'samuel'),(666,'sapphire'),(667,'sara'),(668,'sarah'),(669,'sarai'),(670,'saralee'),(671,'sariah'),(672,'saul'),(673,'sela'),(674,'selah'),(675,'selima'),(676,'sem'),(677,'sera'),(678,'seraphim'),(679,'seraphina'),(680,'seraphine'),(681,'seth'),(682,'seth'),(683,'sethe'),(684,'shai'),(685,'shaina'),(686,'shalailah'),(687,'shalom'),(688,'shalom'),(689,'shamira'),(690,'shani'),(691,'sharai'),(692,'sharon'),(693,'shauna'),(694,'shaviv'),(695,'shay'),(696,'shay'),(697,'sheba'),(698,'shem'),(699,'shiloh'),(700,'shiloh'),(701,'shimon'),(702,'shira'),(703,'shiron'),(704,'shlomo'),(705,'shmuel'),(706,'shoshana'),(707,'shoshanna'),(708,'shoushan'),(709,'shula'),(710,'shulamit'),(711,'simcha'),(712,'simeon'),(713,'simi'),(714,'simm'),(715,'simon'),(716,'siomon'),(717,'solomon'),(718,'susan'),(719,'susanna'),(720,'susannah'),(721,'tal'),(722,'tali'),(723,'talia'),(724,'talila'),(725,'tallie'),(726,'talma'),(727,'tamah'),(728,'tamar'),(729,'tamara'),(730,'tamir'),(731,'tavora'),(732,'tehila'),(733,'temani'),(734,'terach'),(735,'tevye'),(736,'thirza'),(737,'tibbie'),(738,'tikvah'),(739,'tira'),(740,'tiras'),(741,'tirzah'),(742,'tivona'),(743,'tobiah'),(744,'tobias'),(745,'tova'),(746,'tovi'),(747,'tubia'),(748,'tuvia'),(749,'tziamarnit'),(750,'tzipora'),(751,'tziporah'),(752,'tzofia'),(753,'tzophiah'),(754,'tzvi'),(755,'uma'),(756,'uri'),(757,'uriah'),(758,'uriel'),(759,'uriela'),(760,'uzi'),(761,'uziah'),(762,'uzziah'),(763,'varda'),(764,'vered'),(765,'yaakov'),(766,'yada'),(767,'yadira'),(768,'yael'),(769,'yael'),(770,'yaffa'),(771,'yahir'),(772,'yakim'),(773,'yanis'),(774,'yarden'),(775,'yaron'),(776,'yasiel'),(777,'yehuda'),(778,'yehudah'),(779,'yehudit'),(780,'yeshaya'),(781,'yisrael'),(782,'yitzhak'),(783,'yochanna'),(784,'yoel'),(785,'yona'),(786,'yonah'),(787,'yonina'),(788,'yosef'),(789,'zac'),(790,'zachariah'),(791,'zachary'),(792,'zadie'),(793,'zadock'),(794,'zahara'),(795,'zahava'),(796,'zahavi'),(797,'zak'),(798,'zakk'),(799,'zamir'),(800,'zara'),(801,'zared'),(802,'zariah'),(803,'zariza'),(804,'zaza'),(805,'zebadiah'),(806,'zebediah'),(807,'zebulon'),(808,'zechariah'),(809,'zedekiah'),(810,'zehava'),(811,'zeke'),(812,'zelia'),(813,'zemora'),(814,'zephaniah'),(815,'zera'),(816,'zerah'),(817,'zetta'),(818,'zev'),(819,'zevi'),(820,'zeév'),(821,'zia'),(822,'zibby'),(823,'zilla'),(824,'zimran'),(825,'zimri'),(826,'zion'),(827,'zion'),(828,'zippora'),(829,'zipporah'),(830,'ziv'),(831,'ziva'),(832,'ziza'),(833,'zohar'),(834,'zohara'),(835,'zubin'),(836,'zvi');
/*!40000 ALTER TABLE `first_names` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-01 18:17:30
