-- MySQL dump 10.13  Distrib 8.0.22-13, for Linux (x86_64)
--
-- Host: localhost    Database: bhhznvmtyir2pzxf7lun
-- ------------------------------------------------------
-- Server version	8.0.22-13

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
/*!50717 SELECT COUNT(*) INTO @rocksdb_has_p_s_session_variables FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'performance_schema' AND TABLE_NAME = 'session_variables' */;
/*!50717 SET @rocksdb_get_is_supported = IF (@rocksdb_has_p_s_session_variables, 'SELECT COUNT(*) INTO @rocksdb_is_supported FROM performance_schema.session_variables WHERE VARIABLE_NAME=\'rocksdb_bulk_load\'', 'SELECT 0') */;
/*!50717 PREPARE s FROM @rocksdb_get_is_supported */;
/*!50717 EXECUTE s */;
/*!50717 DEALLOCATE PREPARE s */;
/*!50717 SET @rocksdb_enable_bulk_load = IF (@rocksdb_is_supported, 'SET SESSION rocksdb_bulk_load = 1', 'SET @rocksdb_dummy_bulk_load = 0') */;
/*!50717 PREPARE s FROM @rocksdb_enable_bulk_load */;
/*!50717 EXECUTE s */;
/*!50717 DEALLOCATE PREPARE s */;

--
-- Table structure for table `educacion`
--

DROP TABLE IF EXISTS `educacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `educacion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion_ed` varchar(255) DEFAULT NULL,
  `duracion_ed` varchar(255) DEFAULT NULL,
  `nombre_ed` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `educacion`
--

LOCK TABLES `educacion` WRITE;
/*!40000 ALTER TABLE `educacion` DISABLE KEYS */;
INSERT INTO `educacion` VALUES (1,'Bachillerato de ciencias naturales, Participación en la Olimpíada Argentina de Ciencias Junior, Trabajo en conjunto con el IFIR CONICET-UNR Instituto de Física Rosario','2005-2017','Colegio Santísimo Rosario'),(2,'Estudiante 4to año de la carrera Ing. Industrial en la Universidad Católica Argentina','2018-2022',' Ingeniería Industrial'),(3,'Realizado en CoderHouse, contenidos; html, css, sass, git, github, seo, Bootstrap y hosting de sitios web','2022 (2 meses)','Curso Desarrollo Web'),(4,'Realizado en CoderHouse, contenidos: sintaxis y variables, Control de flujos, Ciclos/Iteraciones, Programación con funciones, Objetos, Arrays, DOM, Eventos y Storage','2023 (2 meses)','Curso JavaScript'),(7,'Desarrollado por el I.N.T.I. El mismo abarca la construcción de un frontend con Angular, la compresión de las bases de datos MySQL y el desarrollo de un backend utilizando Java con Spring Boot','2022-2023','Curso Arg Programa');
/*!40000 ALTER TABLE `educacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `experiencia`
--

DROP TABLE IF EXISTS `experiencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `experiencia` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcione` varchar(255) DEFAULT NULL,
  `duracione` varchar(255) DEFAULT NULL,
  `nombree` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `experiencia`
--

LOCK TABLES `experiencia` WRITE;
/*!40000 ALTER TABLE `experiencia` DISABLE KEYS */;
INSERT INTO `experiencia` VALUES (1,'Atención al público en una tienda saludable','2015-2017','Comercio Familiar'),(2,'Construcción de sitios web de manera freelance para trabajadores independientes, comercios o pequeñas empresas, desde landing page a ecommerce','2023-actualidad','Desarrollo de Sitios Web');
/*!40000 ALTER TABLE `experiencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hys`
--

DROP TABLE IF EXISTS `hys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hys` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `porcentaje` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hys`
--

LOCK TABLES `hys` WRITE;
/*!40000 ALTER TABLE `hys` DISABLE KEYS */;
INSERT INTO `hys` VALUES (1,'Html',95),(3,'css',89),(4,'JavaScript',80),(5,'Angular',78),(6,'Java',70),(7,'Pensamiento crítico',80),(8,'Flexibilidad/Adaptación',71),(9,'Perseverancia',82);
/*!40000 ALTER TABLE `hys` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `apellido` varchar(50) NOT NULL,
  `img` varchar(255) DEFAULT NULL,
  `nombre` varchar(50) NOT NULL,
  `subtitulo` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'Elizondo Rios','https://i.ibb.co/x5JWSDG/fotoperfil.png','Iñaki Cruz','Full stack developer');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyectos`
--

DROP TABLE IF EXISTS `proyectos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proyectos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descrip` varchar(255) NOT NULL,
  `img` varchar(255) NOT NULL,
  `linkgit` varchar(255) NOT NULL,
  `linkpreview` varchar(255) NOT NULL,
  `tech` varchar(255) NOT NULL,
  `titulo` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyectos`
--

LOCK TABLES `proyectos` WRITE;
/*!40000 ALTER TABLE `proyectos` DISABLE KEYS */;
INSERT INTO `proyectos` VALUES (1,' Proyecto final del curso Desarrollo web, simula un sitio estático para una concesionaria de vehículos ','https://i.ibb.co/pyfthfF/olympo-Car2recort.png','https://github.com/CruzElizorios/OlympoCar','https://cruzelizorios.github.io/OlympoCar/','Html, CSS, SCSS, Bootstrap 5, wow js','Olympo Car'),(2,'Aplicación full stack, se realizo un CRUD donde todo el contenido del mismo puede ser editado desde la web','https://i.ibb.co/10HjwYT/mi-Portfoliorecort.png','https://github.com/CruzElizorios/portfolio-FrontEnd-ArgPrograma','https://portfoliofronticruz.web.app','Angular, MySQL, Java, Spring Boot','Mi Portfolio'),(3,'Simulación de una tienda de electrónica construida principalmente con JS, proyecto final CoderHouse','https://i.ibb.co/W3Sf55p/tienda-Electronica-Recort.png','https://github.com/CruzElizorios/Near-Tecnology','https://cruzelizorios.github.io/Near-Tecnology/','Html, CSS, JavaScript','Near Tecnology');
/*!40000 ALTER TABLE `proyectos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `id` int NOT NULL AUTO_INCREMENT,
  `rol_nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sobremi`
--

DROP TABLE IF EXISTS `sobremi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sobremi` (
  `id` int NOT NULL AUTO_INCREMENT,
  `info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sobremi`
--

LOCK TABLES `sobremi` WRITE;
/*!40000 ALTER TABLE `sobremi` DISABLE KEYS */;
INSERT INTO `sobremi` VALUES (1,'Soy estudiante de programación web full stack con 22 años de edad. Me apasiona el desarrollo web y me gustaría trabajar en proyectos innovadores y desafiantes. Tengo experiencia en HTML, CSS, JavaScript, Java y frameworks. '),(2,'Además de la programación, Tengo otras habilidades y aficiones que me hacen una persona versátil y creativa. Soy primer Dan en Taekwondo, arte marcial que me enseña disciplina y perseverancia, toco el piano y me interesa la ciencia. '),(3,'También estudié cuatro años de ingeniería industrial, lo que me dio una base sólida en matemáticas, física y gestión de proyectos'),(4,' En este portfolio podrás ver algunos de mis trabajos y proyectos personales que demuestran mi capacidad y potencial como desarrollador web. Espero que te guste mi perfil y que podamos colaborar en el futuro.\n');
/*!40000 ALTER TABLE `sobremi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `nombre_usuario` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_puhr3k3l7bj71hb7hk7ktpxn0` (`nombre_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'admin@gmail.com','admin','admin','$2a$10$9GPqFQLlK.XLdmMWR1gD6.PeJqihomHQGXVd0z/aHlZOD/CHpmE.W');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_rol`
--

DROP TABLE IF EXISTS `usuario_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_rol` (
  `usuario_id` int NOT NULL,
  `rol_id` int NOT NULL,
  PRIMARY KEY (`usuario_id`,`rol_id`),
  KEY `FK610kvhkwcqk2pxeewur4l7bd1` (`rol_id`),
  CONSTRAINT `FK610kvhkwcqk2pxeewur4l7bd1` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`),
  CONSTRAINT `FKbyfgloj439r9wr9smrms9u33r` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_rol`
--

LOCK TABLES `usuario_rol` WRITE;
/*!40000 ALTER TABLE `usuario_rol` DISABLE KEYS */;
INSERT INTO `usuario_rol` VALUES (1,1),(1,2);
/*!40000 ALTER TABLE `usuario_rol` ENABLE KEYS */;
UNLOCK TABLES;
/*!50112 SET @disable_bulk_load = IF (@is_rocksdb_supported, 'SET SESSION rocksdb_bulk_load = @old_rocksdb_bulk_load', 'SET @dummy_rocksdb_bulk_load = 0') */;
/*!50112 PREPARE s FROM @disable_bulk_load */;
/*!50112 EXECUTE s */;
/*!50112 DEALLOCATE PREPARE s */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-17 19:56:33
