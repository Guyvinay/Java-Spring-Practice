-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: Sb101_B26
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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `tid` int NOT NULL,
  `name` varchar(20) NOT NULL,
  `amount` int NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'Dinesh',2500,'dinesh@ms.com'),(2,'Jayesh',5500,'jayesh@ms.com');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bankcustomer`
--

DROP TABLE IF EXISTS `bankcustomer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bankcustomer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `annualIncome` double NOT NULL,
  `home_city` varchar(255) DEFAULT NULL,
  `home_state` varchar(255) DEFAULT NULL,
  `home_zipcode` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `office_city` varchar(255) DEFAULT NULL,
  `office_state` varchar(255) DEFAULT NULL,
  `office_zipcode` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bankcustomer`
--

LOCK TABLES `bankcustomer` WRITE;
/*!40000 ALTER TABLE `bankcustomer` DISABLE KEYS */;
INSERT INTO `bankcustomer` VALUES (1,8,'Sikar','Rajasthan',303002,'Satya','Jaipur','Rajasthan',302002);
/*!40000 ALTER TABLE `bankcustomer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_table`
--

DROP TABLE IF EXISTS `book_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_table` (
  `book_id` int NOT NULL AUTO_INCREMENT,
  `author` varchar(40) NOT NULL,
  `price` decimal(7,2) NOT NULL,
  `publish_date` date DEFAULT NULL,
  `title` varchar(75) NOT NULL,
  PRIMARY KEY (`book_id`),
  UNIQUE KEY `UK_16qel17fc0mnqcv5adw9sfpuv` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_table`
--

LOCK TABLES `book_table` WRITE;
/*!40000 ALTER TABLE `book_table` DISABLE KEYS */;
INSERT INTO `book_table` VALUES (2,'ABC',499.00,'2023-01-02','LifeStyle');
/*!40000 ALTER TABLE `book_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `cat_id` int NOT NULL,
  `cat_name` varchar(20) NOT NULL,
  PRIMARY KEY (`cat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Electronics'),(2,'Stationary'),(3,'Furniture'),(4,'Food Items'),(5,'House-keeping Goods');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `zipcode` int NOT NULL,
  `annualIncome` double NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Jaipur','Rajasthan',302002,20,'ABC');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `defaulter_addres`
--

DROP TABLE IF EXISTS `defaulter_addres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `defaulter_addres` (
  `defaulter_customer_id` int NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `zipcode` int NOT NULL,
  KEY `FKpi4d055tmx5a8wk9jayb7m23f` (`defaulter_customer_id`),
  CONSTRAINT `FKpi4d055tmx5a8wk9jayb7m23f` FOREIGN KEY (`defaulter_customer_id`) REFERENCES `defaultercustomer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `defaulter_addres`
--

LOCK TABLES `defaulter_addres` WRITE;
/*!40000 ALTER TABLE `defaulter_addres` DISABLE KEYS */;
INSERT INTO `defaulter_addres` VALUES (1,'Sikar','Rajasthan',303002),(1,'Jaipur','Rajasthan',302002);
/*!40000 ALTER TABLE `defaulter_addres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `defaultercustomer`
--

DROP TABLE IF EXISTS `defaultercustomer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `defaultercustomer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `annualIncome` double NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `defaultercustomer`
--

LOCK TABLES `defaultercustomer` WRITE;
/*!40000 ALTER TABLE `defaultercustomer` DISABLE KEYS */;
INSERT INTO `defaultercustomer` VALUES (1,15,'Anu');
/*!40000 ALTER TABLE `defaultercustomer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `Eid` varchar(4) NOT NULL,
  `Ename` varchar(10) NOT NULL,
  `Dept` varchar(10) NOT NULL,
  `Salary` int DEFAULT NULL,
  `Designation` varchar(10) NOT NULL,
  PRIMARY KEY (`Eid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('E001','ABC','SALES',25000,'SM'),('E002','PQR','SALES',35000,'SM'),('E003','RTY','HRM',58000,'SSM'),('E004','RED','HRM',38000,'HR'),('E005','YUT','BDO',25000,'BM'),('E006','RFT','BDO',48000,'BM');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `my_employee`
--

DROP TABLE IF EXISTS `my_employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `my_employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `designation` varchar(30) NOT NULL,
  `gender` enum('FEMALE','MALE') DEFAULT NULL,
  `emp_name` varchar(50) NOT NULL,
  `salary` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1208 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `my_employee`
--

LOCK TABLES `my_employee` WRITE;
/*!40000 ALTER TABLE `my_employee` DISABLE KEYS */;
INSERT INTO `my_employee` VALUES (1201,'Technical Manager','MALE','Gopal',40000),(1202,'Proof Reader','FEMALE','Manisha',40000),(1203,'Technical Writer','FEMALE','Masthanvali',40000),(1204,'Technical Writer','MALE','Satish',30000),(1205,'Technical Writer','MALE','Krishna',30000),(1206,'Proof Reader','MALE','Kiran',35000);
/*!40000 ALTER TABLE `my_employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `pro_id` int NOT NULL,
  `pro_name` varchar(20) NOT NULL,
  `MRP` double(7,2) DEFAULT NULL,
  `MFG_DATE` date NOT NULL,
  `category_id` int DEFAULT NULL,
  PRIMARY KEY (`pro_id`),
  KEY `fk_cat_pro` (`category_id`),
  CONSTRAINT `fk_cat_pro` FOREIGN KEY (`category_id`) REFERENCES `category` (`cat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Parker Pen',349.00,'2022-06-16',2),(2,'Student Chair',1499.00,'2021-12-31',3),(3,'Dark Chocolate',399.00,'2022-04-30',4),(4,'Microwave Oven',10500.00,'2022-05-15',1),(5,'AC',34500.00,'2022-05-01',1),(6,'Footware',599.00,'2022-05-01',NULL),(7,'snacks',90.00,'2022-01-01',4);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soldier`
--

DROP TABLE IF EXISTS `soldier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `soldier` (
  `sol_id` varchar(4) NOT NULL,
  `sol_name` varchar(4) NOT NULL,
  `sol_age` int DEFAULT NULL,
  `col_id` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`sol_id`),
  KEY `fk_col_sol` (`col_id`),
  CONSTRAINT `fk_col_sol` FOREIGN KEY (`col_id`) REFERENCES `soldier` (`sol_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soldier`
--

LOCK TABLES `soldier` WRITE;
/*!40000 ALTER TABLE `soldier` DISABLE KEYS */;
INSERT INTO `soldier` VALUES ('S001','ABC',34,NULL),('S002','BCD',26,'S001'),('S003','CDE',28,'S001'),('S004','DEF',35,NULL),('S005','FGH',26,'S004');
/*!40000 ALTER TABLE `soldier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `st`
--

DROP TABLE IF EXISTS `st`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `st` (
  `rollNo` int NOT NULL,
  `name` varchar(20) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `x_per` double(5,2) DEFAULT '33.00',
  `state` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`rollNo`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `st`
--

LOCK TABLES `st` WRITE;
/*!40000 ALTER TABLE `st` DISABLE KEYS */;
INSERT INTO `st` VALUES (1,'ABC','abc@ms.com',77.42,'Karnataka'),(2,'BCD','bcd@ms.com',33.00,'Rajasthan'),(3,'CDE','cde@ms.com',77.24,'Maharashtra'),(4,'def','def@ms.com',74.69,'West Bengal'),(5,'efg','efg@ms.com',66.00,'kerela'),(6,'fgh','fgh@ms.com',33.00,'Delhi'),(7,'ghi','ghi@ms.com',33.00,'Punjab'),(8,'ijk','ijk@ms.com',79.36,'Haryana'),(10,'AED','noname@unknown.com',0.00,'Karnataka'),(11,'PQR','pqr@gmail.com',79.36,'Himachal Pradesh'),(12,'YTR','yrt@ms.in',56.25,'Rajasthan');
/*!40000 ALTER TABLE `st` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `roll` int NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `marks` int DEFAULT NULL,
  PRIMARY KEY (`roll`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (10,'ABC',450),(11,'BCD',500),(12,'QAZ',475);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-07 14:04:19
