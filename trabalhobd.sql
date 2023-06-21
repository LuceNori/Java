-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 27-Maio-2023 às 20:42
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
-- Estrutura da tabela `tremcarga`
--

DROP TABLE IF EXISTS `tremcarga`;
CREATE TABLE IF NOT EXISTS `tremcarga` (
  `id_trem_carga` int NOT NULL AUTO_INCREMENT,
  `tipo_carga` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_trem_carga`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `tremcarga`
--

INSERT INTO `tremcarga` (`id_trem_carga`, `tipo_carga`) VALUES
(1, 'materia');

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
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `tremvagao`
--

INSERT INTO `tremvagao` (`id_vagao`, `id_trem_carga`, `tipo_vagao`, `peso_vagao`) VALUES
(1, 1, 'madeira', 10);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
