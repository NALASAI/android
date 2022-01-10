-- MySQL dump 10.13  Distrib 5.7.32, for Win64 (x86_64)
--
-- Host: localhost    Database: shoppingmallproject
-- ------------------------------------------------------
-- Server version	5.7.32-log

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
-- Table structure for table `table_cart`
--

DROP TABLE IF EXISTS `table_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `table_cart` (
  `cart_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(100) CHARACTER SET utf8 NOT NULL,
  `sales_id` int(11) NOT NULL,
  `sales_quantity` int(11) NOT NULL,
  `sales_size` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `sales_color` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  PRIMARY KEY (`cart_id`),
  KEY `FK_USERID_FROM_SOLD_idx` (`user_id`),
  KEY `FK_SALESID_FROM_CART_idx` (`sales_id`),
  CONSTRAINT `FK_SALESID_FROM_CART` FOREIGN KEY (`sales_id`) REFERENCES `table_sales` (`sales_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_USERID_FROM_CART` FOREIGN KEY (`user_id`) REFERENCES `table_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `table_cart`
--

LOCK TABLES `table_cart` WRITE;
/*!40000 ALTER TABLE `table_cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `table_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `table_order`
--

DROP TABLE IF EXISTS `table_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `table_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_quantity` int(11) NOT NULL,
  `sales_id` int(11) NOT NULL,
  `user_id` varchar(100) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FK_SALESID_FROM_ORDER_idx` (`sales_id`),
  KEY `FK_USERID_FROM_ORDER_idx` (`user_id`),
  CONSTRAINT `FK_SALESID_FROM_ORDER` FOREIGN KEY (`sales_id`) REFERENCES `table_sales` (`sales_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_USERID_FROM_ORDER` FOREIGN KEY (`user_id`) REFERENCES `table_user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `table_order`
--

LOCK TABLES `table_order` WRITE;
/*!40000 ALTER TABLE `table_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `table_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `table_review`
--

DROP TABLE IF EXISTS `table_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `table_review` (
  `review_id` int(11) NOT NULL AUTO_INCREMENT,
  `review_content` varchar(200) COLLATE utf8_bin NOT NULL,
  `review_score` int(11) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `user_id` varchar(100) CHARACTER SET utf8 NOT NULL,
  `sales_id` int(11) NOT NULL,
  `ip` varchar(39) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`review_id`),
  KEY `FK_SALESID_FROM_REVIEW_idx` (`sales_id`),
  KEY `FK_USERID_FROM_REVIEW_idx` (`user_id`),
  CONSTRAINT `FK_SALESID_FROM_REVIEW` FOREIGN KEY (`sales_id`) REFERENCES `table_sales` (`sales_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_USERID_FROM_REVIEW` FOREIGN KEY (`user_id`) REFERENCES `table_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `table_review`
--

LOCK TABLES `table_review` WRITE;
/*!40000 ALTER TABLE `table_review` DISABLE KEYS */;
INSERT INTO `table_review` VALUES (33,'리뷰 작성 테스트입니다.2',2,'2021-12-10','google_108217885273618508917',21,'192.168.7.23'),(34,'리뷰 작성 테스트입니다1',5,'2021-12-10','google_108217885273618508917',31,'127.0.0.1');
/*!40000 ALTER TABLE `table_review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `table_sales`
--

DROP TABLE IF EXISTS `table_sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `table_sales` (
  `sales_id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(45) COLLATE utf8_bin NOT NULL,
  `sales_title` varchar(50) COLLATE utf8_bin NOT NULL,
  `sales_price` int(11) NOT NULL,
  `sales_content` text COLLATE utf8_bin,
  `salesImg` longtext COLLATE utf8_bin,
  `sales_size` varchar(45) COLLATE utf8_bin NOT NULL,
  `sales_color` varchar(45) COLLATE utf8_bin NOT NULL,
  `create_date` date DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`sales_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `table_sales`
--

LOCK TABLES `table_sales` WRITE;
/*!40000 ALTER TABLE `table_sales` DISABLE KEYS */;
INSERT INTO `table_sales` VALUES (21,'outer','듀런트 퍼자켓',80000,'듀런트 퍼자켓','듀런트_퍼자켓.jpg','S,M,L','블랙,브라운','2021-12-09','2021-12-09'),(22,'outer','마론디 레더 패딩',75000,'마론디 레더 패딩','마론디_레더패딩.jpg','S,M','블랙, 그레이','2021-12-09','2021-12-09'),(23,'outer','토리즈 카라 퍼자켓',115000,'토리즈 카라 퍼자켓','토리즈_카라_퍼자켓.jpg','Free','브라운, 아이보리','2021-12-09','2021-12-09'),(24,'top','샤스페 워머 폴라티',25000,'샤스페 워머 폴라티','샤스페워머폴라티.jpg','Free','화이트, 블랙','2021-12-09','2021-12-09'),(25,'top','아르마 골지 카라니트',32000,'아르마 골지 카라니트','아르마골지카라니트.jpg','S,M','블랙, 그레이','2021-12-09','2021-12-09'),(26,'top','프린느 꽈배기 크롭니트',25000,'프린느 꽈배기 크롭니트','프린느꽈배기크롭니트.jpg','M,L','그린, 퍼플, 블루','2021-12-09','2021-12-09'),(27,'skirt','이카토 피치코튼 스커트',30000,'이카토 피치코튼 스커트','이카토피치코튼스커트.jpg','S,M,L','브라운,카모,네이비','2021-12-09','2021-12-09'),(28,'pants','에디스 투웨이 밴딩팬츠 ',28000,'에디스 투웨이 밴딩팬츠','에디스_투웨이_밴딩팬츠.jpg','S,M,L','블랙,그레이,아이보리','2021-12-09','2021-12-09'),(29,'skirt','투피츠 기모 스커트팬츠',40000,'투피츠 기모 스커트팬츠','투피츠기모스커트팬츠.jpg','S,M,L','베이지,브라운,블랙','2021-12-09','2021-12-09'),(31,'skirt','핸덜 스웨이드 롱 스커트',50000,'핸덜 스웨이드 롱 스커트','핸덜스웨이드롱스커트.jpg','S,M','브라운,카키,블랙','2021-12-09','2021-12-09'),(32,'pants','에스핀 코로듀이 조거팬츠',68000,'코로듀이 조거팬츠','에스핀_코로듀이_조거팬츠.jpg','S,M,L','블랙,그레이,아이보리','2021-12-09','2021-12-09'),(33,'pants','트로븐 기모 투웨이팬츠',56000,'기모 투웨이 팬츠','트로븐_기모_투웨이팬츠.jpg','S,M','버건디,블랙,브라운','2021-12-09','2021-12-09'),(34,'jewerly','노딕 볼 링귀걸이',12000,'노딕 볼 링귀걸이','노딕_볼_링귀걸이.jpg','Free','실버,골드','2021-12-09','2021-12-09'),(35,'jewerly','블시린 5세트 레이어드반지',20000,'블시린 5세트 레이어드반지','블시린_5세트_레이어드반지.jpg','Free','실버,골드','2021-12-09','2021-12-09'),(36,'jewerly','튜몽 심플 큐브목걸이',25000,'튜몽 심플 큐브목걸이','튜몽_심플_큐브목걸이.jpg','Free','실버','2021-12-09','2021-12-09'),(37,'bag&shoes','뉴먼트 레이스업 워커',45000,'뉴먼트 레이스업 워커','뉴먼트_레이스업_워커.jpg','S,M,L','블랙','2021-12-09','2021-12-09'),(38,'bag&shoes','레벳토 스터드 클로그',40000,'레벳토 스터드 클로그','레벳토_스터드_클로그.jpg','S,M,L','베이지,블랙','2021-12-09','2021-12-09'),(39,'bag&shoes','헬킷트 플랫폼 부츠',45000,'헬킷트 플랫폼 부츠','헬킷트_플랫폼_부츠.jpg','S,M,L','화이트,블랙','2021-12-09','2021-12-09'),(40,'top','머라빈 울 홀니트',30000,'머라빈 울 홀니트','머라빈_울_홀니트.jpg','S,M,L','베이지,블랙','2021-12-10','2021-12-10');
/*!40000 ALTER TABLE `table_sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `table_salespicture`
--

DROP TABLE IF EXISTS `table_salespicture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `table_salespicture` (
  `sales_id` int(11) NOT NULL,
  `main_origin_file_name` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `main_temp_file_name` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `origin_file_names` varchar(800) COLLATE utf8_bin DEFAULT NULL,
  `temp_file_names` varchar(800) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`sales_id`),
  CONSTRAINT `FK_SALESID_FROM_SALESPICTURE` FOREIGN KEY (`sales_id`) REFERENCES `table_sales` (`sales_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `table_salespicture`
--

LOCK TABLES `table_salespicture` WRITE;
/*!40000 ALTER TABLE `table_salespicture` DISABLE KEYS */;
/*!40000 ALTER TABLE `table_salespicture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `table_sold`
--

DROP TABLE IF EXISTS `table_sold`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `table_sold` (
  `sold_id` int(11) NOT NULL AUTO_INCREMENT,
  `sold_date` date NOT NULL,
  `sales_id` int(11) NOT NULL,
  `user_id` varchar(100) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`sold_id`),
  KEY `FK_SALESID_FROM_SOLD_idx` (`sales_id`),
  KEY `FK_USERID_FROM_SOLD_idx` (`user_id`),
  CONSTRAINT `FK_SALESID_FROM_SOLD` FOREIGN KEY (`sales_id`) REFERENCES `table_sales` (`sales_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_USERID_FROM_SOLD` FOREIGN KEY (`user_id`) REFERENCES `table_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `table_sold`
--

LOCK TABLES `table_sold` WRITE;
/*!40000 ALTER TABLE `table_sold` DISABLE KEYS */;
INSERT INTO `table_sold` VALUES (1,'2021-12-09',21,'test'),(2,'2021-12-09',23,'test'),(3,'2021-12-09',32,'test');
/*!40000 ALTER TABLE `table_sold` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `table_user`
--

DROP TABLE IF EXISTS `table_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `table_user` (
  `seqnum` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(100) CHARACTER SET utf8 NOT NULL,
  `user_password` varchar(200) COLLATE utf8_bin NOT NULL,
  `user_name` varchar(20) COLLATE utf8_bin NOT NULL,
  `user_zipcode` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `user_address1` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `user_address2` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `user_tel` varchar(11) COLLATE utf8_bin DEFAULT NULL,
  `user_email` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `user_role` varchar(15) COLLATE utf8_bin NOT NULL,
  `provider` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`seqnum`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `table_user`
--

LOCK TABLES `table_user` WRITE;
/*!40000 ALTER TABLE `table_user` DISABLE KEYS */;
INSERT INTO `table_user` VALUES (0,'manager','1234','manager',NULL,NULL,NULL,NULL,NULL,'ROLE_MANAGER',NULL,NULL,NULL),(1,'test','test','test',NULL,NULL,NULL,NULL,NULL,'ROLE_USER',NULL,NULL,NULL),(8,'google_100489855763058338403','$2a$10$UNvfWko3LVJmSNF/OHNDSusld5PrLUKpeMHzvfV8S4rJT7tfNbrmi','Sunghee Hwang',NULL,NULL,NULL,NULL,'heeyaa.ott@gmail.com','ROLE_USER','google','2021-12-08','2021-12-08'),(9,'naver_o4fjNrLiqgOSISwKtt0lAdL2E_gDa03frVummKOjuRU','$2a$10$QFDGrgqY7kn0aThbraYj6.6PI7tpsA/Tcb/mR85LENCr2V2zdsRua','김예성',NULL,NULL,NULL,'01065850377','mitem714285@naver.com','ROLE_USER','naver','2021-12-08','2021-12-08'),(10,'google_108217885273618508917','$2a$10$hCSDs/m4jDfqkMxwV8.Pg.aRXCE/wsgoSRaTv0JXxetIwKGjZo2RG','M iTeM','12345','주소1','주소2','01065850377','mitem714285@gmail.com','ROLE_USER','google','2021-12-10','2021-12-10');
/*!40000 ALTER TABLE `table_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_board`
--

DROP TABLE IF EXISTS `tb_board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_board` (
  `idx` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `contents` text COLLATE utf8_bin,
  `image` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_board`
--

LOCK TABLES `tb_board` WRITE;
/*!40000 ALTER TABLE `tb_board` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_board` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-20 22:29:12
