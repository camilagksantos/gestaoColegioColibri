-- MySQL dump 10.13  Distrib 8.0.34, for macos13 (arm64)
--
-- Host: 62.28.39.135    Database: bd_projeto_colegio_colibri
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aluno` (
  `id_aluno` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `apelido` varchar(45) NOT NULL,
  `idade` int NOT NULL,
  `email` varchar(45) NOT NULL,
  `turma_id` int NOT NULL,
  `login_id` int NOT NULL,
  PRIMARY KEY (`id_aluno`),
  KEY `fk_aluno_login_idx` (`login_id`),
  KEY `fk_aluno_turma_idx` (`turma_id`),
  CONSTRAINT `fk_aluno_login` FOREIGN KEY (`login_id`) REFERENCES `login` (`id_login`),
  CONSTRAINT `fk_aluno_turma` FOREIGN KEY (`turma_id`) REFERENCES `turma` (`id_turma`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (1,'Afonso','Figueiredo',24,'afonsof@email.com',6,24),(3,'João','Carlos',29,'jcarlos@email.com',5,25),(4,'Breno','Scafura',34,'brenos@email.com',7,26),(5,'João ','Gonçalves',27,'joaogoncalvespt@email.com',4,27),(6,'Felippe','Santana',29,'fesantana@email.com',7,28),(7,'Roberto','Felipe',26,'robertobeto@email.com',6,29),(8,'Diogo','Moura',28,'dimoura@email.com',5,30),(9,'João','Costa',25,'joca@email.com',4,31),(10,'Silvio','Zequini',28,'silviozequini@email.com',6,32),(11,'Hugo','Gomes',31,'hugoguinho@email.com',4,33),(12,'Fernanda','Vieira',34,'fervieiraemail.com',7,34),(13,'Raffael','Bittar',36,'raffabit@email.com',5,35),(14,'Widja','Queiroz',34,'widjaq@email.com',6,36),(15,'João','Cardoso',30,'joaocardoso@email.com',7,37),(16,'Nuno','Fernandes',25,'nunofernandes@email.com',4,38),(23,'Wesly','Cardoso',19,'weslycardoso@hotmail.com',4,39);
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disciplina`
--

DROP TABLE IF EXISTS `disciplina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `disciplina` (
  `id_disciplina` int NOT NULL AUTO_INCREMENT,
  `designacao` varchar(45) NOT NULL,
  PRIMARY KEY (`id_disciplina`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplina`
--

LOCK TABLES `disciplina` WRITE;
/*!40000 ALTER TABLE `disciplina` DISABLE KEYS */;
INSERT INTO `disciplina` VALUES (1,'Português'),(2,'Matematica'),(3,'Ciência'),(4,'Ed. Física'),(5,'Inglês');
/*!40000 ALTER TABLE `disciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `id_funcionario` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `apelido` varchar(45) NOT NULL,
  `idade` int NOT NULL,
  `email` varchar(45) NOT NULL,
  `login_id` int NOT NULL,
  PRIMARY KEY (`id_funcionario`),
  KEY `fk_funcionario_login_idx` (`login_id`),
  CONSTRAINT `fk_funcionario_login` FOREIGN KEY (`login_id`) REFERENCES `login` (`id_login`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'Camila','Santos',33,'camila@email.com',1),(2,'Marcos','Alvarães',40,'marcos@colegiocolibri.com',2),(3,'Rui','Boticas',40,'rui@colegiocolibri.com',21),(4,'Paulo','Jorge',40,'paulo@colegiocolibri@colegiocolibri.com',22),(5,'Sandra','Garin',40,'sandra@colegiocolibri.com',23);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `id_login` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` enum('ALUNO','PROFESSOR','DIRETOR') NOT NULL,
  PRIMARY KEY (`id_login`),
  UNIQUE KEY `user_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'camilasantos','dircamila','DIRETOR'),(2,'marcosalvaraes','profmarcos','PROFESSOR'),(21,'ruiboticas','profrui','PROFESSOR'),(22,'paulojorge','profpaulo','PROFESSOR'),(23,'sandragarin','sandragarin','PROFESSOR'),(24,'afonsofigueiredo','123','ALUNO'),(25,'joaocarlos','123','ALUNO'),(26,'brenoscafura','123','ALUNO'),(27,'joaogoncalves','123','ALUNO'),(28,'felippesantana','123','ALUNO'),(29,'robertofelipe','123','ALUNO'),(30,'diogomoura','123','ALUNO'),(31,'joaocosta','123','ALUNO'),(32,'silviozaquini','123','ALUNO'),(33,'hugogomes','123','ALUNO'),(34,'fernandavieira','123','ALUNO'),(35,'raffaelbittar','123','ALUNO'),(36,'widjaqueiroz','123','ALUNO'),(37,'joaocardoso','123','ALUNO'),(38,'nunofernandes','123','ALUNO'),(39,'weslycardoso','123','ALUNO');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nota`
--

DROP TABLE IF EXISTS `nota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nota` (
  `id_nota` int NOT NULL AUTO_INCREMENT,
  `aluno_id` int NOT NULL,
  `disciplina_id` int NOT NULL,
  `periodo_id` int NOT NULL,
  `data_atribuicao` date DEFAULT NULL,
  `nota` double DEFAULT NULL,
  PRIMARY KEY (`id_nota`),
  KEY `fk_disciplina_nota_idx` (`disciplina_id`),
  KEY `fk_nota_aluno_idx` (`aluno_id`),
  KEY `fk_nota_periodo_idx` (`periodo_id`),
  CONSTRAINT `fk_nota_aluno` FOREIGN KEY (`aluno_id`) REFERENCES `aluno` (`id_aluno`),
  CONSTRAINT `fk_nota_disciplina` FOREIGN KEY (`disciplina_id`) REFERENCES `disciplina` (`id_disciplina`),
  CONSTRAINT `fk_nota_periodo` FOREIGN KEY (`periodo_id`) REFERENCES `periodo` (`id_periodo`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nota`
--

LOCK TABLES `nota` WRITE;
/*!40000 ALTER TABLE `nota` DISABLE KEYS */;
INSERT INTO `nota` VALUES (1,5,1,4,'2023-12-15',18),(2,5,2,4,'2023-12-15',12.75),(6,5,3,4,'2023-12-15',20),(7,5,4,4,'2023-12-15',15),(8,5,5,4,'2023-12-15',20),(9,9,1,4,'2023-12-15',11),(10,9,2,4,'2023-12-15',17),(11,9,3,4,'2023-12-15',8),(12,9,4,4,'2023-12-15',13.25),(13,9,5,4,'2023-12-15',12),(14,11,1,4,'2023-12-15',19.5),(15,11,2,4,'2023-12-15',20),(16,11,3,4,'2023-12-15',9.5),(17,11,4,4,'2023-12-15',16),(18,11,5,4,'2023-12-15',13),(19,16,1,4,'2023-12-15',16.5),(20,16,2,4,'2023-12-15',14),(21,16,3,4,'2023-12-15',10),(22,16,4,4,'2023-12-15',20),(23,16,5,4,'2023-12-15',11.75),(28,3,1,4,'2023-12-15',13),(29,3,2,4,'2023-12-15',18),(30,3,3,4,'2023-12-15',17.25),(31,3,4,4,'2023-12-15',13),(32,3,5,4,'2023-12-15',20),(33,8,1,4,'2023-12-15',20),(34,8,2,4,'2023-12-15',18),(35,8,3,4,'2023-12-15',7.5),(36,8,4,4,'2023-12-15',11),(37,8,5,4,'2023-12-15',15.25),(38,13,1,4,'2023-12-15',20),(39,13,2,4,'2023-12-15',20),(40,13,3,4,'2023-12-15',16),(41,13,4,4,'2023-12-15',17.5),(42,13,5,4,'2023-12-15',17),(43,1,1,4,'2023-12-15',0),(44,1,2,4,'2023-12-15',12.25),(45,1,3,4,'2023-12-15',20),(46,1,4,4,'2023-12-15',20),(47,1,5,4,'2023-12-15',11),(48,7,1,4,'2023-12-15',13.5),(49,7,2,4,'2023-12-15',18),(50,7,3,4,'2023-12-15',19),(51,7,4,4,'2023-12-15',9),(52,7,5,4,'2023-12-15',9),(53,10,1,4,'2023-12-15',13),(54,10,2,4,'2023-12-15',12.5),(55,10,3,4,'2023-12-15',20),(56,10,4,4,'2023-12-15',18),(57,10,5,4,'2023-12-15',10),(58,14,1,4,'2023-12-15',18),(59,14,2,4,'2023-12-15',10.25),(60,14,3,4,'2023-12-15',19),(61,14,4,4,'2023-12-15',14),(62,14,5,4,'2023-12-15',13),(63,4,1,4,'2023-12-15',8),(64,4,2,4,'2023-12-15',9),(65,4,3,4,'2023-12-15',15.75),(66,4,4,4,'2023-12-15',16),(67,4,5,4,'2023-12-15',17),(68,6,1,4,'2023-12-15',20),(69,6,2,4,'2023-12-15',17.5),(70,6,3,4,'2023-12-15',10),(71,6,4,4,'2023-12-15',20),(72,6,5,4,'2023-12-15',16.5),(73,12,1,4,'2023-12-15',20),(74,12,2,4,'2023-12-15',13),(75,12,3,4,'2023-12-15',18),(76,12,4,4,'2023-12-15',10),(77,12,5,4,'2023-12-15',12.75),(78,15,1,4,'2023-12-15',18),(79,15,2,4,'2023-12-15',18),(80,15,3,4,'2023-12-15',16),(81,15,4,4,'2023-12-15',18.25),(82,15,5,4,'2023-12-15',20),(93,15,1,5,'2024-03-20',16.75),(94,15,2,5,'2024-03-20',12.5),(95,15,3,5,'2024-03-20',20),(96,15,4,5,'2024-03-20',7.75),(97,15,5,5,'2024-03-20',17),(98,15,1,6,'2024-06-18',9),(99,15,2,6,'2024-06-18',20),(100,15,3,6,'2024-06-18',17.25),(101,15,4,6,'2024-06-18',15.5),(102,15,5,6,'2024-06-18',18);
/*!40000 ALTER TABLE `nota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `periodo`
--

DROP TABLE IF EXISTS `periodo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `periodo` (
  `id_periodo` int NOT NULL AUTO_INCREMENT,
  `designacao` varchar(45) NOT NULL,
  PRIMARY KEY (`id_periodo`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `periodo`
--

LOCK TABLES `periodo` WRITE;
/*!40000 ALTER TABLE `periodo` DISABLE KEYS */;
INSERT INTO `periodo` VALUES (4,'1º Período'),(5,'2º Período'),(6,'3º Período');
/*!40000 ALTER TABLE `periodo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turma`
--

DROP TABLE IF EXISTS `turma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `turma` (
  `id_turma` int NOT NULL AUTO_INCREMENT,
  `designacao` varchar(45) NOT NULL,
  `professor_id` int NOT NULL,
  PRIMARY KEY (`id_turma`),
  KEY `fk_turma_funcionario_idx` (`professor_id`),
  CONSTRAINT `fk_turma_funcionario` FOREIGN KEY (`professor_id`) REFERENCES `funcionario` (`id_funcionario`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turma`
--

LOCK TABLES `turma` WRITE;
/*!40000 ALTER TABLE `turma` DISABLE KEYS */;
INSERT INTO `turma` VALUES (4,'1º Ano',3),(5,'2º Ano',2),(6,'3º Ano',5),(7,'4º Ano',4);
/*!40000 ALTER TABLE `turma` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-10 21:22:08
