-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 28, 2018 at 06:56 
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `social_iot_platform_sve`
--

-- --------------------------------------------------------

--
-- Table structure for table `SVE_1`
--

CREATE TABLE `SVE_1` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_1`
--

INSERT INTO `SVE_1` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('10', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('27', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('31', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('35', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('39', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('42', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('6', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_2`
--

CREATE TABLE `SVE_2` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_2`
--

INSERT INTO `SVE_2` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('1', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('10', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('2', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('27', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('30', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('32', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('33', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('34', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('35', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('38', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('6', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('80', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('9', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_3`
--

CREATE TABLE `SVE_3` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_3`
--

INSERT INTO `SVE_3` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('19', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('23', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('27', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('33', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('34', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('35', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('38', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('4', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('42', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('45', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('80', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_4`
--

CREATE TABLE `SVE_4` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_4`
--

INSERT INTO `SVE_4` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('11', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('15', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('25', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('27', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('28', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('31', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('32', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('33', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('34', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('35', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('38', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('4', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('42', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('6', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_5`
--

CREATE TABLE `SVE_5` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_5`
--

INSERT INTO `SVE_5` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('10', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('15', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('16', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('2', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('21', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('24', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('27', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('29', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('33', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('34', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('38', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('43', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('6', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_6`
--

CREATE TABLE `SVE_6` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_6`
--

INSERT INTO `SVE_6` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('10', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('11', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('12', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('13', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('17', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('18', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('19', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('2', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('23', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('24', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('25', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('26', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('28', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('29', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('3', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('30', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('31', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('32', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('36', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('37', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('39', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('4', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('41', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('42', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('44', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('45', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('5', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('7', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_7`
--

CREATE TABLE `SVE_7` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_7`
--

INSERT INTO `SVE_7` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('10', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('11', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('16', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('20', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('3', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('33', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('34', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('36', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('40', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('43', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('6', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('7', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_8`
--

CREATE TABLE `SVE_8` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_8`
--

INSERT INTO `SVE_8` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('11', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('16', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('2', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('25', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('26', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('28', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('30', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('31', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('33', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('34', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('35', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('41', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('43', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_9`
--

CREATE TABLE `SVE_9` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_9`
--

INSERT INTO `SVE_9` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('10', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('17', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('26', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('27', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('32', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('33', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('34', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('35', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('4', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('6', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_10`
--

CREATE TABLE `SVE_10` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_10`
--

INSERT INTO `SVE_10` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('1', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('13', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('14', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('15', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('18', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('23', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('25', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('26', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('27', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('30', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('33', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('34', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('35', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('38', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('39', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('40', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('6', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('7', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('8', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_11`
--

CREATE TABLE `SVE_11` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_11`
--

INSERT INTO `SVE_11` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('1', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('15', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('17', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('23', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('25', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('26', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('27', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('33', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('34', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('36', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('38', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('44', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('45', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('6', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_12`
--

CREATE TABLE `SVE_12` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_12`
--

INSERT INTO `SVE_12` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('17', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('20', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('27', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('34', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('35', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('38', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('6', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('9', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_13`
--

CREATE TABLE `SVE_13` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_13`
--

INSERT INTO `SVE_13` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('21', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('24', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('29', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('32', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('37', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('43', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('45', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_14`
--

CREATE TABLE `SVE_14` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_14`
--

INSERT INTO `SVE_14` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('1', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('10', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('11', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('13', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('16', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('2', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('22', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('23', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('25', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('32', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('44', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('6', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('8', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_15`
--

CREATE TABLE `SVE_15` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_15`
--

INSERT INTO `SVE_15` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('13', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('14', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('16', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('22', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('34', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('41', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('5', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('6', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('7', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_16`
--

CREATE TABLE `SVE_16` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_16`
--

INSERT INTO `SVE_16` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('15', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('16', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('20', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('25', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('27', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('29', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('36', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('4', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('44', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('6', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_17`
--

CREATE TABLE `SVE_17` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_17`
--

INSERT INTO `SVE_17` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('12', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('2', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('25', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('27', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('28', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('33', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('34', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('37', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('38', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('43', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('44', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('45', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('6', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('8', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_18`
--

CREATE TABLE `SVE_18` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_18`
--

INSERT INTO `SVE_18` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('10', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('13', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('15', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('17', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('24', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('26', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('27', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('28', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('33', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('34', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('35', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('38', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('40', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('43', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('45', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('6', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('9', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_19`
--

CREATE TABLE `SVE_19` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_19`
--

INSERT INTO `SVE_19` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('1', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('13', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('15', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('18', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('19', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('23', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('27', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('3', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('33', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('34', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('35', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('38', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('42', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('6', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('7', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_20`
--

CREATE TABLE `SVE_20` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_20`
--

INSERT INTO `SVE_20` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('18', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('22', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('31', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('32', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('33', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('35', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('40', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('42', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('45', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('80', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('9', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_21`
--

CREATE TABLE `SVE_21` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_21`
--

INSERT INTO `SVE_21` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('11', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('13', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('15', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('18', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('21', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('28', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('3', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('34', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('35', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('38', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('45', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('6', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('9', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_22`
--

CREATE TABLE `SVE_22` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_22`
--

INSERT INTO `SVE_22` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('13', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('14', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('16', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('2', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('20', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('22', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('27', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('28', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('31', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('33', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('34', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('35', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('38', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('43', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('44', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('6', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_23`
--

CREATE TABLE `SVE_23` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_23`
--

INSERT INTO `SVE_23` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('22', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('27', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('33', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('35', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('36', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('38', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('39', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('42', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('43', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('45', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('5', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('6', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_24`
--

CREATE TABLE `SVE_24` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_24`
--

INSERT INTO `SVE_24` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('10', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('13', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('21', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('25', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('27', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('28', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('30', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('33', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('34', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('35', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('37', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('38', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('41', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('42', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('45', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('5', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('6', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_25`
--

CREATE TABLE `SVE_25` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_25`
--

INSERT INTO `SVE_25` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('2', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('20', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('27', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('33', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('34', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('38', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('39', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('44', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('45', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('6', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('7', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_26`
--

CREATE TABLE `SVE_26` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_26`
--

INSERT INTO `SVE_26` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('10', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('11', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('23', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('24', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('27', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('33', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('34', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('35', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('38', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('43', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('45', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('5', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('6', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('9', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_27`
--

CREATE TABLE `SVE_27` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_27`
--

INSERT INTO `SVE_27` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('10', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('11', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('12', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('17', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('18', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('19', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('2', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('22', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('23', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('24', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('25', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('26', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('29', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('3', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('30', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('37', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('39', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('4', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('41', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('42', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('44', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('45', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('5', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('7', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('80', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('9', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_28`
--

CREATE TABLE `SVE_28` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_28`
--

INSERT INTO `SVE_28` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('11', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('17', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('18', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('19', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('2', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('27', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('28', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('29', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('33', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('34', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('37', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('38', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('4', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('6', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('8', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('9', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_29`
--

CREATE TABLE `SVE_29` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_29`
--

INSERT INTO `SVE_29` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('17', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('25', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('26', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('27', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('33', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('34', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('35', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('38', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('43', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('6', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_30`
--

CREATE TABLE `SVE_30` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_30`
--

INSERT INTO `SVE_30` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('11', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('17', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('2', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('23', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('27', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('33', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('34', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('38', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('43', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('45', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('5', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('6', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_31`
--

CREATE TABLE `SVE_31` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_31`
--

INSERT INTO `SVE_31` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('26', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('27', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('33', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('34', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('35', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('36', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('38', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('41', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('42', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('45', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('6', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('80', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_32`
--

CREATE TABLE `SVE_32` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_32`
--

INSERT INTO `SVE_32` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('10', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('16', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('33', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('34', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('37', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('39', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('6', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_33`
--

CREATE TABLE `SVE_33` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_33`
--

INSERT INTO `SVE_33` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('10', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('12', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('13', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('15', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('17', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('18', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('19', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('2', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('20', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('21', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('22', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('24', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('25', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('26', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('28', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('29', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('3', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('30', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('36', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('39', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('4', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('40', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('41', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('42', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('44', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('45', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('5', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('9', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_34`
--

CREATE TABLE `SVE_34` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_34`
--

INSERT INTO `SVE_34` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('1', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('10', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('11', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('12', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('13', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('14', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('15', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('17', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('18', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('19', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('2', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('22', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('23', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('24', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('25', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('28', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('29', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('3', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('30', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('31', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('32', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('33', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('36', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('37', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('39', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('4', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('41', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('42', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('44', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('45', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('5', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('6', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('8', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('9', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_35`
--

CREATE TABLE `SVE_35` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_35`
--

INSERT INTO `SVE_35` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('10', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('11', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('12', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('13', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('14', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('16', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('17', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('18', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('19', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('2', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('20', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('21', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('23', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('24', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('28', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('29', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('3', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('30', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('31', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('35', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('37', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('39', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('4', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('41', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('44', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('5', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('7', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('80', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('9', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_36`
--

CREATE TABLE `SVE_36` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_36`
--

INSERT INTO `SVE_36` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('13', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('15', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('17', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('26', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('27', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('31', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('33', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('34', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('35', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('38', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_37`
--

CREATE TABLE `SVE_37` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_37`
--

INSERT INTO `SVE_37` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('11', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('12', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('16', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('18', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('2', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('24', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('26', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('27', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('3', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('31', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('34', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('38', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('39', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('6', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('7', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('9', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_38`
--

CREATE TABLE `SVE_38` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_38`
--

INSERT INTO `SVE_38` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('10', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('12', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('14', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('15', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('16', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('17', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('19', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('2', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('20', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('22', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('23', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('24', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('25', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('26', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('28', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('29', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('3', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('31', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('33', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('36', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('37', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('39', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('4', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('40', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('41', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('43', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('44', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('5', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('6', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('8', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('9', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_39`
--

CREATE TABLE `SVE_39` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_39`
--

INSERT INTO `SVE_39` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('1', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('13', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('16', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('22', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('23', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('27', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('33', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('34', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('38', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('40', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('41', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('45', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('6', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_40`
--

CREATE TABLE `SVE_40` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_40`
--

INSERT INTO `SVE_40` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('12', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('15', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('30', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('33', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('34', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('35', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('9', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_41`
--

CREATE TABLE `SVE_41` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_41`
--

INSERT INTO `SVE_41` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('26', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('27', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('33', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('34', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('35', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('38', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('42', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('6', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('7', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_42`
--

CREATE TABLE `SVE_42` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_42`
--

INSERT INTO `SVE_42` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('1', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('12', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('15', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('20', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('22', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('25', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('27', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('33', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('34', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('35', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('38', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('43', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('6', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_43`
--

CREATE TABLE `SVE_43` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_43`
--

INSERT INTO `SVE_43` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('11', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('15', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('17', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('18', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('19', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('22', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('25', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('26', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('29', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('30', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('32', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('36', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('38', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('41', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('42', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('44', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('9', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_44`
--

CREATE TABLE `SVE_44` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_44`
--

INSERT INTO `SVE_44` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('1', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('15', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('21', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('27', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('33', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('34', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('35', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('38', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('39', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('40', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('43', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('6', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_45`
--

CREATE TABLE `SVE_45` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_45`
--

INSERT INTO `SVE_45` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('11', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('15', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('16', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('18', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('19', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('2', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('24', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('26', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('29', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('30', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('32', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('36', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('39', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('8', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('9', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

-- --------------------------------------------------------

--
-- Table structure for table `SVE_80`
--

CREATE TABLE `SVE_80` (
  `id_friend` varchar(255) NOT NULL,
  `REL` varchar(255) DEFAULT NULL,
  `MS_LOCATOR` varchar(255) DEFAULT NULL,
  `SVE_LOCATOR` varchar(255) DEFAULT NULL,
  `SERVER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SVE_80`
--

INSERT INTO `SVE_80` (`id_friend`, `REL`, `MS_LOCATOR`, `SVE_LOCATOR`, `SERVER`) VALUES
('1', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('16', 'OOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('29', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('31', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('33', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('34', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('39', 'SOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('42', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0'),
('8', 'CLOR', '192.168.42.178', 'silvia-HP-Notebook/192.168.42.178:200', '0');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `SVE_1`
--
ALTER TABLE `SVE_1`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_2`
--
ALTER TABLE `SVE_2`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_3`
--
ALTER TABLE `SVE_3`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_4`
--
ALTER TABLE `SVE_4`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_5`
--
ALTER TABLE `SVE_5`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_6`
--
ALTER TABLE `SVE_6`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_7`
--
ALTER TABLE `SVE_7`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_8`
--
ALTER TABLE `SVE_8`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_9`
--
ALTER TABLE `SVE_9`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_10`
--
ALTER TABLE `SVE_10`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_11`
--
ALTER TABLE `SVE_11`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_12`
--
ALTER TABLE `SVE_12`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_13`
--
ALTER TABLE `SVE_13`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_14`
--
ALTER TABLE `SVE_14`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_15`
--
ALTER TABLE `SVE_15`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_16`
--
ALTER TABLE `SVE_16`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_17`
--
ALTER TABLE `SVE_17`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_18`
--
ALTER TABLE `SVE_18`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_19`
--
ALTER TABLE `SVE_19`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_20`
--
ALTER TABLE `SVE_20`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_21`
--
ALTER TABLE `SVE_21`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_22`
--
ALTER TABLE `SVE_22`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_23`
--
ALTER TABLE `SVE_23`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_24`
--
ALTER TABLE `SVE_24`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_25`
--
ALTER TABLE `SVE_25`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_26`
--
ALTER TABLE `SVE_26`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_27`
--
ALTER TABLE `SVE_27`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_28`
--
ALTER TABLE `SVE_28`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_29`
--
ALTER TABLE `SVE_29`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_30`
--
ALTER TABLE `SVE_30`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_31`
--
ALTER TABLE `SVE_31`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_32`
--
ALTER TABLE `SVE_32`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_33`
--
ALTER TABLE `SVE_33`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_34`
--
ALTER TABLE `SVE_34`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_35`
--
ALTER TABLE `SVE_35`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_36`
--
ALTER TABLE `SVE_36`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_37`
--
ALTER TABLE `SVE_37`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_38`
--
ALTER TABLE `SVE_38`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_39`
--
ALTER TABLE `SVE_39`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_40`
--
ALTER TABLE `SVE_40`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_41`
--
ALTER TABLE `SVE_41`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_42`
--
ALTER TABLE `SVE_42`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_43`
--
ALTER TABLE `SVE_43`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_44`
--
ALTER TABLE `SVE_44`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_45`
--
ALTER TABLE `SVE_45`
  ADD PRIMARY KEY (`id_friend`);

--
-- Indexes for table `SVE_80`
--
ALTER TABLE `SVE_80`
  ADD PRIMARY KEY (`id_friend`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
