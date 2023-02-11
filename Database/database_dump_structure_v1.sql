-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: medalite_schema
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `tblclinics`
--

DROP TABLE IF EXISTS `tblclinics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblclinics` (
  `ClinicID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Address` varchar(45) NOT NULL,
  `Phone` varchar(45) NOT NULL,
  `Web` varchar(45) DEFAULT NULL,
  `Logo` blob,
  `Notes` longtext,
  PRIMARY KEY (`ClinicID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbldiagnoses`
--

DROP TABLE IF EXISTS `tbldiagnoses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbldiagnoses` (
  `DiagnosisID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Code` varchar(45) NOT NULL,
  `Description` longtext,
  PRIMARY KEY (`DiagnosisID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbldoctors`
--

DROP TABLE IF EXISTS `tbldoctors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbldoctors` (
  `DoctorID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Title` varchar(45) NOT NULL,
  `Specialization` varchar(45) NOT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `Phone` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Username` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Notes` longtext,
  PRIMARY KEY (`DoctorID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tblpatients`
--

DROP TABLE IF EXISTS `tblpatients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblpatients` (
  `PatientID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Surname` varchar(45) NOT NULL,
  `ParentName` varchar(45) NOT NULL,
  `Birthdate` varchar(45) DEFAULT NULL,
  `PlaceOfBirth` varchar(45) DEFAULT NULL,
  `MbNo` varchar(45) NOT NULL,
  `Phone` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `EvidentionCode` varchar(45) NOT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `FamilyHistory` longtext,
  `CurrentDiseases` longtext,
  `Allergens` longtext,
  `Notes` longtext,
  PRIMARY KEY (`PatientID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tblreceptiondiagnoses`
--

DROP TABLE IF EXISTS `tblreceptiondiagnoses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblreceptiondiagnoses` (
  `ReceptionDiagnosisID` int NOT NULL AUTO_INCREMENT,
  `ReceptionID` int NOT NULL,
  `DiagnosisID` int NOT NULL,
  PRIMARY KEY (`ReceptionDiagnosisID`),
  KEY `DiagnosisID_idx` (`DiagnosisID`),
  KEY `ReceptionID2_idx` (`ReceptionID`),
  CONSTRAINT `tblreceptiondiagnoses_DiagnosisID` FOREIGN KEY (`DiagnosisID`) REFERENCES `tbldiagnoses` (`DiagnosisID`),
  CONSTRAINT `tblreceptiondiagnoses_ReceptionID` FOREIGN KEY (`ReceptionID`) REFERENCES `tblreceptions` (`ReceptionID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tblreceptiondocuments`
--

DROP TABLE IF EXISTS `tblreceptiondocuments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblreceptiondocuments` (
  `ReceptionDocumentID` int NOT NULL AUTO_INCREMENT,
  `ReceptionID` int NOT NULL,
  `Document` blob NOT NULL,
  `DocDate` date DEFAULT NULL,
  `Description` longtext,
  PRIMARY KEY (`ReceptionDocumentID`),
  KEY `ReceptionID_idx` (`ReceptionID`),
  CONSTRAINT `tblreceptiondocuments_ReceptionID` FOREIGN KEY (`ReceptionID`) REFERENCES `tblreceptions` (`ReceptionID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tblreceptions`
--

DROP TABLE IF EXISTS `tblreceptions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblreceptions` (
  `ReceptionID` int NOT NULL AUTO_INCREMENT,
  `PatientID` int NOT NULL,
  `DoctorID` int NOT NULL,
  `ServiceID` int NOT NULL,
  `ReceptionTime` datetime NOT NULL,
  `Anamnesis` longtext,
  `Opinion` longtext,
  `SuggestedTreatment` longtext,
  `Findings` longtext,
  `Conclusion` longtext,
  `ExpectedControlDate` date DEFAULT NULL,
  `Notes` longtext,
  `IsLocked` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`ReceptionID`),
  KEY `PatientID_idx` (`PatientID`),
  KEY `DoctorID_idx` (`DoctorID`),
  KEY `ServiceID_idx` (`ServiceID`),
  CONSTRAINT `tblreceptions_DoctorID` FOREIGN KEY (`DoctorID`) REFERENCES `tbldoctors` (`DoctorID`),
  CONSTRAINT `tblreceptions_PatientID` FOREIGN KEY (`PatientID`) REFERENCES `tblpatients` (`PatientID`),
  CONSTRAINT `tblreceptions_ServiceID` FOREIGN KEY (`ServiceID`) REFERENCES `tblservices` (`ServiceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tblreceptiontherapies`
--

DROP TABLE IF EXISTS `tblreceptiontherapies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblreceptiontherapies` (
  `ReceptionTherapyID` int NOT NULL AUTO_INCREMENT,
  `ReceptionID` int NOT NULL,
  `TherapyID` int NOT NULL,
  `Dose` varchar(45) NOT NULL,
  PRIMARY KEY (`ReceptionTherapyID`),
  KEY `tblReceptionTherapies_ReceptionID_idx` (`ReceptionID`),
  KEY `tblReceptionTherapies_TherapyID_idx` (`TherapyID`),
  CONSTRAINT `tblReceptionTherapies_ReceptionID` FOREIGN KEY (`ReceptionID`) REFERENCES `tblreceptions` (`ReceptionID`),
  CONSTRAINT `tblReceptionTherapies_TherapyID` FOREIGN KEY (`TherapyID`) REFERENCES `tbltherapies` (`TherapyID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tblservices`
--

DROP TABLE IF EXISTS `tblservices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblservices` (
  `ServiceID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Duration` varchar(45) DEFAULT NULL,
  `Notes` longtext,
  PRIMARY KEY (`ServiceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbltherapies`
--

DROP TABLE IF EXISTS `tbltherapies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbltherapies` (
  `TherapyID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `GenericName` varchar(45) DEFAULT NULL,
  `Code` varchar(45) DEFAULT NULL,
  `Description` longtext,
  PRIMARY KEY (`TherapyID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-11 19:20:52
