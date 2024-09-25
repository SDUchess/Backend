-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 47.104.224.71    Database: chess
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `chess_moves`
--

DROP TABLE IF EXISTS `chess_moves`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chess_moves` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `chessboard_id` bigint NOT NULL,
  `move_order` int NOT NULL,
  `move` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `chessboard_id` (`chessboard_id`),
  CONSTRAINT `chess_moves_ibfk_1` FOREIGN KEY (`chessboard_id`) REFERENCES `chessboards` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=302 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chess_moves`
--

LOCK TABLES `chess_moves` WRITE;
/*!40000 ALTER TABLE `chess_moves` DISABLE KEYS */;
INSERT INTO `chess_moves` VALUES (104,31,1,'2,3->3,3'),(105,32,1,'5,1->5,0'),(106,33,1,'5,9->5,8'),(107,33,2,'5,2->4,1'),(108,33,3,'5,1->4,1'),(109,34,1,'2,7->2,3'),(110,35,1,'2,7->2,0'),(111,36,1,'1,7->1,0'),(112,37,1,'6,0->6,2'),(113,38,1,'2,7->2,0'),(114,38,2,'4,2->2,0'),(115,38,3,'2,8->2,0'),(116,39,1,'6,5->6,0'),(117,39,2,'7,0->6,0'),(118,39,3,'6,7->6,0'),(119,40,1,'1,7->4,7'),(120,41,1,'7,7->7,0'),(121,42,1,'6,3->6,0'),(125,45,1,'8,7->8,0'),(126,45,2,'7,0->6,2'),(127,45,3,'7,5->7,0'),(128,46,1,'7,5->7,0'),(129,48,1,'7,7->2,7'),(130,48,2,'4,0->5,0'),(131,48,3,'2,7->2,0'),(133,50,1,'1,5->1,0'),(134,50,2,'2,0->3,0'),(135,50,3,'1,0->3,0'),(137,52,1,'7,7->7,4'),(138,52,2,'6,1->8,2'),(139,52,3,'7,4->8,4'),(140,53,1,'5,3->1,3'),(141,53,2,'1,2->0,2'),(142,53,3,'1,3->1,4'),(145,58,1,'2,0->4,2'),(146,58,2,'5,2->6,2'),(147,58,3,'1,2->6,2'),(148,59,1,'0,2->0,0'),(149,60,1,'5,7->5,0'),(154,64,1,'6,5->6,1'),(155,64,2,'4,1->4,0'),(156,64,3,'8,5->8,0'),(157,65,1,'1,5->1,1'),(158,65,2,'3,1->3,0'),(159,65,3,'2,2->2,0'),(160,66,1,'1,5->3,5'),(161,67,1,'8,4->8,1'),(162,67,2,'3,1->3,2'),(163,67,3,'1,0->3,0'),(164,68,1,'4,6->3,6'),(165,70,1,'8,6->3,6'),(166,70,2,'3,1->4,1'),(167,70,3,'8,7->4,7'),(168,71,1,'5,9->4,9'),(169,71,2,'3,1->3,0'),(170,71,3,'4,3->3,3'),(171,72,1,'3,3->4,3'),(172,72,2,'4,2->5,2'),(173,72,3,'3,9->4,9'),(174,72,4,'5,2->5,1'),(175,72,5,'4,3->5,3'),(176,73,1,'3,5->3,0'),(177,73,2,'4,0->4,1'),(178,73,3,'3,6->3,1'),(179,74,1,'5,7->5,0'),(180,74,2,'4,0->4,1'),(181,74,3,'1,5->1,1'),(187,76,1,'6,5->4,6'),(188,76,2,'2,7->2,4'),(189,76,3,'4,6->6,7'),(190,77,1,'5,3->6,1'),(191,77,2,'4,0->5,0'),(192,77,3,'6,1->8,0'),(196,79,1,'1,3->2,1'),(197,80,1,'7,3->6,1'),(198,80,2,'4,0->4,1'),(199,80,3,'8,7->8,1'),(200,81,1,'2,5->3,3'),(201,81,2,'4,1->3,1'),(202,81,3,'8,5->3,5'),(203,82,1,'1,3->3,2'),(204,82,2,'4,0->3,0'),(205,82,3,'4,4->3,4'),(211,84,1,'6,3->7,1'),(212,84,2,'5,0->4,0'),(213,84,3,'7,1->5,2'),(214,84,4,'4,0->5,0'),(215,84,5,'4,5->5,5'),(216,85,1,'6,3->7,1'),(217,85,2,'5,0->5,1'),(218,85,3,'4,5->8,5'),(219,85,4,'4,1->3,2'),(220,85,5,'8,5->8,1'),(221,86,1,'7,3->6,1'),(222,86,2,'4,0->4,1'),(223,86,3,'1,7->1,1'),(229,89,1,'1,3->2,1'),(230,89,2,'4,0->3,0'),(231,89,3,'8,6->3,6'),(232,89,4,'4,1->3,2'),(233,89,5,'3,6->3,2'),(234,90,1,'1,3->3,2'),(235,90,2,'4,0->4,1'),(236,90,3,'7,5->7,1'),(237,92,1,'7,5->7,0'),(238,92,2,'4,1->5,0'),(239,92,3,'7,0->5,0'),(259,98,1,'7,7->4,7'),(260,98,2,'7,0->6,2'),(261,98,3,'6,6->6,5'),(262,98,4,'2,3->2,4'),(263,98,5,'7,9->6,7'),(264,98,6,'1,0->2,2'),(265,98,7,'8,9->7,9'),(281,108,1,'5,4->5,6'),(282,109,1,'7,5->5,5'),(283,109,2,'5,0->4,0'),(284,109,3,'5,5->5,4'),(285,110,1,'0,7->2,7'),(286,111,1,'4,6->4,4'),(287,112,1,'1,5->2,3'),(288,113,1,'3,5->5,4'),(289,114,1,'2,4->2,3'),(290,115,1,'7,3->7,2'),(293,117,1,'6,9->4,7'),(294,118,1,'2,6->2,5'),(295,118,2,'4,3->4,4'),(296,118,3,'6,6->6,5'),(297,119,1,'2,3->2,4'),(298,119,2,'2,6->2,5'),(299,119,3,'6,3->6,4'),(300,120,1,'1,2->1,5'),(301,120,2,'5,9->4,8');
/*!40000 ALTER TABLE `chess_moves` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chessboards`
--

DROP TABLE IF EXISTS `chessboards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chessboards` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `initial_board` text NOT NULL,
  `publisher_id` bigint NOT NULL,
  `description` varchar(300) DEFAULT NULL COMMENT '棋盘描述',
  `score` int DEFAULT '0' COMMENT '残局得分',
  PRIMARY KEY (`id`),
  KEY `teacher_id` (`publisher_id`),
  CONSTRAINT `chessboards_ibfk_1` FOREIGN KEY (`publisher_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chessboards`
--

LOCK TABLES `chessboards` WRITE;
/*!40000 ALTER TABLE `chessboards` DISABLE KEYS */;
INSERT INTO `chessboards` VALUES (31,'兵的基本走法','[[null,null,null,null,\"b_j\",null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,\"r_z\",\"b_m\",null,null,null,null,null],[null,null,\"b_m\",null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_j\",null,null,null]]',9,'红兵一步吃掉黑马',1),(32,'兵的基本走法','[[null,null,null,null,\"b_j\",null,null,null,null],[null,null,null,\"r_z\",null,\"r_z\",null,null,null],[null,null,null,\"b_s\",null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_j\",null,null,null]]',9,'利用红兵一步杀',1),(33,'兵的基本走法','[[null,null,null,null,\"b_j\",null,null,null,null],[null,null,null,\"r_z\",null,\"r_z\",null,null,null],[null,null,null,null,null,\"b_s\",null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_j\",null,null,null]]',9,'利用红兵两步杀',1),(34,'炮的基本走法','[[null,null,null,null,\"b_j\",null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,\"b_m\",null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,\"r_z\",null,null,null,null,null,null],[null,null,\"r_p\",null,null,null,null,\"b_m\",null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_j\",null,null,null]]',9,'红炮一步吃掉黑马（注意：炮能走直线行子，但不能直线吃子）',1),(35,'炮的基本走法','[[null,null,\"b_x\",\"b_s\",\"b_j\",null,null,null,null],[null,null,null,null,\"b_s\",null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,\"r_z\",null,null,null,null,null,null],[null,null,\"r_p\",null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_j\",null,null,null]]',9,'利用红炮一步杀',1),(36,'炮的基本走法','[[null,null,null,\"b_s\",\"b_j\",null,null,null,null],[null,null,null,null,\"b_s\",null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,\"r_p\",null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_j\",null,null,null]]',9,'利用红炮一步杀',1),(37,'炮的基本走法','[[null,null,null,null,null,null,\"r_p\",null,null],[null,null,null,null,\"b_s\",null,null,null,null],[null,null,null,null,\"b_j\",\"b_s\",null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_j\",null,null,null]]',9,'利用红炮一步杀',1),(38,'炮的基本走法 ','[[null,null,\"b_x\",\"b_s\",\"b_j\",null,null,null,null],[null,null,null,null,\"b_s\",null,null,null,null],[null,null,null,null,\"b_x\",null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,\"r_x\",null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,\"r_p\",null,null,null,null,null,null],[null,null,\"r_p\",null,null,null,null,null,null],[null,null,null,null,null,\"r_j\",null,null,null]]',9,'利用红炮两步杀',1),(39,'炮的基本走法 ','[[null,null,null,null,\"b_j\",\"b_s\",null,\"b_c\",null],[null,null,null,null,\"b_s\",null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,\"r_p\",null,null],[null,null,null,null,null,null,\"r_z\",null,null],[null,null,null,null,null,null,\"r_p\",null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_j\",null,null,null]]',9,'利用红炮两步杀',1),(40,'炮的基本走法 ','[[null,null,null,\"b_s\",\"b_j\",\"b_s\",null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,\"r_p\",null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,\"r_p\",null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_j\",null,null,null]]',9,'利用红炮一步杀',1),(41,'炮的基本走法 ','[[null,null,null,\"b_s\",\"b_j\",null,null,null,\"r_p\"],[null,null,null,null,\"b_s\",null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,\"r_p\",null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_j\",null,null,null]]',9,'利用红炮一步杀',1),(42,'炮的基本走法 ','[[null,null,null,\"b_s\",\"b_j\",null,null,null,\"r_p\"],[null,null,null,\"r_z\",null,null,null,null,null],[null,null,null,null,null,\"b_s\",null,null,null],[null,null,null,null,null,null,\"r_p\",null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_j\",null,null,null]]',9,'利用红炮一步杀',1),(45,'炮的基本走法 ','[[null,null,null,\"b_s\",\"b_j\",null,null,\"b_m\",null],[null,null,null,\"r_z\",null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,\"r_p\",null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"b_z\",null,null,\"r_p\"],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_j\",null,null,null]]',9,'利用红炮两步杀',1),(46,'炮的基本走法 ','[[null,null,null,\"b_j\",null,\"b_s\",null,null,null],[null,null,null,null,\"b_s\",\"r_p\",null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,\"r_p\",null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,\"r_j\",null,null,null,null]]',9,'利用红炮一步杀',1),(48,'炮的基本走法 ','[[null,null,null,\"b_s\",\"b_j\",null,null,null,null],[null,null,null,\"r_p\",\"b_s\",null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[\"b_z\",null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,\"r_p\",null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,\"r_j\",null,null,null,null]]',9,'利用红炮两步杀',1),(50,'车的基本走法','[[null,null,\"b_p\",null,\"b_j\",null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,\"r_c\",null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,\"r_j\",null,null,null,null,null]]',9,'红车两步白白吃掉黑炮',1),(52,'车的基本走法','[[null,null,null,null,\"b_j\",null,\"b_x\",null,null],[null,null,null,null,null,null,\"b_m\",null,null],[null,null,null,null,\"b_x\",null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,\"b_m\"],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,\"r_c\",null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_j\",null,null,null]]',9,'红车两步白白吃掉黑马',1),(53,'车的基本走法','[[null,null,\"b_x\",null,\"b_j\",null,\"b_x\",null,null],[null,null,null,null,null,null,null,null,null],[null,\"b_p\",null,null,null,null,\"b_m\",null,null],[null,null,null,null,null,\"r_c\",null,null,null],[null,\"b_m\",null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_j\",null,null,null]]',9,'红车两步白白得子',1),(58,'车的基本走法','[[null,null,\"b_x\",null,\"b_j\",null,\"b_x\",null,null],[null,null,null,null,null,null,null,null,null],[null,\"b_p\",null,null,null,\"r_c\",\"b_m\",null,null],[null,null,null,null,null,null,null,null,null],[null,\"b_m\",null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_j\",null,null,null]]',9,'黑方防止红车捉双得子（提示：需要同时保护好被捉双的两个子，本挑战利用好三路象）',1),(59,'车的基本走法','[[null,null,null,null,\"b_j\",null,null,null,null],[null,\"r_c\",null,null,null,null,null,null,null],[\"r_c\",null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_j\",null,null,null]]',9,'利用红车一步杀',1),(60,'车的基本走法','[[null,null,null,null,\"b_j\",null,null,null,null],[null,\"r_c\",null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_c\",null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_j\",null,null,null]]',9,'利用红车一步杀',1),(64,'车的基本走法','[[null,null,null,null,null,null,null,null,null],[null,null,null,null,\"b_j\",null,null,\"b_m\",null],[null,null,null,null,null,null,null,null,null],[null,null,null,\"b_c\",null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,\"r_c\",null,\"r_c\"],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_j\",null,null,null]]',9,'利用红车两步杀',1),(65,'车的基本走法','[[null,null,null,null,null,\"b_s\",null,null,null],[null,null,null,\"b_j\",\"b_s\",null,null,null,null],[null,null,\"r_c\",null,null,\"b_p\",null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,\"r_c\",null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_j\",null,null,null]]',9,'利用红车两步杀',1),(66,'车的基本走法','[[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,\"b_j\",\"b_x\",null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,\"r_c\",null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_j\",null,null,null]]',9,'利用红车一步杀',1),(67,'车的基本走法','[[null,\"r_c\",null,null,null,null,null,null,null],[null,null,null,\"b_j\",null,null,null,null,null],[null,null,null,null,\"b_x\",null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,\"b_m\",null,null,null,null,null,\"r_c\"],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_j\",null,null,null]]',9,'利用红车两步杀',1),(68,'车的基本走法','[[null,null,null,null,null,null,null,null,null],[null,null,null,\"b_j\",null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,\"r_c\",null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,\"r_j\",null,null,null,null]]',9,'利用红车一步杀',1),(70,'车的基本走法','[[null,null,null,null,null,null,null,null,null],[null,null,null,\"b_j\",null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,\"r_c\"],[null,null,null,\"r_p\",null,null,null,null,\"r_c\"],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_j\",null,null,null]]',9,'利用红车两步杀',1),(71,'车的基本走法','[[null,null,null,null,null,null,null,null,null],[null,null,null,\"b_j\",null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,\"r_c\",null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_j\",null,null,null]]',9,'利用红车两步杀',1),(72,'车的基本走法','[[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,\"b_j\",null,null,null,null],[null,null,null,\"r_c\",null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,\"r_j\",null,null,null,null,null]]',9,'利用红车三步杀',1),(73,'车的基本走法','[[null,null,null,\"b_s\",\"b_j\",\"b_s\",\"b_x\",null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,\"b_x\",null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,\"r_c\",null,null,null,null,null],[null,null,null,\"r_c\",null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_j\",null,null,null]]',9,'利用红车两步杀',1),(74,'车的基本走法','[[null,null,null,\"b_s\",\"b_j\",\"b_s\",\"b_x\",null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,\"b_x\",null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,\"r_c\",null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_c\",null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_j\",null,null,null]]',9,'利用红车两步杀',1),(76,'马的基本走法','[[null,null,null,null,\"b_j\",null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,\"r_m\",null,null],[null,null,null,null,null,null,null,null,null],[null,null,\"b_c\",null,\"r_x\",null,\"b_p\",null,null],[null,null,null,null,\"r_s\",null,null,null,null],[null,null,\"r_x\",null,\"r_j\",null,null,null,null]]',9,'红马两步白白得子',1),(77,'马的基本走法','[[null,null,null,\"b_s\",\"b_j\",null,null,null,\"b_c\"],[null,null,null,null,\"b_s\",null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_m\",null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,\"r_x\",null,null,null,null],[null,null,null,null,\"r_s\",null,null,null,null],[null,null,\"r_x\",null,\"r_j\",null,null,null,null]]',9,'红马两步白白得子',1),(79,'马的基本走法','[[null,null,null,\"b_s\",\"b_j\",\"b_s\",null,null,null],[\"r_p\",null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,\"r_m\",null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,\"r_x\",null,null,null,null],[null,null,null,null,\"r_s\",null,null,null,null],[null,null,\"r_x\",null,\"r_j\",null,null,null,null]]',9,'利用红马一步杀',1),(80,'马的基本走法','[[null,null,null,\"b_s\",\"b_j\",\"b_s\",null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,\"r_m\",null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,\"r_p\"],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_j\",null,null,null]]',9,'利用红马两步杀',1),(81,'马的基本走法','[[null,null,null,null,null,\"b_s\",null,\"r_p\",null],[null,null,null,null,\"b_j\",null,null,null,null],[null,null,null,null,\"b_x\",null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,\"r_m\",null,null,null,null,null,\"r_p\"],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_j\",null,null,null]]',9,'利用红马两步杀',1),(82,'马的基本走法','[[null,null,null,null,\"b_j\",\"b_s\",null,null,null],[null,null,null,null,\"b_s\",null,null,null,null],[null,null,null,null,\"b_x\",null,null,null,null],[null,\"r_m\",null,null,null,null,null,null,null],[null,null,null,null,\"r_p\",null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_j\",null,null,null]]',9,'利用红马两步杀',1),(84,'马的基本走法','[[null,null,null,\"b_s\",null,\"b_j\",null,null,null],[null,null,null,null,\"b_s\",null,null,null,null],[null,null,null,null,\"b_x\",null,null,null,null],[null,null,null,null,null,null,\"r_m\",null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,\"r_p\",null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,\"r_j\",null,null,null,null]]',9,'利用红马三步杀（黑将六平五变化）',1),(85,'马的基本走法','[[null,null,null,\"b_s\",null,\"b_j\",null,null,null],[null,null,null,null,\"b_s\",null,null,null,null],[null,null,null,null,\"b_x\",null,null,null,null],[null,null,null,null,null,null,\"r_m\",null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,\"r_p\",null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,\"r_j\",null,null,null,null]]',9,'利用红马三步杀（黑将六进一变化）',1),(86,'马的基本走法','[[null,null,null,\"b_s\",\"b_j\",\"b_s\",null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,\"r_m\",null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,\"r_c\",null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_j\",null,null,null]]',9,'利用红马两步杀',1),(89,'马的基本走法','[[null,null,null,null,\"b_j\",\"b_s\",null,null,null],[null,null,null,null,\"b_s\",null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,\"r_m\",null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,\"r_c\"],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_j\",null,null,null]]',9,'利用红马三步杀',1),(90,'马的基本走法','[[null,null,null,\"b_s\",\"b_j\",\"b_s\",null,null,null],[null,null,null,null,null,null,null,null,null],[\"b_m\",null,null,null,\"b_x\",null,null,null,null],[null,\"r_m\",null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,\"r_c\",null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_j\",null,null,null]]',9,'利用红马两步杀',1),(92,'马的基本走法','[[null,null,null,\"b_s\",\"b_j\",null,null,null,null],[null,null,null,null,\"b_s\",null,null,null,null],[null,null,null,null,null,null,\"r_m\",null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,\"r_c\",null],[null,null,null,null,null,null,null,null,null],[null,null,null,\"r_s\",null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,\"r_j\",null,null,null,null,null]]',9,'利用红马两步杀',1),(98,'经典布局','[[\"b_c\",\"b_m\",\"b_x\",\"b_s\",\"b_j\",\"b_s\",\"b_x\",\"b_m\",\"b_c\"],[null,null,null,null,null,null,null,null,null],[null,\"b_p\",null,null,null,null,null,\"b_p\",null],[\"b_z\",null,\"b_z\",null,\"b_z\",null,\"b_z\",null,\"b_z\"],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[\"r_z\",null,\"r_z\",null,\"r_z\",null,\"r_z\",null,\"r_z\"],[null,\"r_p\",null,null,null,null,null,\"r_p\",null],[null,null,null,null,null,null,null,null,null],[\"r_c\",\"r_m\",\"r_x\",\"r_s\",\"r_j\",\"r_s\",\"r_x\",\"r_m\",\"r_c\"]]',14,'当头炮布局',1),(108,'捉双','[[null,null,null,null,null,\"b_j\",null,null,null],[null,null,null,null,\"b_s\",null,null,null,null],[null,null,null,null,null,\"b_s\",null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_c\",null,null,null],[null,null,null,null,null,null,null,null,null],[\"b_m\",\"b_m\",null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_j\",null,null,null]]',9,'红先走捉双',1),(109,'捉双','[[null,null,null,null,null,\"b_j\",null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,\"b_p\",null,\"b_m\",null,null],[null,null,null,null,null,null,null,\"r_c\",null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,\"r_j\",null,null,null,null,null]]',9,'红先走捉双',1),(110,'捉双','[[null,null,null,null,\"b_j\",null,null,null,null],[null,null,\"b_m\",null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,\"b_m\",null,null,null,null,null,null],[null,null,\"r_x\",null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[\"r_p\",null,null,null,null,null,null,null,null],[null,null,null,null,\"r_s\",null,null,null,null],[null,null,null,null,\"r_j\",\"r_s\",null,null,null]]',9,'红先走捉双',1),(111,'捉双','[[null,null,null,null,\"b_j\",null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,\"b_c\",\"b_x\",null,null,null,\"b_x\",null,\"b_c\"],[null,null,null,null,null,null,null,null,null],[null,null,null,null,\"r_p\",null,null,null,null],[null,null,null,null,\"r_x\",null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,\"r_s\",\"r_j\",\"r_s\",null,null,null]]',9,'红先走捉双',1),(112,'捉双','[[null,null,null,null,\"b_j\",null,null,null,null],[null,\"b_p\",null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,\"r_m\",null,\"b_p\",null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,\"r_j\",null,null,null]]',9,'红先走捉双',1),(113,'捉双','[[null,null,null,null,\"b_j\",null,null,null,null],[null,null,null,null,\"b_s\",null,null,null,null],[null,null,null,null,null,null,\"b_c\",null,null],[null,null,null,null,null,null,\"b_z\",null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,\"r_m\",null,null,null,null,null],[null,null,null,null,null,null,\"b_c\",null,null],[null,null,null,null,\"r_x\",null,null,null,\"r_x\"],[null,null,null,null,null,null,null,null,null],[null,null,null,null,\"r_j\",\"r_s\",null,null,null]]',9,'红先走捉双',1),(114,'捉双','[[null,null,null,null,\"b_j\",null,\"b_x\",null,null],[null,null,null,null,null,null,null,null,null],[null,null,\"b_m\",null,\"b_x\",null,null,null,null],[null,null,null,\"b_m\",null,null,null,null,null],[null,null,\"r_z\",null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,\"r_j\",null,null,null,null]]',9,'红先走捉双',1),(115,'捉双','[[null,null,null,null,\"b_j\",null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,\"b_p\",null,\"b_p\"],[null,null,null,null,null,null,null,\"r_z\",null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,null,null,\"r_x\",null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,\"r_x\",\"r_j\",null,null,null,null,null]]',9,'红先走捉双',1),(117,'捉双','[[null,null,null,\"b_s\",null,\"b_j\",null,null,\"r_p\"],[null,null,null,null,\"b_s\",null,null,null,null],[null,null,null,null,null,null,null,null,null],[\"b_z\",null,null,null,null,null,null,null,null],[null,null,\"r_m\",null,null,null,null,null,null],[\"r_z\",null,null,null,null,null,\"b_p\",null,null],[null,null,null,null,null,null,null,null,\"r_z\"],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[null,null,\"b_p\",null,\"r_j\",null,\"r_x\",null,null]]',9,'红先走捉双',1),(118,'我的挑战','[[\"b_c\",\"b_m\",\"b_x\",\"b_s\",\"b_j\",\"b_s\",\"b_x\",\"b_m\",\"b_c\"],[null,null,null,null,null,null,null,null,null],[null,\"b_p\",null,null,null,null,null,\"b_p\",null],[\"b_z\",null,\"b_z\",null,\"b_z\",null,\"b_z\",null,\"b_z\"],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[\"r_z\",null,\"r_z\",null,\"r_z\",null,\"r_z\",null,\"r_z\"],[null,\"r_p\",null,null,null,null,null,\"r_p\",null],[null,null,null,null,null,null,null,null,null],[\"r_c\",\"r_m\",\"r_x\",\"r_s\",\"r_j\",\"r_s\",\"r_x\",\"r_m\",\"r_c\"]]',2,'这是我的挑战',7),(119,'我的挑战2','[[\"b_c\",\"b_m\",\"b_x\",\"b_s\",\"b_j\",\"b_s\",\"b_x\",\"b_m\",\"b_c\"],[null,null,null,null,null,null,null,null,null],[null,\"b_p\",null,null,null,null,null,\"b_p\",null],[\"b_z\",null,\"b_z\",null,\"b_z\",null,\"b_z\",null,\"b_z\"],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[\"r_z\",null,\"r_z\",null,\"r_z\",null,\"r_z\",null,\"r_z\"],[null,\"r_p\",null,null,null,null,null,\"r_p\",null],[null,null,null,null,null,null,null,null,null],[\"r_c\",\"r_m\",\"r_x\",\"r_s\",\"r_j\",\"r_s\",\"r_x\",\"r_m\",\"r_c\"]]',2,'',1),(120,'我的挑战3','[[\"b_c\",\"b_m\",\"b_x\",\"b_s\",\"b_j\",\"b_s\",\"b_x\",\"b_m\",\"b_c\"],[null,null,null,null,null,null,null,null,null],[null,\"b_p\",null,null,null,null,null,\"b_p\",null],[\"b_z\",null,\"b_z\",null,\"b_z\",null,\"b_z\",null,\"b_z\"],[null,null,null,null,null,null,null,null,null],[null,null,null,null,null,null,null,null,null],[\"r_z\",null,\"r_z\",null,\"r_z\",null,\"r_z\",null,\"r_z\"],[null,\"r_p\",null,null,null,null,null,\"r_p\",null],[null,null,null,null,null,null,null,null,null],[\"r_c\",\"r_m\",\"r_x\",\"r_s\",\"r_j\",\"r_s\",\"r_x\",\"r_m\",\"r_c\"]]',2,'',6);
/*!40000 ALTER TABLE `chessboards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_board`
--

DROP TABLE IF EXISTS `class_board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_board` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `class_id` bigint NOT NULL,
  `board_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `class_id` (`class_id`),
  KEY `board_id` (`board_id`),
  CONSTRAINT `class_board_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`),
  CONSTRAINT `class_board_ibfk_2` FOREIGN KEY (`board_id`) REFERENCES `chessboards` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_board`
--

LOCK TABLES `class_board` WRITE;
/*!40000 ALTER TABLE `class_board` DISABLE KEYS */;
INSERT INTO `class_board` VALUES (17,5,98),(20,5,118),(22,5,119),(23,5,120);
/*!40000 ALTER TABLE `class_board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classes`
--

DROP TABLE IF EXISTS `classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classes`
--

LOCK TABLES `classes` WRITE;
/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
INSERT INTO `classes` VALUES (5,'我的班级1','这是我的班级1'),(6,'1班','整维全包要反派型报白规把位制果较标用。制必很果界太列局构严已两算。度并质离那需照越速能会级完很。着资如参交达包易专海科造它各却七。'),(7,'2班','整维全包要反派型报白规把位制果较标用。制必很果界太列局构严已两算。度并质离那需照越速能会级完很。着资如参交达包易专海科造它各却七。'),(8,'3班','班级描述...'),(12,'4班','班级描述...'),(13,'新的班级2','这是新的班级2'),(14,'新的班级3','这是新的班级3'),(15,'啊啊啊','噢噢噢'),(18,'英才班','123'),(19,'育苗班','123'),(20,'名字超级无敌长的班名字超级无敌长的班名字超级无敌长的班名字超级无敌长的班名字超级无敌长的班名字超级无敌长的班名字超级无敌长的班名字超级无敌长的班名字超级无敌长的班名字超级无敌长的班名字超级无敌长的班名字超级无敌长的班名字超级无敌长的班名字超级无敌长的班2名字超级无敌长的班名字超级无敌长的班名字超级无敌长的班','123'),(21,'被覆盖的班','呜呜呜呜');
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classes_student`
--

DROP TABLE IF EXISTS `classes_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classes_student` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `class_id` bigint NOT NULL,
  `student_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `class_id` (`class_id`),
  KEY `student_id` (`student_id`),
  CONSTRAINT `classes_student_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`),
  CONSTRAINT `classes_student_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classes_student`
--

LOCK TABLES `classes_student` WRITE;
/*!40000 ALTER TABLE `classes_student` DISABLE KEYS */;
INSERT INTO `classes_student` VALUES (2,8,6),(3,8,4),(6,5,1),(7,6,10),(10,6,15);
/*!40000 ALTER TABLE `classes_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_chess`
--

DROP TABLE IF EXISTS `student_chess`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_chess` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `chess_id` bigint NOT NULL,
  `student_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cid` (`chess_id`),
  KEY `sid` (`student_id`),
  CONSTRAINT `cid` FOREIGN KEY (`chess_id`) REFERENCES `chessboards` (`id`),
  CONSTRAINT `sid` FOREIGN KEY (`student_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_chess`
--

LOCK TABLES `student_chess` WRITE;
/*!40000 ALTER TABLE `student_chess` DISABLE KEYS */;
INSERT INTO `student_chess` VALUES (1,31,1),(3,32,1),(4,31,13),(5,64,13),(7,98,13),(8,31,4),(9,32,4),(10,33,4),(14,118,1);
/*!40000 ALTER TABLE `student_chess` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_classes`
--

DROP TABLE IF EXISTS `teacher_classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher_classes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `teacher_id` bigint NOT NULL,
  `class_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_id` (`teacher_id`),
  KEY `class_id` (`class_id`),
  CONSTRAINT `teacher_classes_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `users` (`id`),
  CONSTRAINT `teacher_classes_ibfk_2` FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_classes`
--

LOCK TABLES `teacher_classes` WRITE;
/*!40000 ALTER TABLE `teacher_classes` DISABLE KEYS */;
INSERT INTO `teacher_classes` VALUES (1,2,5),(2,8,6),(3,8,7),(4,7,8),(7,2,12),(8,2,13),(9,2,14),(10,2,15),(13,14,18),(14,14,19),(15,14,20),(16,14,21);
/*!40000 ALTER TABLE `teacher_classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_student`
--

DROP TABLE IF EXISTS `teacher_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher_student` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `teacher_id` bigint NOT NULL,
  `student_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_id` (`teacher_id`),
  KEY `student_id` (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_student`
--

LOCK TABLES `teacher_student` WRITE;
/*!40000 ALTER TABLE `teacher_student` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'reisen','123456','student'),(2,'keine','123456','teacher'),(3,'啦啦啦','123','teacher'),(4,'哈哈哈','123','student'),(5,'宫政','123456','teacher'),(6,'ysy','123456','student'),(7,'123','123','teacher'),(8,'嘻嘻嘻','123','teacher'),(9,'ChessAdmin','123admin456','admin'),(10,'测试','123','student'),(11,'谭强1','esse123','student'),(13,'exe','123456','student'),(14,'admin','123456','teacher'),(15,'小明','123','student'),(18,'newUser1222','123','student'),(19,'newUser1','123456','teacher'),(20,'newUser2','123456','student'),(21,'newUser3','123456','student'),(22,'qwe','123','student');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-25 15:22:13
