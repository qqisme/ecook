/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.47-MariaDB : Database - ecook
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ecook` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ecook`;

/*Table structure for table `ecook_ingredients` */

DROP TABLE IF EXISTS `ecook_ingredients`;

CREATE TABLE `ecook_ingredients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `parent_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `ecook_top` */

DROP TABLE IF EXISTS `ecook_top`;

CREATE TABLE `ecook_top` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `synopsis` varchar(50) DEFAULT NULL,
  `author` varchar(50) DEFAULT NULL,
  `img_url` varchar(100) NOT NULL,
  `pageviews` bigint(20) DEFAULT NULL,
  `praise_points` bigint(20) DEFAULT NULL,
  `created_time` date NOT NULL,
  `updated_time` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2081 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
