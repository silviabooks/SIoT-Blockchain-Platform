-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Mar 19, 2018 alle 11:13
-- Versione del server: 10.1.28-MariaDB
-- Versione PHP: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `social_iot_platform`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `sver`
--

CREATE TABLE `sver` (
  `channel` varchar(255) NOT NULL,
  `uid` int(255) NOT NULL,
  `areas` varchar(255) NOT NULL,
  `ip` varchar(255) NOT NULL,
  `meta` varchar(255) NOT NULL,
  `server` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `sver`
--

INSERT INTO `sver` (`channel`, `uid`, `areas`, `ip`, `meta`, `server`) VALUES
('325389', 1, '41.0152185,-74.0395756', 'https://thingspeak.com/channels/325389', '#HillsdaleTempBot (by #SmartyTempy)', 0),
('265086', 2, '48.841526,17.1222', 'https://thingspeak.com/channels/265086', 'Chata zahrada', 0),
('249563', 3, '51.4109,5.4601', 'https://thingspeak.com/channels/249563', 'ENS210 @ HTC', 0),
('42908', 4, '51.3026,37.82872', 'https://thingspeak.com/channels/42908', 'ÐšÑƒÑ…Ð½Ñ', 0),
('408176', 5, '50.009464,22.021365', 'https://thingspeak.com/channels/408176', 'Kamery RzeszÃ³w - Pomiar czystoÅ›ci powietrza - Zimowit', 0),
('387713', 6, '0.0,0.0', 'https://thingspeak.com/channels/387713', 'Meteostanice', 0),
('243783', 7, '39.1507502041,117.2558653355', 'https://thingspeak.com/channels/243783', 'Neo Home sensor', 0),
('5683', 8, '35.664548,-78.654972', 'https://thingspeak.com/channels/5683', 'Residential Data Points', 0),
('377943', 9, '50.0411867,21.9991196', 'https://thingspeak.com/channels/377943', 'Kamery RzeszÃ³w - Pomiar czystoÅ›ci powietrza -Drabinianka', 0),
('83873', 10, '45.556906,18.67948', 'https://thingspeak.com/channels/83873', 'Inchoo', 0),
('45572', 11, '46.94843,7.43777', 'https://thingspeak.com/channels/45572', 'Energy monitoring', 0),
('22793', 12, '46.420124,26.442574', 'https://thingspeak.com/channels/22793', 'Monitorizare turbina eoliana verticala', 0),
('418060', 13, '35.0,34.0', 'https://thingspeak.com/channels/418060', 'Peacefair PZEM-004T Data', 0),
('104729', 14, '38.8009792,-9.1624423', 'https://thingspeak.com/channels/104729', 'PFC Temperatura', 0),
('82655', 15, '38.77792,-9.2291', 'https://thingspeak.com/channels/82655', 'Filipe Reis  (PT)', 0),
('82655', 16, '38.77792,-9.2291', 'https://thingspeak.com/channels/82655', 'Filipe Reis  (PT)', 0),
('145242', 17, '53.6722459,10.2503598', 'https://thingspeak.com/channels/145242', 'Squirrel Cafe Weather Data', 0),
('75470', 18, '55.87895,-4.387102', 'https://thingspeak.com/channels/75470', 'Twitter PostThing', 0),
('36156', 19, '49.959768,20.641941', 'https://thingspeak.com/channels/36156', 'Stacja pogodowa', 0),
('9', 20, '40.44,-79.9965', 'https://thingspeak.com/channels/9', 'my_house', 0),
('34247', 21, '27.35256,-80.42484', 'https://thingspeak.com/channels/34247', 'Solar Home', 0),
('159150', 22, '49.988777,36.222111', 'https://thingspeak.com/channels/159150', 'WS#1 (Weather Station)', 0),
('206644', 23, '60.014326,30.252398', 'https://thingspeak.com/channels/206644', 'ROZET A503W', 0),
('182328', 24, '49.988777,36.222111', 'https://thingspeak.com/channels/182328', 'Gas Sensor', 0),
('178434', 25, '49.988777,36.222111', 'https://thingspeak.com/channels/178434', 'WS#3 (Weather Station)', 0),
('84008', 26, '50.94498,-1.425', 'https://thingspeak.com/channels/84008', 'Temperature & Humidity', 0),
('209159', 27, '0.0,0.0', 'https://thingspeak.com/channels/209159', 'Mobile ESP8266 Air Quality Sensor', 0),
('172216', 28, '49.988777,36.222111', 'https://thingspeak.com/channels/172216', 'Smart Fridge', 0),
('145827', 29, '53.7238,-0.4349', 'https://thingspeak.com/channels/145827', 'Hessle Electricity Usage ', 0),
('64519', 30, '53.723805,-0.4319', 'https://thingspeak.com/channels/64519', 'Hessle IOT', 0),
('83708', 31, '46.94843,7.43777', 'https://thingspeak.com/channels/83708', 'Internet Speed Test', 0),
('38265', 32, '43.150287,26.160743', 'https://thingspeak.com/channels/38265', 'Temperature and humidity in Antonovo', 0),
('79695', 33, '0.0,0.0', 'https://thingspeak.com/channels/79695', 'Benjamin environment', 0),
('16157', 34, '-1.436588,35.19449', 'https://thingspeak.com/channels/16157', 'Talek River @ Fig Tree', 0),
('113125', 35, '0.0,0.0', 'https://thingspeak.com/channels/113125', 'Wi-Fi logger powered by Solar Panels & Ionistor', 0),
('20466', 36, '50.6255,13.6946', 'https://thingspeak.com/channels/20466', 'Kotelna', 0),
('211716', 37, '47.1544081,9.8241137', 'https://thingspeak.com/channels/211716', 'Bludenz Temp. 1', 0),
('211718', 38, '0.0,0.0', 'https://thingspeak.com/channels/211718', 'Hotspot 1 SZ', 0),
('112288', 39, '49.3943333,15.7324', 'https://thingspeak.com/channels/112288', 'Cottage network monitoring', 0),
('184944', 40, '35.9257015,127.0786352', 'https://thingspeak.com/channels/184944', 'Traffic status', 0),
('432212', 41, '48.1897,17.2557', 'https://thingspeak.com/channels/432212', 'ESP8266-12 Weather Station', 0),
('88282', 42, '52.074404,1.131861', 'https://thingspeak.com/channels/88282', 'Bird Box', 0),
('168212', 43, '14.07757,100.61293', 'https://thingspeak.com/channels/168212', ' Solar ESP-01 BME280', 0),
('261716', 44, '50.877071,9.691197', 'https://thingspeak.com/channels/261716', 'af104-fsk', 0),
('387449', 45, '15.885418,108.324238', 'https://thingspeak.com/channels/387449', 'CEPC SOLAR  TRACKER SYSTEM', 0);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `sver`
--
ALTER TABLE `sver`
  ADD PRIMARY KEY (`uid`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `sver`
--
ALTER TABLE `sver`
  MODIFY `uid` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
