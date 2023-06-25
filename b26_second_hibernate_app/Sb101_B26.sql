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