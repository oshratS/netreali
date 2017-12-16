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
-- Table structure for table `search_tasks`
--

DROP TABLE IF EXISTS `search_tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `search_tasks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(45) NOT NULL,
  `title` varchar(255) NOT NULL,
  `body` longtext NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='Atricles that the user seeks';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `search_tasks`
--

LOCK TABLES `search_tasks` WRITE;
/*!40000 ALTER TABLE `search_tasks` DISABLE KEYS */;
INSERT INTO `search_tasks` VALUES (1,'30/11/2017 14:46','פצמ\"רים נורו לעבר כוח צה\"ל שעבד על גבול רצועת עזה','תקרית חמורה בדרום: הפלסטינים ירו היום (חמישי) פצצות מרגמה לעבר כוח צה\"ל שביצע עבודות הנדסיות על גבול הרצועה. לא היו נפגעים. צה\"ל השיב אש לעבר עמדות של ארגון חמאס. בעקבות הירי הופסקה תנועת הרכבות בין אשקלון לשדרות. הרכבות מדרום יגיעו עד נתיבות ואילו הרכבות מצפון ייעצרו באשדוד. אוטובוסים יפעלו מתי התחנות לרווחת הנוסעים. מוקדם יותר נשמעה באזור עוטף עזה אזעקת צבע אדום, אבל היא הוגדרה כהתרעת שווא. דובר צה\"ל מסר כי \"לפני זמן קצר תקף צה\"ל באמצעות ירי טנקים וכלי טיס של חיל האוויר ארבע מטרות טרור ברצועת עזה. התקיפה בוצעה בתגובה לירי תלול המסלול שבוצע לעבר מוצב צבאי בצפון רצועת עזה. צה\"ל רואה בארגון הטרור חמאס האחראי למתרחש ברצועת עזה\". כזכור, לפני כחודשיים פוצץ צה\"ל מנהרה של ארגון הג\'יהאד האסלאמי שחדרה לתוך שטח ישראל. בתקרית נהרגו 12 אנשי הארגון, כשגופות של חמישה מהם נמצאות בידי ישראל. לאחר התקרית איים הג\'יהאד האסלאמי לנקום בישראל, ובעקבות זאת נפרסו ברחבי הארץ סוללות כיפת ברזל. לפני כשבועיים הורה צה\"ל לסגור אתרי מטיילים בסמוך לרצועת עזה בעקבות חשש מפיגועי צלפים וירי נ\"ט של ארגון הטרור הסוני. בשבוע שעבר פורסם כי הוגש כתב אישום נגד פעיל חמאס שחצה את הגבול מעזה לישראל. איש, אחמד עביד, בן 23 משכונת סג\'עייה, שבעזה, התגייס לארגון הטרור ב-2013. במסגרת פעילותו בחמאס עבר הכשרה צבאית ונטל חלק באימונים צבאיים בתחומי הנ\"ט, ההנדסה והצליפה. עוד עלה כי לקח חלק בחפירת מנהרות בגזרת מגוריו וכן שימש כפעיל כוח הריסון (אבטחת הגבולות) מטעם חמאס. משב\"כ והמשטרה נמסר כי בחקירתו של עביד התקבל מידע רב אודות פעילות מערך המנהרות של חמאס ברצועת עזה - הן מנהרות המיועדות לפעילות התקפית נגד ישראל, והן מנהרות המיועדות ללחימה מול כוחות צה\"ל בתוך שטח הרצועה. חקירתו של עביד חשפה פעם נוספת את פעילות הטרור של חמאס בתחום המנהרות לקידום פעילות טרור כנגד מדינת ישראל. ב-23 באוקטובר הוגש לבית המשפט המחוזי בבאר שבע כתב אישום חמור המייחס לעביד עבירות ביטחון חמורות. יום קודם לכן פורסם כי רשות המעברים במשרד הביטחון סיכלה הברחה של כמה טונות חומר נפץ שהיו בדרכן לגורמי הטרור בעזה. לאחרונה, בשלב ההרצה של המעבדה, הגיעה למעבר כרם שלום משאית, שהובילה מטען של שמנים לרכב, שעוררה את חשד הבודקים הביטחוניים. דגימות מהשמנים הועברו לבדיקת המעבדה, אשר זיהתה שלא מדובר בשמן מנוע תמים, אלא בחומר מסוכן, המיועד לייצור חומרי נפץ בכמות גדולה מאוד.');
/*!40000 ALTER TABLE `search_tasks` ENABLE KEYS */;
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
