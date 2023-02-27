
-- Host: localhost
-- Generation Time:
-- Server version:
-- PHP Version:


SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `hospitalAtu`
--
USE `hospitalAtu`;

--
-- Drop tables if they already exist
--
DROP TABLE IF EXISTS `patients`;
DROP TABLE IF EXISTS `doctors`;
DROP TABLE IF EXISTS `nurseys`;
DROP TABLE IF EXISTS `historic`;
DROP TABLE IF EXISTS `patientdisease`;
DROP TABLE IF EXISTS `disease`;
DROP TABLE IF EXISTS `diseasespeciality`;
DROP TABLE IF EXISTS `speciality`;
DROP TABLE IF EXISTS `patientdisease`;
DROP TABLE IF EXISTS `admin`;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` enum ('admin', 'doctor','nursey','patient') NOT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`adminId`, `userName`, `password`, `role`) VALUES
(1, 'hospitalatu', 'password', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `doctors`
--

CREATE TABLE IF NOT EXISTS `doctors` (
  `doctorId` int(11) NOT NULL AUTO_INCREMENT,
  `colegiatenumber` varchar(50) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `userName` varchar(15) NOT NULL,
  `password` varchar(10) NOT NULL,
  `speciality` varchar(29) NOT NULL,
  `create_at` timestamp,
  PRIMARY KEY (`doctorId`)
) ENGINE=Innodb  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `doctors`
--

INSERT INTO `doctors` (`doctorId`, `colegiatenumber`, `firstName`, `lastName`, `email`, `userName`, `password`, `speciality`) VALUES
(1, '2141', 'Paco', 'Perez', 'pacoperez@somewhere.com', 'pperez', 'abc123', 'Cardiologo'),
(2, '2142', 'Pepe', 'Fdez', 'pepefdez@somewhere.com', 'pfdez', 'abc123', 'Neumologo'),
(3, '2143', 'Luis', 'Martinez', 'luismartinez@somewhere.com', 'lmartinez', 'abc123', 'Otorrino');


-- --------------------------------------------------------

--
-- Table structure for table `nurseys`
--

CREATE TABLE IF NOT EXISTS `nurseys` (
  `nurseysId` int(11) NOT NULL AUTO_INCREMENT,
  `colegiatenumber` varchar(50) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `userName` varchar(15) NOT NULL,
  `password` varchar(10) NOT NULL,
  `speciality` varchar(29) NOT NULL,
  `create_at` timestamp,
  PRIMARY KEY (`nurseysId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `nurseys`
--
INSERT INTO `nurseys` (`nurseysId`, `colegiatenumber`, `firstName`, `lastName`, `email`, `userName`, `password`, `speciality`) VALUES
(1, '1041', 'Paco', 'Martinez', 'pacomartinez@somewhere.com', 'pmartinez', 'abc123', 'UVI'),
(2, '1042', 'Jose', 'Fdez', 'Josefdez@somewhere.com', 'jfdez', 'abc123', 'REA'),
(3, '1043', 'Maria', 'Martinez', 'mariamartinez@somewhere.com', 'mmartinez', 'abc123', 'Planta');

-- --------------------------------------------------------


CREATE TABLE IF NOT EXISTS `patients` (
  `patientId` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `userName` varchar(15) NOT NULL,
  `password` varchar(10) NOT NULL,
  `urgencyLevel` tinyint NOT NULL,
  `desease` varchar(29) NOT NULL,
  `create_at` timestamp current_timestamp,
  PRIMARY KEY (`patientId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `patients`
--
INSERT INTO `patients` (`patientId`, `firstName`, `lastName`, `email`, `userName`, `password`, `urgencyLevel`,`desease` ) VALUES
(1,  'Nuria', 'Velasco', 'nuriavelasco@somewhere.com', 'nvelasco', 'abc123', '3', 'Pulmonia'),
(2,  'Jose', 'Martin', 'josemartin@somewhere.com', 'jmartin', 'abc123', '2', 'Amigdalitis'),
(3,  'Maria', 'Lopez', 'marialopez@somewhere.com', 'mlopez', 'abc123', '1', 'Infarto');


--
-- Table structure for table `disease`
--

CREATE TABLE IF NOT EXISTS `disease` (
  `diseaseId` int(11) NOT NULL AUTO_INCREMENT,
  `diseaseName` varchar(20) NOT NULL,
  PRIMARY KEY (`diseaseId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `disease`
--

INSERT INTO `disease` (`diseaseId`, `diseaseName`) VALUES
('1', 'Pulmonia'),
('2', 'Infarto'),
('3', 'Amigdalitis');


-- --------------------------------------------------------

CREATE TABLE IF NOT EXISTS `speciality` (
  `specialityId` int(11) NOT NULL AUTO_INCREMENT,
  `specialityName` varchar(20) NOT NULL,
  PRIMARY KEY (`specialityId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `speciality`
--

INSERT INTO `speciality` (`specialityId`, `specialityName`) VALUES
('1', 'Neumologia'),
('2', 'Cardilogia'),
('3', 'Otorrinolaringologia');


--
-- Table structure for table `historic`
--

CREATE TABLE IF NOT EXISTS `historic` (
  `create_at` timestamp,
  `hitsId` int(11) NOT NULL AUTO_INCREMENT,
  `historicId` varchar(50) NOT NULL,
  `doctorId` varchar(20) NOT NULL,
  `nurseysId` varchar(20) NOT NULL,
  `deseaseId` int(10) NOT NULL,
  `priority` int(10) NOT NULL,
  `dateIn` DATE NOT NULL,
  `Dateout` DATE,
  `diagnosys` varchar(50) NOT NULL,
  `prescritions` varchar(200) NOT NULL,
  `ubication` varchar(50) NOT NULL,
  `surgery` bit NOT NULL,
  PRIMARY KEY (`hitsId`),
  KEY `historicId` (`historicId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `historic`
--
INSERT INTO `historic` (`hitsId`, `historicId`, `doctorId`, `nurseysId`, `deseaseId`, `priority`, `dateIn`, `Dateout`, `diagnosys`, `prescritions`, `ubication`,`surgery`) VALUES
(1, 1, '2141', '1041', '1','3','2023-01-02','','Bronquitis','Ibuprofeno','Ambulatorio',0);
