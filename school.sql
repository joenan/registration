/*
SQLyog Community v13.0.1 (64 bit)
MySQL - 5.6.10 : Database - school
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`school` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `school`;

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `courseid` bigint(20) NOT NULL AUTO_INCREMENT,
  `coursecode` varchar(10) DEFAULT NULL,
  `coursedescription` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`courseid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `course` */

insert  into `course`(`courseid`,`coursecode`,`coursedescription`) values 
(1,'ECE 211','Electrical & Computer Engineering I'),
(2,'CS 200','Introduction to Computer Science'),
(3,'CS 211','Computer Programming II'),
(4,'CS 412','Computer Programming II'),
(5,'CS 19','Object Oriented Programming');

/*Table structure for table `registration` */

DROP TABLE IF EXISTS `registration`;

CREATE TABLE `registration` (
  `detailsid` bigint(20) NOT NULL AUTO_INCREMENT,
  `courseid` bigint(20) DEFAULT NULL,
  `studentid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`detailsid`),
  KEY `FK9ovl96js5ir4wu8fb2iq8s4wk` (`courseid`),
  KEY `FKlvrsywpsinxuycxg8vaf66png` (`studentid`),
  CONSTRAINT `FK9ovl96js5ir4wu8fb2iq8s4wk` FOREIGN KEY (`courseid`) REFERENCES `course` (`courseid`),
  CONSTRAINT `FKlvrsywpsinxuycxg8vaf66png` FOREIGN KEY (`studentid`) REFERENCES `student` (`studentid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `registration` */

insert  into `registration`(`detailsid`,`courseid`,`studentid`) values 
(2,1,29),
(3,2,29);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `studentid` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) DEFAULT NULL,
  `firstname` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `gender` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`studentid`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`studentid`,`email`,`firstname`,`lastname`,`phone`,`gender`) values 
(1,'kaz@gmail.com','Kazim','Abdullahi','00958574845','Male'),
(2,'mo@gmail.com','Hassan','hassan','0995757458','Male'),
(3,'tad@gmail.com','Tad','Bricks','0959484847','Male'),
(11,'philip@yahoo.com','Ibrahim','Abubakar','99485769','Male'),
(12,'philip@yahoo.com','Ibrahim','Abubakar','99485769','Male'),
(13,'naomi@yahoo.com','Naomi','Philimon','09066475123','Female'),
(14,'naomi@yahoo.com','Naomi','Philimon','09066475123','Female'),
(15,'helon@gmail.com','Helon','Alcy','00998756','Male'),
(16,'morgan@hotmail.com','chris','morgan','08058572167','Male'),
(17,'morgan@hotmail.com','chris','morgan','08058572167','Male'),
(18,'morgan@hotmail.com','chris','morgan','08058572167','Male'),
(19,'santa@gmail.com','Santa','Clause','09988573123',NULL),
(20,'benard@yahoo.com','benard','iroh','08055668591',NULL),
(21,'benard@yahoo.com','benard','iroh','08055668591',NULL),
(22,'benard@yahoo.com','benard','iroh','08055668591',NULL),
(23,'hens@gmail.com','hens','hens','090984444',NULL),
(24,'hens@gmail.com','hens','hens','090984444',NULL),
(25,'gibah@yahoo.com','Gibaj','Joseph','3232884756',NULL),
(26,'gibah@yahoo.com','Gibaj','Joseph','3232884756',NULL),
(29,'hafsat@gmail.cm','Hafsat','Sani','200499585','Female');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
