-- MySQL dump 10.13  Distrib 5.5.27, for Win32 (x86)
--
-- Host: localhost    Database: Dumbara1
-- ------------------------------------------------------
-- Server version	5.5.27

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
-- Current Database: `Dumbara1`
--

/*!40000 DROP DATABASE IF EXISTS `Dumbara1`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `dumbara1` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `Dumbara1`;

--
-- Table structure for table `agency`
--

DROP TABLE IF EXISTS `agency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agency` (
  `AgencyID` varchar(20) NOT NULL DEFAULT '',
  `AgencyName` varchar(100) DEFAULT NULL,
  `Address` varchar(200) DEFAULT NULL,
  `ContactNo` varchar(12) DEFAULT NULL,
  `OwnerName` varchar(100) DEFAULT NULL,
  `OwnerNo` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`AgencyID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agency`
--

LOCK TABLES `agency` WRITE;
/*!40000 ALTER TABLE `agency` DISABLE KEYS */;
INSERT INTO `agency` VALUES ('A0001','C&S Agent','Horana Sri Lanka','0772193303','Chanaka','0342255180'),('A0002','Nalaka Agency','Nawinna Sri Lanka','0112547896','Nslaka Kumara','0254789655'),('A0003','Madhu agency','Kandy Sri Lanka','0459874123','Madhushani Silva','0114569877');
/*!40000 ALTER TABLE `agency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agencyorder`
--

DROP TABLE IF EXISTS `agencyorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agencyorder` (
  `AgencyOrderID` varchar(20) NOT NULL DEFAULT '',
  `AgencyID` varchar(20) DEFAULT NULL,
  `OrderDate` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`AgencyOrderID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agencyorder`
--

LOCK TABLES `agencyorder` WRITE;
/*!40000 ALTER TABLE `agencyorder` DISABLE KEYS */;
INSERT INTO `agencyorder` VALUES ('AOID001','A002','2014/04/04'),('AOID002','A002','2014/04/05'),('AOID003','A0001','2014/04/07'),('AOID004','A0001','2014/04/07'),('AOID005','A0001','2014/04/08'),('AOID006','A0001','2014/04/08'),('AOID007','A0001','2014/04/08'),('AOID008','A0001','2014/04/08'),('AOID009','A0001','2014/04/12'),('AOID010','A0002','2014/04/09'),('AOID011','A0001','2014/04/25'),('AOID012','A0001','2014/04/25'),('AOID013','A0001','2014/04/26'),('AOID014','A0001','2014/04/26'),('AOID015','A0001','2014/04/26'),('AOID016','A0001','2014/04/26'),('AOID017','A0001','2014/04/29'),('AOID018','A0001','2014/04/30'),('AOID019','A0001','2014/04/26'),('AOID020','A0001','2014/04/30'),('AOID021','A0002','2014/05/03'),('AOID022','A0001','2014/05/03'),('AOID023','A0001','2014/05/04'),('AOID024','A0004','2014/05/06'),('AOID025','A0003','2014/05/10'),('AOID026','A0001','2014/05/11'),('AOID027','A0001','2014/05/24');
/*!40000 ALTER TABLE `agencyorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agencyorderdetail`
--

DROP TABLE IF EXISTS `agencyorderdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agencyorderdetail` (
  `AgencyOrderID` varchar(20) DEFAULT NULL,
  `BottleID` varchar(50) DEFAULT NULL,
  `Qty` varchar(40) DEFAULT NULL,
  `UnitPrice` varchar(50) DEFAULT NULL,
  `TotalPrice` varchar(50) DEFAULT NULL,
  KEY `AgencyOrderID` (`AgencyOrderID`),
  CONSTRAINT `agencyOrderDetail_ibfk_1` FOREIGN KEY (`AgencyOrderID`) REFERENCES `agencyorder` (`AgencyOrderID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agencyorderdetail`
--

LOCK TABLES `agencyorderdetail` WRITE;
/*!40000 ALTER TABLE `agencyorderdetail` DISABLE KEYS */;
INSERT INTO `agencyorderdetail` VALUES ('AOID001','BT05','4000','500','2000000.0'),('AOID001','BT02','200','120','24000.0'),('AOID002','BT05','5000','500','2500000.0'),('AOID002','BT03','100','250','25000.0'),('AOID003','BT05','100','500','50000.0'),('AOID003','BT02','422','120','50640.0'),('AOID004','BT02','100','120','12000.0'),('AOID004','BT05','500','500','250000.0'),('AOID005','BT01','200','52','10400.0'),('AOID005','BT05','10','450','4500.0'),('AOID006','BT01','500','52','26000.0'),('AOID006','BT02','100','90','9000.0'),('AOID007','BT03','200','120','24000.0'),('AOID007','BT04','100','200','20000.0'),('AOID008','BT01','500','52','26000.0'),('AOID008','BT02','1000','90','90000.0'),('AOID008','BT04','410','200','82000.0'),('AOID009','BT01','500','52','26000'),('AOID009','BT02','500','90','45000'),('AOID009','BT03','120','120','14400'),('AOID010','BT01','500','52','26000'),('AOID010','BT02','100','90','9000'),('AOID010','BT03','500','120','60000'),('AOID011','BT01','200','52','10400'),('AOID011','BT03','150','120','18000'),('AOID011','BT04','500','200','100000'),('AOID011','BT05','412','450','185400'),('AOID012','BT01','200','52','10400'),('AOID013','BT01','100','52','5200'),('AOID013','BT03','250','120','30000'),('AOID014','BT01','100','52','5200'),('AOID014','BT03','5000','120','600000'),('AOID015','BT01','150','52','7800'),('AOID015','BT02','520','90','46800'),('AOID016','BT02','100','90','9000'),('AOID016','BT03','255','120','30600'),('AOID017','BT01','250','52','13000'),('AOID017','BT03','300','120','36000'),('AOID018','BT02','100','90','9000'),('AOID018','BT04','450','200','90000'),('AOID019','BT01','105','52','5460'),('AOID019','BT05','200','450','90000'),('AOID020','BT01','250','52','13000'),('AOID020','BT04','463','200','92600'),('AOID021','BT01','200','52','10400'),('AOID021','BT04','50','200','10000'),('AOID022','BT02','500','90','45000'),('AOID022','BT04','400','200','80000'),('AOID023','BT01','500','52','26000'),('AOID023','BT03','1000','120','120000'),('AOID024','BT02','500','90','45000'),('AOID024','BT04','1500','200','300000'),('AOID025','BT02','500','90','45000'),('AOID025','BT04','1000','200','200000'),('AOID026','BT04','200','200','40000'),('AOID026','BT03','200','120','24000'),('AOID027','BT01','12','52','624'),('AOID027','BT04','20','200','4000');
/*!40000 ALTER TABLE `agencyorderdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attendence`
--

DROP TABLE IF EXISTS `attendence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendence` (
  `EmpID` varchar(20) DEFAULT NULL,
  `Date` varchar(100) DEFAULT NULL,
  `InTime` varchar(100) DEFAULT NULL,
  `OutTime` varchar(100) DEFAULT NULL,
  KEY `EmpID` (`EmpID`),
  CONSTRAINT `attendence_ibfk_1` FOREIGN KEY (`EmpID`) REFERENCES `employee` (`EmpID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `CustID` varchar(20) NOT NULL DEFAULT '',
  `Name` varchar(100) DEFAULT NULL,
  `Address` varchar(200) DEFAULT NULL,
  `Telno` varchar(12) DEFAULT NULL,
  `NIC` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`CustID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('C0001','Namal','Matara','0114789654','123654789v'),('C0002','Bhanaka','Panadura Sri Lanka','0112547896','123654789v'),('C0003','Shashini','Matara Sri Lanka','0712547896','369852147v');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email`
--

DROP TABLE IF EXISTS `email`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `email` (
  `email` varchar(250) DEFAULT NULL,
  `pwd` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email`
--

LOCK TABLES `email` WRITE;
/*!40000 ALTER TABLE `email` DISABLE KEYS */;
INSERT INTO `email` VALUES ('chanu1993@gmail.com','joomla1993');
/*!40000 ALTER TABLE `email` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emaildraft`
--

DROP TABLE IF EXISTS `emaildraft`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emaildraft` (
  `toMail` varchar(200) DEFAULT NULL,
  `subject` varchar(250) DEFAULT NULL,
  `msg` varchar(500) DEFAULT NULL,
  `sign` int(10) unsigned NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emaildraft`
--

LOCK TABLES `emaildraft` WRITE;
/*!40000 ALTER TABLE `emaildraft` DISABLE KEYS */;
/*!40000 ALTER TABLE `emaildraft` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `EmpID` varchar(20) NOT NULL DEFAULT '',
  `EmpName` varchar(100) DEFAULT NULL,
  `Address` varchar(200) DEFAULT NULL,
  `ContactNo` varchar(20) DEFAULT NULL,
  `DOB` varchar(80) DEFAULT NULL,
  `Age` varchar(12) DEFAULT NULL,
  `NIC` varchar(20) DEFAULT NULL,
  `AssignedDate` varchar(80) DEFAULT NULL,
  `Gender` varchar(45) DEFAULT NULL,
  `CivilStatus` varchar(50) DEFAULT NULL,
  `Nationality` varchar(50) DEFAULT NULL,
  `BloodGroup` varchar(20) DEFAULT NULL,
  `EmergencyCall` varchar(20) DEFAULT NULL,
  `EmpImage` longblob,
  `Salary` double DEFAULT NULL,
  PRIMARY KEY (`EmpID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `emptybottles`
--

DROP TABLE IF EXISTS `emptybottles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emptybottles` (
  `BottleID` varchar(50) NOT NULL DEFAULT '',
  `BottleVolume` varchar(50) DEFAULT NULL,
  `Qty` int(11) DEFAULT NULL,
  PRIMARY KEY (`BottleID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emptybottles`
--

LOCK TABLES `emptybottles` WRITE;
/*!40000 ALTER TABLE `emptybottles` DISABLE KEYS */;
INSERT INTO `emptybottles` VALUES ('BT01','500 ml',1859),('BT02','1 l',1850),('BT03','1.5 l',3170),('BT04','5 l',2130),('BT05','19 l',1100);
/*!40000 ALTER TABLE `emptybottles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `filledbottles`
--

DROP TABLE IF EXISTS `filledbottles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `filledbottles` (
  `BottleID` varchar(20) DEFAULT NULL,
  `BottleVolume` varchar(20) DEFAULT NULL,
  `ProducedDate` varchar(50) DEFAULT NULL,
  `ExpireDate` varchar(50) DEFAULT NULL,
  `InStockQty` varchar(50) DEFAULT NULL,
  `UnitPrice` varchar(50) DEFAULT NULL,
  KEY `BottleID` (`BottleID`),
  CONSTRAINT `filledBottles_ibfk_1` FOREIGN KEY (`BottleID`) REFERENCES `emptybottles` (`BottleID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `filledbottles`
--

LOCK TABLES `filledbottles` WRITE;
/*!40000 ALTER TABLE `filledbottles` DISABLE KEYS */;
INSERT INTO `filledbottles` VALUES ('BT01','500 ml','2014-04-08','2014-04-08','4500','52'),('BT02','1 l','2014-04-08','2014-04-08','5000','90'),('BT03','1.5 l','2014-04-08','2014-04-08','6000','120'),('BT04','5 l','2014-04-08','2014-04-08','7410','200'),('BT05','19 l','2014-04-08','2014-04-08','3210','450');
/*!40000 ALTER TABLE `filledbottles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forgetpwd`
--

DROP TABLE IF EXISTS `forgetpwd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forgetpwd` (
  `username` varchar(20) DEFAULT NULL,
  `ques1` varchar(200) DEFAULT NULL,
  `ques2` varchar(200) DEFAULT NULL,
  `ques3` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forgetpwd`
--

LOCK TABLES `forgetpwd` WRITE;
/*!40000 ALTER TABLE `forgetpwd` DISABLE KEYS */;
INSERT INTO `forgetpwd` VALUES ('shashi','shandy','shashi','pink'),('chanu','blaze','chanaka','red');
/*!40000 ALTER TABLE `forgetpwd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goodrecievednote`
--

DROP TABLE IF EXISTS `goodrecievednote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goodrecievednote` (
  `GRN_ID` varchar(50) NOT NULL DEFAULT '',
  `BOTTLEID` varchar(50) NOT NULL DEFAULT '',
  `GRN_Date` varchar(50) DEFAULT NULL,
  `SupplierOrderID` varchar(50) DEFAULT NULL,
  `BOTTLEVOLUME` varchar(50) DEFAULT NULL,
  `ORDERQTY` varchar(50) DEFAULT NULL,
  `RECIEVEDQTY` varchar(50) DEFAULT NULL,
  `VARIENCE` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`GRN_ID`,`BOTTLEID`),
  KEY `BOTTLEID` (`BOTTLEID`),
  KEY `SupplierOrderID` (`SupplierOrderID`),
  CONSTRAINT `goodRecievedNote_ibfk_1` FOREIGN KEY (`BOTTLEID`) REFERENCES `emptybottles` (`BottleID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `goodRecievedNote_ibfk_2` FOREIGN KEY (`SupplierOrderID`) REFERENCES `supplierorder` (`SupplierOrderID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goodrecievednote`
--

LOCK TABLES `goodrecievednote` WRITE;
/*!40000 ALTER TABLE `goodrecievednote` DISABLE KEYS */;
INSERT INTO `goodrecievednote` VALUES ('GRN0001','BT03','Sat Apr 05 00:00:00 PDT 2014','SOD0002','1.5 l','400','350','50'),('GRN0002','BT04','Sat Apr 05 00:00:00 PDT 2014','SOD0001','5 l','200','200','0'),('GRN0003','BT03','Sat Apr 05 00:00:00 PDT 2014','SOD0002','1.5 l','400','320','80'),('GRN0004','BT05','Sun Apr 06 00:00:00 PDT 2014','SOD0007','19 l','987','500','487'),('GRN0005','BT04','Sat Apr 05 00:00:00 PDT 2014','SOD0004','5 l','200','190','10'),('GRN0006','BT01','Sun Apr 06 00:00:00 PDT 2014','SOD0005','500 ml','200','100','100'),('GRN0007','BT04','Tue Apr 15 00:00:00 PDT 2014','SOD0004','5 l','200','150','50'),('GRN0008','BT04','Thu Apr 10 00:00:00 PDT 2014','SOD0004','5 l','200','140','60'),('GRN0009','BT02','Sat Apr 05 00:00:00 PDT 2014','SOD0005','1 l','500','400','100'),('GRN0010','BT04','Sun Apr 06 00:00:00 PDT 2014','SOD0001','5 l','200','150','50'),('GRN0011','BT04','Wed Apr 09 00:00:00 PDT 2014','SOD0004','5 l','200','200','0'),('GRN0012','BT01','Wed Apr 09 00:00:00 PDT 2014','SOD0004','500 ml','100','100','0'),('GRN0012','BT04','Wed Apr 09 00:00:00 PDT 2014','SOD0004','5 l','200','200','0'),('GRN0013','BT01','Mon Apr 07 00:00:00 PDT 2014','SOD0002','500 ml','200','120','80'),('GRN0013','BT03','Mon Apr 07 00:00:00 PDT 2014','SOD0002','1.5 l','400','400','0'),('GRN0014','BT02','Wed Apr 09 00:00:00 PDT 2014','SOD0017','1 l','500','100','400'),('GRN0014','BT03','Wed Apr 09 00:00:00 PDT 2014','SOD0017','1.5 l','1000','800','200'),('GRN0014','BT05','Wed Apr 09 00:00:00 PDT 2014','SOD0017','19 l','500','400','100'),('GRN0015','BT01','Sat May 03 00:00:00 PDT 2014','SOD0015','500 ml','200','159','41'),('GRN0015','BT02','Sat May 03 00:00:00 PDT 2014','SOD0015','1 l','100','100','0'),('GRN0015','BT03','Sat May 03 00:00:00 PDT 2014','SOD0015','1.5 l','320','300','20'),('GRN0016','BT01','Mon May 05 00:00:00 PDT 2014','SOD0024','500 ml','145','120','25'),('GRN0016','BT03','Mon May 05 00:00:00 PDT 2014','SOD0024','1.5 l','522','400','122'),('GRN0017','BT01','Sun May 04 00:00:00 PDT 2014','SOD0008','500 ml','100','50','50'),('GRN0017','BT03','Sun May 04 00:00:00 PDT 2014','SOD0008','1.5 l','200','150','50');
/*!40000 ALTER TABLE `goodrecievednote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interestrate`
--

DROP TABLE IF EXISTS `interestrate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `interestrate` (
  `Lowest` double NOT NULL DEFAULT '0',
  `Highest` double NOT NULL DEFAULT '0',
  `Rate` double NOT NULL DEFAULT '0',
  `RateID` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`RateID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interestrate`
--

LOCK TABLES `interestrate` WRITE;
/*!40000 ALTER TABLE `interestrate` DISABLE KEYS */;
INSERT INTO `interestrate` VALUES (1001,10001,5,'RID1'),(10001,25001,6,'RID2'),(25001,100001,7,'RID3'),(100001,250001,8,'RID4'),(250001,500001,10.5,'RID5');
/*!40000 ALTER TABLE `interestrate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventory` (
  `ItemCode` varchar(20) NOT NULL DEFAULT '',
  `ItemName` varchar(150) DEFAULT NULL,
  `ItemDesc` varchar(250) DEFAULT NULL,
  `BrandName` varchar(150) DEFAULT NULL,
  `Price` varchar(30) DEFAULT NULL,
  `SupplierName` varchar(150) DEFAULT NULL,
  `SupplierAddress` varchar(200) DEFAULT NULL,
  `SupplierContactNo` varchar(14) DEFAULT NULL,
  `PurchasedDate` varchar(50) DEFAULT NULL,
  `WarrantyPeriod` varchar(20) DEFAULT NULL,
  `WarrantyEndDate` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ItemCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` VALUES ('IT0001','Filter','UV Filter','Nissana','45000','Nalamal Suppliers','Padukka Sri Lanka\\','0778965412','Sat Apr 05 00:00:00 PDT 2014','5','Fri Feb 26 00:00:00 PST 2016'),('IT0002','Wrapper','Wrap all bottles','Noyona','45000','Q&Q Suppliers','Matara Sri Lanka','0974488563','Tue Apr 15 00:00:00 PDT 2014','5','Thu Mar 19 00:00:00 PDT 2015');
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loan`
--

DROP TABLE IF EXISTS `loan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loan` (
  `LoanID` varchar(20) NOT NULL DEFAULT '',
  `EmpID` varchar(20) DEFAULT NULL,
  `LoanAmount` varchar(30) DEFAULT NULL,
  `LoanTerm` varchar(30) DEFAULT NULL,
  `InterestRate` varchar(30) DEFAULT NULL,
  `MonthlyPayment` varchar(30) DEFAULT NULL,
  `DuePayment` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`LoanID`),
  KEY `EmpID` (`EmpID`),
  CONSTRAINT `loan_ibfk_1` FOREIGN KEY (`EmpID`) REFERENCES `employee` (`EmpID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loan`
--

LOCK TABLES `loan` WRITE;
/*!40000 ALTER TABLE `loan` DISABLE KEYS */;
INSERT INTO `loan` VALUES ('LN0001','E0001','50000','012','5','4,375.00','Full Amount'),('LN0002','E0001','100000','24.0','9','4,916.67','Full Amount'),('LN0003','E0003','50000','012','6','4,416.67','Full Amount'),('LN0004','E0001','5000','012','5','437.50','Full Amount'),('LN0005','E0001','50000','012','5','4,375.00','Full Amount'),('LN0006','E0003','50000','05','5','10,208.33','Full Amount'),('LN0007','E0001','50000','24.0','5','2,291.67','Full Amount'),('LN0008','E0002','50000','012','5','4,375.00','Full Amount'),('LN0009','E0002','240500','024','8.0','11,624.17 ','Full Amount'),('LN0010','E0004','50000','20','7.0','2,791.6','Full Amount'),('LN0011','E0003','456123','36.0','10.0','15000','Full Amount'),('LN0012','E0002','150000','24.0','8.0','7,250','Full Amount'),('LN0013','E0002','150000','24.0','8.0','7000','Full Amount');
/*!40000 ALTER TABLE `loan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loancount`
--

DROP TABLE IF EXISTS `loancount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loancount` (
  `slaryId` varchar(100) NOT NULL DEFAULT '',
  `lowest` double DEFAULT NULL,
  `highest` double DEFAULT NULL,
  `count` double DEFAULT NULL,
  PRIMARY KEY (`slaryId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loancount`
--

LOCK TABLES `loancount` WRITE;
/*!40000 ALTER TABLE `loancount` DISABLE KEYS */;
INSERT INTO `loancount` VALUES ('SA01',10001,15000,1),('SA02',15000,30000,2),('SA03',30000,50000,3),('SA04',50000,100000,4),('SA05',100001,500000,5);
/*!40000 ALTER TABLE `loancount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loansettle`
--

DROP TABLE IF EXISTS `loansettle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loansettle` (
  `LoanSettleID` varchar(20) NOT NULL DEFAULT '',
  `Payment` varchar(50) DEFAULT NULL,
  `LoanID` varchar(20) DEFAULT NULL,
  `LoanAmount` varchar(30) DEFAULT NULL,
  `DuePayment` varchar(50) DEFAULT NULL,
  `PaymentDate` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`LoanSettleID`),
  KEY `LoanID` (`LoanID`),
  CONSTRAINT `loanSettle_ibfk_1` FOREIGN KEY (`LoanID`) REFERENCES `loan` (`LoanID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loansettle`
--

LOCK TABLES `loansettle` WRITE;
/*!40000 ALTER TABLE `loansettle` DISABLE KEYS */;
INSERT INTO `loansettle` VALUES ('LS0001','5000','LN0002','100000','95000.0','2014/04/04'),('LS0002','1000','LN0002','100000','94000.0','2014/04/06'),('LS0003','5000','LN0001','50000','45000.0','2014/04/07'),('LS0004','5000','LN0005','50000','45000.0','2014/04/08'),('LS0005','7000','LN0005','50000','38000.0','2014/04/08'),('LS0006','6500','LN0002','100000','87500.0','2014/04/09'),('LS0007','8000','LN0002','100000','79500.0','2014/04/09'),('LS0008','8000','LN0006','50000','42000.0','2014/04/09'),('LS0009','6000','LN0006','50000','36000.0','2014/04/09'),('LS0010','10000','LN0009','240500','230500.0','2014/04/26'),('LS0011','10000','LN0009','240500','220500.0','2014/04/26'),('LS0012','2000','LN0010','50000','48000.0','2014/04/27'),('LS0013','5000','LN0001','50000','40000.0','2014/05/03'),('LS0014','80000','LN0012','150000','70000.0','2014/05/04'),('LS0015','6000','LN0012','150000','64000.0','2014/05/06'),('LS0016','5000','LN0005','50000','33000.0','2014/05/10'),('LS0017','5000','LN0007','50000','45000.0','2014/05/10'),('LS0018','4500','LN0007','50000','40500.0','2014/05/10'),('LS0019','10000','LN0009','240500','210500.0','2014/05/16');
/*!40000 ALTER TABLE `loansettle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questions` (
  `questionID` varchar(50) NOT NULL DEFAULT '',
  `question` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`questionID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES ('Q01','What is your first pet name ?'),('Q02','What is your first child name ?'),('Q03','What is your favourite color ?');
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sales` (
  `SalesID` varchar(50) NOT NULL DEFAULT '',
  `SalesDate` varchar(50) DEFAULT NULL,
  `AgencyID` varchar(50) DEFAULT NULL,
  `BottleID` varchar(50) DEFAULT NULL,
  `BottleVolume` varchar(50) DEFAULT NULL,
  `SaledQty` int(11) DEFAULT NULL,
  `Income` double DEFAULT NULL,
  PRIMARY KEY (`SalesID`),
  KEY `AgencyID` (`AgencyID`),
  KEY `BottleID` (`BottleID`),
  CONSTRAINT `sales_ibfk_1` FOREIGN KEY (`AgencyID`) REFERENCES `agency` (`AgencyID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sales_ibfk_2` FOREIGN KEY (`BottleID`) REFERENCES `emptybottles` (`BottleID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` VALUES ('SID0001','2014-04-08','A0002','BT02','1 l',250,30000),('SID0002','2014-04-08','A0001','BT01','500 ml',250,13000),('SID0007','2014-04-15','A0001','BT05','19 l',88,39600),('SID0008','2014-04-09','A0002','BT02','1 l',400,36000),('SID0009','2014-04-09','A0003','BT03','1.5 l',200,24000),('SID0010','2014-04-26','A0002','BT02','1 l',145,13050),('SID0011','2014-04-27','A0002','BT03','1.5 l',120,14400),('SID0012','2014-04-30','A0003','BT03','1.5 l',125,15000),('SID0013','2014-05-03','A0001','BT02','1 l',200,18000),('SID0014','2014-05-03','A0001','BT03','1.5 l',50,6000),('SID0015','2014-05-14','A0001','BT01','500 ml',250,13000),('SID0016','2014-05-04','A0002','BT03','1.5 l',140,16800),('SID0017','2014-05-04','A0004','BT05','19 l',52,23400),('SID0018','2014-05-22','A0004','BT04','5 l',120,24000);
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier` (
  `SupplierID` varchar(50) NOT NULL DEFAULT '',
  `SupplierName` varchar(200) DEFAULT NULL,
  `SupplierAddress` varchar(200) DEFAULT NULL,
  `SupplierContactNo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`SupplierID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES ('S001','Mahela Suppliers','Galpatha Sri lanka','0115478963'),('S002','Kumara Lanka','Kandy Sri lnak','0778965412'),('S003','Dinuka Agencyes','Matara Sri Lanka','0712489632'),('S004','Ayodya Suppliers','Rathnapura','0458796321');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplierorder`
--

DROP TABLE IF EXISTS `supplierorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplierorder` (
  `SupplierOrderID` varchar(50) NOT NULL DEFAULT '',
  `SupplierID` varchar(50) DEFAULT NULL,
  `OrderDate` varchar(200) DEFAULT NULL,
  `Status` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`SupplierOrderID`),
  KEY `SupplierID` (`SupplierID`),
  CONSTRAINT `supplierOrder_ibfk_1` FOREIGN KEY (`SupplierID`) REFERENCES `supplier` (`SupplierID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplierorder`
--

LOCK TABLES `supplierorder` WRITE;
/*!40000 ALTER TABLE `supplierorder` DISABLE KEYS */;
INSERT INTO `supplierorder` VALUES ('SOD0001','S002','2014/04/05','Recieved'),('SOD0002','S002','2014/04/05','Recieved'),('SOD0003','S002','2014/04/05','Not Recieved'),('SOD0004','S001','2014/04/05','Recieved'),('SOD0005','S001','2014/04/05','Recieved'),('SOD0006','S002','2014/04/06','Not Recieved'),('SOD0007','S001','2014/04/06','Not Recieved'),('SOD0008','S002','2014/04/06','Recieved'),('SOD0009','S002','2014/04/05','Not Recieved'),('SOD0010','S002','2014/04/06','Not_Recieved'),('SOD0011','S001','2014/04/07','Not_Recieved'),('SOD0012','S001','2014/04/09','Not_Recieved'),('SOD0013','S001','2014/04/09','Not_Recieved'),('SOD0014','S001','2014/04/09','Not_Recieved'),('SOD0015','S001','2014/04/09','Recieved'),('SOD0016','S001','2014/04/09','Not_Recieved'),('SOD0017','S003','2014/04/09','Recieved'),('SOD0018','S001','2014/04/15','Not_Recieved'),('SOD0019','S001','2014/04/15','Not_Recieved'),('SOD0020','S001','2014/04/24','Not_Recieved'),('SOD0021','S001','2014/04/24','Not_Recieved'),('SOD0022','S001','2014/04/24','Not_Recieved'),('SOD0023','S002','2014/05/03','Not_Recieved'),('SOD0024','S002','2014/05/03','Recieved');
/*!40000 ALTER TABLE `supplierorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplierorderdetail`
--

DROP TABLE IF EXISTS `supplierorderdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplierorderdetail` (
  `SupplierOrderID` varchar(50) DEFAULT NULL,
  `BottleID` varchar(20) DEFAULT NULL,
  `BottleVolume` varchar(50) DEFAULT NULL,
  `BottleQty` varchar(50) DEFAULT NULL,
  KEY `SupplierOrderID` (`SupplierOrderID`),
  CONSTRAINT `supplierOrderDetail_ibfk_1` FOREIGN KEY (`SupplierOrderID`) REFERENCES `supplierorder` (`SupplierOrderID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplierorderdetail`
--

LOCK TABLES `supplierorderdetail` WRITE;
/*!40000 ALTER TABLE `supplierorderdetail` DISABLE KEYS */;
INSERT INTO `supplierorderdetail` VALUES ('SOD0001','BT01','500 ml','100'),('SOD0001','BT02','1 l','200'),('SOD0001','BT04','5 l','200'),('SOD0002','BT01','500 ml','200'),('SOD0002','BT03','1.5 l','400'),('SOD0003','BT01','500 ml','200'),('SOD0003','BT04','5 l','100'),('SOD0004','BT01','500 ml','100'),('SOD0004','BT04','5 l','200'),('SOD0005','BT01','500 ml','200'),('SOD0005','BT02','1 l','500'),('SOD0006','BT02','1 l','123'),('SOD0006','BT04','5 l','255'),('SOD0007','BT01','500 ml','456'),('SOD0007','BT02','1 l','741'),('SOD0007','BT03','1.5 l','321'),('SOD0007','BT05','19 l','987'),('SOD0008','BT01','500 ml','100'),('SOD0008','BT03','1.5 l','200'),('SOD0009','BT01','500 ml','30'),('SOD0009','BT02','1 l','750'),('SOD0010','BT01','500 ml','200'),('SOD0010','BT03','1.5 l','10'),('SOD0011','BT01','500 ml','100'),('SOD0011','BT03','1.5 l','200'),('SOD0015','BT01','500 ml','200'),('SOD0015','BT02','1 l','100'),('SOD0015','BT03','1.5 l','320'),('SOD0017','BT05','19 l','500'),('SOD0017','BT03','1.5 l','1000'),('SOD0017','BT02','1 l','500'),('SOD0023','BT01','500 ml','100'),('SOD0023','BT03','1.5 l','100'),('SOD0023','BT05','19 l','100'),('SOD0024','BT01','500 ml','145'),('SOD0024','BT03','1.5 l','522');
/*!40000 ALTER TABLE `supplierorderdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temp1`
--

DROP TABLE IF EXISTS `temp1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `temp1` (
  `username` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temp1`
--

LOCK TABLES `temp1` WRITE;
/*!40000 ALTER TABLE `temp1` DISABLE KEYS */;
/*!40000 ALTER TABLE `temp1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `UserName` varchar(20) NOT NULL DEFAULT '',
  `Password` varchar(250) NOT NULL DEFAULT '',
  `Privilege` int(10) unsigned NOT NULL DEFAULT '0',
  `Email` varchar(250) NOT NULL DEFAULT '',
  PRIMARY KEY (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES('chanu','*22C9DC89AF5AB2D5370F1159F672A420A7DEE062',0,'chanu1993@gmail.com'),('shashi','*720F43565E226389130D85E7D1E0F41CF5C92ABC',1,'');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-05-27  8:22:18
