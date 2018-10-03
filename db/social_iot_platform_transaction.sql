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
-- Database: `social_iot_platform_transaction`
--

-- --------------------------------------------------------

--
-- Table structure for table `completed`
--

CREATE TABLE `completed` (
  `TrxHash` varchar(255) NOT NULL,
  `Content` varchar(10000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `creditCharges`
--

CREATE TABLE `creditCharges` (
  `trxHash` varchar(255) NOT NULL,
  `userID` int(11) NOT NULL,
  `credit` int(11) NOT NULL,
  `isConfirmed` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `creditCharges`
--

INSERT INTO `creditCharges` (`trxHash`, `userID`, `credit`, `isConfirmed`) VALUES
('e9e16f999f4409f612ffbdc55b3322112eca9af1e1e1650bb7ee3ce5895fa306', 111, 4800000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `readAPIkeys`
--

CREATE TABLE `readAPIkeys` (
  `SVER_ID` varchar(255) NOT NULL,
  `SVE_ID` varchar(255) NOT NULL,
  `readAPIkey` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `readAPIkeys`
--

INSERT INTO `readAPIkeys` (`SVER_ID`, `SVE_ID`, `readAPIkey`) VALUES
('0', '80', 'UNTE8IUESCETPC9A');

-- --------------------------------------------------------

--
-- Table structure for table `unconfirmed`
--

CREATE TABLE `unconfirmed` (
  `TrxHash` varchar(255) NOT NULL,
  `SVER_ID` varchar(255) DEFAULT NULL,
  `SVE_ID` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `completed`
--
ALTER TABLE `completed`
  ADD PRIMARY KEY (`TrxHash`),
  ADD UNIQUE KEY `TrxHash` (`TrxHash`);

--
-- Indexes for table `creditCharges`
--
ALTER TABLE `creditCharges`
  ADD PRIMARY KEY (`trxHash`);

--
-- Indexes for table `unconfirmed`
--
ALTER TABLE `unconfirmed`
  ADD UNIQUE KEY `TrxHash` (`TrxHash`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
