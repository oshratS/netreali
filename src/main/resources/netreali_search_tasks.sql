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
  `body` longtext NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='Atricles that the user seeks';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `search_tasks`
--

LOCK TABLES `search_tasks` WRITE;
/*!40000 ALTER TABLE `search_tasks` DISABLE KEYS */;
INSERT INTO `search_tasks` VALUES (1,' - ומקיים: 285 מיליון דולרים יקוצצו מתקציב האו\\\"ם האיום של נשיא ארה\\\"ב לאור תוצאות ההצבעה נגד ההכרה בירושלים הופך למעשי • השגרירה ניקי היילי: \\\"חוסר היעילות והבזבוז של האו\\\"ם מוכרים היטב. לא נרשה עוד שינצלו את נדיבות העם האמריקני\\\" ך ביום חמישי האחרון, בדיון באו\\\"ם שבסיומו אימצה העצרת הכללית החלטה נגד ההכרה האמריקנית בירושלים כבירת ישראל, איימה שגרירת ארה\\\"ב ניקי היילי כי להצבעה יהיו השלכות כלכליות. שלשום, בצעד שכנראה כבר תוכנן עוד קודם לכן, הוכיחה היילי כי האיום שהשמיעה היה רציני. השגרירה האמריקנית הודיעה ביום ראשון כי ארה\\\"ב נשאה ונתנה עם האו\\\"ם על קיצוץ של 285 מיליון דולר מתקציב הארגון, שאותו הגדירה כ\\\"נפוח\\\". לדבריה, \\\"חוסר היעילות והבזבוז של האו\\\"ם מוכרים היטב. אנחנו לא נרשה עוד שינצלו את הנדיבות של העם האמריקני\\\". השגרירה הוסיפה כי ה\\\"קיצוץ ההיסטורי\\\" הוא צעד בכיוון הנכון והבטיחה כי ארה\\\"ב תנקוט צעדים נוספים כדי לקדם ארגון יעיל ואחראי יותר. \\\"נוסף על החיסכון המשמעותי, הפחתנו במנגנוני הניהול והתמיכה המנופחים של האו\\\"ם, עיגנו את התמיכה בסדרי עדיפויות אמריקניים ברחבי העולם והשתתנו יותר משמעת ואחריות לאורכה ולרוחבה של המערכת\\\", נכתב בהודעה מטעם משלחת ארה\\\"ב לאו\\\"ם. הקיצוץ מתייחס לתקציב האו\\\"ם לשנת 2019-2018, והיילי הביעה תקווה כי תוכל לסייע ליישם קיצוצים נוספים גם בשנים הבאות. הצעד מגיע ימים ספורים אחרי הדיון באו\\\"ם, שעוד לפניו הבטיחה השגרירה האמריקנית כי ארה\\\"ב \\\"תרשום שמות\\\" במהלך ההצבעה - מסר שעליו חזרה גם בנאומה בעצרת. \\\"אנו נזכור את היום הזה שבו הותקפנו בעצרת האו\\\"ם על השימוש בריבונות שלנו\\\", הטיחה היילי מעל בימת האו\\\"ם, \\\"אנו נזכור זאת כשיבקשו מאיתנו לשלם. אנחנו נשים את השגרירות שלנו בירושלים - זה הדבר הנכון לעשות. ההחלטה היום לא תשנה זאת. ההחלטה הזו תשנה את האופן שבו האמריקנים תופסים את האו\\\"ם ואת המדינות שלא מכבדות אותנו באו\\\"ם. נזכור זאת כשיקראו לנו לתרום שוב לאו\\\"ם וכשמדינות יבקשו את הכספים והתמיכה שלנו\\\"');
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

-- Dump completed on 2017-12-27 23:40:18
