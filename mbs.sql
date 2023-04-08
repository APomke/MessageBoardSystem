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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,3,101,'��һ������',1,'2023-04-02','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'֩����'),(2,3,101,'���Ƕ������ۣ�¥��¥',2,'2023-04-02','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',1,'֩����'),(3,3,101,'�ڶ�������',1,'2023-04-02','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'֩����'),(4,3,101,'���Ƕ������ۣ�¥��¥',2,'2023-04-02','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',1,'֩����'),(5,3,3,'������',1,'2023-04-05 15:25:46','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'֩����'),(6,4,3,'�ҵ�֩��˿��Ҫ�²�ס��......',1,'2023-04-05 15:26:38','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'֩����'),(7,5,3,'����һ¥',1,'2023-04-05 15:32:43','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'֩����'),(9,3,3,'������',2,'2023-04-05 20:48:51','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',3,'֩����'),(10,5,3,'¥��¥�һ���һ¥',2,'2023-04-05 21:16:38','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',7,'֩����'),(11,4,3,'������¥',2,'2023-04-05 21:17:12','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',6,'֩����'),(12,4,3,'�ߺ�',1,'2023-04-05 21:17:26','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'֩����'),(13,5,3,'û���𣿶�һ��',1,'2023-04-06 09:18:29','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'֩����'),(14,3,3,'aaa',1,'2023-04-06 09:24:42','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'֩����'),(15,3,3,'bbb',1,'2023-04-06 09:27:39','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'֩����'),(16,3,3,'ccc',1,'2023-04-06 09:29:53','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'֩����'),(17,4,3,'aaa',1,'2023-04-06 09:31:29','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'֩����'),(18,3,3,'ccc',1,'2023-04-06 09:33:30','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'֩����'),(19,3,3,'ddd',1,'2023-04-06 09:34:02','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'֩����'),(20,3,3,'eee',1,'2023-04-06 09:34:33','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'֩����'),(21,3,3,'bbb',2,'2023-04-06 09:34:51','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',15,'֩����'),(22,4,3,'��������',2,'2023-04-06 14:13:11','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',6,'֩����');
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
INSERT INTO `department` VALUES (1,'����',0,'��','��'),(2,'��Ӫ��',0,'��','��'),(3,'����',0,'��','��'),(4,'������',0,'��','��');
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (3,3,'11¥�Ĳ������˺ܾ����Ҹо�.......','11¥�Ĳ������˺ܾ����Ҹо�Ҫ�緢��',6,3,0,'��','2023-04-03 19:44:28','֩����'),(4,5,'ûʱ������ˡ���������','ȫ��Ա���Ͻ��뿪�칫��¥',4,1,0,'��','2023-04-03 20:06:55','����˹̹');
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
INSERT INTO `type` VALUES (1,'����'),(2,'֪ͨ'),(3,'����'),(4,'����');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '鐢ㄦ埛id',
  `account` varchar(255) DEFAULT NULL COMMENT '鐢ㄦ埛璐﹀彿',
  `password` varchar(255) DEFAULT NULL COMMENT '鐢ㄦ埛瀵嗙爜',
  `nickname` varchar(255) DEFAULT NULL COMMENT '鐢ㄦ埛鏄电О',
  `role` varchar(255) DEFAULT NULL COMMENT '鐢ㄦ埛瑙掕壊',
  `deptId` int(20) DEFAULT NULL COMMENT '鐢ㄦ埛閮ㄩ棬id',
  `email` varchar(255) DEFAULT NULL COMMENT '鐢ㄦ埛閭??',
  `avatarUrl` varchar(255) DEFAULT NULL COMMENT '鐢ㄦ埛澶村儚鍥剧墖璺?緞',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'311252','123456','��','',1,'3112520587@qq.com',NULL),(2,'aaa','123456','qq',NULL,1,'3112520587@qq.com',NULL),(3,'101','123456','֩����',NULL,4,'3112520587@qq.com','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg'),(4,'102','123456','��������',NULL,1,'1111@qq.com','images/3640957e-2067-45b2-8c75-cbaccdbc5cdc.jpg'),(5,'103','123456','����˹̹',NULL,1,'aiyinstan@qq.com','images/fcc2bf1d-dacd-46ca-a60c-3978a61867f5.jpg'),(6,'test','123456','������Ա',NULL,1,'aa@qq.com','images/893cc0ef-24ef-4da2-94ad-15de22a1c4cd.jpg'),(7,'111','123456','���԰����Ա','����Ա',1,'ygl2879827672@gmail.com','images/39fc162d-f0a0-4406-baf6-1c062352dafa.jpg');
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

-- Dump completed on 2023-04-07 11:26:14
