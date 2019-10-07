-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.11-beta-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema emailproject
--

CREATE DATABASE IF NOT EXISTS emailproject;
USE emailproject;

--
-- Definition of table `demo_user`
--

DROP TABLE IF EXISTS `demo_user`;
CREATE TABLE `demo_user` (
  `user_id` bigint(20) NOT NULL auto_increment,
  `email` varchar(100) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `email_verification_hash` varchar(100) default NULL,
  `email_verification_attempts` int(11) default NULL,
  `status` varchar(15) default 'new',
  `created_time` timestamp NULL default CURRENT_TIMESTAMP,
  `password` varchar(100) default NULL,
  PRIMARY KEY  (`user_id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='User Table';

--
-- Dumping data for table `demo_user`
--

/*!40000 ALTER TABLE `demo_user` DISABLE KEYS */;
INSERT INTO `demo_user` (`user_id`,`email`,`first_name`,`last_name`,`email_verification_hash`,`email_verification_attempts`,`status`,`created_time`,`password`) VALUES 
 (1,'tathagatkumarsingh@gmail.com','tathagat','singh','$2a$10$DOWSDz/CyKaJ40hslrk5feoIBHhfk0bWWEVZIAXkD4iBO5qYEq7wO',NULL,'active','2016-03-16 10:23:26','$2a$10$DOWSDz/CyKaJ40hslrk5feH8V6YLyd0uK9pKH/vReiZcsiCrGQP/O');
/*!40000 ALTER TABLE `demo_user` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
