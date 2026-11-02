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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-10 21:20:43
