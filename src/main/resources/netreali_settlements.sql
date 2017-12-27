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
-- Table structure for table `settlements`
--

DROP TABLE IF EXISTS `settlements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `settlements` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1198 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `settlements`
--

LOCK TABLES `settlements` WRITE;
/*!40000 ALTER TABLE `settlements` DISABLE KEYS */;
INSERT INTO `settlements` VALUES (1,'ABU JUWEI\'ID'),(2,'ABU GHOSH'),(3,'ABU SINAN'),(4,'ABU SUREIHAN'),(5,'ABU ABDUN'),(6,'ABU AMMAR'),(7,'ABU AMRE'),(8,'ABU QUREINAT'),(9,'ABU QUREINAT'),(10,'ABU RUBEI\'A'),(11,'ABU RUQAYYEQ'),(12,'ABU TULUL'),(13,'IBTIN'),(14,'AVTALYON'),(15,'AVI\'EL'),(16,'AVIVIM'),(17,'AVIGEDOR'),(18,'AVIHAYIL'),(19,'AVITAL'),(20,'AVI\'EZER'),(21,'ABBIRIM'),(22,'EVEN YEHUDA'),(23,'EVEN MENAHEM'),(24,'EVEN SAPPIR'),(25,'EVEN SHEMU\'EL'),(26,'AVNE ETAN'),(27,'AVNE HEFEZ'),(28,'AVENAT'),(29,'AVSHALOM'),(30,'ADORA'),(31,'ADDIRIM'),(32,'ADAMIT'),(33,'ADDERET'),(34,'UDIM'),(35,'ODEM'),(36,'OHAD'),(37,'UMM AL-FAHM'),(38,'UMM AL-QUTUF'),(39,'OMEN'),(40,'OMEZ'),(41,'OFAQIM'),(42,'OR HAGANUZ'),(43,'OR HANER'),(44,'OR YEHUDA'),(45,'OR AQIVA'),(46,'ORA'),(47,'OROT'),(48,'ORTAL'),(49,'URIM'),(50,'ORANIM'),(51,'ORANIT'),(52,'USHA'),(53,'AZOR'),(54,'AHAWA'),(55,'AHUZZAM'),(56,'AHIHUD'),(57,'AHITUV'),(58,'AHISAMAKH'),(59,'AHI\'EZER'),(60,'ATRASH'),(61,'IBBIM'),(62,'EYAL'),(63,'AYYELET HASHAHAR'),(64,'ELON'),(65,'ELOT'),(66,'ILANIYYA'),(67,'ELAT'),(68,'IRUS'),(69,'ITAMAR'),(70,'ETAN'),(71,'ETANIM'),(72,'IKSAL'),(73,'AL-ARYAN'),(74,'EL-ROM'),(75,'ALUMMA'),(76,'ALUMMOT'),(77,'ALLON HAGALIL'),(78,'ELON MORE'),(79,'ALLON SHEVUT'),(80,'ALLONE ABBA'),(81,'ALLONE HABASHAN'),(82,'ALLONE YIZHAQ'),(83,'ALLONIM'),(84,'ELI AL'),(85,'ELIAV'),(86,'ELYAKHIN'),(87,'ELIFAZ'),(88,'ELIFELET'),(89,'ELYAQIM'),(90,'ELYASHIV'),(91,'ELISHAMA'),(92,'ALMAGOR'),(93,'ALMOG'),(94,'EL\'AZAR'),(95,'ALFE MENASHE'),(96,'ELQOSH'),(97,'ELQANA'),(98,'EMUNIM'),(99,'AMIRIM'),(100,'AMNUN'),(101,'AMAZYA'),(102,'ANI\'AM'),(103,'ASAD'),(104,'ASEFAR'),(105,'I\'BILLIN'),(106,'A\'SAM'),(107,'AFEINISH'),(108,'AFIQ'),(109,'AFIQIM'),(110,'AFEQ'),(111,'EFRAT'),(112,'ARBEL'),(113,'ARGAMAN'),(114,'EREZ'),(115,'ARI\'EL'),(116,'ARSUF'),(117,'ESHBOL'),(118,'NAHAL ESHBAL'),(119,'ASHDOD'),(120,'ASHDOT YA\'AQOV'),(121,'ESHHAR'),(122,'ESHKOLOT'),(123,'ESHEL HANASI'),(124,'ASHALIM'),(125,'ASHQELON'),(126,'ASHERAT'),(127,'ESHTA\'OL'),(128,'ETGAR'),(129,'BE\'ER ORA'),(130,'BEER GANNIM'),(131,'BE\'ER TUVEYA'),(132,'BE\'ER YA\'AQOV'),(133,'BE\'ER SHEVA'),(134,'BE\'EROT YIZHAQ'),(135,'BE\'EROTAYIM'),(136,'BE\'ERI'),(137,'BUSTAN HAGALIL'),(138,'BU\'EINE-NUJEIDAT'),(139,'BUQ\'ATA'),(140,'BURGETA'),(141,'BAHAN'),(142,'BITHA'),(143,'BIZZARON'),(144,'BIR EL-MAKSUR'),(145,'BIRIYYA'),(146,'BET OREN'),(147,'BET EL'),(148,'BET EL\'AZARI'),(149,'BET ALFA'),(150,'BET ARYE'),(151,'BET BERL'),(152,'BEIT JANN'),(153,'BET GUVRIN'),(154,'BET GAMLI\'EL'),(155,'BET DAGAN'),(156,'BET HAGADDI'),(157,'BET HALEVI'),(158,'BET HILLEL'),(159,'BET HAEMEQ'),(160,'BET HAARAVA'),(161,'BET HASHITTA'),(162,'BET ZEID'),(163,'BET ZAYIT'),(164,'BET ZERA'),(165,'BET HORON'),(166,'BET HERUT'),(167,'BET HILQIYYA'),(168,'BET HANAN'),(169,'BET HANANYA'),(170,'BET HASHMONAY'),(171,'BET YEHOSHUA'),(172,'BET YOSEF'),(173,'BET YANNAY'),(174,'BET YIZHAQ-SH. HEFER'),(175,'BET LEHEM HAGELILIT'),(176,'BET ME\'IR'),(177,'BET NEHEMYA'),(178,'BET NIR'),(179,'BET NEQOFA'),(180,'BET OVED'),(181,'BET UZZI\'EL'),(182,'BET EZRA'),(183,'BET ARIF'),(184,'BET ZEVI'),(185,'BET QAMA'),(186,'BET QESHET'),(187,'BET RABBAN'),(188,'BET RIMMON'),(189,'BET SHE\'AN'),(190,'BET SHEMESH'),(191,'BET SHE\'ARIM'),(192,'BET SHIQMA'),(193,'BITAN AHARON'),(194,'BETAR ILLIT'),(195,'BALFURIYYA'),(196,'BEN ZAKKAY'),(197,'BEN AMMI'),(198,'BEN SHEMEN'),(199,'BENE BERAQ'),(200,'BNE DKALIM'),(201,'BENE DAROM'),(202,'BENE DEROR'),(203,'BENE YEHUDA'),(204,'BENE NEZARIM'),(205,'BENE ATAROT'),(206,'BENE ZIYYON'),(207,'BENE RE\'EM'),(208,'BENAYA'),(209,'BINYAMINA'),(210,'BASMAT TAB\'UN'),(211,'BI NE'),(212,'BAZRA'),(213,'BEZET'),(214,'BEQOA'),(215,'BEQA\'OT'),(216,'BAR GIYYORA'),(217,'BAR YOHAY'),(218,'BRUKHIN'),(219,'BEROR HAYIL'),(220,'BEROSH'),(221,'BERAKHA'),(222,'BEREKHYA'),(223,'BAR\'AM'),(224,'BARAQ'),(225,'BARQAY'),(226,'BARQAN'),(227,'BAREQET'),(228,'BAT HADAR'),(229,'BAT HEN'),(230,'BAT HEFER'),(231,'BAT HAZOR'),(232,'BAT YAM'),(233,'BAT AYIN'),(234,'BAT SHELOMO'),(235,'JUDEIDE-MAKER'),(236,'JULIS'),(237,'JALJULYE'),(238,'JUNNABIB'),(239,'JISR AZ-ZARQA'),(240,'JISH'),(241,'JAAT'),(242,'GE\'ULE TEMAN'),(243,'GE\'ULIM'),(244,'GE\'ALYA'),(245,'GEVULOT'),(246,'GEVIM'),(247,'GEVA'),(248,'GEVA BINYAMIN'),(249,'GEVA KARMEL'),(250,'GIV\'OLIM'),(251,'GIV\'ON HAHADASHA'),(252,'GIV\'AT AVNI'),(253,'GIV\'AT ELA'),(254,'GIV\'AT BRENNER'),(255,'GIV\'AT HASHELOSHA'),(256,'GIV\'AT ZE\'EV'),(257,'GIV\'AT HAYYIM'),(258,'GIV\'AT YO\'AV'),(259,'GIV\'AT YE\'ARIM'),(260,'GIV\'AT YESHA\'YAHU'),(261,'GIV\'AT OZ'),(262,'GIV\'AT SHEMU\'EL'),(263,'GIV\'AT SHEMESH'),(264,'GIV\'AT SHAPPIRA'),(265,'GIV\'ATI'),(266,'GIV\'ATAYIM'),(267,'GEVAR\'AM'),(268,'GEVAT'),(269,'GADOT'),(270,'GADISH'),(271,'GID\'ONA'),(272,'GEDERA'),(273,'GONEN'),(274,'GOREN'),(275,'GORNOT HAGALIL'),(276,'GAZIT'),(277,'GEZER'),(278,'GE\'A'),(279,'GIBBETON'),(280,'GIZO'),(281,'GILON'),(282,'GILAT'),(283,'GINNOSAR'),(284,'GINNEGAR'),(285,'GINNATON'),(286,'GITTA'),(287,'GITTIT'),(288,'GAL\'ON'),(289,'GILGAL'),(290,'GELIL YAM'),(291,'EVEN YIZHAQ'),(292,'GIMZO'),(293,'GAN HADAROM'),(294,'GAN HASHOMERON'),(295,'GAN HAYYIM'),(296,'GAN YOSHIYYA'),(297,'GAN YAVNE'),(298,'GAN NER'),(299,'GAN SOREQ'),(300,'GAN SHELOMO'),(301,'GAN SHEMU\'EL'),(302,'GANNOT'),(303,'GANNOT HADAR'),(304,'GANNE HADAR'),(305,'GANNE YOHANAN'),(306,'GANNE MODIIN'),(307,'GANNE AM'),(308,'GANNE TIQWA'),(309,'GA\'ASH'),(310,'GA\'TON'),(311,'GEFEN'),(312,'GEROFIT'),(313,'GESHUR'),(314,'GESHER'),(315,'GESHER HAZIW'),(316,'GAT'),(317,'GAT RIMMON'),(318,'DALIYAT AL-KARMEL'),(319,'DEVORA'),(320,'DABBURYE'),(321,'DEVIRA'),(322,'DAVERAT'),(323,'DEGANYA ALEF'),(324,'DEGANYA BET'),(325,'DOLEV'),(326,'DOR'),(327,'DOROT'),(328,'DAHI'),(329,'DEIR AL-ASAD'),(330,'DEIR HANNA'),(331,'DEIR RAFAT'),(332,'DIMONA'),(333,'DISHON'),(334,'DALIYYA'),(335,'DALTON'),(336,'DEMEIDE'),(337,'DAN'),(338,'DAFNA'),(339,'DEQEL'),(340,'HAON'),(341,'HABONIM'),(342,'HAGOSHERIM'),(343,'HADAR AM'),(344,'HOD HASHARON'),(345,'HODIYYA'),(346,'HODAYOT'),(347,'HAWASHLA'),(348,'HUZAYYEL'),(349,'HOSHA\'AYA'),(350,'HAZOREA'),(351,'HAZORE\'IM'),(352,'HAHOTERIM'),(353,'HAYOGEV'),(354,'HILLA'),(355,'HAMA\'PIL'),(356,'HASOLELIM'),(357,'HAOGEN'),(358,'HAR ADAR'),(359,'HAR GILLO'),(360,'HAR AMASA'),(361,'HAR\'EL'),(362,'HARDUF'),(363,'HERZELIYYA'),(364,'HARARIT'),(365,'WERED YERIHO'),(366,'WARDON'),(367,'ZABARGA'),(368,'ZAVDI\'EL'),(369,'ZOHAR'),(370,'ZIQIM'),(371,'ZETAN'),(372,'ZIKHRON YA\'AQOV'),(373,'ZEKHARYA'),(374,'ZEMER'),(375,'ZIMRAT'),(376,'ZANOAH'),(377,'ZERU\'A'),(378,'ZARZIR'),(379,'ZERAHYA'),(380,'KHAWALED'),(381,'HAVAZZELET HASHARON'),(382,'HEVER'),(383,'HAGOR'),(384,'HAGGAI'),(385,'HOGLA'),(386,'HAD-NES'),(387,'HADID'),(388,'HADERA'),(389,'HUJEIRAT'),(390,'HULDA'),(391,'HOLON'),(392,'HOLIT'),(393,'HULATA'),(394,'HOSEN'),(395,'HUSSNIYYA'),(396,'HOFIT'),(397,'HUQOQ'),(398,'HURA'),(399,'HURFEISH'),(400,'HORESHIM'),(401,'HAZON'),(402,'HIBBAT ZIYYON'),(403,'HINNANIT'),(404,'HAIFA'),(405,'HERUT'),(406,'HALUZ'),(407,'HALLAMISH'),(408,'HELEZ'),(409,'HAMAM'),(410,'HEMED'),(411,'HAMADYA'),(412,'NAHAL HEMDAT'),(413,'HAMRA'),(414,'HANNI\'EL'),(415,'HANITA'),(416,'HANNATON'),(417,'HASPIN'),(418,'HAFEZ HAYYIM'),(419,'HEFZI-BAH'),(420,'HAZAV'),(421,'HAZEVA'),(422,'HAZOR HAGELILIT'),(423,'HAZOR-ASHDOD'),(424,'HAZAR BE\'EROTAYIM'),(425,'HAZROT HULDA'),(426,'HAZROT YASAF'),(427,'HAZERIM'),(428,'HEREV LE\'ET'),(429,'HARUZIM'),(430,'HARISH'),(431,'HERMESH'),(432,'HARASHIM'),(433,'HASHMONA\'IM'),(434,'TIBERIAS'),(435,'TUBA-ZANGARIYYE'),(436,'TUR\'AN'),(437,'TAYIBE'),(438,'TAYIBE'),(439,'TIRE'),(440,'TIRAT YEHUDA'),(441,'TIRAT KARMEL'),(442,'TIRAT ZEVI'),(443,'TAL SHAHAR'),(444,'TAL-EL'),(445,'TELALIM'),(446,'TALMON'),(447,'TAMRA'),(448,'TENE'),(449,'TEFAHOT'),(450,'YANUH-JAT'),(451,'YEVUL'),(452,'YAVNE\'EL'),(453,'YAVNE'),(454,'YAGUR'),(455,'YAGEL'),(456,'YAD BINYAMIN'),(457,'YAD HASHEMONA'),(458,'YAD HANNA'),(459,'YAD MORDEKHAY'),(460,'YAD NATAN'),(461,'YEDIDA'),(462,'YEHUD-MONOSON'),(463,'YAHEL'),(464,'YUVAL'),(465,'YUVALIM'),(466,'YODEFAT'),(467,'YONATAN'),(468,'YOSHIVYA'),(469,'YIZRE\'EL'),(470,'YEHI\'AM'),(471,'YOTVATA'),(472,'YAKHINI'),(473,'YANUV'),(474,'YINNON'),(475,'YESUD HAMA\'ALA'),(476,'YESODOT'),(477,'YAS\'UR'),(478,'YA\'AD'),(479,'YA\'EL'),(480,'YE\'AF'),(481,'YA\'ARA'),(482,'YAFI'),(483,'YAFIT'),(484,'YIF\'AT'),(485,'YIFTAH'),(486,'YIZHAR'),(487,'YAZIZ'),(488,'YAQUM'),(489,'YAQIR'),(490,'YOQNE\'AM'),(491,'YOQNE\'AM ILLIT'),(492,'YIR\'ON'),(493,'YARDENA'),(494,'YEROHAM'),(495,'JERUSALEM'),(496,'YARHIV'),(497,'YIRKA'),(498,'YARQONA'),(499,'YESHA'),(500,'YISH\'I'),(501,'YASHRESH'),(502,'YATED'),(503,'KABUL'),(504,'KAOKAB ABU AL-HIJA'),(505,'KABRI'),(506,'KADOORIE'),(507,'KOKHAV HASHAHAR'),(508,'KOKHAV YA\'IR'),(509,'KOKHAV YA\'AQOV'),(510,'KOKHAV MIKHA\'EL'),(511,'KORAZIM'),(512,'KAHAL'),(513,'KISSUFIM'),(514,'KISHOR'),(515,'KELIL'),(516,'KALLANIT'),(517,'KEMEHIN'),(518,'KAMMON'),(519,'KANNOT'),(520,'KANAF'),(521,'KINNERET'),(522,'KUSEIFE'),(523,'KESALON'),(524,'KISRA-SUMEI'),(525,'KA\'ABIYYE-TABBASH-HA'),(526,'KEFAR AVIV'),(527,'KEFAR ADUMMIM'),(528,'KEFAR URIYYA'),(529,'KEFAR AHIM'),(530,'KEFAR BIALIK'),(531,'KEFAR BLUM'),(532,'KEFAR BIN NUN'),(533,'KAFAR BARA'),(534,'KEFAR BARUKH'),(535,'KEFAR GID\'ON'),(536,'KEFAR GALLIM'),(537,'KEFAR GLIKSON'),(538,'KEFAR GIL\'ADI'),(539,'KEFAR DANIYYEL'),(540,'KEFAR HAORANIM'),(541,'KEFAR HAHORESH'),(542,'KEFAR HAMAKKABI'),(543,'KEFAR HANAGID'),(544,'KEFAR HANO\'AR HADATI'),(545,'KEFAR HANASI'),(546,'KEFAR HESS'),(547,'KEFAR VITKIN'),(548,'KEFAR WARBURG'),(549,'KEFAR WERADIM'),(550,'KEFAR ZOHARIM'),(551,'KEFAR ZETIM'),(552,'KEFAR HOSHEN'),(553,'KEFAR HITTIM'),(554,'KEFAR HAYYIM'),(555,'KEFAR HANANYA'),(556,'KEFAR HASIDIM ALEF'),(557,'KEFAR HASIDIM BET'),(558,'KEFAR HARUV'),(559,'KEFAR TRUMAN'),(560,'KAFAR YASIF'),(561,'YEDIDYA'),(562,'KEFAR YEHOSHUA'),(563,'KEFAR YONA'),(564,'KEFAR YEHEZQEL'),(565,'KEFAR YA\'BEZ'),(566,'KAFAR KAMA'),(567,'KAFAR KANNA'),(568,'KEFAR MONASH'),(569,'KEFAR MAYMON'),(570,'KAFAR MANDA'),(571,'KEFAR MENAHEM'),(572,'KEFAR MASARYK'),(573,'KAFAR MISR'),(574,'KEFAR MORDEKHAY'),(575,'KEFAR NETTER'),(576,'KEFAR SZOLD'),(577,'KEFAR SAVA'),(578,'KEFAR SILVER'),(579,'KEFAR SIRKIN'),(580,'KEFAR AVODA'),(581,'KEFAR AZZA'),(582,'KEFAR EZYON'),(583,'KEFAR PINES'),(584,'KAFAR QASEM'),(585,'KEFAR KISH'),(586,'KAFAR QARA'),(587,'KEFAR ROSH HANIQRA'),(588,'KEFAR ROZENWALD'),(589,'KEFAR RUPPIN'),(590,'KEFAR RUT'),(591,'KEFAR SHAMMAY'),(592,'KEFAR SHEMU\'EL'),(593,'KEFAR SHEMARYAHU'),(594,'KEFAR TAVOR'),(595,'KEFAR TAPPUAH'),(596,'KARE DESHE'),(597,'KARKOM'),(598,'KEREM BEN ZIMRA'),(599,'KEREM BEN SHEMEN'),(600,'KEREM YAVNE'),(601,'KEREM SHALOM'),(602,'KARME YOSEF'),(603,'KARME ZUR'),(604,'KARME QATIF'),(605,'KARMI\'EL'),(606,'KARMIYYA'),(607,'KERAMIM'),(608,'KARMEL'),(609,'LAVON'),(610,'LAVI'),(611,'LIVNIM'),(612,'LAHAV'),(613,'LAHAVOT HABASHAN'),(614,'LAHAVOT HAVIVA'),(615,'LEHAVIM'),(616,'LOD'),(617,'LUZIT'),(618,'LOHAME HAGETA\'OT'),(619,'LOTEM'),(620,'LOTAN'),(621,'LIMAN'),(622,'LAKHISH'),(623,'LAPPID'),(624,'LAPPIDOT'),(625,'LAQYE'),(626,'MA\'OR'),(627,'ME\'IR SHEFEYA'),(628,'MEVO BETAR'),(629,'MEVO DOTAN'),(630,'MEVO HORON'),(631,'MEVO HAMMA'),(632,'MEVO MODI\'IM'),(633,'MEVO\'OT YAM'),(634,'MABBU\'IM'),(635,'MIVTAHIM'),(636,'MAVQI\'IM'),(637,'MEVASSERET ZIYYON'),(638,'MAJD AL-KURUM'),(639,'MAJDAL SHAMS'),(640,'MUGHAR'),(641,'MEGADIM'),(642,'MIGDAL'),(643,'MIGDAL HAEMEQ'),(644,'MIGDAL OZ'),(645,'MIGDALIM'),(646,'MEGIDDO'),(647,'MAGGAL'),(648,'MAGEN'),(649,'MAGEN SHA\'UL'),(650,'MAGSHIMIM'),(651,'MIDRAKH OZ'),(652,'MIDRESHET BEN GURION'),(653,'MIDRESHET RUPPIN'),(654,'MODI\'IN ILLIT'),(655,'MODI\'IN-MAKKABBIM-RE'),(656,'MOLEDET'),(657,'MOZA ILLIT'),(658,'MUQEIBLE'),(659,'MORAN'),(660,'MORESHET'),(661,'MAZOR'),(662,'MAZKERET BATYA'),(663,'MIZRA'),(664,'MAZRA\'A'),(665,'MEHOLA'),(666,'MAHANE YATTIR'),(667,'MAHANAYIM'),(668,'MAHSEYA'),(669,'METULA'),(670,'MATTA'),(671,'ME AMMI'),(672,'METAV'),(673,'MEISER'),(674,'MEZAR'),(675,'MERAV'),(676,'MERON'),(677,'MESHAR'),(678,'METAR'),(679,'MEKHORA'),(680,'MAKCHUL'),(681,'MIKHMORET'),(682,'MIKHMANNIM'),(683,'MELE\'A'),(684,'MELILOT'),(685,'MALKIYYA'),(686,'MALKISHUA'),(687,'MENUHA'),(688,'MANOF'),(689,'MANOT'),(690,'MENAHEMYA'),(691,'MENNARA'),(692,'MANSHIYYET ZABDA'),(693,'MASSAD'),(694,'MASSADA'),(695,'MESILLOT'),(696,'MESILLAT ZIYYON'),(697,'MASLUL'),(698,'MAS\'ADE'),(699,'MAS\'UDIN AL-\'AZAZME'),(700,'MA\'BAROT'),(701,'MA\'GALIM'),(702,'MA\'AGAN'),(703,'MA\'AGAN MIKHA\'EL'),(704,'MA\'OZ HAYYIM'),(705,'MA\'ON'),(706,'ME\'ONA'),(707,'MI\'ELYA'),(708,'MA\'YAN BARUKH'),(709,'MA\'YAN ZEVI'),(710,'MA\'ALE ADUMMIM'),(711,'MA\'ALE EFRAYIM'),(712,'MA\'ALE GILBOA'),(713,'MA\'ALE GAMLA'),(714,'MA\'ALE HAHAMISHA'),(715,'MA\'ALE LEVONA'),(716,'MA\'ALE MIKHMAS'),(717,'MA\'ALE IRON'),(718,'MA\'ALE AMOS'),(719,'MA\'ALE SHOMERON'),(720,'MA\'ALOT-TARSHIHA'),(721,'MA\'ANIT'),(722,'MA\'AS'),(723,'MEFALLESIM'),(724,'MEZADOT YEHUDA'),(725,'MAZZUVA'),(726,'MAZLIAH'),(727,'MIZPA'),(728,'MIZPE YERIHO'),(729,'MIZPE NETOFA'),(730,'MIZPE RAMON'),(731,'MIZPE SHALEM'),(732,'MEZER'),(733,'MIQWE YISRA\'EL'),(734,'MARGALIYYOT'),(735,'MEROM GOLAN'),(736,'MERHAVYA'),(737,'MERKAZ SHAPPIRA'),(738,'MASH\'ABBE SADE'),(739,'MISGAV DOV'),(740,'MISGAV AM'),(741,'MESHHED'),(742,'MASSU\'A'),(743,'MASSUOT YIZHAQ'),(744,'MASKIYYOT'),(745,'MISHMAR AYYALON'),(746,'MISHMAR DAWID'),(747,'MISHMAR HAYARDEN'),(748,'MISHMAR HANEGEV'),(749,'MISHMAR HAEMEQ'),(750,'MISHMAR HASHIV\'A'),(751,'MISHMAR HASHARON'),(752,'MISHMAROT'),(753,'MISHMERET'),(754,'MASH\'EN'),(755,'MATTAN'),(756,'MATTAT'),(757,'MATTITYAHU'),(758,'NE\'OT GOLAN'),(759,'NE\'OT HAKIKKAR'),(760,'NE\'OT MORDEKHAY'),(761,'SHIZZAFON'),(762,'NA\'URA'),(763,'NEVATIM'),(764,'NEGBA'),(765,'NEHORA'),(766,'NAHALAL'),(767,'NAHARIYYA'),(768,'NOV'),(769,'NOGAH'),(770,'NAVE'),(771,'NEWE AVOT'),(772,'NEWE UR'),(773,'NEWE ILAN'),(774,'NEWE ETAN'),(775,'NEWE DANIYYEL'),(776,'NEWE ZOHAR'),(777,'NEWE HARIF'),(778,'NEWE YAM'),(779,'NEWE YAMIN'),(780,'NEWE YARAQ'),(781,'NEWE MIVTAH'),(782,'NEWE MIKHA\'EL'),(783,'NEWE SHALOM'),(784,'NO\'AM'),(785,'NOFIM'),(786,'NOFIT'),(787,'NOFEKH'),(788,'NOQEDIM'),(789,'NORDIYYA'),(790,'NURIT'),(791,'NEHUSHA'),(792,'NAHAL OZ'),(793,'NAHALA'),(794,'NAHALI\'EL'),(795,'NEHALIM'),(796,'NAHAM'),(797,'NAHEF'),(798,'NAHSHOLIM'),(799,'NAHSHON'),(800,'NAHSHONIM'),(801,'NETU\'A'),(802,'NATUR'),(803,'NETA'),(804,'NETA\'IM'),(805,'NATAF'),(806,'NEIN'),(807,'NIZZAN'),(808,'NIZZAN B'),(809,'NIZZANA'),(810,'NIZZANE SINAY'),(811,'NIZZANE OZ'),(812,'NIZZANIM'),(813,'NIR ELIYYAHU'),(814,'NIR BANIM'),(815,'NIR GALLIM'),(816,'NIR DAWID'),(817,'NIR YAFE'),(818,'NIR YIZHAQ'),(819,'NIR YISRA\'EL'),(820,'NIR MOSHE'),(821,'NIR OZ'),(822,'NIR AM'),(823,'NIR EZYON'),(824,'NIR AQIVA'),(825,'NIR ZEVI'),(826,'NIRIM'),(827,'NIRIT'),(828,'NIRAN'),(829,'NIMROD'),(830,'NES HARIM'),(831,'NES AMMIM'),(832,'NES ZIYYONA'),(833,'NE\'URIM'),(834,'NA\'ALE'),(835,'NA\'AN'),(836,'NASASRA'),(837,'NEZER SERENI'),(838,'NAZARETH'),(839,'NAZERAT ILLIT'),(840,'NESHER'),(841,'NETIV HAGEDUD'),(842,'NETIV HAASARA'),(843,'NETIV HASHAYYARA'),(844,'NETIVOT'),(845,'NETANYA'),(846,'SAJUR'),(847,'SASA'),(848,'SAVYON'),(849,'SEGULA'),(850,'SAWA\'ID'),(851,'SULAM'),(852,'SUSEYA'),(853,'SUFA'),(854,'SAKHNIN'),(855,'SAYYID'),(856,'SALLAMA'),(857,'SAL\'IT'),(858,'SAMAR'),(859,'SA\'AD'),(860,'SA\'AR'),(861,'SAPPIR'),(862,'SITRIYYA'),(863,'GHAJAR'),(864,'AVDON'),(865,'EVRON'),(866,'AGUR'),(867,'ADI'),(868,'ADANIM'),(869,'UZA'),(870,'UZEIR'),(871,'OLESH'),(872,'OMER'),(873,'OFER'),(874,'OFRA'),(875,'OZEM'),(876,'UQBI'),(877,'EZUZ'),(878,'EZER'),(879,'AZRI\'EL'),(880,'AZARYA'),(881,'AZRIQAM'),(882,'ATAWNE'),(883,'ATERET'),(884,'IDDAN'),(885,'EILABUN'),(886,'AYANOT'),(887,'ILUT'),(888,'EN AYYALA'),(889,'EIN AL-ASAD'),(890,'EN GEV'),(891,'EN GEDI'),(892,'EN DOR'),(893,'EN HABESOR'),(894,'EN HOD'),(895,'EN HAHORESH'),(896,'EN HAMIFRAZ'),(897,'EN HAEMEQ'),(898,'EN HASHOFET'),(899,'EN HASHELOSHA'),(900,'EN WERED'),(901,'EN ZIWAN'),(902,'EN HAZEVA'),(903,'EN HAROD'),(904,'EN YAHAV'),(905,'EN YA\'AQOV'),(906,'EN KARMEL'),(907,'EIN MAHEL'),(908,'EIN NAQQUBA'),(909,'EN IRON'),(910,'EN ZURIM'),(911,'EIN QINIYYE'),(912,'EIN RAFA'),(913,'EN SHEMER'),(914,'EN SARID'),(915,'EN TAMAR'),(916,'ENAT'),(917,'IR OVOT'),(918,'AKKO'),(919,'ALUMIM'),(920,'ELI'),(921,'ALE ZAHAV'),(922,'ALMA'),(923,'ALMON'),(924,'AMUQQA'),(925,'AMMINADAV'),(926,'AMMI\'AD'),(927,'AMMI\'OZ'),(928,'AMMIQAM'),(929,'AMIR'),(930,'IMMANU\'EL'),(931,'AMQA'),(932,'ENAV'),(933,'ISIFYA'),(934,'AFULA'),(935,'EZ EFRAYIM'),(936,'ATSMON-SEGEV'),(937,'ARRABE'),(938,'ARAMSHA'),(939,'ARRAB AL NAIM'),(940,'ARAD'),(941,'ARUGOT'),(942,'AR\'ARA'),(943,'AR\'ARA-BANEGEV'),(944,'ASERET'),(945,'ATLIT'),(946,'OTNI\'EL'),(947,'PARAN'),(948,'PEDU\'EL'),(949,'PEDUYIM'),(950,'PEDAYA'),(951,'PORIYYA-KEFAR AVODA'),(952,'PORIYYA-NEWE OVED'),(953,'PORIYYA ILLIT'),(954,'FUREIDIS'),(955,'PORAT'),(956,'PATTISH'),(957,'PELEKH'),(958,'PALMAHIM'),(959,'PENE HEVER'),(960,'PESAGOT'),(961,'FASSUTA'),(962,'PEZA\'EL'),(963,'PEQI\'IN'),(964,'PEQI\'IN HADASHA'),(965,'PARDES HANNA-KARKUR'),(966,'PARDESIYYA'),(967,'PAROD'),(968,'PERAZON'),(969,'PERI GAN'),(970,'PETAH TIQWA'),(971,'PETAHYA'),(972,'ZE\'ELIM'),(973,'ZVIYYA'),(974,'ZIV\'ON'),(975,'ZOVA'),(976,'ZOHAR'),(977,'ZOFIYYA'),(978,'ZUFIN'),(979,'ZOFIT'),(980,'ZOFAR'),(981,'SHOSHANNAT HAAMAQIM'),(982,'MAHANE BILDAD'),(983,'ZUR HADASSA'),(984,'ZUR YIZHAQ'),(985,'ZUR MOSHE'),(986,'ZUR NATAN'),(987,'ZURI\'EL'),(988,'ZURIT'),(989,'ZIPPORI'),(990,'ZELAFON'),(991,'SANDALA'),(992,'ZAFRIYYA'),(993,'ZAFRIRIM'),(994,'ZEFAT'),(995,'ZERUFA'),(996,'ZOR\'A'),(997,'QABBO\'A'),(998,'QEVUZAT YAVNE'),(999,'QEDUMIM'),(1000,'QADIMA-ZORAN'),(1001,'QEDMA'),(1002,'QIDMAT ZEVI'),(1003,'QEDAR'),(1004,'QIDRON'),(1005,'QADDARIM'),(1006,'QUDEIRAT AS-SANI'),(1007,'QAWA\'IN'),(1008,'QOMEMIYYUT'),(1009,'QORANIT'),(1010,'QETURA'),(1011,'QESARIYYA'),(1012,'QELAHIM'),(1013,'QALYA'),(1014,'QALANSAWE'),(1015,'QELA'),(1016,'QAZIR'),(1017,'QAZRIN'),(1018,'QIRYAT ONO'),(1019,'QIRYAT ARBA'),(1020,'QIRYAT ATTA'),(1021,'QIRYAT BIALIK'),(1022,'QIRYAT GAT'),(1023,'QIRYAT TIV\'ON'),(1024,'QIRYAT YAM'),(1025,'QIRYAT YE\'ARIM'),(1026,'QIRYAT MOTZKIN'),(1027,'QIRYAT MAL\'AKHI'),(1028,'QIRYAT NETAFIM'),(1029,'QIRYAT ANAVIM'),(1030,'QIRYAT EQRON'),(1031,'QIRYAT SHELOMO'),(1032,'QIRYAT SHEMONA'),(1033,'QARNE SHOMERON'),(1034,'QESHET'),(1035,'RAME'),(1036,'RAS ALI'),(1037,'ROSH HAAYIN'),(1038,'ROSH PINNA'),(1039,'ROSH ZURIM'),(1040,'RISHON LEZIYYON'),(1041,'REVAVA'),(1042,'REVADIM'),(1043,'REVIVIM'),(1044,'RAVID'),(1045,'REGBA'),(1046,'REGAVIM'),(1047,'RAHAT'),(1048,'REWAHA'),(1049,'REWAYA'),(1050,'RUAH MIDBAR'),(1051,'RUHAMA'),(1052,'RUMMANE'),(1053,'RUMAT HEIB'),(1054,'RO\'I'),(1055,'ROTEM'),(1056,'REHOV'),(1057,'REHOVOT'),(1058,'REHELIM'),(1059,'REIHANIYYE'),(1060,'REHAN'),(1061,'REINE'),(1062,'RIMMONIM'),(1063,'RINNATYA'),(1064,'REKHASIM'),(1065,'RAM-ON'),(1066,'RAMOT'),(1067,'RAMOT HASHAVIM'),(1068,'RAMOT ME\'IR'),(1069,'RAMOT MENASHE'),(1070,'RAMOT NAFTALI'),(1071,'RAMLA'),(1072,'RAMAT GAN'),(1073,'RAMAT DAWID'),(1074,'RAMAT HAKOVESH'),(1075,'RAMAT HASHOFET'),(1076,'RAMAT HASHARON'),(1077,'RAMAT YOHANAN'),(1078,'RAMAT YISHAY'),(1079,'RAMAT MAGSHIMIM'),(1080,'RAMAT ZEVI'),(1081,'RAMAT RAZI\'EL'),(1082,'RAMAT RAHEL'),(1083,'RANNEN'),(1084,'RE\'IM'),(1085,'RA\'ANANA'),(1086,'RAQEFET'),(1087,'RISHPON'),(1088,'RESHAFIM'),(1089,'RETAMIM'),(1090,'SHE\'AR YASHUV'),(1091,'SHAVE ZIYYON'),(1092,'SHAVE SHOMERON'),(1093,'SHIBLI'),(1094,'SEGEV-SHALOM'),(1095,'SEDE ILAN'),(1096,'SEDE ELIYYAHU'),(1097,'SEDE ELI\'EZER'),(1098,'SEDE BOQER'),(1099,'SEDE DAWID'),(1100,'SEDE WARBURG'),(1101,'SEDE YO\'AV'),(1102,'SEDE YA\'AQOV'),(1103,'SEDE YIZHAQ'),(1104,'SEDE MOSHE'),(1105,'SEDE NAHUM'),(1106,'SEDE NEHEMYA'),(1107,'SEDE NIZZAN'),(1108,'SEDE UZZIYYAHU'),(1109,'SEDE ZEVI'),(1110,'SEDOT YAM'),(1111,'SEDOT MIKHA'),(1112,'SEDE AVRAHAM'),(1113,'SEDE HEMED'),(1114,'SEDE TERUMOT'),(1115,'SHEDEMA'),(1116,'SHADMOT DEVORA'),(1117,'SHADMOT MEHOLA'),(1118,'SEDEROT'),(1119,'SHO\'EVA'),(1120,'SHUVA'),(1121,'SHOVAL'),(1122,'SHOHAM'),(1123,'SHOMERA'),(1124,'SHOMERIYYA'),(1125,'SHOQEDA'),(1126,'SHORESH'),(1127,'SHORASHIM'),(1128,'SHOSHANNAT HAAMAQIM'),(1129,'SHEZOR'),(1130,'SHAHAR'),(1131,'SHAHARUT'),(1132,'SHIBBOLIM'),(1133,'NAHAL SHITTIM'),(1134,'SHEIKH DANNUN'),(1135,'SHILO'),(1136,'SHILAT'),(1137,'SHEKHANYA'),(1138,'SHALWA'),(1139,'SHALVA BAMIDBAR'),(1140,'SHELUHOT'),(1141,'SHELOMI'),(1142,'SHAMIR'),(1143,'SHIM\'A'),(1144,'SHAMERAT'),(1145,'SHANI'),(1146,'SENIR'),(1147,'SHA\'AB'),(1148,'SE\'ORIM'),(1149,'SHA\'AL'),(1150,'SHA\'ALVIM'),(1151,'SHA\'AR EFRAYIM'),(1152,'SHA\'AR HAGOLAN'),(1153,'SHA\'AR HAAMAQIM'),(1154,'SHA\'AR MENASHE'),(1155,'SHA\'ARE TIQWA'),(1156,'SHEFAYIM'),(1157,'SHAFIR'),(1158,'SHEFER'),(1159,'SHEFAR\'AM'),(1160,'SHAQED'),(1161,'SHEQEF'),(1162,'SHARONA'),(1163,'LI-ON'),(1164,'SARID'),(1165,'SHARSHERET'),(1166,'SHETULA'),(1167,'SHETULIM'),(1168,'TE\'ASHUR'),(1169,'TIDHAR'),(1170,'TUVAL'),(1171,'TOMER'),(1172,'TUSHIYYA'),(1173,'TIMMORIM'),(1174,'TIROSH'),(1175,'TEL AVIV - YAFO'),(1176,'TEL YOSEF'),(1177,'TEL YIZHAQ'),(1178,'TEL MOND'),(1179,'TEL ADASHIM'),(1180,'TEL QAZIR'),(1181,'TEL SHEVA'),(1182,'TEL TE\'OMIM'),(1183,'TELEM'),(1184,'TALME ELIYYAHU'),(1185,'TALME EL\'AZAR'),(1186,'TALME YOSEF'),(1187,'TALME YEHI\'EL'),(1188,'TALME YAFE'),(1189,'TELAMIM'),(1190,'TIMRAT'),(1191,'TENUVOT'),(1192,'TA\'OZ'),(1193,'TIFRAH'),(1194,'TEQUMA'),(1195,'TEQOA'),(1196,'TARABIN AS-SANI'),(1197,'TARUM');
/*!40000 ALTER TABLE `settlements` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-27 23:40:18
