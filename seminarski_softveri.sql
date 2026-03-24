/*
SQLyog Community v13.2.1 (64 bit)
MySQL - 10.4.32-MariaDB : Database - seminarski_softveri
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`seminarski_softveri` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `seminarski_softveri`;

/*Table structure for table `grupa` */

DROP TABLE IF EXISTS `grupa`;

CREATE TABLE `grupa` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nazivGrupe` varchar(200) NOT NULL,
  `datumPocetkaKursa` date NOT NULL,
  `idKursa` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idKursa` (`idKursa`),
  CONSTRAINT `grupa_ibfk_1` FOREIGN KEY (`idKursa`) REFERENCES `kurs` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `grupa` */

insert  into `grupa`(`id`,`nazivGrupe`,`datumPocetkaKursa`,`idKursa`) values 
(1,'A grupa','2024-09-14',1),
(2,'B grupa','2024-09-15',2),
(3,'C grupa','2024-09-16',3),
(4,'D grupa','2024-09-17',4),
(6,'Grupa za početnike','2024-09-20',1),
(7,'aa','2024-09-18',5);

/*Table structure for table `korisnik` */

DROP TABLE IF EXISTS `korisnik`;

CREATE TABLE `korisnik` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) NOT NULL,
  `prezime` varchar(50) NOT NULL,
  `datumRodjenja` date NOT NULL,
  `kontaktTelefon` varchar(30) NOT NULL,
  `mejl` varchar(50) NOT NULL,
  `korisnickoIme` varchar(30) NOT NULL,
  `lozinka` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `korisnik` */

insert  into `korisnik`(`id`,`ime`,`prezime`,`datumRodjenja`,`kontaktTelefon`,`mejl`,`korisnickoIme`,`lozinka`) values 
(1,'Admin','Admin','2024-01-01','060101010','admin@gmail.com','admin','admin'),
(2,'Sara','Slavkovic','2002-02-15','063586614','sara@gmail.com','sara','sara'),
(3,'Lolo','Lolo','2001-01-01','060000011','lolo@gmail.com','lolo','lolo'),
(4,'Mika','Mikic','2000-01-30','061234567','mika@gmail.com','mika','mika'),
(5,'а','а','2024-09-17','061234567','а@gmail.com','aaa','aassddff');

/*Table structure for table `kurs` */

DROP TABLE IF EXISTS `kurs`;

CREATE TABLE `kurs` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nazivKursa` varchar(50) NOT NULL,
  `trajanjeUNedeljama` int(10) unsigned NOT NULL,
  `idTipaSminkanja` int(10) unsigned NOT NULL,
  `idPredavaca` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idTipaSminkanja` (`idTipaSminkanja`),
  KEY `idPredavaca` (`idPredavaca`),
  CONSTRAINT `kurs_ibfk_1` FOREIGN KEY (`idTipaSminkanja`) REFERENCES `tipsminkanja` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `kurs_ibfk_2` FOREIGN KEY (`idPredavaca`) REFERENCES `predavac` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `kurs` */

insert  into `kurs`(`id`,`nazivKursa`,`trajanjeUNedeljama`,`idTipaSminkanja`,`idPredavaca`) values 
(1,'Kurs za početnike',4,1,1),
(2,'Kurs za profesionalnog šminkera',11,4,4),
(3,'Kurs šminkanja za svečane prilike',8,3,2),
(4,'Kurs profesionalnog šminkanja za svečane prilike',9,4,4),
(5,'Kurs za glamuroznu sminkuuu',15,3,3),
(12,'Kurs svakodnevnog šminkanja za početnike',3,1,2),
(16,'Kurs svadbenog sminkanja',12,2,3),
(17,'lala',12,2,4);

/*Table structure for table `predavac` */

DROP TABLE IF EXISTS `predavac`;

CREATE TABLE `predavac` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) NOT NULL,
  `prezime` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `predavac` */

insert  into `predavac`(`id`,`ime`,`prezime`,`email`) values 
(1,'Ana','Anić','ana@gmail.com'),
(2,'Bojana','Marić','bojana@gmail.com'),
(3,'Ivan','Lukić','ivan@gmail.com'),
(4,'Anja','Perić','anja@gmail.com');

/*Table structure for table `prijava` */

DROP TABLE IF EXISTS `prijava`;

CREATE TABLE `prijava` (
  `idKorisnika` int(10) unsigned NOT NULL,
  `idKursa` int(10) unsigned NOT NULL,
  `datumPrijave` date NOT NULL,
  `napomena` varchar(500) NOT NULL DEFAULT '/',
  `idGrupe` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idKorisnika`,`idKursa`),
  KEY `idKursa` (`idKursa`),
  KEY `idGrupe` (`idGrupe`),
  CONSTRAINT `prijava_ibfk_1` FOREIGN KEY (`idKorisnika`) REFERENCES `korisnik` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `prijava_ibfk_2` FOREIGN KEY (`idKursa`) REFERENCES `kurs` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `prijava_ibfk_3` FOREIGN KEY (`idGrupe`) REFERENCES `grupa` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `prijava` */

insert  into `prijava`(`idKorisnika`,`idKursa`,`datumPrijave`,`napomena`,`idGrupe`) values 
(2,1,'2024-09-16','',1),
(2,2,'2024-09-17','Već sam pohađala kurs za početnike, poznajem osnovne tehnike šminkanja',2),
(2,3,'2024-09-16','',3),
(2,4,'2024-09-16','',4),
(2,5,'2024-09-16','',7),
(2,12,'2024-09-17','',1),
(4,3,'2024-09-17','',3),
(4,5,'2024-09-17','',1),
(4,16,'2024-09-18','',1);

/*Table structure for table `rasporedkursa` */

DROP TABLE IF EXISTS `rasporedkursa`;

CREATE TABLE `rasporedkursa` (
  `idGrupe` int(10) unsigned NOT NULL,
  `danUNedelji` varchar(20) NOT NULL,
  `brojCasova` int(10) unsigned NOT NULL,
  `opisKursa` varchar(500) NOT NULL,
  `sala` int(10) unsigned NOT NULL,
  `vreme` varchar(200) NOT NULL,
  PRIMARY KEY (`idGrupe`,`danUNedelji`),
  CONSTRAINT `rasporedkursa_ibfk_1` FOREIGN KEY (`idGrupe`) REFERENCES `grupa` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `rasporedkursa` */

insert  into `rasporedkursa`(`idGrupe`,`danUNedelji`,`brojCasova`,`opisKursa`,`sala`,`vreme`) values 
(1,'Ponedeljak',1,'Blazi intenzitet',101,'10:00'),
(2,'Utorak',3,'Srednji intenzitet',103,'8:00'),
(3,'Sreda',5,'Neki opis',22,'13:30'),
(4,'Četvrtak',6,'Lalala',90,'11:00'),
(6,'Petak',5,'Osnovni kurs šminkanja pruža polaznicima temeljne tehnike i savete za kreiranje svakodnevnog izgleda',10,'19:00'),
(6,'Subota',5,'Osnovni kurs šminkanja pruža polaznicima temeljne tehnike i savete za kreiranje svakodnevnog izgleda',3,'17:30'),
(6,'Utorak',5,'Osnovni kurs šminkanja pruža polaznicima temeljne tehnike i savete za kreiranje svakodnevnog izgleda',8,'18:00'),
(7,'Ponedeljak',22,'jfhfh',11,'14:00'),
(7,'Sreda',2,'',11,'11:00');

/*Table structure for table `tipsminkanja` */

DROP TABLE IF EXISTS `tipsminkanja`;

CREATE TABLE `tipsminkanja` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nazivTipaSminkanja` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `tipsminkanja` */

insert  into `tipsminkanja`(`id`,`nazivTipaSminkanja`) values 
(1,'svakodnevna šminka'),
(2,'svadbena šminka'),
(3,'maturska šminka'),
(4,'glamurozna šminka');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
