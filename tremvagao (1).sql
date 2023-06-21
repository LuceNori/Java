-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 21-Jun-2023 às 19:15
-- Versão do servidor: 8.0.31
-- versão do PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `trabalhobd`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tremvagao`
--

DROP TABLE IF EXISTS `tremvagao`;
CREATE TABLE IF NOT EXISTS `tremvagao` (
  `id_vagao` int NOT NULL AUTO_INCREMENT,
  `id_trem_carga` int DEFAULT NULL,
  `tipo_vagao` varchar(50) DEFAULT NULL,
  `peso_vagao` double DEFAULT NULL,
  PRIMARY KEY (`id_vagao`),
  KEY `id_trem_carga` (`id_trem_carga`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `tremvagao`
--

INSERT INTO `tremvagao` (`id_vagao`, `id_trem_carga`, `tipo_vagao`, `peso_vagao`) VALUES
(8, 8, 'Pessoas classe alta ', 1000),
(9, 8, 'pessoas classe media', 1000),
(10, 9, 'madeira', 10),
(11, 16, 'Tipo do Vagão 1', 0),
(12, 18, 'Tipo do Vagão 1', 0),
(13, 18, 'Tipo do Vagão 2', 0),
(14, 20, 'Tipo do Vagão 1', 0),
(15, 22, 'Tipo do Vagão 1', 0),
(16, 22, 'Tipo do Vagão 2', 0),
(17, 22, 'Tipo do Vagão 3', 0),
(18, 22, 'Tipo do Vagão 4', 0),
(19, 23, 'Tipo do Vagão 1', 0),
(20, 24, 'Tipo do Vagão 1', 0);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
