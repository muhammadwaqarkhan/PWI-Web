-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: pwi
-- ------------------------------------------------------
-- Server version	5.1.53-community-log

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `addressID` bigint(20) NOT NULL AUTO_INCREMENT,
  `street` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `postCode` varchar(100) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`addressID`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (2,NULL,'lahore','5400','pakistan'),(3,NULL,'lahore','5400','pakistan'),(4,NULL,'lahore','5400','pakistan'),(18,NULL,'lahore','5400','pakistan'),(21,NULL,'lahore','5400','pakistan'),(23,NULL,'lahore','5400','pakistan'),(24,NULL,'lahore','5400','pakistan'),(25,NULL,'lahore','5400','pakistan'),(28,NULL,'lahore','5400','pakistan'),(29,NULL,'Abu Dhabi',NULL,'USA'),(30,NULL,'Abu Dhabi',NULL,'USA'),(31,NULL,'Abu Dhabi',NULL,'USA'),(32,NULL,'Abu Dhabi',NULL,'USA'),(33,NULL,'Abu Dhabi',NULL,'USA'),(34,NULL,'Abu Dhabi',NULL,'USA'),(35,NULL,'Abu Dhabi',NULL,'USA'),(36,NULL,'Abu Dhabi',NULL,'USA'),(37,NULL,'Abu Dhabi',NULL,'USA'),(38,NULL,'Abu Dhabi',NULL,'USA'),(39,NULL,'waqar',NULL,'waqar'),(40,NULL,'Abu Dhabi',NULL,'USA'),(41,NULL,'rohaan',NULL,'rohaan'),(42,NULL,'Def',NULL,'USA'),(43,NULL,'Abu Dhabi',NULL,'USA'),(44,NULL,'Abu Dhabi',NULL,'USA'),(45,NULL,'Abu Dhabi',NULL,'USA'),(46,NULL,'Abu Dhabi',NULL,'waqar'),(47,NULL,'rohaan',NULL,'USA'),(48,NULL,'rohaan',NULL,'USA'),(49,NULL,'rohaan',NULL,'USA'),(50,NULL,'rohaan',NULL,'USA'),(52,'street','clity','postal','country'),(83,'','','',''),(84,'','','',''),(85,'','','',''),(86,'','','',''),(87,'','','',''),(88,'','','',''),(89,'','','',''),(90,'','','',''),(91,'123 6th St','Melbourne','32904','USA'),(92,'456 street','Dublin','54000','Ireland'),(93,'87 Street','Dubai','60000','UAE'),(94,'store 1 stree','California','67000','USA'),(95,'store 2 street','Stockton','68000','USA'),(96,'Store 3 street','Ireland','69000','Ireland'),(97,'store 2 street','Henderson','70000','Ireland'),(98,'Dubai stree1','Dubai','71000','UAE');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `branch` (
  `branchID` bigint(20) NOT NULL AUTO_INCREMENT,
  `branchName` varchar(45) DEFAULT NULL,
  `addressID` bigint(20) DEFAULT NULL,
  `status` int(1) DEFAULT '1',
  `companyID` bigint(20) NOT NULL,
  PRIMARY KEY (`branchID`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch`
--

LOCK TABLES `branch` WRITE;
/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
INSERT INTO `branch` VALUES (44,'USA Branch',91,1,11),(45,'Ireland Branch',92,1,11),(46,'Dubai Branch',93,1,11);
/*!40000 ALTER TABLE `branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brandproduct`
--

DROP TABLE IF EXISTS `brandproduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brandproduct` (
  `brandproductID` bigint(20) NOT NULL AUTO_INCREMENT,
  `brandID` bigint(20) NOT NULL,
  `productID` bigint(20) NOT NULL,
  PRIMARY KEY (`brandproductID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brandproduct`
--

LOCK TABLES `brandproduct` WRITE;
/*!40000 ALTER TABLE `brandproduct` DISABLE KEYS */;
INSERT INTO `brandproduct` VALUES (3,3,6),(4,3,7),(5,3,5);
/*!40000 ALTER TABLE `brandproduct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brands`
--

DROP TABLE IF EXISTS `brands`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brands` (
  `brandID` bigint(20) NOT NULL,
  `brandName` varchar(45) DEFAULT NULL,
  `companyID` bigint(20) NOT NULL,
  PRIMARY KEY (`brandID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brands`
--

LOCK TABLES `brands` WRITE;
/*!40000 ALTER TABLE `brands` DISABLE KEYS */;
INSERT INTO `brands` VALUES (3,'Brand1',0),(4,'Brand2',0);
/*!40000 ALTER TABLE `brands` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `companyID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) DEFAULT NULL,
  `status` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`companyID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (11,'Vantiboli','1');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lookup`
--

DROP TABLE IF EXISTS `lookup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lookup` (
  `lookUpID` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `code` varchar(15) DEFAULT NULL,
  `text` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`lookUpID`)
) ENGINE=InnoDB AUTO_INCREMENT=413 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lookup`
--

LOCK TABLES `lookup` WRITE;
/*!40000 ALTER TABLE `lookup` DISABLE KEYS */;
INSERT INTO `lookup` VALUES (410,'LKProductType','500','Finished Product'),(411,'LKProductType','501','Component'),(412,'LKProductType','502','Packaging Material');
/*!40000 ALTER TABLE `lookup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `productID` bigint(20) NOT NULL AUTO_INCREMENT,
  `productName` varchar(45) NOT NULL,
  `productType` varchar(45) DEFAULT NULL,
  `MOQ` bigint(20) DEFAULT NULL,
  `Size` bigint(20) DEFAULT NULL,
  `QPB` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`productID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (5,'ProductA','500',NULL,10,1),(6,'ProductB','20ml',NULL,10,1),(7,'ProductC','20ml',NULL,10,1),(9,'ProductD','500',NULL,22,22),(10,'ProductE','501',NULL,10,1),(11,'ProductF','500',NULL,10,1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store`
--

DROP TABLE IF EXISTS `store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `store` (
  `storeID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `addressID` bigint(20) DEFAULT NULL,
  `branchID` bigint(20) NOT NULL,
  PRIMARY KEY (`storeID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store`
--

LOCK TABLES `store` WRITE;
/*!40000 ALTER TABLE `store` DISABLE KEYS */;
INSERT INTO `store` VALUES (14,'Store1 USA','1',94,44),(15,'Store2 USA','1',95,44),(16,'Store 3 Ireland','1',96,45),(17,'Store 4 Ireland','1',97,45),(18,'Store 5 Dubai','1',98,46);
/*!40000 ALTER TABLE `store` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storeproduct`
--

DROP TABLE IF EXISTS `storeproduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storeproduct` (
  `storeProductID` bigint(20) NOT NULL AUTO_INCREMENT,
  `productID` bigint(20) NOT NULL,
  `storeID` bigint(20) NOT NULL,
  `quantity` bigint(20) DEFAULT '0',
  `reorderPoint` bigint(20) DEFAULT '0',
  `InTransit` bigint(20) DEFAULT '0',
  `instock` bigint(20) DEFAULT '0',
  PRIMARY KEY (`storeProductID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storeproduct`
--

LOCK TABLES `storeproduct` WRITE;
/*!40000 ALTER TABLE `storeproduct` DISABLE KEYS */;
INSERT INTO `storeproduct` VALUES (7,5,14,12,15,11,1),(9,5,15,12,15,11,1),(10,5,16,12,15,11,1),(11,5,18,12,15,11,1);
/*!40000 ALTER TABLE `storeproduct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `storeproductview`
--

DROP TABLE IF EXISTS `storeproductview`;
/*!50001 DROP VIEW IF EXISTS `storeproductview`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `storeproductview` AS SELECT 
 1 AS `quantity`,
 1 AS `instock`,
 1 AS `reorderPoint`,
 1 AS `storeID`,
 1 AS `productID`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `useraccounts`
--

DROP TABLE IF EXISTS `useraccounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `useraccounts` (
  `userid` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(500) NOT NULL,
  `firstname` varchar(100) DEFAULT NULL,
  `lastname` varchar(100) DEFAULT NULL,
  `islock` varchar(1) DEFAULT NULL,
  `lang` varchar(100) DEFAULT NULL,
  `timeZone` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `useraccounts`
--

LOCK TABLES `useraccounts` WRITE;
/*!40000 ALTER TABLE `useraccounts` DISABLE KEYS */;
INSERT INTO `useraccounts` VALUES (1,'waqar','waqar','waqar','waqar','1','en',''),(2,'Vantiboli','Vantiboli','Vantiboli','Vantiboli','1','en','');
/*!40000 ALTER TABLE `useraccounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `storeproductview`
--

/*!50001 DROP VIEW IF EXISTS `storeproductview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `storeproductview` AS select `sp`.`quantity` AS `quantity`,`sp`.`instock` AS `instock`,`sp`.`reorderPoint` AS `reorderPoint`,`sp`.`storeID` AS `storeID`,`sp`.`productID` AS `productID` from ((`product` `p` join `storeproduct` `sp` on((`p`.`productID` = `sp`.`productID`))) join `store` `s` on((`s`.`storeID` = `sp`.`storeID`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-21 12:56:56
