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


DROP TABLE IF EXISTS `doctors`;
DROP TABLE IF EXISTS `nurseys`;
DROP TABLE IF EXISTS `historic`;
DROP TABLE IF EXISTS `patientdisease`;
DROP TABLE IF EXISTS `disease`;
DROP TABLE IF EXISTS `diseasespeciality`;
DROP TABLE IF EXISTS `speciality`;
DROP TABLE IF EXISTS `patientdisease`;
DROP TABLE IF EXISTS `admin`;
DROP TABLE IF EXISTS `patients`;
DROP TABLE IF EXISTS `persona`;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` enum ('Admin', 'Doctor','Nursey','Patient') NOT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`adminId`, `userName`, `password`, `role`) VALUES
(1, 'hospitalatu', 'password', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `persona`
--

CREATE TABLE IF NOT EXISTS `persona` (
  `dni` varchar(12) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `password` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `birthdate` date NOT NULL,
  `role` enum ('admin', 'doctor','nursey','patient') NOT NULL,
  `create_at` timestamp,
  PRIMARY KEY (`dni`)
) ENGINE=Innodb  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `persona`
--

INSERT INTO `persona` (`firstName`, `lastName`, `password`,`dni`, `email`,`birthdate`, `role`) VALUES
('Paco', 'Perez','abc123', '1223563-W','pacoperez@somewhere.com', '1967-12-01', 2),
('Manuel', 'Puzela','abc123', '1223564-W','manuelpuzela@somewhere.com', '1981-12-01', 2),
('Margarita', 'Alonso','abc123', '1223565-W','margaritaalonso@somewhere.com', '1973-12-01', 2),
('Pepe', 'Fdez','abc123', '5256458-P', 'pepefdez@somewhere.com', '1989-03-02', 4),
('Amanada', 'Fdez','abc123', '36486483-H', 'amanadafdez@somewhere.com', '1954-03-02', 4),
('Ainoa', 'Fdez','abc123', '36475637-L', 'ainoafdez@somewhere.com', '1943-03-02', 4),
('Luis', 'Martinez', 'abc123', '45859586-Y','luismartinez@somewhere.com', '1974-06-06', 3),
('Pepa', 'Perez', 'abc123', '87656783-P','pepaperez@somewhere.com', '1961-06-06', 3),
('Magdalena', 'Martinez', 'abc123', '6483945-W','magdalenamartinez@somewhere.com', '2001-06-06', 3);


--
-- Table structure for table `doctors`
--

CREATE TABLE IF NOT EXISTS `doctors` (
  `dni` varchar(12) NOT NULL,
  `colegiatenumber` varchar(50) NOT NULL,
  `speciality` varchar(29) NOT NULL,
  `create_at` timestamp,
  PRIMARY KEY (`dni`),
  CONSTRAINT `fk_person_doctor` FOREIGN KEY (dni) REFERENCES persona(dni)
) ENGINE=Innodb  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `doctors`
--

INSERT INTO `doctors` (`dni`,`colegiatenumber`,`speciality`) VALUES
('1223563-W', '2141', 'Cardiologo'),
('1223564-W', '2142', 'Neumologo'),
('1223565-W', '2143', 'Otorrino');

-- --------------------------------------------------------

--
-- Table structure for table `nurseys`
--

CREATE TABLE IF NOT EXISTS `nurseys` (
  `dni` varchar(12) NOT NULL,
  `colegiatenumber` varchar(50) NOT NULL,
  `speciality` varchar(29) NOT NULL,
  `create_at` timestamp,
  PRIMARY KEY (`dni`),
  CONSTRAINT `fk_person_nursey` FOREIGN KEY (dni) REFERENCES persona(dni)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `nurseys`
--
INSERT INTO `nurseys` (`dni`, `colegiatenumber`, `speciality`) VALUES
('45859586-Y', '1041','UVI'),
('87656783-P', '1042','REA'),
('6483945-W', '1043','Planta');

-- --------------------------------------------------------


CREATE TABLE IF NOT EXISTS `patients` (
  `dni` varchar(12) NOT NULL,
  `urgencyLevel` tinyint NOT NULL,
  `desease` varchar(29) NOT NULL,
  `historicId` int(11) NOT NULL AUTO_INCREMENT,
  `create_at` timestamp,
  PRIMARY KEY (`historicId`),
  CONSTRAINT `fk_person_patients` FOREIGN KEY (dni) REFERENCES persona(dni)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `patients`
--
INSERT INTO `patients` (`dni`,`urgencyLevel`,`desease`) VALUES
('5256458-P','3', 'Pulmonia'),
('36486483-H','2', 'Amigdalitis'),
('36475637-L', '1', 'Infarto');


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


CREATE TABLE IF NOT EXISTS `patientdisease` (
  `diseaseId` int(11) NOT NULL,
  `historicId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Dumping data for table `patientdisease`
--

INSERT INTO `patientdisease` (`diseaseId`, `historicId`) VALUES
('1', '1');



CREATE TABLE IF NOT EXISTS `diseasespeciality` (
  `diseaseId` int(11) NOT NULL,
  `specialityId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `diseasespeciality`
--

INSERT INTO `diseasespeciality` (`diseaseId`, `specialityId`) VALUES
('1', '1'),
('2', '2'),
('3', '3');