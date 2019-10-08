CREATE SCHEMA `ajax` ;

USE `ajax`;

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `cid` int(10) NOT NULL,
  `cname` varchar(45) default NULL,
  `sid` int(10) default NULL,
  PRIMARY KEY  (`cid`),
  KEY `sid` (`sid`),
  CONSTRAINT `sid` FOREIGN KEY (`sid`) REFERENCES `state` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `city` */

insert  into `city`(`cid`,`cname`,`sid`) values (1,'pune',1),(2,'mumbai',1),(3,'gujrat',2),(4,'avanue46',3);

/*Table structure for table `country` */

DROP TABLE IF EXISTS `country`;

CREATE TABLE `country` (
  `coid` int(10) NOT NULL,
  `coname` varchar(45) default NULL,
  PRIMARY KEY  (`coid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `country` */

insert  into `country`(`coid`,`coname`) values (1,'india'),(2,'usa');

/*Table structure for table `state` */

DROP TABLE IF EXISTS `state`;

CREATE TABLE `state` (
  `sid` int(10) NOT NULL,
  `sname` varchar(45) default NULL,
  `coid` int(10) default NULL,
  PRIMARY KEY  (`sid`),
  KEY `coid` (`coid`),
  CONSTRAINT `coid` FOREIGN KEY (`coid`) REFERENCES `country` (`coid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `state` */

insert  into `state`(`sid`,`sname`,`coid`) values (1,'mh',1),(2,'gujarat',1),(3,'LA',2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
