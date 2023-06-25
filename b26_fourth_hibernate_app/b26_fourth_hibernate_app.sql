-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: b26_fourth_hibernate_app
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `biostudent`
--

DROP TABLE IF EXISTS `biostudent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `biostudent` (
  `bioMarks` double NOT NULL,
  `bio_student_id` int NOT NULL,
  PRIMARY KEY (`bio_student_id`),
  CONSTRAINT `FK66i8lsupaeeovwuvy0p8xqhey` FOREIGN KEY (`bio_student_id`) REFERENCES `sciencestudent` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `biostudent`
--

LOCK TABLES `biostudent` WRITE;
/*!40000 ALTER TABLE `biostudent` DISABLE KEYS */;
INSERT INTO `biostudent` VALUES (85,1),(66,2);
/*!40000 ALTER TABLE `biostudent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commercialelectricityconnection`
--

DROP TABLE IF EXISTS `commercialelectricityconnection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commercialelectricityconnection` (
  `id` int NOT NULL,
  `unitCharges` double NOT NULL,
  `unitConsumed` int NOT NULL,
  `fixCharge` double NOT NULL,
  `valueAddedTax` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commercialelectricityconnection`
--

LOCK TABLES `commercialelectricityconnection` WRITE;
/*!40000 ALTER TABLE `commercialelectricityconnection` DISABLE KEYS */;
INSERT INTO `commercialelectricityconnection` VALUES (1,10,200,200,8),(2,9,300,250,9);
/*!40000 ALTER TABLE `commercialelectricityconnection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `domesticelectricityconnection`
--

DROP TABLE IF EXISTS `domesticelectricityconnection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `domesticelectricityconnection` (
  `id` int NOT NULL,
  `unitCharges` double NOT NULL,
  `unitConsumed` int NOT NULL,
  `electricityDuty` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domesticelectricityconnection`
--

LOCK TABLES `domesticelectricityconnection` WRITE;
/*!40000 ALTER TABLE `domesticelectricityconnection` DISABLE KEYS */;
INSERT INTO `domesticelectricityconnection` VALUES (3,6,250,150),(4,7.5,350,175);
/*!40000 ALTER TABLE `domesticelectricityconnection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `human`
--

DROP TABLE IF EXISTS `human`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `human` (
  `human_profession` varchar(31) NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `weight` double NOT NULL,
  `organizationName` varchar(255) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `course` varchar(255) DEFAULT NULL,
  `institutionName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `human`
--

LOCK TABLES `human` WRITE;
/*!40000 ALTER TABLE `human` DISABLE KEYS */;
INSERT INTO `human` VALUES ('EMP',1,'ABC',65.25,'ABC Company',9.6,NULL,NULL),('EMP',2,'XYZ',45.25,'XYZ Company',9.6,NULL,NULL),('ST',3,'BCD',48.25,NULL,NULL,'Java','Masai'),('ST',4,'YZA',45.63,NULL,NULL,'React','Masai');
/*!40000 ALTER TABLE `human` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mathstudent`
--

DROP TABLE IF EXISTS `mathstudent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mathstudent` (
  `mathMarks` double NOT NULL,
  `math_student_id` int NOT NULL,
  PRIMARY KEY (`math_student_id`),
  CONSTRAINT `FK6o7xmr5j2o096gdgq07yhc0i2` FOREIGN KEY (`math_student_id`) REFERENCES `sciencestudent` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mathstudent`
--

LOCK TABLES `mathstudent` WRITE;
/*!40000 ALTER TABLE `mathstudent` DISABLE KEYS */;
INSERT INTO `mathstudent` VALUES (95,3),(98,4);
/*!40000 ALTER TABLE `mathstudent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sciencestudent`
--

DROP TABLE IF EXISTS `sciencestudent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sciencestudent` (
  `id` int NOT NULL AUTO_INCREMENT,
  `chemistryMarks` double NOT NULL,
  `physicsMarks` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sciencestudent`
--

LOCK TABLES `sciencestudent` WRITE;
/*!40000 ALTER TABLE `sciencestudent` DISABLE KEYS */;
INSERT INTO `sciencestudent` VALUES (1,76,78),(2,73,85),(3,85,75),(4,65,85);
/*!40000 ALTER TABLE `sciencestudent` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-08 14:03:39
