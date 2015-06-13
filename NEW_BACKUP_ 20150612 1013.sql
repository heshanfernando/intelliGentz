-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.27


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema intelligentz_db
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ intelligentz_db;
USE intelligentz_db;

--
-- Table structure for table `intelligentz_db`.`category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `categoryId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `intelligentz_db`.`category`
--

/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`categoryId`,`categoryName`) VALUES 
 (1,'Gent Fashion'),
 (2,'Ladies Fashion'),
 (3,'Vehicle'),
 (4,'Electronic Devices');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;


--
-- Table structure for table `intelligentz_db`.`item`
--

DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `itemId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `itemName` varchar(100) NOT NULL DEFAULT '',
  `categoryId` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`itemId`),
  KEY `FK_item_1` (`categoryId`),
  CONSTRAINT `FK_item_1` FOREIGN KEY (`categoryId`) REFERENCES `category` (`categoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `intelligentz_db`.`item`
--

/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` (`itemId`,`itemName`,`categoryId`) VALUES 
 (11,'Top Ware',1),
 (12,'Bottom Ware',1),
 (13,'Under Ware',1),
 (21,'Top Ware',2),
 (22,'Bottom Ware',2),
 (23,'Under Ware',2),
 (31,'Car',3),
 (32,'Van',3),
 (33,'Three Wheel',3),
 (34,'Lorry',3),
 (41,'Mobille Phones & Tablets',4),
 (42,'Desktop Computers',4),
 (43,'Laptops',4),
 (44,'Tv',4),
 (45,'Radio',4);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;


--
-- Table structure for table `intelligentz_db`.`owner`
--

DROP TABLE IF EXISTS `owner`;
CREATE TABLE `owner` (
  `ownerId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userName` varchar(100) NOT NULL DEFAULT '',
  `password` varchar(50) NOT NULL DEFAULT '',
  `ownerName` varchar(100) NOT NULL DEFAULT '',
  `ownerContactNo` int(10) unsigned NOT NULL DEFAULT '0',
  `ownerNicNo` varchar(15) NOT NULL DEFAULT '',
  PRIMARY KEY (`ownerId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `intelligentz_db`.`owner`
--

/*!40000 ALTER TABLE `owner` DISABLE KEYS */;
INSERT INTO `owner` (`ownerId`,`userName`,`password`,`ownerName`,`ownerContactNo`,`ownerNicNo`) VALUES 
 (1,'dineth','678','Dineth Egodage',713636666,'932115685v'),
 (2,'heshanf','123','Heshan Fernando',712282328,'922111804v'),
 (3,'janaka','999','Janaka Chathuranga',712357832,'931782343v'),
 (4,'lucky','5555','Lakshan Gamage',772345679,'931447346v'),
 (5,'shalith','456','Shalith Fernando',779956961,'922590940v'),
 (6,'amila','6666','Amila Rathnayaka',723456253,'872346251v'),
 (7,'keet','123','Keet Sudagathadasa',723452345,'9354656876v');
/*!40000 ALTER TABLE `owner` ENABLE KEYS */;


--
-- Table structure for table `intelligentz_db`.`shop`
--

DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `shopId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `shopName` varchar(100) NOT NULL DEFAULT '',
  `shopAddress` varchar(200) NOT NULL DEFAULT '',
  `shopContactNo` int(10) unsigned NOT NULL DEFAULT '0',
  `shopLongitude` double NOT NULL DEFAULT '0',
  `shopLattitude` double NOT NULL DEFAULT '0',
  `ownerId` int(10) unsigned NOT NULL DEFAULT '0',
  `shopMaskedNo` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`shopId`),
  KEY `FK_shop_1` (`ownerId`),
  CONSTRAINT `FK_shop_1` FOREIGN KEY (`ownerId`) REFERENCES `owner` (`ownerId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `intelligentz_db`.`shop`
--

/*!40000 ALTER TABLE `shop` DISABLE KEYS */;
INSERT INTO `shop` (`shopId`,`shopName`,`shopAddress`,`shopContactNo`,`shopLongitude`,`shopLattitude`,`ownerId`,`shopMaskedNo`) VALUES 
 (1,'Weera Fashion ','123,Galle Road,Katubedda',712282328,79.8888316146622,6.7965279290169365,2,'Tel:0771232345'),
 (2,'Egoda Enterprices','23,Main Street,Pandura',716723472,79.90711784367704,6.716488381338133,1,'Tel:0773541982'),
 (3,'Fashion Corner','234,Sumathi Road,Piliyandala',715268543,79.92291069043858,6.803597505220649,3,'Tel:0771238923'),
 (4,'Lucky Enterprices','234,Malwatta Road,Galle',778652341,80.26831068098545,6.0946749770611675,4,'Tel:0722346543'),
 (5,'Janaka Electricals','234,Gunathilake Road,Rathmalana',77852941,79.90233707270818,6.794964000017729,5,'Tel:072562303');
/*!40000 ALTER TABLE `shop` ENABLE KEYS */;


--
-- Table structure for table `intelligentz_db`.`shop_item_detail`
--

DROP TABLE IF EXISTS `shop_item_detail`;
CREATE TABLE `shop_item_detail` (
  `shopId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `itemId` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`shopId`,`itemId`),
  KEY `FK_shop_item_detail_1` (`shopId`),
  KEY `FK_shop_item_detail_2` (`itemId`),
  CONSTRAINT `FK_shop_item_detail_1` FOREIGN KEY (`shopId`) REFERENCES `shop` (`shopId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_shop_item_detail_2` FOREIGN KEY (`itemId`) REFERENCES `item` (`itemId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `intelligentz_db`.`shop_item_detail`
--

/*!40000 ALTER TABLE `shop_item_detail` DISABLE KEYS */;
INSERT INTO `shop_item_detail` (`shopId`,`itemId`) VALUES 
 (1,11),
 (1,12),
 (1,13),
 (1,21),
 (1,22),
 (1,23),
 (2,31),
 (2,32),
 (3,11),
 (3,12),
 (3,13),
 (3,21),
 (3,22),
 (3,23),
 (3,31),
 (3,32),
 (3,33),
 (4,11),
 (4,21),
 (5,41),
 (5,43),
 (5,44);
/*!40000 ALTER TABLE `shop_item_detail` ENABLE KEYS */;


--
-- Table structure for table `intelligentz_db`.`shop_time`
--

DROP TABLE IF EXISTS `shop_time`;
CREATE TABLE `shop_time` (
  `shopId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `date` varchar(15) NOT NULL DEFAULT '',
  `startTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `closeTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`shopId`,`date`),
  CONSTRAINT `FK_shop_time_1` FOREIGN KEY (`shopId`) REFERENCES `shop` (`shopId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `intelligentz_db`.`shop_time`
--

/*!40000 ALTER TABLE `shop_time` DISABLE KEYS */;
INSERT INTO `shop_time` (`shopId`,`date`,`startTime`,`closeTime`) VALUES 
 (5,'Weekdays','1970-01-01 08:00:00','1970-01-01 17:00:00'),
 (5,'Weekends','1970-01-01 08:00:00','1970-01-01 17:00:00');
/*!40000 ALTER TABLE `shop_time` ENABLE KEYS */;


--
-- Table structure for table `intelligentz_db`.`task`
--

DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `taskId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `mobileNo` int(10) unsigned NOT NULL DEFAULT '0',
  `taskLongitude` float NOT NULL DEFAULT '0',
  `taskLattitude` float NOT NULL DEFAULT '0',
  `timeStarted` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `receivedMessage` varchar(200) NOT NULL DEFAULT '',
  `itemId` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`taskId`),
  KEY `FK_task_1` (`itemId`),
  CONSTRAINT `FK_task_1` FOREIGN KEY (`itemId`) REFERENCES `item` (`itemId`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `intelligentz_db`.`task`
--

/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` (`taskId`,`mobileNo`,`taskLongitude`,`taskLattitude`,`timeStarted`,`receivedMessage`,`itemId`) VALUES 
 (1,772345671,76.2346,6.45678,'2015-06-11 11:40:15','Emerald Shirt',11);
/*!40000 ALTER TABLE `task` ENABLE KEYS */;


--
-- Table structure for table `intelligentz_db`.`task_detail`
--

DROP TABLE IF EXISTS `task_detail`;
CREATE TABLE `task_detail` (
  `taskDetailId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `taskId` int(10) unsigned NOT NULL DEFAULT '0',
  `shopId` int(10) unsigned NOT NULL DEFAULT '0',
  `responseTime` datetime DEFAULT NULL,
  `itemAvailability` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`taskDetailId`),
  KEY `FK_task_detail_1` (`taskId`),
  KEY `FK_task_detail_2` (`shopId`),
  CONSTRAINT `FK_task_detail_1` FOREIGN KEY (`taskId`) REFERENCES `task` (`taskId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_task_detail_2` FOREIGN KEY (`shopId`) REFERENCES `shop` (`shopId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `intelligentz_db`.`task_detail`
--

/*!40000 ALTER TABLE `task_detail` DISABLE KEYS */;
INSERT INTO `task_detail` (`taskDetailId`,`taskId`,`shopId`,`responseTime`,`itemAvailability`) VALUES 
 (3,1,1,'2015-06-11 11:58:22',1);
/*!40000 ALTER TABLE `task_detail` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
