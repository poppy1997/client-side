-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 14, 2021 at 06:23 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

CREATE TABLE `project` (
  `itemID` int(11) NOT NULL,
  `itemCode` varchar(45) NOT NULL,
  `itemName` varchar(45) NOT NULL,
  `itemPrice` double NOT NULL,
  `itemDesc` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`itemID`, `itemCode`, `itemName`, `itemPrice`, `itemDesc`) VALUES
(1, 'project-idea', 'Food-4-u', 12, 'a food ordering mobile app'),
(2, 'project-finished', 'HeartCart', 7, 'online gift ordering website'),
(3, 'project-finished', 'Grammar-nu', 25, 'grammar and spell checker app for mobiles');

-- --------------------------------------------------------

--
-- Table structure for table `researcher`
--

CREATE TABLE `researcher` (
  `itemID` int(11) NOT NULL,
  `itemCode` varchar(45) NOT NULL,
  `itemName` varchar(45) NOT NULL,
  `itemDesc` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `researcher`
--

INSERT INTO `researcher` (`itemID`, `itemCode`, `itemName`, `itemDesc`) VALUES
(1, 'researcher', 'N M Silva', 'I am an aspiring programmer who\'s currently working on multiple mobile app development projects.'),
(2, 'researcher', 'P N Perera', 'I a veteran programmer who\'s currently managing multiple mobile app development projects.'),
(3, 'researcher', 'L M Doe', 'I am a seasoned programmer with expertise on Java, C and C++.');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`itemID`);

--
-- Indexes for table `researcher`
--
ALTER TABLE `researcher`
  ADD PRIMARY KEY (`itemID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `researcher`
--
ALTER TABLE `researcher`
  MODIFY `itemID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SETTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
