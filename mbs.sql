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
INSERT INTO `bgimage` VALUES (3,'蜘蛛侠','images/3a9de451-bd32-4c7d-a617-f34fe0d4d833.jpg'),(7,'留言板管理员','images/2e003231-83c8-4efe-8c4f-baa4d6fa955e.htm');
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
INSERT INTO `comments` VALUES (1,3,101,'第一次评论',1,'2023-04-02','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'蜘蛛侠'),(2,3,101,'我是二级评论，楼中楼',2,'2023-04-02','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',1,'蜘蛛侠'),(3,3,101,'第二次评论',1,'2023-04-02','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'蜘蛛侠'),(4,3,101,'我是二级评论，楼中楼',2,'2023-04-02','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',1,'蜘蛛侠'),(5,3,3,'哈哈哈',1,'2023-04-05 15:25:46','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'蜘蛛侠'),(6,4,3,'我的蜘蛛丝快要堵不住了......',1,'2023-04-05 15:26:38','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'蜘蛛侠'),(9,3,3,'哈哈哈',2,'2023-04-05 20:48:51','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',3,'蜘蛛侠'),(11,4,3,'建议跳楼',2,'2023-04-05 21:17:12','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',6,'蜘蛛侠'),(12,4,3,'芜湖',1,'2023-04-05 21:17:26','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'蜘蛛侠'),(14,3,3,'aaa',1,'2023-04-06 09:24:42','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'蜘蛛侠'),(15,3,3,'bbb',1,'2023-04-06 09:27:39','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'蜘蛛侠'),(16,3,3,'ccc',1,'2023-04-06 09:29:53','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'蜘蛛侠'),(17,4,3,'aaa',1,'2023-04-06 09:31:29','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'蜘蛛侠'),(18,3,3,'ccc',1,'2023-04-06 09:33:30','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'蜘蛛侠'),(19,3,3,'ddd',1,'2023-04-06 09:34:02','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'蜘蛛侠'),(20,3,3,'eee',1,'2023-04-06 09:34:33','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',NULL,'蜘蛛侠'),(21,3,3,'bbb',2,'2023-04-06 09:34:51','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',15,'蜘蛛侠'),(22,4,3,'来不及了',2,'2023-04-06 14:13:11','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',6,'蜘蛛侠'),(25,4,3,'wu',2,'2023-04-08 19:07:48','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',12,'蜘蛛侠'),(26,3,3,'ccc',2,'2023-04-08 19:29:02','images/92e4d664-b2ca-482a-a756-6e8c136f442c.jpg',16,'蜘蛛侠'),(27,8,7,'芜湖',1,'2023-04-12 15:06:49','images/39fc162d-f0a0-4406-baf6-1c062352dafa.jpg',NULL,'留言板管理员'),(28,8,3,'aaaa',1,'2023-04-14 08:36:22','images/f4cd5ce5-3aa4-409d-9f48-f3f9726e75d0.jpg',NULL,'蜘蛛侠');
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
INSERT INTO `department` VALUES (1,'管理部',3,'无','无'),(2,'运营部',0,'无','无'),(3,'财务部',0,'无','无'),(4,'技术部',1,'无','无');
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
INSERT INTO `message` VALUES (3,3,'11楼的厕所堵了很久了我感觉.......','11楼的厕所堵了很久了我感觉要喷发了',7,3,0,'无','2023-04-03 19:44:28','蜘蛛侠'),(4,5,'没时间解释了。。。。。','全体员工赶紧离开办公大楼',5,1,0,'无','2023-04-03 20:06:55','爱因斯坦'),(6,7,'test','test',1,3,0,'无','2023-04-07 20:07:53','留言板管理员'),(7,7,'这是一个通知','这是一个通知',1,2,0,'无','2023-04-12 14:48:26','留言板管理员'),(8,7,'领厕纸','请所有人到一楼领取厕纸！',3,4,0,'无','2023-04-12 14:49:27','留言板管理员');
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
INSERT INTO `type` VALUES (1,'公务'),(2,'通知'),(3,'其它'),(4,'生活');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '閻€劍鍩沬d',
  `account` varchar(255) DEFAULT NULL COMMENT '閻€劍鍩涚拹锕�褰�',
  `password` varchar(255) DEFAULT NULL COMMENT '閻€劍鍩涚�靛棛鐖�',
  `nickname` varchar(255) DEFAULT NULL COMMENT '閻€劍鍩涢弰鐢敌�',
  `role` varchar(255) DEFAULT NULL COMMENT '閻€劍鍩涚憴鎺曞',
  `deptId` int(20) DEFAULT NULL COMMENT '閻€劍鍩涢柈銊╂，id',
  `email` varchar(255) DEFAULT NULL COMMENT '閻€劍鍩涢柇??',
  `avatarUrl` varchar(255) DEFAULT NULL COMMENT '閻€劍鍩涙径鏉戝剼閸ュ墽澧栫捄?绶�',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (3,'101','123456','蜘蛛侠',NULL,4,'3112520587@qq.com','images/f4cd5ce5-3aa4-409d-9f48-f3f9726e75d0.jpg'),(5,'103','123456','爱因斯坦',NULL,1,'aiyinstan@qq.com','images/fcc2bf1d-dacd-46ca-a60c-3978a61867f5.jpg'),(6,'test','123456','测试人员',NULL,1,'aa@qq.com','images/893cc0ef-24ef-4da2-94ad-15de22a1c4cd.jpg'),(7,'111','123456','留言板管理员','管理员',1,'ygl2879827672@gmail.com','images/39fc162d-f0a0-4406-baf6-1c062352dafa.jpg');
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
