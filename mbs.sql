-- MySQL dump 10.13  Distrib 5.5.36, for Win32 (x86)
--
-- Host: localhost    Database: mbs
-- ------------------------------------------------------
-- Server version	5.5.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES gbk */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bgimage`
--

DROP TABLE IF EXISTS `bgimage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bgimage` (
  `userId` int(255) DEFAULT NULL,
  `userNickName` varchar(255) DEFAULT NULL,
  `imagePath` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bgimage`
--

LOCK TABLES `bgimage` WRITE;
/*!40000 ALTER TABLE `bgimage` DISABLE KEYS */;
INSERT INTO `bgimage` VALUES (3,'÷©÷Îœ¿','images/3a9de451-bd32-4c7d-a617-f34fe0d4d833.jpg'),(7,'¡Ù—‘∞Âπ‹¿Ì‘±','images/2e003231-83c8-4efe-8c4f-baa4d6fa955e.htm');
/*!40000 ALTER TABLE `bgimage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blacklist`
--

DROP TABLE IF EXISTS `blacklist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blacklist` (
  `userId` int(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blacklist`
--

LOCK TABLES `blacklist` WRITE;
/*!40000 ALTER TABLE `blacklist` DISABLE KEYS */;
/*!40000 ALTER TABLE `blacklist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `code`
--

DROP TABLE IF EXISTS `code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `code` (
  `codeId` int(255) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`codeId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `code`
--

LOCK TABLES `code` WRITE;
/*!40000 ALTER TABLE `code` DISABLE KEYS */;
INSERT INTO `code` VALUES (1,'adaaaa'),(2,'sadasdf'),(3,'Gc1MFG'),(4,'EIQXYT'),(5,'qQyCxU'),(6,'i3HtXV'),(7,'SM4WG8'),(8,'z1dCb4');
/*!40000 ALTER TABLE `code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comments` (
  `commentId` int(255) NOT NULL AUTO_INCREMENT,
  `messageId` int(255) DEFAULT NULL,
  `commentUserId` int(255) DEFAULT NULL,
  `commentContent` varchar(255) DEFAULT NULL,
  `commentLevel` int(20) DEFAULT NULL,
  `commentTime` varchar(255) DEFAULT NULL,
  `masterUrl` varchar(255) DEFAULT NULL,
  `mainComments` int(255) DEFAULT NULL,
  `userNickName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`commentId`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,3,101,'µ⁄“ª¥Œ∆¿¬€',1,'2023-04-02','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'÷©÷Îœ¿'),(2,3,101,'Œ“ «∂˛º∂∆¿¬€£¨¬•÷–¬•',2,'2023-04-02','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',1,'÷©÷Îœ¿'),(3,3,101,'µ⁄∂˛¥Œ∆¿¬€',1,'2023-04-02','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'÷©÷Îœ¿'),(4,3,101,'Œ“ «∂˛º∂∆¿¬€£¨¬•÷–¬•',2,'2023-04-02','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',1,'÷©÷Îœ¿'),(5,3,3,'π˛π˛π˛',1,'2023-04-05 15:25:46','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'÷©÷Îœ¿'),(6,4,3,'Œ“µƒ÷©÷ÎÀøøÏ“™∂¬≤ª◊°¡À......',1,'2023-04-05 15:26:38','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'÷©÷Îœ¿'),(9,3,3,'π˛π˛π˛',2,'2023-04-05 20:48:51','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',3,'÷©÷Îœ¿'),(11,4,3,'Ω®“ÈÃ¯¬•',2,'2023-04-05 21:17:12','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',6,'÷©÷Îœ¿'),(12,4,3,'Œﬂ∫˛',1,'2023-04-05 21:17:26','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'÷©÷Îœ¿'),(14,3,3,'aaa',1,'2023-04-06 09:24:42','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'÷©÷Îœ¿'),(15,3,3,'bbb',1,'2023-04-06 09:27:39','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'÷©÷Îœ¿'),(16,3,3,'ccc',1,'2023-04-06 09:29:53','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'÷©÷Îœ¿'),(17,4,3,'aaa',1,'2023-04-06 09:31:29','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'÷©÷Îœ¿'),(18,3,3,'ccc',1,'2023-04-06 09:33:30','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'÷©÷Îœ¿'),(19,3,3,'ddd',1,'2023-04-06 09:34:02','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'÷©÷Îœ¿'),(20,3,3,'eee',1,'2023-04-06 09:34:33','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'÷©÷Îœ¿'),(21,3,3,'bbb',2,'2023-04-06 09:34:51','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',15,'÷©÷Îœ¿'),(22,4,3,'¿¥≤ªº∞¡À',2,'2023-04-06 14:13:11','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',6,'÷©÷Îœ¿'),(25,4,3,'wu',2,'2023-04-08 19:07:48','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',12,'÷©÷Îœ¿'),(26,3,3,'ccc',2,'2023-04-08 19:29:02','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',16,'÷©÷Îœ¿'),(27,8,7,'Œﬂ∫˛',1,'2023-04-12 15:06:49','images/39fc162d-f0a0-4406-baf6-1c062352dafa.jpg',NULL,'¡Ù—‘∞Âπ‹¿Ì‘±'),(28,8,3,'aaaa',1,'2023-04-14 08:36:22','images/f4cd5ce5-3aa4-409d-9f48-f3f9726e75d0.jpg',NULL,'÷©÷Îœ¿');
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `deptId` int(20) NOT NULL AUTO_INCREMENT,
  `deptName` varchar(20) NOT NULL,
  `deptSize` int(20) DEFAULT NULL,
  `deptLeader` varchar(20) DEFAULT NULL,
  `deptImagePath` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`deptId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'π‹¿Ì≤ø',3,'Œﬁ','Œﬁ'),(2,'‘À”™≤ø',0,'Œﬁ','Œﬁ'),(3,'≤∆ŒÒ≤ø',0,'Œﬁ','Œﬁ'),(4,'ºº ı≤ø',1,'Œﬁ','Œﬁ');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `masterId` int(255) NOT NULL,
  `topic` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `likes` int(255) DEFAULT '0',
  `typeId` int(255) DEFAULT NULL,
  `comments` int(255) DEFAULT '0',
  `imagePath` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `userNickName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (3,3,'11¬•µƒ≤ﬁÀ˘∂¬¡À∫‹æ√¡ÀŒ“∏–æı.......','11¬•µƒ≤ﬁÀ˘∂¬¡À∫‹æ√¡ÀŒ“∏–æı“™≈Á∑¢¡À',7,3,0,'Œﬁ','2023-04-03 19:44:28','÷©÷Îœ¿'),(4,5,'√ª ±º‰Ω‚ Õ¡À°£°£°£°£°£','»´ÃÂ‘±π§∏œΩÙ¿Îø™∞Ïπ´¥Û¬•',5,1,0,'Œﬁ','2023-04-03 20:06:55','∞Æ“ÚÀπÃπ'),(6,7,'test','test',1,3,0,'Œﬁ','2023-04-07 20:07:53','¡Ù—‘∞Âπ‹¿Ì‘±'),(7,7,'’‚ «“ª∏ˆÕ®÷™','’‚ «“ª∏ˆÕ®÷™',1,2,0,'Œﬁ','2023-04-12 14:48:26','¡Ù—‘∞Âπ‹¿Ì‘±'),(8,7,'¡Ï≤ﬁ÷Ω','«ÎÀ˘”–»ÀµΩ“ª¬•¡Ï»°≤ﬁ÷Ω£°',3,4,0,'Œﬁ','2023-04-12 14:49:27','¡Ù—‘∞Âπ‹¿Ì‘±');
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topmessage`
--

DROP TABLE IF EXISTS `topmessage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `topmessage` (
  `messageId` int(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topmessage`
--

LOCK TABLES `topmessage` WRITE;
/*!40000 ALTER TABLE `topmessage` DISABLE KEYS */;
/*!40000 ALTER TABLE `topmessage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type` (
  `typeId` int(255) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(255) NOT NULL,
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` VALUES (1,'π´ŒÒ'),(2,'Õ®÷™'),(3,'∆‰À¸'),(4,'…˙ªÓ');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'Èê¢„Ñ¶Âüõid',
  `account` varchar(255) DEFAULT NULL COMMENT 'Èê¢„Ñ¶ÂüõÁíêÔπÄÂΩø',
  `password` varchar(255) DEFAULT NULL COMMENT 'Èê¢„Ñ¶ÂüõÁÄµÂóôÁàú',
  `nickname` varchar(255) DEFAULT NULL COMMENT 'Èê¢„Ñ¶ÂüõÈèÑÁîµ–û',
  `role` varchar(255) DEFAULT NULL COMMENT 'Èê¢„Ñ¶ÂüõÁëôÊéïÂ£ä',
  `deptId` int(20) DEFAULT NULL COMMENT 'Èê¢„Ñ¶ÂüõÈñÆ„Ñ©Ê£¨id',
  `email` varchar(255) DEFAULT NULL COMMENT 'Èê¢„Ñ¶ÂüõÈñ≠??',
  `avatarUrl` varchar(255) DEFAULT NULL COMMENT 'Èê¢„Ñ¶ÂüõÊæ∂ÊùëÂÑöÈç•ÂâßÂ¢ñÁí∫?Á∑û',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (3,'101','123456','÷©÷Îœ¿',NULL,4,'3112520587@qq.com','images/f4cd5ce5-3aa4-409d-9f48-f3f9726e75d0.jpg'),(5,'103','123456','∞Æ“ÚÀπÃπ',NULL,1,'aiyinstan@qq.com','images/fcc2bf1d-dacd-46ca-a60c-3978a61867f5.jpg'),(6,'test','123456','≤‚ ‘»À‘±',NULL,1,'aa@qq.com','images/893cc0ef-24ef-4da2-94ad-15de22a1c4cd.jpg'),(7,'111','123456','¡Ù—‘∞Âπ‹¿Ì‘±','π‹¿Ì‘±',1,'ygl2879827672@gmail.com','images/39fc162d-f0a0-4406-baf6-1c062352dafa.jpg');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-15 14:44:33
